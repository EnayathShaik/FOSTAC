package com.ir.util;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ChangePasswordUtility {
	
	public  boolean changePasswordUtil( String oldPassword, String newPassword, String userId){/*
		boolean passwordCheck=false;
		String oldEcriptedPwd=null;
		String newEncryptPwd=null;
		String Password=null;
		try {
			 oldEcriptedPwd=EncryptionPasswordANDVerification.encryptPass(oldPassword);
			 newEncryptPwd=EncryptionPasswordANDVerification.encryptPass(newPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//int idd=11;
	Session session=sessionFactory.openSession();
	
	Query pwdQuery=session.createQuery("select Encrypted_Password from LoginDetails where loginId='"+userId+"'");
	
	List psdList = pwdQuery.list();
	for(Object LoginPassword :psdList){
		 Password=(String) LoginPassword;
		if(oldEcriptedPwd.equalsIgnoreCase(Password)){
			Query updateQuery=session.createSQLQuery("update LoginDetails  set Encrypted_Password='"+newEncryptPwd+"', Password='"+newPassword+"'  where loginId='"+userId+"'");
			updateQuery.executeUpdate();
			passwordCheck=true;
			session.close();
		}
		else{
			passwordCheck=false;
		}
	}
	return passwordCheck;
	*/
	return false;	
	}
	
	public boolean changePasswordUtil(String oldPassword, String newPassword,
			String userId, Session session) {
		boolean passwordCheck = false;
		String oldEcriptedPwd = null;
		String newEncryptPwd = null;
		String Password = null;
		try {
			oldEcriptedPwd = EncryptionPasswordANDVerification
					.encryptPass(oldPassword);
			newEncryptPwd = EncryptionPasswordANDVerification
					.encryptPass(newPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Query pwdQuery = session
				.createQuery("select Encrypted_Password from LoginDetails where loginId='"
						+ userId + "'");
		List psdList = pwdQuery.list();
		for (Object LoginPassword : psdList) {
			Password = (String) LoginPassword;
			if (oldEcriptedPwd.equalsIgnoreCase(Password)) {
				Query updateQuery = session
						.createSQLQuery("update LoginDetails  set Encrypted_Password='"
								+ newEncryptPwd
								+ "', Password='"
								+ newPassword
								+ "'  where loginId='" + userId + "'");
				updateQuery.executeUpdate();
				passwordCheck = true;
			} else {
				passwordCheck = false;
			}
		}
		return passwordCheck;
	}
	
	

}
