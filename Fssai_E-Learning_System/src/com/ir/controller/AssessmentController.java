package com.ir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.ir.form.AssessmentAnswerCriteria;
import com.ir.form.GenerateCourseCertificateForm;
import com.ir.form.common.AssessmentEvaluationForm;
import com.ir.model.AssessmentQuestion;
import com.ir.model.trainee.TraineeAssessmentEvaluation;
import com.ir.service.AssessmentService;
import com.ir.service.TraineeService;
import com.zentech.logger.ZLogger;

@Controller
@SessionAttributes
public class AssessmentController {

	@Autowired
	@Qualifier("assessmentService")
	public AssessmentService assessmentService;

	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;

	@RequestMapping(value = "/submitAssessment", method = RequestMethod.POST)
	public String saveAssessment(
			@Valid @ModelAttribute("assessmentEvaluationForm") AssessmentEvaluationForm assessmentEvaluationForm,
			Model model, HttpServletRequest request,HttpSession session) {
		
		try{
			new ZLogger("submitAssessment",(String) request.getAttribute("questionNo1"), "AssessmentController.java");
			Map<String, String> questionMap = new HashMap<>();
			List<AssessmentAnswerCriteria> listAnswerCriteria = new ArrayList<AssessmentAnswerCriteria>();
			AssessmentAnswerCriteria assessmentAnswerCriteria = new AssessmentAnswerCriteria();

			List<AssessmentQuestion> answers = assessmentService
					.getAssessmentAnswers(
							assessmentEvaluationForm.getCourseNameId(),
							assessmentEvaluationForm.getAssessmentQuestionsList());
			Enumeration<String> enumeration = request.getParameterNames();
			HttpSession httpSession = request.getSession(false);
			int loginIdUniuqe = (Integer) httpSession.getAttribute("loginIdUnique");
			int userId = (Integer) httpSession.getAttribute("userId");
			while (enumeration.hasMoreElements()) {
				String parameterName = (String) enumeration.nextElement();
				if (!parameterName.equalsIgnoreCase("courseNameId")
						&& !parameterName.equalsIgnoreCase("assessmentQuestions")
						&& !parameterName
								.equalsIgnoreCase("assessmentQuestionsList")) {
					questionMap.put(parameterName,
							request.getParameter(parameterName));
					assessmentAnswerCriteria.setQuestionId(Integer
							.parseInt(parameterName));
					assessmentAnswerCriteria.setSelectedAnswer(Integer
							.parseInt(request.getParameter(parameterName)));

				} else if (parameterName.equalsIgnoreCase("courseNameId")) {
					assessmentAnswerCriteria.setCourseNameId(Integer
							.parseInt(request.getParameter(parameterName)));
				}
				assessmentAnswerCriteria.setLoginId(loginIdUniuqe);
				listAnswerCriteria.add(assessmentAnswerCriteria);
			}
			new ZLogger("submitAssessment","Assessment save begin.."+questionMap, "AssessmentController.java");
			assessmentService.saveAssessment(listAnswerCriteria);

			TraineeAssessmentEvaluation traineeAssessmentEvaluation = assessmentService
					.evaluate(questionMap, answers,
							assessmentEvaluationForm.getCourseNameId());
			traineeAssessmentEvaluation.setLogindetails(loginIdUniuqe);
			assessmentService
					.saveTraineeAssessmentEvaluation(traineeAssessmentEvaluation);
			
			//Update Result in Course Enrolled User
			if(traineeAssessmentEvaluation != null && traineeAssessmentEvaluation.getResult() != null){
				//Update Result
				assessmentService.updateTraineeAssessmentResultOnline(userId, traineeAssessmentEvaluation.getResult(), String.valueOf(traineeAssessmentEvaluation.getTotalScore()));
			}
			
			
			Gson gson = new Gson();
			String strTraineeAssessmentEvaluation = gson
					.toJson(traineeAssessmentEvaluation);
			model.addAttribute("traineeAssessmentEvaluation",
					strTraineeAssessmentEvaluation);

			// update Step
			Integer profileID = 0;
			int loginId = 0;
			try {
				profileID = (Integer) session.getAttribute("profileId");
				loginId = (int) session.getAttribute("loginIdUnique");
			} catch (Exception e) {
				new ZLogger("submitAssessment"," Exception while submitAssessment "+e.getMessage(), "AssessmentController.java");
			}
			int tableID = traineeService.getTableIdForEnrolmentID(loginId,
					profileID);
			traineeService.updateSteps(tableID, profileID, 4);
			session.setAttribute("traineeSteps", 4);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("submitAssessment"," Exception while submitAssessment "+e.getMessage(), "AssessmentController.java");
		}
		
		return "traineeAssessmentEvaluation";
		

	}

	
	//searchDataAssessmentAgency
	@RequestMapping(value="/searchDataAssessmentAgency" , method=RequestMethod.POST)
	@ResponseBody
	public void searchDataAssessmentAgency(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchDataAssessmentAgency","searchDataAssessmentAgency............" + data  , "TrainingPartnerController.java");
		List batchCodeList = assessmentService.searchDataAssessmentAgency(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//editMAA
	
	@RequestMapping(value="/editMAA" , method=RequestMethod.POST)
	@ResponseBody
	public void editMAA(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("editMAA","editMAA............" + data  , "TrainingPartnerController.java");
		List batchCodeList = assessmentService.editMAA(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//updateMAA
	
	
	@RequestMapping(value="/updateMAA" , method=RequestMethod.POST)
	@ResponseBody
	public void updateMAA(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("updateMAA","updateMAA............" + data  , "TrainingPartnerController.java");
		String batchCodeList = assessmentService.updateMAA(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
}
