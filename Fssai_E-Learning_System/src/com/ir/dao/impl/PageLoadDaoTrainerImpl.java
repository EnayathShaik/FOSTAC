package com.ir.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.dao.PageLoadDaoTrainer;
import com.ir.model.CourseName;
import com.ir.model.State;
import com.ir.model.Title;


@Service
public class PageLoadDaoTrainerImpl implements PageLoadDaoTrainer {

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


	/*@Override
	public List<City> loadCity() {
		System.out.println("Page Load DAOImpl process start in city ");
		Session session = sessionFactory.openSession();
		//Query query = session.createQuery("Select cityid , cityname from City where stateid = "+ stat);
		Query query = session.createQuery("from City");
		List listCity = query.list();
		System.out.println("city  ************* list dao     :"+ listCity);
		return listCity;
	}*/


	@Override
	public List<Title> loadTitle() {
		System.out.println("Page Load DAOImpl process start in title ");
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Title");
		List titleList = query.list();
		System.out.println("title  ************* list dao     :"+ titleList);
		return titleList;
	}



	/*@Override
	public List<com.ir.model.District> District() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in district name ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from District");
		//Query query = session.createQuery("select districtId , districtName from District");
		List districtList = query.list();
		System.out.println("district  ************* list dao     :"+ districtList);
		return districtList;
	}*/


	@Override
	@Transactional
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in basicCourseName  ");
		Session session = sessionFactory.getCurrentSession();
		String sql = "select ct.coursetypeid ,cn.coursename , cn.coursenameid from coursename as cn inner join coursetype as ct"+
				" on ct.coursetypeid = cn.coursetypeid";
		Query query = session.createSQLQuery(sql);
		//Query query = session.createQuery("from CourseName");
		List basicCourseName = query.list();
		System.out.println("CourseName  ************* list dao     :"+ basicCourseName);
		return basicCourseName;
	}


	/*@Override
	public List<CourseName> advanceCourseName() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in advanceCourseName  ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseName where coursetypeid=2 ");
		List advanceCourseName = query.list();
		System.out.println("CourseName  ************* list dao     :"+ advanceCourseName);
		return advanceCourseName;
	}
*/

	/*@Override
	public List<CourseName> specialCourseList() {
		// TODO Auto-generated method stub
		System.out.println("Page Load DAOImpl process start in specialCourseList  ");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CourseName where coursetypeid=3 ");
		List specialCourseList = query.list();
		System.out.println("CourseName  ************* list dao     :"+ specialCourseList);
		return specialCourseList;

	}

*/
	
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



}
