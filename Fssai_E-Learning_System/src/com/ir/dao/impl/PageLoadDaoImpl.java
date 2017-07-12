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
import com.ir.form.ManageAssessmentAgencyForm;
import com.ir.form.ManageTrainingPartnerForm;
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


	/*@Override
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
	}*/


/*	@Override
	public List<CourseName> specialCourseList() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in specialCourseList  ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseName where coursetypeid=3 ");
		List specialCourseList = query.list();
		System.out.println("CourseName  ************* list dao     :"+ specialCourseList);
		return specialCourseList;

	}
*/

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


		@Override
		public List<CourseName> cateringList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where upper(courseName) like '%CATERING%' ");
			List cateringList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ cateringList);
			return cateringList;
		}


		@Override
		public List<CourseName> manufacturingList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where upper(courseName) like '%MANUFACTURING%' ");
			List manufacturingList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ manufacturingList);
			return manufacturingList;
		}


		@Override
		public List<CourseName> transportList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where upper(courseName) like '%TRANSPORT%' or upper(courseName) like '%STORAGE%'  ");
			List transportList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ transportList);
			return transportList; 
		}


		@Override
		public List<CourseName> retailList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where upper(courseName) like '%RETAIL%' ");
			List retailList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ retailList);
			return retailList;
		}


		@Override
		public List<CourseName> basicList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where coursetypeid=1");
			List basicList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ basicList);
			return basicList;
		}


		@Override
		public List<CourseName> advancedList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where coursetypeid=2 ");
			List advancedList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ advancedList);
			return advancedList;
		}


		@Override
		public List<CourseName> specialList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where coursetypeid=3");
			List specialList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ specialList);
			return specialList;
		}


		@Override
		public List<CourseName> awarenessList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from CourseName where coursetypeid=5");
			List specialList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ specialList);
			return specialList;
		}
		
		@Override
		public List<ManageTrainingPartnerForm> manageTrainingPartnerList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select l.loginid,tp.trainingPartnerName,tp.websiteUrl,(CASE WHEN l.status = 'N' THEN 'INACTIVE' ELSE 'ACTIVE' END) as currentStatus from ManageTrainingPartner tp inner join logindetails l on tp.logindetails=l.id");
			List manageTrainingPartnerList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ manageTrainingPartnerList);
			return manageTrainingPartnerList;
		}
		
		@Override
		public List<ManageAssessmentAgencyForm> manageAssessmentAgencyList() {
			System.out.println("Page Load DAOImpl process start in specialCourseList  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select l.loginid,ma.assessmentAgencyName,ma.websiteUrl,(CASE WHEN l.status = 'N' THEN 'INACTIVE' ELSE 'ACTIVE' END) as status from ManageAssessmentAgency ma inner join logindetails l on ma.logindetails=l.id");
			List manageAssessmentAgencyList = query.list();
			System.out.println("CourseName  ************* list dao     :"+ manageAssessmentAgencyList);
			return manageAssessmentAgencyList;
		}


		@Override
		public List commonList2(int i) {
			// TODO Auto-generated method stub
			System.out.println("Page Load DAOImpl process start in basicList2  ");
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, mcm.modeoftraininginput , mcm.contenttypeinput, mcm.contentnameinput ,mcm.uploadedContent, mcm.managecoursecontentid from ManageCoursecontent as mcm inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput  inner join coursename as cn on cn.coursenameid = mcm.coursenameinput where ct.coursetypeid ="+i+" order by mcm.managecoursecontentid desc ");
			List basicList = query.list();
			System.out.println("basicList2  ************* list dao     :"+ basicList);
			return basicList;
		}


		@Override
		public List courseCommonList2(int id) {
			// TODO Auto-generated method stub
			Query query=null;
			Session session = sessionFactory.getCurrentSession();
			if(id==1)
				query = session.createSQLQuery("select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, mcm.modeoftraininginput , mcm.contenttypeinput, mcm.contentnameinput ,mcm.uploadedContent, mcm.managecoursecontentid from ManageCoursecontent as mcm inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput  inner join coursename as cn on cn.coursenameid = mcm.coursenameinput where upper(cn.coursename) like '%CATERING%' order by mcm.managecoursecontentid desc ");
			else if(id==2)
				query = session.createSQLQuery("select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, mcm.modeoftraininginput , mcm.contenttypeinput, mcm.contentnameinput ,mcm.uploadedContent, mcm.managecoursecontentid from ManageCoursecontent as mcm inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput  inner join coursename as cn on cn.coursenameid = mcm.coursenameinput where upper(cn.coursename) like '%MANUFACTURING%' order by mcm.managecoursecontentid desc ");
			else if(id==3)
				 query = session.createSQLQuery("select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, mcm.modeoftraininginput , mcm.contenttypeinput, mcm.contentnameinput ,mcm.uploadedContent, mcm.managecoursecontentid from ManageCoursecontent as mcm inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput  inner join coursename as cn on cn.coursenameid = mcm.coursenameinput where upper(cn.coursename)  like '%TRANSPORT%' or upper(cn.coursename)   like '%STORAGE%'  order by mcm.managecoursecontentid desc ");
			else if(id==4)
				query = session.createSQLQuery("select cn.coursecode , ct.coursetype , mcm.contentlinkinput , mcm.contentlocationinput, mcm.modeoftraininginput , mcm.contenttypeinput, mcm.contentnameinput ,mcm.uploadedContent, mcm.managecoursecontentid from ManageCoursecontent as mcm inner join coursetype as ct on ct.coursetypeid = mcm.coursetypeinput  inner join coursename as cn on cn.coursenameid = mcm.coursenameinput where upper(cn.coursename) like '%RETAIL%' order by mcm.managecoursecontentid desc ");
			
			List courseCommList = query.list();
			
			return courseCommList;
		}


		
		
}
