package com.ir.service;

import java.util.List;

import javax.transaction.Transactional;

import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.State;
import com.ir.model.Title;

public interface PageLoadServiceTrainer {
	@Transactional
	public List<State> loadState();
	
	@Transactional
	public List<Title> loadTitle();
	
	@Transactional
	public List<CourseName> basicCourseName();
	
	@Transactional
	public  List<String> loadCaste();
	//public List<CourseName> advanceCourseList();
	//public List<CourseName> specialCourseList();
}
