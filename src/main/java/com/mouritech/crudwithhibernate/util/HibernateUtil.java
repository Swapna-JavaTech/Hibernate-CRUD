package com.mouritech.crudwithhibernate.util;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class HibernateUtil {
	
	private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory ==  null) {
			try {
				//create registry
				registry = new StandardServiceRegistryBuilder().configure().build();
				//create Metadata Sources
				MetadataSources sources = new MetadataSources(registry) ;
				//create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();
				//create SessionFactory		
				sessionFactory = metadata.getSessionFactoryBuilder().build();
						
				
			}catch (Exception e) {
				e.printStackTrace();
				if(registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}
	

}
