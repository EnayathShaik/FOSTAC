package com.ir.dao.impl;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.RegistrationTrainingPartnerDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.RegistrationFormTrainingPartner;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseEnrolled;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.LoginDetails;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.GenerateUniqueID;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendContectMail;
import com.ir.util.SendMail;

public class RegistrationTrainingPartnerDAOImpl implements RegistrationTrainingPartnerDAO {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	@Qualifier("loginDetails")
	private LoginDetails loginDetails;
	@Autowired
	@Qualifier("postVacancyTrainingCenter")
	private PostVacancyTrainingCenter postVacancyTrainingCenter;
	@Autowired
	@Qualifier("personalInformationTrainingPartner")
	private PersonalInformationTrainingPartner personalInformationTrainingPartner;
	@Autowired
	@Qualifier("courseNameS")
	private CourseName courseNameS;
	@Autowired
	@Qualifier("courseTypeS")
	private CourseType courseTypeS;

	
	@Override
	public PersonalInformationTrainingPartner getPersonalInformationTrainingPartner(int id){
		Session s = sessionFactory.openSession();
		PersonalInformationTrainingPartner personalInformationTrainingPartner = (PersonalInformationTrainingPartner)s.load(PersonalInformationTrainingPartner.class, id);
		s.close();
		return personalInformationTrainingPartner;
	}
	
	@Override
	public CourseType getCourseType(int id){
		Session s = sessionFactory.openSession();
		CourseType courseType = (CourseType)s.load(CourseType.class, id);
		s.close();
		return courseType;
	}
	@Override
	public LoginDetails getLoginDetails(String string){
		Session s = sessionFactory.openSession();
		LoginDetails loginDetails = (LoginDetails)s.load(LoginDetails.class, string);
		s.close();
		return loginDetails;
	}
	
	@Override
	public CourseName getCourseName(int id){
		Session s = sessionFactory.openSession();
		CourseName courseName = (CourseName)s.load(CourseName.class, id);
		s.close();
		return courseName;
	}
		
	@Override
	public String register(RegistrationFormTrainingPartner registrationFormTrainingPartner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<State> loadState() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from State  where status = 'A'");
		List listState = query.list();
		session.close();
		System.out.println("state list dao     :"+ listState);
		// TODO Auto-generated method stub
		return listState;
	}
//Rishi
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	// Rishi

