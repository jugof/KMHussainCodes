package example.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory getSessionFactory() {
		Configuration hibernateConfig = 
				new Configuration();
		hibernateConfig = hibernateConfig.configure();
		
		SessionFactory hibernateFactory = 
		hibernateConfig.buildSessionFactory();
		return hibernateFactory;
		
	}
}
