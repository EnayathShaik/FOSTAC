package com.ir.dao.impl;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
import com.ir.service.PageLoadService;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.PasswordGenerator;


@Component("registrationDAO")
@Service
public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	@Qualifier("kindOfBusiness")
	private KindOfBusiness kindOfBusiness;
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;


	
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
	
	public KindOfBusiness getKid(int id,Session session){
		KindOfBusiness kid=(KindOfBusiness) session.load(KindOfBusiness.class, id);
		return kid;
	}
	public State getState(int id,Session session){
		State ss = (State)session.load(State.class, id);
		return ss;
	}
	public City getCity(int id,Session session){
		City cc = (City)session.load(City.class, id);
		return cc;
	}
	public District getDistrict(int id,Session session){
		District dd = (District)session.load(District.class, id);
		return dd;
	}
	public Title getTitle(int id,Session session){
		Title tt = (Title)session.load(Title.class, id);
		return tt;
	}
	
	
	@Override
	public RegisterTraineeInformationFull register(RegistrationFormTrainee registrationFormTrainee)  {
		
		System.out.println("RegistrationDAOImpl [register] begin ");
		Integer userId=null;
		try{
		Session session = sessionFactory.getCurrentSession();
		System.out.println("state " +registrationFormTrainee.getResState());
		userId = (Integer)session.save(registrationFormTrainee);
		//registerTraineeInformationFull.setUserId(userId);
		System.out.println("savedPerson "+userId);
		}catch(HibernateException he){
			
			String localizedMessage = he.getLocalizedMessage();
			if(null==userId || localizedMessage.contains("duplicate key")){
				System.out.println("UserAlreadRegisteredException occured..");
				
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
			Session session = sessionFactory.getCurrentSession();
			String sqlQuery = "select password from personalinformationtrainee where userid = " + registrationFormTrainee.getUserId() + " ";
			//String newList=null;
			try {       
		        System.out.println("sqlQuery "+sqlQuery);
				Query query = session.createSQLQuery(sqlQuery);
				list = query.list();
		    }
		    catch(Exception re){
		    	re.printStackTrace();
		    }
		    finally {}
			if(list.size() > 0){
				System.out.println("not available to use");
				ret = "already";
			}else{
				System.out.println("not in database");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
			return ret;
	}

	@Override
	public String registerPersonalInformationTrainee(
			RegistrationFormTrainee registrationFormTrainee) {
		
		Session session = sessionFactory.getCurrentSession();
		State ps = getState(registrationFormTrainee.getResState(),session); 
		State cs = getState(registrationFormTrainee.getCorrespondenceState(),session);
		State bs = getState(registrationFormTrainee.getBussState(),session);
		District pd = getDistrict(registrationFormTrainee.getResidentialDistrict(),session);
		District cd = getDistrict(registrationFormTrainee.getCorrespondenceDistrict(),session);
		District bd = getDistrict(registrationFormTrainee.getBussDistrict(),session);
		City pc = getCity(registrationFormTrainee.getResCity(),session);
		City cc = getCity(registrationFormTrainee.getCorrespondenceCity(),session);
		City bc = getCity(registrationFormTrainee.getBussCity(),session);
		Title tt = getTitle(registrationFormTrainee.getTitle(),session);
		KindOfBusiness kob = getKid(registrationFormTrainee.getKindOfBusiness(),session);
		
		boolean correspondADD=registrationFormTrainee.isCheckCorrespondence();
		boolean checkCompany=registrationFormTrainee.isCheckCompany();
		
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
		
		String nextSequenceUserID = pageLoadService.getNextCombinationId("TE", "personalinformationtrainee" , "000000");
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setLoginId(nextSequenceUserID);
		loginDetails.setPassword(passwordString);
		loginDetails.setEncrypted_Password(encryprPassword);
		loginDetails.setStatus("A");
		loginDetails.setProfileId(3);
		PersonalInformationTrainee personalInformationTrainee = new PersonalInformationTrainee();
		personalInformationTrainee.setSteps(0);
		personalInformationTrainee.setTitle(tt);
		personalInformationTrainee.setCaste(registrationFormTrainee.getCaste() == null ? "" : registrationFormTrainee.getCaste().trim());
		personalInformationTrainee.setAadharNumber(registrationFormTrainee.getAadharNumber() == null ? "" : registrationFormTrainee.getAadharNumber().trim());
		personalInformationTrainee.setFirstName(registrationFormTrainee.getFirstName() == null ? "" : registrationFormTrainee.getFirstName().trim());
		personalInformationTrainee.setLastName(registrationFormTrainee.getLastName() == null ? "" : registrationFormTrainee.getLastName().trim());
		personalInformationTrainee.setMiddleName(registrationFormTrainee.getMiddleName() == null ? "" : registrationFormTrainee.getMiddleName().trim());
		personalInformationTrainee.setDob(registrationFormTrainee.getDob() == null ? "" : registrationFormTrainee.getDob().trim());
		personalInformationTrainee.setGender(registrationFormTrainee.getGender() == null ? "" : registrationFormTrainee.getGender().trim());
		personalInformationTrainee.setEmail(registrationFormTrainee.getEmail() == null ? "" : registrationFormTrainee.getEmail().trim());
		personalInformationTrainee.setMobile(registrationFormTrainee.getMobile() == null ? "" : registrationFormTrainee.getMobile().trim());		
		personalInformationTrainee.setCorrespondenceAddress1(registrationFormTrainee.getCorrespondenceAddress1() == null ? "" : registrationFormTrainee.getCorrespondenceAddress1().trim());
		personalInformationTrainee.setCorrespondenceAddress2(registrationFormTrainee.getCorrespondenceAddress2() == null ? "" : registrationFormTrainee.getCorrespondenceAddress2().trim());
		personalInformationTrainee.setCorrespondenceState(cs);
		personalInformationTrainee.setCorrespondenceDistrict(cd);
		personalInformationTrainee.setCorrespondenceCity(cc);
		personalInformationTrainee.setCorrespondencePincode(registrationFormTrainee.getCorrespondencePincode() == null ? "" : registrationFormTrainee.getCorrespondencePincode().trim());
		personalInformationTrainee.setFatherName(registrationFormTrainee.getFatherName() == null ? "" : registrationFormTrainee.getFatherName().trim());
		
		
		
		if(correspondADD){
			personalInformationTrainee.setResidentialLine1(registrationFormTrainee.getCorrespondenceAddress1() == null ? "" : registrationFormTrainee.getCorrespondenceAddress1().trim());
			personalInformationTrainee.setResidentialLine2(registrationFormTrainee.getCorrespondenceAddress2() == null ? "" : registrationFormTrainee.getCorrespondenceAddress2().trim());
			personalInformationTrainee.setResState(cs);
			personalInformationTrainee.setResCity(cc);
			personalInformationTrainee.setResidentialDistrict(cd);
			personalInformationTrainee.setResPincode(registrationFormTrainee.getCorrespondencePincode() == null ? "" : registrationFormTrainee.getCorrespondencePincode().trim());
			personalInformationTrainee.setCheckPermanent("true");
		}else{
			personalInformationTrainee.setResidentialLine1(registrationFormTrainee.getResidentialAddressLine1() == null ? "" : registrationFormTrainee.getResidentialAddressLine1().trim());
			personalInformationTrainee.setResidentialLine2(registrationFormTrainee.getResidentialAddressLine2() == null ? "" : registrationFormTrainee.getResidentialAddressLine2().trim());
			personalInformationTrainee.setResState(ps);
			personalInformationTrainee.setResCity(pc);
			personalInformationTrainee.setResidentialDistrict(pd);
			personalInformationTrainee.setResPincode(registrationFormTrainee.getResPincode() == null ? "" : registrationFormTrainee.getResPincode().trim());
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
			personalInformationTrainee.setDesignation(registrationFormTrainee.getDesignation() == null ? "" : registrationFormTrainee.getDesignation().trim());
			personalInformationTrainee.setKindOfBusiness(kob);
			personalInformationTrainee.setCompanyName(registrationFormTrainee.getCompanyName() == null ? "" : registrationFormTrainee.getCompanyName().trim());
			personalInformationTrainee.setRegistrationNo(registrationFormTrainee.getRegistrationNo() == null ? "" : registrationFormTrainee.getRegistrationNo().trim());
			

			if(checkCompany){
				personalInformationTrainee.setBusinessAddressLine1(registrationFormTrainee.getCorrespondenceAddress1() == null ? "" : registrationFormTrainee.getCorrespondenceAddress1().trim());
				personalInformationTrainee.setBusinessAddressLine2(registrationFormTrainee.getCorrespondenceAddress2() == null ? "" : registrationFormTrainee.getCorrespondenceAddress2().trim());
				personalInformationTrainee.setBussCity(cc);
				personalInformationTrainee.setBussDistrict(cd);
				personalInformationTrainee.setBussState(cs);
				personalInformationTrainee.setBussPincode(registrationFormTrainee.getCorrespondencePincode() == null ? "" : registrationFormTrainee.getCorrespondencePincode().trim());
				personalInformationTrainee.setCheckCompany("true");
			}else{
				personalInformationTrainee.setBusinessAddressLine1(registrationFormTrainee.getBusinessAddressLine1() == null ? "" : registrationFormTrainee.getBusinessAddressLine1().trim());
				personalInformationTrainee.setBusinessAddressLine2(registrationFormTrainee.getBusinessAddressLine2() == null ? "" : registrationFormTrainee.getBusinessAddressLine2().trim());
				personalInformationTrainee.setDesignation(registrationFormTrainee.getDesignation() == null ? "" : registrationFormTrainee.getDesignation().trim());
			
				personalInformationTrainee.setBussState(bs);
				personalInformationTrainee.setBussCity(bc);
				personalInformationTrainee.setBussDistrict(bd);
				personalInformationTrainee.setBussPincode(registrationFormTrainee.getBussPincode() == null ? "" : registrationFormTrainee.getBussPincode().trim());
				personalInformationTrainee.setCheckCompany("false");
	}
		}
		personalInformationTrainee.setLoginDetails(loginDetails);
		session.save(personalInformationTrainee);
		return passwordString+"&"+nextSequenceUserID;
	}
	
}