	@Override
	public List<Title> loadTitle() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Title");
		List titleList = query.list();
		session.close();
		return titleList;
	}

	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
				Session session = sessionFactory.openSession();
				String sql = "select ct.coursetypeid ,cn.coursename , cn.coursenameid from coursename as cn inner join coursetype as ct"+
						" on ct.coursetypeid = cn.coursetypeid";
				
				Query query = session.createSQLQuery(sql);
				List courseNameList = query.list();
				session.close();
				return courseNameList;
	}

	@Override
	public List<ManageTrainingPartner> trainingPartnerNameList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> trainingPartnerNameList = query.list();
		session.close();
		return trainingPartnerNameList;
	}

	@Override
	public String registerTrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner) {
		int personalInformationTrainingPartnerIdd = 0;
		Session session = sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		String passwordString = null;
		try{
			PasswordGenerator passwordGenerator = new PasswordGenerator(6);
			char[] pass = passwordGenerator.get();
			passwordString = String.valueOf(pass);
		}catch(Exception e){
			passwordString = "password";
		}
		
		
		
		
		String encryprPassword = null;
		try{
			EncryptionPasswordANDVerification encryptionPasswordANDVerification = new EncryptionPasswordANDVerification();
			encryprPassword = encryptionPasswordANDVerification.encryptPass(passwordString);
			
		}catch(NoSuchAlgorithmException e){
			System.out.println( " no such algo exception error catch ");
		}
		
		//registrationTrainingPartner
		PersonalInformationTrainingPartner personalInformationTrainingPartner = new PersonalInformationTrainingPartner();
		String TPName =  registrationFormTrainingPartner.getTPName();  
		String preFix = "TCTP"+TPName;
		System.out.println("preFix "+preFix);
		String nextSequenceUserID  =  GenerateUniqueID.getNextCombinationId(preFix, "personalInformationTrainingPartner", "00");
		System.out.println("nextSequenceUserID "+nextSequenceUserID);
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setLoginId(nextSequenceUserID);
		/**TODO - change the status to I initially */
		
		loginDetails.setStatus("A");
		loginDetails.setPassword(passwordString);
		loginDetails.setEncrypted_Password(encryprPassword);
		loginDetails.setProfileId(5);
		
		
		personalInformationTrainingPartner.setUserID(nextSequenceUserID);
		personalInformationTrainingPartner.setTitle(registrationFormTrainingPartner.getTitle());
		personalInformationTrainingPartner.setTrainingCentreName(registrationFormTrainingPartner.getTrainingCentreName());
		personalInformationTrainingPartner.setTrainingPartnerName(registrationFormTrainingPartner.getTrainingPartnerName());
		personalInformationTrainingPartner.setFirstName(registrationFormTrainingPartner.getFirstName());
		personalInformationTrainingPartner.setLastName(registrationFormTrainingPartner.getLastName());
		personalInformationTrainingPartner.setMiddleName(registrationFormTrainingPartner.getMiddleName());
		personalInformationTrainingPartner.setPAN(registrationFormTrainingPartner.getPAN());
		personalInformationTrainingPartner.setTrainingPartnerPermanentLine1(registrationFormTrainingPartner.getTrainingPartnerPermanentLine1());
		personalInformationTrainingPartner.setTrainingPartnerPermanentLine2(registrationFormTrainingPartner.getTrainingPartnerPermanentLine2());
		personalInformationTrainingPartner.setTrainingPartnerPermanentState(registrationFormTrainingPartner.getTrainingPartnerPermanentState());
		personalInformationTrainingPartner.setTrainingPartnerPermanentDistrict(registrationFormTrainingPartner.getTrainingPartnerPermanentDistrict());
		personalInformationTrainingPartner.setTrainingPartnerPermanentCity(registrationFormTrainingPartner.getTrainingPartnerPermanentCity());
		personalInformationTrainingPartner.setTrainingPartnerPermanentPincode(registrationFormTrainingPartner.getTrainingPartnerPermanentPincode());
		personalInformationTrainingPartner.setTrainingPartnerPermanentEmail(registrationFormTrainingPartner.getTrainingPartnerPermanentEmail());
		personalInformationTrainingPartner.setTrainingPartnerPermanentMobile(registrationFormTrainingPartner.getTrainingPartnerPermanentMobile());
		personalInformationTrainingPartner.setSeatCapacityPerSession(registrationFormTrainingPartner.getSeatCapacityPerSession());
		personalInformationTrainingPartner.setSeatcapacityAvailable(Integer.parseInt(registrationFormTrainingPartner.getSeatCapacityPerSession()));
		
		//personalInformationTrainingPartner.setNoOfInHouseTrainers(registrationFormTrainingPartner.getNoOfInHouseTrainers());
		personalInformationTrainingPartner.setAvailabiltyOfTVProjector(registrationFormTrainingPartner.getAvailabiltyOfInHouseTrainersInFoodSafety());
		personalInformationTrainingPartner.setFacilityOfElectricityAndAirCondition(registrationFormTrainingPartner.getFacilityOfElectricityAndAirCondition());
		System.out.println("drinking water "+registrationFormTrainingPartner.getFacilityOfDrinkingWater());
		personalInformationTrainingPartner.setTrainingPartnerPermanentLandLine(registrationFormTrainingPartner.getTrainingPartnerPermanentLandLine());
		personalInformationTrainingPartner.setFacilityOfDrinkingWater(registrationFormTrainingPartner.getFacilityOfDrinkingWater());
		personalInformationTrainingPartner.setFacilityOfWashroom(registrationFormTrainingPartner.getFacilityOfWashroom());
		//personalInformationTrainingPartner.setNoOfYearsInBusinessOfTraining(registrationFormTrainingPartner.getNoOfYearsInBusinessOfTraining());
		personalInformationTrainingPartner.setAvailabiltyOfInHouseTrainersInFoodSafety(registrationFormTrainingPartner.getAvailabiltyOfInHouseTrainersInFoodSafety());
		//personalInformationTrainingPartner.setNoOfTrainingSessionWishToConductInAMonth(registrationFormTrainingPartner.getNoOfTrainingSessionWishToConductInAMonth());
		personalInformationTrainingPartner.setLoginDetails(loginDetails);
		personalInformationTrainingPartner.setProfileCode(5);
		
		try{
			personalInformationTrainingPartnerIdd = (Integer) session.save(personalInformationTrainingPartner);
			transaction.commit();
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Oops !!");
		}
		Session session1 = sessionFactory.openSession();
		Transaction transaction1= session1.beginTransaction();
		try{
			String BasicCourse = registrationFormTrainingPartner.getBasicCourse1();
			if(BasicCourse.length() > 0){
				String[] BasicCoursesplited = BasicCourse.split(",");
				System.out.println("basic course length   "+ BasicCoursesplited.length);
				if(BasicCoursesplited.length >= 1){
					for(int i=0 ; i < BasicCoursesplited.length ; i++){
						CourseEnrolled courseEnrolledBasic = new CourseEnrolled();
						courseEnrolledBasic.setLoginDetails(loginDetails);
						courseEnrolledBasic.setCoursenameid(Integer.parseInt(BasicCoursesplited[i]));
						System.out.println("BasicCoursesplited  "+ BasicCoursesplited[i]);
						Integer courseenrolledBasicc = (Integer)session1.save(courseEnrolledBasic);
					}
				}
			}
			String AdvanceCourse = registrationFormTrainingPartner.getAdvanceCourse1();
			if(AdvanceCourse.length() > 0){
				String[] AdvanceCoursesplited = AdvanceCourse.split(",");
				System.out.println("advance course length   "+ AdvanceCoursesplited.length);
				if(AdvanceCoursesplited.length >= 1){
					for(int i=0 ; i < AdvanceCoursesplited.length ; i++){
						CourseEnrolled courseEnrolledAdvance = new CourseEnrolled();
						courseEnrolledAdvance.setLoginDetails(loginDetails);
						courseEnrolledAdvance.setCoursenameid(Integer.parseInt(AdvanceCoursesplited[i]));
						System.out.println("AdvanceCoursesplited  "+ AdvanceCoursesplited[i]);
						Integer courseenrolledAdvancee = (Integer)session1.save(courseEnrolledAdvance);
					}
				}
			}
			String SpecialCourse = registrationFormTrainingPartner.getSpecialCourse1();
			if(AdvanceCourse.length() > 0){
				String[] SpecialCoursesplited = SpecialCourse.split(",");
				System.out.println("SpecialCourse course length   "+ SpecialCoursesplited.length);
				if(SpecialCoursesplited.length >= 1){
					for(int i=0 ; i < SpecialCoursesplited.length ; i++){
						CourseEnrolled courseEnrolledSpecial = new CourseEnrolled();
						courseEnrolledSpecial.setLoginDetails(loginDetails);
						courseEnrolledSpecial.setCoursenameid(Integer.parseInt(SpecialCoursesplited[i]));
						System.out.println("SpecialCoursesplited  "+ SpecialCoursesplited[i]);
						Integer courseenrolledSpeciall = (Integer)session1.save(courseEnrolledSpecial);
					}
				}
			}	
		}catch (Exception e) {
			System.out.println("Oops !! course basic");
		}
		System.out.println("all insert done");
		transaction1.commit();
		session1.close();
		if(personalInformationTrainingPartnerIdd > 0){
			SendMail sendMail = new SendMail();
			sendMail.mailProperty(passwordString, registrationFormTrainingPartner.getTrainingPartnerPermanentEmail(), registrationFormTrainingPartner.getFirstName()+ " " + registrationFormTrainingPartner.getLastName());

			return passwordString+"&"+nextSequenceUserID;
			//return "created";
		}else{
			return passwordString+"&"+nextSequenceUserID;
			//return "error";
		}
	}

	@Override
	public List<ManageTrainingPartner> trainingCenterList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> trainingCenterList = query.list();
		session.close();
		return trainingCenterList;
	}	
	@Override
	public String updatetrainingPartner(RegistrationFormTrainingPartner registrationFormTrainingPartner, Integer id) {
		Session s=sessionFactory.openSession();
		
		PersonalInformationTrainingPartner personalInformationTrainingPartner=(PersonalInformationTrainingPartner) s.load(PersonalInformationTrainingPartner.class,id);
		
		System.out.println("ID == "+personalInformationTrainingPartner.getPersonalInformationTrainingPartnerId());
		
		System.out.println("id is in dao "+id);
		//personalInformationTrainingPartner.setAvailabiltyOfInHouseTrainersInFoodSafety(registrationFormTrainingPartner.getAvailabiltyOfInHouseTrainersInFoodSafety());
		//personalInformationTrainingPartner.setAvailabiltyOfTVProjector(registrationFormTrainingPartner.getAvailabiltyOfTVProjector());
		//personalInformationTrainingPartner.setFirstName(registrationFormTrainingPartner.getFirstName());
		//personalInformationTrainingPartner.setLastName(registrationFormTrainingPartner.getLastName());
		//personalInformationTrainingPartner.setMiddleName(registrationFormTrainingPartner.getMiddleName());
		//personalInformationTrainingPartner.setNoOfInHouseTrainers(registrationFormTrainingPartner.getNoOfInHouseTrainers());
		//personalInformationTrainingPartner.setNoOfTrainingSessionWishToConductInAMonth(registrationFormTrainingPartner.getNoOfTrainingSessionWishToConductInAMonth());
		//personalInformationTrainingPartner.setNoOfYearsInBusinessOfTraining(registrationFormTrainingPartner.getNoOfYearsInBusinessOfTraining());
		//personalInformationTrainingPartner.setPAN(registrationFormTrainingPartner.getPAN());
		personalInformationTrainingPartner.setTrainingPartnerPermanentLine1(registrationFormTrainingPartner.getTrainingPartnerPermanentLine1());
		personalInformationTrainingPartner.setTrainingPartnerPermanentLine2(registrationFormTrainingPartner.getTrainingPartnerPermanentLine2());
		personalInformationTrainingPartner.setTrainingPartnerPermanentState(registrationFormTrainingPartner.getTrainingPartnerPermanentState());
		personalInformationTrainingPartner.setTrainingPartnerPermanentDistrict(registrationFormTrainingPartner.getTrainingPartnerPermanentDistrict());
		personalInformationTrainingPartner.setTrainingPartnerPermanentCity(registrationFormTrainingPartner.getTrainingPartnerPermanentCity());
		personalInformationTrainingPartner.setTrainingPartnerPermanentPincode(registrationFormTrainingPartner.getTrainingPartnerPermanentPincode().trim());
		System.out.println(registrationFormTrainingPartner.getTrainingPartnerPermanentEmail()  + "email is "+registrationFormTrainingPartner.getTrainingPartnerPermanentPincode().length());
		String email= registrationFormTrainingPartner.getTrainingPartnerPermanentEmail();
		System.out.println("email is"+email);
		personalInformationTrainingPartner.setTrainingPartnerPermanentEmail(email.trim());
		personalInformationTrainingPartner.setTrainingPartnerPermanentMobile(registrationFormTrainingPartner.getTrainingPartnerPermanentMobile());
		personalInformationTrainingPartner.setSeatCapacityPerSession(registrationFormTrainingPartner.getSeatCapacityPerSession().trim());
	//	personalInformationTrainingPartner.setSeatcapacityAvailable(Integer.parseInt(registrationFormTrainingPartner.getSeatCapacityPerSession()));
		
		//personalInformationTrainingPartner.setNoOfInHouseTrainers(registrationFormTrainingPartner.getNoOfInHouseTrainers().trim());
		//personalInformationTrainingPartner.setAvailabiltyOfTVProjector(registrationFormTrainingPartner.getAvailabiltyOfInHouseTrainersInFoodSafety().trim());
		//personalInformationTrainingPartner.setNoOfYearsInBusinessOfTraining(registrationFormTrainingPartner.getNoOfYearsInBusinessOfTraining().trim());
		//personalInformationTrainingPartner.setAvailabiltyOfInHouseTrainersInFoodSafety(registrationFormTrainingPartner.getAvailabiltyOfInHouseTrainersInFoodSafety().trim());
		//personalInformationTrainingPartner.setNoOfTrainingSessionWishToConductInAMonth(registrationFormTrainingPartner.getNoOfTrainingSessionWishToConductInAMonth().trim());		
		s.update(personalInformationTrainingPartner);
		s.beginTransaction().commit();
		s.close();
		return "updated";
		
	}

	/*@Override
	public String contactTraineeSave(ContactTrainee contactTrainee, int id) {
		SendContectMail traineeMaail=null;
		 traineeMaail = new SendContectMail();
			
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ContactTrainee contactTrainerModel = new ContactTrainee();
		String email=contactTrainee.getEmailId();
		String msg=contactTrainee.getMessage();
//		traineeMaail.mailProperty(msg, email,id);

		contactTrainerModel.setEmailId(email); 
		contactTrainerModel.setMessage(msg);
		contactTrainerModel.setUserId(contactTrainee.getUserId());
		Integer contactTrainerModelId = (Integer) session.save(contactTrainerModel);
		System.out.println("contactTraineeSave after save");
		tx.commit();
		session.close();
		if(contactTrainerModelId >0 && contactTrainerModelId != null){
			return "created";
		}else{
			return "error";
		}
	}*/
	@Override
	public String contactTraineeSave(ContactTrainee contactTrainee, String id) {
		SendContectMail traineeMaail=null;
		 traineeMaail = new SendContectMail();
			
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ContactTraineee contactTrainerModel = new ContactTraineee();
		String email=contactTrainee.getEmailAddress();
		String msg=contactTrainee.getMessageDetails();
		traineeMaail.mailProperty(msg, email,id);

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
	public String postVacancyTrainingCenter(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		Integer postVacancyTrainingCenterIdd ;
		Session session = sessionFactory.openSession();
		PersonalInformationTrainingPartner p = getPersonalInformationTrainingPartner(postVacancyTrainingCenterForm.getTrainingCenter());
		
		System.out.println("hkhkhk");
		String sql = "select * from PostVacancyTrainingCenter where CourseType = '"+postVacancyTrainingCenterForm.getCourseType()+"' and CourseName = '" + postVacancyTrainingCenterForm.getCourseName()+"' and TrainingDate = '"+ postVacancyTrainingCenterForm.getTrainingDate()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() > 0){
			session.close();
			return "error";
		}else{
			session.flush();
			CourseType ct = getCourseType(postVacancyTrainingCenterForm.getCourseType());
			CourseName cn = getCourseName(postVacancyTrainingCenterForm.getCourseName());
			//LoginDetails loginDetails = loginDetails.setLoginId(postVacancyTrainingCenterForm.getLoginId());
			postVacancyTrainingCenter.setNoOfVacancy(postVacancyTrainingCenterForm.getNoOfVacancy());
			postVacancyTrainingCenter.setRequiredExp(postVacancyTrainingCenterForm.getRequiredExp());
			postVacancyTrainingCenter.setTrainingDate(postVacancyTrainingCenterForm.getTrainingDate());
			postVacancyTrainingCenter.setCourseName(cn);
			postVacancyTrainingCenter.setCourseType(ct);
			postVacancyTrainingCenter.setLoginId(postVacancyTrainingCenterForm.getLoginId());
			postVacancyTrainingCenter.setTrainingCenter(p);
			postVacancyTrainingCenterIdd = (Integer) session.save(postVacancyTrainingCenter);
			System.out.println("post Vacancy TrainingCenter after save");
			session.beginTransaction().commit();
			session.close();
			if(postVacancyTrainingCenterIdd >0 && postVacancyTrainingCenterIdd != null){
				return "created";
			}else{
				return "error";
			}
		}
	}


	@Override
	public List<CourseName> courseNameList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from CourseName");
		List<CourseName> courseNameList = query.list();
		session.close();
		return courseNameList;
	}


	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		session.close();
		return courseTypeList;
	}
		@Override
		public boolean changePasswordTCSave(ChangePasswordForm changePasswordForm, String id) {
		
			String oldPassword=	changePasswordForm.getOldPassword();
			String newPassword=changePasswordForm.getNewPassword();
			//String idd=changePasswordForm.getLoginid();
			System.out.println("new pass   "+oldPassword);
			
			
			boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
			
			
			return confirm;
		}
		
		@Override
		public PersonalInformationTrainingPartner fulldetailtainingpartner(int id) {
			System.out.println("LogintrainerpartnerDAOImpl full detail process start ");
			Session session = sessionFactory.openSession();
			Integer i = id;
			
			Query query = session.createQuery("from PersonalInformationTrainingPartner where loginDetails = '"+ i +"'");
			List<PersonalInformationTrainingPartner> list1 = query.list();
			
			PersonalInformationTrainingPartner personalInformationTrainingPartner11 = null;
			for(PersonalInformationTrainingPartner personalInformationTrainingPartner:list1){
				personalInformationTrainingPartner11=personalInformationTrainingPartner;
			}
			//session.close();
			return personalInformationTrainingPartner11;
		}
	// rishi
		
		
		
		
}
