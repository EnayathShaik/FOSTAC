package com.ir.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory sessionFactory = null;
	static {
	    try {
	        sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
	    } catch (Throwable ex) {
	        System.err.println("Initial SessionFactory creation failed." + ex);
	        throw new ExceptionInInitializerError(ex);
	    }
	}
	public static SessionFactory getSessionFactory(){
	return sessionFactory;
	}
}
