package com.ir.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
