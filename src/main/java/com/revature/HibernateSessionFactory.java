package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class HibernateSessionFactory {
	private static Session session = null;
	private static SessionFactory factory = null;
	
	private HibernateSessionFactory() {};
	
	public static SessionFactory getFactory () {
		if (factory == null) {
			Configuration cfg = new Configuration();

			// read the configuration and load in the object
			cfg.configure("hibernate.cfg.xml");

			// create factory
			System.out.println("Building factory");
			factory = cfg.buildSessionFactory();
			System.out.println(factory);

			// open the session
			//session = factory.openSession();
		}

		return factory;
	}
}
