package dsa.common.manage;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import dsa.common.hibernate.util.HibernateUtil;

public class DbManager {
	private static DbManager currentDbManager;
	private HibernateUtil hibernate;
	private SessionFactory sessionFactory;
	private Session session;
	public DbManager() {
		init();
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
		session.flush();
		t.commit();
		closeSession();
	}
	
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
			if(hibernate == null)
				init();
			else
				sessionFactory = hibernate.getSessionFactory();
					
		return sessionFactory.openSession();
	}
	private void closeSession(){
		if (session != null && session.isOpen())
			session.close();
	}
	
	public void init(){
		if(hibernate != null){
			try {
				hibernate.setUp();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}else{
			hibernate = new HibernateUtil();
				
			try {
				hibernate.setUp();
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
		if(currentDbManager == null)
			new DbManager();
		return currentDbManager;
	}

	private static void setCurrentDbManager(DbManager currentDbManager) {
		DbManager.currentDbManager = currentDbManager;
	}
}
