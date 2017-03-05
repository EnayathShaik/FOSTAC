package com.ir.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AssessmentDao;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;
import com.ir.model.trainee.TraineeAssessmentEvaluation;
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
		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseName +" and courseType= "+courseType);
		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseName);
		List<AssessmentQuestion> assessmentQuestions = query.list();
		return assessmentQuestions;
	}

	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias){
		Session session = sessionFactory.getCurrentSession();
		try{
		for(int i= 0; i<answerCriterias.size(); i++){
			session.save(answerCriterias.get(i));
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}
		
		return "Success";
	}
	
	@Override
	public List<CourseType> courseTypes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}
	@Override
	public List<IntStringBean> getTrainingPartners(int assessorId){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> trainingPartnerList = new ArrayList<IntStringBean>();
		String strQuery = "select pit.personalinformationtrainingpartnerid, pit.trainingcentrename "
				+ "from personalinformationassessor pia "
				+ "inner join courseenrolled ce on ce.logindetails = pia.logindetails "
				+ "inner join trainingcalendar tc on tc.coursename = ce.coursenameid "
				+ "inner join coursename cn on cn.coursenameid = tc.coursename "
				+ "inner join personalinformationtrainingpartner pit on pit.personalinformationtrainingpartnerid = tc.trainingcenter "
				+ "where pia.logindetails = "+assessorId + " "
						+ "group by pit.personalinformationtrainingpartnerid, pit.trainingcentrename";
		Query query = session.createSQLQuery(strQuery);
		//List tpList = query.list();
		List<Object[]> tpList =(List<Object[]>) query.list();
		if(tpList != null && tpList.size() >0){
			for(int i =0 ; i<tpList.size(); i++){
				
				IntStringBean tc = new IntStringBean();
				Object[] o =tpList.get(0);
				tc.setId((int)o[0]);
				tc.setValue(o[1].toString());
				trainingPartnerList.add(tc);
			}
		}
		return trainingPartnerList;
	}

	@Override
	public List<AssessmentQuestion> getAssessmentAnswers(int courseType, List<Integer> questions) {
		Session session = sessionFactory.getCurrentSession();
		String questionIds = questions.toString();
		if(questionIds.length() >2){
			questionIds = questionIds.substring(1,questionIds.length()-1);
		}
		Query query = session.createQuery("from AssessmentQuestion where coursename = "+ courseType +" and assessmentquestionid in ("+questionIds+")");
		List<AssessmentQuestion> listAssessmentQuestions = query.list();
		
		return listAssessmentQuestions;
	}
	@Override
	public int saveTraineeAssessmentEvaluation(TraineeAssessmentEvaluation traineeAssessmentEvaluation){
		Session session = sessionFactory.getCurrentSession();
		Integer traineeAssessmentEvaluationId = (Integer) session.save(traineeAssessmentEvaluation);
		return traineeAssessmentEvaluationId;
	}

	@Override
	public int getElegibilityForAssessment(int coursenameid){
		Session session = sessionFactory.getCurrentSession();
		String sql = "select eligibility from assessmenteligibility where coursenameid="+coursenameid;
		Query query = session.createSQLQuery(sql);
		List listEligibility = query.list();
		if(listEligibility.size() > 0)
		{
			return (int)listEligibility.get(0);
		}
		return -1;
	}
	
	
	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}
}
