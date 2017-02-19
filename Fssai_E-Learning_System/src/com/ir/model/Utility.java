package com.ir.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ir.bean.common.StringStringBean;

public class Utility {
private String assessmentAgencyId;
private String assessmentAgencyName;
private String assessorName;
private int courseTypeId;
private int courseNameId ;
private int feedbackId;
private String courseTypeName;
private String courseName ;
private String courseCode ;
private int noOfVacancy;
private String trainingDate;
private String endDate;
private int noOfApplications;
private String loginId;
private int cityId;
private int stateId;
private int trainingCenterId;
private List<StringStringBean> trainerList;
private String trainingStartDate;
private String trainingEndDate;
/**
 * @return the courseTypeId
 */



public int getCourseTypeId() {
	return courseTypeId;
}
public String getTrainingStartDate() {
	return trainingStartDate;
}
public void setTrainingStartDate(String trainingStartDate) {
	this.trainingStartDate = trainingStartDate;
}
public String getTrainingEndDate() {
	return trainingEndDate;
}
public void setTrainingEndDate(String trainingEndDate) {
	this.trainingEndDate = trainingEndDate;
}
public String getEndDate() {
	return endDate;
}
public void setEndDate(String endDate) {
	this.endDate = endDate;
}
public String getCourseCode() {
	return courseCode;
}
public void setCourseCode(String courseCode) {
	this.courseCode = courseCode;
}
/**
 * @param courseTypeId the courseTypeId to set
 */
public void setCourseTypeId(int courseTypeId) {
	this.courseTypeId = courseTypeId;
}
/**
 * @return the courseNameId
 */
public int getCourseNameId() {
	return courseNameId;
}
/**
 * @param courseNameId the courseNameId to set
 */
public void setCourseNameId(int courseNameId) {
	this.courseNameId = courseNameId;
}
/**
 * @return the courseTypeName
 */
public String getCourseTypeName() {
	return courseTypeName;
}
/**
 * @param courseTypeName the courseTypeName to set
 */
public void setCourseTypeName(String courseTypeName) {
	this.courseTypeName = courseTypeName;
}
/**
 * @return the courseName
 */
public String getCourseName() {
	return courseName;
}
/**
 * @param courseName the courseName to set
 */
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
/**
 * @return the noOfVacancy
 */
public int getNoOfVacancy() {
	return noOfVacancy;
}
/**
 * @param noOfVacancy the noOfVacancy to set
 */
public void setNoOfVacancy(int noOfVacancy) {
	this.noOfVacancy = noOfVacancy;
}
/**
 * @return the trainingDate
 */
public String getTrainingDate() {
	return trainingDate;
}
/**
 * @param trainingDate the trainingDate to set
 */
public void setTrainingDate(String trainingDate) {
	this.trainingDate = trainingDate;
}
/**
 * @return the noOfApplications
 */
public int getNoOfApplications() {
	return noOfApplications;
}
/**
 * @param noOfApplications the noOfApplications to set
 */
public void setNoOfApplications(int noOfApplications) {
	this.noOfApplications = noOfApplications;
}
/**
 * @return the assessmentAgencyId
 */
public String getAssessmentAgencyId() {
	return assessmentAgencyId;
}
/**
 * @param assessmentAgencyId the assessmentAgencyId to set
 */
public void setAssessmentAgencyId(String assessmentAgencyId) {
	this.assessmentAgencyId = assessmentAgencyId;
}
/**
 * @return the assessmentAgencyName
 */
public String getAssessmentAgencyName() {
	return assessmentAgencyName;
}
/**
 * @param assessmentAgencyName the assessmentAgencyName to set
 */
public void setAssessmentAgencyName(String assessmentAgencyName) {
	this.assessmentAgencyName = assessmentAgencyName;
}
/**
 * @return the assessorName
 */
public String getAssessorName() {
	return assessorName;
}
/**
 * @param assessorName the assessorName to set
 */
public void setAssessorName(String assessorName) {
	this.assessorName = assessorName;
}
/**
 * @param request is used to create a query based on  screen type
 * @return SQL query.
 */
public static String getSQLQuery(HttpServletRequest request){
	StringBuilder strblder=new StringBuilder();
	String sql=" ";
	String queryParam=" ";
	if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_CALENDAR")){
	strblder = getCourseAndTrainerDateQueryParam(request, strblder);
	if(request.getParameter("trainerid")!=null&&request.getParameter("trainerid")!=""){
		strblder.append("ce.logindetails= ").append(Integer.parseInt(request.getParameter("trainerid"))).append(" AND ");
	}
	queryParam=removeExtraParam(strblder);
	sql = "select ct.coursetypeid,ct.coursetype,cn.coursenameid,cn.coursename,tc.trainingdate,tc.trainingtime,ce.logindetails,concat(pit.firstname,' ',pit.middlename,' ',pit.lastname) as name "
			+ "from coursetype ct "
			+ "inner join coursename cn on cn.coursetypeid=ct.coursetypeid "
			+ "inner join trainingcalendar tc on tc.coursetype=cn.coursetypeid "
			+ "inner join courseenrolled ce on  ce.coursenameid=cn.coursenameid "
			+ "inner join personalinformationtrainer pit on pit.logindetails=ce.logindetails"
			+queryParam+" group by ct.coursetypeid,ct.coursetype, cn.coursenameid,cn.coursename,tc.trainingdate,tc.trainingtime,ce.logindetails,name";
	return sql;
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_VIEW_TRAINEE_LIST")){
		strblder = getCourseAndTrainerDateQueryParam(request, strblder);
		if(request.getParameter("traineeStatus")!=null && request.getParameter("traineeStatus")!=""){
			strblder.append("ce.traineeStatus=").append(request.getParameter("traineeStatus")).append(" AND ");
		}
		if(request.getParameter("modeOfTrainig")!=null&& request.getParameter("modeOfTrainig")!=""){
			strblder.append("ce.modeOfTrainig=").append(request.getParameter("modeOfTrainig")).append(" AND ");
		}
		queryParam= removeExtraParam(strblder);
		return sql;
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_POST_VACANCY")){
		strblder = getCourseQueryParam(request, strblder);
		
		if(request.getParameter("trainingdate")!=null && request.getParameter("trainingdate")!=""){
			strblder.append("tc.trainingdate=").append(request.getParameter("trainingdate")).append(" AND ");
		}
		if(request.getParameter("requiredExperiance")!=null&& request.getParameter("requiredExperiance")!=""){
			strblder.append("tc.requiredExperiance=").append(request.getParameter("requiredExperiance")).append(" AND ");
		}
		if(request.getParameter("noOfVacancy")!=null&&request.getParameter("noOfVacancy")!=""){
			strblder.append("tc.noOfVacancy=").append(request.getParameter("noOfVacancy")).append(" AND ");
		}
		queryParam=removeExtraParam(strblder);
		return sql;
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_MARK_TRAINEE_ATTENDENCE")){
		getCourseAndTrainerDateQueryParam(request, strblder);
		removeExtraParam(strblder);
		
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_APPLICATION_STATUS")){
		getCourseQueryParam(request, strblder);
		
		if(request.getParameter("trainingdate")!=null&&request.getParameter("trainingdate")!=""){
			strblder.append("tc.trainingdate=").append(request.getParameter("trainingdate")).append(" AND ");
		}
		queryParam= removeExtraParam(strblder);
		return sql;
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_MANAGE_TRAINER")){
		getCourseQueryParam(request, strblder);
		if(request.getParameter("trainerid")!=null&&request.getParameter("trainerid")!=""){
			strblder.append("ce.logindetails=").append(Integer.parseInt(request.getParameter("trainerid"))).append(" AND ");
		}
		queryParam= removeExtraParam(strblder);
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_ASSISSMENT_CALENDAR")){
		getCourseQueryParam(request, strblder);
		if(request.getParameter("trainerid")!=null&&request.getParameter("trainerid")!=""){
			strblder.append("ce.logindetails= ").append(Integer.parseInt(request.getParameter("trainerid"))).append(" AND ");
		}
		if(request.getParameter("assissmentdate")!=null&&request.getParameter("assissmentdate")!=""){
			strblder.append("tc.assissmentdate=").append(request.getParameter("assissmentdate")).append(" AND ");
		}
		if(request.getParameter("assissmenttime")!=null&&request.getParameter("assissmenttime")!=""){
			strblder.append("ct.assissmenttime=").append(request.getParameter("assissmenttime")).append(" AND ");
		}
		queryParam=removeExtraParam(strblder);
		return sql;
	}else if(request.getParameter("screentype").equalsIgnoreCase("TRAINING_PARTNER_PAYMENT_CONFIRMATION")){
		getCourseAndTrainerDateQueryParam(request, strblder);
		if(request.getParameter("status")!=null&&request.getParameter("status")!=""){
			strblder.append("ct.status=").append(request.getParameter("status")).append(" AND ");
		}
		queryParam= removeExtraParam(strblder);
		return sql;
	}
	return sql;
}
private static StringBuilder getCourseAndTrainerDateQueryParam(HttpServletRequest request, StringBuilder strblder) {
	getCourseQueryParam(request, strblder);
	if(request.getParameter("trainingdate")!=null&&request.getParameter("trainingdate")!=""){
		strblder.append("tc.trainingdate=").append(request.getParameter("trainingdate")).append(" AND ");
	}
	if(request.getParameter("trainingtime")!=null&&request.getParameter("trainingtime")!=""){
		strblder.append("ct.trainingtime=").append(request.getParameter("trainingtime")).append(" AND ");
	}
	return strblder;
}
private static StringBuilder getCourseQueryParam(HttpServletRequest request, StringBuilder strblder) {
	if(request.getParameter("cousertypeid")!=null&&request.getParameter("cousertypeid")!=""){
		strblder.append("ct.coursetypeid= ").append(Integer.parseInt(request.getParameter("cousertypeid"))).append(" AND ");
	}
	if(request.getParameter("coursenameid")!=null&&request.getParameter("coursenameid")!=""){
		strblder.append("cn.coursenameid=").append( request.getParameter("coursenameid")).append(" AND ");
	}
	return strblder;
}
private static String removeExtraParam(StringBuilder strblder) {
	String localQueryParam=" ";
	if(strblder.length()>0){
		int index=strblder.toString().lastIndexOf(" AND ");
		String str=strblder.toString().substring(0,index);
		localQueryParam=" where "+str;
	}
	return localQueryParam;
}
public static String save(HttpServletRequest request, Session session) {
	String userId=request.getSession(false).getAttribute("loginIdUnique").toString();
	String[] feedbackMastersIds=request.getParameter("feedbackMastersIds").split(",");
	String courseId = request.getParameter("courseId");
	List<FeedbackForm> list =new ArrayList<>();
	for(int index=0;index<feedbackMastersIds.length;index++){
		FeedbackForm  feedbackForm=new FeedbackForm();
		feedbackForm.setUserId(userId);
		feedbackForm.setCourseId(courseId);
		String[] feedbaks=feedbackMastersIds[index].split("`");
		feedbackForm.setFeedbackId(feedbaks[0]);
		feedbackForm.setFeedbackRating(feedbaks[1]);
		list.add(feedbackForm);
	}
	Transaction transaction=session.beginTransaction();
	for(FeedbackForm feedbackForm:list){
		session.save(feedbackForm);
	}
	transaction.commit();
	return null;
}
/**
 * @return the loginId
 */
