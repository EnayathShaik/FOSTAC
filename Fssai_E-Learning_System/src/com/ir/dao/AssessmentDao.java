package com.ir.dao;

import java.util.List;

import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;

public interface AssessmentDao {
	
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName);
	public String saveAssessment(List<AssessmentAnswerCriteria> answerCriterias);
	public List<CourseType> courseTypes();

}
