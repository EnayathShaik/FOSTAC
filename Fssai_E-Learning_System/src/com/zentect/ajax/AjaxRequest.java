package com.zentect.ajax;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ir.util.HibernateUtil;

public class AjaxRequest {
	public List returnList(String sqlQuery){
		List list = null;
		/*Configuration conf = new Configuration();
		conf.configure("/hibernate.cfg.xml");
		SessionFactory sf = conf.buildSessionFactory();*/
		SessionFactory sf = new HibernateUtil().getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = null;
		try {       
	        transaction = session.beginTransaction();
	        System.out.println("sqlQuery "+sqlQuery);
			Query query = session.createSQLQuery(sqlQuery);
			list = query.list();
			 session.flush();
		     session.clear();
	        transaction.commit();
	    }
	    catch(Exception re){
	    
	        transaction.rollback();
	    	re.printStackTrace();
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
