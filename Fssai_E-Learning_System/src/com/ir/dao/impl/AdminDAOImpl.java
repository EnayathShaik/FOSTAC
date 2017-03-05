package com.ir.dao.impl;


import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AdminDAO;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionForm;
import com.ir.form.AssessorUserManagementForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.CityForm;
import com.ir.form.ContactTrainee;
import com.ir.form.DistrictForm;
import com.ir.form.ManageAssessmentAgencyForm;
import com.ir.form.ManageCourse;
import com.ir.form.ManageCourseContentForm;
import com.ir.form.ManageTrainingPartnerForm;
import com.ir.form.RegionForm;
import com.ir.form.StateForm;
import com.ir.form.TraineeUserManagementForm;
import com.ir.form.TrainerUserManagementForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.TrainingCenterUserManagementForm;
import com.ir.model.AdminUserManagement;
import com.ir.model.AssessmentQuestion;
import com.ir.model.AssessorUserManagement;
import com.ir.model.City;
import com.ir.model.ContactTraineee;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.Region;
import com.ir.model.State;
import com.ir.model.TrainingCalendar;
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainer.TrainerAssessmentEvaluation;
import com.ir.service.PageLoadService;
import com.ir.util.ChangePasswordUtility;
import com.ir.util.EncryptionPasswordANDVerification;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendContectMail;
import com.ir.util.SendMail;
import com.zentech.logger.ZLogger;
@Repository
public class AdminDAOImpl implements AdminDAO {

	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	@Qualifier("state")
	private State state;
	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	@Autowired
	@Qualifier("district")
	private District district;
	@Autowired
	@Qualifier("city")
	private City city;
	@Autowired
	@Qualifier("courseTypeS")
	private CourseType courseTypeS;
	@Autowired
	@Qualifier("courseNameS")
	private CourseName courseNameS;
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;


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
	@Transactional
	@Override
	public CourseType getCourseType(int id){
		Session session = sessionFactory.getCurrentSession();
		CourseType ct = (CourseType)session.load(CourseType.class, id);
		return  ct;
		
	}
	@Override
	public CourseName getCourseName(int id){
		Session session = sessionFactory.getCurrentSession();
		CourseName cn = (CourseName)session.load(CourseName.class, id);
		return cn;
		
	}
	
