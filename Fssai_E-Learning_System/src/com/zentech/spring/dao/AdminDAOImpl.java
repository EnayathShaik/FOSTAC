package com.zentech.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.zentech.spring.form.assessmentQuestionsForm;
import com.zentech.spring.form.manageTrainingCalendarForm;
import com.zentech.spring.form.verifyTraineeEnrollmentForm;
import com.zentech.spring.hb.model.City;
import com.zentech.spring.hb.model.District;
import com.zentech.spring.hb.model.FeedbackMaster;
import com.zentech.spring.hb.model.ManageCourseCarricullum;
import com.zentech.spring.hb.model.ManageTraining;
import com.zentech.spring.hb.model.Region;
import com.zentech.spring.hb.model.NState;

@Repository
public class AdminDAOImpl implements AdminDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	
	//******************* left menu
	
	@Override
	public void addManageCourseCarricullum(ManageCourseCarricullum p) {
		// TODO Auto-generated method stub
		System.out.println("getTrainingName "+p.getTrainingName());
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

		logger.info("ManageCourseCarricullum saved successfully, ManageCourseCarricullum Details=" + p);
	}

	@Override
	public void updateManageCourseCarricullum(ManageCourseCarricullum p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("ManageCourseCarricullum updated successfully, ManageCourseCarricullum Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageCourseCarricullum> listManageCourseCarricullum() {
		// TODO Auto-generated method stub
		System.out.println("inside manageCourseCarrilcullum");
		Session session = this.sessionFactory.getCurrentSession();
		List<ManageCourseCarricullum> mccList = session.createQuery("from ManageCourseCarricullum").list();
		for (ManageCourseCarricullum p : mccList) {
			logger.info("ManageCourseCarricullum List::" + p);
		}
		return mccList;
	}

	@Override
	public ManageCourseCarricullum getManageCourseCarricullumById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ManageCourseCarricullum p = (ManageCourseCarricullum) session.load(ManageCourseCarricullum.class, new Integer(id));
		logger.info("ManageCourseCarricullum loaded successfully, ManageCourseCarricullum details=" + p);
		return p;
	}

	@Override
	public void removeManageCourseCarricullum(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ManageCourseCarricullum p = (ManageCourseCarricullum) session.load(ManageCourseCarricullum.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("ManageCourseCarricullum deleted successfully, ManageCourseCarricullum details=" + p);
	}
	
	
	// Manage Training
	
	
	@Override
	public void addManageTraining(ManageTraining p) {
		// TODO Auto-generated method stub
		System.out.println("getTrainingName "+p.getTrainingName());
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

		logger.info("ManageTraining saved successfully, ManageTraining Details=" + p);
	}

	@Override
	public void updateManageTraining(ManageTraining p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("ManageTraining updated successfully, ManageTraining Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageTraining> listManageTraining() {
		// TODO Auto-generated method stub
		System.out.println("inside manageCourseCarrilcullum");
		Session session = this.sessionFactory.getCurrentSession();
		List<ManageTraining> mccList = session.createQuery("from ManageTraining").list();
		for (ManageTraining p : mccList) {
			logger.info("ManageTraining List::" + p);
		}
		return mccList;
	}

	@Override
	public ManageTraining getManageTrainingById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ManageTraining p = (ManageTraining) session.load(ManageTraining.class, new Integer(id));
		logger.info("ManageTraining loaded successfully, ManageTraining details=" + p);
		return p;
	}

	@Override
	public void removeManageTraining(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		ManageTraining p = (ManageTraining) session.load(ManageTraining.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("ManageTraining deleted successfully, ManageTraining details=" + p);
	}
	
// Feedback Master
	
	

	@Override
	public void addFeedbackMaster(FeedbackMaster p) {
		// TODO Auto-generated method stub
		System.out.println("feedback "+p.getFeedback());
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);

		logger.info("FeedbackMaster saved successfully, FeedbackMaster Details=" + p);
	}

	@Override
	public void updateFeedbackMaster(FeedbackMaster p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("FeedbackMaster updated successfully, FeedbackMaster Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedbackMaster> listFeedbackMaster() {
		// TODO Auto-generated method stub
		System.out.println("inside manageCourseCarrilcullum");
		Session session = this.sessionFactory.getCurrentSession();
		List<FeedbackMaster> mccList = session.createQuery("from FeedbackMaster").list();
		for (FeedbackMaster p : mccList) {
			logger.info("FeedbackMaster List::" + p);
		}
		return mccList;
	}

	@Override
	public FeedbackMaster getFeedbackMasterById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		FeedbackMaster p = (FeedbackMaster) session.load(FeedbackMaster.class, new Integer(id));
		logger.info("FeedbackMaster loaded successfully, FeedbackMaster details=" + p);
		return p;
	}

	@Override
	public void removeFeedbackMaster(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		FeedbackMaster p = (FeedbackMaster) session.load(FeedbackMaster.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("FeedbackMaster deleted successfully, FeedbackMaster details=" + p);
	}
	
	
	@Override
	public List<assessmentQuestionsForm> listAssessmentQuestion(assessmentQuestionsForm form) {
		// TODO Auto-generated method stub
		System.out.println("inside assessmentQuestionsForm");
		String assesmentType = form.getAssesmentType();
		String trainingName = form.getTrainingName();
		assessmentQuestionsForm bean = new assessmentQuestionsForm();
		List<assessmentQuestionsForm> resulList = new ArrayList<assessmentQuestionsForm>();
		System.out.println("assesmentType "+assesmentType + " trainingName "+trainingName);
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> list = session.createSQLQuery("select cast('Training' as varchar(20)) as assesmentType , cast('SCCC' as varchar(20)) as trainingName").list();
		for (Object[] li : list ) {
			
			bean.setAssesmentType((String) li[0]);
			bean.setTrainingName((String) li[1]);
			logger.info("ManageTraining List::" + li);
			resulList.add(bean);
		}
		return resulList;
	}
	
	
	
	
	@Override
	public List<verifyTraineeEnrollmentForm> listVerifyTraineeEnrollment(verifyTraineeEnrollmentForm form) {
		// TODO Auto-generated method stub
		System.out.println("inside assessmentQuestionsForm");
		String courseName = form.getCourseName();
		String traineeName = form.getTraineeName();
		verifyTraineeEnrollmentForm bean = new verifyTraineeEnrollmentForm();
		List<verifyTraineeEnrollmentForm> resulList = new ArrayList<verifyTraineeEnrollmentForm>();
		System.out.println("assesmentType "+courseName + " trainingName "+traineeName);
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> list = session.createSQLQuery("select cast('Java' as varchar(20)) as CourseName , cast('2016-12-16 12:00' as varchar(20)) as TrainingDate , cast('Mahape' as varchar(20) ) as TrainingLab , cast('jyoti' as varchar(20)) as tarineeName  ").list();
		for (Object[] li : list ) {
			
			bean.setCourseName((String) li[0]);
			bean.setTrainingDate((String) li[1]);
			bean.setTrainingLab((String) li[2]);
			bean.setTraineeName((String) li[3]);
			logger.info("listVerifyTraineeEnrollment List::" + li);
			resulList.add(bean);
		}
		return resulList;
	}
	
	
	
	
	@Override
	public List<manageTrainingCalendarForm> listmanageTrainingCalendar(manageTrainingCalendarForm form) {
		// TODO Auto-generated method stub
		System.out.println("inside manageTrainingCalendarForm");
		String courseName = form.getCourseName();
		String traineeName = form.getTrainingDate();
				manageTrainingCalendarForm bean = new manageTrainingCalendarForm();
		List<manageTrainingCalendarForm> resulList = new ArrayList<manageTrainingCalendarForm>();
		System.out.println("courseName "+courseName + " traineeName "+traineeName);
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> list = session.createSQLQuery("select cast('Java' as varchar(20)) as CourseName , cast('2016-12-16 12:00' as varchar(20)) as TrainingDate , cast('Mahape' as varchar(20) ) as TrainingLab , cast('jyoti' as varchar(20)) as tarineeName  ").list();
		for (Object[] li : list ) {
			
			bean.setCourseName((String) li[0]);
			bean.setTrainingDate((String) li[1]);
			bean.setTrainingLab((String) li[2]);

			logger.info("listVerifyTraineeEnrollment List::" + li);
			resulList.add(bean);
		}
		return resulList;
	}

}
