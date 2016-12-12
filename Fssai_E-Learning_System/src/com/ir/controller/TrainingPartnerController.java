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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.ir.bean.common.IntStringBean;
import com.ir.bean.common.JsonResponse;
import com.ir.bean.common.StringStringBean;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.trainingPartner.TrainingPartnerSearch;
import com.ir.form.trainingPartner.TrainingPartnerSearchForm;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.State;
import com.ir.model.TrainingPartnerTrainingCalender;
import com.ir.model.Utility;
import com.ir.service.AdminService;
import com.ir.service.LoginService;
import com.ir.service.TraineeService;
import com.ir.service.TrainingPartnerService;
import com.ir.util.Profiles;

@Controller
public class TrainingPartnerController {
	

	@Autowired
	@Qualifier("trainingPartnerService")
	TrainingPartnerService trainingPartnerService; 
	
	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	
	@Autowired
	@Qualifier("loginService")
	LoginService loginService; 
	
	@RequestMapping(value="/postVacancyTrainingPartner" , method=RequestMethod.GET)
	public String postVacancy(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm,HttpSession session,BindingResult result , Model model ){
		return "postVacancyTrainingPartner";
		
	}
	@RequestMapping(value="/postVacancyTrainingCenter" , method=RequestMethod.GET)
	public String postVacancyTrainingCenter(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm,HttpSession session,BindingResult result , Model model ){
		return "postVacancyTrangCenter";
		
	}
	@RequestMapping(value="/changePasswordTrainingPartner" , method=RequestMethod.GET)
	public String changePasswordTP(@ModelAttribute("changePasswordTrainingPartner") ChangePasswordForm changePasswordForm ){
		return "changePasswordTrainingPartner";		
	}
	@RequestMapping(value="/contactTrainingPartner" , method=RequestMethod.GET)
	public String contactTrainingPartner(@ModelAttribute("contactTrainingPartner") ContactTrainee contactTrainee ){
		return "contactTrainingPartner";		
	}
	@RequestMapping(value="/viewFeedbackDetails" , method=RequestMethod.GET)
	public String viewFeedbackDetails(@ModelAttribute("trainingpartnerapplicationstatus") TrainingPartnerTrainingCalender trainingpartnerapplicationstatus,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnerapplicationstatus1";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerapplicationstatus.setCourseTypes(courseTypes);
		List<PersonalInformationTrainingPartner> trainingCenterList=trainingCenterList();
		trainingpartnerapplicationstatus.setTrainingCenterList(trainingCenterList);
//		trainingpartnerapplicationstatus.setCourseNames(courseNames);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerapplicationstatus" , gson.toJson(trainingpartnerapplicationstatus));
	
		return "viewFeedbackDetails";		
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
	@RequestMapping(value="/viewtrainingpartnertrainingcalendar" , method=RequestMethod.GET)
	public String viewtrainingpartnertrainingcalendar(@ModelAttribute("trainingPartnerTrainingCalender") TrainingPartnerTrainingCalender trainingPartnerTrainingCalender,HttpSession session,BindingResult result , Model model){
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
		List<PersonalInformationTrainingPartner> trainingCenterList=trainingCenterList();
		trainingPartnerTrainingCalender.setTrainingCenterList(trainingCenterList);
		Gson gson = new Gson();
		model.addAttribute("trainingPartnerTrainingCalender" , gson.toJson(trainingPartnerTrainingCalender));
		return "viewtrainingpartnertrainingcalendar";
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
	@RequestMapping(value="/trainingpartnerapplicationstatus1" , method=RequestMethod.GET)
	public String trainingpartnerapplicationstatus1(@ModelAttribute("trainingpartnerapplicationstatus") TrainingPartnerTrainingCalender trainingpartnerapplicationstatus,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingpartnerapplicationstatus1";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerapplicationstatus.setCourseTypes(courseTypes);
		List<PersonalInformationTrainingPartner> trainingCenterList=trainingCenterList();
		trainingpartnerapplicationstatus.setTrainingCenterList(trainingCenterList);
//		trainingpartnerapplicationstatus.setCourseNames(courseNames);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerapplicationstatus" , gson.toJson(trainingpartnerapplicationstatus));
		return "trainingpartnerapplicationstatus1";
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
	@RequestMapping(value="/updateApplicationStatusForEnrolledVacancy" , method=RequestMethod.POST)
	@ResponseBody
	  public void updateApplicationStatusForEnrolledVacancy(@RequestBody PostVacancyTrainingCenterBean postVacancyTrainingCenterBean ,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {	
		JsonResponse responseObj=new JsonResponse();
		try{
			trainingPartnerService.updateApplicationStatusForEnrolledVacancy(postVacancyTrainingCenterBean);
			responseObj.setMessage("Vacancy status Updated sucessfully");
		}catch(Exception e){
			responseObj.setMessage("unable to update Vacancy");
		}
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson=new Gson();
        String newJSON=gson.toJson(responseObj);
        out.print(newJSON);
        out.flush();
	 }
	@RequestMapping(value="/getTrainingCalenderList" , method=RequestMethod.POST)
	@ResponseBody
	  public void getTrainingCalenderList(@RequestBody PostVacancyTrainingCenterBean postVacancyTrainingCenterBean ,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException {	
		List<PostVacancyTrainingCenterBean> trainingCalendarList=new ArrayList<>();
		try{
		trainingCalendarList=trainingPartnerService.getTrainingCalenderList(postVacancyTrainingCenterBean);
	
		}catch(Exception e){
		}
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(trainingCalendarList));
        out.flush();
	 }
	
	@RequestMapping(value="/editApplicationStatusDetails" , method=RequestMethod.GET)
	  public String editApplicationStatusDetails(@ModelAttribute("PostVacancyTrainingCenterBean") PostVacancyTrainingCenterBean postVacancyTrainingCenterBean ,HttpSession session,BindingResult result ,  Model model) {	
		
		Utility utilityList=new Utility();
		utilityList=trainingPartnerService.editApplicationStatus(postVacancyTrainingCenterBean);
		model.addAttribute("utilityList", new Gson().toJson(utilityList));
		if(postVacancyTrainingCenterBean.getTrainingCenter()>0){
			return "editApplicationStatusDetails1";
		}else{
			return "editApplicationStatusDetails";
		}
		
	 }
	@RequestMapping(value="/postVacancyTrainingPartnerSave" , method=RequestMethod.POST)
	  public String postVacancySave(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm ,HttpSession session,BindingResult result ,  Model model){		
		boolean isPostVacancyTrainingPartner=true;
		if(postVacancyTrainingCenterForm.getTrainingCenter()==0){
			isPostVacancyTrainingPartner=false;
			int loginId=Integer.parseInt(session.getAttribute("loginIdUnique").toString());
			postVacancyTrainingCenterForm.setTrainingCenter(loginService.FullDetailtrainingpartner(loginId).getPersonalInformationTrainingPartnerId());
		}
		String postVacancy = trainingPartnerService.postVacancyTrainingPartner(postVacancyTrainingCenterForm);
		  if(postVacancy.equalsIgnoreCase("created")){
			  model.addAttribute("created", "Vacancy created successfull !!!");
		  }else{
			  model.addAttribute("created", "vacancy already created !!!");
		  }
		  if(isPostVacancyTrainingPartner){
			  return "postVacancyTrangCenter";
		  }else{
			  return "postVacancyTrainingPartner";	
		  }
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
	@RequestMapping(value="/getApplicationStatusDetails" , method=RequestMethod.POST)
	@ResponseBody
	public void getApplicationStatusDetails(@RequestBody PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		List<PostVacancyTrainingCenter> list=new ArrayList<>();
		try{
			 list = trainingPartnerService.getAppliedCount(postVacancyTrainingCenterBean);
		}catch(Exception e){
		}
		response.setContentType("text/html;charset=UTF-8");
		List<Utility> utilityList=new ArrayList<>();
		for(PostVacancyTrainingCenter pvtc:list){
			Utility e=new Utility();
				e.setCourseTypeId(pvtc.getCourseType().getCourseTypeId());
				e.setCourseTypeName(pvtc.getCourseType().getCourseType());
				e.setCourseNameId(pvtc.getCourseName().getCoursenameid());
				e.setCourseName(pvtc.getCourseName().getCoursename());
				e.setTrainingDate(pvtc.getTrainingDate());
				e.setNoOfVacancy(pvtc.getNoOfVacancy());
				e.setLoginId(pvtc.getLoginId());
				e.setNoOfApplications(pvtc.getNoOfApplications());
				utilityList.add(e);
		}
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(utilityList));
        out.flush();
	}
	

	@RequestMapping(value="/updateUpcomingTrainingsStatus" , method=RequestMethod.POST)
	@ResponseBody
	public void updateUpcomingTrainingsStatus(@RequestBody IntStringBean intStringBean,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		JsonResponse responseObj=new JsonResponse();
		responseObj.setId(intStringBean.getId());
		try{
			trainingPartnerService.updateUpcomingTrainingsStatus(intStringBean.getId());
			responseObj.setMessage("OK");
		}catch(Exception e){
			responseObj.setMessage("KO");
		}
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson=new Gson();
        String newJSON=gson.toJson(responseObj);
        out.print(newJSON);
        out.flush();
	}
	
	
	@RequestMapping(value="/applyForVacancy" , method=RequestMethod.POST)
	@ResponseBody
	public void applyForVacancy(@RequestBody PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		JsonResponse responseObj=new JsonResponse();
		responseObj.setId(postVacancyTrainingCenterBean.getTrainingCenter());
		try{
			HttpSession session=httpServletRequest.getSession(false);
			postVacancyTrainingCenterBean.setLoginId(session.getAttribute("loginIdUnique").toString());
			int appliedId = trainingPartnerService.saveVacancy(postVacancyTrainingCenterBean);
			if(appliedId>0){
				responseObj.setMessage("Vacancy applyed successfully");
			}else{
				responseObj.setMessage("Vacancy already applyed");
			}
		}catch(Exception e){
			responseObj.setMessage("unable to apply Vacancy");
		}
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson=new Gson();
        String newJSON=gson.toJson(responseObj);
        out.print(newJSON);
        out.flush();
	}
	@RequestMapping(value="/getFeedbackDetails" , method=RequestMethod.POST)
	@ResponseBody
	public void getFeedbackDetails(@RequestBody Utility utility,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		List<FeedbackForm> feedbackFormList=new ArrayList<>();
		try{
			feedbackFormList=traineeService.getFeedbackDetails(utility);
		}catch(Exception e){

		}
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(feedbackFormList));
        out.flush();
	}
	
	
	@RequestMapping(value="/trainingPartnerSearch", method = RequestMethod.GET)
	public String searchTrainingPartnerSearch(Model model, @ModelAttribute("trainingPartnerSearch")TrainingPartnerSearchForm tpSearchForm, @RequestParam int trainingPartnerId){
		TrainingPartnerSearchForm formData = new TrainingPartnerSearchForm();
		List<TrainingPartnerSearch> listTp = trainingPartnerService.getTrainingPartnerDetails(trainingPartnerId);
		formData.setListTp(listTp);
		
		Gson gson = new Gson();
		String strFormData = gson.toJson(formData);
		model.addAttribute("trainingPartnerSearch" , strFormData);
		return "trainingPartnerSearch";
	}
	
}
