package com.ir.dao;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;
import com.ir.model.trainee.TraineeAssessmentEvaluation;

public interface AssessmentDao {
	
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName);
	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias);
	public List<CourseType> courseTypes();
	public List<IntStringBean> getTrainingPartners(int assessorId);
	public List<AssessmentQuestion> getAssessmentAnswers(int courseType, List<Integer> questions);
	public int saveTraineeAssessmentEvaluation(TraineeAssessmentEvaluation traineeAssessmentEvaluation);
	public int getElegibilityForAssessment(int coursetypeid);
	public List<CourseType> courseTypeList();
	public List searchAssessorCalendar(String data);
	public List viewAssessmentAgencyCalendar(String data);
	public List searchAssessorTraineesForResults(String data);
	public String updateTraineeAssessmentResult(String data);
}
