package com.zentech.spring.service;

import java.util.List;

import com.zentech.spring.hb.model.PersonalInformationTrainee;
import com.zentech.spring.hb.model.Trainee;

public interface TraineeService {
	//Trainees
	public void addTrainee(Trainee p);
	public void updateTrainee(Trainee p);
	public List<Trainee> listTrainees();
	public Trainee getTraineeById(int id);
	public void removeTrainee(int id);
	
	
	
	//Register Trainee
	
	//Trainees
		public void addPersonalInfoTrainee(PersonalInformationTrainee p);
		public void updatePersonalInfoTrainee(PersonalInformationTrainee p);
		public List<PersonalInformationTrainee> listPersonalInfoTrainees();
		public PersonalInformationTrainee getPersonalInfoTraineeById(int id);
		public void removePersonalInfoTrainee(int id);
}



