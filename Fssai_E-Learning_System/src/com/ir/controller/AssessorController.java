package com.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ir.form.ContactTrainee;
import com.ir.service.TraineeService;

@Controller
public class AssessorController {

	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	@RequestMapping(value="/assessment-calendar" , method=RequestMethod.GET)
	public String assessmentCalendar(){
		return "assessment-calendar";
	}
	
	@RequestMapping(value="/mark-attendance" , method=RequestMethod.GET)
	public String markAttendance(){
		return "mark-attendance";
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
