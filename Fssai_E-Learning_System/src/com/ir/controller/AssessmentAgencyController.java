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

import com.google.gson.Gson;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.LoginForm;
import com.ir.form.viewAssessmentAgencyCalendarForm;
import com.ir.model.CourseType;
import com.ir.model.assessmentagency.AssessmentAgencyForm;
import com.ir.service.AssessmentAgencyService;


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
			System.out.println("in controller contact assessor agency save");
			String id = contactTrainee.getUserId();
			System.out.println("id    :"+ id);
			String contactAssessorSave = assessmentAgencyService.contactAssessorSave(contactTrainee , id);
			if(contactAssessorSave.equalsIgnoreCase("created")){
				modal.addAttribute("created" , "Your contact details has been sent");
			}else{
				modal.addAttribute("created" , "Oops , something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "contactAA";
	}
	
	@RequestMapping(value="/contactSave" , method=RequestMethod.POST)
	public String contactSave(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee,
			HttpSession session , Model modal){
		try{
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
		}catch(Exception e){
			e.printStackTrace();
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
				}
				else{
					model.addAttribute("changed" , "Oops , Password doesn't Match !!!");
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "changePasswordAssesAgency";
				
			//return getConfirmation;
			
	}
	@RequestMapping(value = "/logoutAssessor", method = RequestMethod.GET)
	public String logout(@Validated @ModelAttribute("loginAssessor") LoginForm loginForm,HttpSession session,Model model) {
		try{
			System.out.println("logout assessor");
			model.addAttribute("created"," You have successfully logout");
			session.invalidate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return "loginAssessor";
	}
	
	@RequestMapping(value="/viewAssessmentAgencyCalendar", method=RequestMethod.GET)
	public String viewAssessmentAgencyCalendar(@Validated @ModelAttribute("viewAssessmentAgencyCalendarForm") viewAssessmentAgencyCalendarForm viewAssessmentAgencyCalendarForm,HttpSession httpSession,Model model){
		int agencyId = (Integer)httpSession.getAttribute("assessmentId");
		System.out.println("agencyId "+agencyId);
		try{

				Map<String , String> assessorMap = assessmentAgencyService.assessorNameMap(agencyId);
				model.addAttribute("assessorName" , assessorMap);
				return "viewAssessmentAgencyCalendar";
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return "login";
	}
	
	
	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList(){
		List<CourseType> courseTypeList = assessmentAgencyService.courseTypeList();
		return courseTypeList;
	}
	
}
