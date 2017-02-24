package com.ir.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import com.ir.bean.common.IntStringBean;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;
import com.ir.model.trainee.TraineeAssessmentEvaluation;

public interface AssessmentService {
	@Transactional
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName);
	
	@Transactional
	public String saveAssessment(List<AssessmentAnswerCriteria> assessmentAnswerCriteria);
	
	@Transactional
	public List<CourseType> courseTypes();
	
	@Transactional
	public List<IntStringBean> getTrainingPartners(int assessorId);
	
	@Transactional
	public List<AssessmentQuestion> getAssessmentAnswers(int courseType, List<Integer> questions);
	
	@Transactional
	public TraineeAssessmentEvaluation evaluate(Map<String,String> question,List<AssessmentQuestion> answers, int courseNameId);
	
	@Transactional
	public int saveTraineeAssessmentEvaluation(TraineeAssessmentEvaluation traineeAssessmentEvaluation);
}
