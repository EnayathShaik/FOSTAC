package com.ir.service;

import java.util.List;

import com.ir.bean.common.IntStringBean;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;

public interface AssessmentService {
	
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName);
	public String saveAssessment(List<AssessmentAnswerCriteria> assessmentAnswerCriteria);
	public List<CourseType> courseTypes();
	public List<IntStringBean> getTrainingPartners(int assessorId);

}
