package com.ir.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ir.form.LoginForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.CourseName;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.TrainingPartner;
import com.ir.service.PageLoadService;
import com.ir.service.RegistrationServiceTrainee;

@Controller
public class MainRedirect {
	
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	
	   @ModelAttribute("tpList")
	   public List<ManageTrainingPartner> tpList() {
		   List<ManageTrainingPartner> tpList = pageLoadService.tpList();
		   return tpList;
	   }
	   @ModelAttribute("aaList")
	   public List<ManageAssessmentAgency> aaList() {
		   List<ManageAssessmentAgency> aaList = pageLoadService.aaList();
		   return aaList;
	   }
	   @ModelAttribute("basicCourseList")
	   public List basicCourseList() {
		   List basicCourseList = pageLoadService.basicCourseList();
		   return basicCourseList;
	   }
	   @RequestMapping(value="/basic-level" ,method = RequestMethod.GET)
	   public String basicLevel() {
		return "basic-level";
	   }
	   
	   @RequestMapping(value="/advance-level" ,method = RequestMethod.GET)
	   public String advanceLevel() {
		   return "advance-level";
	   }
	   @RequestMapping(value="/special-level" ,method = RequestMethod.GET)
	   public String specialLevel() {
		   return "special-level";
	   }
	   @RequestMapping(value="/fostac" ,method = RequestMethod.GET)
	   public String fostac(HttpSession session) {
		   session.invalidate();
		   return "redirect:index.jsp";
	   }
	   @RequestMapping(value="/contact" ,method = RequestMethod.GET)
	   public String contact() {
		   return "contact";
	   }
	   @RequestMapping(value="/about" ,method = RequestMethod.GET)
	   public String about() {
		   return "about";
	   }
	   @RequestMapping(value="/disclaimer" ,method = RequestMethod.GET)
	   public String disclaimer() {
		   return "disclaimer";
	   }
	   @RequestMapping(value="/feedback" ,method = RequestMethod.GET)
	   public String feedback() {
		   return "feedback";
	   }
	   @RequestMapping(value="/knowYourTrainingPartner" ,method = RequestMethod.GET)
	   public String knowYourTrainingPartner() {
		   return "knowYourTrainingPartner";
	   }
	   @RequestMapping(value="/freeFoodSafetyCertification" ,method = RequestMethod.GET)
	   public String freeFoodSafetyCertification() {
		   return "freeFoodSafetyCertification";
	   }
	   @RequestMapping(value="/certificationProcess" ,method = RequestMethod.GET)
	   public String certificationProcess() {
		   return "certificationProcess";
	   }
	   @RequestMapping(value="/viewEnrolledCourse" ,method = RequestMethod.GET)
	   public String viewEnrolledCourse() {
		   return "viewEnrolledCourse";
	   }

	   @RequestMapping(value="/afterLoginContact" ,method = RequestMethod.GET)
	   public String afterLoginContact() {
		   return "afterLoginContact";
	   }
	  
	   @RequestMapping(value="/trainee" ,method = RequestMethod.GET)
	   public String trainee() {
		   return "trainee";
	   }
	   
	   @RequestMapping(value="/trainer" ,method = RequestMethod.GET)
	   public String trainer() {
		   return "trainer";
	   }
	   @RequestMapping(value="/trainingPartner" ,method = RequestMethod.GET)
	   public String trainingPartner() {
		   return "trainingPartner";
	   }
	   @RequestMapping(value="/assessor" ,method = RequestMethod.GET)
	   public String assessor() {
		   return "assessor";
	   }
	 /*  public String login(
			   @ModelAttribute("fostac_Trainee_Index_Form") RegisterFormTrainee registerFormTrainee,
			   BindingResult result,Model model,HttpSession session) {
			return "login";
	
			 String captcha=(String)session.getAttribute("CAPTCHA");
			    if(captcha==null || (captcha!=null && !captcha.equals(login.getCaptcha()))){
			    	login.setCaptcha("");
			    	model.addAttribute("message", "Captcha does not match");
			    	return "login";
			    }

				if(login.getUserId().equals("guest") && login.getPassword().equals("ddd")){
					System.out.println("user id and password matches");
					model.addAttribute("loginId", login.getUserId());
					return "home";
				
				}
				else{
					login.setCaptcha("");
					model.addAttribute("message","User ID or Password Incorrect");
					return "login";	
				}		
		}

	   @RequestMapping(value="/fostac_Trainee_Index_Form" ,method = RequestMethod.POST)
	   public String fostac_Trainee_Index_Form(
			   @ModelAttribute("RegisterFormTrainee") RegisterFormTrainee registerFormTrainee,
				BindingResult bindingResult, Model model
			   ) {
		   model.addAttribute("RegisterFormTrainee",  registerFormTrainee);
		   System.out.println("llllllllll");
		return "trainee_registration";
	   }*/

}
