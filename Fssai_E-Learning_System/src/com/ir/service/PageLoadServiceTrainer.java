package com.ir.service;

import java.util.List;

import com.ir.model.CourseName;
import com.ir.model.State;
import com.ir.model.Title;

public interface PageLoadServiceTrainer {
	
	public List<State> loadState();
	
	
	public List<Title> loadTitle();
	
	
	public List<CourseName> basicCourseName();
	
	
	public  List<String> loadCaste();
	//public List<CourseName> advanceCourseList();
	//public List<CourseName> specialCourseList();
}
