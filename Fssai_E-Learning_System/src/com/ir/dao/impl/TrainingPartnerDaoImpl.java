package com.ir.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;
import com.ir.dao.TrainingPartnerDao;
import com.ir.form.ChangePasswordForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
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
		Session s = sessionFactory.openSession();
		CourseType courseType = (CourseType)s.load(CourseType.class, id);
		s.close();
		return courseType;
	}
	@Override
	public CourseName getCourseName(int id){
		Session s = sessionFactory.openSession();
		CourseName courseName = (CourseName)s.load(CourseName.class, id);
		s.close();
		return courseName;
	}
	@Override
	public PersonalInformationTrainingPartner getPersonalInformationTrainingPartner(int id){
		Session s = sessionFactory.openSession();
		PersonalInformationTrainingPartner personalInformationTrainingPartner = (PersonalInformationTrainingPartner)s.load(PersonalInformationTrainingPartner.class, id);
		s.close();
		return personalInformationTrainingPartner;
	}
	@Override
	public List<PersonalInformationTrainingPartner> trainingCenterList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PersonalInformationTrainingPartner");
		List<PersonalInformationTrainingPartner> personalInformationTrainingPartner = query.list();
		session.close();
		return personalInformationTrainingPartner;
	}

	@Override
	public List<CourseType> courseTypeList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		session.close();
		return courseTypeList;
	}

	@Override
	public String postVacancyTrainingPartner(PostVacancyTrainingCenterForm postVacancyTrainingCenterForm) {
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
	public int saveVacancy(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		Session session = sessionFactory.openSession();
		Integer isapplied=0;
		Transaction tx=session.beginTransaction();
		Query sql=session.createSQLQuery("select * from trainingcentervacancyenrolled where coursetype= "+postVacancyTrainingCenterBean.getCourseType()+" AND coursename="+postVacancyTrainingCenterBean.getCourseName()+" AND trainingcenter="+postVacancyTrainingCenterBean.getTrainingCenter());
		List<Object[]> list=sql.list();
		if(list.size()>0){
			postVacancyTrainingCenterBean.setVacancyEnrolledId(Integer.parseInt(list.get(0)[0].toString()));
			session.update(postVacancyTrainingCenterBean);
		}else{
			isapplied= (Integer) session.save(postVacancyTrainingCenterBean);
		}
		tx.commit();
		session.close();
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
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseType");
		List<CourseType> courseTypeList = query.list();
		session.close();
		return courseTypeList;
	}
	@Override
	public List<IntStringBean> getTrainerList(){
		Session session = sessionFactory.openSession();
		List<IntStringBean> trinerNameList=new ArrayList<>();
		String sql="select pit.logindetails,pit.firstname,pit.middlename,pit.lastname from personalinformationtrainer pit,personalinformationtrainingpartner pitp where pit.logindetails=pitp.logindetails";
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
		session.close();
		return trinerNameList;
	}
	@Override
	public List<StringStringBean> getStatusList(){
		//TODO write query retrieve all Status of trainee
		List<StringStringBean> statusList=new ArrayList<>();
		String[] arrayValues={"confirm,Payment Confirm","confirmed,Auto Confirmed","pending,Payment Pending"};
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
	public List<PostVacancyTrainingCenter> getPostVacancyTrainingList(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from PostVacancyTrainingCenter");
		List<PostVacancyTrainingCenter> postVacancyTrainingCenter = query.list();
		session.close();
		return postVacancyTrainingCenter;
	}
	@Override
	public List<StringStringBean> getModeOfTrainingList(){
		//TODO write query retrieve all Status of trainee
		List<StringStringBean> statusList=new ArrayList<>();
		String[] arrayValues={"classroom,Classroom","online,Online","both,Both"};
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
		Session session = sessionFactory.openSession();
		List<CourseName> courseNameList=new ArrayList<>();
		String sql="select coursenameid,coursename from coursename";
		Query query = session.createSQLQuery(sql);
		List<Object[]> courseTypeList = query.list();
		if(courseTypeList.size()>0){
			for(int index=0;index<courseTypeList.size();index++){
				CourseName courseName=new CourseName();
				Object[] objecList=courseTypeList.get(index);
				courseName.setCoursenameid(Integer.parseInt(objecList[0].toString()));
				courseName.setCoursename(objecList[1].toString());
				courseNameList.add(courseName);
			}
		}
		session.close();
		return courseNameList;
	}
	public Utility editApplicationStatus(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean){
		Session session = sessionFactory.openSession();
		
		String sql="select trainingdate,noofvacancy,loginid from trainingcentervacancyenrolled where coursetype="+postVacancyTrainingCenterBean.getCourseType()+" AND coursename="+postVacancyTrainingCenterBean.getCourseName();
		Query query = session.createSQLQuery(sql);
		Utility utility=new Utility();
		List<Object[]> list = query.list();
		List<CourseType> courseTypeList=courseTypes();
		List<CourseName> courseNames=getCourseNameList();
		
		
		utility.setTrainingDate(list.get(0)[0].toString());
		utility.setNoOfVacancy(Integer.parseInt(list.get(0)[1].toString()));
		List<StringStringBean> trainerList=new ArrayList<>();
		for(Object[] obj:list){
			String loginSQL=" select ve.vacancyenrolledid , concat(pit.firstname,' ',pit.middlename,' ',pit.lastname) as name from personalinformationtrainer pit , trainingcentervacancyenrolled ve where logindetails="+Integer.parseInt(list.get(0)[2].toString());
			Query loginSQLSQuery = session.createSQLQuery(loginSQL);
			List<Object[]> loginSQLSQuerylist = loginSQLSQuery.list();
			StringStringBean e=new StringStringBean();
			e.setId(loginSQLSQuerylist.get(0)[0].toString());
			e.setValue(loginSQLSQuerylist.get(0)[1].toString());
			trainerList.add(e);
		}
		
		utility.setTrainerList(trainerList);
		session.close();
		for(CourseType ctpe:courseTypeList){
			if(ctpe.getCourseTypeId()==postVacancyTrainingCenterBean.getCourseType()){
				utility.setCourseTypeId(ctpe.getCourseTypeId());
				utility.setCourseTypeName(ctpe.getCourseType());
				break;
			}
		}
		for(CourseName cn:courseNames){
			if(cn.getCoursenameid()==postVacancyTrainingCenterBean.getCourseName()){
				utility.setCourseNameId(cn.getCoursenameid());
				utility.setCourseName(cn.getCoursename());
				break;
			}
		}
		return utility;
		
	}
	
	@Override
	public List<PostVacancyTrainingCenter> getAppliedCount(PostVacancyTrainingCenterBean postVacancyTrainingCenterBean) {
		Session session = sessionFactory.openSession();
		String sql="select coursetype,coursename,trainingdate,noofvacancy,loginid from trainingcentervacancyenrolled tcev";
		String queryParam="";
		List<PostVacancyTrainingCenter> beans=new ArrayList<>();
		if(postVacancyTrainingCenterBean.getCourseType()>0){
			queryParam+="coursetype="+postVacancyTrainingCenterBean.getCourseType()+" AND ";
		}
		if(postVacancyTrainingCenterBean.getCourseName()>0){
			queryParam+="coursename="+postVacancyTrainingCenterBean.getCourseName() +" AND ";
		}
		if(postVacancyTrainingCenterBean.getTrainingDate()!=""){
			queryParam+="trainingdate="+postVacancyTrainingCenterBean.getTrainingDate() +" AND ";
		}
		if(queryParam!=null){
			int index=queryParam.lastIndexOf(" AND ");
			String str=queryParam.substring(0,index);
			sql+=" where "+str;
		}
		Query query = session.createSQLQuery(sql);
		List<Object[]> list = query.list();
		List<CourseType> courseTypeList=courseTypes();
		List<CourseName> courseNames=getCourseNameList();
		
		session.close();
		PostVacancyTrainingCenter postVacancyTrainingBean=new PostVacancyTrainingCenter();
		for(CourseType ctpe:courseTypeList){
			if(Integer.parseInt(list.get(0)[0].toString())==ctpe.getCourseTypeId()){
				postVacancyTrainingBean.setCourseType(ctpe);
				break;
			}
		}
		for(CourseName cn:courseNames){
			if(Integer.parseInt(list.get(0)[1].toString())==cn.getCoursenameid()){
				postVacancyTrainingBean.setCourseName(cn);
				break;
			}
		}
		postVacancyTrainingBean.setTrainingDate(list.get(0)[2].toString());
		postVacancyTrainingBean.setNoOfVacancy(Integer.parseInt(list.get(0)[3].toString()));
		postVacancyTrainingBean.setLoginId(list.get(0)[4].toString());
		postVacancyTrainingBean.setNoOfApplications(list.size());
		
		beans.add(postVacancyTrainingBean);
		return beans;
	}
	@Override
	public void updateApplicationStatusForEnrolledVacancy(PostVacancyTrainingCenterBean PostVacancyTrainingCenterBean) {
		Session session = sessionFactory.openSession();
		PostVacancyTrainingCenterBean pvtcb = (PostVacancyTrainingCenterBean)session.load(PostVacancyTrainingCenterBean.class, Integer.parseInt(PostVacancyTrainingCenterBean.getLoginId()));
		Transaction tx=session.beginTransaction();
		pvtcb.setStatus(PostVacancyTrainingCenterBean.getStatus());
		session.update(pvtcb);
		tx.commit();
		session.close();
		
	}

}
