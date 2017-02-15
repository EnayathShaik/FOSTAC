package com.zentech.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zentech.spring.dao.AdminDAO;
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
@Service
public class AdminServiceImpl implements AdminService {

	private AdminDAO adminDAO;
	
	/**
	 * @param adminDAO the adminDAO to set
	 */
	public void setadminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	//************left menu
	//Manage course Carriculum
	
	@Override
	@Transactional
	public void addManageCourseCarricullum(ManageCourseCarricullum p) {
		// TODO Auto-generated method stub
	this.adminDAO.addManageCourseCarricullum(p);
	}

	@Override
	@Transactional
	public void updateManageCourseCarricullum(ManageCourseCarricullum p) {
		// TODO Auto-generated method stub
		this.adminDAO.updateManageCourseCarricullum(p);
	}

	@Override
	@Transactional
	public List<ManageCourseCarricullum> listManageCourseCarricullum() {
		// TODO Auto-generated method stub
		return this.adminDAO.listManageCourseCarricullum();
	}

	@Override
	@Transactional
	public ManageCourseCarricullum getManageCourseCarricullumById(int id) {
		// TODO Auto-generated method stub
		return this.adminDAO.getManageCourseCarricullumById(id);
	}

	@Override
	@Transactional
	public void removeManageCourseCarricullum(int id) {
		// TODO Auto-generated method stub
		this.adminDAO.removeManageCourseCarricullum(id);
	}

	
	// Manage Training
	
	
	
	@Override
	@Transactional
	public void addManageTraining(ManageTraining p) {
		// TODO Auto-generated method stub
	this.adminDAO.addManageTraining(p);
	}

	@Override
	@Transactional
	public void updateManageTraining(ManageTraining p) {
		// TODO Auto-generated method stub
		this.adminDAO.updateManageTraining(p);
	}

	@Override
	@Transactional
	public List<ManageTraining> listManageTraining() {
		// TODO Auto-generated method stub
		return this.adminDAO.listManageTraining();
	}

	@Override
	@Transactional
	public ManageTraining getManageTrainingById(int id) {
		// TODO Auto-generated method stub
		return this.adminDAO.getManageTrainingById(id);
	}

	@Override
	@Transactional
	public void removeManageTraining(int id) {
		// TODO Auto-generated method stub
		this.adminDAO.removeManageTraining(id);
	}
	
	
// Feedback Master
	
	
	
	@Override
	@Transactional
	public void addFeedbackMaster(FeedbackMaster p) {
		// TODO Auto-generated method stub
	this.adminDAO.addFeedbackMaster(p);
	}

	@Override
	@Transactional
	public void updateFeedbackMaster(FeedbackMaster p) {
		// TODO Auto-generated method stub
		this.adminDAO.updateFeedbackMaster(p);
	}

	@Override
	@Transactional
	public List<FeedbackMaster> listFeedbackMaster() {
		// TODO Auto-generated method stub
		return this.adminDAO.listFeedbackMaster();
	}

	@Override
	@Transactional
	public FeedbackMaster getFeedbackMasterById(int id) {
		// TODO Auto-generated method stub
		return this.adminDAO.getFeedbackMasterById(id);
	}

	@Override
	@Transactional
	public void removeFeedbackMaster(int id) {
		// TODO Auto-generated method stub
		this.adminDAO.removeFeedbackMaster(id);
	}
	

	//listAssessmentQuestion
	
	
	@Override
	@Transactional
	public List<assessmentQuestionsForm> listAssessmentQuestion(assessmentQuestionsForm p ) {
		// TODO Auto-generated method stub
		return this.adminDAO.listAssessmentQuestion(p);
	}
	
	@Override
	@Transactional
	public List<verifyTraineeEnrollmentForm> listVerifyTraineeEnrollment(verifyTraineeEnrollmentForm p ) {
		// TODO Auto-generated method stub
		return this.adminDAO.listVerifyTraineeEnrollment(p);
	}
	
	
	@Override
	@Transactional
	public List<manageTrainingCalendarForm> listmanageTrainingCalendar(manageTrainingCalendarForm p ) {
		// TODO Auto-generated method stub
		return this.adminDAO.listmanageTrainingCalendar(p);
	}

}
