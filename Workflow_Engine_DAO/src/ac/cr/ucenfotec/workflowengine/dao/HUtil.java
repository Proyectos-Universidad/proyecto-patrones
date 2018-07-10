package ac.cr.ucenfotec.workflowengine.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HUtil {

	private static SessionFactory sessionFactory;
	private static String configFilePath = "hibernate.cfg.xml";
	private HUtil() {
		
	}
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null || sessionFactory.isClosed()) {
			Logger log = Logger.getLogger("org.hibernate"); 
			log.setLevel(Level.OFF);
			sessionFactory = new Configuration().configure(configFilePath).buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
	public static void setConfigFilePath(String configFilePath) {
		//DAO Tests?
		HUtil.configFilePath = configFilePath;
	}
}
