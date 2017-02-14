package com.ir.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.ir.dao.PageLoadDaoTrainer;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadServiceTrainer;

public class PageLoadServiceTrainerImpl implements PageLoadServiceTrainer {

	@Autowired
	@Qualifier("pageLoadDaoTrainer")
	private PageLoadDaoTrainer pageLoadDaoTrainer;
	
	@Override
	public List<State> loadState() {
		List<State> listState = pageLoadDaoTrainer.loadState();
		return listState;
	}

	/*@Override
	public List<City> loadCity(int stat) {
		// TODO Auto-generated method stub
		System.out.println("page load service");
		List<City> cityList = pageLoadDaoTrainer.loadCity();
		return cityList;
	}*/

	@Override
	public List<Title> loadTitle() {
		// TODO Auto-generated method stub
		List<Title> titleList = pageLoadDaoTrainer.loadTitle();
		return titleList;
	}

	
	/*@Override
	public List<District> loadDistrict() {
		// TODO Auto-generated method stub
		List<District> districtList = pageLoadDaoTrainer.District();
		return districtList;
	}*/

	@Override
	public List<CourseName> basicCourseName() {
		// TODO Auto-generated method stub
		List<CourseName> basicCourseName= pageLoadDaoTrainer.basicCourseName();
		return basicCourseName;
	}

	/*@Override
	public List<CourseName> advanceCourseList() {
		// TODO Auto-generated method stub
		List<CourseName> advanceCourseName= pageLoadDaoTrainer.advanceCourseName();
		return advanceCourseName;
	}*/

	/*@Override
	public List<CourseName> specialCourseList() {
		// TODO Auto-generated method stub
		List<CourseName> specialCourseList= pageLoadDaoTrainer.specialCourseList();
		return specialCourseList;
	}*/
	
	@Override
	public List<String> loadCaste() {
		List<String> listCaste = pageLoadDaoTrainer.loadCaste();
		return listCaste;
	}

}
