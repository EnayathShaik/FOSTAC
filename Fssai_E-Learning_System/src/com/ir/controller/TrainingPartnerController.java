package com.ir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.ir.form.GenerateCourseCertificateForm;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.TraineeAttendanceForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.trainingPartner.TrainingPartnerSearch;
import com.ir.form.trainingPartner.TrainingPartnerSearchForm;
import com.ir.model.CertificateInfo;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.FeedbackForm;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.TrainingPartnerCalendarForm;
import com.ir.model.TrainingPartnerTrainingCalender;
import com.ir.model.Utility;
import com.ir.service.TraineeService;
import com.ir.service.TrainingPartnerService;
import com.zentech.logger.ZLogger;
import com.zentect.list.constant.ListConstant;

@Controller
public class TrainingPartnerController {
	

	@Autowired
	@Qualifier("trainingPartnerService")
	TrainingPartnerService trainingPartnerService; 
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;

	
	public List<PersonalInformationTrainingPartner> trainingCenterList(){
		List<PersonalInformationTrainingPartner> trainingCenterList = trainingPartnerService.trainingCenterList();
		return trainingCenterList;
	}
	
	/*@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList(){
		List<CourseType> courseTypeList = trainingPartnerService.courseTypeList();
		return courseTypeList;
	}
	*/
	ListConstant lst = new ListConstant();
	
	@RequestMapping(value="/postVacancyTrainingPartner" , method=RequestMethod.GET)
	public String postVacancy(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm,HttpSession session,BindingResult result , Model model ){
		Integer userId = (Integer) session.getAttribute("userId");
		Integer profileId = (Integer) session.getAttribute("profileId");
		
		List<CourseType> courseTypeList = trainingPartnerService.courseTypeList();
		List<IntStringBean> trainingCenterList = trainingPartnerService.getTrainingCenterList(userId,profileId);
		int trainingCenter = trainingPartnerService.getTrainingCenter(userId, profileId);
		model.addAttribute("triningCenter", trainingCenter);
		Map<String , String> vacancyMap = lst.vacancyMap;
		model.addAttribute("trainingCenterList" , trainingCenterList);
		model.addAttribute("vacancyMap",vacancyMap);
		model.addAttribute("courseTypeList",courseTypeList);
		
		return "postVacancyTrainingPartner";
		
	}
	
	
	@RequestMapping(value="/postVacancyTrainingCenter" , method=RequestMethod.GET)
	public String postVacancyTrainingCenter(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm,HttpSession session,BindingResult result , Model model ){
		return "postVacancyTrangCenter";
		
	}
	
	
	@RequestMapping(value="/generateCourseCertificate" , method=RequestMethod.GET)
	public String generateCourseCertificate(@ModelAttribute("generateCourseCertificateForm") GenerateCourseCertificateForm generateCourseCertificateForm,HttpSession session,BindingResult result , Model model ){
		List<CourseType> courseTypeList = trainingPartnerService.courseTypeList();
		model.addAttribute("courseTypeList",courseTypeList);
		return "generateCourseCertificate";
		
	}
	
	
	@RequestMapping(value="/generateCourseCertificateForTrainee" , method=RequestMethod.GET)
	public String generateCourseCertificateForTrainee(@ModelAttribute("generateCourseCertificateForm") GenerateCourseCertificateForm generateCourseCertificateForm,HttpSession session,BindingResult result , Model model ){
		List<CourseType> courseTypeList = trainingPartnerService.courseTypeList();
		model.addAttribute("courseTypeList",courseTypeList);
		return "generateCourseCertificateForTrainee";
		
	}
	
	
	@RequestMapping(value="/getBatchCode" , method=RequestMethod.POST)
	@ResponseBody
	public void getBatchCode(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("getBatchCode","getBatchCode............" + data  , "TrainingPartnerController.java");
		int courseName =  Integer.parseInt(data);
		List<String> batchCodeList = trainingPartnerService.getBatchCodeList(courseName);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		out.write(newList);
		out.flush();
		
	}
	

	
	
