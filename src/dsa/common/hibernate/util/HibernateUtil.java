package dsa.common.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private SessionFactory sessionFactory;
	
//	@Override
	public void setUp() throws Exception {
		//final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				//.configure("hibernateSupport/hibernate.cfg.xml")
				//.build();
		try {
			//sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			sessionFactory = new Configuration().configure("hibernateSupport/hibernate.cfg.xml").buildSessionFactory();
		}
		catch (Exception e) {
			//StandardServiceRegistryBuilder.destroy( registry );
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
//	@Override
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
