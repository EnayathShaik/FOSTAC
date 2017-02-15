package com.zentech.spring.dao;

import java.util.List;

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

public interface AdminDAO {
	
	
	//Manage course carricullum
	public void addManageCourseCarricullum(ManageCourseCarricullum p);
	public void updateManageCourseCarricullum(ManageCourseCarricullum p);
	public List<ManageCourseCarricullum> listManageCourseCarricullum();
	public ManageCourseCarricullum getManageCourseCarricullumById(int id);
	public void removeManageCourseCarricullum(int id);
	
	// Manage Training
	
	public void addManageTraining(ManageTraining p);
	public void updateManageTraining(ManageTraining p);
	public List<ManageTraining> listManageTraining();
	public ManageTraining getManageTrainingById(int id);
	public void removeManageTraining(int id);
	
	
	// Feedback Master
	
	

	public void addFeedbackMaster(FeedbackMaster p);
	public void updateFeedbackMaster(FeedbackMaster p);
	public List<FeedbackMaster> listFeedbackMaster();
	public FeedbackMaster getFeedbackMasterById(int id);
	public void removeFeedbackMaster(int id);
	
	
	//manage Assesment
	
	public List<assessmentQuestionsForm> listAssessmentQuestion(assessmentQuestionsForm p);
	public List<verifyTraineeEnrollmentForm> listVerifyTraineeEnrollment(verifyTraineeEnrollmentForm p);
	public List<manageTrainingCalendarForm> listmanageTrainingCalendar(manageTrainingCalendarForm p);

}