	@RequestMapping(value="/getCertificateID" , method=RequestMethod.POST)
	@ResponseBody
	public void getCertificateID(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("getCertificateID","getCertificateID............" + data  , "TrainingPartnerController.java");
		String[] ss = data.split("-");
		String loginId = null;
		if(!ss[1].equalsIgnoreCase("NA")){
			loginId = ss[1];
		}
		String batchcode =  ss[0];
		List<String> certificateList = trainingPartnerService.getCertificateIdList(batchcode , loginId);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(certificateList); 
		out.write(newList);
		out.flush();
	}
	
	//generateCourseCertificateGO
	
	@RequestMapping(value="/generateCourseCertificateGO" , method=RequestMethod.POST)
	public String generateCourseCertificateGO(@ModelAttribute("generateCourseCertificateForm") GenerateCourseCertificateForm generateCourseCertificateForm,HttpSession session,HttpServletRequest request ,HttpServletResponse response , BindingResult result , Model model ) throws IOException{
		System.out.println("inside generateCourseCertificateGO"+generateCourseCertificateForm.getMainCertificateId());
		new ZLogger("generateCourseCertificateGO","inside generateCourseCertificateGO"+generateCourseCertificateForm.getMainCertificateId()  , "TrainingPartnerController.java");
		Integer profileID = 0;
	
		String certificateID = generateCourseCertificateForm == null ? "" : generateCourseCertificateForm.getMainCertificateId() == null ? "" : generateCourseCertificateForm.getMainCertificateId().trim();
		
		String returnResult = null;
		try{
			
			
			profileID = (Integer) session.getAttribute("profileId");
			
			System.out.println("profileID "+profileID);
			if(profileID== 3){
			int userId = (Integer) session.getAttribute("userId");
			CertificateInfo certificateInfo = traineeService.getCertificateID(userId, profileID,certificateID);
			model.addAttribute("certificateID", certificateInfo.getCertificateID());
			model.addAttribute("trainingDate", certificateInfo.getTrainingDate());
			model.addAttribute("traineeCertificateName", certificateInfo.getName());
			model.addAttribute("trainingAddress", certificateInfo.getTrainingAddress());
			if(certificateInfo.getTrainingPartnerName().equalsIgnoreCase("Hotel and Restaurant Association (Western India)")){
			returnResult = "certificatetraineeHRAWI";	
			}
			else if(certificateInfo.getTrainingPartnerName().equalsIgnoreCase("Hotel and Restaurant Association (Northern India)")){
				returnResult = "certificatetraineeHRANI";
			}else if(certificateInfo.getTrainingPartnerName().equalsIgnoreCase("FSSAI")){
				returnResult ="certificatetraineeFSSAI";
			}else{
				returnResult = "certificatetraineeGEN";
			}
			
			}else{
				
				int loginId =generateCourseCertificateForm.getLoginId();
				int traineeId = generateCourseCertificateForm.getTraineeId();
				System.out.println(" traineeId "+traineeId);
				traineeService.updateSteps(traineeId, profileID, 0);
				CertificateInfo certificateInfo = traineeService.getCertificateID(loginId, profileID,"");
				model.addAttribute("certificateID", certificateInfo.getCertificateID());
				model.addAttribute("trainingDate", certificateInfo.getTrainingDate());
				model.addAttribute("traineeCertificateName", certificateInfo.getName());
				model.addAttribute("trainingAddress", certificateInfo.getTrainingAddress());
				if(certificateInfo.getTrainingPartnerName().equalsIgnoreCase("Hotel and Restaurant Association (Western India)")){
				returnResult = "certificatetraineeHRAWI";	
				}
				else if(certificateInfo.getTrainingPartnerName().equalsIgnoreCase("Hotel and Restaurant Association (Northern India)")){
					returnResult = "certificatetraineeHRANI";
				}else if(certificateInfo.getTrainingPartnerName().equalsIgnoreCase("FSSAI")){
					returnResult ="certificatetraineeFSSAI";
				}else{
					returnResult = "certificatetraineeGEN";
				}
				
				
				new ZLogger("certificatetrainee","Certificate ID = "+certificateInfo.getCertificateID()  , "TrainingPartnerController.java");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("generateCourseCertificateGO","Exception while "+e.getMessage() , "TrainingPartnerController.java");
		}
		
		System.out.println("returnResult "+returnResult);
		return returnResult;
		
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
			new ZLogger("viewFeedbackDetails", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("viewFeedbackDetails", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnerapplicationstatus1";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		//List<CourseName> courseNames = trainingPartnerService.getCourseNameList();
		trainingpartnerapplicationstatus.setCourseTypes(courseTypes);
		List<PersonalInformationTrainingPartner> trainingCenterList=trainingCenterList();
		trainingpartnerapplicationstatus.setTrainingCenterList(trainingCenterList);
		List<IntStringBean> traineeList = trainingPartnerService.getTraineeList();
		trainingpartnerapplicationstatus.setTraineeList(traineeList);
	
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerapplicationstatus" , gson.toJson(trainingpartnerapplicationstatus));
	
		return "viewFeedbackDetails";		
	}
	@RequestMapping(value="/changePasswordTrainingartnerSave" , method=RequestMethod.POST)
	public String changePasswordTraineeSave(@ModelAttribute("changePasswordTrainingPartner") ChangePasswordForm changePasswordForm,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			new ZLogger("changePasswordTrainingartnerSave", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("changePasswordTrainingartnerSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "changePasswordTrainingPartner";
		}
		String id =(String) session.getAttribute("logId");
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
			new ZLogger("trainingpartnertrainingcalendar", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnertrainingcalendar", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnertrainingcalendar";
		}

		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingPartnerTrainingCalender.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		List<IntStringBean> assessmentAgencyNameList = trainingPartnerService.loadAssessmentAgency();
		trainingPartnerTrainingCalender.setAssessmentAgencyName(assessmentAgencyNameList);
		trainingPartnerTrainingCalender.setTrainerList(trainerList);
		Gson gson = new Gson();
		model.addAttribute("trainingPartnerTrainingCalender" , gson.toJson(trainingPartnerTrainingCalender));
		return "trainingpartnertrainingcalendar";
	}
	@RequestMapping(value="/viewtrainingpartnertrainingcalendar" , method=RequestMethod.GET)
	public String viewtrainingpartnertrainingcalendar(@ModelAttribute("trainingPartnerTrainingCalender") TrainingPartnerTrainingCalender trainingPartnerTrainingCalender,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			new ZLogger("viewtrainingpartnertrainingcalendar", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("viewtrainingpartnertrainingcalendar", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
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
			new ZLogger("trainingpartnerassessmentcalendar", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnerassessmentcalendar", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnerassessmentcalendar";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingpartnerassessmentcalendar.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		List<IntStringBean> assessorList = trainingPartnerService.getAssessorList();
		trainingpartnerassessmentcalendar.setTrainerList(trainerList);
		trainingpartnerassessmentcalendar.setAssessorList(assessorList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerassessmentcalendar" , gson.toJson(trainingpartnerassessmentcalendar));
		return "trainingpartnerassessmentcalendar";
	}

	@RequestMapping(value="/trainingpartnerapplicationstatus" , method=RequestMethod.GET)
	public String trainingpartnerapplicationstatus(@ModelAttribute("trainingpartnerapplicationstatus") TrainingPartnerTrainingCalender trainingpartnerapplicationstatus,HttpSession session,BindingResult result , Model model){
	
		return "trainingpartnerapplicationstatus";
	}
	
	@RequestMapping(value="/trainingpartnerapplicationstatus1" , method=RequestMethod.GET)
	public String trainingpartnerapplicationstatus1(@ModelAttribute("trainingpartnerapplicationstatus") TrainingPartnerTrainingCalender trainingpartnerapplicationstatus,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			new ZLogger("trainingpartnerapplicationstatus1", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnerapplicationstatus1", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnerapplicationstatus1";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingpartnerapplicationstatus.setCourseTypes(courseTypes);
		List<PersonalInformationTrainingPartner> trainingCenterList=trainingCenterList();
		trainingpartnerapplicationstatus.setTrainingCenterList(trainingCenterList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerapplicationstatus" , gson.toJson(trainingpartnerapplicationstatus));
		return "trainingpartnerapplicationstatus1";
	}

	@RequestMapping(value="/trainingpartnermanagetrainer" , method=RequestMethod.GET)
	public String trainingpartnermanagetrainer(@ModelAttribute("trainingpartnermanagetrainer") TrainingPartnerTrainingCalender trainingpartnermanagetrainer,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			new ZLogger("trainingpartnermanagetrainer", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnermanagetrainer", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnermanagetrainer";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingpartnermanagetrainer.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnermanagetrainer.setTrainerList(trainerList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnermanagetrainer" , gson.toJson(trainingpartnermanagetrainer));
		return "trainingpartnermanagetrainer";
	}
	
	@RequestMapping(value="/trainingpartnerviewtraineelist" , method=RequestMethod.GET)
	public String trainingpartnerviewtraineelist(@ModelAttribute("trainingpartnerviewtraineelist") TrainingPartnerTrainingCalender trainingpartnerviewtraineelist,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			new ZLogger("trainingpartnerviewtraineelist", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnerviewtraineelist", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnerviewtraineelist";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingpartnerviewtraineelist.setCourseTypes(courseTypes);
		/*List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnerviewtraineelist.setTrainerList(trainerList);*/
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
			new ZLogger("trainingpartnerpaymentconfirmation", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnerpaymentconfirmation", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			return "trainingpartnerpaymentconfirmation";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingpartnerpaymentconfirmation.setCourseTypes(courseTypes);
		List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnerpaymentconfirmation.setTrainerList(trainerList);
		List<StringStringBean> statusList= trainingPartnerService.getStatusList();
		trainingpartnerpaymentconfirmation.setStatusList(statusList);
		Gson gson = new Gson();
		model.addAttribute("trainingpartnerpaymentconfirmation" , gson.toJson(trainingpartnerpaymentconfirmation));
		return "trainingpartnerpaymentconfirmation";
	}
	
	
	@RequestMapping(value="/tcm" , method=RequestMethod.GET)
	public String tcm(){
			return "tcm";
	}
	
	
	
	@RequestMapping(value="/trainingpartnermarkAttendence" , method=RequestMethod.GET)
	public String trainingpartnermarkAttendence(@ModelAttribute("trainingpartnermarkAttendence") TrainingPartnerTrainingCalender trainingpartnerpaymentconfirmation,HttpSession session,BindingResult result , Model model){
		if(result.hasErrors()){
			new ZLogger("trainingpartnermarkAttendence", "bindingResult.hasErrors  "+result.hasErrors() , "TrainingPartnerController.java");
			new ZLogger("trainingpartnermarkAttendence", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "TrainingPartnerController.java");
			
			return "trainingpartnermarkAttendence";
		}
		
		List<CourseType> courseTypes = trainingPartnerService.courseTypes();
		trainingpartnerpaymentconfirmation.setCourseTypes(courseTypes);
		/*List<IntStringBean> trainerList = trainingPartnerService.getTrainerList();
		trainingpartnerpaymentconfirmation.setTrainerList(trainerList);
		List<StringStringBean> statusList= trainingPartnerService.getStatusList();
		trainingpartnerpaymentconfirmation.setStatusList(statusList);*/
		Gson gson = new Gson();
		model.addAttribute("trainingpartnermarkAttendence" , gson.toJson(trainingpartnerpaymentconfirmation));
		return "trainingpartnermarkAttendence";
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
			new ZLogger("updateApplicationStatusForEnrolledVacancy", "Exception while updateApplicationStatusForEnrolledVacancy  "+e.getMessage() , "TrainingPartnerController.java");
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
			new ZLogger("getTrainingCalenderList", "Exception while getTrainingCalenderList  "+e.getMessage() , "TrainingPartnerController.java");
		}
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(trainingCalendarList));
        out.flush();
	 }
	
	@RequestMapping(value="/editApplicationStatusDetails" , method=RequestMethod.GET)
	  public String editApplicationStatusDetails(@ModelAttribute("PostVacancyTrainingCenterBean") PostVacancyTrainingCenterBean postVacancyTrainingCenterBean ,HttpSession session,BindingResult result ,  Model model) {	
		String resumePath = "";
		Utility utilityList=new Utility();
		utilityList=trainingPartnerService.editApplicationStatus(postVacancyTrainingCenterBean);
		model.addAttribute("utilityList", new Gson().toJson(utilityList));
		
		resumePath = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Trainer");
		model.addAttribute("resumePath", resumePath);
		if(postVacancyTrainingCenterBean.getTrainingCenter()>0){
			return "editApplicationStatusDetails1";
		}else{
			return "editApplicationStatusDetails";
		}
		
	 }
	@RequestMapping(value="/postVacancyTrainingPartnerSave" , method=RequestMethod.POST)
	  public String postVacancySave(@ModelAttribute("postVacancyTrainingCenterForm") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm ,HttpSession session,BindingResult result ,  Model model){		
		String postVacancy = trainingPartnerService.postVacancyTrainingPartner(postVacancyTrainingCenterForm);
		  if(postVacancy.equalsIgnoreCase("created")){
			  model.addAttribute("created", "Vacancy created successfull !!!");
		  }else{
			  model.addAttribute("created", "vacancy already created !!!");
		  }
		  
		  return "redirect:/postVacancyTrainingPartner.fssai";
		  
	 }
	
	@RequestMapping(value="/getApplicationStatusDetails" , method=RequestMethod.POST)
	@ResponseBody
	public void getApplicationStatusDetails(@RequestParam("name") String name ,@RequestBody PostVacancyTrainingCenterBean postVacancyTrainingCenterBean,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		
		
		List<PostVacancyTrainingCenter> list=new ArrayList<>();
		try{
			 list = trainingPartnerService.getAppliedCount(postVacancyTrainingCenterBean);
	
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("getApplicationStatusDetails", "Exception while getApplicationStatusDetails  "+e.getMessage() , "TrainingPartnerController.java");
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
				//e.setTrainingStartDate(pvtc.getTrainingDate());
				e.setTrainingEndDate(pvtc.getTrainingEndTime());
				e.setNoOfVacancy(pvtc.getNoOfVacancy());
				e.setLoginId(pvtc.getLoginId());
				e.setNoOfApplications(pvtc.getNoOfApplications());
				e.setCourseCode(pvtc.getCourseName().getCourseCode());
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
			new ZLogger("updateUpcomingTrainingsStatus", "Exception while updateUpcomingTrainingsStatus  "+e.getMessage() , "TrainingPartnerController.java");
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
		Integer profileID = 0;
		Integer userId = 0;
		try{
			HttpSession session=httpServletRequest.getSession(false);
			profileID = (Integer) session.getAttribute("profileId");
			userId = (Integer) session.getAttribute("userId");
			postVacancyTrainingCenterBean.setLoginId(session.getAttribute("loginIdUnique").toString());
			int appliedId = trainingPartnerService.saveVacancy(postVacancyTrainingCenterBean,profileID,userId);
			if(appliedId>0){
				responseObj.setMessage("Vacancy applyed successfully");
			}else{
				responseObj.setMessage("Vacancy already applyed");
			}
		}catch(Exception e){
			responseObj.setMessage("unable to apply Vacancy");
			new ZLogger("applyForVacancy", "Exception while applyForVacancy  "+e.getMessage() , "TrainingPartnerController.java");
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
			new ZLogger("getFeedbackDetails", "Exception while getFeedbackDetails  "+e.getMessage() , "TrainingPartnerController.java");	
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
	
	@RequestMapping(value="/trainingCenterCalenderSave" , method=RequestMethod.POST)
	public String trainingCalenderSave(@Valid @ModelAttribute("trainingPartnerCalendarForm") TrainingPartnerCalendarForm trainingPartnerCalendarForm ,BindingResult result ,Model model , HttpSession session) {
		try{
			if(result.hasErrors()){
				System.out.println(" bindingResult.hasErrors "+result.hasErrors());
				System.out.println(result.getErrorCount());
				System.out.println(result.getAllErrors());
				return "trainingpartnertrainingcalendar";
			}
			Integer profileID = 0;
			int loginId = 0;
				profileID = (Integer) session.getAttribute("profileId");
				loginId = (int) session.getAttribute("loginIdUnique");
				int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileID);
		     
			TrainingCalendarForm trainingCalendarForm = new TrainingCalendarForm();
			trainingPartnerService.setTrainingCalanderDeatils(trainingCalendarForm, trainingPartnerCalendarForm.getLoginId());
			trainingCalendarForm.setCourseName(trainingPartnerCalendarForm.getSelCourseName());
			trainingCalendarForm.setCourseType(trainingPartnerCalendarForm.getSelCourseType());
			trainingCalendarForm.setTrainerName(trainingPartnerCalendarForm.getSelTrainerNames());
			trainingCalendarForm.setTrainingStartDate(trainingPartnerCalendarForm.getTrainingStartDate());
			trainingCalendarForm.setTrainingEndDate(trainingPartnerCalendarForm.getTrainingEndDate());
			trainingCalendarForm.setAssessmentAgencyName(trainingPartnerCalendarForm.getAssessmentAgencyName());
			trainingCalendarForm.setTcid(trainingPartnerCalendarForm.getTcid());
			trainingCalendarForm.setSeatCapacity(trainingPartnerCalendarForm.getSeatCapacity());
			trainingCalendarForm.setType(trainingPartnerCalendarForm.getType());
			trainingCalendarForm.setAssessor(trainingPartnerCalendarForm.getAssessorName());
			trainingCalendarForm.setAssessmentDateTime(trainingPartnerCalendarForm.getAssessmentDateTime());
			trainingCalendarForm.setTrainingCenter(tableID);
			trainingCalendarForm.setUserName(trainingPartnerCalendarForm.getUserName());
			
			String trainingCalendar = trainingPartnerService.trainingCalendarForm(trainingCalendarForm);
			
			model.addAttribute(new TrainingPartnerCalendarForm()); 
			if(trainingCalendar.equalsIgnoreCase("created")){
				model.addAttribute("created", "Calender saved successfully !!!");
			}else{
				model.addAttribute("created", "Oops , something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("trainingCenterCalenderSave", "Exception while trainingCenterCalenderSave  "+e.getMessage() , "TrainingPartnerController.java");
		}
		
		return "redirect:/trainingpartnertrainingcalendar.fssai";
	}
	
	
	@RequestMapping("/trainingCalendarRemove" )
    public String removeManageCourseCarricullum(@Valid @ModelAttribute("trainingPartnerCalendarForm") TrainingPartnerCalendarForm trainingPartnerCalendarForm){
        trainingPartnerService.cancelTrainingCalendar(trainingPartnerCalendarForm.getTcid());
		return "redirect:/trainingpartnertrainingcalendar.fssai";
    }
	
	
//traineeCenterViewTrainee
	@RequestMapping(value="/traineeCenterViewTrainee" , method=RequestMethod.POST)
	@ResponseBody
	public void traineeCenterViewTrainee(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("traineeCenterViewTrainee","traineeCenterViewTrainee............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.getTrainingPartnerList(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	@RequestMapping(value="/tcvt" , method=RequestMethod.POST)
	@ResponseBody
	public void traineeCenterViewTraineeList(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("traineeCenterViewTraineeList","traineeCenterViewTraineeList............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.traineeCenterViewTraineeList(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	
	@RequestMapping(value="/traineeCenterPaymentConfirmation" , method=RequestMethod.POST)
	@ResponseBody
	public void traineeCenterPaymentConfirmation(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("traineeCenterPaymentConfirmation","traineeCenterPaymentConfirmation............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.traineeCenterPaymentConfirmation(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//trainingpartnermanagetrainer
	
	
	

	@RequestMapping(value="/trainingpartnermanagetrainer" , method=RequestMethod.POST)
	@ResponseBody
	public void trainingpartnermanagetrainer(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("trainingpartnermanagetrainer","trainingpartnermanagetrainer............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.trainingpartnermanagetrainer(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchVacancy
	
	
	@RequestMapping(value="/searchVacancy" , method=RequestMethod.POST)
	@ResponseBody
	public void searchVacancy(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchVacancy","searchVacancy............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.searchVacancy(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	
	
	@RequestMapping(value="/searchMarkAttendance" , method=RequestMethod.POST)
	@ResponseBody
	public void searchMarkAttendance(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchMark","searchVacancy............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.searchMarkAttendance(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//updateAttendanceStatus
	
	
	@RequestMapping(value="/updateAttendanceStatus" , method=RequestMethod.POST)
	@ResponseBody
	public void updateAttendanceStatus(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchMark","searchVacancy............" + data  , "TrainingPartnerController.java");
		String result = trainingPartnerService.updateAttendanceStatus(data);
		PrintWriter out = response.getWriter();

		out.write(result);
		out.flush();
		
	}
	
	//SearchUpcomingTraining
	
	@RequestMapping(value="/searchUpcomingTraining" , method=RequestMethod.POST)
	@ResponseBody
	public void searchUpcomingTraining(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchUpcomingTraining","SearchUpcomingTraining............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.SearchUpcomingTraining(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchTrainingCenterList
	
	@RequestMapping(value="/searchTrainingCenterList" , method=RequestMethod.POST)
	@ResponseBody
	public void searchTrainingCenterList(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchTrainingCenterList","searchTrainingCenterList............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.searchTrainingCenterList(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	//onLoadTrainingPartnerCenterId
	@RequestMapping(value="/onLoadTrainingPartnerCenterId" , method=RequestMethod.POST)
	@ResponseBody
	public void onLoadTrainingPartnerCenterId(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("onLoadTrainingPartnerCenterId","onLoadTrainingPartnerCenterId............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.onLoadTrainingPartnerCenterId(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	@RequestMapping(value="/traineeAttendance" , method={RequestMethod.GET , RequestMethod.POST} )
	public String traineeAttendance(@ModelAttribute("traineeAttendanceForm") TraineeAttendanceForm traineeAttendanceForm,HttpSession session,BindingResult result , Model model ){
		return "traineeAttendance";
		
	}
	
	//markTraineeAttendance

	@RequestMapping(value="/markTraineeAttendance" , method=RequestMethod.POST)
	@ResponseBody
	public void markTraineeAttendance(@RequestParam("data") String data  , @RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		
		String rollNo =data;
		System.out.println("roll number "+rollNo);
		String res = trainingPartnerService.markTraineeAttendance(rollNo);
		
		System.out.println("res "+res);
		//checkAadhar
		PrintWriter out = response.getWriter(); 
		out.write(res );
		out.flush();
		
	}
	
	
	@RequestMapping(value="/getAttendanceDeatils" , method=RequestMethod.POST)
	@ResponseBody
	public void getAttendanceDeatils(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response ,  Model model ) throws IOException{
		new ZLogger("getAttendanceDeatils","getAttendanceDeatils............" + data  , "TrainingPartnerController.java");

			List  courseEnrolledDetails= traineeService.getAttendanceDeatilsByID(data);
			PrintWriter out = response.getWriter();
			Gson g =new Gson();
			String newList = g.toJson(courseEnrolledDetails); 
			System.out.println("newList "+newList);
			out.write(newList);
			out.flush();
		
		
		
	}
	
	//savePaymentStatus
	
	@RequestMapping(value="/savePaymentStatus" , method=RequestMethod.POST)
	@ResponseBody
	public void savePaymentStatus(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("savePaymentStatus","savePaymentStatus............" + data  , "TrainingPartnerController.java");
		String result = traineeService.savePaymentStatus(data);
		System.out.println("result "+result);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		
	}
	
	
	
	@RequestMapping(value="/updateTrainingCalendar" , method=RequestMethod.POST)
	@ResponseBody
	public void updateTrainingCalendar(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("updateTrainingCalendar","updateTrainingCalendar............" + data  , "TrainingPartnerController.java");
		String result = trainingPartnerService.updateTrainingCalendar(data);
		PrintWriter out = response.getWriter();

		out.write(result);
		out.flush();
		
	}
	
	
//	/certificateForTraineeList
	@RequestMapping(value="/certificateForTraineeList" , method=RequestMethod.POST)
	@ResponseBody
	public void certificateForTraineeList(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("certificateForTraineeList","certificateForTraineeList............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.certificateForTraineeList(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	@RequestMapping(value="/TraineeCourseCertificateGO" , method=RequestMethod.POST)
	@ResponseBody
	public void TraineeCourseCertificateGO(@RequestParam("data") String data  , @RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpSession session,HttpServletRequest request ,HttpServletResponse response  , Model model ) throws IOException{
		
		new ZLogger("TraineeCourseCertificateGO","inside TraineeCourseCertificateGO"+data  , "TrainingPartnerController.java");
		String[] strArr = data.split("@");
		String certificateID = (strArr[3] == null  || strArr[3] == "null" ? "" : strArr[3]);
		String trainingDate = strArr[0];
		String traineeName = strArr[2];
		String tpName = strArr[4];
		String address = strArr[5];
		
		String returnResult = null;
		try{
	
			model.addAttribute("certificateID", certificateID);
			model.addAttribute("trainingDate",trainingDate);
			model.addAttribute("traineeCertificateName", traineeName);
			model.addAttribute("trainingAddress", address);
			if(tpName.equalsIgnoreCase("Hotel and Restaurant Association (Western India)")){
			returnResult = "certificatetraineeHRAWI";	
			}
			else if(tpName.equalsIgnoreCase("Hotel and Restaurant Association (Northern India)")){
				returnResult = "certificatetraineeHRANI";
			}else if(tpName.equalsIgnoreCase("FSSAI")){
				returnResult ="certificatetraineeFSSAI";
			}else{
				returnResult = "certificatetraineeGEN";
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("generateCourseCertificateGO","Exception while "+e.getMessage() , "TrainingPartnerController.java");
		}
		
		System.out.println("returnResult "+returnResult);
		//return returnResult;
		
	}
	//searchDataTP
	
	@RequestMapping(value="/searchDataTP" , method=RequestMethod.POST)
	@ResponseBody
	public void searchDataTP(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchDataTP","searchDataTP............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.searchDataTP(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//editMTP
	
	@RequestMapping(value="/editMTP" , method=RequestMethod.POST)
	@ResponseBody
	public void editMTP(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("editMTP","editMTP............" + data  , "TrainingPartnerController.java");
		List batchCodeList = trainingPartnerService.editMTP(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(batchCodeList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//updateMTP
	
	@RequestMapping(value="/updateMTP" , method=RequestMethod.POST)
	@ResponseBody
	public void updateMTP(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("updateMTP","updateMTP............" + data  , "TrainingPartnerController.java");
		String result = trainingPartnerService.updateMTP(data);
		PrintWriter out = response.getWriter();
		System.out.println("newList "+result);
		out.write(result);
		out.flush();
		
	}
	
}
