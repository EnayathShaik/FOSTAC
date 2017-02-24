package com.ir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.ir.bean.common.IntStringBean;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.TrainingPartner;
import com.ir.model.Utility;

public interface PageLoadService {
	@Transactional
	public List<State> loadState();
	
	@Transactional
	public  List<String> loadCaste();
	
	@Transactional
	public List<City> loadCity(int stat);
	
	@Transactional
	public List<Title> loadTitle();
	
	@Transactional
	public List<KindOfBusiness> loadKindOfBusiness();
	
	@Transactional
	public List<CourseName> loadCourseName();
	
	@Transactional
	public List<District> loadDistrict();
	
	@Transactional
	public List<CourseName> basicCourseName();
	
	@Transactional
	public List<CourseName> advanceCourseList();
	
	@Transactional
	public List<CourseName> specialCourseList();
	
	@Transactional
	public List<ManageTrainingPartner> tpList();
	
	@Transactional
	public List<ManageAssessmentAgency> aaList();
	
	@Transactional
	public List basicCourseList();
	
	@Transactional
	public List<CourseName> getCouserNameList(int coursetypeid);
	
	@Transactional
	public List<String> getTrainingPartnerNameList();
	
	@Transactional
	public List<ManageCourseContent> getManageCourseContentList(int i);
	
	@Transactional
	public List<IntStringBean> getTrainingPartnerList(int courseTypeId);
	
	@Transactional
	public List<Object[]> loadTrainingDetails(Utility utility);
	 
}
