package com.ir.dao;

import java.util.List;

import com.ir.model.CourseName;
import com.ir.model.State;
import com.ir.model.Title;

public interface PageLoadDaoTrainer {
	public List<State> loadState();
	public List<String> loadCaste();
	//public List<City> loadCity();
	public List<Title> loadTitle();
	//public List<District> District();
	public List<CourseName> basicCourseName();
	//public List<CourseName> advanceCourseName();
	//public List<CourseName> specialCourseList();

}
