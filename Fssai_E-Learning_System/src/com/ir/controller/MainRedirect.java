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
import com.ir.bean.common.PropertyUtils;
import com.ir.form.LoginForm;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.service.PageLoadService;
import com.ir.util.Profiles;

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
	   public String basicLevel(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.basicLevel));
		   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
		   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.basicLevel));
		   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
		   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
		   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
		   return "basic-level";
	   }
	   
	   @RequestMapping(value="/advance-level" ,method = RequestMethod.GET)
	   public String advanceLevel(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.advanceLevel));
		   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
		   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.advanceLevel));
		   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
		   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
		   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
		   return "advance-level";
	   }
	   @RequestMapping(value="/special-level" ,method = RequestMethod.GET)
	   public String specialLevel(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.specialLevel));
		   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
		   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.specialLevel));
		   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
		   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
		   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
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
	   @RequestMapping(value="/basicFoodSafetyCertification" ,method = RequestMethod.GET)
	   public String basicFoodSafetyCertification(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.basicLevel));
		   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
		   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.basicLevel));
		   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
		   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
		   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
		   return "basicFoodSafetyCertification";
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
