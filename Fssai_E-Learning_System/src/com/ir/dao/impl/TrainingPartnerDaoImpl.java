package com.ir.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.trainingPartner.TrainingPartnerSearch;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.TrainingCalendar;
import com.ir.model.TrainingCalendarHistoryLogs;
import com.ir.model.Utility;
import com.ir.util.ChangePasswordUtility;

@Repository
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
		
		System.out.println("hkhkhk");
		String sql = "select * from PostVacancyTrainingCenter where CourseType = '"+postVacancyTrainingCenterForm.getCourseType()+"' and CourseName = '" + postVacancyTrainingCenterForm.getCourseName()+"' and TrainingDate = '"+ postVacancyTrainingCenterForm.getTrainingDate()+"'";
		Query query = session.createSQLQuery(sql);
		List l = query.list();
		if(l != null && l.size() > 0){
			return "error";
		}else{
			CourseType ct = getCourseType(postVacancyTrainingCenterForm.getCourseType());
			CourseName cn = getCourseName(postVacancyTrainingCenterForm.getCourseName());
			//LoginDetails loginDetails = loginDetails.setLoginId(postVacancyTrainingCenterForm.getLoginId());
			postVacancyTrainingCenter.setNoOfVacancy(postVacancyTrainingCenterForm.getNoOfVacancy());
			postVacancyTrainingCenter.setRequiredExp(postVacancyTrainingCenterForm.getRequiredExp());
			//postVacancyTrainingCenter.setTrainingDate(postVacancyTrainingCenterForm.getTrainingDate());
			postVacancyTrainingCenter.setCourseName(cn);
			postVacancyTrainingCenter.setCourseType(ct);
			postVacancyTrainingCenter.setVacancyType(postVacancyTrainingCenterForm.getVacancyType());
			postVacancyTrainingCenter.setTrainingDate(postVacancyTrainingCenterForm.getTrainingDate());
			postVacancyTrainingCenter.setTrainingEndTime(postVacancyTrainingCenterForm.getTrainingEndTime());
			postVacancyTrainingCenter.setLoginId(postVacancyTrainingCenterForm.getLoginId());
			postVacancyTrainingCenter.setTrainingCenter(p);
			postVacancyTrainingCenterIdd = (Integer) session.save(postVacancyTrainingCenter);
			System.out.println("post Vacancy TrainingCenter after save");
			if(postVacancyTrainingCenterIdd >0 && postVacancyTrainingCenterIdd != null){
				return "created";
			}else{
				return "error";
			}
		}
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
		//String idd=changePasswordForm.getLoginid();
		System.out.println("new pass   "+oldPassword);
		
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
				
		//"select pit.logindetails,pit.firstname,pit.middlename,pit.lastname from personalinformationtrainer pit,personalinformationtrainingpartner pitp";// where pit.logindetails=pitp.logindetails";
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
				
		//"select pit.logindetails,pit.firstname,pit.middlename,pit.lastname from personalinformationtrainer pit,personalinformationtrainingpartner pitp";// where pit.logindetails=pitp.logindetails";
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
		//"select pit.logindetails,pit.firstname,pit.middlename,pit.lastname from personalinformationtrainer pit,personalinformationtrainingpartner pitp";// where pit.logindetails=pitp.logindetails";
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
		StringBuffer userCondition = new StringBuffer();
	
		String sql="select distinct A.personalinformationtrainingpartnerid  from personalinformationtrainingpartner A " +
				" inner join logindetails B on(A.logindetails=B.id) where logindetails='"+userId+"'";
		
	System.out.println(" sql "+sql);
		Query query = session.createSQLQuery(sql);
		List list = query.list();
		
			if(list.size() > 0){
				trainingCenter = (int) list.get(0);
				System.out.println("trainingCenter "+trainingCenter);
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
		System.out.println("sql "+sql);
		Query query1 = session.createSQLQuery(sql);
		List<String> status = query1.list();
		try{
			if(status.size()>0){
				System.out.println("status.get(0).toString() == "+status.get(0).toString());
				trainerExp = Float.parseFloat(status.get(0).toString());
			}	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("e "+e.getMessage());
		}
		
		Query query = session.createQuery("from PostVacancyTrainingCenter A where  to_timestamp(COALESCE(A.trainingDate, '19900101010101'),'DD-MM-YYYY HH24:MI')  > now() AND A.requiredExp <= "+trainerExp);
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
			//String sql="select trainingdate,noofvacancy,loginid from trainingcentervacancyenrolled where postvacancyid="+postVacancyTrainingCenterBean.getPostvacancyID();
			StringBuffer sql = new StringBuffer();
			sql.append(" select trainingdate,noofvacancy,loginid,B.coursetypeid,B.coursetype,C.coursenameid,C.coursename,C.coursecode from trainingcentervacancyenrolled A");
			sql.append(" inner join coursetype B on(A.coursetype=B.coursetypeid)");
			sql.append(" inner join coursename C on(A.coursename=C.coursenameid)");
			sql.append(" where postvacancyid="+postVacancyTrainingCenterBean.getPostvacancyID());
			
			Query query = session.createSQLQuery(sql.toString());
			
			List<Object[]> list = query.list();
			List<CourseType> courseTypeList=courseTypes();
			List<CourseName> courseNames=getCourseNameList();
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
				/*for(Object[] obj:list){
					String loginSQL=" select ve.vacancyenrolledid , concat(pit.firstname,' ',pit.middlename,' ',pit.lastname) as name from personalinformationtrainer pit , trainingcentervacancyenrolled ve where logindetails="+Integer.parseInt(list.get(0)[2].toString());
					Query loginSQLSQuery = session.createSQLQuery(loginSQL);
					List<Object[]> loginSQLSQuerylist = loginSQLSQuery.list();
					StringStringBean e=new StringStringBean();
					e.setId(loginSQLSQuerylist.get(0)[0].toString());
					e.setValue(loginSQLSQuerylist.get(0)[1].toString());
					trainerList.add(e);
				}*/
				
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
		
		System.out.println("Application Status == "+sqlBuffer.toString());
		
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
			System.out.println("****************************"+statusList[index]);
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
		System.out.println("********  "+trainingCalendarForm.getCourseName());
		Session session = sessionFactory.getCurrentSession();
		
		String sql = "select coalesce(max(seqNo) + 1,1) from trainingcalendar";
		int maxId = 0 ;
		Query maxIDList = session.createSQLQuery(sql);
		List list = maxIDList.list();
		System.out.println(list.size());
		if(list.size() > 0){
			maxId = (int) list.get(0);
			//eligible = (String) list.get(0);
		}
		TrainingCalendar tc = new TrainingCalendar();
		TrainingCalendarHistoryLogs tch =  new TrainingCalendarHistoryLogs();
		tc.setCourseType(trainingCalendarForm.getCourseType());
		tc.setCourseName(trainingCalendarForm.getCourseName());
		tc.setTrainingCenter(trainingCalendarForm.getTrainingCenter());
		tc.setTrainingDate(trainingCalendarForm.getTrainingStartDate());
		tc.setTrainingTime(trainingCalendarForm.getTrainingEndDate());
		tc.setTrainerName(trainingCalendarForm.getTrainerName());
		tc.setAssessmentPartnerName(trainingCalendarForm.getAssessmentAgencyName());
		tc.setSeatCapacity(trainingCalendarForm.getSeatCapacity());
		tc.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime());
		tc.setType(trainingCalendarForm.getType());
		tc.setAssessor(trainingCalendarForm.getAssessor());
		tc.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime());
		
		
		
		tch.setCourseType(trainingCalendarForm.getCourseType());
		tch.setCourseName(trainingCalendarForm.getCourseName());
		tch.setTrainingCenter(trainingCalendarForm.getTrainingCenter());
		tch.setTrainingDate(trainingCalendarForm.getTrainingStartDate());
		tch.setTrainingTime(trainingCalendarForm.getTrainingEndDate());
		tch.setTrainerName(trainingCalendarForm.getTrainerName());
		tch.setAssessmentPartnerName(trainingCalendarForm.getAssessmentAgencyName());
		tch.setSeatCapacity(trainingCalendarForm.getSeatCapacity());
		tch.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime());
		tch.setType(trainingCalendarForm.getType());
		tch.setAssessor(trainingCalendarForm.getAssessor());
		tch.setAssessmentDateTime(trainingCalendarForm.getAssessmentDateTime());
		
		System.out.println("---->"+trainingCalendarForm.getTcid());
		CourseName courseName = (CourseName) session.load(CourseName.class, trainingCalendarForm.getCourseName());
		PersonalInformationTrainingPartner personalInformationTrainingPartner = (PersonalInformationTrainingPartner) session.load(PersonalInformationTrainingPartner.class, trainingCalendarForm.getTrainingCenter());
		tc.setTrainingPartner(personalInformationTrainingPartner.getTrainingPartnerName());
		if(courseName != null && courseName.getCourseCode() != null && courseName.getCourseCode().length() > 1){
			tc.setBatchCode(courseName.getCourseCode()+"/"+StringUtils.leftPad(String.valueOf(maxId), 5, "0"));
			tc.setSeqNo(maxId);
		}
		int i = 0;
	if(trainingCalendarForm.getTcid()==0){
		System.out.println("inside create");
		System.out.println("username "+trainingCalendarForm.getUserName());
		tch.setCreated_by(trainingCalendarForm.getUserName());
	 i = (Integer) session.save(tc);
	 				session.save(tch);
	}else{
		System.out.println(" inside update");
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
		System.out.println("sql "+sql);
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
			System.out.println("e "+e.getMessage());
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
				System.out.println(objecList);
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
				System.out.println(objecList);
				trinerNameList.add(objecList);
			}
		}
		return trinerNameList;
	}
		
}
