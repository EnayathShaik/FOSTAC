package com.set.fostac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ir.model.assessor.EnrolledAssessments;

public class FOSTAC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
 
		EnrolledAssessments enrolledAssessments = new EnrolledAssessments();
 
		enrolledAssessments.setAssessmentsenrolledid(710);
		enrolledAssessments.setTrainingcalendarid(171);
		enrolledAssessments.setStatus("A");
 
	       Transaction tx=session.beginTransaction();
	          session.save(enrolledAssessments);
	          System.out.println("Object Loaded successfully.....!!");
	       tx.commit();     
 
		session.close();
		factory.close();
	}

}
