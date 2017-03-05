package com.ir.dao;

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

public interface PageLoadDao {
	public List<State> loadState();
	public List<City> loadCity();
	public List<Title> loadTitle();
	public List<KindOfBusiness> loadKindOfBusiness();
	public List<CourseName> loadCourseName();
	public List<District> District();
	public List<CourseName> basicCourseName();
	public List<CourseName> advanceCourseName();
	public List<CourseName> specialCourseList();
	public List<ManageTrainingPartner> tpList();
	public List<ManageAssessmentAgency> aaList();
	public List basicCourseList();
	public List<CourseName> getCouserNameList(int coursetypeid);
	public List<String> getTrainingPartnerNameList();
	public List<ManageCourseContent> getManageCourseContentList(int coursetypeid);
	public List<IntStringBean> getTrainingPartnerList(int courseTypeId);
	public List<Object[]> loadTrainingDetails(Utility utility);
	public  List<String> loadCaste(); 
	public String getNextCombinationId(String prefix , String tableName , String pattern);
	List<CourseType> courseTypeList();
	public List<District> District(String stateId);
	public List<City> loadCity(String distId);
}
