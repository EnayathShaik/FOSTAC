package com.ir.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.LoginForm;
import com.ir.model.assessmentagency.AssessmentAgencyForm;
import com.ir.service.AdminService;
import com.ir.service.AssessmentAgencyService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class AssessmentAgencyController {
	
	@Autowired
	@Qualifier("assessmentAgencyService")
	AssessmentAgencyService assessmentAgencyService; 
	
	
	@RequestMapping(value="/assessmentAgencyHomepage" , method=RequestMethod.GET)
	public String assessmentAgencyHomepage(){
		return "assessmentAgencyHomepage";
	}
	@RequestMapping(value="/contactAA" , method=RequestMethod.GET)
	public String contactAssessor(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee){
		return "contactAA";
	}
	
	@RequestMapping(value="/contactAssessorSave" , method=RequestMethod.POST)
	public String contactAssessorSave(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee,
			HttpSession session , Model modal){
		System.out.println("in controller contact assessor agency save");
		String id = contactTrainee.getUserId();
		System.out.println("id    :"+ id);
		String contactAssessorSave = assessmentAgencyService.contactAssessorSave(contactTrainee , id);
		if(contactAssessorSave.equalsIgnoreCase("created")){
			modal.addAttribute("created" , "Your contact details has been sent");
		}else{
			modal.addAttribute("created" , "Oops , something went wrong !!!");
		}
		return "contactAA";
	}
	
	@RequestMapping(value="/contactSave" , method=RequestMethod.POST)
	public String contactSave(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee,
			HttpSession session , Model modal){
		System.out.println("in controller contact assessor agency save");
		String id = (String) session.getAttribute("logId");
		//String id = contactTrainee.getUserId();
		System.out.println("id    :"+ id);
		String contactSave = assessmentAgencyService.contactAssessorSave(contactTrainee , id);
		if(contactSave.equalsIgnoreCase("created")){
			modal.addAttribute("created" , "Your mail has been sent");
		}else{
			modal.addAttribute("created" , "Oops , something went wrong !!!");
		}
		return "contactAA";
	}
	
	/**
	 * @param ChangePasswordForm
	 * @return
	 */
	@RequestMapping(value="/changePasswordAssesAgency" , method=RequestMethod.GET)
	public String changePass(@ModelAttribute("changePasswordForm")ChangePasswordForm ChangePasswordForm ){
		return "changePasswordAssesAgency";
	}
	@RequestMapping(value="/passwordChangeAssesAgency" , method=RequestMethod.GET)
	public String changePassword(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session,
				 Model model){
		String getConfirmation=null;
		boolean getConfirm=false;
		//String id=(String) session.getAttribute("loginUser");
			System.out.println("in controller change password assessor agency save");
			String id = (String) session.getAttribute("logId");
			String loginClass= (String) session.getAttribute("logerClass");
			System.out.println("id    :"+ id);
			 getConfirm = assessmentAgencyService.changePasswordData(changePasswordForm, id);
			if(getConfirm){
				System.out.println("PASSWORD HAS BEEN CHANGED");
				model.addAttribute("changed" , "Great , your password has been changed !!!");
				System.out.println("PASSWORD HAS BEEN CHANGED");
				return"changePasswordAssesAgency";}
			else{
				model.addAttribute("changed" , "Oops , Password doesn't Match !!!");
				return "changePasswordAssesAgency";
			}
				
			//return getConfirmation;
			
	}
	@RequestMapping(value = "/logoutAssessor", method = RequestMethod.GET)
	public String logout(@Validated @ModelAttribute("loginAssessor") LoginForm loginForm,HttpSession session,Model model) {
		System.out.println("logout assessor");
		model.addAttribute("created"," You have successfully logout");
		session.invalidate();
		return "loginAssessor";
	}
	
	@RequestMapping(value="/viewAssessmentAgencyCalendar", method=RequestMethod.GET)
	public String viewAssessmentAgencyCalendar(@Validated @ModelAttribute("assessmentAgencyForm") AssessmentAgencyForm assessmentAgencyForm,HttpSession httpSession,Model model){
		int agencyId = (Integer)httpSession.getAttribute("loginIdUnique");
		if(agencyId >0 ){
			assessmentAgencyForm = assessmentAgencyService.getAssessmentAgencyForm(agencyId);
			Gson gson = new Gson();
			String assessmentAgencyFormData = gson.toJson(assessmentAgencyForm);
			model.addAttribute("viewAssessmentAgencyCalendar" , assessmentAgencyFormData);
			return "viewAssessmentAgencyCalendar";
		} 
		else{
			model.addAttribute("error" , "Oops , You are not authorized !!!");
			return "login";
		}
	}
	
}
