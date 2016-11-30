package com.ir.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.ir.dao.RegistrationAssessorDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactFormAssessor;
import com.ir.form.ContactTrainee;
import com.ir.form.RegistrationFormAssessor;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.AssessmentAgency;
import com.ir.model.CourseEnrolled;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.RegistrationServiceAssessor;



@Component("registrationServiceTrainer")
public class RegistrationServiceAssessorImpl implements RegistrationServiceAssessor{
	
	@Autowired
	@Qualifier("registrationAssessorDAO")
	RegistrationAssessorDAO registrationAssessorDAO; 


	@Override
	public List<State> loadState() {
		List<State> listState = registrationAssessorDAO.loadState();
		return listState;
	}

	@Override
	public List<Title> loadTitle() {
		List<Title> titleList = registrationAssessorDAO.loadTitle();
		return titleList;
	}

	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
				List<CourseName> basicCourseName= registrationAssessorDAO.basicCourseName();
				return basicCourseName;
	}

	@Override
	public String registerPersonalInformationAssessor(RegistrationFormAssessor registrationFormAssessor ) {
		/*String basicCourse2 =registrationFormAssessor.getBasicCourse1();
		String [] basicCourse3 = basicCourse2.split(",");
		String advanceCourse2 =registrationFormAssessor.getAdvanceCourse1();
		String [] advanceCourse3 = advanceCourse2.split(",");
		String specialCourse2 =registrationFormAssessor.getSpecialCourse1();
		String [] specialCourse3 = specialCourse2.split(",");
		
		Set ceS = new HashSet<>();
		List ceLB = new ArrayList<>();
		for(int i = 0 ; i < basicCourse3.length ; i++ ){
			ceLB.add(basicCourse3[i]);
		}
		ceS.add(ceLB);
		
		List ceLA = new ArrayList<>();
		for(int i = 0 ; i < advanceCourse3.length ; i++ ){
			ceLA.add(advanceCourse3[i]);
		}
		ceS.add(ceLA);
		
		List ceLS = new ArrayList<>();
		for(int i = 0 ; i < specialCourse3.length ; i++ ){
			ceLS.add(specialCourse3[i]);
		}
		ceS.add(ceLS);*/
		
		
		
		String personalInformationassessor = registrationAssessorDAO.register(registrationFormAssessor );
		return personalInformationassessor;
	}

	@Override
	public List<ManageAssessmentAgency> loadAssessmentAgency() {
		List<ManageAssessmentAgency> loadAssessmentAgency = registrationAssessorDAO.loadAssessmentAgency();
		return loadAssessmentAgency;
	}

	@Override
	public String UpdateAssessor(RegistrationFormAssessor registrationFormAssessor, int loginId) {
		String personalInformationassessor = registrationAssessorDAO.updateAssessor(registrationFormAssessor,loginId);
		return personalInformationassessor;
	}

	/*@Override
	public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	
	
	// Rishi
	@Override
	public String contactAssesorSave(ContactTrainee contactTrainee, String id) {
		String contactFormAssessor1 = registrationAssessorDAO.cotactAssessorSave(contactTrainee,id);
		return contactFormAssessor1;
	}

	@Override
	public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean changePasswordASSSave(ChangePasswordForm changePasswordForm, String id) {
		boolean changePassword = registrationAssessorDAO.cotactAssessorSave(changePasswordForm,id);
		return changePassword;
	}


	/*@Override
	public String contactAssesorSave(ContactFormAssessor contactFormAssessor, int id) {
		String contactFormAssessor1 = registrationAssessorDAO.cotactAssessorSave(contactFormAssessor,id);
		return contactFormAssessor1;
	}*/
	
}