	@Override
	public String stateMasterSave(StateForm stateForm) {
		Session session = sessionFactory.getCurrentSession();
		State state = new State();
		state.setStateName(stateForm.getStateName().replaceAll("%20", " "));
		state.setStatus(stateForm.getStatus());
		Integer stateIdd = null ;
		String sql = "select * from state where upper(stateName) like '"+stateForm.getStateName().replaceAll("%20", " ").toUpperCase()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() >0){
			session.close();
			return "error";
		}else{
			stateIdd = (Integer)session.save(state);
			if(stateIdd != 0 && stateIdd  != 0){
				return "created";
			}else{
				return "error";
			}
		}
	}

	@Override
	public State getState(int id){
		Session s = sessionFactory.getCurrentSession();
		State ss = (State)s.load(State.class, id);
		return ss;
	}
	
	
	@Override
	public List<State> stateList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from State where status = 'A'");
		List<State> stateList = query.list();
		return stateList;
	}


	@Override
	public String districtMasterSave(DistrictForm districtForm) {
		Session session = sessionFactory.getCurrentSession();
		String district1 = "select * from district where upper(districtname) ='"+districtForm.getDistrictName().replaceAll("%20", " ").toUpperCase()+"'";
		//String sql = "select s.stateId from district as d inner join state as s on s.stateid = d.stateid where "+
		//			 " s.stateId='" + districtForm.getStateId()+ "' and d.districtname='" +districtForm.getDistrictName().toUpperCase() +"'";
		Query query = session.createSQLQuery(district1);
		
		State s = (State) session.load(State.class , districtForm.getStateId());
		
		List l = query.list();
		if(l != null && l.size() > 0){
			return "District already exists !!!";
		}else{
			District district = new District();
			district.setDistrictName(districtForm.getDistrictName());
			district.setStatus(districtForm.getStatus());
			district.setState(s);
			Session session1 = sessionFactory.getCurrentSession();
			Integer districtId = (Integer)session1.save(district);
			if(districtId != 0 && districtId  != null){
				return "created";
			}else{
				return "error";
			}
		}
		
	}

	@Override
	public String cityMasterSave(CityForm cityForm) {
		Session session = sessionFactory.getCurrentSession();
		
		District d = (District) session.load(District.class, cityForm.getDistrictId());
		City city = new City();
		city.setCityName(cityForm.getCityName());
		city.setDistrict(d);
		city.setStatus(cityForm.getStatus());
		
		Integer cityIdd = null ;
		String sql = "select * from city where upper(cityName) = '"+cityForm.getCityName().replaceAll("%20", " ").toUpperCase()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() >0){
			session.close();
			return "error";
		}else{
			cityIdd = (Integer)session.save(city);
			if(cityIdd != 0 && cityIdd  != 0){
				return "created";
			}else{
				return "error";
			}
		}
	}


	@Override
	public String regionMasterSave(RegionForm regionForm) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from region where regionname = '"+regionForm.getRegionName()+"' and districtid = '"+regionForm.getDistrictId()+"' and status = '"+regionForm.getStatus()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		Integer stateId = null ;
		if(l!= null && l.size() > 0){
			return "Oops";
		}else{
			Region region= new Region();
			region.setRegionName(regionForm.getRegionName());
			region.setDistrictId(regionForm.getDistrictId());
			region.setCityId(regionForm.getCityId());
			region.setStateId(regionForm.getStateId());
			region.setStatus(regionForm.getStatus());
			stateId = (Integer)session.save(region);
			if(stateId != 0 && stateId  != 0){
				return "created";
			}else{
				return "error";
			}
		}	
	}


	@Override
	public List<CourseName> courseNameList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName  where status = 'A'");
		List<CourseName> courseNameList = query.list();
		return courseNameList;
	}


	@Override
	public String manageCourse(ManageCourse manageCourse) {
		Session session = sessionFactory.getCurrentSession();
		//Get Next Seq
		
		String sql = "select coalesce(max(seqNo) + 1,1) from coursename";
		int maxId = 0 ;
		Query maxIDList = session.createSQLQuery(sql);
		List list = maxIDList.list();
		System.out.println(list.size());
		new ZLogger("manageCourse", "list.size() "+list.size(), "AdminDAOImpl.java");
		if(list.size() > 0){
			maxId = (int) list.get(0);
			//eligible = (String) list.get(0);
		}
		
		CourseType ct = (CourseType) session.load(CourseType.class, manageCourse.getCourseType());
		String coursetype = ct.getCourseType();
		CourseName courseName= new CourseName();
		courseName.setCourseduration(manageCourse.getDuration());
		courseName.setCoursename(manageCourse.getCourseName());
		courseName.setCourseTypeS(ct);
		courseName.setStatus(manageCourse.getStatus());
		courseName.setPaidunpaid(manageCourse.getFreePaid());
		courseName.setModeOfTraining(manageCourse.getModeOfTraining());
		if(manageCourse != null && manageCourse.getCourseName() != null && manageCourse.getCourseName().length() > 1
				&& coursetype != null && coursetype.length() > 1){
			courseName.setCourseCode(ct.getCourseType().substring(0, 1).toUpperCase()+ manageCourse.getCourseName().substring(0, 2).toUpperCase()+StringUtils.leftPad(String.valueOf(maxId), 3, "0"));
			
			courseName.setSeqNo(maxId);
		}
		
		
		
		
		
		if(manageCourse.getOnline()==null||manageCourse.getOnline().equals("false")){
			courseName.setOnline("Nil");
		}else{
			courseName.setOnline("Online");
		}
		if(manageCourse.getClassroom()==null||manageCourse.getClassroom().equalsIgnoreCase("false")){
			courseName.setClassroom("Nil");
		}else{
			courseName.setClassroom("Classroom");
		}
		
		courseName.setCreatedby(2);
		courseName.setUpdatedby(2);
		
			
		
		String sqlInsert ="select ct.coursetype , cn.coursename "+
					" from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid "+
					" where cn.coursetypeid='"+ manageCourse.getCourseType()+"' and cn.coursename= '"+ manageCourse.getCourseName()+"'";
		Integer courseNameId = null ;
		Query query = session.createSQLQuery(sqlInsert);
		List l = query.list();
		if(l != null && l.size() >0){
			return "error";
		}else{
			courseNameId = (Integer)session.save(courseName);
			System.out.println(courseName.getClassroom());
			if(courseNameId != 0 && courseNameId  != 0){
				return "created";
			}else{
				return "error";
			}
		}	
	}


	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}


	@Override
	public String manageTrainingPartnerSave(ManageTrainingPartnerForm manageTrainingPartnerForm) {
		Session session = sessionFactory.getCurrentSession();
		PasswordGenerator passwordGenerator = new PasswordGenerator(6);
		char[] pass = passwordGenerator.get();
		String passwordString = String.valueOf(pass);
		String encryprPassword = null;
		try{
			EncryptionPasswordANDVerification encryptionPasswordANDVerification = new EncryptionPasswordANDVerification();
			encryprPassword = encryptionPasswordANDVerification.encryptPass(passwordString);
			
		}catch(NoSuchAlgorithmException e){
			new ZLogger("manageTrainingPartnerSave", "Exception while  "+e.getMessage(), "AdminDAOImpl.java");
		}
		
		
		String TPPrefix = "TP"+   manageTrainingPartnerForm.getTrainingPartnerName().toUpperCase().substring(0, 3);
		//String nextSequenceUserID  =  GenerateUniqueID.getNextCombinationId(TPPrefix, "manageTrainingPartner", "00");
		String nextSequenceUserID = pageLoadService.getNextCombinationId(TPPrefix, "manageTrainingPartner", "00");
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setLoginId(nextSequenceUserID);
		loginDetails.setPassword(passwordString);
		loginDetails.setEncrypted_Password(encryprPassword);
		loginDetails.setIsActive(manageTrainingPartnerForm.getStatus().equalsIgnoreCase("A")? "Y" : "N");
		loginDetails.setStatus("A");
		loginDetails.setProfileId(7);
		
		State s = getState(manageTrainingPartnerForm.getState());
		District d = getDistrict(manageTrainingPartnerForm.getDistrict());
		City c = getCity(manageTrainingPartnerForm.getCity());
		
		ManageTrainingPartner manageTrainingPartner = new ManageTrainingPartner();
		manageTrainingPartner.setPAN(manageTrainingPartnerForm.getPAN());
		manageTrainingPartner.setTrainingPartnerName(manageTrainingPartnerForm.getTrainingPartnerName());
		manageTrainingPartner.setUserId(nextSequenceUserID);
		manageTrainingPartner.setWebsiteUrl(manageTrainingPartnerForm.getWebsiteUrl());
		manageTrainingPartner.setHeadOfficeDataAddress1(manageTrainingPartnerForm.getHeadOfficeDataAddress1());
		manageTrainingPartner.setHeadOfficeDataAddress2(manageTrainingPartnerForm.getHeadOfficeDataAddress2());
		manageTrainingPartner.setPin(manageTrainingPartnerForm.getPin());
		manageTrainingPartner.setDistrict(d);
		manageTrainingPartner.setCity(c);
		manageTrainingPartner.setState(s);
		manageTrainingPartner.setEmail(manageTrainingPartnerForm.getEmail());
		manageTrainingPartner.setLoginDetails(loginDetails);
		Integer manageTrainingPartnerIdd = (Integer)session.save(manageTrainingPartner);
		
		new ZLogger("manageTrainingPartnerSave", "all insert done", "AdminDAOImpl.java");
		new ZLogger("manageTrainingPartnerSave", "saved login "+ manageTrainingPartnerIdd, "AdminDAOImpl.java");
		if(manageTrainingPartnerIdd  != 0){
			SendMail sendMail = new SendMail();
			sendMail.mailProperty(passwordString, manageTrainingPartnerForm.getEmail(), manageTrainingPartnerForm.getTrainingPartnerName()+ " " + manageTrainingPartnerForm.getUserId());
			return passwordString+"&"+nextSequenceUserID;
		}else{
			return passwordString+"&"+nextSequenceUserID;
		}
	}


	@Override
	public String manageAssessmentAgencySave(ManageAssessmentAgencyForm manageAssessmentAgencyForm) {
		Session session = sessionFactory.getCurrentSession();
		PasswordGenerator passwordGenerator = new PasswordGenerator(6);
		char[] pass = passwordGenerator.get();
		String passwordString = String.valueOf(pass);
		String encryprPassword = null;
		try{
			EncryptionPasswordANDVerification encryptionPasswordANDVerification = new EncryptionPasswordANDVerification();
			encryprPassword = encryptionPasswordANDVerification.encryptPass(passwordString);
			
		}catch(NoSuchAlgorithmException e){
			new ZLogger("manageAssessmentAgencySave", "Exception while manageAssessmentAgencySave "+e.getMessage(), "AdminDAOImpl.java");
		}
		
		State s = getState(manageAssessmentAgencyForm.getStateId());
		District d = getDistrict(manageAssessmentAgencyForm.getDistrict());
		City c = getCity(manageAssessmentAgencyForm.getCity());
		
		ManageAssessmentAgency manageAssessmentAgency = new ManageAssessmentAgency();
		String APPrefix = "AP"+   manageAssessmentAgencyForm.getAssessmentAgencyName().toUpperCase().substring(0, 3);
		String nextSequenceUserID  =  pageLoadService.getNextCombinationId(APPrefix, "manageAssessmentAgency", "00");
		
		LoginDetails loginDetails = new LoginDetails();
		loginDetails.setLoginId(nextSequenceUserID);
		loginDetails.setPassword(passwordString);
		loginDetails.setEncrypted_Password(encryprPassword);
		loginDetails.setProfileId(8);
		loginDetails.setStatus("A");
		loginDetails.setIsActive(manageAssessmentAgencyForm.getStatus().equalsIgnoreCase("A")? "Y" : "N");
		manageAssessmentAgency.setAgencyUniqueID(nextSequenceUserID);
		manageAssessmentAgency.setPAN(manageAssessmentAgencyForm.getPAN());
		manageAssessmentAgency.setAssessmentAgencyName(manageAssessmentAgencyForm.getAssessmentAgencyName());
		manageAssessmentAgency.setWebsiteUrl(manageAssessmentAgencyForm.getWebsiteUrl());
		manageAssessmentAgency.setHeadOfficeDataAddress1(manageAssessmentAgencyForm.getHeadOfficeDataAddress1());
		manageAssessmentAgency.setHeadOfficeDataAddress2(manageAssessmentAgencyForm.getHeadOfficeDataAddress2());
		manageAssessmentAgency.setPin(manageAssessmentAgencyForm.getPin());
		manageAssessmentAgency.setDistrict(d);
		manageAssessmentAgency.setCity(c);
		manageAssessmentAgency.setEmail(manageAssessmentAgencyForm.getEmail());
		manageAssessmentAgency.setLoginDetails(loginDetails);
		manageAssessmentAgency.setState(s);
		Integer manageTrainingPartnerIdd = (Integer)session.save(manageAssessmentAgency);
		if(manageTrainingPartnerIdd  != 0){
			SendMail sendMail = new SendMail();
			sendMail.mailProperty(passwordString, manageAssessmentAgencyForm.getEmail(), manageAssessmentAgencyForm.getAssessmentAgencyName()+ " " + manageAssessmentAgencyForm.getUserId());

			return passwordString+"&"+nextSequenceUserID;
		}else{
			return passwordString+"&"+nextSequenceUserID;
		}
	}


	@Override
	public List<PersonalInformationTrainee> traineeUserManagementSearch(TraineeUserManagementForm traineeUserManagementForm) {
		Session session = sessionFactory.getCurrentSession();
		String FirstName = traineeUserManagementForm.getFirstName();
		String MiddleName = traineeUserManagementForm.getMiddleName();
		String LastName = traineeUserManagementForm.getLastName() ;
		String AadharNumber = traineeUserManagementForm.getAadharNumber();
		String status = traineeUserManagementForm.getStatus();
		
		if(FirstName.length() == 0){
			FirstName = "%";
		}
		if(MiddleName.length()==0)
		{
			MiddleName="%";
		}
		if(LastName.length()==0)
		{
			LastName="%";
		}
		if(AadharNumber.length()==0)
		{
			AadharNumber="%";
		}
		if(status != null && status.equals("0"))
		{
			status="%";
		}
		
		String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
		String like= " where upper(pitp.FirstName) like '"+FirstName.toUpperCase()+"' and pitp.MiddleName like '"+MiddleName+"' and pitp.LastName like '"+LastName+"' and "
				+ "pitp.AadharNumber like '"+AadharNumber +"' and ld.status like '"+ status+"'";
		String select = "pitp.personalInformationTraineeId,ld.loginid,pitp.FirstName,pitp.MiddleName,pitp.LastName,pitp.AadharNumber,pitp.logindetails,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";
		
		String sql= "Select "+ select + "  from PersonalInformationTrainee as pitp "+ join + like;
		Query query = session.createSQLQuery(sql);
		List<PersonalInformationTrainee> list = query.list();
		new ZLogger("traineeUserManagementSearch", "list  "+ list, "AdminDAOImpl.java");
		if( list.size() > 0){
			return list;
		}else{
			list = null;
			return list;
		}
	}

	@Override
	public List<PersonalInformationTrainer> trainerUserManagementSearch(TrainerUserManagementForm trainerUserManagementForm) {
		Session session = sessionFactory.getCurrentSession();
		String FirstName = trainerUserManagementForm.getFirstName();
		String MiddleName = trainerUserManagementForm.getMiddleName();
		String LastName = trainerUserManagementForm.getLastName() ;
		String AadharNumber = trainerUserManagementForm.getAadharNumber();
		String status = trainerUserManagementForm.getStatus();
		
		if(FirstName.length() == 0){
			FirstName = "%";
		}
		if(MiddleName.length()==0)
		{
			MiddleName="%";
		}
		if(LastName.length()==0)
		{
			LastName="%";
		}
		if(AadharNumber.length()==0)
		{
			AadharNumber="%";
		}
		if(status.equals("0"))
		{
			status="%";
		}
		
		String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
		String like= " where upper(pitp.FirstName) like '"+FirstName.toUpperCase()+"' and pitp.MiddleName like '"+MiddleName+"' and pitp.LastName like '"+LastName+"' and "
				+ "pitp.AadharNumber like '"+AadharNumber +"' and ld.status like '"+ status+"'";
		String select = "pitp.personalInformationTrainerId,ld.loginid,pitp.FirstName,pitp.MiddleName,pitp.LastName,pitp.AadharNumber,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";
		
		String sql= "Select "+ select + "  from PersonalInformationTrainer as pitp "+ join + like;
		Query query = session.createSQLQuery(sql);
		List<PersonalInformationTrainer> list = query.list();
		new ZLogger("trainerUserManagementSearch", "list  "+ list, "AdminDAOImpl.java");
		if( list.size() > 0){
			return list;
		}else{
			new ZLogger("trainerUserManagementSearch", "list size null", "AdminDAOImpl.java");
			list = null;
			return list;
		}
	}
	
	@Override
	public List<PersonalInformationAssessor> assessorUserManagementSearch(AssessorUserManagementForm assessorUserManagementForm,Integer profileid,Integer userID) {
		Session session = sessionFactory.getCurrentSession();
		String FirstName = assessorUserManagementForm.getFirstName();
		String MiddleName = assessorUserManagementForm.getMiddleName();
		String LastName = assessorUserManagementForm.getLastName() ;
		String AadharNumber = assessorUserManagementForm.getAadharNumber();
		String status = assessorUserManagementForm.getStatus();
		
		if(FirstName.length() == 0){
			FirstName = "%";
		}
		if(MiddleName.length()==0)
		{
			MiddleName="%";
		}
		if(LastName.length()==0)
		{
			LastName="%";
		}
		if(AadharNumber.length()==0)
		{
			AadharNumber="%";
		}
		if(status.equals("0"))
		{
			status="%";
		}
		StringBuffer userBuffer = new StringBuffer();
		if(profileid == 8){
			int perAssessorAgencyID = 0;
			String sql = "select manageassessmentagencyid from manageassessmentagency where logindetails ="
					+ userID;
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			perAssessorAgencyID = (Integer) list.get(0);
			userBuffer.append(" AND pitp.assessmentagencyname="+perAssessorAgencyID);
		}
		String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
		String like= " where upper(pitp.FirstName) like '"+FirstName.toUpperCase()+"' and pitp.MiddleName like '"+MiddleName+"' and pitp.LastName like '"+LastName+"' and "
				+ "pitp.AadharNumber like '"+AadharNumber +"' and pitp.AadharNumber  like '"+ AadharNumber+"'";
		
		like = like + userBuffer.toString();
		String select = "pitp.personalInformationAssessorId,ld.loginid,pitp.FirstName,pitp.MiddleName,pitp.LastName,pitp.AadharNumber,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";
		
		String sql= "Select "+ select + "  from PersonalInformationAssessor as pitp "+ join + like;
		Query query = session.createSQLQuery(sql);
		List<PersonalInformationAssessor> list = query.list();
		new ZLogger("assessorUserManagementSearch", "list size "+list.size(), "AdminDAOImpl.java");
		if( list.size() > 0){
			new ZLogger("assessorUserManagementSearch", "list size gt thaan 0", "AdminDAOImpl.java");
			return list;
		}else{
			new ZLogger("assessorUserManagementSearch", "list size null", "AdminDAOImpl.java");
			list = null;
			return list;
		}
	}
	
	@Override
	public List<PersonalInformationTrainingPartner> trainingCenterUserManagementSearch(TrainingCenterUserManagementForm trainingCenterUserManagementForm,Integer profileid,Integer userID) {
		Session session = sessionFactory.getCurrentSession();
		String FirstName = trainingCenterUserManagementForm.getFirstName();
		String MiddleName = trainingCenterUserManagementForm.getMiddleName();
		String LastName = trainingCenterUserManagementForm.getLastName() ;
		String PanNumber = trainingCenterUserManagementForm.getPanNumber();
		String status = trainingCenterUserManagementForm.getStatus();
		
		if(FirstName.length() == 0){
			FirstName = "%";
		}
		if(MiddleName.length()==0)
		{
			MiddleName="%";
		}
		if(LastName.length()==0)
		{
			LastName="%";
		}
		
		if(PanNumber == null)
		{
			PanNumber="%";
		}
		if(status.equals("0"))
		{
			status="%";
		}
		StringBuffer userBuffer = new StringBuffer();
		if(profileid == 7){
			int perTrainingPartnerID = 0;
			String sql = "select managetrainingpartnerid from managetrainingpartner where logindetails ="
					+ userID;
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			perTrainingPartnerID = (Integer) list.get(0);
			userBuffer.append(" AND pitp.trainingpartnername="+perTrainingPartnerID);
		}
		String join = " inner join loginDetails as ld on pitp.loginDetails = ld.id";
		String like= " where upper(pitp.FirstName) like '"+FirstName.toUpperCase()+"' and pitp.MiddleName like '"+MiddleName+"' and pitp.LastName like '"+LastName+"' and "
				+ "pitp.PAN like '"+PanNumber +"' and ld.status like '"+ status+"'";
		like = like + userBuffer.toString();
		String select = "pitp.personalInformationTrainingPartnerId,ld.loginid,pitp.FirstName,pitp.MiddleName,pitp.LastName,pitp.PAN,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";
		
		String sql= "Select "+ select + "  from PersonalInformationTrainingPartner as pitp "+ join + like;
		Query query = session.createSQLQuery(sql);
		List<PersonalInformationTrainingPartner> list = query.list();
		if( list.size() > 0){
			new ZLogger("trainingCenterUserManagementSearch", "list size gt thaan 0", "AdminDAOImpl.java");
			return list;
		}else{
			new ZLogger("trainingCenterUserManagementSearch", "list size null", "AdminDAOImpl.java");
			list = null;
			return list;
		}
	}


	@Override
	public List<AdminUserManagement> adminUserManagementSearch() {
		new ZLogger("adminUserManagementSearch", "inside adminUserManagementSearch", "AdminDAOImpl.java");
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AdminUserManagement.class);
		List<AdminUserManagement> list = criteria.list();
		if( list.size() > 0){
			return list;
		}else{
			return list;
		}
	}


	@Override
	public String adminUserManagementSave(AdminUserManagementForm adminUserManagementForm) {
		new ZLogger("adminUserManagementSave", "inside adminUserManagementSave", "AdminDAOImpl.java");
		Session session = sessionFactory.getCurrentSession();
		String sql = "select * from adminusermanagement as aum inner join logindetails as ld on ld.id = aum.logindetails where loginid = '"+adminUserManagementForm.getUserId()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() > 0){
			return "error";
		}else{
			LoginDetails loginDetails = new LoginDetails();
			loginDetails.setLoginId(adminUserManagementForm.getUserId());
			loginDetails.setPassword("Password");
			loginDetails.setProfileId(2);
			loginDetails.setStatus("A");
			
			AdminUserManagement adminUserManagement = new AdminUserManagement();
			adminUserManagement.setUserId(adminUserManagementForm.getUserId());
			adminUserManagement.setAadharNumber(adminUserManagementForm.getAadharNumber());
			adminUserManagement.setFirstName(adminUserManagementForm.getFirstName());
			adminUserManagement.setLastName(adminUserManagementForm.getLastName());
			adminUserManagement.setMiddleName(adminUserManagementForm.getMiddleName());
			adminUserManagement.setLoginDetails(loginDetails);
			Integer adminUserManagementIdd = (Integer)session.save(adminUserManagement);
			if(adminUserManagementIdd != 0 ){
				return "created";
			}else{
				return "error";
			}
		}
	}


	@Override
	public String manageCourseContentSearch(ManageCourseContentForm manageCourseContentForm) {
		String contentLocation = manageCourseContentForm.getContentLocation();
		int courseType = manageCourseContentForm.getCourseType();
		int courseName = manageCourseContentForm.getCourseName();
		String modeOfTraining = manageCourseContentForm.getModeOfTraining();
		String contentType = manageCourseContentForm.getContentType();
		String contentLink = manageCourseContentForm.getContentLink();
		String contentName = manageCourseContentForm.getContentName();
		
		Session session = sessionFactory.getCurrentSession();
	
		Criteria criteria = session.createCriteria(ManageCourseContent.class);
		criteria.add(Restrictions.eq("contentLocationInput", contentLocation));
		criteria.add(Restrictions.eq("courseTypeInput", courseType));
		criteria.add(Restrictions.eq("courseNameInput", courseName));
		criteria.add(Restrictions.eq("contentNameInput", contentName));
		
		List l = criteria.list();
		if(l != null && l.size() > 0){
			session.close();
			return "error";
		}else{
			Session session1 = sessionFactory.getCurrentSession();
			ManageCourseContent mcc = new ManageCourseContent();
			mcc.setContentLocationInput(contentLocation);
			mcc.setCourseTypeInput(courseType);
			mcc.setCourseNameInput(courseName);
			mcc.setModeOfTrainingInput(modeOfTraining);
			mcc.setContentTypeInput(contentType);
			mcc.setContentLinkInput(contentLink);
			mcc.setContentNameInput(contentName);
			int mccId = (Integer)session1.save(mcc);
			if(mccId > 0){
				return "created";
			}else{
				return "error";
			}
		}
		
		
	}


	@Override
	public List<ManageTrainingPartner> trainingPartnerList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> trainingPartnerList = query.list();
		return trainingPartnerList;
	}


	@Override
	public List<PersonalInformationTrainer> trainingNameList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PersonalInformationTrainer");
		List<PersonalInformationTrainer> trainingNameList = query.list();
		return trainingNameList;
	}


	@Override
	public String assessorUserManagementSave(AssessorUserManagementForm assessorUserManagementForm) {
		Session session = sessionFactory.getCurrentSession();
		String sqlInsert ="select ld.loginid  , aum.aadharnumber from assessorusermanagement as aum "+
				  " inner join logindetails as ld on ld.id = aum.logindetails ";
		Query query = session.createSQLQuery(sqlInsert);
		List l = query.list();
		if(l != null && l.size() >0){
			session.close();
			return "error";
		}else{
			LoginDetails loginDetails = new LoginDetails();
			loginDetails.setLoginId(assessorUserManagementForm.getUserId());
			loginDetails.setPassword("Password");
			loginDetails.setProfileId(8);
			loginDetails.setStatus("A");
			
			AssessorUserManagement assessorUserManagement = new AssessorUserManagement();
			assessorUserManagement.setAadharNumber(assessorUserManagementForm.getAadharNumber());
			assessorUserManagement.setFirstName(assessorUserManagementForm.getFirstName());
			assessorUserManagement.setLastName(assessorUserManagementForm.getLastName());
			assessorUserManagement.setMiddleName(assessorUserManagementForm.getMiddleName());
			assessorUserManagement.setLoginDetails(loginDetails);
			Integer assessorUserManagementIdd = (Integer)session.save(assessorUserManagement);
			if(assessorUserManagementIdd != 0 ){
				return "created";
			}else{
				return "error";
			}
		}		
	}


	@Override
	public List<District> districtList() {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery("from District  where status = 'A'");
				List<District> districtList = query.list();
				return districtList;
	}


	@Override
	public String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select max(seqNo) + 1 from trainingcalendar";
		int maxId = 0 ;
		Query maxIDList = session.createSQLQuery(sql);
		List list = maxIDList.list();
		if(list.size() > 0){
			maxId = (int) list.get(0);
			//eligible = (String) list.get(0);
		}
		TrainingCalendar tc = new TrainingCalendar();
		
		tc.setCourseType(trainingCalendarForm.getCourseType());
		tc.setCourseName(trainingCalendarForm.getCourseName());
		tc.setTrainingPartner(trainingCalendarForm.getTrainingPartner());
		tc.setTrainingCenter(trainingCalendarForm.getTrainingCenter());
		tc.setTrainingDate(trainingCalendarForm.getTrainingStartDate());
		tc.setTrainingTime(trainingCalendarForm.getTrainingEndDate());
		tc.setTrainerName(trainingCalendarForm.getTrainerName());
		tc.setAssessmentDate(trainingCalendarForm.getTrainingStartDate());
		tc.setAssessmentTime(trainingCalendarForm.getTrainingEndDate());
		CourseName courseName = (CourseName) session.load(CourseName.class, trainingCalendarForm.getCourseName());
		if(courseName != null && courseName.getCourseCode() != null && courseName.getCourseCode().length() > 1){
			tc.setBatchCode(courseName.getCourseCode()+"/"+StringUtils.leftPad(String.valueOf(maxId), 5, "0"));
			tc.setSeqNo(maxId);
		}
		int i = (Integer) session.save(tc);
		if(i >0){
			return "created";
		}else{
			return "error";
		}	
	}

	@Override
	public String manageAssessmentQuestionsSave(AssessmentQuestionForm assessmentQuestionForm) {
		Session session = sessionFactory.getCurrentSession();
		AssessmentQuestion assessmentQuestion = null;
		if(assessmentQuestionForm.getId() <= 0){
			assessmentQuestion = new AssessmentQuestion();
		}else{
			assessmentQuestion = (AssessmentQuestion) session
					.load(AssessmentQuestion.class, assessmentQuestionForm.getId());
		}
		
		CourseType ct = getCourseType(assessmentQuestionForm.getCourseTypeId());
		CourseName cn = getCourseName(assessmentQuestionForm.getCourseName());
		
		assessmentQuestion.setCourseType(ct);
		assessmentQuestion.setCourseName(cn);
		assessmentQuestion.setQuestionNumber(assessmentQuestionForm.getQuestionNumber());
		assessmentQuestion.setQuestionHint(assessmentQuestionForm.getQuestionHint());
		assessmentQuestion.setQuestionTitle(assessmentQuestionForm.getQuestionTitle());
		assessmentQuestion.setNoOfOption(assessmentQuestionForm.getNoOfOption());
		assessmentQuestion.setOptionOne(assessmentQuestionForm.getOptionOne());
		assessmentQuestion.setOptionTwo(assessmentQuestionForm.getOptionTwo());
		assessmentQuestion.setOptionThree(assessmentQuestionForm.getOptionThree());
		assessmentQuestion.setOptionFour(assessmentQuestionForm.getOptionFour());
		assessmentQuestion.setOptionFive(assessmentQuestionForm.getOptionFive());
		assessmentQuestion.setOptionSix(assessmentQuestionForm.getOptionSix());
		assessmentQuestion.setCorrectAnswer(assessmentQuestionForm.getCorrectAnswer());
		assessmentQuestion.setAssessmentType("Post");
		
		Integer assessmentQuestionIdd = null ;
		
		String where = " where coursetype = '"+assessmentQuestionForm.getCourseTypeId()+"' and coursename = '"+assessmentQuestionForm.getCourseName()+"' and questionTitle = '"+assessmentQuestionForm.getQuestionTitle()+"'";
		String sql = "select assessmenttype from AssessmentQuestion " + where ;
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() > 0 && assessmentQuestionForm.getId() <= 0){
			session.close();
			return "already";
		}else{
			if(assessmentQuestionForm.getId() > 0){
				//assessmentQuestion.setAssessmentQuestionId(assessmentQuestionForm.getId());
				session.update(assessmentQuestion);
				assessmentQuestionIdd = assessmentQuestionForm.getId();
			}else{
				assessmentQuestionIdd = (Integer)session.save(assessmentQuestion);
			}
			
			if(assessmentQuestionIdd != 0 ){
				return "created";
			}else{
				return "already";
			}
		}
	}
