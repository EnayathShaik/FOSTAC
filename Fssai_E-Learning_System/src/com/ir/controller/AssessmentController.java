package com.ir.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.ir.form.AadharDetails;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.form.common.AssessmentEvaluationForm;
import com.ir.model.AssessmentQuestion;
import com.ir.model.LoginDetails;
import com.ir.model.trainee.TraineeAssessmentEvaluation;
import com.ir.service.AssessmentService;
@Controller
@SessionAttributes
public class AssessmentController {

	@Autowired
	@Qualifier("assessmentService")
	public AssessmentService assessmentService;
	
	@RequestMapping(value = "/submitAssessment", method = RequestMethod.POST)
	public String  saveAssessment(@Valid @ModelAttribute("assessmentEvaluationForm") AssessmentEvaluationForm assessmentEvaluationForm, Model model, HttpServletRequest request){
		System.out.println(request.getAttribute("questionNo1"));
		Map<String,String> questionMap=new HashMap<>();
		List<AssessmentAnswerCriteria> listAnswerCriteria = new ArrayList<AssessmentAnswerCriteria>();
		AssessmentAnswerCriteria assessmentAnswerCriteria = new AssessmentAnswerCriteria();
		
		List<AssessmentQuestion> answers = assessmentService.getAssessmentAnswers(assessmentEvaluationForm.getCourseNameId(), assessmentEvaluationForm.getAssessmentQuestionsList());
		Enumeration<String> enumeration = request.getParameterNames();
		HttpSession httpSession = request.getSession(false);
		int loginIdUniuqe = (Integer)httpSession.getAttribute("loginIdUnique");
		while (enumeration.hasMoreElements()) {
		    String parameterName = (String) enumeration.nextElement();
		    if(!parameterName.equalsIgnoreCase("courseNameId") && !parameterName.equalsIgnoreCase("assessmentQuestions") &&
		    		!parameterName.equalsIgnoreCase("assessmentQuestionsList")){
		    		questionMap.put(parameterName, request.getParameter(parameterName));
		    		assessmentAnswerCriteria.setQuestionId(Integer.parseInt(parameterName));
		    		assessmentAnswerCriteria.setSelectedAnswer(Integer.parseInt(request.getParameter(parameterName)));
		    		
		    }else if (parameterName.equalsIgnoreCase("courseNameId")){
		    	assessmentAnswerCriteria.setCourseNameId(Integer.parseInt(request.getParameter(parameterName)));
		    }
		    assessmentAnswerCriteria.setLoginId(loginIdUniuqe);
		    listAnswerCriteria.add(assessmentAnswerCriteria);
		}
		System.out.println("Assessment save begin..");
		System.out.println(questionMap);
		assessmentService.saveAssessment(listAnswerCriteria);
		
		TraineeAssessmentEvaluation traineeAssessmentEvaluation = assessmentService.evaluate(questionMap,answers, assessmentEvaluationForm.getCourseNameId());
		traineeAssessmentEvaluation.setLogindetails(loginIdUniuqe);
		assessmentService.saveTraineeAssessmentEvaluation(traineeAssessmentEvaluation);
		Gson gson = new Gson();
		String strTraineeAssessmentEvaluation = gson.toJson(traineeAssessmentEvaluation);
		model.addAttribute("traineeAssessmentEvaluation", strTraineeAssessmentEvaluation);
		return "traineeAssessmentEvaluation";
		
	}
	
}
