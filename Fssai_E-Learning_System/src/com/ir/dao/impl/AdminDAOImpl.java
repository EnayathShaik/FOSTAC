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
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
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
import com.ir.form.TrainingCenterReport;
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
import com.ir.util.HibernateUtil;
import com.ir.util.PasswordGenerator;
import com.ir.util.SendContectMail;
import com.ir.util.SendMail;
import com.zentech.logger.ZLogger;
@Repository
@Service
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
		courseName.setCourseduration(manageCourse.getDuration() == null ? "" : manageCourse.getDuration());
		courseName.setCoursename(manageCourse.getCourseName() == null ? "" : manageCourse.getCourseName());
		courseName.setCourseTypeS(ct);
		courseName.setStatus(manageCourse.getStatus() == null ? "" : manageCourse.getStatus());
		courseName.setPaidunpaid(manageCourse.getFreePaid() == null ? "" : manageCourse.getFreePaid());
		courseName.setModeOfTraining(manageCourse.getModeOfTraining() == null ? "" : manageCourse.getModeOfTraining());
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
		System.out.println("status "+manageTrainingPartnerForm.getStatus());
		loginDetails.setIsActive( manageTrainingPartnerForm.getStatus() != null && manageTrainingPartnerForm.getStatus().equalsIgnoreCase("A")? "Y" : "N");
		loginDetails.setStatus( manageTrainingPartnerForm.getStatus() != null && manageTrainingPartnerForm.getStatus().equalsIgnoreCase("A")? "Y" : "N");
		loginDetails.setProfileId(7);
		
		State s = getState(manageTrainingPartnerForm.getState());
		District d = getDistrict(manageTrainingPartnerForm.getDistrict());
		City c = getCity(manageTrainingPartnerForm.getCity());
		try{
		ManageTrainingPartner manageTrainingPartner = new ManageTrainingPartner();
		manageTrainingPartner.setPAN(manageTrainingPartnerForm.getPAN() == null ? "" : manageTrainingPartnerForm.getPAN());
		manageTrainingPartner.setTrainingPartnerName(manageTrainingPartnerForm.getTrainingPartnerName() == null ? "" : manageTrainingPartnerForm.getTrainingPartnerName());
		manageTrainingPartner.setUserId(nextSequenceUserID == null ? "" : nextSequenceUserID);
		
		manageTrainingPartner.setContactPersonName(manageTrainingPartnerForm.getContactPersonName() == null ? "" :manageTrainingPartnerForm.getContactPersonName() );
		manageTrainingPartner.setContactEmail(manageTrainingPartnerForm.getContactEmail() == null ? "" :manageTrainingPartnerForm.getContactEmail() );
		manageTrainingPartner.setMobile(manageTrainingPartnerForm.getMobile() == null ? "" :manageTrainingPartnerForm.getMobile() );
		manageTrainingPartner.setEmail(manageTrainingPartnerForm.getEmail() == null ? "" :manageTrainingPartnerForm.getEmail() );
		manageTrainingPartner.setWebsiteUrl(manageTrainingPartnerForm.getWebsiteUrl() == null ? "" : manageTrainingPartnerForm.getWebsiteUrl());
		manageTrainingPartner.setHeadOfficeDataAddress1(manageTrainingPartnerForm.getHeadOfficeDataAddress1() == null ? "" : manageTrainingPartnerForm.getHeadOfficeDataAddress1());
		manageTrainingPartner.setHeadOfficeDataAddress2(manageTrainingPartnerForm.getHeadOfficeDataAddress2() == null ? "" : manageTrainingPartnerForm.getHeadOfficeDataAddress2());
		manageTrainingPartner.setPin(manageTrainingPartnerForm.getPin() == null ? "" : manageTrainingPartnerForm.getPin());
		manageTrainingPartner.setDistrict(d);
		manageTrainingPartner.setCity(c);
		manageTrainingPartner.setState(s);
		manageTrainingPartner.setLoginDetails(loginDetails);
		session.save(manageTrainingPartner);
		}catch(Exception e){
			e.printStackTrace();
		}
		new ZLogger("manageTrainingPartnerSave", "all insert done", "AdminDAOImpl.java");
		return passwordString+"&"+nextSequenceUserID;
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
		manageAssessmentAgency.setAgencyUniqueID(nextSequenceUserID == null ? "" : nextSequenceUserID);
		manageAssessmentAgency.setPAN(manageAssessmentAgencyForm.getPAN() == null ? "" : manageAssessmentAgencyForm.getPAN());
		manageAssessmentAgency.setContactPersonName(manageAssessmentAgencyForm.getContactPersonName() == null ? "" : manageAssessmentAgencyForm.getContactPersonName());
		manageAssessmentAgency.setContactEmail(manageAssessmentAgencyForm.getContactEmail() == null ? "" : manageAssessmentAgencyForm.getContactEmail());
		manageAssessmentAgency.setMobile(manageAssessmentAgencyForm.getMobile() == null? "" :manageAssessmentAgencyForm.getMobile() );
		manageAssessmentAgency.setAssessmentAgencyName(manageAssessmentAgencyForm.getAssessmentAgencyName() == null ? "" : manageAssessmentAgencyForm.getAssessmentAgencyName());
		manageAssessmentAgency.setWebsiteUrl(manageAssessmentAgencyForm.getWebsiteUrl() == null ? "" : manageAssessmentAgencyForm.getWebsiteUrl());
		manageAssessmentAgency.setHeadOfficeDataAddress1(manageAssessmentAgencyForm.getHeadOfficeDataAddress1() == null ? "" : manageAssessmentAgencyForm.getHeadOfficeDataAddress1());
		manageAssessmentAgency.setHeadOfficeDataAddress2(manageAssessmentAgencyForm.getHeadOfficeDataAddress2() == null ? "" : manageAssessmentAgencyForm.getHeadOfficeDataAddress2());
		manageAssessmentAgency.setPin(manageAssessmentAgencyForm.getPin() == null ? "" : manageAssessmentAgencyForm.getPin());
		manageAssessmentAgency.setDistrict(d);
		manageAssessmentAgency.setCity(c);
		manageAssessmentAgency.setEmail(manageAssessmentAgencyForm.getEmail() == null ? "" : manageAssessmentAgencyForm.getEmail());
		manageAssessmentAgency.setLoginDetails(loginDetails);
		manageAssessmentAgency.setState(s);
		session.save(manageAssessmentAgency);
		return passwordString+"&"+nextSequenceUserID;
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
		String FirstName = (trainingCenterUserManagementForm.getTrainingCenterName()==null ? "" : trainingCenterUserManagementForm.getTrainingCenterName());
		/*String MiddleName = trainingCenterUserManagementForm.getMiddleName();
		String LastName = trainingCenterUserManagementForm.getLastName() ;
		String PanNumber = trainingCenterUserManagementForm.getPanNumber();*/
		String status = (trainingCenterUserManagementForm.getStatus() == null ? "" : trainingCenterUserManagementForm.getStatus());
		String userId = (trainingCenterUserManagementForm.getUserId() == null ? "" : trainingCenterUserManagementForm.getUserId() );
		
		if(FirstName.length() == 0){
			FirstName = "%";
		}
		
		if(userId.length() == 0){
			userId = "%";
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
		String like= " where upper(pitp.trainingcentrename) like '"+FirstName.toUpperCase()+"'  and "
				+ " ld.loginid like '"+userId+"%' and ld.status like '"+ status+"'";
		like = like + userBuffer.toString();
		String select = "pitp.personalInformationTrainingPartnerId,ld.loginid,pitp.trainingcentrename,pitp.logindetails ,(CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus ";
		
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
		assessmentQuestion.setQuestionNumber(1);
		System.out.println(assessmentQuestion.getQuestionNumber());
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
		
		//searchManageCourse
		@Override
		public List searchManageCourse( String data){
			String name = data;
			System.out.println("passing name   :" + name);
			String[] totalConnected = name.split("-");
			String courseType="",courseName="" , freePaid ="" , status="",duration = "" ;
			if(!name.equalsIgnoreCase("ALL")){
				
				try{
					courseType = (totalConnected[0].split("="))[1];
				}
				catch(Exception e)
				{
					courseType ="%" ;
				}
				
				try{
					courseName = (totalConnected[1].split("="))[1].replaceAll("%20", " ").trim();
				}
				catch(Exception e)
				{
					courseName = "%";
				}
				
				try{
					freePaid = (totalConnected[2].split("="))[1];
				}
				catch(Exception e)
				{
					freePaid = "%";
				}
				
					status = (totalConnected[3].split("="))[1];
					try{
						duration =totalConnected[4].split("=")[1];
					}catch(Exception e){
						duration = "%";	
					}
				
			}
			CourseName courseName1 = new CourseName();
			String sql = null;
			if(!name.equalsIgnoreCase("ALL"))
				sql ="select cn.coursetypeid,ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
							" ,cn.courseCode from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid "+
							" where cast(cn.coursetypeid as varchar(10)) like '"+courseType+"%' and upper(cn.coursename) like '"+ courseName.toUpperCase()+"%'"+
							"  and paidunpaid like'"+freePaid+"%' and cn.courseduration like '"+duration+"%' and cn.status like '"+status+"%' Order By cn.coursenameid desc ";
				else
				sql ="select cn.coursetypeid,ct.coursetype , cn.coursename , cn.courseduration , cn.paidunpaid ,  cn.status ,cn.coursenameid , cn.online , cn.classroom"+
								" ,cn.courseCode from coursename as cn inner join coursetype as ct on ct.coursetypeid= cn.coursetypeid Order By cn.coursenameid desc " ;
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(sql);
			List courseTypeList = query.list();
			return courseTypeList;	
			
			
		}	
		
		//editManageCourseData
		
		@Override
		public String editManageCourseData( String data){
			String name = data;
			System.out.println("passing name   : " + name);
			
			String[] totalConnected = name.split("-");
			String courseName , courseDuration , online, status , paidunpaid , id  , classroom;
			
			courseName = (totalConnected[1].split("="))[1].replaceAll("%20", " ").trim();
			courseDuration = (totalConnected[4].split("="))[1].replaceAll("%20", " ").trim();
			if( (totalConnected[2].split("="))[1].equals("true")){
				online =  "Online";
			}else{
				online = "Nil";
			}
			paidunpaid = (totalConnected[0].split("="))[1];
			status = (totalConnected[3].split("="))[1];
			id = (totalConnected[5].split("="))[1];
			System.out.println(" classroom "+(totalConnected[6].split("="))[1]);
			if( (totalConnected[6].split("="))[1].equals("true")){
				classroom =  "Classroom";
			}else{
				classroom = "Nil";
			}
			
			System.out.println(courseName + " "+courseDuration + " "+ online + "  "+ classroom + " "+ status + "  "+id);
			
			Session session = sessionFactory.getCurrentSession();
			CourseName   courseNameee=(CourseName) session.load(CourseName.class, Integer.parseInt(id));
			courseNameee.setCoursename(courseName);
			courseNameee.setCourseduration(courseDuration);
			courseNameee.setOnline(online);
			courseNameee.setClassroom(classroom);
			courseNameee.setStatus(status);	
			courseNameee.setPaidunpaid(paidunpaid);
			session.update(courseNameee);
			String newList = "Recors successfully updated !!!" ;
			
			return newList;

		}	
		
		//editState
		
		@Override
		public String editState( String data){
			String name = data;
			System.out.println("passing name state update  :" + name);
			String[] totalConnected = name.split("-");
			String id , status , state ;
			id = (totalConnected[0].split("="))[1];
			status = (totalConnected[1].split("="))[1];
			state = (totalConnected[2].split("="))[1].replaceAll("%20", " ");
			System.out.println(Integer.parseInt(id) + "  "+ status + "   "+ state);
			String newList = null;
			Session session =  sessionFactory.getCurrentSession();
				State   stateNameee=(State) session.load(State.class, Integer.parseInt(id));
				stateNameee.setStatus(status);
				stateNameee.setStateName(state);
				session.update(stateNameee);
			 newList = "Recors successfully updated !!!" ;
			
			return newList;

		}
		
	
		//CheckState
		
		@Override
		public String CheckState( String data){
			String name = data;
			String newList = null;
			System.out.println("passing name state update  :" + name);
			String sql="select * from State where upper(stateName) like '" + name.replaceAll("%20", " ").toUpperCase() + "%'"; 
			Session session =  sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery(sql);
			System.out.println("query>"+query);
			List l = query.list();
			if(l != null && l.size() > 0){
				System.out.println("available in data base cannot use");
				newList = "Already";
					
			}else{
				System.out.println("available to use not in database");
				newList = "";
			}

			
			return newList;

		}
		
		//searchState
		
		@Override
		public List<State> searchState( String data){
			String n = data;
			String sss , ssss;
			  String [] n1 = n.split("-");
		        String stateName = null;
		        try{
		        	 stateName = (n1[0].split("="))[1] ;
		        	 String s [] = stateName.split("%20");
		        	 String ss = " ";
		        	 for(int i = 0 ; i < s.length ; i++){
		        		 ss =ss + s[i] + " "; 
		        	 }
		        	 sss = ss.substring(1, ss.length());
		        	 ssss = sss.substring(0 , sss.length() - 1);
		        }catch(Exception e){
		        	stateName = "%";
		        }
		        
		        String status = (n1[1].split("="))[1];
		        System.out.println(stateName + "   "+ status);
		        
		        Session session =  sessionFactory.getCurrentSession();
				String newList = null ;
				
					System.out.println("state 1");
					Query query = session.createQuery("from State where statename like '"+ stateName+"%'");
					List<State> list = query.list();
					return list;

		}
		
		
		//onLoadDistrict

		
		@Override
		public List onLoadDistrict( String data){
				Session session =  sessionFactory.getCurrentSession();
				String newList = null ;
				
					System.out.println("state 1");
					Query query = session.createSQLQuery("select s.statename , d.districtName , d.status , d.districtId from district as d inner join state as s on s.stateid = d.stateid");
					List list = query.list();
					return list;

		}
		
		
		@Override
		public String changeStatusDistrict(String data){
			
			String[] totalConnected = data.split("-");
			String id,status,distName;
			
			
			id = (totalConnected[0].split("="))[1];
			status = (totalConnected[1].split("="))[1];
			distName = (totalConnected[2].split("="))[1];
			//districtIdH = (totalConnected[4].split("="))[1];
			System.out.println("check status:"+status);
			System.out.println("district name==>"+distName);
			Session session =  sessionFactory.getCurrentSession();
			
			String newList = null;
		
				District d = (District) session.load(District.class,Integer.parseInt( id));			
				System.out.println("else");
				d.setStatus(status);
				d.setDistrictName(distName);
				session.update(d);
				newList = "Status changed" ;
				return newList;
		}
		
//searchDistrict
		
		@Override
		public List searchDistrict(String data){
			
			String[] totalConnected = data.split("-");
	        String stateId = (totalConnected[0].split("="))[1];
	        String	districtName =null ;
	        System.out.println("length  "+totalConnected[1].split("=").length);
	        
	        try{
	        	districtName = (totalConnected[1].split("="))[1];
	        }catch(Exception e){
	        	districtName = "%";
	        }
	     
	        System.out.println("stateId "+stateId  + " districtName "+districtName );
			Session session =  sessionFactory.getCurrentSession();
			String sql = "select  s.stateName , d.districtName  , d.districtId  from district as d inner join state as s on s.stateid = d.stateid where "+
					 " d.status = 'A' and upper(districtname) like '"+districtName.replaceAll("%20", " ").toUpperCase()+"%' and cast(s.stateid as varchar(100)) like '"+stateId+"%' ";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
		
		
		//editCityData
		
		@Override
		public String editCityData( String data){
			String name = data;
			System.out.println("passing name state update  :" + name);
			String[] totalConnected = name.split("-");
			String status,cityName;
			int  cityId;
			status = (totalConnected[0].split("="))[1];
			
			cityId = Integer.parseInt((totalConnected[1].split("="))[1]);
			cityName = (totalConnected[2].split("="))[1];
			String districtId = (totalConnected[3].split("="))[1];
			String newList = null;
			Session session =  sessionFactory.getCurrentSession();
			City   cityNameee=(City) session.load(City.class, cityId);
			cityNameee.setStatus(status);
			cityNameee.setCityName(cityName);
			session.update(cityNameee);
			 newList = "Recors successfully updated !!!" ;
			
			return newList;

		}
		
		//searchCity
		
		
		@Override
		public List searchCity(String data){
			String [] n1 = data.split("-");
			
			String stateId ;
			if((n1[0].split("="))[1].equals("0")){
				stateId = "%";
			}else{
				stateId = (n1[0].split("="))[1];
			}
			
			String districtId;
			if((n1[1].split("="))[1].equals("0")){
				districtId ="%";
			}else{
				districtId = (n1[1].split("="))[1];
			}
			
			String cityName = null;
			if( (n1[2].split("=")).length == 1){
				cityName = "%";
			}else{
				cityName =  (n1[2].split("="))[1].replaceAll("%20", " ");
			}
			String status = (n1[3].split("="))[1] ;
			Session session =  sessionFactory.getCurrentSession();
			String sql = "select s.statename , d.districtname , c.cityname , c.status , c.cityId,d.districtid  ,s.stateid from city as c  "+
					" inner join district d on d.districtid = c.districtid "+
					" inner join state as s on s.stateid = d.stateid"+
					" where CAST(s.stateid AS varchar(10)) like'"+ stateId +"'"+
					" and c.cityName like '"+cityName+"%' and  CAST(d.districtid AS varchar(10)) like '"+districtId+"'";


			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
	
		
		@Override
		public List onLoadRegion( String data){
				Session session =  sessionFactory.getCurrentSession();
				String newList = null ;
				
					System.out.println("onLoadRegion");
					Query query = session.createSQLQuery("select d.districtName , r.regionname ,r.id , s.statename , c.cityname ,r.cityid , r.districtid , r.stateid , r.status  from region r left join city c on c.cityid = r.cityid left join district d on d.districtid = r.districtid left join state s on s.stateid = r.stateid ");
					List list = query.list();
					return list;

		}
		//editRegionData
		
		@Override
		public String editRegionData( String data){
			String name = data;
			String[] totalConnected = name.split("-");
			String regionName,status;
			int  regionId,stateId,districtId,cityId;
			regionId = Integer.parseInt((totalConnected[0].split("="))[1]);
			regionName = (totalConnected[1].split("="))[1];
			status = (totalConnected[2].split("="))[1];
			stateId =  Integer.parseInt((totalConnected[3].split("="))[1]);
			districtId =  Integer.parseInt((totalConnected[4].split("="))[1]);
			cityId =  Integer.parseInt((totalConnected[5].split("="))[1]);
			System.out.println("checkkk data==>"+regionId+regionName+stateId+districtId+cityId);
			Session session =  sessionFactory.getCurrentSession();
			
				
				Region   region=(Region) session.load(Region.class, regionId);
				region.setCityId(cityId);
				region.setDistrictId(districtId);
				region.setStateId(stateId);
				region.setStatus(status);
				region.setRegionName(regionName);
				session.update(region);
			
			String newList = "Recors successfully updated !!!" ;
			
			return newList;

		}

		//traineeAssessmentCalender
		
		@Override
		public List traineeAssessmentCalender(String data){
			String [] n1 = data.split("&");
			System.out.println("n1 "+n1);
			String courseType,courseName , trainerName, assDate , assTime ;
			try{
				courseType = n1[0].split("=")[1];
			}
			catch(Exception e){
				courseType = "%";	
			}
			
			try{
				courseName = n1[1].split("=")[1];	
			}catch(Exception e){
				courseName = "%";	
			}
			
			try{
				trainerName = n1[2].split("=")[1];	
			}catch(Exception e){
				trainerName = "%";	
			}
			
			
			try{
				assDate = n1[3].split("=")[1];	
			}catch(Exception e){
				assDate = "%";	
			}
			
			try{
				assTime = n1[4].split("=")[1];	
			}catch(Exception e){
				assTime = "%";	
			}
			
			Session session =  sessionFactory.getCurrentSession();
			String sql = "select B.coursetype,C.coursename,A.trainername,A.assessmentdate,A.assessmenttime,D.firstname || D.middlename || D.lastname,A.trainingcalendarid,A.assessor  from trainingcalendar A  " +
					" inner join coursetype B on(A.coursetype=B.coursetypeid)  " +
					"inner join coursename C on(A.coursename=C.coursenameid)"+
					"inner join personalinformationtrainer D on(CAST(CAST (A.trainername AS NUMERIC(19,4)) AS INT)=D.personalinformationtrainerid)" +
					" where  cast(B.coursetypeid as varchar(10)) like '"+courseType+"%'  and cast(C.coursenameid as varchar(10)) like  '"+courseName+"%' and (D.firstname || ' '|| D.middlename ||' '|| D.lastname)  like  '"+trainerName+"%'  and  cast(A.assessmentdate as varchar(10)) like  '"+assDate+"%'  and cast(assessmenttime as varchar(10)) like '"+assTime+"%'  " ;
			

			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
		
		//getQuestions

		@Override
		public List getQuestions(String data){
			String[] totalConnected = data.split("-");
			
			int  courseNameSearch = Integer.parseInt((totalConnected[0].split("="))[1]);
			int  courseTypeSearch = Integer.parseInt((totalConnected[1].split("="))[1]);
			
			String courseNameSearch1 , courseTypeSearch1;
			if(courseNameSearch == 0){
				courseNameSearch1 ="%";
			}else{
				courseNameSearch1 = (totalConnected[0].split("="))[1];
			}
			
			if(courseTypeSearch == 0){
				courseTypeSearch1 ="%";
			}else{
				courseTypeSearch1 = (totalConnected[0].split("="))[1];
			}
			
			
			System.out.println("contentLocationInput  "+courseNameSearch + "  "+ courseNameSearch1);
			System.out.println("courseTypeInput   "+courseTypeSearch + "  "+ courseTypeSearch1);
			StringBuffer wherebuffer = new StringBuffer();
			wherebuffer.append(" WHERE 1=1 ");
			if(courseTypeSearch > 0){
				wherebuffer.append(" AND ct.coursetypeid="+courseTypeSearch);
			}
			if(courseNameSearch > 0){
				wherebuffer.append(" AND cn.coursenameid="+courseNameSearch);
			}
			
			Session session =  sessionFactory.getCurrentSession();
			String sql = "select ct.coursetype , cn.coursename , aq.questionnumber, aq.assessmentquestionid, cn.coursecode   from assessmentquestion as aq "+
					" inner join coursetype as ct on ct.coursetypeid = aq.coursetype"+
					" inner join coursename as cn on cn.coursenameid = aq.coursename";
		sql = sql + wherebuffer.toString();
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
		
		//searchFeedbackMaster
		
		@Override
		public List searchFeedbackMaster(String data){
			String courseType ="" , catagory ="", feedback = "" , status = "";
			if(!data.equalsIgnoreCase("ALL")){
				
				 String [] n1 = data.split("-");
					
					
					try{
						courseType = (n1[0].split("="))[1];
					}catch(Exception e){
						courseType = "%";
					}
					
					try{
						catagory = n1[1].split("=")[1];
						
					}catch(Exception e){
						catagory ="%";
					}
					
					try{
						feedback = (n1[2].split("="))[1];
					}catch(Exception e){
						feedback = "%";
					}
					
					 status = (n1[3].split("="))[1] ;
			}
		
			String sql= null;
			Session session =  sessionFactory.getCurrentSession();
			if(data.equalsIgnoreCase("ALL"))
				sql = "select feedbacktypeid,coursetype,catogery,feedback,status from feedbackmaster";
				else
				sql = "select feedbacktypeid,coursetype,catogery,feedback,status from feedbackmaster"+
				" where cast (coursetype as varchar(20)) like '"+courseType+"%' and cast(catogery as varchar(20)) like  '"+catagory+"%' and cast(feedback as varchar(20)) like '"+feedback+"%' and cast(status as varchar(10)) like '"+status+"%'";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
		

		//searchAssessmentAgencyList
		@Override
		public List searchAssessmentAgencyList(String data){
			Session session =  sessionFactory.getCurrentSession();
			
				String sql = "select maa.manageassessmentagencyid ,  maa.assessmentagencyname , "+
						" count(pia.assessmentagencyname) from personalinformationassessor as pia "+
" inner join manageassessmentagency as maa on pia.assessmentagencyname = maa.manageassessmentagencyid  "+
" inner join logindetails as ld on pia.logindetails = ld.id where ld.status='I' "+
" group by maa.assessmentagencyname , maa.manageassessmentagencyid ";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
		

		
		
		
		//searchAssessorDetail
		
		
		@Override
		public List searchAssessorDetail(String data){
			String id = data;
			Session session =  sessionFactory.getCurrentSession();
			
			String sql = "select  maa.assessmentagencyname , concat( pia.firstname ,'' ,pia.middlename ,' '  , pia.lastname) , ld.loginid , "+
					"  ld.status ,  pia.personalinformationassessorid , case when ld.status='A' then 'Active' else 'In Active' end from personalinformationassessor as pia "+
					" inner join manageassessmentagency as maa on pia.assessmentagencyname = maa.manageassessmentagencyid "+
					" inner join logindetails as ld on ld.id = pia.logindetails "+
					" where maa.manageassessmentagencyid = '"+Integer.parseInt(id)+"' AND ld.status='I'";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
				return list;
		}
		
		//changeAssessor
		
		
		@Override
		public String changeAssessor(String data){
			
			String[] totalConnected = data.split("@");
			String id,status;
			
			id = (totalConnected[0].split("="))[1];
			status = (totalConnected[1].split("="))[1];
			Session session =  sessionFactory.getCurrentSession();
			
			String newList = null;
			PersonalInformationAssessor   personalInformationAssessor=(PersonalInformationAssessor) session.load(PersonalInformationAssessor.class,Integer.parseInt(id));
			LoginDetails ld = personalInformationAssessor.getLoginDetails();
			String newStatus = "I";
			if(status.equalsIgnoreCase("I")){
				newStatus = "A";
				newList = "Status changet to ACTIVE" ;
			}else{
				newList = "Status changet to IN-ACTIVE" ;
				newStatus = "I";
			}
	
					if(personalInformationAssessor.getLoginDetails() != null){
						String updateQry = "update logindetails set status ='"+newStatus+"' where id ="+personalInformationAssessor.getLoginDetails().getId(); 
						Query query = session.createSQLQuery(updateQry);
						System.out.println(updateQry);
						Integer i = query.executeUpdate();
						System.out.println("i  :"+ i);
						String responseStr = null ;
						
						if(i > 0 ){
							System.out.println("data selected finally  " );
							responseStr = "Data updated successfully"; 
						}else{
							responseStr = "Oops , something went wrong try ageain !!!";
						}
					}
		
		return newList;
		}
		
		@Override
		 public List trainingCenterDetails(int data){
			String input = null;
			if(data == 0){
				input = "%";
			}else{
				input = data+"";
						
			}
			Session session =  sessionFactory.getCurrentSession();
			List<TrainingCenterReport> mailList = new ArrayList<TrainingCenterReport>();
			String sql = "select cast('jyoti' as varchar(50)) as trainingcenter , cast('29' as varchar(10)) as noOfTrainingDone  ,  cast('39' as varchar(10))   as NoOfTraineesInvolved,  cast('20' as varchar(10))   as Pass , cast('10' as varchar(10))  CountFail from personalinformationtrainingpartner where cast(trainingpartnername as varchar(20))  like '"+input+"%'";
			Query query = session.createSQLQuery(sql);
			List list = query.list();
			System.out.println(list.size());
			for(int i = 0 ; i < list.size() ; i++){
				Object[] obj = (Object[]) list.get(i);
				TrainingCenterReport tc = new TrainingCenterReport();
				tc.setTrainingCenter((String)obj[0]);
				tc.setNoOfTrainingDone((String)obj[1]);
				tc.setNoOfTraineesInvolved((String) obj[2]);
				tc.setPass((String)obj[3]);
				tc.setCountFail((String)obj[4]);
				mailList.add(tc);
			}
			return mailList;
		}
}


