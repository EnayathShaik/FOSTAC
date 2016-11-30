package com.ir.util;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.model.LoginDetails;

public class ChangePasswordUtility {
	
	@Autowired
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;
	
	
	public  boolean changePasswordUtil( String oldPassword, String newPassword, String userId){
		boolean passwordCheck=false;
		String oldEcriptedPwd=null;
		String newEncryptPwd=null;
		String dataPassword=null;
		String Password=null;
		System.out.println("this is for pass set  "+userId);
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
		 System.out.println("this is to pass the password  "+Password);
		 System.out.println("this is old password  "+oldEcriptedPwd);
		 System.out.println("data base data "+Password);
	
		/*for(int i=0;i<psdList.size();i++){
		String LoginPassword=(String) psdList.get(i);
			
		// dataPassword=LoginPassword.getPassword();
		}*/
		if(oldEcriptedPwd.equalsIgnoreCase(Password)){
			
			
			
			Query updateQuery=session.createSQLQuery("update LoginDetails  set Encrypted_Password='"+newEncryptPwd+"', Password='"+newPassword+"'  where loginId='"+userId+"'");
			System.out.println("password is getting change");

			updateQuery.executeUpdate();
						
						
						passwordCheck=true;
						session.close();
		}
		
		else{
			passwordCheck=false;
		}
	}
			
		return passwordCheck;
	}
	
	

}