// Rishi
	@Override
	public boolean trainingadminForm(ChangePasswordForm changePasswordForm, String id) {
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		
		
		return confirm;
	}
	
@Override
	public boolean trainingPartnerPass(ChangePasswordForm changePasswordForm, String id) {
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();

		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);		
		return confirm;
	}

	@Override
	public String contactTrainigPartnerSave(ContactTrainee contactTrainee, String id) {
		SendContectMail traineeMaail=null;
		 traineeMaail = new SendContectMail();
			
		Session session = sessionFactory.getCurrentSession();
		ContactTraineee contactTrainerModel = new ContactTraineee();
		String email=contactTrainee.getEmailAddress();
		String msg=contactTrainee.getMessageDetails();
		traineeMaail.mailProperty(msg, email,id);
		new ZLogger("contactTrainigPartnerSave", "sent mail to........................", "AdminDAOImpl.java");
		contactTrainerModel.setEmailAddress(email); 
		contactTrainerModel.setMessageDetails(msg);
		contactTrainerModel.setUserId(id);
		Integer contactTrainerModelId = (Integer) session.save(contactTrainerModel);
		new ZLogger("contactTrainigPartnerSave", "contactTraineeSave after save", "AdminDAOImpl.java");
		if(contactTrainerModelId >0 && contactTrainerModelId != null){
			return "created";
		}else{
			return "error";
		}

	}
	@Override
	public String saveFeedbackMaster(FeedbackMaster feedbackMaster) {
		try{
		Session session = sessionFactory.getCurrentSession();
		Integer saveFeedbackMasterId =null;
		if(feedbackMaster.getFeedbackTypeID()==0){
			saveFeedbackMasterId= (Integer) session.save(feedbackMaster);
		}else{
			session.update(feedbackMaster);
		}
		new ZLogger("saveFeedbackMaster", "saveFeedbackMaster after save", "AdminDAOImpl.java");
		if(saveFeedbackMasterId != null && saveFeedbackMasterId.intValue() >0){
			return "Successfully created";
		}else{
			return "Successfully updated";
		}
		}catch(Exception exception){
			return "error";
		}
	}
	@Override
	public List<IntStringBean> getTrainingCentersByCourse(int courseNameId){
		Session session = sessionFactory.getCurrentSession();
		String strQuery = "select pitp.personalinformationtrainingpartnerid, pitp.trainingcentrename "
				+ "from courseenrolled ce "
				+ "inner join logindetails login on login.id = ce.logindetails and profileid = 5 "
				+ "inner join personalinformationtrainingpartner pitp on pitp.logindetails = login.id "
				+ "where ce.coursenameid = "+courseNameId;

		Query query = session.createSQLQuery(strQuery);
		List<IntStringBean> listTrainingCenters = new ArrayList<IntStringBean>();
		List<Object[]> list =(List<Object[]>) query.list();
		for (int i = 0; i < list.size(); i++) {
			IntStringBean bean = new IntStringBean();
			Object[] obj = list.get(i);
			bean.setId((int)obj[0]);
			bean.setValue(obj[1].toString());
			listTrainingCenters.add(bean);
		}
		return listTrainingCenters;
	}
	@Override
	public List<TrainerAssessmentSearchForm> searchTrainerForAssessmentValidation(int courseNameId, int trainingPartnerId){
		List<TrainerAssessmentSearchForm> list = new ArrayList<TrainerAssessmentSearchForm>();
		Session session = sessionFactory.getCurrentSession();	
		StringBuffer strQuery = new StringBuffer();
		
		strQuery.append("select pit.personalinformationtrainerid ,ct.coursetype ,cn.coursenameid, cn.coursename, "
				+ "concat(pit.firstname, ' ', pit.middlename, ' ', pit.lastname) as name, "
				+ "pitp.personalinformationtrainingpartnerid, pitp.trainingcentrename "
				+ "from personalinformationtrainer pit "
				+ "inner join courseenrolled ce on ce.logindetails = pit.logindetails "
				+ "inner join coursename cn on cn.coursenameid = ce.coursenameid "
				+ "inner join coursetype ct on ct.coursetypeid = cn.coursetypeid "
				+ "inner join courseenrolled cetp on cetp.coursenameid = ce.coursenameid "
				+ "inner join logindetails login on login.id = cetp.logindetails and profileid = 5 "
				+ "inner join personalinformationtrainingpartner pitp on pitp.logindetails = login.id");
		
		if (courseNameId >0 || trainingPartnerId > 0){
			strQuery.append(" where ");
			if (courseNameId > 0){
				strQuery.append("ce.coursenameid = "+courseNameId+" and ");
			}
			if(trainingPartnerId > 0){
				strQuery.append("pitp.personalinformationtrainingpartnerid ="+trainingPartnerId);
			}
		}
		
		Query query = session.createSQLQuery(strQuery.toString());
		List rawlist = query.list();
		
		if(rawlist.size() > 0){
			for (int i = 0; i < rawlist.size(); i++) {
				Object[] obj = (Object[])rawlist.get(i);
				TrainerAssessmentSearchForm dataForm = new TrainerAssessmentSearchForm();
				dataForm.setTrainerId((int)obj[0]);
				dataForm.setCourseType(obj[1].toString());
				dataForm.setCourseNameId((int)obj[2]);
				dataForm.setCourseName(obj[3].toString());
				dataForm.setTrainerName(obj[4].toString());
				dataForm.setTrainingPartnerId((int)obj[5]);
				dataForm.setTrainingPartnerName(obj[6].toString());
				list.add(dataForm);
			}
		}
		return list;
	}
	
	@Override
	public int getElegibilityForAssessment(int coursenameid){
		Session session = sessionFactory.getCurrentSession();
		String sql = "select eligibility from assessmenteligibilitytrainer where coursenameid="+coursenameid;
		Query query = session.createSQLQuery(sql);
		List listEligibility = query.list();
		if(listEligibility.size() > 0)
		{
			return (int)listEligibility.get(0);
		}
		return -1;
	}
	
	@Override
	public int saveTrainerAssessment(TrainerAssessmentEvaluation trainerAssessmentEvaluation){
		Session session = sessionFactory.getCurrentSession();
		Integer trainerAssessmentEvaluationId = (Integer) session.save(trainerAssessmentEvaluation);
		return trainerAssessmentEvaluationId;
	}

	
	
	
	//updateUser
	
		@Override
		public void updateUser( String userid , String tableName , String status){
			Session session = sessionFactory.getCurrentSession();
			new ZLogger("contactTrainigPartnerSave", "update "+tableName+" set isActive='"+status+"' where id="+userid, "AdminDAOImpl.java");
			String sql="update "+tableName+" set isActive='"+status+"' where id="+userid;
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
			
		}
	}
