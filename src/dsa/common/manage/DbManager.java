package dsa.common.manage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import dsa.common.data.Eigenschaft;
import dsa.common.data.Talent;
import dsa.common.data.mappings.Probe;
import dsa.common.data.wrapper.NameIdWrapper;
import dsa.common.hibernate.util.HibernateUtil;

public class DbManager {
	private static DbManager currentDbManager;
	private HibernateUtil hibernate;
	private SessionFactory sessionFactory;
	private Session session;
	public DbManager(String username, String password) {
		init(username, password);
	}
	/* Data Retrieval Methods*/
	
	@SuppressWarnings("unchecked")
	public<T> List<T> getAllOfClass(Class<T> t){
		session = getSession();
		Criteria criteria = session.createCriteria(t);
		List<T> retval = criteria.list();
		closeSession();
		return retval;
	}

	public <T> T getOneOfClassByID(Class<T> t, Integer id){
		session = getSession();
		session.get(t, id);
		T retval = session.get(t, id);
		closeSession();
		return retval;
	}
	
	public <T> Long  getRowCountOfClass(Class<T> t) {
		session = getSession();
		Long retval = (Long) session.createCriteria(t).setProjection(Projections.rowCount()).uniqueResult();
		closeSession();
		return retval;
	}

	public <T> void updateObject(T object) {
		session = getSession();
		Transaction t = session.beginTransaction();
		session.update(object);
		//session.merge(object);
		session.flush();
		t.commit();
		closeSession();
	}
	
	public <T> void mergeObject(T object) {
		session = getSession();
		Transaction t = session.beginTransaction();
		session.merge(object);
		session.flush();
		t.commit();
		closeSession();
	}
	
//	public <T> void updateObject(T object,Serializable id) {
//		session = getSession();
//		T entity = (T)session.load(object.getClass(),id);
//		BeanUtile.copyProperties(entity,object);
//		closeSession();
//	}
	
	public <T> void createNewObject(T object) {
		session = getSession();
		Transaction t = session.beginTransaction();
		session.save(object);
		session.flush();
		t.commit();
		closeSession();
	}
	

	public <T> void deleteObject(T object) {
		session = getSession();
		Transaction t = session.beginTransaction();
		session.delete(object);
		session.flush();
		t.commit();
		closeSession();
	}
	
	
	/* Utility Methods*/
	private Session getSession(){
		if (sessionFactory == null)
			sessionFactory = hibernate.getSessionFactory();
					
		return sessionFactory.openSession();
	}
	private void closeSession(){
		if (session != null && session.isOpen())
			session.close();
	}
	
	public void init(String username, String password){
		if(hibernate != null){
			try {
				hibernate.setUp(username,password);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}else{
			hibernate = new HibernateUtil();
				
			try {
				hibernate.setUp(username,password);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		if(sessionFactory != null){
			sessionFactory.close();
		}
		sessionFactory = hibernate.getSessionFactory();
		setCurrentDbManager(this);
	}
	
	public void destroy(){
		if(session.isOpen())
			session.close();
		try {
			hibernate.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static DbManager getCurrentDbManager() {
		return currentDbManager;
	}
	
	public static DbManager getNewDbManager(String username, String password) {
		if(currentDbManager == null)
			new DbManager(username,password);
		return currentDbManager;
	}

	private static void setCurrentDbManager(DbManager currentDbManager) {
		DbManager.currentDbManager = currentDbManager;
	}

	public <T> List<NameIdWrapper> getNameIdWrapperByClass(Class<T> t) {
		List<NameIdWrapper> retval = new ArrayList<NameIdWrapper>();
		if(t.equals(Eigenschaft.class)){
			Iterator<Eigenschaft> iter = getAllOfClass(Eigenschaft.class).iterator();
			Eigenschaft curE;
			while(iter.hasNext()){
				curE = iter.next();
				retval.add(new NameIdWrapper(curE.getId(),curE.getKuerzel()));
			}
		}
		return retval;
	}

	public Set<Probe> getProbenOfTalent(Talent talent) {
		session = getSession();
		session.beginTransaction();
		session.refresh(talent);
		Hibernate.initialize(talent.getProben());
		Set<Probe> retval = talent.getProben();
		closeSession();
		return retval;
	}

	public <T> T loadInstanceById(T obj, Serializable id) {
		session = getSession();
		session.load(obj, id);
		closeSession();
		return obj;
	}

	public void updateTalent(Talent talent) {
		session = getSession();
		Transaction t = session.beginTransaction();
		Talent tal = session.get(Talent.class, talent.getId());
		tal.setProben(talent.getProben());
		session.save(tal);
		t.commit();
		closeSession();
	}

	public void unlazyTalente(List<Talent> data) {
		session = getSession();
		session.beginTransaction();
		for(Talent t : data){
			session.refresh(t);
			Hibernate.initialize(t.getProben());
		}
		closeSession();
	}
}
