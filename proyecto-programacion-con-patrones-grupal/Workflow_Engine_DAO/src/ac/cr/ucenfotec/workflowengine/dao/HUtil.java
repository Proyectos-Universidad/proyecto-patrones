package ac.cr.ucenfotec.workflowengine.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HUtil {

	private static SessionFactory sessionFactory;
	
	private HUtil() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null || sessionFactory.isClosed()) {
			Logger log = Logger.getLogger("org.hibernate"); 
			log.setLevel(Level.OFF);
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
}
