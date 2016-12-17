package com.ir.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ir.dao.PageLoadDao;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;

public class PageLoadDaoImpl implements PageLoadDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<State> loadState() {
		System.out.println("Page Load DAOImpl process start in state");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from State");
		List listState = query.list();
		session.close();
		System.out.println("state list dao     :"+ listState);
		// TODO Auto-generated method stub
		return listState;
	}


	@Override
	public List<City> loadCity() {
		System.out.println("Page Load DAOImpl process start in city ");
		Session session = sessionFactory.openSession();
		//Query query = session.createQuery("Select cityid , cityname from City where stateid = "+ stat);
		Query query = session.createQuery("from City");
		List listCity = query.list();
		session.close();
		System.out.println("city  ************* list dao     :"+ listCity);
		return listCity;
	}


	@Override
	public List<Title> loadTitle() {
		System.out.println("Page Load DAOImpl process start in title ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Title");
		List titleList = query.list();
		session.close();
		System.out.println("title  ************* list dao     :"+ titleList);
		return titleList;
	}


	@Override
	public List<KindOfBusiness> loadKindOfBusiness() {
		System.out.println("Page Load DAOImpl process start in KindOfBusinessList ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from KindOfBusiness");
		List KindOfBusinessList = query.list();
		session.close();
		System.out.println("business  ************* list dao     :"+ KindOfBusinessList);
		return KindOfBusinessList;
	}


	@Override
	public List<CourseName> loadCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in course name ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseName");
		List courseNameList = query.list();
		session.close();
		System.out.println("CourseName  ************* list dao     :"+ courseNameList);
		return courseNameList;
	}


	@Override
	public List<com.ir.model.District> District() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in district name ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from District");
		//Query query = session.createQuery("select districtId , districtName from District");
		List districtList = query.list();
		session.close();
		System.out.println("district  ************* list dao     :"+ districtList);
		return districtList;
	}


	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in basicCourseName  ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseName where coursetypeid=1 ");
		List basicCourseName = query.list();
		session.close();
		System.out.println("CourseName  ************* list dao     :"+ basicCourseName);
		return basicCourseName;
	}


	@Override
	public List<CourseName> advanceCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in advanceCourseName  ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseName where coursetypeid=2 ");
		List advanceCourseName = query.list();
		session.close();
		System.out.println("CourseName  ************* list dao     :"+ advanceCourseName);
		return advanceCourseName;
	}


	@Override
	public List<CourseName> specialCourseList() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in specialCourseList  ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseName where coursetypeid=3 ");
		List specialCourseList = query.list();
		session.close();
		System.out.println("CourseName  ************* list dao     :"+ specialCourseList);
		return specialCourseList;

	}


	@Override
	public List<ManageTrainingPartner> tpList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ManageTrainingPartner");
		List<ManageTrainingPartner> tpList = query.list();
		session.close();
		return tpList;
	}


	@Override
	public List<ManageAssessmentAgency> aaList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ManageAssessmentAgency");
		List<ManageAssessmentAgency> aaList = query.list();
		session.close();
		return aaList;
	}


	@Override
	public List basicCourseList() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ManageAssessmentAgency");
		List basicCourseList = query.list();
		session.close();
		return basicCourseList;
	}
	@Override
	public List<CourseName> getCouserNameList(int coursetypeid) {
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select coursename,courseduration from coursename where online ='Online' and status='A' and coursetypeid="+coursetypeid);
		List<Object[]> courseNameList = query.list();
		List<CourseName> courseNames=new ArrayList<>();
		for(int index=0;index<courseNameList.size();index++){
			Object[] objects=courseNameList.get(index);
			CourseName courseName=new CourseName();
			courseName.setCoursename(objects[0].toString());
			courseName.setCourseduration(objects[1].toString());
			courseNames.add(courseName);
		}
		session.close();
		return courseNames;
	}
	@Override
	public List<String> getTrainingPartnerNameList() {
		Session session = sessionFactory.openSession();
		String sql="select trainingpartnername from ManageTrainingPartner";
		Query query = session.createSQLQuery(sql);
		List<String> trainingPartnerNameList = query.list();
		session.close();
		return trainingPartnerNameList;
	}
	@Override
	public List<ManageCourseContent> getManageCourseContentList(int coursetypeid) {
		Session session = sessionFactory.openSession();
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
		session.close();
		return manageCourseContents;
	}
}
