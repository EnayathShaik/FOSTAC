package com.zentech.spring.service;

import java.util.List;

import com.zentech.spring.hb.model.PersonalInformationStateAdmin;


public interface StateAdminService {

	
	//Register StateAdmin
	
	//StateAdmins
		public void addPersonalInfoStateAdmin(PersonalInformationStateAdmin p);
		public void updatePersonalInfoStateAdmin(PersonalInformationStateAdmin p);
		public List<PersonalInformationStateAdmin> listPersonalInfoStateAdmins();
		public PersonalInformationStateAdmin getPersonalInfoStateAdminById(int id);
		public void removePersonalInfoStateAdmin(int id);
}