public String getLoginId() {
	return loginId;
}
/**
 * @param loginId the loginId to set
 */
public void setLoginId(String loginId) {
	this.loginId = loginId;
}
/**
 * @return the trainerList
 */
public List<StringStringBean> getTrainerList() {
	return trainerList;
}
/**
 * @param trainerList the trainerList to set
 */
public void setTrainerList(List<StringStringBean> trainerList) {
	this.trainerList = trainerList;
}
/**
 * @return the feedbackId
 */
public int getFeedbackId() {
	return feedbackId;
}
/**
 * @param feedbackId the feedbackId to set
 */
public void setFeedbackId(int feedbackId) {
	this.feedbackId = feedbackId;
}
/**
 * @return the cityId
 */
public int getCityId() {
	return cityId;
}
/**
 * @param cityId the cityId to set
 */
public void setCityId(int cityId) {
	this.cityId = cityId;
}
/**
 * @return the stateId
 */
public int getStateId() {
	return stateId;
}
/**
 * @param stateId the stateId to set
 */
public void setStateId(int stateId) {
	this.stateId = stateId;
}
/**
 * @return the trainingCenterId
 */
public int getTrainingCenterId() {
	return trainingCenterId;
}
/**
 * @param trainingCenterId the trainingCenterId to set
 */
public void setTrainingCenterId(int trainingCenterId) {
	this.trainingCenterId = trainingCenterId;
}
}