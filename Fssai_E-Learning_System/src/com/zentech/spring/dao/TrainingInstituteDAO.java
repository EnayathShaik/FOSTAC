package com.zentech.spring.dao;

import java.util.List;

import com.zentech.spring.hb.model.PersonalInformationTrainingInstitute;


public interface TrainingInstituteDAO {

			//register TrainingInstitute
			
			public void addPersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute p);
			public void updatePersonalInfoTrainingInstitute(PersonalInformationTrainingInstitute p);
			public List<PersonalInformationTrainingInstitute> listPersonalInfoTrainingInstitutes();
			public PersonalInformationTrainingInstitute getPersonalInfoTrainingInstituteById(int id);
			public void removePersonalInfoTrainingInstitute(int id);
}
