package com.ir.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.AdminDAO;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.service.TrainingPartnerService;

@Service
public class TrainingPartnerServiceImpl implements TrainingPartnerService  {

	@Autowired
	@Qualifier("trainingPartnerDAO")
	TrainingPartnerDao trainingPartnerDAO; 

	@Override
	public List<PersonalInformationTrainingPartner> trainingCenterList() {
		List<PersonalInformationTrainingPartner> trainingCenterList = trainingPartnerDAO.trainingCenterList();
		return trainingCenterList;
	}

	@Override
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = trainingPartnerDAO.courseTypeList();
		return courseTypeList;
	}

	@Override
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		String postVacancyTrainingPartner = trainingPartnerDAO.postVacancyTrainingPartner(postVacancyTrainingCenterForm);
		return postVacancyTrainingPartner;
	}

	@Override
	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePasswordTraineeSave = trainingPartnerDAO.changePasswordTrainingPartnerSave(changePasswordForm , id);
		return changePasswordTraineeSave;
	}


	
	 
}
