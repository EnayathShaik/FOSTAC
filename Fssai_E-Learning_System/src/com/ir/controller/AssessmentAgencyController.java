package com.ir.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.LoginForm;
import com.ir.form.viewAssessmentAgencyCalendarForm;
import com.ir.model.CourseType;
import com.ir.service.AssessmentAgencyService;
import com.zentech.logger.ZLogger;


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
		try{
			
			String id = contactTrainee.getUserId();
			new ZLogger("contactAssessorSave","in controller contact assessor agency save  id "+id , "AssessmentAgencyController.java");
			String contactAssessorSave = assessmentAgencyService.contactAssessorSave(contactTrainee , id);
			if(contactAssessorSave.equalsIgnoreCase("created")){
				modal.addAttribute("created" , "Your contact details has been sent");
			}else{
				modal.addAttribute("created" , "Oops , something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("contactAssessorSave", "contactAssessorSave exception  "+e.getMessage(), "AssessmentAgencyController.java");
		}
		return "contactAA";
	}
	
	@RequestMapping(value="/contactSave" , method=RequestMethod.POST)
	public String contactSave(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee,
			HttpSession session , Model modal){
		try{
			String id = (String) session.getAttribute("logId");
			new ZLogger("contactSave", "in controller contact assessor agency save id "+id, "AssessmentAgencyController.java");
			String contactSave = assessmentAgencyService.contactAssessorSave(contactTrainee , id);
			if(contactSave.equalsIgnoreCase("created")){
				modal.addAttribute("created" , "Your mail has been sent");
			}else{
				modal.addAttribute("created" , "Oops , something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("contactSave", "contactSave exception  "+e.getMessage(), "AssessmentAgencyController.java");
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
	@RequestMapping(value="/passwordChangeAssesAgency" , method=RequestMethod.POST)
	public String changePassword(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session,
				 Model model){
		try{
			boolean getConfirm=false;
				String id = (String) session.getAttribute("logId");
				new ZLogger("passwordChangeAssesAgency", "in controller change password assessor agency save  id "+id, "AssessmentAgencyController.java");
				 getConfirm = assessmentAgencyService.changePasswordData(changePasswordForm, id);
				if(getConfirm){
					new ZLogger("passwordChangeAssesAgency", "PASSWORD HAS BEEN CHANGED", "AssessmentAgencyController.java");
					model.addAttribute("changed" , "Great , your password has been changed !!!");
					new ZLogger("passwordChangeAssesAgency", "PASSWORD HAS BEEN CHANGED", "AssessmentAgencyController.java");
				}
				else{
					model.addAttribute("changed" , "Oops , Password doesn't Match !!!");
				}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("passwordChangeAssesAgency", "passwordChangeAssesAgency exception  "+e.getMessage(), "AssessmentAgencyController.java");
		}
		return "changePasswordAssesAgency";
				
			//return getConfirmation;
			
	}
	@RequestMapping(value = "/logoutAssessor", method = RequestMethod.GET)
	public String logout(@Validated @ModelAttribute("loginAssessor") LoginForm loginForm,HttpSession session,Model model) {
		try{
			new ZLogger("logoutAssessor", "logout assessor", "AssessmentAgencyController.java");
			model.addAttribute("created"," You have successfully logout");
			session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("logoutAssessor", "Exception while logout assessor "+e.getMessage(), "AssessmentAgencyController.java");
		}
		return "loginAssessor";
	}
	
	@RequestMapping(value="/viewAssessmentAgencyCalendar", method=RequestMethod.GET)
	public String viewAssessmentAgencyCalendar(@Validated @ModelAttribute("viewAssessmentAgencyCalendarForm") viewAssessmentAgencyCalendarForm viewAssessmentAgencyCalendarForm,HttpSession httpSession,Model model){
		int agencyId = (Integer)httpSession.getAttribute("loginUserAssessor");
		int profileId = (Integer)httpSession.getAttribute("profileId");
		new ZLogger("viewAssessmentAgencyCalendar", "agencyId "+agencyId, "AssessmentAgencyController.java");
		try{

				Map<String , String> assessorMap = assessmentAgencyService.assessorNameMap(agencyId , profileId);
				model.addAttribute("assessorName" , assessorMap);
				return "viewAssessmentAgencyCalendar";
		
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("viewAssessmentAgencyCalendar", "Exception while viewAssessmentAgencyCalendar "+e.getMessage(), "AssessmentAgencyController.java");
		}
		return "login";
	}
	
	
	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList(){
		List<CourseType> courseTypeList = assessmentAgencyService.courseTypeList();
		return courseTypeList;
	}
	
	//
	
}
