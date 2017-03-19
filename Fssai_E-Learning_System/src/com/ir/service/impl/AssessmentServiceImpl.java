package com.ir.service.impl;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ir.bean.common.IntStringBean;
import com.ir.dao.AssessmentDao;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.trainee.TraineeAssessmentEvaluation;
import com.ir.service.AssessmentService;

@Service("AssessmentService")
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired(required=true)
	@Qualifier(value="assessmentDao")
	private AssessmentDao assessmentDao;
	@Override
	@Transactional
	public List<AssessmentQuestion> getAssessmentQuestions(int courseType, int courseName) {
//		AssessmentDaoImpl assessmentDao = new AssessmentDaoImpl();
		final List<AssessmentQuestion> listAssessmetQustions = assessmentDao.getAssessmentQuestions(courseType, courseName);
		return listAssessmetQustions;
	}
	@Override
	@Transactional
	public String saveAssessment(List<AssessmentAnswerCriteria> assessmentAnswerCriterias){
		String result = assessmentDao.saveAssessment(assessmentAnswerCriterias);
		return result;
	}
	
	@Override
	@Transactional
	public List<CourseType> courseTypes() {
		List<CourseType> courseTypeList = assessmentDao.courseTypes();
		return courseTypeList;
	}
	
	
	@Override
	@Transactional
	public List<CourseName> courseNames() {
		List<CourseName> courseNameList = assessmentDao.courseNames();
		return courseNameList;
	}
	@Override
	@Transactional
	public List<IntStringBean> getTrainingPartners(int assessorId){
		List<IntStringBean> trainingPartners = assessmentDao.getTrainingPartners(assessorId);
		return trainingPartners;
	}

	@Override
	@Transactional
	public List<AssessmentQuestion> getAssessmentAnswers(int courseType, List<Integer> questions) {
		// TODO Auto-generated method stub
		List<AssessmentQuestion> answersList = assessmentDao.getAssessmentAnswers(courseType, questions);
		return answersList;
	}

	@Override
	@Transactional
	public TraineeAssessmentEvaluation evaluate(Map<String,String> questions ,List<AssessmentQuestion> answers, int courseNameId){
		TraineeAssessmentEvaluation traineeEvaluation = new TraineeAssessmentEvaluation();
		//int totalQuestion = answers.size();
		Map<String, Integer> answersMap = new HashMap<String, Integer>();
		for (int i = 0; i < answers.size(); i++) {
			answersMap.put(String.valueOf(answers.get(i).getAssessmentQuestionId()), answers.get(i).getCorrectAnswer());
		}
		int totalQuestions = answers.size();
		int correctAnswers = 0;
		int wrongAnswers = 0;
		double totalScore = 0.00;
		Set<String> questionKeys = questions.keySet();
		Iterator<String> keysIterator = questionKeys.iterator();
		while(keysIterator.hasNext()){
			String key = keysIterator.next();
			int correctAnswer = answersMap.get(key);
			int providedAnswer = Integer.parseInt(questions.get(key));
			System.out.println("For Question "+key +" #Provided answer :" + providedAnswer + " & Correct answer :"+ correctAnswer);
			
			if(providedAnswer == correctAnswer){
				correctAnswers++;
			}
		}
			wrongAnswers = totalQuestions - correctAnswers;
		if(totalQuestions > 0)
		{
			totalScore = (double)correctAnswers/totalQuestions*100;
			DecimalFormat f = new DecimalFormat("##.00");
			totalScore = Double.valueOf(f.format(totalScore));
		}
		traineeEvaluation.setTotalQuestions(totalQuestions);
		traineeEvaluation.setCorrectAnswers(correctAnswers);
		traineeEvaluation.setIncorrectAnswers(wrongAnswers);
		traineeEvaluation.setTotalScore(totalScore);
		traineeEvaluation.setCourseNameId(courseNameId);
		int eligibility = assessmentDao.getElegibilityForAssessment(courseNameId);
		if(eligibility > -1){
			if(totalScore >= eligibility){
				traineeEvaluation.setResult("Pass");
			}else{
				traineeEvaluation.setResult("Fail");
			}
		}else{
			traineeEvaluation.setResult("Eligibility yet to declare");
		}
		return traineeEvaluation;
	}
	@Override
	@Transactional
	public int saveTraineeAssessmentEvaluation(TraineeAssessmentEvaluation traineeAssessmentEvaluation){
		int assessmentId = assessmentDao.saveTraineeAssessmentEvaluation(traineeAssessmentEvaluation);
		return assessmentId;
	}

	
	@Override
	@Transactional
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = assessmentDao.courseTypeList();
		return courseTypeList;
	}
	
	//searchAssessorCalendar
	
	@Override
	@Transactional
	public List searchAssessorCalendar(String data) {
		List courseTypeList = assessmentDao.searchAssessorCalendar(data);
		return courseTypeList;
	}
	
	//viewAssessmentAgencyCalendar
	
	
	@Override
	@Transactional
	public List viewAssessmentAgencyCalendar(String data) {
		List courseTypeList = assessmentDao.viewAssessmentAgencyCalendar(data);
		return courseTypeList;
	}
	
	//searchAssessorTraineesForResults
	
	@Override
	@Transactional
	public List searchAssessorTraineesForResults(String data) {
		List courseTypeList = assessmentDao.searchAssessorTraineesForResults(data);
		return courseTypeList;
	}
	
	//updateTraineeAssessmentResult
	
	@Override
	@Transactional
	public String updateTraineeAssessmentResult(String data) {
		String courseTypeList = assessmentDao.updateTraineeAssessmentResult(data);
		return courseTypeList;
	}
	
	@Override
	@Transactional
	public String updateTraineeAssessmentResultOnline(Integer userID,String result,String comment) {
		String courseTypeList = assessmentDao.updateTraineeAssessmentResultOnline(userID,result,comment);
		return courseTypeList;
	}
	
	//searchDataAssessmentAgency
	@Override
	@Transactional
	public List searchDataAssessmentAgency(String data) {
		List courseTypeList = assessmentDao.searchDataAssessmentAgency(data);
		return courseTypeList;
	}
	
	//editMAA
	
	@Override
	@Transactional
	public List editMAA(String data) {
		List courseTypeList = assessmentDao.editMAA(data);
		return courseTypeList;
	}
	
	//updateMAA
	
	@Override
	@Transactional
	public String updateMAA(String data) {
		String courseTypeList = assessmentDao.updateMAA(data);
		return courseTypeList;
	}
}
