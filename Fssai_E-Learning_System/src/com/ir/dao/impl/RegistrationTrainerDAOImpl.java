package com.ir.dao.impl;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ir.dao.RegistrationTrainerDAO;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.City;
import com.ir.model.CourseEnrolled;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.District;
import com.ir.model.LoginDetails;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadService;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendMail;


@Service
@Component("registrationDAO")
public class RegistrationTrainerDAOImpl implements RegistrationTrainerDAO {

@Autowired
@Qualifier("sessionFactory")
private SessionFactory sessionFactory;
@Autowired
@Qualifier("state")
private State state;
@Autowired
@Qualifier("district")
private District district;
@Autowired
@Qualifier("trainingPartnerName")
private ManageTrainingPartner trainingPartnerName;
@Autowired
@Qualifier("city")
private City city;
@Autowired
@Qualifier("title")
private Title title;

	@Override
	public State getState(int id){
		Session s = sessionFactory.getCurrentSession();
		State ss = (State)s.load(State.class, id);
		return ss;
	}
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	@Override
	public ManageTrainingPartner getTP(int id){
		Session s = sessionFactory.getCurrentSession();
		ManageTrainingPartner mtp = (ManageTrainingPartner)s.load(ManageTrainingPartner.class, id);
		return mtp;
	}
	@Override
	public City getCity(int id){
		Session s = sessionFactory.getCurrentSession();
		City cc = (City)s.load(City.class, id);
		return cc;
	}
	@Override
	public District getDistrict(int id){
		Session s = sessionFactory.getCurrentSession();
		District dd = (District)s.load(District.class, id);
		return dd;
	}
	@Override
	public Title getTitle(int id){
		Session s = sessionFactory.getCurrentSession();
		Title tt = (Title)s.load(Title.class, id);
		return tt;
	}
	
