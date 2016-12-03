package com.ir.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.AdminDAO;
import com.ir.dao.TraineeDAO;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.AdmitCardForm;
import com.ir.model.City;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseEnrolled;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.LoginDetails;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.TrainingPartner;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.Profiles;
import com.ir.util.SendContectMail;
import com.itextpdf.text.log.SysoCounter;

public class TraineeDAOImpl implements  TraineeDAO{

	@Autowired
	@Qualifier("sessionFactory")
	public SessionFactory sessionFactory;
	
// Rishi
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	@Autowired
	public CourseEnrolledUser courseEnrolledUser;
	// Rishi
		
	@Autowired
	@Qualifier("state")
	private State state;
	@Autowired
	@Qualifier("kindOfBusiness")
	private KindOfBusiness kindOfBusiness;
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
	@Qualifier("adminDAO")
	AdminDAO adminDAO;
	
	
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
	
	/*@Override
	public String contactTraineeSave(ContactTrainee contactTrainee , String id) {
		SendContectMail traineeMaail= new SendContectMail();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ContactTraineee contactTraineeModel = new ContactTraineee();
		String email=contactTrainee.getEmailId();
		String msg=contactTrainee.getMessage();
		//String ss=contactTrainee.getUserId();
		System.out.println("user id in dao impl  :::::" + id);
		traineeMaail.mailProperty(msg, email,id);
		contactTraineeModel.setEmailAddress(email);
		contactTraineeModel.setMessageDetails(msg);
		contactTraineeModel.setUserId(id);
		Integer contactTraineeModelId = (Integer) session.save(contactTraineeModel);
		tx.commit();
		session.close();
		if(contactTraineeModelId >0 && contactTraineeModelId != null){
			return "created";
		}else{
			return "error";
		}
	}*/

