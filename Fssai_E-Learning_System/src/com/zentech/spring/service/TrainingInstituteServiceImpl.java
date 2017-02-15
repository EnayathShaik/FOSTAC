package com.zentech.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.zentech.spring.dao.TrainingInstituteDAO;
import com.zentech.spring.hb.model.PersonalInformationTrainingInstitute;


public class TrainingInstituteServiceImpl implements TrainingInstituteService {
	private TrainingInstituteDAO trainingInstituteDAO;
	
	
	
	public void setTrainingInstituteDAO(TrainingInstituteDAO trainingInstituteDAO) {
		this.trainingInstituteDAO = trainingInstituteDAO;
	}

	
	
	
	//*************************** Register TrainingInstitute *****************************************************
	
	@Override
	@Transactional
	public void addPersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute p) {
		// TODO Auto-generated method stub
		this.trainingInstituteDAO.addPersonalInfoTrainingInstitute(p);
	}

	@Override
	@Transactional
	public void updatePersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute p) {
		// TODO Auto-generated method stub
		this.trainingInstituteDAO.updatePersonalInfoTrainingInstitute(p);
	}

	@Override
	@Transactional
	public List<PersonalInformationTrainingInstitute> listPersonalInfoTrainingInstitutes() {
		// TODO Auto-generated method stub
		return this.trainingInstituteDAO.listPersonalInfoTrainingInstitutes();
	}

	@Override
	@Transactional
	public PersonalInformationTrainingInstitute getPersonalInfoTrainingInstituteById(int id) {
		// TODO Auto-generated method stub
		return this.trainingInstituteDAO.getPersonalInfoTrainingInstituteById(id);
	}

	@Override
	@Transactional
	public void removePersonalInfoTrainingInstitute(int id) {
		// TODO Auto-generated method stub
		this.trainingInstituteDAO.removePersonalInfoTrainingInstitute(id);
	}
	

}
