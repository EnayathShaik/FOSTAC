package com.ir.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.AssessmentAgencyDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.model.ChangePassword;
import com.ir.model.ContactTraineee;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.SendContectMail;

public class AssessmentAgencyDaoImpl implements AssessmentAgencyDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	// Rishi
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	
	@Override
	public String contactSave(ContactTrainee contactTrainee  , String id) {
		SendContectMail traineeMaail=null;
		 traineeMaail = new SendContectMail();
			
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ContactTraineee contactTrainerModel = new ContactTraineee();
		String email=contactTrainee.getEmailAddress();
		String msg=contactTrainee.getMessageDetails();
		traineeMaail.mailProperty(msg, email,id);
		
		System.out.println("sent mail to........................"+id);
		
		contactTrainerModel.setEmailAddress(email); 
		contactTrainerModel.setMessageDetails(msg);
		contactTrainerModel.setUserId(id);
		Integer contactTrainerModelId = (Integer) session.save(contactTrainerModel);
		System.out.println("contactTraineeSave after save");
		tx.commit();
		session.close();
		if(contactTrainerModelId >0 && contactTrainerModelId != null){
			return "created";
		}else{
			return "error";
		}
		
		
	}

	@Override
	public boolean changePasswordData(ChangePasswordForm changePasswordForm, String id) {
	String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		//String idd=changePasswordForm.getLoginid();
		
		
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		
		
		return confirm;
	}
		// Rishi
}
