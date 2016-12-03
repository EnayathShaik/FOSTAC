package com.ir.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.ir.bean.common.StringStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.TrainingPartnerTrainingCalender;
import com.ir.service.TrainingPartnerService;

@Controller
public class TrainingPartnerController {
	

	@Autowired
	@Qualifier("trainingPartnerService")
	TrainingPartnerService trainingPartnerService; 

	@RequestMapping(value="/postVacancyTrainingPartner" , method=RequestMethod.GET)
	public String postVacancy(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm ){
		return "postVacancyTrainingPartner";
		
	}
	@RequestMapping(value="/changePasswordTrainingPartner" , method=RequestMethod.GET)
	public String changePasswordTP(@ModelAttribute("changePasswordTrainingPartner") ChangePasswordForm changePasswordForm ){
		return "changePasswordTrainingPartner";		
	}
	@RequestMapping(value="/contactTrainingPartner" , method=RequestMethod.GET)
	public String contactTrainingPartner(@ModelAttribute("contactTrainingPartner") ContactTrainee contactTrainee ){
		return "contactTrainingPartner";		
	}
	@RequestMapping(value="/changePasswordTrainingartnerSave" , method=RequestMethod.POST)
	public String changePasswordTraineeSave(@ModelAttribute("changePasswordTrainingPartner") ChangePasswordForm changePasswordForm,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "changePasswordTrainingPartner";
		}
		String id =(String) session.getAttribute("logId");
		//System.out.println(changePasswordForm.getLoginid());
		//int id = 1;
		boolean changePasswordTraineeSave = trainingPartnerService.changePasswordTrainingPartnerSave(changePasswordForm , id);
		if(changePasswordTraineeSave){
			model.addAttribute("created" , "Your password has been changed !!!");
		}else{
			model.addAttribute("created" , "Oops, something went wrong !!!");
		}
		return "changePasswordTrainingPartner";
	}
	@RequestMapping(value="/trainingpartnertrainingcalendar" , method=RequestMethod.GET)
	public String trainingpartnertrainingcalendar(@ModelAttribute("trainingPartnerTrainingCalender") TrainingPartnerTrainingCalender trainingPartnerTrainingCalender,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnertrainingcalendar";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingPartnerTrainingCalender.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingPartnerTrainingCalender.setTrainerList(trainerList);
//		trainingPartnerTrainingCalender.setCourseNames(courseNames);
		Gson gson = new Gson();
		model.addAttribute("trainingPartnerTrainingCalender" , gson.toJson(trainingPartnerTrainingCalender));
		return "trainingpartnertrainingcalendar";
	}
	@RequestMapping(value="/trainingpartnerassessmentcalendar" , method=RequestMethod.GET)
	public String trainingpartnerassessmentcalendar(@ModelAttribute("trainingpartnerassessmentcalendar") TrainingPartnerTrainingCalender trainingpartnerassessmentcalendar,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnerassessmentcalendar";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerassessmentcalendar.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnerassessmentcalendar.setTrainerList(trainerList);
//		trainingpartnerassessmentcalendar.setCourseNames(courseNames);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerassessmentcalendar" , gson.toJson(trainingpartnerassessmentcalendar));
		return "trainingpartnerassessmentcalendar";
	}
	@RequestMapping(value="/trainingpartnerapplicationstatus" , method=RequestMethod.GET)
	public String trainingpartnerapplicationstatus(@ModelAttribute("trainingpartnerapplicationstatus") TrainingPartnerTrainingCalender trainingpartnerapplicationstatus,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnerapplicationstatus";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerapplicationstatus.setCourseTypes(courseTypes);
//		trainingpartnerapplicationstatus.setCourseNames(courseNames);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerapplicationstatus" , gson.toJson(trainingpartnerapplicationstatus));
		return "trainingpartnerapplicationstatus";
	}
	@RequestMapping(value="/trainingpartnermanagetrainer" , method=RequestMethod.GET)
	public String trainingpartnermanagetrainer(@ModelAttribute("trainingpartnermanagetrainer") TrainingPartnerTrainingCalender trainingpartnermanagetrainer,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnermanagetrainer";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnermanagetrainer.setCourseTypes(courseTypes);
//		trainingpartnermanagetrainer.setCourseNames(courseNames);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnermanagetrainer.setTrainerList(trainerList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnermanagetrainer" , gson.toJson(trainingpartnermanagetrainer));
		return "trainingpartnermanagetrainer";
	}
	
	@RequestMapping(value="/trainingpartnerviewtraineelist" , method=RequestMethod.GET)
	public String trainingpartnerviewtraineelist(@ModelAttribute("trainingpartnerviewtraineelist") TrainingPartnerTrainingCalender trainingpartnerviewtraineelist,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnerviewtraineelist";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerviewtraineelist.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnerviewtraineelist.setTrainerList(trainerList);
//		trainingpartnerviewtraineelist.setCourseNames(courseNames);
		List<StringStringBean> statusList= trainingPartnerService.getStatusList();
		trainingpartnerviewtraineelist.setStatusList(statusList);
		List<StringStringBean> modeOfTrainingList= trainingPartnerService.getModeOfTrainingList();
		trainingpartnerviewtraineelist.setModeOfTrainingList(modeOfTrainingList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerviewtraineelist" , gson.toJson(trainingpartnerviewtraineelist));
		return "trainingpartnerviewtraineelist";
	}
	 
	@RequestMapping(value="/trainingpartnerpaymentconfirmation" , method=RequestMethod.GET)
	public String trainingpartnerpaymentconfirmation(@ModelAttribute("trainingpartnerpaymentconfirmation") TrainingPartnerTrainingCalender trainingpartnerpaymentconfirmation,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnerpaymentconfirmation";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerpaymentconfirmation.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnerpaymentconfirmation.setTrainerList(trainerList);
//		trainingpartnerpaymentconfirmation.setCourseNames(courseNames);
		List<StringStringBean> statusList= trainingPartnerService.getStatusList();
		trainingpartnerpaymentconfirmation.setStatusList(statusList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerpaymentconfirmation" , gson.toJson(trainingpartnerpaymentconfirmation));
		return "trainingpartnerpaymentconfirmation";
	}
	
	@RequestMapping(value="/postVacancyTrainingPartnerSave" , method=RequestMethod.POST)
	  public String postVacancySave(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm , Model model){		
		  String postVacancy = trainingPartnerService.postVacancyTrainingPartner(postVacancyTrainingCenterForm);
		  if(postVacancy.equalsIgnoreCase("created")){
			  model.addAttribute("created", "Vacancy created successfull !!!");
		  }else{
			  model.addAttribute("created", "vacancy already created !!!");
		  }
		  return "postVacancyTrainingPartner";	
	 }
	@ModelAttribute("trainingCenterList")
	public List<PersonalInformationTrainingPartner> trainingCenterList(){
		List<PersonalInformationTrainingPartner> trainingCenterList = trainingPartnerService.trainingCenterList();
		return trainingCenterList;
	}
	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList(){
		List<CourseType> courseTypeList = trainingPartnerService.courseTypeList();
		return courseTypeList;
	}
	
	
}
