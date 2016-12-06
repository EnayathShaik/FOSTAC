package com.ir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AssessmentDao;
import com.ir.dao.LoginDAO;
import com.ir.dao.impl.AssessmentDaoImpl;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseType;
import com.ir.service.AssessmentService;

@Service("AssessmentService")
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired(required=true)
	@Qualifier(value="assessmentDao")
	private AssessmentDao assessmentDao;
	@Override
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName) {
//		AssessmentDaoImpl assessmentDao = new AssessmentDaoImpl();
		final List<AssessmentQuestion> listAssessmetQustions = assessmentDao.getAssessmentQuestions(courseType, courseName);
		return listAssessmetQustions;
	}
	
	public String saveAssessment(List<AssessmentAnswerCriteria> assessmentAnswerCriterias){
		String result = assessmentDao.saveAssessment(assessmentAnswerCriterias);
		return result;
	}
	
	@Override
	public List<CourseType> courseTypes() {
		List<CourseType> courseTypeList = assessmentDao.courseTypes();
		return courseTypeList;
	}
	@Override
	public List<IntStringBean> getTrainingPartners(int assessorId){
		List<IntStringBean> trainingPartners = assessmentDao.getTrainingPartners(assessorId);
		return trainingPartners;
	}
}
