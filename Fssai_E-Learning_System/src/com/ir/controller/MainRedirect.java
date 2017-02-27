package com.ir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.PropertyUtils;
import com.ir.form.LoginForm;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageCourseContent;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.State;
import com.ir.model.Utility;
import com.ir.service.PageLoadService;

@Controller
public class MainRedirect {
	
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	
	   /*@ModelAttribute("tpList")
	   public List<ManageTrainingPartner> tpList() {
		   List<ManageTrainingPartner> tpList = null;
		   try{
			   tpList = pageLoadService.tpList();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return tpList;
	   }
	   @ModelAttribute("aaList")
	   public List<ManageAssessmentAgency> aaList() {
		   List<ManageAssessmentAgency> aaList = null;
		   try{
			   aaList = pageLoadService.aaList();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return aaList;
	   }
	   @ModelAttribute("basicCourseList")
	   public List basicCourseList() {
		   List basicCourseList = null;
		   try{
			   basicCourseList = pageLoadService.basicCourseList();
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return basicCourseList;
	   }*/
	   @RequestMapping(value="/showTrainingCalendarDetails" , method=RequestMethod.POST)
		@ResponseBody
		public void getApplicationStatusDetails(@RequestBody Utility utility,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
			
			System.out.println("Get Application Status............");
			List<Object[]> list=new ArrayList<>();
			try{
				 list = pageLoadService.loadTrainingDetails(utility);
				 response.setContentType("text/html;charset=UTF-8");
			        PrintWriter out = response.getWriter();
			        out.print(new Gson().toJson(list));
			        out.flush();
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	   
	   @RequestMapping(value="/calendarSearch" ,method = RequestMethod.GET)
	   public String calendarSearch(@ModelAttribute("utility")Utility utility,HttpSession session,BindingResult result ,  Model model) {
		   try{
			   List<CourseName> courseNameList=pageLoadService.getCouserNameList(utility.getCourseTypeId());
			   List<IntStringBean> mangePartnerList=pageLoadService.getTrainingPartnerList(utility.getCourseTypeId());
			   List<City> citys=pageLoadService.loadCity(0);
			   List<State> states=pageLoadService.loadState();
			   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
			   model.addAttribute("mangePartnerList", new Gson().toJson(mangePartnerList));
			   model.addAttribute("citys", new Gson().toJson(citys));
			   model.addAttribute("states", new Gson().toJson(states));
			   model.addAttribute("courseTypeId", utility.getCourseTypeId());
			   model.addAttribute("trainingDate", utility.getTrainingDate());
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return "calendarSearch";
	   }
	   
	   @RequestMapping(value="/basic-level" ,method = RequestMethod.GET)
	   public String basicLevel(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   try{
			   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.basicLevel));
			   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
			   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.basicLevel));
			   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
			   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
			   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		    return "basic-level";
	   }
	   
	   @RequestMapping(value="/advance-level" ,method = RequestMethod.GET)
	   public String advanceLevel(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   try{
			   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.advanceLevel));
			   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
			   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.advanceLevel));
			   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
			   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
			   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
		   }catch(Exception e){
			   e.printStackTrace();
		   }
	     return "advance-level";
	   }
	   @RequestMapping(value="/special-level" ,method = RequestMethod.GET)
	   public String specialLevel(@ModelAttribute("login") LoginForm loginForm,HttpSession session,BindingResult result ,  Model model) {
		   try{
			   List<CourseName> courseNameList=pageLoadService.getCouserNameList(Integer.parseInt(PropertyUtils.specialLevel));
			   List<String> trainingPartnerNameList=pageLoadService.getTrainingPartnerNameList();
			   List<ManageCourseContent> manageCourseContents=pageLoadService.getManageCourseContentList(Integer.parseInt(PropertyUtils.specialLevel));
			   model.addAttribute("courseNameList", new Gson().toJson(courseNameList));
			   model.addAttribute("trainingPartnerNameList", new Gson().toJson(trainingPartnerNameList));
			   model.addAttribute("manageCourseContents", new Gson().toJson(manageCourseContents));
		   }catch(Exception e){
			   e.printStackTrace();
		   }
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
	   @RequestMapping(value="/faq" ,method = RequestMethod.GET)
	   public String faq() {
		   return "faq";
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
	
}
