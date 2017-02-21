package com.ir.model;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.StringStringBean;

public class TrainingPartnerTrainingCalender {
	private List<CourseType> courseTypes;
	private List<IntStringBean> trainerList;
	private List<CourseName> courseNames;
	private List<StringStringBean> statusList;
	private List<StringStringBean> modeOfTrainingList;
	private List<PersonalInformationTrainingPartner> trainingCenterList;
	private List<IntStringBean> assessorList;
	private List<IntStringBean> traineeList;
	private List<IntStringBean>assessmentAgencyName;
	public List<IntStringBean> getAssessmentAgencyName() {
		return assessmentAgencyName;
	}
	public void setAssessmentAgencyName(
			List<IntStringBean> assessmentAgencyName) {
		this.assessmentAgencyName = assessmentAgencyName;
	}
	/**
	 * @return the statusList
	 */
	public List<StringStringBean> getStatusList() {
		return statusList;
	}
	/**
	 * @param statusList the statusList to set
	 */
	public void setStatusList(List<StringStringBean> statusList) {
		this.statusList = statusList;
	}
	/**
	 * @return the modeOfTrainingList
	 */
	public List<StringStringBean> getModeOfTrainingList() {
		return modeOfTrainingList;
	}
	/**
	 * @param modeOfTrainingList the modeOfTrainingList to set
	 */
	public void setModeOfTrainingList(List<StringStringBean> modeOfTrainingList) {
		this.modeOfTrainingList = modeOfTrainingList;
	}
	
	/**
	 * @return the trainerList
	 */
	public List<IntStringBean> getTrainerList() {
		return trainerList;
	}
	/**
	 * @param trainerList the trainerList to set
	 */
	public void setTrainerList(List<IntStringBean> trainerList) {
		this.trainerList = trainerList;
	}
	/**
	 * @return the courseNames
	 */
	public List<CourseName> getCourseNames() {
		return courseNames;
	}
	/**
	 * @param courseNames the courseNames to set
	 */
	public void setCourseNames(List<CourseName> courseNames) {
		this.courseNames = courseNames;
	}
	/**
	 * @return the courseTypes
	 */
	public List<CourseType> getCourseTypes() {
		return courseTypes;
	}
	/**
	 * @param courseTypes the courseTypes to set
	 */
	public void setCourseTypes(List<CourseType> courseTypes) {
		this.courseTypes = courseTypes;
	}
	/**
	 * @return the trainingCenterList
	 */
	public List<PersonalInformationTrainingPartner> getTrainingCenterList() {
		return trainingCenterList;
	}
	/**
	 * @param trainingCenterList the trainingCenterList to set
	 */
	public void setTrainingCenterList(List<PersonalInformationTrainingPartner> trainingCenterList) {
		this.trainingCenterList = trainingCenterList;
	}
	public List<IntStringBean> getAssessorList() {
		return assessorList;
	}
	public void setAssessorList(List<IntStringBean> assessorList) {
		this.assessorList = assessorList;
	}
	public List<IntStringBean> getTraineeList() {
		return traineeList;
	}
	public void setTraineeList(List<IntStringBean> traineeList) {
		this.traineeList = traineeList;
	}
	
	

}
