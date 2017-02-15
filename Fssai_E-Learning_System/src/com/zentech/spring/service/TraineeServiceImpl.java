package com.zentech.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import com.zentech.spring.dao.TraineeDAO;
import com.zentech.spring.dao.UserDAO;
import com.zentech.spring.hb.model.PersonalInformationTrainee;
import com.zentech.spring.hb.model.Trainee;

public class TraineeServiceImpl implements TraineeService {
	private TraineeDAO traineeDAO;
	
	
	
	public void setTraineeDAO(TraineeDAO traineeDAO) {
		this.traineeDAO = traineeDAO;
	}

	@Override
	@Transactional
	public void addTrainee(Trainee p) {
		// TODO Auto-generated method stub
		this.traineeDAO.addTrainee(p);
	}

	@Override
	@Transactional
	public void updateTrainee(Trainee p) {
		// TODO Auto-generated method stub
		this.traineeDAO.updateTrainee(p);
	}

	@Override
	@Transactional
	public List<Trainee> listTrainees() {
		// TODO Auto-generated method stub
		return this.traineeDAO.listTrainees();
	}

	@Override
	@Transactional
	public Trainee getTraineeById(int id) {
		// TODO Auto-generated method stub
		return this.traineeDAO.getTraineeById(id);
	}

	@Override
	@Transactional
	public void removeTrainee(int id) {
		// TODO Auto-generated method stub
		this.traineeDAO.removeTrainee(id);
	}
	
	
	
	
	//*************************** Register Trainee *****************************************************
	
	@Override
	@Transactional
	public void addPersonalInfoTrainee(PersonalInformationTrainee p) {
		// TODO Auto-generated method stub
		this.traineeDAO.addPersonalInfoTrainee(p);
	}

	@Override
	@Transactional
	public void updatePersonalInfoTrainee(PersonalInformationTrainee p) {
		// TODO Auto-generated method stub
		this.traineeDAO.updatePersonalInfoTrainee(p);
	}

	@Override
	@Transactional
	public List<PersonalInformationTrainee> listPersonalInfoTrainees() {
		// TODO Auto-generated method stub
		return this.traineeDAO.listPersonalInfoTrainees();
	}

	@Override
	@Transactional
	public PersonalInformationTrainee getPersonalInfoTraineeById(int id) {
		// TODO Auto-generated method stub
		return this.traineeDAO.getPersonalInfoTraineeById(id);
	}

	@Override
	@Transactional
	public void removePersonalInfoTrainee(int id) {
		// TODO Auto-generated method stub
		this.traineeDAO.removePersonalInfoTrainee(id);
	}
	

}