	@Override
	public String contactTraineeSave(ContactTrainee contactTrainee , String id) {
		SendContectMail traineeMaail= new SendContectMail();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		ContactTraineee contactTraineeModel = new ContactTraineee();
		String email=contactTrainee.getEmailAddress();
		String msg=contactTrainee.getMessageDetails();
		//String ss=contactTrainee.getUserId();
		System.out.println("user id in dao impl  :::::" + id);
		traineeMaail.mailProperty(msg, email,id);
		contactTraineeModel.setEmailAddress(email);
		contactTraineeModel.setMessageDetails(msg);
		contactTraineeModel.setUserId(id);
		Integer contactTraineeModelId = (Integer) session.save(contactTraineeModel);
		tx.commit();
		session.close();
		if(contactTraineeModelId >0 && contactTraineeModelId != null){
			return "created";
		}else{
			return "error";
		}
	}
	@Override
	public List<CourseName> courseNameList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from CourseName where coursetypeid = '"+1+"'");
		List<CourseName> courseNameList = query.list();
		session.close();
		return courseNameList;
	}
	@Override
	public CourseTrainee getCourseTrainingByCourseTypeID(int typeId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		CourseTrainee courseTrainee=new CourseTrainee();
		String sql ="select c.coursename, c.courseduration ,c.coursenameid, mgid.contentlinkinput ,mgid.contentnameinput from  coursename as c inner join managecoursecontent as mgid on mgid.coursetypeinput = c.coursetypeid where c.coursetypeid="+typeId;
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTraineeList =(List<Object[]>) query.list();
		session.close();
		if(courseTraineeList.size()>0){
			Object[] o=courseTraineeList.get(0);
			courseTrainee.setCourseName(o[0].toString());
			courseTrainee.setCourseDuration(o[1].toString());
			courseTrainee.setCourseTypeId(o[2].toString());
			courseTrainee.setContentLinkInput(o[3].toString());
			courseTrainee.setContentNameInput(o[4].toString());
			return courseTrainee;
		}else{
			return courseTrainee;
		}
		
	}	
	@Override
	public CourseName getCourseName(int profileId) {
		CourseName courseName= new CourseName();
		Session session = sessionFactory.openSession();
		String sql="select c.coursename,c.coursenameid,c.courseduration from coursename c,courseenrolleduser ceu where c.coursenameid=ceu.courseenrolleduserid and ceu.profileid="+profileId;
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseNameList =(List<Object[]>)query.list();
		session.close();
		if(courseNameList.size()>0){
			Object[] o=courseNameList.get(0);
			courseName.setCoursename( o[0].toString());
			courseName.setCoursenameid(Integer.parseInt(o[1].toString()));
			courseName.setCourseduration(o[2].toString());
			return courseName;	
		}else{
			return courseName;
		}
		
	}
	@Override
	public CourseName getCourseDetails(int loginId) {
		CourseName courseName= new CourseName();
		Session session = sessionFactory.openSession();
		String sql="select cn.coursename,cn.coursenameid,cn.courseduration from coursename cn,courseenrolled cnrld where cn.coursenameid=cnrld.coursenameid and cnrld.logindetails="+loginId;
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseNameList =(List<Object[]>)query.list();
		session.close();
		if(courseNameList.size()>0){
			Object[] o=courseNameList.get(0);
			courseName.setCoursename( o[0].toString());
			courseName.setCoursenameid(Integer.parseInt(o[1].toString()));
			courseName.setCourseduration(o[2].toString());
			return courseName;	
		}else{
			return courseName;
		}
		
	}
	@Override
	public List<FeedbackMaster> getFeedMasterList(int profileId) {
		Session session = sessionFactory.openSession();
		String profile="";
				if(profileId==3){
					profile="trainee";
				}else if(profileId==4){
					profile="trainer";
				}
				
		
		Query query = session.createSQLQuery("select feedbacktypeid,feedback from feedbackmaster where coursetype='"+profile+"'");
		List<FeedbackMaster> feedbackMasters = query.list();
		session.close();
		return feedbackMasters;
	}

	@Override
	public List<ManageTrainingPartner> trainingPartnerList() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> trainingPartnerList = query.list();
		session.close();
		return trainingPartnerList;
	}


	@Override
	public List<State> trainingCenterStateList() {
		List<State> st=null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql ="select s.stateid, s.statename  from  state as s  "+
					" inner join personalinformationtrainingpartner as pitp on pitp.trainingpartnerpermanentstate = s.stateid "+
					" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid  = pitp.trainingpartnername  ";
		Query query = session.createSQLQuery(sql);
		List<Object[]> trainingCenterStateList =(List<Object[]>) query.list();
		 st = new ArrayList<>();
		for(int i=0;i<trainingCenterStateList.size();i++){
			State stt = new State();
			
			Object[] o=trainingCenterStateList.get(i);
			stt.setStateId((int) o[0]);
			stt.setStateName(o[1].toString());
			st.add(stt);
			
		}
		session.close();
		System.out.println(st);
		return st;
	}
	@Override
	public String updateTrainee(RegistrationFormTrainee registrationFormTrainee , Integer ss) {
		
		Session session =sessionFactory.openSession();
		
		System.out.println("iddddd  "+ss);
		State ps = getState(registrationFormTrainee.getResState()); 
		State cs = getState(registrationFormTrainee.getResState());
		State bs = getState(registrationFormTrainee.getBussState());
		District pd = getDistrict(registrationFormTrainee.getResidentialDistrict());
		District cd = getDistrict(registrationFormTrainee.getResidentialDistrict());
		District bd = getDistrict(registrationFormTrainee.getBussDistrict());
		City pc = getCity(registrationFormTrainee.getResCity());
		City cc = getCity(registrationFormTrainee.getCorrespondenceCity());
		City bc = getCity(registrationFormTrainee.getBussCity());
		//Title tt = getTitle(registrationFormTrainee.getTitle());
		KindOfBusiness kob = getKid(registrationFormTrainee.getKindOfBusiness());
		PersonalInformationTrainee   personalInformationTrainee=(PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, ss);
		
	//	PersonalInformationTrainee personalInformationTrainee = new PersonalInformationTrainee();
		//personalInformationTrainee.setTitle(tt);
	System.out.println("this is pin code    "+registrationFormTrainee.getResPincode());	
	System.out.println("this is state     "+registrationFormTrainee.getResState());
	System.out.println(registrationFormTrainee.getBusinessAddressLine1());
		personalInformationTrainee.setBusinessAddressLine1(registrationFormTrainee.getBusinessAddressLine1());
		personalInformationTrainee.setBusinessAddressLine2(registrationFormTrainee.getBusinessAddressLine2());
		personalInformationTrainee.setBussCity(bc);
		personalInformationTrainee.setBussPincode(registrationFormTrainee.getBussPincode());
		personalInformationTrainee.setBussState(bs);
		personalInformationTrainee.setBussDistrict(bd);
		personalInformationTrainee.setCompanyName(registrationFormTrainee.getCompanyName());
		personalInformationTrainee.setCorrespondenceAddress1(registrationFormTrainee.getCorrespondenceAddress1());
		personalInformationTrainee.setCorrespondenceAddress2(registrationFormTrainee.getCorrespondenceAddress2());
		personalInformationTrainee.setCorrespondenceDistrict(cd);
		personalInformationTrainee.setCorrespondenceCity(cc);
		personalInformationTrainee.setCorrespondenceState(cs);
		personalInformationTrainee.setCorrespondencePincode(registrationFormTrainee.getCorrespondencePincode());
		personalInformationTrainee.setCorrespondenceState(adminDAO.getState(registrationFormTrainee.getCorrespondenceState()));
		personalInformationTrainee.setDesignation(registrationFormTrainee.getDesignation());
		personalInformationTrainee.setEmail(registrationFormTrainee.getEmail());
		personalInformationTrainee.setKindOfBusiness(kob);
		personalInformationTrainee.setMobile(registrationFormTrainee.getMobile());
	    personalInformationTrainee.setResCity(pc);
		personalInformationTrainee.setResidentialLine1(registrationFormTrainee.getResidentialAddressLine1());
		personalInformationTrainee.setResidentialLine2(registrationFormTrainee.getResidentialAddressLine2());
		personalInformationTrainee.setResPincode(registrationFormTrainee.getResPincode());
	personalInformationTrainee.setResidentialDistrict(pd);
	personalInformationTrainee.setResState(ps);
	personalInformationTrainee.setRegistrationNo(registrationFormTrainee.getRegistrationNo());
		
		
	//	session.createQuery("update com. ir.model.PersonalInformationTrainee set title='"+personalInformationTrainee.getTitle()+"', Email='"+personalInformationTrainee.getEmail()+"' ");
		
		
		session.update(personalInformationTrainee);
		session.beginTransaction().commit();
		
		session.close();
		return null;
	}


	/*@Override
	public String changePasswordTraineeSave(ChangePasswordForm changePasswordForm, int id) {
		System.out.println("change pwd dai impl");
		Session session =sessionFactory.openSession();
		System.out.println(changePasswordForm.getLoginid());
		PersonalInformationTrainee   personalInformationTrainee=(PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, Integer.parseInt(changePasswordForm.getLoginid()));
		System.out.println("id  "+ id);
		LoginDetails ld = new LoginDetails();
		ld.setPassword(changePasswordForm.getNewPassword());
		ld.setLoginId(changePasswordForm.getLoginidd());
		ld.setProfileId(3);
		ld.setStatus("A");
		session.update(personalInformationTrainee);
		session.beginTransaction().commit();
		session.close();
		return "created";
		
	}*/

	@Override
	public boolean changePasswordTraineeSave(ChangePasswordForm changePasswordForm, String id) {
	
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		//String idd=changePasswordForm.getLoginid();
		System.out.println("new pass   "+oldPassword);
		
		
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		
		
		return confirm;
	}

	@Override
	public long basicSave(CourseEnrolledUserForm courseEnrolledUserForm , String loginid, int personalinformationtraineeid ) {
		System.out.println("course enrolled");
		Session session =sessionFactory.openSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		long date = System.currentTimeMillis();
		System.out.println("roll nu  :"+date);
		System.out.println("loginid  :"+loginid);
		System.out.println("personalinformationtraineeid   :"+personalinformationtraineeid);
		System.out.println("TrainingCalendarId()   :"+courseEnrolledUserForm.getTrainingCalendarId());
		
		courseEnrolledUser.setLoginDetails(loginid);
		courseEnrolledUser.setProfileId(3);
		courseEnrolledUser.setTrainingCalendarId(courseEnrolledUserForm.getTrainingCalendarId());
		courseEnrolledUser.setRollno(date);
		courseEnrolledUser.setPaymentstatus("Pending");
		courseEnrolledUser.setEnrolledby("Trainee");
		
//		Integer ce =0;
		Integer ce =  (Integer) session.save(courseEnrolledUser);
		if(ce!=null&& ce.intValue()>0){
				PersonalInformationTrainee   personalInformationTrainee=(PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, personalinformationtraineeid);
				//personalInformationTrainee.setSteps(2);			
				session.update(personalInformationTrainee);
			session.beginTransaction().commit();
		}
		session.close();
		return date;
	}
	@Override
	public long advanceTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, String loginid,
			int personalinformationtraineeid) {
		System.out.println("course enrolled");
		Session session =sessionFactory.openSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		long date = System.currentTimeMillis();
		System.out.println("roll nu  :"+date);
		System.out.println("loginid  :"+loginid);
		System.out.println("personalinformationtraineeid   :"+personalinformationtraineeid);
		System.out.println("calander id is  "+courseEnrolledUserForm.getTrainingCalendarId());
		
		courseEnrolledUser.setLoginDetails(loginid);
		courseEnrolledUser.setProfileId(3);
		courseEnrolledUser.setTrainingCalendarId(courseEnrolledUserForm.getTrainingCalendarId());
		courseEnrolledUser.setRollno(date);
		courseEnrolledUser.setPaymentstatus("Pending");
		courseEnrolledUser.setEnrolledby("Trainee");
		
		Integer ce = (Integer) session.save(courseEnrolledUser);
		if(ce > 0){
			PersonalInformationTrainee   personalInformationTrainee=(PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, personalinformationtraineeid);
			//personalInformationTrainee.setSteps(2);			
			session.update(personalInformationTrainee);
		}
		session.beginTransaction().commit();
		session.close();
		return date;
	}
	@Override
	public long specialTraineeSave(CourseEnrolledUserForm courseEnrolledUserForm, String loginid,
			int personalinformationtraineeid) {
		Session session =sessionFactory.openSession();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		long date = System.currentTimeMillis();
		System.out.println("roll nu  :"+date);
		System.out.println("loginid  :"+loginid);
		System.out.println("personalinformationtraineeid   :"+personalinformationtraineeid);
		System.out.println("calander id is  "+courseEnrolledUserForm.getTrainingCalendarId());
		
		courseEnrolledUser.setLoginDetails(loginid);
		courseEnrolledUser.setProfileId(3);
		courseEnrolledUser.setTrainingCalendarId(courseEnrolledUserForm.getTrainingCalendarId());
		courseEnrolledUser.setRollno(date);
		courseEnrolledUser.setEnrolledby("Trainee");
		courseEnrolledUser.setPaymentstatus("Pending");
		
		Integer ce = (Integer) session.save(courseEnrolledUser);
		if(ce > 0){
			PersonalInformationTrainee   personalInformationTrainee=(PersonalInformationTrainee) session.load(PersonalInformationTrainee.class, personalinformationtraineeid);
			//personalInformationTrainee.setSteps(2);			
			session.update(personalInformationTrainee);
		}
		session.beginTransaction().commit();
		session.close();
		return date;
	}
	@Override
	public boolean changePasswordAssesorSave(ChangePasswordForm changePasswordForm, String id) {
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		//String idd=changePasswordForm.getLoginid();
		System.out.println("new pass   "+oldPassword);
		
		
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		
		
		return confirm;
	}
	public AdmitCardForm generateAdmitCard(int loginId, int profileId){
//		String str_query = "select ce.courseenrolleduserid "+
//				", cn.coursename as courseName,"+
//				" ctype.coursetype as category, "+
//				" pit.fathername as fatherName, titlename as title, pit.firstname ||' '|| pit.middlename ||' '|| pit.lastname  as name ,"+
//				" tcal.trainingcenter as trainingCenterCode,"+
//				" pitp.trainingpartnerpermanentline1||','|| pitp.trainingpartnerpermanentline2 as address,"+
//				" ce.rollno as rollNo "+
//				", district.districtname as city"+
//
//				" from courseenrolleduser ce "+
//
//				" inner join personalinformationtrainee pit on pit.logindetails = ce.courseenrolleduserid "+
//				" inner join title on title.titleId = pit.title "+
//				" inner join trainingcalendar tcal on tcal.trainingcalendarid = ce.trainingcalendarid "+
//				" inner join personalinformationtrainingpartner pitp on pitp.personalinformationtrainingpartnerid = tcal.trainingcenter "+
//				" inner join district district on district.districtid = pitp.trainingpartnerpermanentdistrict "+
//				" inner join coursename cn on cn.coursenameid = tcal.coursename "+
//				" inner join coursetype ctype on ctype.coursetypeid = cn.coursetypeid ";
		
		String str_query = "select cn.coursename as courseName,"+
				" ctype.coursetype as category, "+
				" pit.fathername as fatherName, titlename as title, pit.firstname ||' '|| pit.middlename ||' '|| pit.lastname  as name ,"+
				//" pit.correspondenceaddress1 || ' '|| pit.correspondenceaddress2 as address ,"+
				" tcal.trainingcenter as trainingCenterCode,"+
				" pitp.trainingpartnerpermanentline1||','|| pitp.trainingpartnerpermanentline2 as address,"+
				" ce.rollno as rollNo "+
				", district.districtname as city"+

				" from courseenrolleduser ce "+

				" inner join personalinformationtrainee pit on pit.logindetails = ce.courseenrolleduserid "+
				" inner join title on title.titleId = pit.title "+
				" inner join trainingcalendar tcal on tcal.trainingcalendarid = ce.trainingcalendarid "+
				" inner join personalinformationtrainingpartner pitp on pitp.personalinformationtrainingpartnerid = tcal.trainingcenter "+
				" inner join district district on district.districtid = pitp.trainingpartnerpermanentdistrict "+
				" inner join coursename cn on cn.coursenameid = tcal.coursename "+
				" inner join coursetype ctype on ctype.coursetypeid = cn.coursetypeid ";

		
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			AdmitCardForm admitcard = new AdmitCardForm();
			Query query = session.createSQLQuery(str_query);
			List records = query.list();
			try{
			if(records.size() > 0){
				admitcard = (AdmitCardForm)records.get(0);
			}
			}catch(Exception e){
				System.out.println("Exception while retrieving admit card details : " + e.getMessage());
			}
		return admitcard;
	}
	}
	


