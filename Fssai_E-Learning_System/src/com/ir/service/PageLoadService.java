package com.ir.service;

import java.util.List;

import com.ir.bean.common.IntStringBean;
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

public interface PageLoadService {
	
	public List<State> loadState();
	public List<String> loadCaste();
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
	public List<CourseName> getCouserNameList(int coursetypeid);
	public List<String> getTrainingPartnerNameList();
	public List<ManageCourseContent> getManageCourseContentList(int i);
	public List<IntStringBean> getTrainingPartnerList(int courseTypeId);
	public List<Object[]> loadTrainingDetails(Utility utility);
	public String getNextCombinationId(String prefix , String tableName , String pattern);
	List<CourseType> courseTypeList();
	
	
	//onchange 
	
	public List<District> loadDistrict(String stateId);
	public List<City> loadCity(String districtId);
	
	
	
	 
}
