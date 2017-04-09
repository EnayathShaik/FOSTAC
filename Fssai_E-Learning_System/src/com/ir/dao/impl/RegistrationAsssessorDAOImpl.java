package com.ir.dao.impl;


import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ir.dao.RegistrationAssessorDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.RegistrationFormAssessor;
import com.ir.model.City;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseEnrolled;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadService;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendContectMail;
import com.ir.util.SendMail;


@Repository
@Component("RegistrationAssessorDAO")
@Service
public class RegistrationAsssessorDAOImpl implements RegistrationAssessorDAO {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
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
	@Qualifier("kindOfBusiness")
	private KindOfBusiness kindOfBusiness;
	@Autowired
	@Qualifier("assessmentAgency")
	private ManageAssessmentAgency assessmentAgency;
	
	
	@Override
	public State getState(int id){
		Session s = sessionFactory.getCurrentSession();
		State ss = (State)s.load(State.class, id);
		return ss;
	}
	@Override
	public District getDistrict(int id){
		Session s = sessionFactory.getCurrentSession();
		District dd = (District)s.load(District.class, id);
		return dd;
	}
	// Rishi 
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	// Rishi end
	
	
	@Override
	public City getCity(int id){
		Session s = sessionFactory.getCurrentSession();
		City cc = (City)s.load(City.class, id);
		return cc;
	}
	@Override
	public Title getTitle(int id){
		Session s = sessionFactory.getCurrentSession();
		Title tt = (Title)s.load(Title.class, id);
		return tt;
	}
	@Override
	public ManageAssessmentAgency getAssessmentAgencyName(int id){
		Session s = sessionFactory.getCurrentSession();
		ManageAssessmentAgency manageAssessmentAgency = (ManageAssessmentAgency)s.load(ManageAssessmentAgency.class, id);
		return manageAssessmentAgency;
	}
	
	
	@Override
	public String register(RegistrationFormAssessor registrationFormAssessor ) {
		try{
			Integer personalInformationTrainerIdd = null  ;
			State cs = getState(registrationFormAssessor.getAssessorCorrespondenceState());
			State ps = getState(registrationFormAssessor.getAssessorrPermanentState());
			District cd = getDistrict(registrationFormAssessor.getAssessorCorrespondenceDistrict());
			District pd = getDistrict(registrationFormAssessor.getAssessorPermanentDistrict());
			City cc = getCity(registrationFormAssessor.getAssessorCorrespondenceCity());
			City pc = getCity(registrationFormAssessor.getAssessorPermanentCity());
			Title tt = getTitle(registrationFormAssessor.getTitle());
			ManageAssessmentAgency maan = getAssessmentAgencyName(registrationFormAssessor.getAssessmentAgencyName());
			
			List<String> registeredCourses = registrationFormAssessor.getBasicCourses();
			
			if(registrationFormAssessor.getAdvanceCourses() != null)
				registeredCourses.addAll(registrationFormAssessor.getAdvanceCourses());
			if(registrationFormAssessor.getSpecialCourses() != null)
				registeredCourses.addAll(registrationFormAssessor.getSpecialCourses());
			
			
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
			
			String uniqueID = pageLoadService.getNextCombinationId("AS", "personalinformationassessor" , "000000");
			LoginDetails loginDetails = new LoginDetails();
			loginDetails.setPassword(passwordString);
			loginDetails.setEncrypted_Password(encryprPassword.trim());
			loginDetails.setProfileId(6);
			loginDetails.setStatus("I");
			loginDetails.setLoginId(uniqueID);

			PersonalInformationAssessor personalInformationAssessor = new PersonalInformationAssessor();
			personalInformationAssessor.setTitle(tt);
			personalInformationAssessor.setUserId(uniqueID);
			personalInformationAssessor.setAadharNumber(registrationFormAssessor.getAadharNumber() == null ? "" : registrationFormAssessor.getAadharNumber());
			personalInformationAssessor.setFirstName(registrationFormAssessor.getFirstName() == null ? "" : registrationFormAssessor.getFirstName());
			personalInformationAssessor.setLastName(registrationFormAssessor.getLastName() == null ? "" : registrationFormAssessor.getLastName());
			personalInformationAssessor.setMiddleName(registrationFormAssessor.getMiddleName() == null ? "" : registrationFormAssessor.getMiddleName());
			personalInformationAssessor.setDOB(registrationFormAssessor.getDOB() == null ? "" : registrationFormAssessor.getDOB());
			personalInformationAssessor.setGender(registrationFormAssessor.getGender() == null ? "" : registrationFormAssessor.getGender());
			personalInformationAssessor.setAssessorPermanentLine1(registrationFormAssessor.getAssessorPermanentLine1() == null ? "" : registrationFormAssessor.getAssessorPermanentLine1());
			personalInformationAssessor.setAssessorPermanentLine2(registrationFormAssessor.getAssessorPermanentLine2() == null ? "" : registrationFormAssessor.getAssessorPermanentLine2());
			personalInformationAssessor.setAssessorrPermanentState(ps);
			personalInformationAssessor.setAssessorPermanentDistrict(pd);
			personalInformationAssessor.setAssessorPermanentCity(pc);
			personalInformationAssessor.setAssessorPermanentPincode(registrationFormAssessor.getAssessorPermanentPincode() == null ? "" : registrationFormAssessor.getAssessorPermanentPincode());
			personalInformationAssessor.setAssessorPermanentEmail(registrationFormAssessor.getAssessorPermanentEmail() == null ? "" : registrationFormAssessor.getAssessorPermanentEmail());
			personalInformationAssessor.setAssessorPermanentMobile(registrationFormAssessor.getAssessorPermanentMobile() == null ? "" : registrationFormAssessor.getAssessorPermanentMobile());
			personalInformationAssessor.setAssessorCorrespondenceLine1(registrationFormAssessor.getAssessorCorrespondenceLine1() == null ? "" : registrationFormAssessor.getAssessorCorrespondenceLine1());
			personalInformationAssessor.setAssessorCorrespondenceLine2(registrationFormAssessor.getAssessorCorrespondenceLine2() == null ? "" : registrationFormAssessor.getAssessorCorrespondenceLine2());
			personalInformationAssessor.setAssessorCorrespondenceState(cs);
			personalInformationAssessor.setAssessorCorrespondenceDistrict(cd);
			personalInformationAssessor.setAssessorCorrespondenceCity(cc);
			personalInformationAssessor.setAssessorCorrespondencePincode(registrationFormAssessor.getAssessorCorrespondencePincode() == null ? "" : registrationFormAssessor.getAssessorCorrespondencePincode());
			personalInformationAssessor.setReleventExpOfAuditInYear(registrationFormAssessor.getReleventExpOfAuditInYear());
			personalInformationAssessor.setReleventExpOfAuditInMonth(registrationFormAssessor.getReleventExpOfAuditInMonth() == null ? "" : registrationFormAssessor.getReleventExpOfAuditInMonth());
			personalInformationAssessor.setHowManyAssessmentConductInAMonth(registrationFormAssessor.getHowManyAssessmentConductInAMonth() == null ? "" : registrationFormAssessor.getHowManyAssessmentConductInAMonth());
			personalInformationAssessor.setAssessmentAgencyName(maan);
			personalInformationAssessor.setLoginDetails(loginDetails);
			//personalInformationAssessor.setCoursesEnrolled(coursesEnrolled);
			
			try{
				Session session = sessionFactory.getCurrentSession();
				personalInformationTrainerIdd = (Integer)session.save(personalInformationAssessor);
				System.out.println("RegistrationDAOImpl [register] begin for registration assessor login   :"+ personalInformationAssessor);
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Exception while saving accessor :" + e.getMessage());
			}
			
			Session session1 = sessionFactory.getCurrentSession();
			try{
				
				List<String> listCourses = new ArrayList<String>();
				
				
				if(registrationFormAssessor.getBasicCourses() != null &&  registrationFormAssessor.getBasicCourses().size() >0)
					listCourses.addAll(registrationFormAssessor.getBasicCourses());
				if(registrationFormAssessor.getAdvanceCourses() != null &&  registrationFormAssessor.getAdvanceCourses().size() >0)
					listCourses.addAll(registrationFormAssessor.getAdvanceCourses());
				if(registrationFormAssessor.getSpecialCourses() != null &&  registrationFormAssessor.getSpecialCourses().size() >0)
					listCourses.addAll(registrationFormAssessor.getSpecialCourses());
				
				for (int i = 0; i < listCourses.size(); i++) {
					String strBasicCourse = listCourses.get(i);
//						String[] BasicCoursesplited = BasicCourse.split(",");
						System.out.println("basic course length   "+ strBasicCourse);
								CourseEnrolled courseEnrolledBasic = new CourseEnrolled();
								courseEnrolledBasic.setLoginDetails(loginDetails);
								courseEnrolledBasic.setCoursenameid(Integer.parseInt(strBasicCourse));
								System.out.println("BasicCoursesplited  "+ strBasicCourse);
								session1.save(courseEnrolledBasic);
				}
		}catch (Exception e) {
				System.out.println("Oops !! course basic" + e.getMessage());
			}
			System.out.println("lllll     "+ uniqueID + "      "+ personalInformationTrainerIdd);
			System.out.println("all insert done");
		
			if(personalInformationTrainerIdd >0 ){
				SendMail sendMail = new SendMail();
				sendMail.mailProperty(passwordString, registrationFormAssessor.getAssessorPermanentEmail(), registrationFormAssessor.getFirstName()+ " " + registrationFormAssessor.getLastName());
				return passwordString+"&"+uniqueID;
			}else{
				return passwordString+"&"+uniqueID;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<State> loadState() {
		System.out.println("Page Load DAOImpl process start in state");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from State  where status = 'A'");
		List listState = query.list();
		System.out.println("state list dao     :"+ listState);
		// TODO Auto-generated method stub
		return listState;
	}

	@Override
	public List<Title> loadTitle() {
		System.out.println("Page Load DAOImpl process start in title ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Title");
		List titleList = query.list();
		System.out.println("title  ************* list dao     :"+ titleList);
		return titleList;
	}

	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in course name ");
		Session session = sessionFactory.getCurrentSession();
		String sql = "select ct.coursetypeid ,cn.coursename , cn.coursenameid from coursename as cn inner join coursetype as ct"+
					" on ct.coursetypeid = cn.coursetypeid";
		Query query = session.createSQLQuery(sql);
		List courseNameList = query.list();
		System.out.println("CourseName  ************* list dao     :"+ courseNameList);
		return courseNameList;
	}

	@Override
	public List<ManageAssessmentAgency> loadAssessmentAgency() {
		System.out.println("Page Load DAOImpl process start in Assessment Agency");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ManageAssessmentAgency");
		List loadAssessmentAgency = query.list();
		System.out.println("state list dao     :"+ loadAssessmentAgency);
		// TODO Auto-generated method stub
		return loadAssessmentAgency;
	}

	@Override
	public String updateAssessor(RegistrationFormAssessor registrationFormAssessor, int loginId) {
		Session session =sessionFactory.getCurrentSession();
		State cs = getState(registrationFormAssessor.getAssessorCorrespondenceState());
		State ps = getState(registrationFormAssessor.getAssessorrPermanentState());
		District cd = getDistrict(registrationFormAssessor.getAssessorCorrespondenceDistrict());
		District pd = getDistrict(registrationFormAssessor.getAssessorPermanentDistrict());
		City cc = getCity(registrationFormAssessor.getAssessorCorrespondenceCity());
		City pc = getCity(registrationFormAssessor.getAssessorPermanentCity());
		//Title tt = getTitle(registrationFormAssessor.getTitle());
		//ManageAssessmentAgency maan = getAssessmentAgencyName(registrationFormAssessor.getAssessmentAgencyName());
		
		System.out.println("Assessor login id to update information : "+ loginId);
		
		PersonalInformationAssessor   personalInformationAssessor=(PersonalInformationAssessor) session.load(PersonalInformationAssessor.class, loginId);
		
	//	personalInformationAssessor.setAadharNumber(registrationFormAssessor.getAadharNumber());
		//personalInformationAssessor.setAssessmentAgencyName(maan);
		personalInformationAssessor.setAssessorCorrespondenceCity(cc);
		personalInformationAssessor.setAssessorCorrespondenceDistrict(cd);
	    personalInformationAssessor.setAssessorCorrespondenceState(cs);
	    personalInformationAssessor.setAssessorCorrespondenceLine1(registrationFormAssessor.getAssessorCorrespondenceLine1());
		personalInformationAssessor.setAssessorCorrespondenceLine2(registrationFormAssessor.getAssessorCorrespondenceLine2());
	    personalInformationAssessor.setAssessorCorrespondencePincode(registrationFormAssessor.getAssessorCorrespondencePincode());
		personalInformationAssessor.setAssessorPermanentCity(pc);
		personalInformationAssessor.setAssessorPermanentDistrict(pd);
		personalInformationAssessor.setAssessorrPermanentState(ps);
		personalInformationAssessor.setAssessorPermanentEmail(registrationFormAssessor.getAssessorPermanentEmail());
		personalInformationAssessor.setAssessorPermanentMobile(registrationFormAssessor.getAssessorPermanentMobile());
		personalInformationAssessor.setAssessorPermanentPincode(registrationFormAssessor.getAssessorPermanentPincode());
		personalInformationAssessor.setAssessorPermanentLine1(registrationFormAssessor.getAssessorPermanentLine1());
		personalInformationAssessor.setAssessorPermanentLine2(registrationFormAssessor.getAssessorPermanentLine2());
		//personalInformationAssessor.setFirstName(registrationFormAssessor.getFirstName());
		//personalInformationAssessor.setLastName(registrationFormAssessor.getLastName());
		personalInformationAssessor.setReleventExpOfAuditInYear(registrationFormAssessor.getReleventExpOfAuditInYear());
	    personalInformationAssessor.setReleventExpOfAuditInMonth(registrationFormAssessor.getReleventExpOfAuditInMonth());
		personalInformationAssessor.setHowManyAssessmentConductInAMonth(registrationFormAssessor.getHowManyAssessmentConductInAMonth());
		personalInformationAssessor.setGender(registrationFormAssessor.getGender());
		//personalInformationAssessor.setMiddleName(registrationFormAssessor.getMiddleName());
		System.out.println("reachec down");
		session.update(personalInformationAssessor);
		
		return "updated";
	}
	/*@Override
	public String cotactAssessorSave(ContactFormAssessor contactFormAssessor, int id) {
		
			SendContectMail traineeMaail=null;
			 traineeMaail = new SendContectMail();
				
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			ContactAssessor contactAssessor = new ContactAssessor();
			String email=contactAssessor.getEmailAddress();
			String msg=contactAssessor.getMessageDetails();
			traineeMaail.mailProperty(msg, email,id);
			
			System.out.println("sent mail to........................");
			
			contactAssessor.setEmailAddress(email);;
			contactAssessor.setMessageDetails(msg);;
			contactAssessor.setUserId(contactFormAssessor.getUserId());
			Integer contactTrainerModelId = (Integer) session.save(contactAssessor);
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
	public String cotactAssessorSave(ContactTrainee contactTrainee, String id) {
		
			SendContectMail traineeMaail=null;
			 traineeMaail = new SendContectMail();
				
			Session session = sessionFactory.getCurrentSession();
			ContactTraineee contactTrainee1 = new ContactTraineee();
			String email=contactTrainee.getEmailAddress();
			String msg=contactTrainee.getMessageDetails();
			traineeMaail.mailProperty(msg, email,id);
			
			System.out.println("sent mail to........................");
			
			contactTrainee1.setEmailAddress(email);;
			contactTrainee1.setMessageDetails(msg);;
			contactTrainee1.setUserId(id);
			Integer contactTrainerModelId = (Integer) session.save(contactTrainee1);
			System.out.println("contactTraineeSave after save");
			if(contactTrainerModelId >0 && contactTrainerModelId != null){
				
				
				return "created";
			}else{
				return "error";
			}

	}
	@Override
	public boolean cotactAssessorSave(ChangePasswordForm changePasswordForm, String id) {
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		//String idd=changePasswordForm.getLoginid();
		System.out.println("new pass   "+oldPassword);
		
		
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		
		
		return confirm;
	}
	
	@Override
	public PersonalInformationAssessor fullDetailAssesser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Integer i = id;
		System.out.println("search " + id);
		Query query = session.createQuery("from PersonalInformationAssessor where loginDetails = '"+ i +"'");
		List<PersonalInformationAssessor> list = query.list();
		PersonalInformationAssessor personalInformationAssessor = null;
		for(PersonalInformationAssessor personalInformationAssessor1: list){
			personalInformationAssessor=personalInformationAssessor1;
		}
		return personalInformationAssessor;
	}
	// Rishi
}