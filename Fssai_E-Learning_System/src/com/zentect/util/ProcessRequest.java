package com.zentect.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class ProcessRequest {
	public List returnList(SessionFactory sessionFactory,String sqlQuery){
		List list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {       
	        transaction = session.beginTransaction();
	        System.out.println("sqlQuery "+sqlQuery);
			Query query = session.createSQLQuery(sqlQuery);
			list = query.list();
	        transaction.commit();
	    }
	    catch(Exception re){
	        transaction.rollback();
	    }
	    finally {
	        if(session != null){
	            Transaction tran = session.getTransaction();
	            if(tran != null && tran.isActive() && !tran.wasCommitted() && tran.wasRolledBack()){
	                tran.rollback();
	            }
	            session.close();
	        }
	    }
		return list;
		
	}

}
