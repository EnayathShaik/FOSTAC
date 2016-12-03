package com.ir.dao.impl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ir.dao.AssessmentDao;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;
import com.ir.model.ManageAssessmentAgency;
@Repository("AssessmentDao")
public class AssessmentDaoImpl implements AssessmentDao{

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName) {
		System.out.println("AssessmentQuestions");
//		Criteria criteria = session.createCriteria(AssessmentQuestion.class);
//		criteria.add(Restrictions.eq("courseName", courseName));
//		criteria.add(Restrictions.eq("courseType", courseType));
//		List <AssessmentQuestion> listAssessmentQuestions = criteria.list();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseName +" and courseType= "+courseType);
		List<AssessmentQuestion> assessmentQuestions = query.list();
		session.close();
		return assessmentQuestions;
	}

	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias){
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction(); 
		try{
		for(int i= 0; i<answerCriterias.size(); i++){
			session.save(answerCriterias.get(i));
		}
		transaction.commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		
		return "Success";
	}
	
	@Override
	public List<CourseType> courseTypes() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		session.close();
		return courseTypeList;
	}
	

}
