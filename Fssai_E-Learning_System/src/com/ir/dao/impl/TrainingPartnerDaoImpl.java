package com.ir.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

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

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.trainingPartner.TrainingPartnerSearch;
import com.ir.model.City;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.ManageCourseContent;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.State;
import com.ir.model.TraineeDailyAttendance;
import com.ir.model.TrainingCalendar;
import com.ir.model.TrainingCalendarHistoryLogs;
import com.ir.model.Utility;
import com.ir.util.ChangePasswordUtility;
import com.zentech.logger.ZLogger;
import com.zentect.ajax.AjaxRequest;

@Repository
@Service
public class TrainingPartnerDaoImpl implements TrainingPartnerDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	@Autowired
	@Qualifier("courseNameS")
	private CourseName courseNameS;
	@Autowired
	@Qualifier("courseTypeS")
	private CourseType courseTypeS;
	@Autowired
	@Qualifier("personalInformationTrainingPartner")
	private PersonalInformationTrainingPartner personalInformationTrainingPartner;
	@Autowired
	@Qualifier("postVacancyTrainingCenter")
	private PostVacancyTrainingCenter postVacancyTrainingCenter;

	@Autowired
	@Qualifier("changePasswordUtility")
	public ChangePasswordUtility changePasswordUtility;
	
	@Override
	public CourseType getCourseType(int id){
		Session s = sessionFactory.getCurrentSession();
		CourseType courseType = (CourseType)s.load(CourseType.class, id);
		return courseType;
	}
	@Override
	public CourseName getCourseName(int id){
		Session s = sessionFactory.getCurrentSession();
		CourseName courseName = (CourseName)s.load(CourseName.class, id);
		return courseName;
	}
	@Override
	public PersonalInformationTrainingPartner getPersonalInformationTrainingPartner(int id){
		Session s = sessionFactory.getCurrentSession();
		PersonalInformationTrainingPartner personalInformationTrainingPartner = (PersonalInformationTrainingPartner)s.load(PersonalInformationTrainingPartner.class, id);
		return personalInformationTrainingPartner;
	}
	@Override
	public List<PersonalInformationTrainingPartner> trainingCenterList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PersonalInformationTrainingPartner");
		List<PersonalInformationTrainingPartner> personalInformationTrainingPartner = query.list();
		return personalInformationTrainingPartner;
	}

	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}

	@Override
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
		Integer postVacancyTrainingCenterIdd ;
		Session session = sessionFactory.getCurrentSession();
		PersonalInformationTrainingPartner p = getPersonalInformationTrainingPartner(postVacancyTrainingCenterForm.getTrainingCenter());
		
		new ZLogger("postVacancyTrainingPartner","postVacancyTrainingPartner", "TrainingPartnerDaoImpl.java");
		String sql = "select * from PostVacancyTrainingCenter where CourseType = '"+postVacancyTrainingCenterForm.getCourseType()+"' and CourseName = '" + postVacancyTrainingCenterForm.getCourseName()+"' and TrainingDate = '"+ postVacancyTrainingCenterForm.getTrainingDate()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() > 0){
			
		}else{
			CourseType ct = getCourseType(postVacancyTrainingCenterForm.getCourseType());
			CourseName cn = getCourseName(postVacancyTrainingCenterForm.getCourseName());
			postVacancyTrainingCenter.setNoOfVacancy(postVacancyTrainingCenterForm.getNoOfVacancy());
			postVacancyTrainingCenter.setRequiredExp(postVacancyTrainingCenterForm.getRequiredExp());
			postVacancyTrainingCenter.setCourseName(cn);
			postVacancyTrainingCenter.setCourseType(ct);
			postVacancyTrainingCenter.setVacancyType(postVacancyTrainingCenterForm.getVacancyType() == null ? "" : postVacancyTrainingCenterForm.getVacancyType());
			postVacancyTrainingCenter.setTrainingDate(postVacancyTrainingCenterForm.getTrainingDate() == null ? "" : postVacancyTrainingCenterForm.getTrainingDate());
			postVacancyTrainingCenter.setTrainingEndTime(postVacancyTrainingCenterForm.getTrainingEndTime() == null ? "" : postVacancyTrainingCenterForm.getTrainingEndTime());
			postVacancyTrainingCenter.setLoginId(postVacancyTrainingCenterForm.getLoginId() == null ? "" : postVacancyTrainingCenterForm.getLoginId());
			postVacancyTrainingCenter.setTrainingCenter(p);
			postVacancyTrainingCenterIdd = (Integer) session.save(postVacancyTrainingCenter);
			if(postVacancyTrainingCenterIdd >0 && postVacancyTrainingCenterIdd != null){
				return "created";
			}
		}
		return "error";
	}
	@Override
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,Integer profileID, Integer userId){
		Session session = sessionFactory.getCurrentSession();
		Integer isapplied=0;
		Query sql=session.createSQLQuery("select * from trainingcentervacancyenrolled where postvacancyid="+postVacancyTrainingCenterBean.getPostvacancyID()+" AND CAST(CAST (loginid AS NUMERIC(19,4)) AS INT)="+userId);
		List<Object[]> list=sql.list();
		if(list.size()>0){
			postVacancyTrainingCenterBean.setVacancyEnrolledId(Integer.parseInt(list.get(0)[0].toString()));
			session.update(postVacancyTrainingCenterBean);
		}else{
			isapplied= (Integer) session.save(postVacancyTrainingCenterBean);
		}
		return isapplied;
		
	}
	@Override
	public boolean changePasswordTrainingPartnerSave(ChangePasswordForm changePasswordForm, String id) {
		String oldPassword=	changePasswordForm.getOldPassword();
		String newPassword=changePasswordForm.getNewPassword();
		new ZLogger("changePasswordTrainingPartnerSave","changePasswordTrainingPartnerSave "+oldPassword, "TrainingPartnerDaoImpl.java");
		boolean confirm = changePasswordUtility.changePasswordUtil(oldPassword, newPassword, id);
		return confirm;
	}
	public List<CourseType> courseTypes(){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		return courseTypeList;
	}
	@Override
	public List<IntStringBean> getTrainerList(){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> trinerNameList=new ArrayList<>();
		String sql="select distinct pitp.personalinformationtrainerid,pitp.firstname,pitp.middlename,pitp.lastname from personalinformationtrainer pitp , logindetails pit";
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				IntStringBean bean=new IntStringBean();
				Object[] objecList=courseTypeList.get(index);
				bean.setId(Integer.parseInt(objecList[0].toString()));
				bean.setValue(objecList[1].toString().concat(" ").concat(objecList[2].toString()).concat(" ").concat(objecList[3].toString()));
				trinerNameList.add(bean);
			}
		}
		return trinerNameList;
	}
	@Override
	public List<IntStringBean> getTraineeList(){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> trinerNameList=new ArrayList<>();
		String sql="select distinct pitp.personalinformationtraineeid,pitp.firstname,pitp.middlename,pitp.lastname from personalinformationtrainee pitp , logindetails pit";
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				IntStringBean bean=new IntStringBean();
				Object[] objecList=courseTypeList.get(index);
				bean.setId(Integer.parseInt(objecList[0].toString()));
				bean.setValue(objecList[1].toString().concat(" ").concat(objecList[2].toString()).concat(" ").concat(objecList[3].toString()));
				trinerNameList.add(bean);
			}
		}
		return trinerNameList;
	}
	
	@Override
	public List<IntStringBean> getTrainingCenterList(Integer userId,Integer profileId){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> trainingCenterList=new ArrayList<>();
		StringBuffer userCondition = new StringBuffer();
		if(profileId == 5){
			userCondition.append("Where B.ID = "+userId);
		}else{
			userCondition.append("");
		}
		String sql="select distinct A.personalinformationtrainingpartnerid,A.firstname,A.middlename,A.lastname  from personalinformationtrainingpartner A " +
				" inner join logindetails B on(A.logindetails=B.id) ";
		sql	= sql + userCondition.toString();
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				IntStringBean bean=new IntStringBean();
				Object[] objecList=courseTypeList.get(index);
				bean.setId(Integer.parseInt(objecList[0].toString()));
				bean.setValue(objecList[1].toString().concat(" ").concat(objecList[2].toString()).concat(" ").concat(objecList[3].toString()));
				trainingCenterList.add(bean);
			}
		}
		return trainingCenterList;
	}
	
	

	@Override
	public int getTrainingCenter(Integer userId,Integer profileId){
		Session session = sessionFactory.getCurrentSession();
		int trainingCenter=0;
		
		String sql="select distinct A.personalinformationtrainingpartnerid  from personalinformationtrainingpartner A " +
				" inner join logindetails B on(A.logindetails=B.id) where logindetails='"+userId+"'";
		new ZLogger("getTrainingCenter","sql "+sql, "TrainingPartnerDaoImpl.java");
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		
			if(list.size() > 0){
				trainingCenter = (int) list.get(0);
				new ZLogger("getTrainingCenter"," ", "TrainingPartnerDaoImpl.java");
			}
		
		return trainingCenter;
	}
	
	
	@Override
	public List<IntStringBean> getAssessorList(){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> assessorList=new ArrayList<>();
		String sql="select distinct pitp.personalinformationassessorid,pitp.firstname,pitp.middlename,pitp.lastname from personalinformationassessor pitp , logindetails pit";
				
		//"select pit.logindetails,pit.firstname,pit.middlename,pit.lastname from personalinformationtrainer pit,personalinformationtrainingpartner pitp";// where pit.logindetails=pitp.logindetails";
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				IntStringBean bean=new IntStringBean();
				Object[] objecList=courseTypeList.get(index);
				bean.setId(Integer.parseInt(objecList[0].toString()));
				bean.setValue(objecList[1].toString().concat(" ").concat(objecList[2].toString()).concat(" ").concat(objecList[3].toString()));
				assessorList.add(bean);
			}
		}
		return assessorList;
	}
	@Override
	public List<StringStringBean> getStatusList(){
		//TODO write query retrieve all Status of trainee
		List<StringStringBean> statusList=new ArrayList<>();
		String[] arrayValues={"Confirm,Payment Confirm","Confirmed,Auto Confirmed","Pending,Payment Pending"};
		for(int index=0;index<arrayValues.length;index++){
			StringStringBean bean=new StringStringBean();
			String[] beanValues=arrayValues[index].split(",");
			bean.setId(beanValues[0]);
			bean.setValue(beanValues[1]);
			statusList.add(bean);
		}
		return statusList;
	}
	@Override
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList(Integer userID){
		Session session = sessionFactory.getCurrentSession();
		double trainerExp = 0;
		String sql = "select (CAST(AA.expinfoodsafefytimeyear AS VARCHAR(10) ) ||'.'|| CAST(AA.expinfoodsafefytimemonth AS VARCHAR(10) )) from personalinformationtrainer AA where AA.logindetails ='"+userID+"'";
		new ZLogger("getPostVacancyTrainingList","sql "+sql, "TrainingPartnerDaoImpl.java");
		Query query1 = session.createSQLQuery(sql);
		List<String> status = query1.list();
		try{
			if(status.size()>0){
				new ZLogger("getPostVacancyTrainingList","status.size() "+status.size(), "TrainingPartnerDaoImpl.java");
				trainerExp = Float.parseFloat(status.get(0).toString());
			}	
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("getPostVacancyTrainingList","Exception while getPostVacancyTrainingList "+e.getMessage(), "TrainingPartnerDaoImpl.java");
		}
		
		Query query = session.createQuery("from PostVacancyTrainingCenter A where   to_timestamp(COALESCE(A.trainingDate, '19900101010101'),'DD-MM-YYYY HH24:MI')  > now()   AND A.requiredExp <= "+trainerExp);
		List<PostVacancyTrainingCenter> postVacancyTrainingCenter = query.list();
		return postVacancyTrainingCenter;
	}
	@Override
	public List<StringStringBean> getModeOfTrainingList(){
		//TODO write query retrieve all Status of trainee
		List<StringStringBean> statusList=new ArrayList<>();
		String[] arrayValues={"Classroom,Classroom","Online,Online","both,Both"};
		for(int index=0;index<arrayValues.length;index++){
			StringStringBean bean=new StringStringBean();
			String[] beanValues=arrayValues[index].split(",");
			bean.setId(beanValues[0]);
			bean.setValue(beanValues[1]);
			statusList.add(bean);
		}
		return statusList;
	}
	@Override
	public List<CourseName> getCourseNameList(){
		Session session = sessionFactory.getCurrentSession();
		List<CourseName> courseNameList=new ArrayList<>();
		String sql="select A.coursenameid courseid ,coalesce(A.coursename,'') coursename,coalesce(A.coursecode , '') coursecode from coursename A";
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				CourseName courseName=new CourseName();
				Object[] objecList=courseTypeList.get(index);
				courseName.setCoursenameid(Integer.parseInt(objecList[0].toString()));
				courseName.setCoursename(objecList[1].toString());
				courseName.setCourseCode(objecList[2].toString());
				courseNameList.add(courseName);
			}
		}
		return courseNameList;
	}
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		Utility utility=new Utility();
		if(postVacancyTrainingCenterBean.getPostvacancyID() <= 0){
			return utility;
		}
		Session session = sessionFactory.getCurrentSession();
		try{
			StringBuffer sql = new StringBuffer();
			sql.append(" select trainingdate,noofvacancy,loginid,B.coursetypeid,B.coursetype,C.coursenameid,C.coursename,C.coursecode from trainingcentervacancyenrolled A");
			sql.append(" inner join coursetype B on(A.coursetype=B.coursetypeid)");
			sql.append(" inner join coursename C on(A.coursename=C.coursenameid)");
			sql.append(" where postvacancyid="+postVacancyTrainingCenterBean.getPostvacancyID());
			
			Query query = session.createSQLQuery(sql.toString());
			
			List<Object[]> list = query.list();
			if(list.size() > 0){
				utility.setTrainingDate(list.get(0)[0] == null ? "" : list.get(0)[0].toString());
				utility.setNoOfVacancy(Integer.parseInt(list.get(0)[1].toString()));
				utility.setCourseTypeId(Integer.parseInt(list.get(0)[3].toString()));
				utility.setCourseTypeName(list.get(0)[4].toString());
				utility.setCourseNameId(Integer.parseInt(list.get(0)[5].toString()));
				utility.setCourseName(list.get(0)[6].toString());
				utility.setCourseName(list.get(0)[7].toString());
				List<StringStringBean> trainerList=new ArrayList<>();
				for(int i=0;i<list.size();i++){
					StringBuffer sqlBuffer = new StringBuffer();
					sqlBuffer.append("select A.vacancyenrolledid , concat(B.firstname,' ',B.middlename,' ',B.lastname) as name,A.status,C.loginid ");
					sqlBuffer.append(" from trainingcentervacancyenrolled A");
					sqlBuffer.append(" inner join personalinformationtrainer B on(CAST(CAST (A.loginid AS NUMERIC(19,4)) AS INT)=B.logindetails)");
					sqlBuffer.append(" inner join logindetails C on(B.logindetails=C.id)");
					sqlBuffer.append(" where A.postvacancyid="+postVacancyTrainingCenterBean.getPostvacancyID());
					//String loginSQL=" select ve.vacancyenrolledid , concat(pit.firstname,' ',pit.middlename,' ',pit.lastname) as name, ve.status from personalinformationtrainer pit , trainingcentervacancyenrolled ve where logindetails="+list.get(i)[2];
					Query loginSQLSQuery = session.createSQLQuery(sqlBuffer.toString());
					List<Object[]> loginSQLSQuerylist = loginSQLSQuery.list();
					StringStringBean e=new StringStringBean();
					e.setId(loginSQLSQuerylist.get(i)[0] == null ? "" : loginSQLSQuerylist.get(i)[0].toString());
					e.setValue(loginSQLSQuerylist.get(i)[1] == null ? "" : loginSQLSQuerylist.get(i)[1].toString());
					e.setStatus(loginSQLSQuerylist.get(i)[2] == null ? "" : loginSQLSQuerylist.get(i)[2].toString());
					e.setLink(loginSQLSQuerylist.get(i)[3] == null ? "" : loginSQLSQuerylist.get(i)[3].toString());
					trainerList.add(e);
				}
				
				utility.setTrainerList(trainerList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return utility;
	}
	
	@Override
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		Session session = sessionFactory.getCurrentSession();
		//String sql="select coursetype,coursename,trainingdate,noofvacancy,loginid from trainingcentervacancyenrolled tcev";
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append("select B.coursetypeid,C.coursenameid,A.trainingdate,A.noofvacancy,");
		sqlBuffer.append("A.postvacancytrainingcenterid, (select count(1) from trainingcentervacancyenrolled AA where AA.postvacancyid = A.postvacancytrainingcenterid)");
		sqlBuffer.append(" ,A.trainingendtime");
		sqlBuffer.append(" from postvacancytrainingcenter A");
		sqlBuffer.append(" inner join coursetype B on(A.coursetype=B.coursetypeid)");
		sqlBuffer.append(" inner join coursename C on(A.coursename=C.coursenameid) ");
		
		new ZLogger("getAppliedCount","getAppliedCount  "+sqlBuffer.toString(), "TrainingPartnerDaoImpl.java");
		String queryParam="";
		List<PostVacancyTrainingCenter> beans=new ArrayList<>();
		if(postVacancyTrainingCenterBean.getCourseType()>0){
			queryParam+="coursetype="+postVacancyTrainingCenterBean.getCourseType()+" AND ";
		}
		if(postVacancyTrainingCenterBean.getCourseName()>0){
			queryParam+="coursename="+postVacancyTrainingCenterBean.getCourseName() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getTrainingDate()!=null&& postVacancyTrainingCenterBean.getTrainingDate()!=""){
			queryParam+="trainingdate="+postVacancyTrainingCenterBean.getTrainingDate() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getTrainingCenter()>0){
			queryParam+="trainingcenter="+postVacancyTrainingCenterBean.getTrainingCenter() +" AND ";
		}
		if(queryParam!=""){
			int index=queryParam.lastIndexOf(" AND ");
			String str=queryParam.substring(0,index);
			sqlBuffer.append(" where "+str);
			//sql+=" where "+str;
		}
		Query query = session.createSQLQuery(sqlBuffer.toString());
		List<Object[]> list = query.list();
		List<CourseType> courseTypeList=courseTypes();
		List<CourseName> courseNames=getCourseNameList();
		for(int i=0;i<list.size();i++){
			PostVacancyTrainingCenter postVacancyTrainingBean=new PostVacancyTrainingCenter();
			for(CourseType ctpe:courseTypeList){
				if(Integer.parseInt(list.get(i)[0].toString())==ctpe.getCourseTypeId()){
					postVacancyTrainingBean.setCourseType(ctpe);
					break;
				}
			}
			for(CourseName cn:courseNames){
				if(Integer.parseInt(list.get(i)[1].toString())==cn.getCoursenameid()){
					postVacancyTrainingBean.setCourseName(cn);
					break;
				}
			}
			postVacancyTrainingBean.setTrainingDate(list.get(i)[2].toString());
			postVacancyTrainingBean.setNoOfVacancy(Integer.parseInt(list.get(i)[3].toString()));
			postVacancyTrainingBean.setLoginId(list.get(i)[4].toString());
			postVacancyTrainingBean.setNoOfApplications(Integer.parseInt(list.get(i)[5].toString()));
			postVacancyTrainingBean.setTrainingEndTime(list.get(i)[6] == null ? "" : list.get(i)[6].toString());
			beans.add(postVacancyTrainingBean);
		}
		return beans;
	}
	@Override
	public List<PostVacancyTrainingCenterBean> getTrainingCalenderList(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		Session session = sessionFactory.getCurrentSession();
		String sql=" select tc.trainingdate,tc.trainingtime, pitp.trainingcentrename, concat(pit.firstname,' ',pit.middlename,' ',pit.lastname) as name, tc.status from personalinformationtrainingpartner pitp,personalinformationtrainer pit , trainingcentervacancyenrolled ve ,trainingcalendar tc";
		String queryParam="";
		List<PostVacancyTrainingCenterBean> beans=new ArrayList<>();
		if(postVacancyTrainingCenterBean.getCourseType()>0){
			queryParam+="tc.coursetype="+postVacancyTrainingCenterBean.getCourseType()+" AND ";
		}
		if(postVacancyTrainingCenterBean.getCourseName()>0){
			queryParam+="tc.coursename="+postVacancyTrainingCenterBean.getCourseName() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getTrainingDate()!=null&& postVacancyTrainingCenterBean.getTrainingDate()!=""){
			queryParam+="tc.trainingdate="+postVacancyTrainingCenterBean.getTrainingDate() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getTrainingTime()!=null&& postVacancyTrainingCenterBean.getTrainingTime()!=""){
			queryParam+="tc.trainingtime="+postVacancyTrainingCenterBean.getTrainingDate() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getStatus()!=null&& postVacancyTrainingCenterBean.getStatus()!=""){
			queryParam+="tc.status="+postVacancyTrainingCenterBean.getTrainingDate() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getTrainingCenter()>0){
			queryParam+="pitp.personalinformationtrainingpartnerid="+postVacancyTrainingCenterBean.getTrainingCenter() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getLoginId()!=null){
			queryParam+="concat(pit.firstname,' ',pit.middlename,' ',pit.lastname)='"+postVacancyTrainingCenterBean.getLoginId() +"' AND ";
		}
		if(queryParam!=""){
			int index=queryParam.lastIndexOf(" AND ");
			String str=queryParam.substring(0,index);
			sql+=" where "+str;
		}
		Query query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		List<CourseType> courseTypeList=courseTypes();
		List<CourseName> courseNames=getCourseNameList();
		String couserName="";
		String couserTypeName="";
		for(CourseType ctpe:courseTypeList){
			if(postVacancyTrainingCenterBean.getCourseType()==ctpe.getCourseTypeId()){
				couserTypeName=ctpe.getCourseType();
				break;
			}
		}
		for(CourseName cn:courseNames){
			if(postVacancyTrainingCenterBean.getCourseName()==cn.getCoursenameid()){
				couserName=cn.getCoursename();
				break;
			}
		}
		for(int index=0;index<list.size();index++){
			Object[] listObj=list.get(0);
			PostVacancyTrainingCenterBean postVacancyTrainingBean=new PostVacancyTrainingCenterBean();
			postVacancyTrainingBean.setCoursetypeName(couserTypeName);
			postVacancyTrainingBean.setStrCourseName(couserName);
			postVacancyTrainingBean.setTrainingDate(listObj[0].toString());
			postVacancyTrainingBean.setTrainingTime(listObj[1].toString());
			postVacancyTrainingBean.setTrainingCenterName(listObj[2].toString());
			postVacancyTrainingBean.setLoginId(listObj[3].toString());
			postVacancyTrainingBean.setStatus(listObj[4].toString());
			beans.add(postVacancyTrainingBean);
		}
		
		return beans;
	}
	@Override
	public void updateApplicationStatusForEnrolledVacancy(PostVacancyTrainingCenterBean PostVacancyTrainingCenterBean) {
		Session session = sessionFactory.getCurrentSession();
		String[] trainerList=PostVacancyTrainingCenterBean.getLoginId().split(",");
		String[] statusList=PostVacancyTrainingCenterBean.getStatus().split(",");
		for(int index=0;index<trainerList.length;index++){
			PostVacancyTrainingCenterBean pvtcb = (PostVacancyTrainingCenterBean)session.load(PostVacancyTrainingCenterBean.class, Integer.parseInt(trainerList[index]));
			pvtcb.setStatus(statusList[index]);
			session.update(pvtcb);
		}
		
	}
	@Override
	public PostVacancyTrainingCenterBean getApplicationStatusBean(String loginId,int coursename, int cousertype) {
		PostVacancyTrainingCenterBean bean=new PostVacancyTrainingCenterBean();
		Session session = sessionFactory.getCurrentSession();
		String sql="select status from trainingcentervacancyenrolled where loginid='"+loginId +"' AND coursename="+coursename+" AND coursetype="+cousertype;
		Query query = session.createSQLQuery(sql);
		List<String> status = query.list();
		if(status.size()>0){
			bean.setStatus(status.get(0));
		}
		return bean;
	}
	@Override
	public void updateUpcomingTrainingsStatus(int id) {
		Session session = sessionFactory.getCurrentSession();
			String sql="update trainingCalendar set status='A' where trainingCalendarId="+id;
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
	}
	@Override
	public List<TrainingPartnerSearch> getTrainingPartnerDetails(int trainingPartnerId){
		List<TrainingPartnerSearch> listTp = new ArrayList<TrainingPartnerSearch>();
		Session session = sessionFactory.getCurrentSession();
		String sql = "select  tp.trainingpartnername, pitp.trainingcentrename, "
				+ "concat(pitp.trainingpartnerpermanentline1, ', ', pitp.trainingpartnerpermanentline2, ',Ph-', trainingpartnerpermanentmobile, ', ', trainingpartnerpermanentemail) as details, "
				+ "cn.coursename "
				+ "from managetrainingpartner tp "
				+ "inner join personalinformationtrainingpartner pitp on pitp.trainingpartnername = tp.managetrainingpartnerid "
				+ "inner join courseenrolled ce on ce.logindetails = pitp.logindetails "
				+ "inner join coursename cn on cn.coursenameid = ce.coursenameid "
				+ "where tp.managetrainingpartnerid = "+ trainingPartnerId+ ""
						+ " group by tp.trainingpartnername, pitp.trainingcentrename,details, cn.coursename";
		Query query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		for(int index=0;index<list.size();index++){
			TrainingPartnerSearch tpData = new TrainingPartnerSearch();
			Object[] listObj=list.get(index);
			tpData.setTrainingPartnerName(listObj[0].toString());
			tpData.setTrainingCenterName(listObj[1].toString());
			tpData.setDetails(listObj[2].toString());
			tpData.setCourseName(listObj[3].toString());
			listTp.add(tpData);
		}
		return listTp;
	}
	
	@Override
	public String trainingCalendarForm(TrainingCalendarForm trainingCalendarForm) {
		new ZLogger("trainingCalendarForm","trainingCalendarForm  "+trainingCalendarForm.getCourseName(), "TrainingPartnerDaoImpl.java");
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "select coalesce(max(seqNo) + 1,1) from trainingcalendar";
		int maxId = 0 ;
		Query maxIDList = session.createSQLQuery(sql);
		List list = maxIDList.list();
		if(list.size() > 0){
			maxId = (int) list.get(0);
		}
		TrainingCalendar tc = new TrainingCalendar();
		TrainingCalendarHistoryLogs tch =  new TrainingCalendarHistoryLogs();
		
		tc.setCourseType(trainingCalendarForm.getCourseType());
		tc.setCourseName(trainingCalendarForm.getCourseName());
		tc.setTrainingCenter(trainingCalendarForm.getTrainingCenter());
		tc.setTrainingDate(trainingCalendarForm.getTrainingStartDate() == null ? "" : trainingCalendarForm.getTrainingStartDate());
		tc.setTrainingTime(trainingCalendarForm.getTrainingEndDate() == null ? "" : trainingCalendarForm.getTrainingEndDate());
		tc.setTrainerName(trainingCalendarForm.getTrainerName() == null ? "" : trainingCalendarForm.getTrainerName());
		tc.setAssessmentPartnerName(trainingCalendarForm.getAssessmentAgencyName() == null ? "" : trainingCalendarForm.getAssessmentAgencyName());
		tc.setSeatCapacity(trainingCalendarForm.getSeatCapacity() == null ? "" : trainingCalendarForm.getSeatCapacity());
		tc.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime() == null ? "" : trainingCalendarForm.getAssessmentDateTime());
		tc.setType(trainingCalendarForm.getType() == null ? "" : trainingCalendarForm.getType());
		tc.setAssessor(trainingCalendarForm.getAssessor());
		tc.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime() == null ? "" : trainingCalendarForm.getAssessmentDateTime());
		
		
		
		tch.setCourseType(trainingCalendarForm.getCourseType());
		tch.setCourseName(trainingCalendarForm.getCourseName());
		tch.setTrainingCenter(trainingCalendarForm.getTrainingCenter());
		tch.setTrainingDate(trainingCalendarForm.getTrainingStartDate() == null ? "" : trainingCalendarForm.getTrainingStartDate());
		tch.setTrainingTime(trainingCalendarForm.getTrainingEndDate() == null ? "" : trainingCalendarForm.getTrainingEndDate());
		tch.setTrainerName(trainingCalendarForm.getTrainerName() == null ? "" : trainingCalendarForm.getTrainerName());
		tch.setAssessmentPartnerName(trainingCalendarForm.getAssessmentAgencyName() == null ? "" : trainingCalendarForm.getAssessmentAgencyName());
		tch.setSeatCapacity(trainingCalendarForm.getSeatCapacity() == null ? "" : trainingCalendarForm.getSeatCapacity());
		tch.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime() == null ? "" : trainingCalendarForm.getAssessmentDateTime());
		tch.setType(trainingCalendarForm.getType() == null ? "" : trainingCalendarForm.getType());
		tch.setAssessor(trainingCalendarForm.getAssessor());
		tch.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime() == null ? "" : trainingCalendarForm.getAssessmentDateTime());
	
		
		CourseName courseName = (CourseName) session.load(CourseName.class, trainingCalendarForm.getCourseName());
		PersonalInformationTrainingPartner personalInformationTrainingPartner = (PersonalInformationTrainingPartner) session.load(PersonalInformationTrainingPartner.class, trainingCalendarForm.getTrainingCenter());
		tc.setTrainingPartner(personalInformationTrainingPartner.getTrainingPartnerName());
		if(courseName != null && courseName.getCourseCode() != null && courseName.getCourseCode().length() > 1){
			tc.setBatchCode(courseName.getCourseCode()+"/"+StringUtils.leftPad(String.valueOf(maxId), 5, "0"));
			tc.setSeqNo(maxId);
		}
		int i = 0;
	if(trainingCalendarForm.getTcid()==0){
		tch.setCreated_by(trainingCalendarForm.getUserName());
	 i = (Integer) session.save(tc);
	 				session.save(tch);
	}else{
		new ZLogger("trainingCalendarForm","inside update ", "TrainingPartnerDaoImpl.java");
		tc.setTrainingCalendarId(trainingCalendarForm.getTcid());
		tch.setChanged_by(trainingCalendarForm.getUserName());
		 session.update(tc);
		 session.save(tch);
	}
		if(i >0){
			return "created";
		}else{
			return "error";
		}	
	}
	
	
	public void setTrainingCalanderDeatils(TrainingCalendarForm trainingCalendarForm , String loginName){
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "select personalinformationtrainingpartnerid , trainingpartnername   from personalinformationtrainingpartner ptp inner join  logindetails ld on ptp.logindetails = ld.id where ld.loginid ='"+loginName+"'";
		new ZLogger("setTrainingCalanderDeatils","sql "+sql, "TrainingPartnerDaoImpl.java");
		Query query = session.createSQLQuery(sql);
		List<Object[]> status = query.list();
		try{
			if(status.size()>0){
				for(Object[] s : status){
				trainingCalendarForm.setTrainingCenter((int) s[0]);
				trainingCalendarForm.setTrainingPartner((int)s[1]);
				}
			}	
		}catch(Exception e){
			new ZLogger("setTrainingCalanderDeatils","exception while  setTrainingCalanderDeatils  "+e.getMessage(), "TrainingPartnerDaoImpl.java");
		}
		
	}
	
	
	//cancelTrainingCalndar
	
	@Override
	public void cancelTrainingCalndar(int id) {
		Session session = sessionFactory.getCurrentSession();
			String sql="update trainingCalendar set tcStatus='I' where trainingCalendarId="+id;
			Query query = session.createSQLQuery(sql);
			query.executeUpdate();
	}
	
	
	@Override
	public List<IntStringBean> loadAssessmentAgency(){
		Session session = sessionFactory.getCurrentSession();
		List<IntStringBean> trinerNameList=new ArrayList<>();
		String sql="select manageassessmentagencyid , assessmentagencyname from ManageAssessmentAgency";
				
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				IntStringBean bean=new IntStringBean();
				Object[] objecList=courseTypeList.get(index);
				bean.setId(Integer.parseInt(objecList[0].toString()));
				bean.setValue(objecList[1].toString());
				trinerNameList.add(bean);
			}
		}
		return trinerNameList;
	}

	//getBatchCodeList
	
	@Override
	public  List<String> getBatchCodeList(int courseCode){
		Session session = sessionFactory.getCurrentSession();
		List<String> trinerNameList=new ArrayList<>();
		String sql="select batchcode from trainingcalendar where coursename='"+courseCode+"'";
				
		Query query = session.createSQLQuery(sql);
		List<String> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				String objecList=courseTypeList.get(index);
				trinerNameList.add(objecList);
			}
		}
		return trinerNameList;
	}
	
	//getCertificateIdList
	@Override
	public  List<String> getCertificateIdList(String batchCode , String loginId){
		Session session = sessionFactory.getCurrentSession();
		List<String> trinerNameList=new ArrayList<>();
		String sql = null;
		
		if(loginId != null){
			sql="select certificateid from courseenrolleduser    where logindetails='"+loginId+"'";
		}else{
			sql="select ceu.certificateid from courseenrolleduser ceu  inner join trainingcalendar tc on (ceu.trainingcalendarid = tc.trainingcalendarid) where tc.batchcode='"+batchCode+"'";	
		}
		 
				
		Query query = session.createSQLQuery(sql);
		List<String> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				String objecList=courseTypeList.get(index);
				trinerNameList.add(objecList);
			}
		}
		return trinerNameList;
	}
	
	//getTrainingPartnerList
		
	
	
	@Override
	public  List getTrainingPartnerList(String data){
		System.out.println("data "+data);
		String[] datas = data.toString().split("@");
		System.out.println("datas "+datas);
		String courseType,courseName , trainingStartDate , trainingEndDate,trainer , assessmentDateTime , assessmentAgencyName , assessorName , seatCapacity , type ;
		try{
			courseType = datas[0];
		}
		catch(Exception e){
			courseType = "%";	
		}
		
		try{
			courseName = datas[1];	
		}catch(Exception e){
			courseName = "%";	
		}
		
	
		try{
			trainingStartDate = datas[2];
			trainingStartDate = "%"+trainingStartDate.replaceAll("%20", " ");
			System.out.println("trainingStartDate "+trainingStartDate);
		}
		catch(Exception e){
			trainingStartDate = "%";
		}
		
		try{
			trainingEndDate =datas[3];
			trainingEndDate = "%"+trainingEndDate.replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingEndDate = "%";
		}
        
		try{
			trainer = datas[4];
		}
		catch(Exception e){
			trainer = "%";
		}
		
		try{
			assessmentDateTime = datas[5];
			assessmentDateTime = "%"+assessmentDateTime.replaceAll("%20", " ");
		}
		catch(Exception e){
			assessmentDateTime = "%";
		}
		
		try{
			assessmentAgencyName = datas[6];
		}
		catch(Exception e){
			assessmentAgencyName = "%";
		}
		
		try{
			assessorName = datas[7];
		}
		catch(Exception e){
			assessorName = "%";
		}
		
		try{
			seatCapacity = datas[8];
		}
		catch(Exception e){
			seatCapacity = "%";
		}
		
		try{
			type = datas[9];
		}
		catch(Exception e){
			type = "%";
		}
		Session session = sessionFactory.getCurrentSession();
		String	sql = "select A.trainingcalendarid , A.batchcode,C.coursecode,A.trainingdate,A.trainingtime,pitr.firstname || ' '|| pitr.middlename ||' '|| pitr.lastname as participantName   " +
				" , A.coursetype as coursetypeid  , A.coursename as coursenameid , A.trainername as trainernameid , A.assessmentDatetime , A.assessmentpartnername , D.assessmentagencyname ,  A.assessor , cast(E.firstname || ' ' ||  E.middlename || ' ' ||  E.lastname as varchar(100)) , A.seatcapacity , case when  A.type ='P' then 'Paid' else 'Un-Paid'  end as type ,A.type as typecode  from trainingcalendar A " +
				" inner join coursetype B on(A.coursetype=B.coursetypeid)" +
				" inner join coursename C on(A.coursename=C.coursenameid)"+
				" left join ManageAssessmentAgency D on(cast(A.assessmentpartnername as numeric)=D.manageassessmentagencyid)"+
				" left join personalInformationAssessor E on(A.assessor=E.personalinformationassessorid)"+
				" inner join personalinformationtrainer as pitr on CAST(CAST (A.trainername AS NUMERIC(19,4)) AS INT) = pitr.personalinformationtrainerid "
				+" where A.tcStatus is null  and  cast( B.coursetypeid  as varchar(10)) like '"+courseType+"%' " +
						"and  cast(C.coursenameid as varchar(10)) like '"+courseName+"%' and  " +
								"cast(A.trainingdate as varchar(100)) like '"+trainingStartDate+"%' " +
										"and cast(A.trainingtime as varchar(100)) like '"+trainingEndDate+"%' and cast(A.trainername as varchar(100)) like '"+trainer+"%'  and cast(coalesce(A.assessmentdatetime , '') as varchar(100)) like '"+assessmentDateTime+"%' and  cast(A.assessmentpartnername as varchar(100)) like '"+assessmentAgencyName+"%' and  cast(A.assessor as varchar(100)) like '"+assessorName+"%' and  cast(A.seatcapacity as varchar(100)) like '"+seatCapacity+"%'   AND to_timestamp(COALESCE(trainingdate, '19900101010101'),'DD-MM-YYYY') >= CURRENT_TIMESTAMP - INTERVAL '1 days' Order By A.trainingcalendarid desc";
		
		
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	//traineeCenterViewTraineeList
	
	@Override
	public  List traineeCenterViewTraineeList(String name){
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println("name "+name);
		 if(name != null && name.length() > 0 ){
	        	String[] whereList = name.toString().split("@");
	        	for(int i=0;i<whereList.length;i++){
	        		if(i==0){
	        			stringBuffer.append(whereList[0] != null & !whereList[0].equals("null") & whereList[0].length() > 0 ? " AND E.coursetypeid="+whereList[0] : "");
	        		}else if(i==1){
	        			stringBuffer.append(whereList[1] != null & !whereList[1].equals("null") & whereList[1].length() > 0  ? " AND D.COURSENAMEID="+whereList[1] : "");
	        		}else if(i==2){
	        			
	        			stringBuffer.append(whereList[2] != null & !whereList[2].equals("null") & whereList[2].length() > 0 ? " AND B.TRAININGDATE='"+whereList[2].replaceAll("%20", " ")+"'" : "");
	        		}else if(i==3){
	        			
	        			stringBuffer.append(whereList[3] != null & !whereList[3].equals("null") & whereList[3].length() > 0 ? " AND B.TRAININGTIME='"+whereList[3].replaceAll("%20", " ")+"'" : "");
	        		}else if(i==4){
	        			System.out.println(whereList[4]);
	        			stringBuffer.append(whereList[4] != null & !whereList[4].equals("null") & whereList[4].length() > 0   ? " AND A.PAYMENTSTATUS='"+whereList[4]+"'" : "");
	        			
	        		}else if(i==5){
	        			
	        			stringBuffer.append(whereList[5] != null & whereList[5].length() > 0 ? " AND  replace(D.classroom ||''|| D.online,'Nil','')= '"+whereList[5]+"'" : "");
	        		
	        		}
	        	}
	        }
	        
		Session session = sessionFactory.getCurrentSession();
		 String sql ="";
	        sql = "select  B.batchCode,D.courseCode,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,replace(D.classroom ||' '|| D.online,'Nil',''),D.status from courseenrolleduser  A"
					+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
					+ " inner join coursename D on (D.coursenameid = B.coursename)"
					+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
					+ "  inner join personalinformationtrainee C on (C.logindetails = A.logindetails)  "
					+ " inner join logindetails F on(F.id=C.logindetails)";
	        sql = sql + stringBuffer.toString();
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	//searchMarkAttendance
	

	@Override
	public  List searchMarkAttendance(String name){
		String [] n1 = name.split("-");
		System.out.println("name "+name);
		String courseType,courseName , trainingDate , trainingTime ,profileCode;
		
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
			trainingDate = "%"+n1[2].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			trainingTime ="%"+ n1[3].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingTime = "%";
		}
		String userstatus = "";
		

		try{
			profileCode = n1[4].split("=")[1];	
		}catch(Exception e){
			profileCode = "%";	
		}
		if(profileCode.equalsIgnoreCase("5")){
			userstatus = "F.userstaus";
		}else if(profileCode.equalsIgnoreCase("6")){
			userstatus = "F.userstausassessor";
		}
		Session session = sessionFactory.getCurrentSession();
		String newList=null;
		System.out.println("district 0");
		String sql ="";
		
		sql = "select A.batchCode,C.courseCode,A.trainingdate,A.trainingtime,G.firstname||' ' ||G.middlename|| ' ' ||G.lastname as participantName ,G.aadharnumber , courseenrolleduserid , " +userstatus+ " "+
				"from trainingcalendar A inner join coursetype B on(A.coursetype=B.coursetypeid)  inner join coursename C on(A.coursename=C.coursenameid)   inner join personalinformationtrainingpartner D on(A.trainingcenter=D.personalinformationtrainingpartnerid) "+
				"inner join logindetails E on(D.logindetails=E.ID) inner join courseenrolleduser F on(A.trainingcalendarid=F.trainingcalendarid) inner join personalinformationtrainee G on(CAST(CAST (F.logindetails AS NUMERIC(19,4)) AS INT)=G.logindetails)  " +
				"where 1=1 " +
				"and cast(B.coursetypeid as varchar(10)) like '"+courseType+"%'  and cast( C.coursenameid as varchar(10)) like  '"+courseName+"%' and cast(trainingdate as varchar(10)) like '"+trainingDate+"%' and trainingtime  like '"+trainingTime+"%'   ";
		
	
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	//traineeCenterPaymentConfirmation
	
	@Override
	public  List traineeCenterPaymentConfirmation(String name){
		String[] n1 = name.split("-");
		System.out.println("name "+name);
		String courseType,courseName , trainingDate , trainingtime,status ;
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
			trainingDate = "%"+n1[2].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			trainingtime = "%"+n1[3].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingtime = "%";
		}
        
		try{
			status = n1[4].split("=")[1];
		}
		catch(Exception e){
			status = "%";
		}
		Session session = sessionFactory.getCurrentSession();
		String sql = "";
		sql = "select  B.batchcode,D.coursecode,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,D.modeoftraining,A.paymentstatus,A.courseenrolleduserid from courseenrolleduser  A"
				+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
				+ " inner join personalinformationtrainingpartner C on (C.personalinformationtrainingpartnerid = B.trainingcenter)"
				+ " inner join coursename D on (D.coursenameid = B.coursename)"
				+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
				+ " inner join logindetails F on (F.ID = C.logindetails)"
				+" WHERE A.status = 'N' and B.type not in ('U')  and  cast(E.coursetypeid  as varchar(10)) like '"+courseType+"%' and cast(D.COURSENAMEID as varchar(10))  like '"+courseName+"%'  and  cast(B.TRAININGDATE as varchar(10)) like '"+trainingDate+"%' and  cast(B.TRAININGTIME as varchar(10)) like '"+trainingtime+"%'  and cast(A.paymentstatus as varchar(10)) like '"+status+"%' "; 
					//	"  AND F.loginid ='"+loginId+"' ";
		
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	//trainingpartnermanagetrainer
	
	@Override
	public  List trainingpartnermanagetrainer(String name){
		String[] n1 = name.split("-");
		System.out.println("name "+name);
		String courseType,courseName , trainingDate , trainingtime,status ;
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
			trainingDate = "%"+n1[2].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			trainingtime = "%"+n1[3].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingtime = "%";
		}
        
		try{
			status = n1[4].split("=")[1];
		}
		catch(Exception e){
			status = "%";
		}
		Session session = sessionFactory.getCurrentSession();
		String sql = "";
		sql = "select  B.batchcode,D.coursecode,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName,D.modeoftraining,A.paymentstatus,A.courseenrolleduserid from courseenrolleduser  A"
				+ " inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid)"
				+ " inner join personalinformationtrainingpartner C on (C.personalinformationtrainingpartnerid = B.trainingcenter)"
				+ " inner join coursename D on (D.coursenameid = B.coursename)"
				+ " inner join coursetype E on (E.coursetypeid = B.coursetype)"
				+ " inner join logindetails F on (F.ID = C.logindetails)"
				+" WHERE A.status = 'N' and  cast(E.coursetypeid  as varchar(10)) like '"+courseType+"%' and cast(D.COURSENAMEID as varchar(10))  like '"+courseName+"%'  and  cast(B.TRAININGDATE as varchar(10)) like '"+trainingDate+"%' and  cast(B.TRAININGTIME as varchar(10)) like '"+trainingtime+"%'  and cast(A.paymentstatus as varchar(10)) like '"+status+"%' "; 
					//	"  AND F.loginid ='"+loginId+"' ";
		
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	//searchVacancy
	
	
	@Override
	public  List searchVacancy(String name){
		String [] n1 = name.split("@");
		
		String courseType,courseName , trainingDate , requiredExp ,noOfVacancy,selectAll, trainingendtime, trainingcenter;
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
			trainingDate = "%"+n1[2].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			requiredExp = n1[3].split("=")[1];
		}
		catch(Exception e){
			requiredExp = "%";
		}
		
		try{
			noOfVacancy = n1[4].split("=")[1];
		}
		catch(Exception e){
			noOfVacancy = "%";
		}
		
		try{
			trainingcenter = n1[5].split("=")[1];
		}
		catch(Exception e){
			trainingcenter = "%";
		}
		
		try{
			trainingendtime = "%"+n1[6].split("=")[1].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingendtime = "%";
		}
		Session session = sessionFactory.getCurrentSession();
		System.out.println("district 0");
		String loginCK = "";
		loginCK = "1=1";
		String sql ="";
		sql = "select pvtc.postvacancytrainingcenterid , ct.coursetype , cn.coursecode , pvtc.trainingdate , pvtc.trainingendtime ,pvtc.requiredexp , pvtc.noofvacancy,pvtc.loginid   from postvacancytrainingcenter pvtc left join coursetype as ct on ct.coursetypeid = pvtc.coursetype left join coursename as cn on cn.coursenameid = pvtc.coursename left join personalinformationtrainingpartner D on(pvtc.trainingcenter=D.personalinformationtrainingpartnerid)  left join  logindetails E on(D.logindetails=E.ID) " +
				" where "+loginCK+"  and pvtc.trainingcenter='"+trainingcenter+"'  and  cast(ct.coursetypeid as varchar(10))  like '"+courseType+"%' and CAST(cn.coursenameid AS VARCHAR(10)) like '"+courseName+"%' and  CAST(pvtc.trainingdate AS VARCHAR(100)) like '"+trainingDate+"%'   and cast(pvtc.requiredexp as varchar(10))  like '"+requiredExp+"%' and cast(pvtc.noofvacancy as varchar(10)) like '"+noOfVacancy+"%'  and cast(pvtc.trainingendtime as varchar(100)) like   '"+trainingendtime+"%'  ";
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	//updateAttendanceStatus
	
	
	@Override
	public  String updateAttendanceStatus(String name){
		String[] updateDetails = name.split("-");

		String id , status ;	
		id= (updateDetails[0].split("="))[1];
		
		status = (updateDetails[1].split("="))[1];
		String profileID =  (updateDetails[2].split("="))[1];
		Session session = sessionFactory.getCurrentSession();
		CourseEnrolledUser courseEnrolledUser = (CourseEnrolledUser) session.load(CourseEnrolledUser.class, Integer.parseInt(id));
		if(profileID.equalsIgnoreCase("5")){
			courseEnrolledUser.setUserStaus(status);
		}else if(profileID.equalsIgnoreCase("6")){
			courseEnrolledUser.setUserStausAssessor(status);
		}
		
		String result ="Recors successfully updated !!!" ;
		
		
		session.update(courseEnrolledUser);
		
		return result;
		
	
	}
	
	
	//SearchUpcomingTraining
	
	
	@Override
	public  List SearchUpcomingTraining(String id){
		
		Session session = sessionFactory.getCurrentSession();
	
		String sql ="select tc.trainingcalendarid , concat(pitp.trainingpartnerpermanentline1 , ' ' , pitp.trainingpartnerpermanentline2 , ' ' , s.statename , ' ' , d.districtname , ' ' , c.cityname) as address, "+
				" concat(tc.trainingdate , ' / ' , tc.trainingtime) as schedule , "+
				" concat(pitp.firstname , ' ' , pitp.middlename , ' ' , pitp.lastname ) ,concat( pitp.trainingpartnerpermanentmobile , ' / ' , pitp.trainingpartnerpermanentemail)  as contact, "+
				" (select count(1) from courseenrolleduser A where A.trainingcalendarid = tc.trainingcalendarid) , tc.seatcapacity , ct.coursetype "+
				"  , cn.coursename  , tc.status,cn.coursecode,tc.batchcode from trainingcalendar as tc "+
				" inner join coursename as cn on cn.coursenameid = tc.coursename "+
				" inner join coursetype as ct on ct.coursetypeid = tc.coursetype "+
				" inner join managetrainingpartner as mtp on mtp.managetrainingpartnerid = tc.trainingpartner "+
				" inner join personalinformationtrainingpartner as pitp on mtp.managetrainingpartnerid = pitp.trainingpartnername "+
				" inner join logindetails as log on log.id = pitp.logindetails "+
				" inner join state as s on s.stateid = pitp.trainingpartnerpermanentstate "+
				" inner join city as c on c.cityid = pitp.trainingpartnerpermanentcity "+
				" inner join district as d on d.districtid = pitp.trainingpartnerpermanentdistrict "+
				" and tc.trainingcenter = pitp.personalinformationtrainingpartnerid where to_timestamp(COALESCE(tc.trainingdate, '19900101010101'),'DD-MM-YYYY') >= CURRENT_TIMESTAMP - INTERVAL '1 days'";// and tc.trainingcenter='"+id+"'";
				//" WHERE log.id = "+userId;
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	//searchTrainingCenterList
	
	@Override
	public  List searchTrainingCenterList(String id){
		
		Session session = sessionFactory.getCurrentSession();
System.out.println("id "+id);
	
String sql ="select mtp.managetrainingpartnerid as id, mtp.trainingpartnername , count(pitp.trainingpartnername) from personalinformationtrainingpartner as pitp "+ 
		" inner join managetrainingpartner as mtp on pitp.trainingpartnername = mtp.managetrainingpartnerid "+
		"  inner join logindetails as ld on pitp.logindetails = ld.id where ld.status='I' "+
		//"   and mtp.managetrainingpartnerid = 133 "+
		" group by mtp.trainingpartnername , mtp.managetrainingpartnerid ";	
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	//onLoadTrainingPartnerCenterId
	
	@Override
	public  List onLoadTrainingPartnerCenterId(String id){
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("id "+id);
	
		String sql ="select mtp.managetrainingpartnerid as id, mtp.trainingpartnername , count(pitp.trainingpartnername) from personalinformationtrainingpartner as pitp "+ 
		" inner join managetrainingpartner as mtp on pitp.trainingpartnername = mtp.managetrainingpartnerid "+
		"  inner join logindetails as ld on pitp.logindetails = ld.id where ld.status='I' "+
		//"   and mtp.managetrainingpartnerid = 133 "+
		" group by mtp.trainingpartnername , mtp.managetrainingpartnerid ";	
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	//markTraineeAttendance
	
	@Override
	public String markTraineeAttendance(String rollNo){
	
		Session session = sessionFactory.getCurrentSession();
		String result = null;
		String sql="select  to_date(trainingdate , 'DD-MM-YYYY') trainingdate ,  to_date(trainingtime , 'DD-MM-YYYY') trainingtime,cast(now() as date)  today from trainingcalendar as tc inner join courseenrolleduser ceu on ceu.trainingcalendarid = tc.trainingcalendarid where rollno ='"+rollNo+"' ";
		try{
			Query query = session.createSQLQuery(sql);
			List<Object[]> list = query.list();
			System.out.println("size "+list.size());
			if(list.size() > 0){
				
				String trainingStartDate = list.get(0)[0] == null ? "" : list.get(0)[0].toString();
				String trainingEndDate = list.get(0)[1] == null ? "" : list.get(0)[1].toString();
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
				 Date trainingStartDateNew = new SimpleDateFormat("yyyy-MM-dd").parse(trainingStartDate.toString());
				 Date trainingEndDateNew = new SimpleDateFormat("yyyy-MM-dd").parse(trainingEndDate.toString());
				 Date testDate = new SimpleDateFormat("yyyy-MM-dd").parse(modifiedDate.toString());
				 
				 boolean  iswithinRange = isWithinRange(testDate, trainingStartDateNew , trainingEndDateNew);
				 if(iswithinRange){
					 Session session2 = sessionFactory.getCurrentSession();
					 Criteria criteria = session2.createCriteria(TraineeDailyAttendance.class);
						criteria.add(Restrictions.eq("rollNumber", rollNo));
						criteria.add(Restrictions.eq("attendanceDate", modifiedDate));
						
						List l = criteria.list();
						System.out.println("l.size() "+l.size());
						if(l != null && l.size() > 0){
							result ="Attendance is already marked for date "+modifiedDate;
						
						}else{
							Session session1 = sessionFactory.getCurrentSession();
							TraineeDailyAttendance traineeAtt = new TraineeDailyAttendance();
							traineeAtt.setRollNumber(rollNo);
							traineeAtt.setAttendanceDate(modifiedDate);
							int attId = (Integer) session1.save(traineeAtt);
							if(attId>0){
							result ="Attendance successfully marked for Roll Number "+rollNo;
							}
						}
				 }else{
					 result = "Training is already Completed."; 
				 }
				 System.out.println("iswithinRange "+iswithinRange);
				new ZLogger("markTraineeAttendance", "markTraineeAttendance", "CommonDaoImpl.java");
				
			}else{
				result ="No Course Enrolled ";	
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		}

		return result;
	}
	
	boolean isWithinRange(Date testDate ,Date startDate , Date endDate ) {
		System.out.println(" input "+ " testDate "+testDate + " startDate "+startDate + " endDate "+endDate );
		   return !(testDate.before(startDate) || testDate.after(endDate));
		}

	//updateTrainingCalendar
	
	public String updateTrainingCalendar(String data){
		String[] updateDetails = data.split("@");

		String id , assessmentDateTime ;	
		assessmentDateTime= (updateDetails[0].split("="))[1];
		
		id = (updateDetails[1].split("="))[1];
		
		Session session = sessionFactory.getCurrentSession();
		System.out.println("id "+id + " assessmentDateTime "+assessmentDateTime);
		TrainingCalendar c = new TrainingCalendar();

		String sql="update trainingcalendar  set assessmentdatetime='"+assessmentDateTime+"' where trainingcalendarid="+Integer.parseInt(id);
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
		
		
		
		String result ="Recors successfully updated !!!" ;
		return result;
	}
	
	//certificateForTraineeList
	
	
	
	
	@Override
	public  List certificateForTraineeList(String name){
		String[] n1 = name.split("@");

		String courseType,courseName ,batchCode ,trainingDate , trainingtime,id ;
		try{
			courseType = n1[0];
		}
		catch(Exception e){
			courseType = "%";	
		}
		
		try{
			courseName = n1[1];	
		}catch(Exception e){
			courseName = "%";	
		}
		
		try{
			batchCode = n1[2];	
		}catch(Exception e){
			batchCode = "%";	
		}
		
	
		try{
			trainingDate = "%"+n1[3].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingDate = "%";
		}
		
		try{
			trainingtime = "%"+n1[4].replaceAll("%20", " ");
		}
		catch(Exception e){
			trainingtime = "%";
		}
        
		try{
			id = n1[5];
		}
		catch(Exception e){
			id = "%";
		}
		Session session = sessionFactory.getCurrentSession();
		String sql = "";
		sql = "select  B.batchCode,D.courseCode,B.trainingdate,B.trainingtime,C.firstname || ' '|| C.middlename ||' '|| C.lastname as participantName , A.certificateid , pitp.firstname   ,"
				+ " concat(pitp.trainingcentrename , ' ' , s.statename, ' ' , ds.districtname) as address , A.result , A.logindetails ,  pit.personalinformationtraineeid  "
				+ " from courseenrolleduser  A inner join trainingcalendar B on(A.trainingcalendarid= B.trainingcalendarid) "
				+ " inner join personalinformationtrainingpartner pitp on (pitp.personalinformationtrainingpartnerid = B.trainingcenter)"
				+ " inner join state as s on s.stateid = pitp.trainingpartnerpermanentstate "
				+ " inner join district as ds on ds.districtid = pitp.trainingpartnerpermanentdistrict "
				+ " inner join personalinformationtrainee pit on (A.logindetails = pit.logindetails)"
				+ " inner join coursename D on (D.coursenameid = B.coursename) inner join coursetype E on (E.coursetypeid = B.coursetype)  inner join personalinformationtrainee C on (C.logindetails = A.logindetails)   inner join logindetails F on(F.id=C.logindetails)"
				+" and pitp.logindetails = '"+id+"'  and A.status='N'   and cast(B.batchCode as varchar(100)) like '"+batchCode+"%' and cast(E.coursetypeid as varchar(20))  like '%"+courseType+"' and  cast(D.coursenameid as varchar(20)) like '%"+courseName+"'  and cast(B.trainingdate as varchar(100)) like '%"+trainingDate+"'   and cast(B.trainingtime as varchar(100)) like '%"+trainingtime+"' "; 
				
		
		
		Query query = session.createSQLQuery(sql);
		List courseTypeList = query.list();
		return courseTypeList;
	}
	
	
	//certificateForTraineeList
	
	
	//searchDataTP
	
	
	@Override
	public  List searchDataTP(String name){

		System.out.println("passing name   :" + name);
		String[] totalConnected = name.split("-");
		String id="",tpname="", fcn = "",websiteURL= "",pan= "",email="",headOfficeDataAddress1="",headOfficeDataAddress2="",pin="",stateId="",district="",city="",status="";
		
		
		if(!name.equalsIgnoreCase("ALL")){
			try{
				id = (totalConnected[0].split("="))[1];	
			}
			catch(Exception e){
				id ="%";	
			}
			try{
				tpname = (totalConnected[1].split("="))[1];
			}
			catch(Exception e)
			{
				tpname = "%";	
			}
			try{
				websiteURL = (totalConnected[2].split("="))[1];	
			}catch(Exception e)
			{
				websiteURL = "%";
			}
		try{
			pan = (totalConnected[3].split("="))[1];
		}
		catch(Exception e)
		{
			pan = "%";
		}
		try{
			email = (totalConnected[4].split("="))[1];
		}
		catch(Exception e){
			email = "%";
		}
		try{
			headOfficeDataAddress1 = (totalConnected[5].split("="))[1];
		}catch(Exception e)
		{
			headOfficeDataAddress1 = "%";
		}
		try{
			headOfficeDataAddress2 = (totalConnected[6].split("="))[1];
		}
		catch(Exception e){
			headOfficeDataAddress2 = "%";
		}
		try{
			pin = (totalConnected[1].split("="))[7];	
		}
		catch(Exception e){
			pin = "%";
		}
		try{
			stateId = (totalConnected[8].split("="))[1];
		}
		catch(Exception e){
			stateId = "%";
		}
		try{
			district = (totalConnected[9].split("="))[1];
		}
		catch(Exception e){
			district = "%";
		}
		try{
			city = (totalConnected[10].split("="))[1];
		}
		catch(Exception e){
			city = "%";
		}
		try{
			status = (totalConnected[11].split("="))[1];
		}
		catch(Exception e){
			status = "%";
		}
		
		String[] tpnameA  = tpname.split("%20");
		String cn = "";
		for(int i = 0 ; i < tpnameA.length ; i++){
			cn = cn + tpnameA[i] + " ";
		}
		
		fcn = cn.substring(0, cn.length()-1);
		System.out.println(fcn.length()  + "   "+ fcn);
		}
		Session session = sessionFactory.getCurrentSession();
		
		String sql = null;
		if(!name.equalsIgnoreCase("ALL"))
		 sql ="select mtp.managetrainingpartnerid  , ld.loginid  , mtp.trainingpartnername , mtp.pan , "+
					" mtp.websiteurl , (CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus from managetrainingpartner as mtp "+
					" inner join logindetails as ld on ld.id=mtp.logindetails "+
					" where upper(mtp.trainingpartnername) like '"+fcn.toUpperCase() +"%' and ld.loginid like '"+id+"%' "+
					 " and mtp.trainingpartnername like '"+tpname+"%' and mtp.pan like '"+pan+"%' and mtp.websiteurl like '"+websiteURL+"%' " +
					 " and mtp.email like '"+email+"%' and mtp.headOfficeDataAddress1 like '"+headOfficeDataAddress1+"%' " +
					 " and mtp.headOfficeDataAddress2 like '"+headOfficeDataAddress2+"%' and mtp.pin like '"+pin+"%' and cast(mtp.state as varchar) like '"+stateId+"'" +
					 "and cast(mtp.district as varchar) like '"+district+"' and cast(mtp.city as varchar) like '"+city+"' and ld.status like '"+status+"%'" ;
		else
			 sql ="select mtp.managetrainingpartnerid  , ld.loginid  , mtp.trainingpartnername , mtp.pan , "+
						" mtp.websiteurl , (CASE WHEN ld.isActive = 'Y' THEN 'INACTIVE' ELSE 'ACTIVE' END) as updateStatus ,(CASE WHEN ld.isActive = 'Y' THEN 'ACTIVE' ELSE 'INACTIVE' END) as currentstatus from managetrainingpartner as mtp "+
						" inner join logindetails as ld on ld.id=mtp.logindetails ";
			
		Query query = session.createSQLQuery(sql);
		System.out.println("sql===>"+sql);
		List<CourseName> list = query.list();
		return list;
	}
	
	
	//editMTP
	

	@Override
	public  List editMTP(String name){
		
		Session session = sessionFactory.getCurrentSession();
		String sql=" select mtp.managetrainingpartnerid  , ld.loginid  ,  mtp.pan , mtp.trainingpartnername , ld.status , "+
				" mtp.websiteurl , mtp.headofficedataaddress1 , mtp.headofficedataaddress2 ,mtp.pin ,  "+
			  " s.stateid , d.districtid , c.cityid , mtp.email "+
				" from managetrainingpartner as mtp "+
				" inner join logindetails as ld on ld.id = mtp.logindetails "+
				" inner join district as d on d.districtid = mtp.district "+
				" inner join city as c on c.cityId = mtp.city "+
				" inner join state as s on s.stateid = mtp.state "+
				" where mtp.managetrainingpartnerid = '"+ name+"' ";
		
		Query query = session.createSQLQuery(sql);
		List<CourseName> list = query.list();
		
		return list;
	}
	
	//updateMTP
	@Override
	public  String updateMTP(String name){
		String [] total = name.toString().split("-");
		System.out.println(total);
		String status = total[0];
		System.out.println("status "+status);
		String url = total[1];
		String email = total[2];
		String address1 = total[3];
		String address2 = total[4];
		String pin = total[5];
		String state = total[6];
		String district = total[7];
		String city = total[8];
		String mtpId = total[9];
		String isActive = (status.equalsIgnoreCase("A") ? "Y" : "N");
		System.out.println("status>"+status+url+email+address1+address2+pin+state+district+city+mtpId);

		State s = new State();
		s.setStateId(Integer.parseInt(state));
		District d = new District();
		d.setDistrictId(Integer.parseInt(district));
		City c = new City();
		c.setCityId(Integer.parseInt(city));
		Session session = sessionFactory.getCurrentSession();
		String selectLoginDetails = "select logindetails from managetrainingpartner where managetrainingpartnerid = '"+mtpId+"'";
		Query querySel = session.createSQLQuery(selectLoginDetails);
		String selectSel = querySel.getQueryString();
		System.out.println("login id is   :"+ selectSel);
		String sql="UPDATE managetrainingpartner "+
				" SET city='"+c.getCityId()+"',  "+
				" district='"+d.getDistrictId()+"', email='"+email+"', "+
				" headofficedataaddress1='"+address1+"', headofficedataaddress2='"+address2+"', "+
				" pin='"+pin+"', state='"+s.getStateId()+"' , "+
				" websiteurl='"+url+"' "+
				" WHERE managetrainingpartnerid = '"+mtpId+"' ";

		String sqlLD = "update logindetails set status ='"+status+"' , isactive = '"+isActive+"' where id =("+selectSel+")"; 
		Query query = session.createSQLQuery(sql);
		Query query2 = session.createSQLQuery(sqlLD);
		System.out.println(sql);
		
		Integer i = query.executeUpdate();
		System.out.println("i  :"+ i);
		Integer j = query2.executeUpdate();
		System.out.println("j  :"+ j);
		System.out.println("sql==>"+sqlLD);
		String newList = null ;
		if(i > 0 ){
			System.out.println("data selected finally  " );
			newList = "Data updated successfully"; 
		}else{
			newList = "Oops , something went wrong try ageain !!!";
		}
		
		
		return newList;
	}
	
}