	@Override
	public String register(RegistrationFormTrainer registrationFormTrainer) {
		// TODO Auto-generated method stub
				System.out.println("RegistrationDAOImpl [register] begin for registration trainer");
				Integer personalInformationTrainerIdd=null;
				Session session = sessionFactory.getCurrentSession();
				PasswordGenerator passwordGenerator = new PasswordGenerator(6);
				char[] pass = passwordGenerator.get();
				String passwordString = String.valueOf(pass);
				registrationFormTrainer.isCheckPermanent();
				
				String encryprPassword = null;
				try{
					EncryptionPasswordANDVerification encryptionPasswordANDVerification = new EncryptionPasswordANDVerification();
					encryprPassword = encryptionPasswordANDVerification.encryptPass(passwordString);
					
				}catch(NoSuchAlgorithmException e){
					System.out.println( " no such algo exception error catch ");
				}
				String uniqueID = pageLoadService.getNextCombinationId("TR", "personalinformationtrainer" , "000000");
				
				State ps = getState(registrationFormTrainer.getTrainingCenterPermanentState()); 
				State cs = getState(registrationFormTrainer.getTrainingCenterCorrespondenceState());
				District pd = getDistrict(registrationFormTrainer.getTrainingCenterPermanentDistrict());
				District cd = getDistrict(registrationFormTrainer.getTrainingCenterCorrespondenceDistrict());
				City pc = getCity(registrationFormTrainer.getTrainingCenterPermanentCity());
				City cc = getCity(registrationFormTrainer.getTrainingCenterCorrespondenceCity());
				Title tt = getTitle(registrationFormTrainer.getTitle());
				ManageTrainingPartner mtp ; 
				if(registrationFormTrainer.getAssociatedTrainingpartnerName() == 0){
					mtp = new ManageTrainingPartner();
					mtp = null;
				}else{
					mtp = getTP(registrationFormTrainer.getAssociatedTrainingpartnerName());
				}
				boolean checkPeramanent=registrationFormTrainer.isCheckPermanent();
				LoginDetails loginDetails = new LoginDetails();
				loginDetails.setLoginId(uniqueID);
				loginDetails.setPassword(passwordString);
				loginDetails.setEncrypted_Password(encryprPassword);
				loginDetails.setProfileId(4);
				loginDetails.setStatus("A");
				
				PersonalInformationTrainer personalInformationTrainer = new PersonalInformationTrainer();
				personalInformationTrainer.setTitle(tt);
				personalInformationTrainer.setSteps(0);
				personalInformationTrainer.setAadharNumber(registrationFormTrainer.getAadharNumber() == null ? "" : registrationFormTrainer.getAadharNumber());
				personalInformationTrainer.setFirstName(registrationFormTrainer.getFirstName() == null ? "" : registrationFormTrainer.getFirstName());
				personalInformationTrainer.setLastName(registrationFormTrainer.getLastName() == null ? "" : registrationFormTrainer.getLastName());
				personalInformationTrainer.setMiddleName(registrationFormTrainer.getMiddleName() == null ? "" :registrationFormTrainer.getMiddleName());
				personalInformationTrainer.setDOB(registrationFormTrainer.getDOB() == null ? "" : registrationFormTrainer.getDOB());
				personalInformationTrainer.setCaste(registrationFormTrainer.getCaste() == null ? "" : registrationFormTrainer.getCaste());
				personalInformationTrainer.setGender(registrationFormTrainer.getGender() == null ? "" : registrationFormTrainer.getGender());
				personalInformationTrainer.setTrainingCenterCorrespondenceLine1(registrationFormTrainer.getTrainingCenterCorrespondenceLine1() == null ? "" : registrationFormTrainer.getTrainingCenterCorrespondenceLine1());
				personalInformationTrainer.setTrainingCenterCorrespondenceLine2(registrationFormTrainer.getTrainingCenterCorrespondenceLine2() == null ? "" : registrationFormTrainer.getTrainingCenterCorrespondenceLine2());
				personalInformationTrainer.setCorrespondencestate(cs);
				personalInformationTrainer.setCorrespondencedistrict(cd);
				personalInformationTrainer.setCorrespondencecity(cc);
				personalInformationTrainer.setFathername(registrationFormTrainer.getFatherName() == null ? "" : registrationFormTrainer.getFatherName());
				personalInformationTrainer.setTrainingCenterCorrespondencePincode(registrationFormTrainer.getTrainingCenterCorrespondencePincode() == null ? "" : registrationFormTrainer.getTrainingCenterCorrespondencePincode());
				personalInformationTrainer.setTrainingCenterPermanentEmail(registrationFormTrainer.getTrainingCenterPermanentEmail() == null ? "" : registrationFormTrainer.getTrainingCenterPermanentEmail());
				personalInformationTrainer.setTrainingCenterPermanentMobile(registrationFormTrainer.getTrainingCenterPermanentMobile() == null ? "" : registrationFormTrainer.getTrainingCenterPermanentMobile());
				personalInformationTrainer.setFoodSafetyExpBackground(registrationFormTrainer.getFoodSafetyExpBackground() == null ? "" : registrationFormTrainer.getFoodSafetyExpBackground());
				personalInformationTrainer.setTrainingSessionWishToConduct(registrationFormTrainer.getTrainingSessionWishToConduct());
				personalInformationTrainer.setExpInFoodSafefyTimeYear(registrationFormTrainer.getExpInFoodSafefyTimeYear());
				personalInformationTrainer.setExpInFoodSafefyTimeMonth(registrationFormTrainer.getExpInFoodSafefyTimeMonth());
				personalInformationTrainer.setAssociatedWithAnyTrainingPartner(registrationFormTrainer.getAssociatedWithAnyTrainingPartner() == null ? "" :  registrationFormTrainer.getAssociatedWithAnyTrainingPartner());
				personalInformationTrainer.setNoOfTrainingSessionConducted(registrationFormTrainer.getNoOfTrainingSessionConducted());
				personalInformationTrainer.setAssociatedTrainingpartnerName(mtp);
				if(checkPeramanent){
					personalInformationTrainer.setTrainingCenterPermanentLine1(registrationFormTrainer.getTrainingCenterCorrespondenceLine1() == null ? "" : registrationFormTrainer.getTrainingCenterCorrespondenceLine1());
					personalInformationTrainer.setTrainingCenterPermanentLine2(registrationFormTrainer.getTrainingCenterCorrespondenceLine2() == null ? "" : registrationFormTrainer.getTrainingCenterCorrespondenceLine2());
					personalInformationTrainer.setPermanentcity(cc);
					personalInformationTrainer.setPermanentdistrict(cd);
					personalInformationTrainer.setPermanentstate(cs);
					personalInformationTrainer.setCheckAddress("true");
					personalInformationTrainer.setTrainingCenterPermanentPincode(registrationFormTrainer.getTrainingCenterCorrespondencePincode() == null ? "" : registrationFormTrainer.getTrainingCenterCorrespondencePincode());
				}
				else{
				personalInformationTrainer.setTrainingCenterPermanentLine1(registrationFormTrainer.getTrainingCenterPermanentLine1() == null ? "" : registrationFormTrainer.getTrainingCenterPermanentLine1());
				personalInformationTrainer.setTrainingCenterPermanentLine2(registrationFormTrainer.getTrainingCenterPermanentLine2() == null ? "" : registrationFormTrainer.getTrainingCenterPermanentLine2());
				personalInformationTrainer.setPermanentstate(ps);
				personalInformationTrainer.setPermanentdistrict(pd);
				//System.out.println(pd.getDistrictId() + "dist id");
				personalInformationTrainer.setPermanentcity(pc);
				personalInformationTrainer.setCheckAddress("false");
				personalInformationTrainer.setTrainingCenterPermanentPincode(registrationFormTrainer.getTrainingCenterPermanentPincode() == null ? "" : registrationFormTrainer.getTrainingCenterPermanentPincode());
				}
				personalInformationTrainer.setLoginDetails(loginDetails);
				
				System.out.println("person save before save");
				//Session session = sessionFactory.openSession();
				//Transaction transaction=session.beginTransaction(); 
				personalInformationTrainerIdd = (Integer)session.save(personalInformationTrainer);
				System.out.println("RegistrationDAOImpl [register] begin for registration trainee login   :"+ personalInformationTrainer);
				
				
				String BasicCourse = registrationFormTrainer.getBasicCourse1();
				if(BasicCourse.length() > 0){
					String[] BasicCoursesplited = BasicCourse.split(",");
					System.out.println("basic course length   "+ BasicCoursesplited.length);
					if(BasicCoursesplited.length > 0){
						for(int i=0 ; i < BasicCoursesplited.length ; i++){
							CourseEnrolled courseEnrolledBasic = new CourseEnrolled();
							courseEnrolledBasic.setLoginDetails(loginDetails);
							courseEnrolledBasic.setCoursenameid(Integer.parseInt(BasicCoursesplited[i]));
							System.out.println("BasicCoursesplited  "+ BasicCoursesplited[i]);
							session.save(courseEnrolledBasic);
						}
					}
				}
				String AdvanceCourse = registrationFormTrainer.getAdvanceCourse1();
				if(AdvanceCourse.length() > 0){
					String[] AdvanceCoursesplited = AdvanceCourse.split(",");
					System.out.println("advance course length   "+ AdvanceCoursesplited.length);
					if(AdvanceCoursesplited.length > 0){
						for(int i=0 ; i < AdvanceCoursesplited.length ; i++){
							CourseEnrolled courseEnrolledAdvance = new CourseEnrolled();
							courseEnrolledAdvance.setLoginDetails(loginDetails);
							courseEnrolledAdvance.setCoursenameid(Integer.parseInt(AdvanceCoursesplited[i]));
							System.out.println("AdvanceCoursesplited  "+ AdvanceCoursesplited[i]);
							session.save(courseEnrolledAdvance);
						}
					}
				}

				String SpecialCourse = registrationFormTrainer.getSpecialCourse1();
				if(AdvanceCourse.length() > 0){
					String[] SpecialCoursesplited = SpecialCourse.split(",");
					System.out.println("SpecialCourse course length   "+ SpecialCoursesplited.length);
					if(SpecialCoursesplited.length > 0){
						for(int i=0 ; i < SpecialCoursesplited.length ; i++){
							CourseEnrolled courseEnrolledSpecial = new CourseEnrolled();
							courseEnrolledSpecial.setLoginDetails(loginDetails);
							courseEnrolledSpecial.setCoursenameid(Integer.parseInt(SpecialCoursesplited[i]));
							System.out.println("SpecialCoursesplited  "+ SpecialCoursesplited[i]);
							session.save(courseEnrolledSpecial);
						}
					}
				}
				return passwordString+"&"+uniqueID;
	}
	
