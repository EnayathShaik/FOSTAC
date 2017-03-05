package com.zentech.junit;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.impl.AdminDAOImpl;
import com.ir.form.TraineeUserManagementForm;
import com.ir.model.PersonalInformationTrainee;
import com.ir.service.AdminService;

public class UserManagement {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("adminService")
	AdminService adminService;
	
	
	@Test
	public void getTrainee(){
		try{
			System.out.println("sfdsfdsfsd");
			TraineeUserManagementForm traineeUserManagementForm = new TraineeUserManagementForm();
			List<PersonalInformationTrainee> informationTrainers = new AdminDAOImpl().traineeUserManagementSearch(traineeUserManagementForm);
			System.out.println(informationTrainers.size());
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
