package com.ir.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.PageLoadDao;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.Utility;
import com.ir.service.PageLoadService;
@Service
public class PageLoadServiceImpl implements PageLoadService {

	@Autowired
	@Qualifier("pageLoadDao")
	private PageLoadDao pageLoadDao;
	
	@Override
	@Transactional
	public List<State> loadState() {
		List<State> listState = pageLoadDao.loadState();
		return listState;
	}

	@Override
	@Transactional
	public List<City> loadCity(int stat) {
		// TODO Auto-generated method stub
		System.out.println("page load service");
		List<City> cityList = pageLoadDao.loadCity();
		return cityList;
	}

	@Override
	@Transactional
	public List<Title> loadTitle() {
		// TODO Auto-generated method stub
		List<Title> titleList = pageLoadDao.loadTitle();
		return titleList;
	}

	@Override
	@Transactional
	public List<KindOfBusiness> loadKindOfBusiness() {
		// TODO Auto-generated method stub
		List<KindOfBusiness> KindOfBusinessList = pageLoadDao.loadKindOfBusiness();
		return KindOfBusinessList;
	}

	@Override
	@Transactional
	public List<CourseName> loadCourseName() {
		// TODO Auto-generated method stub
		List<CourseName> loadCourseName= pageLoadDao.loadCourseName();
		return loadCourseName;
	}

	@Override
	@Transactional
	public List<District> loadDistrict() {
		// TODO Auto-generated method stub
		List<District> districtList = pageLoadDao.District();
		return districtList;
	}

	@Override
	@Transactional
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		List<CourseName> basicCourseName= pageLoadDao.basicCourseName();
		return basicCourseName;
	}

	@Override
	@Transactional
	public List<CourseName> advanceCourseList() {
		// TODO Auto-generated method stub
		List<CourseName> advanceCourseName= pageLoadDao.advanceCourseName();
		return advanceCourseName;
	}

	@Override
	@Transactional
	public List<CourseName> specialCourseList() {
		// TODO Auto-generated method stub
		List<CourseName> specialCourseList= pageLoadDao.specialCourseList();
		return specialCourseList;
	}

	@Override
	@Transactional
	public List<ManageTrainingPartner> tpList() {
		List<ManageTrainingPartner> tpList = pageLoadDao.tpList();
		return tpList;
	}

	@Override
	@Transactional
	public List<ManageAssessmentAgency> aaList() {
		List<ManageAssessmentAgency> aaList = pageLoadDao.aaList();
		return aaList;
	}

	@Override
	@Transactional
	public List basicCourseList() {
		List basicCourseList = pageLoadDao.basicCourseList();
		return basicCourseList;
	}

	@Override
	@Transactional
	public List<CourseName> getCouserNameList(int coursetypeid) {
		return pageLoadDao.getCouserNameList(coursetypeid);
	}

	@Override
	@Transactional
	public List<String> getTrainingPartnerNameList() {
		return pageLoadDao.getTrainingPartnerNameList();
	}

	@Override
	@Transactional
	public List<ManageCourseContent> getManageCourseContentList(int coursetypeid) {
		return pageLoadDao.getManageCourseContentList(coursetypeid);
	}

	@Override
	@Transactional
	public List<IntStringBean> getTrainingPartnerList(int courseTypeId) {
		return pageLoadDao.getTrainingPartnerList(courseTypeId);
	}

	@Override
	@Transactional
	public List<Object[]> loadTrainingDetails(Utility utility) {
		return  pageLoadDao.loadTrainingDetails(utility);
	}
	
	
	@Override
	@Transactional
	public  List<String> loadCaste() {
		System.out.println("inside cast map");
		return  pageLoadDao.loadCaste();
	}
	
	@Override
	@Transactional
	public String getNextCombinationId(String prefix , String tableName , String pattern) {
		System.out.println("inside cast map");
		return  pageLoadDao.getNextCombinationId(prefix, tableName, pattern);
	}
	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = pageLoadDao.courseTypeList();
		return courseTypeList;
	}
	
	@Override
	@Transactional
	public List<District> loadDistrict(String stateId) {
		// TODO Auto-generated method stub
		List<District> districtList = pageLoadDao.District(stateId);
		return districtList;
	}
	
	
	@Override
	@Transactional
	public List<City> loadCity(String distId) {
		// TODO Auto-generated method stub
		System.out.println("page load service");
		List<City> cityList = pageLoadDao.loadCity(distId);
		return cityList;
	}


}