	@Override
	public String updatetrainer(RegistrationFormTrainer registrationFormTrainer, int id) {
		State ps = getState(registrationFormTrainer.getTrainingCenterPermanentState()); 
		State cs = getState(registrationFormTrainer.getTrainingCenterCorrespondenceState());
		District pd = getDistrict(registrationFormTrainer.getTrainingCenterPermanentDistrict());
		District cd = getDistrict(registrationFormTrainer.getTrainingCenterCorrespondenceDistrict());
		City pc = getCity(registrationFormTrainer.getTrainingCenterPermanentCity());
		City cc = getCity(registrationFormTrainer.getTrainingCenterCorrespondenceCity());
		//Title tt = getTitle(registrationFormTrainer.getTitle());
		ManageTrainingPartner mtp = getTP(registrationFormTrainer.getAssociatedTrainingpartnerName());
		
		
		Session s=sessionFactory.getCurrentSession();
		
		PersonalInformationTrainer personalinformationtrainer= (PersonalInformationTrainer) s.load(PersonalInformationTrainer.class, id);
		
		personalinformationtrainer.setTrainingCenterCorrespondenceLine1(registrationFormTrainer.getTrainingCenterCorrespondenceLine1());
		personalinformationtrainer.setTrainingCenterCorrespondenceLine2(registrationFormTrainer.getTrainingCenterCorrespondenceLine2());
		personalinformationtrainer.setCorrespondencestate(cs);
		personalinformationtrainer.setCorrespondencedistrict(cd);
		personalinformationtrainer.setCorrespondencecity(cc);
		personalinformationtrainer.setTrainingCenterPermanentEmail(registrationFormTrainer.getTrainingCenterPermanentEmail());
		personalinformationtrainer.setTrainingCenterPermanentMobile(registrationFormTrainer.getTrainingCenterPermanentMobile());
		personalinformationtrainer.setTrainingCenterCorrespondencePincode(registrationFormTrainer.getTrainingCenterCorrespondencePincode());
		/*
		
		personalinformationtrainer.setTrainingCenterPermanentLine1(registrationFormTrainer.getTrainingCenterPermanentLine1());
		personalinformationtrainer.setTrainingCenterPermanentLine2(registrationFormTrainer.getTrainingCenterPermanentLine2());
		personalinformationtrainer.setPermanentstate(ps);
		personalinformationtrainer.setPermanentdistrict(pd);
		personalinformationtrainer.setPermanentcity(pc);
		personalinformationtrainer.setTrainingCenterPermanentPincode(registrationFormTrainer.getTrainingCenterPermanentPincode());
		*/
		boolean checkPeramanent=registrationFormTrainer.isCheckPermanent();
		if(checkPeramanent){
			personalinformationtrainer.setTrainingCenterPermanentLine1(registrationFormTrainer.getTrainingCenterCorrespondenceLine1());
			personalinformationtrainer.setTrainingCenterPermanentLine2(registrationFormTrainer.getTrainingCenterCorrespondenceLine2());
			personalinformationtrainer.setPermanentcity(cc);
			personalinformationtrainer.setPermanentdistrict(cd);
			personalinformationtrainer.setPermanentstate(cs);
			personalinformationtrainer.setCheckAddress("true");
			personalinformationtrainer.setTrainingCenterPermanentPincode(registrationFormTrainer.getTrainingCenterCorrespondencePincode());
		}
		else{
			personalinformationtrainer.setTrainingCenterPermanentLine1(registrationFormTrainer.getTrainingCenterPermanentLine1());
			personalinformationtrainer.setTrainingCenterPermanentLine2(registrationFormTrainer.getTrainingCenterPermanentLine2());
			personalinformationtrainer.setPermanentstate(ps);
			personalinformationtrainer.setPermanentdistrict(pd);
			personalinformationtrainer.setPermanentcity(pc);
			personalinformationtrainer.setCheckAddress("false");
			personalinformationtrainer.setTrainingCenterPermanentPincode(registrationFormTrainer.getTrainingCenterPermanentPincode());
		}
		
		
		
		personalinformationtrainer.setBasicCourse(registrationFormTrainer.getBasicCourse1());
		personalinformationtrainer.setAdvanceCourse(registrationFormTrainer.getAdvanceCourse1());
		personalinformationtrainer.setSpecialCourse(registrationFormTrainer.getSpecialCourse1());
		personalinformationtrainer.setAssociatedTrainingpartnerName(mtp);
		personalinformationtrainer.setExpInFoodSafefyTimeMonth(registrationFormTrainer.getExpInFoodSafefyTimeMonth());
		personalinformationtrainer.setFoodSafetyExpBackground(registrationFormTrainer.getFoodSafetyExpBackground());
		personalinformationtrainer.setNoOfTrainingSessionConducted(registrationFormTrainer.getNoOfTrainingSessionConducted());
		personalinformationtrainer.setTrainingSessionWishToConduct(registrationFormTrainer.getTrainingSessionWishToConduct());
		personalinformationtrainer.setAssociatedWithAnyTrainingPartner(registrationFormTrainer.getAssociatedWithAnyTrainingPartner());
		personalinformationtrainer.setTrainingSessionWishToConduct(registrationFormTrainer.getTrainingSessionWishToConduct());
		personalinformationtrainer.setGender(registrationFormTrainer.getGender());
		personalinformationtrainer.setExpInFoodSafefyTimeYear(registrationFormTrainer.getExpInFoodSafefyTimeYear());
		s.update(personalinformationtrainer);
		return "updated";
		}

