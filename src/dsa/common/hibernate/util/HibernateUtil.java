package dsa.common.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private SessionFactory sessionFactory;
	
	public void setUp(String username, String password){

		try {
			Configuration configuration = new Configuration().configure("hibernateSupport/hibernate.cfg.xml");
			configuration.setProperty("hibernate.connection.username",username);
			configuration.setProperty("hibernate.connection.password",password);
			sessionFactory = configuration.buildSessionFactory();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
