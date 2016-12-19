package com.ir.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ir.dao.CommonDao;
import com.ir.form.ChangePasswordForm;
import com.ir.util.ChangePasswordUtility;

@Repository
public class CommonDaoImpl implements CommonDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	@Override
	public String getCourseTrainingType(String courseNameId){
		Session session = sessionFactory.openSession();
		String response = "" ;
		String strQuery = "select case "
				+ "when online = 'Online' and classroom='Nil' THEN 'Online' "
				+ "when online = 'Nil' and classroom='Classroom' THEN 'Classroom' "
				+ "when online ='Online' and classroom = 'Classroom' THEN 'Both' END as modeOfTraining "
				+ "from coursename where coursenameid ="+courseNameId;
		try{
			Query query = session.createSQLQuery(strQuery);
			List list = (List)query.list();
			if(list.size() > 0){
				response = (String)list.get(0);	
			}
		}catch(Exception e){
			System.out.println("Exception while retrieving mode of training for course id - " + courseNameId + ":" + e.getMessage());
			response = "error";
		}finally{
			session.close();
		}
		return response;
	}
	
	@Override
	public boolean changePasswordSave(ChangePasswordForm changePasswordForm, String id) {
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		return confirm;
	}

}