	@Override
	public long basicCourseTrainer(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		
		Session session =sessionFactory.getCurrentSession();
		long date = System.currentTimeMillis();
		System.out.println("roll nu  :"+date);
		System.out.println("loginid  :"+loginid);
		System.out.println("personalinformationtraineeid   :"+courseEnrolledUserForm);
		System.out.println("calander id is  "+courseEnrolledUserForm.getTrainingCalendarId());
		
		CourseEnrolledUser ceu = new CourseEnrolledUser();
		ceu.setLoginDetails(loginid);
		ceu.setProfileId(4);
		ceu.setTrainingCalendarId(courseEnrolledUserForm.getTrainingCalendarId());
		session.save(ceu);
		return date;
	}
	@Override
	public long advanceTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		Session session =sessionFactory.getCurrentSession();
		long date = System.currentTimeMillis();
		System.out.println("roll nu  :"+date);
		System.out.println("loginid  :"+loginid);
		System.out.println("personalinformationtraineeid   :"+courseEnrolledUserForm);
		System.out.println("calander id is  "+courseEnrolledUserForm.getTrainingCalendarId());
		
		CourseEnrolledUser ceu = new CourseEnrolledUser();
		//ceu.setLoginDetails(loginid);
		ceu.setProfileId(4);
		ceu.setTrainingCalendarId(courseEnrolledUserForm.getTrainingCalendarId());
		session.save(ceu);
		return date;
	}
	@Override
	public long specialTrainerSave(CourseEnrolledUserForm courseEnrolledUserForm, int loginid) {
		Session session =sessionFactory.getCurrentSession();
		long date = System.currentTimeMillis();
		System.out.println("roll nu  :"+date);
		System.out.println("loginid  :"+loginid);
		System.out.println("personalinformationtraineeid   :"+courseEnrolledUserForm);
		System.out.println("calander id is  "+courseEnrolledUserForm.getTrainingCalendarId());
		
		CourseEnrolledUser ceu = new CourseEnrolledUser();
		//ceu.setLoginDetails(loginid);
		ceu.setProfileId(4);
		ceu.setTrainingCalendarId(courseEnrolledUserForm.getTrainingCalendarId());
		//ceu.setRollno(date);
		//abhay ceu.setStatus("Pending");
		
		session.save(ceu);
		return date;
	}
	@Override
	public PersonalInformationTrainer fullDetailtrainer(int loginId) {
		// TODO Auto-generated method stub
		System.out.println("LogintrainerDAOImpl full detail process start ");
		Session session = sessionFactory.getCurrentSession();
		Integer i = loginId;
		System.out.println("search " + loginId);
		Query query = session.createQuery("from PersonalInformationTrainer where loginDetails = '"+ i +"'");
		List<PersonalInformationTrainer> list = query.list();
		PersonalInformationTrainer personalInformationTrainer = null;
		for(PersonalInformationTrainer personalInformationTrainer1: list){
			personalInformationTrainer=personalInformationTrainer1;
		}
		return personalInformationTrainer;

	}
	
	
	
	@Override
	public List<ManageTrainingPartner> trainingPartnerList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> trainingPartnerList = query.list();
		return trainingPartnerList;
	}
	}
	
	

