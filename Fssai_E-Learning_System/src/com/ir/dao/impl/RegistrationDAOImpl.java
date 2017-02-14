package com.ir.dao.impl;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.tomcat.util.buf.UEncoder;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ir.constantes.DBUtil;
import com.ir.dao.AdminDAO;
import com.ir.dao.RegistrationDAO;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.City;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.LoginDetails;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.RegisterTraineeInformationFull;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendMail;
import com.zentect.ajax.AjaxRequest;


@Component("registrationDAO")
public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	@Qualifier("kindOfBusiness")
	private KindOfBusiness kindOfBusiness;
	@Autowired
	@Qualifier("state")
	private State state;
	@Autowired
	@Qualifier("district")
	private District district;
	@Autowired
	@Qualifier("city")
	private City city;
	@Autowired
	@Qualifier("title")
	private Title title;
	@Autowired
	@Qualifier("loginDetails")
	private LoginDetails loginDetails;
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	@Qualifier("personalInformationTrainee")
	private PersonalInformationTrainee personalInformationTrainee;
	
	@Override
	public KindOfBusiness getKid(int id){
		Session ss = sessionFactory.openSession();
		KindOfBusiness kid=(KindOfBusiness) ss.load(KindOfBusiness.class, id);
		ss.close();
		return kid;
	}
	@Override
	public State getState(int id){
		Session s = sessionFactory.openSession();
		State ss = (State)s.load(State.class, id);
		s.close();
		return ss;
	}
	@Override
	public City getCity(int id){
		Session s = sessionFactory.openSession();
		City cc = (City)s.load(City.class, id);
		s.close();
		return cc;
	}
	@Override
	public District getDistrict(int id){
		Session s = sessionFactory.openSession();
		District dd = (District)s.load(District.class, id);
		s.close();
		return dd;
	}
	@Override
	public Title getTitle(int id){
		Session s = sessionFactory.openSession();
		Title tt = (Title)s.load(Title.class, id);
		s.close();
		return tt;
	}
	@Autowired
	AdminDAO admindao;
	
	@Override
	public RegisterTraineeInformationFull register(RegistrationFormTrainee registrationFormTrainee)  {
		
		System.out.println("RegistrationDAOImpl [register] begin ");
		Integer userId=null;
		try{
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction(); 
		System.out.println("state " +registrationFormTrainee.getResState());
		userId = (Integer)session.save(registrationFormTrainee);
		//registerTraineeInformationFull.setUserId(userId);
		transaction.commit();
		session.close();
		System.out.println("savedPerson "+userId);
		}catch(HibernateException he){
			
			String localizedMessage = he.getLocalizedMessage();
			if(null==userId || localizedMessage.contains("duplicate key")){
				System.out.println("UserAlreadRegisteredException occured..");
				Exception e=he;
				
			}
			
		}
		return null;
	}

	@Override
	public String registerUserIdCheck(RegistrationFormTrainee registrationFormTrainee)  {
		// TODO Auto-generated method stub
		String ret = "";
		List list = null;
		try{
			Session session = sessionFactory.openSession();
			String sqlQuery = "select password from personalinformationtrainee where userid = " + registrationFormTrainee.getUserId() + " ";
			String newList=null;
			Transaction transaction = null;
			try {       
		        transaction = session.beginTransaction();
		        System.out.println("sqlQuery "+sqlQuery);
				Query query = session.createSQLQuery(sqlQuery);
				list = query.list();
		        transaction.commit();
		    }
		    catch(Exception re){
		        transaction.rollback();
		    }
		    finally {
		        if(session != null){
		            Transaction tran = session.getTransaction();
		            if(tran != null && tran.isActive() && !tran.wasCommitted() && tran.wasRolledBack()){
		                tran.rollback();
		            }
		            session.close();
		        }
		    }
			if(list.size() > 0){
				System.out.println("not available to use");
				ret = "already";
			}else{
				System.out.println("not in database");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*String ret = null;
		ResultSet rs = null;
		String q = "select password from personalinformationtrainee where userid = " + registrationFormTrainee.getUserId() + " ";
		 try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
         Connection con = null;
		try {
			con = DriverManager.getConnection(DBUtil.databaseUrl,DBUtil.dbUsername,DBUtil.dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
         Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = st.executeQuery(q);
			System.out.println("******* :" + rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
			try {
				if(rs.next()){
					ret = "already";
				}else{
					ret = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("RegistrationDAOImpl user id check begin *** :" + ret);*/
			return ret;
	}

	@Override
	public String registerPersonalInformationTrainee(
			RegistrationFormTrainee registrationFormTrainee) {
		System.out.println("RegistrationDAOImpl [register] begin for registration trainee");
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction(); 
		
		State ps = getState(registrationFormTrainee.getResState()); 
		State cs = getState(registrationFormTrainee.getCorrespondenceState());
		State bs = getState(registrationFormTrainee.getBussState());
		District pd = getDistrict(registrationFormTrainee.getResidentialDistrict());
		District cd = getDistrict(registrationFormTrainee.getCorrespondenceDistrict());
		District bd = getDistrict(registrationFormTrainee.getBussDistrict());
		City pc = getCity(registrationFormTrainee.getResCity());
		City cc = getCity(registrationFormTrainee.getCorrespondenceCity());
		City bc = getCity(registrationFormTrainee.getBussCity());
		Title tt = getTitle(registrationFormTrainee.getTitle());
		KindOfBusiness kob = getKid(registrationFormTrainee.getKindOfBusiness());
		
	boolean correspondADD=registrationFormTrainee.isCheckCorrespondence();
	boolean checkCompany=registrationFormTrainee.isCheckCompany();
		
	System.out.println("this is boolean value   "+correspondADD);
		PasswordGenerator passwordGenerator = new PasswordGenerator(6);
		char[] pass = passwordGenerator.get();
		String passwordString = String.valueOf(pass);
		
		
		String encryprPassword = null;
		try{
			EncryptionPasswordANDVerification encryptionPasswordANDVerification = new EncryptionPasswordANDVerification();
			encryprPassword = encryptionPasswordANDVerification.encryptPass(passwordString);
			
		}catch(NoSuchAlgorithmException e){
			System.out.println( " no such algo exception error catch ");
		}
		
		
		
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setLoginId(registrationFormTrainee.getUserId());
		loginDetails.setPassword(passwordString);
		loginDetails.setEncrypted_Password(encryprPassword);
		loginDetails.setStatus("A");
		loginDetails.setProfileId(3);
		PersonalInformationTrainee personalInformationTrainee = new PersonalInformationTrainee();
		personalInformationTrainee.setSteps(0);
		personalInformationTrainee.setTitle(tt);
		personalInformationTrainee.setCaste(registrationFormTrainee.getCaste());
		personalInformationTrainee.setAadharNumber(registrationFormTrainee.getAadharNumber().trim());
		personalInformationTrainee.setFirstName(registrationFormTrainee.getFirstName().trim());
		personalInformationTrainee.setLastName(registrationFormTrainee.getLastName().trim());
		personalInformationTrainee.setMiddleName(registrationFormTrainee.getMiddleName().trim());
		personalInformationTrainee.setDob(registrationFormTrainee.getDob().trim());
		System.out.println("Gender == "+registrationFormTrainee.getGender());
		personalInformationTrainee.setGender(registrationFormTrainee.getGender().trim());
		personalInformationTrainee.setEmail(registrationFormTrainee.getEmail().trim());
		personalInformationTrainee.setMobile(registrationFormTrainee.getMobile().trim());		
		personalInformationTrainee.setCorrespondenceAddress1(registrationFormTrainee.getCorrespondenceAddress1().trim());
		personalInformationTrainee.setCorrespondenceAddress2(registrationFormTrainee.getCorrespondenceAddress2().trim());
		personalInformationTrainee.setCorrespondenceState(cs);
		personalInformationTrainee.setCorrespondenceDistrict(cd);
		personalInformationTrainee.setCorrespondenceCity(cc);
		personalInformationTrainee.setCorrespondencePincode(registrationFormTrainee.getCorrespondencePincode().trim());
		personalInformationTrainee.setFatherName(registrationFormTrainee.getFatherName());
		
		
		
		if(correspondADD){
			personalInformationTrainee.setResidentialLine1(registrationFormTrainee.getCorrespondenceAddress1());
			personalInformationTrainee.setResidentialLine2(registrationFormTrainee.getCorrespondenceAddress2());
			personalInformationTrainee.setResState(cs);
			personalInformationTrainee.setResCity(cc);
			personalInformationTrainee.setResidentialDistrict(cd);
			personalInformationTrainee.setResPincode(registrationFormTrainee.getCorrespondencePincode());
			personalInformationTrainee.setCheckPermanent("true");
		}else{
			personalInformationTrainee.setResidentialLine1(registrationFormTrainee.getResidentialAddressLine1());
			personalInformationTrainee.setResidentialLine2(registrationFormTrainee.getResidentialAddressLine2());
			personalInformationTrainee.setResState(ps);
			personalInformationTrainee.setResCity(pc);
			personalInformationTrainee.setResidentialDistrict(pd);
			personalInformationTrainee.setResPincode(registrationFormTrainee.getResPincode());
			personalInformationTrainee.setCheckPermanent("false");
			}
		
		if(registrationFormTrainee.getKindOfBusiness()==6){
			System.out.println(" IF Kind of business");
			registrationFormTrainee.setKindOfBusiness(6);
			KindOfBusiness koFbusiness = new KindOfBusiness(6, "Not in business");
			personalInformationTrainee.setKindOfBusiness(koFbusiness);
			personalInformationTrainee.setDesignation(null);
			personalInformationTrainee.setCompanyName(null);
			personalInformationTrainee.setRegistrationNo(null);
			personalInformationTrainee.setBusinessAddressLine1(null);
			personalInformationTrainee.setBusinessAddressLine2(null);
			personalInformationTrainee.setBussCity(null);
			personalInformationTrainee.setBussDistrict(null);
			personalInformationTrainee.setBussState(null);
			personalInformationTrainee.setBussPincode(null);
			
		}
		else{
			System.out.println("Else Kind of business");
			personalInformationTrainee.setDesignation(registrationFormTrainee.getDesignation().trim());
			personalInformationTrainee.setKindOfBusiness(kob);
			personalInformationTrainee.setCompanyName(registrationFormTrainee.getCompanyName());
			personalInformationTrainee.setRegistrationNo(registrationFormTrainee.getRegistrationNo());
			

			if(checkCompany){
				personalInformationTrainee.setBusinessAddressLine1(registrationFormTrainee.getCorrespondenceAddress1());
				personalInformationTrainee.setBusinessAddressLine2(registrationFormTrainee.getCorrespondenceAddress2());
				personalInformationTrainee.setBussCity(cc);
				personalInformationTrainee.setBussDistrict(cd);
				personalInformationTrainee.setBussState(cs);
				personalInformationTrainee.setBussPincode(registrationFormTrainee.getCorrespondencePincode());
				personalInformationTrainee.setCheckCompany("true");
				
			}else{
				personalInformationTrainee.setBusinessAddressLine1(registrationFormTrainee.getBusinessAddressLine1());
				personalInformationTrainee.setBusinessAddressLine2(registrationFormTrainee.getBusinessAddressLine2());
				personalInformationTrainee.setDesignation(registrationFormTrainee.getDesignation());
			
				personalInformationTrainee.setBussState(bs);
				personalInformationTrainee.setBussCity(bc);
				personalInformationTrainee.setBussDistrict(bd);
				personalInformationTrainee.setBussPincode(registrationFormTrainee.getBussPincode());
				personalInformationTrainee.setCheckCompany("false");
	}
		}
	//		personalInformationTrainee.setFirstName(registrationFormTrainee.getFirstName());
		
		personalInformationTrainee.setLoginDetails(loginDetails);
		Integer personalInformationTraineeId = (Integer)session.save(personalInformationTrainee);
		
		System.out.println("all insert done");
		transaction.commit();
		session.close();
		System.out.println("saved login "+ personalInformationTraineeId);
		if(personalInformationTraineeId  != 0){
			/*SendMail sendMail = new SendMail();
			sendMail.mailProperty(passwordString, registrationFormTrainee.getEmail(), registrationFormTrainee.getFirstName()+ " " + registrationFormTrainee.getLastName());
*/
			return passwordString+"&"+registrationFormTrainee.getUserId();
		}else{
			return passwordString+"&"+registrationFormTrainee.getUserId();
		}
	}
	
}
