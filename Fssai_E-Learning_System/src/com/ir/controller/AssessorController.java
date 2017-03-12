package com.ir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ir.bean.common.IntStringBean;
import com.ir.form.ContactTrainee;
import com.ir.form.GenerateCourseCertificateForm;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.assessor.MarkAttendanceForm;
import com.ir.service.AssessmentService;
import com.ir.service.TraineeService;
import com.zentech.logger.ZLogger;

@Controller
public class AssessorController {

	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	@Autowired
	@Qualifier("assessmentService")
	public AssessmentService assessmentService;
	
	@RequestMapping(value="/assessment-calendar" , method=RequestMethod.GET)
	public String assessmentCalendar(){
		return "assessment-calendar";
	}
	
	@RequestMapping(value="/mark-attendance" , method=RequestMethod.GET)
	public String markAttendance(@Valid @ModelAttribute("markAttendance") MarkAttendanceForm markAttendance, BindingResult result, HttpSession httpSession, Model model){
		if(result.hasErrors()){
			new ZLogger("mark-attendance", "bindingResult.hasErrors  "+result.hasErrors() , "AssessorController.java");
			new ZLogger("mark-attendance", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AssessorController.java");
			return "markAttendance";
		}
		try{
			PersonalInformationAssessor assessorInfo = (PersonalInformationAssessor)httpSession.getAttribute("loginUser");
			int assessorId = assessorInfo.getId();
			/**TODO Training center list of assessor needs to be implemented*/
			List<IntStringBean> listTc = new ArrayList<IntStringBean>();
			listTc = assessmentService.getTrainingPartners(assessorId);
			markAttendance.setTrainingCenters(listTc);
			
			List<CourseType> courseTypes = assessmentService.courseTypes();
			markAttendance.setCourseType(courseTypes);
			markAttendance.setAssessorId(assessorId);
			Gson gson = new Gson();
			model.addAttribute("markAttendance" , gson.toJson(markAttendance));
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("mark-attendance", " Exception while mark-attendance  "+e.getMessage() , "AssessorController.java");
		}
		return "markAttendance";
	}
	
	@RequestMapping(value="/update-result" , method=RequestMethod.GET)
	public String updateResultForm(@Valid @ModelAttribute("updateResult") MarkAttendanceForm markAttendance, BindingResult result, Model model, HttpSession httpSession){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			new ZLogger("update-result", "bindingResult.hasErrors  "+result.hasErrors() , "AssessorController.java");
			new ZLogger("update-result", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AssessorController.java");
			return "updateResult";
		}
		try{
			int assessorId= (int)httpSession.getAttribute("loginIdUnique");
			List<CourseType> courseTypes = assessmentService.courseTypes();
			List<CourseName> courseNames = assessmentService.courseNames();
			List<IntStringBean> listTc = assessmentService.getTrainingPartners(assessorId);
			markAttendance.setCourseType(courseTypes);
			markAttendance.setCoursetName(courseNames);
			markAttendance.setTrainingCenters(listTc);
			Gson gson = new Gson();
			model.addAttribute("updateResult" , gson.toJson(markAttendance));
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("update-result", " Exception while update-result  "+e.getMessage() , "AssessorController.java");
		}
		return "updateResult";
	}
	
	@RequestMapping(value="/contactA" , method=RequestMethod.GET)
	public String contactTA(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee){
		return "contactA";
	}
	@RequestMapping(value="/contactTASave" , method=RequestMethod.POST)
	public String contactTrainee1(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			new ZLogger("contactTASave", "bindingResult.hasErrors  "+result.hasErrors() , "AssessorController.java");
			new ZLogger("contactTASave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AssessorController.java");
			return "contactTrainee";
		}
		try{
			String id = contactTrainee.getUserId();
			String contactTraineeSave = traineeService.contactTraineeSave(contactTrainee , id);
			if(contactTraineeSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("contactTASave", " Exception while contactTASave  "+e.getMessage() , "AssessorController.java");
		}
		return "contactA";
		
	}
	
	
	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList(){
		List<CourseType> courseTypeList = assessmentService.courseTypeList();
		return courseTypeList;
	}
	
	//searchAssessorCalendar
	

	@RequestMapping(value="/searchAssessorCalendar" , method=RequestMethod.POST)
	@ResponseBody
	public void searchAssessorCalendar(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchAssessmentAgencyList","searchAssessmentAgencyList............" + data  , "AdminController.java");
		List courseList = assessmentService.searchAssessorCalendar(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//viewAssessmentAgencyCalendar
	
	
	@RequestMapping(value="/viewAssessmentAgencyCalendar" , method=RequestMethod.POST)
	@ResponseBody
	public void viewAssessmentAgencyCalendar(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("viewAssessmentAgencyCalendar","viewAssessmentAgencyCalendar............" + data  , "AdminController.java");
		List courseList = assessmentService.viewAssessmentAgencyCalendar(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	@RequestMapping(value="/searchAssessorTraineesForResults" , method=RequestMethod.POST)
	@ResponseBody
	public void searchAssessorTraineesForResults(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchAssessorTraineesForResults","searchAssessorTraineesForResults............" + data  , "AdminController.java");
		List courseList = assessmentService.searchAssessorTraineesForResults(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	@RequestMapping(value="/updateTraineeAssessmentResult" , method=RequestMethod.POST)
	@ResponseBody
	public void updateTraineeAssessmentResult(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("updateTraineeAssessmentResult","updateTraineeAssessmentResult............" + data  , "AdminController.java");
		String courseList = assessmentService.updateTraineeAssessmentResult(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
}
