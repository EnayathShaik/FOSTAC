package com.ir.dao.impl;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.PageLoadDao;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.Utility;
@Service
public class PageLoadDaoImpl implements PageLoadDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<State> loadState() {
		System.out.println("Page Load DAOImpl process start in state");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from State where status = 'A'");
		List listState = query.list();
		System.out.println("state list dao     :"+ listState);
		// TODO Auto-generated method stub
		return listState;
	}


	@Override
	public List<City> loadCity() {
		System.out.println("Page Load DAOImpl process start in city ");
		Session session = sessionFactory.getCurrentSession();
		//Query query = session.createQuery("Select cityid , cityname from City where stateid = "+ stat);
		Query query = session.createQuery("from City  where status = 'A'");
		List listCity = query.list();
		System.out.println("city  ************* list dao     :"+ listCity);
		return listCity;
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
	public List<KindOfBusiness> loadKindOfBusiness() {
		System.out.println("Page Load DAOImpl process start in KindOfBusinessList ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from KindOfBusiness");
		List KindOfBusinessList = query.list();
		System.out.println("business  ************* list dao     :"+ KindOfBusinessList);
		return KindOfBusinessList;
	}


	@Override
	public List<CourseName> loadCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in course name ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName  where status = 'A'");
		List courseNameList = query.list();
		System.out.println("CourseName  ************* list dao     :"+ courseNameList);
		return courseNameList;
	}


	@Override
	public List<com.ir.model.District> District() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in district name ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from District where status = 'A'");
		//Query query = session.createQuery("select districtId , districtName from District");
		List districtList = query.list();
		System.out.println("district  ************* list dao     :"+ districtList);
		return districtList;
	}


	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in basicCourseName  ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName where coursetypeid=1 ");
		List basicCourseName = query.list();
		System.out.println("CourseName  ************* list dao     :"+ basicCourseName);
		return basicCourseName;
	}


	@Override
	public List<CourseName> advanceCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in advanceCourseName  ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName where coursetypeid=2 ");
		List advanceCourseName = query.list();
		System.out.println("CourseName  ************* list dao     :"+ advanceCourseName);
		return advanceCourseName;
	}


	@Override
	public List<CourseName> specialCourseList() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in specialCourseList  ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName where coursetypeid=3 ");
		List specialCourseList = query.list();
		System.out.println("CourseName  ************* list dao     :"+ specialCourseList);
		return specialCourseList;

	}


	@Override
	public List<ManageTrainingPartner> tpList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> tpList = query.list();
		return tpList;
	}


	@Override
	public List<ManageAssessmentAgency> aaList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ManageAssessmentAgency");
		List<ManageAssessmentAgency> aaList = query.list();
		return aaList;
	}


	@Override
	public List basicCourseList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ManageAssessmentAgency");
		List basicCourseList = query.list();
		return basicCourseList;
	}
	@Override
	public List<CourseName> getCouserNameList(int coursetypeid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select coursename,courseduration,coursenameid from coursename where online ='Online' and status='A' and coursetypeid="+coursetypeid);
		List<Object[]> courseNameList = query.list();
		List<CourseName> courseNames=new ArrayList<>();
		for(int index=0;index<courseNameList.size();index++){
			Object[] objects=courseNameList.get(index);
			CourseName courseName=new CourseName();
			courseName.setCoursename(objects[0].toString());
			courseName.setCourseduration(objects[1].toString());
			courseName.setCoursenameid(Integer.parseInt(objects[2].toString()));
			courseNames.add(courseName);
		}
		return courseNames;
	}
	@Override
	public List<String> getTrainingPartnerNameList() {
		Session session = sessionFactory.getCurrentSession();
		String sql="select trainingpartnername from ManageTrainingPartner";
		Query query = session.createSQLQuery(sql);
		List<String> trainingPartnerNameList = query.list();
		return trainingPartnerNameList;
	}
	@Override
	public List<ManageCourseContent> getManageCourseContentList(int coursetypeid) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select contentnameinput,contentlinkinput,contenttypeinput from managecoursecontent  where coursetypeinput="+coursetypeid);
		List<ManageCourseContent> manageCourseContents =new ArrayList<>();
		List<Object[]> manageCourseObjArrContents = query.list();
		for(int index=0;index<manageCourseObjArrContents.size();index++){
			ManageCourseContent manageCourseContent=new ManageCourseContent();
			Object[] mangeCntObArr=manageCourseObjArrContents.get(index);
			manageCourseContent.setContentNameInput(mangeCntObArr[0].toString());
			manageCourseContent.setContentLinkInput(mangeCntObArr[1].toString());
			manageCourseContent.setContentTypeInput(mangeCntObArr[2].toString());
			manageCourseContents.add(manageCourseContent);
		}
		return manageCourseContents;
	}


	@Override
	public List<IntStringBean> getTrainingPartnerList(int courseTypeId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select mtp.managetrainingpartnerid,mtp.trainingpartnername from trainingcalendar tc inner join managetrainingpartner mtp on mtp.managetrainingpartnerid=tc.trainingpartner and tc.coursetype="+courseTypeId);
		List<IntStringBean> mangeTrainingPartnerList =new ArrayList<>();
		List<Object[]> mangeTrainingObjPartnerList = query.list();
		for(int index=0;index<mangeTrainingObjPartnerList.size();index++){
			IntStringBean manageCourseContent=new IntStringBean();
			Object[] mangeCntObArr=mangeTrainingObjPartnerList.get(index);
			manageCourseContent.setId(Integer.parseInt(mangeCntObArr[0].toString()));
			manageCourseContent.setValue(mangeCntObArr[1].toString());
			mangeTrainingPartnerList.add(manageCourseContent);
		}
		return mangeTrainingPartnerList;
	}


	@Override
	public List<Object[]> loadTrainingDetails(Utility utility) {
		Session session = sessionFactory.getCurrentSession();
		String sql="select cn.coursename,mtp.trainingpartnername,"
				+ "concat(pitp.trainingpartnerpermanentline1,' , ',pitp.trainingpartnerpermanentline2,',pin : ',pitp.trainingpartnerpermanentpincode,',phone : ',pitp.trainingpartnerpermanentmobile),"
				+ "pitp.seatcapacityavailable from trainingcalendar tc inner join managetrainingpartner mtp on mtp.managetrainingpartnerid=tc.trainingpartner"
				+ " and tc.coursetype="+utility.getCourseTypeId()+" inner join coursename cn "
				+ "on cn.coursetypeid="+utility.getCourseTypeId()+" and coursenameid="+utility.getCourseNameId()+" inner join personalinformationtrainingpartner  pitp on mtp.managetrainingpartnerid=pitp.trainingpartnername "
				+ "and  pitp.trainingpartnerpermanentcity="+utility.getCityId()+" and mtp.city="+utility.getCityId()+" "
				+ "and mtp.state="+utility.getStateId()+" and mtp.managetrainingpartnerid="+utility.getTrainingCenterId();
		Query query = session.createSQLQuery(sql);
		List<Object[]> trainingCalendarList = query.list();
		return trainingCalendarList;
	}
	
	@Override
	public String getNextCombinationId(String prefix , String tableName , String pattern) {
		Session session = sessionFactory.getCurrentSession();
		String combinationId =  null;
		BigInteger getNextId =  getNextId(tableName,session);
		combinationId =prefix+ getFourDigitFormat(getNextId , pattern) ;
		return combinationId;
	}
	
	public static BigInteger getNextId(String tableName,Session session){
		BigInteger count = new BigInteger("0");
		String sql = "select count(1)+1 from  "+tableName ;
		System.out.println(" query "+sql);
		Query query = session.createSQLQuery(sql);
		List listCount = query.list();
		if(listCount.size()>0){
			count = (BigInteger) listCount.get(0);
		}
		return count;
	}
	
	
	private static String getFourDigitFormat(BigInteger getNextId , String pattern)
	{
		 DecimalFormat myFormatter = new DecimalFormat(pattern);
		 String output = myFormatter.format(getNextId);
		 return output;
	}
	

	  public  Map<String, String> casteMap() {
		  System.out.println("inside cast mappppp");
	        Map<String, String> auserTypeMap = new HashMap<String, String>();
	        auserTypeMap.put("ST", "ST");
	        auserTypeMap.put("SC", "SC");
	        auserTypeMap.put("OBC", "OBC");
	        auserTypeMap.put("GENERAL", "GENERAL");
	        return Collections.unmodifiableMap(auserTypeMap);
	    }
	  
	  
		@Override
		public List<String> loadCaste() {
			System.out.println("Page Load DAOImpl process start in Caste");
			List<String> listCaste = new ArrayList<String>();
			listCaste.add("ST");
			listCaste.add("SC");
			listCaste.add("OBC");
			listCaste.add("GENERAL");
			return listCaste;
		}
	
		@Override
		public List<CourseType> courseTypeList() {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseType");
			List<CourseType> courseTypeList = query.list();
			return courseTypeList;
		}
		@Override
		public List<com.ir.model.District> District(String stateId) {
			// TODO Auto-generated method stub
			System.out.println("Page Load DAOImpl process start in district name ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from District where status = 'A'  and stateId =  '"+stateId+"'");
			List districtList = query.list();
			System.out.println("district  ************* list dao     :"+ districtList);
			return districtList;
		}
		
		@Override
		public List<City> loadCity(String distId) {
			System.out.println("Page Load DAOImpl process start in city ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from City  where status = 'A' and districtid= '"+distId+"'");
			List listCity = query.list();
			System.out.println("city  ************* list dao     :"+ listCity);
			return listCity;
		}

}
