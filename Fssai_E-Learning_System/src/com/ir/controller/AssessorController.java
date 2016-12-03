package com.ir.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.cfg.InheritanceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.ir.bean.common.IntStringBean;
import com.ir.form.AssessorUserManagementForm;
import com.ir.form.ContactTrainee;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.assessor.MarkAttendanceForm;
import com.ir.service.AssessmentService;
import com.ir.service.TraineeService;
import com.ir.service.impl.AdminServiceImpl;

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
	
//	@RequestMapping(value="/mark-attendance" , method=RequestMethod.GET)
//	public String markAttendance(){
//		return "mark-attendance";
//	}
	
	@RequestMapping(value="/mark-attendance" , method=RequestMethod.GET)
	public String markAttendance(@Valid @ModelAttribute("markAttendance") MarkAttendanceForm markAttendance, BindingResult result, Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "markAttendance";
		}
		
		/**TODO Training center list of assessor needs to be implemented*/
		List<IntStringBean> listTc = new ArrayList<IntStringBean>();
		IntStringBean trainingCenter = new IntStringBean();
		trainingCenter.setId(171);
		trainingCenter.setValue("Zentech");
		listTc.add(trainingCenter);
		markAttendance.setTrainingCenters(listTc);
		
		List<CourseType> courseTypes = assessmentService.courseTypes();
		markAttendance.setCourseType(courseTypes);
		Gson gson = new Gson();
		model.addAttribute("markAttendance" , gson.toJson(markAttendance));
		
		
		return "markAttendance";
	}
	
	/*@RequestMapping(value="/contactA" , method=RequestMethod.GET)
	public String contactTA(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee){
		return "contactA";
	}
	@RequestMapping(value="/contactTASave" , method=RequestMethod.POST)
	public String contactTrainee1(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "contactTrainee";
		}String id = contactTrainee.getUserId();
		System.out.println("userid   "+ id);
		String contactTraineeSave = traineeService.contactTraineeSave(contactTrainee , id);
		if(contactTraineeSave.equalsIgnoreCase("created")){
			model.addAttribute("created" , "Your request has been sent successfully !!!");
		}else{
			model.addAttribute("created" , "Oops, something went wrong !!!");
		}
		return "contactA";
	}*/
	@RequestMapping(value="/contactA" , method=RequestMethod.GET)
	public String contactTA(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee){
		return "contactA";
	}
	@RequestMapping(value="/contactTASave" , method=RequestMethod.POST)
	public String contactTrainee1(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "contactTrainee";
		}String id = contactTrainee.getUserId();
		System.out.println("userid   "+ id);
		String contactTraineeSave = traineeService.contactTraineeSave(contactTrainee , id);
		if(contactTraineeSave.equalsIgnoreCase("created")){
			model.addAttribute("created" , "Your request has been sent successfully !!!");
		}else{
			model.addAttribute("created" , "Oops, something went wrong !!!");
		}
		return "contactA";
	}
}
