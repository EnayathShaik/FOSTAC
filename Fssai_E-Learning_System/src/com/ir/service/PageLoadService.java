package com.ir.service;

import java.util.ArrayList;
import java.util.List;

import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.TrainingPartner;

public interface PageLoadService {
	
	public List<State> loadState();
	public List<City> loadCity(int stat);
	public List<Title> loadTitle();
	public List<KindOfBusiness> loadKindOfBusiness();
	public List<CourseName> loadCourseName();
	public List<District> loadDistrict();
	public List<CourseName> basicCourseName();
	public List<CourseName> advanceCourseList();
	public List<CourseName> specialCourseList();
	public List<ManageTrainingPartner> tpList();
	public List<ManageAssessmentAgency> aaList();
	public List basicCourseList();
}
