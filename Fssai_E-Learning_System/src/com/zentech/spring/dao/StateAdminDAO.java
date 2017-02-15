package com.zentech.spring.dao;

import java.util.List;

import com.zentech.spring.hb.model.PersonalInformationStateAdmin;


public interface StateAdminDAO {

			
			//register StateAdmin
			
			public void addPersonalInfoStateAdmin(PersonalInformationStateAdmin p);
			public void updatePersonalInfoStateAdmin(PersonalInformationStateAdmin p);
			public List<PersonalInformationStateAdmin> listPersonalInfoStateAdmins();
			public PersonalInformationStateAdmin getPersonalInfoStateAdminById(int id);
			public void removePersonalInfoStateAdmin(int id);
}
