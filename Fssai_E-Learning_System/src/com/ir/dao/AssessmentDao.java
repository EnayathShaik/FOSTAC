package com.ir.dao;

import java.util.List;

import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;

public interface AssessmentDao {
	
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName);
	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias);

}
