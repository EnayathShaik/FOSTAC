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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ir.constantes.Constantes;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.AdmitCardForm;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.State;
import com.ir.model.TraineeAssessment;
import com.ir.model.TrainingPartner;
import com.ir.model.Utility;
import com.ir.service.AssessmentService;
import com.ir.service.PageLoadService;
import com.ir.service.TraineeService;
import com.ir.util.Profiles;

@Controller
@SessionAttributes
public class TraineeController {
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	@Autowired
	@Qualifier("assessmentService")
	public AssessmentService assessmentService;
	
	// Rishi 
	@RequestMapping(value="/contactTrainee" , method=RequestMethod.GET)
	public String contactTrainee(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee , HttpSession session){
		System.out.println("My Mail == "+contactTrainee.getEmailAddress());
		System.out.println("My Address == "+contactTrainee.getMessageDetails());
		Integer userId = (Integer) session.getAttribute("userId");
		Integer profileId = (Integer) session.getAttribute("profileId");
		String defaultMail = traineeService.getDefaultMailID(userId, profileId);
		
		return "contactTrainee";
	}
	@RequestMapping(value="/changePasswordTrainee" , method=RequestMethod.GET)
	public String contactTrainee(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm ){
		return "changePasswordTrainee";
	}
	

	@ModelAttribute("kindOfBusinessList")
	public List<KindOfBusiness> populateKindOfBusiness() {
		
		List<KindOfBusiness> kindOfBusinessList=pageLoadService.loadKindOfBusiness();
		return kindOfBusinessList;
	}
	
	
	@RequestMapping(value="/basic" , method=RequestMethod.GET)
	public String basic(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){// , Model modal , HttpSession session ){
		//String uniqueId = courseEnrolledUserForm.getUniqueId();
		//modal.addAttribute("uniqueId", uniqueId);
		//session.setAttribute("uniqueId", uniqueId);
		return "basic";
	}
	


	@RequestMapping(value="/courseTraining" , method=RequestMethod.GET)
	public String courseTraining(@RequestParam(value = "courseTypeId", required = true)  String courseTypeId , Model model, HttpSession session){
		int loginId=Integer.parseInt(session.getAttribute("loginIdUnique").toString());
		if(loginId>0){
			CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(Integer.parseInt(courseTypeId));
			model.addAttribute("courseTrainee", courseTrainee);
		}
		//session.setAttribute("uniqueId", uniqueId);
		return "courseTraining";
	}
	@RequestMapping(value="/training" , method=RequestMethod.GET)
	public String training(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "training";
	}

	@RequestMapping(value="/playvedio" , method=RequestMethod.GET)
	public String playvideo(Model model, HttpSession session){
//		CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(Integer.parseInt(courseTypeId));
//		model.addAttribute("courseTrainee", courseTrainee);
		//session.setAttribute("uniqueId", uniqueId);
		return "playvedio";
	}
	
	@RequestMapping(value="/basicSave" , method=RequestMethod.POST)
	public String basicSave(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result , HttpSession httpSession,Model model){
		int loginId = 0;
		try{
			loginId = (int) httpSession.getAttribute("loginIdUnique");
		}catch(Exception e){
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		int personalinformationtraineeid = courseEnrolledUserForm.getPersonalinformationtraineeid();
		System.out.println("loginid   :"+ loginId);
		System.out.println("personalinformationtraineeid  :"+ personalinformationtraineeid);
		long basicEnroll = traineeService.basicSave(courseEnrolledUserForm , loginId , personalinformationtraineeid);
			if(basicEnroll  > 1){
			model.addAttribute("created", "You have successfully enrolled !!!");
			model.addAttribute("roll", basicEnroll);
		
			}else{
			model.addAttribute("created", "Oops , something went wrong !!!");
			model.addAttribute("roll", basicEnroll);
		
		}
		 return "traineeHomepage";
	}
	@RequestMapping(value="/changePasswordTraineeSave" , method=RequestMethod.POST)
	public String changePasswordTraineeSave(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "changePasswordTrainee";
		}
		String id =(String) session.getAttribute("logId");
		//System.out.println(changePasswordForm.getLoginid());
		//int id = 1;
		boolean changePasswordTraineeSave = traineeService.changePasswordTraineeSave(changePasswordForm , id);
		if(changePasswordTraineeSave){
			model.addAttribute("created" , "Your password has changed !!!");
		}else{
			model.addAttribute("created" , "Oops, something went wrong !!!");
		}
		return "changePasswordTrainee";
	}
	@RequestMapping(value="/contactTraineeSave" , method=RequestMethod.POST)
	public String contactTrainee1(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee
			,BindingResult result , HttpSession session, Model model
			){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "contactTrainee";
		}//String id = contactTrainee.getUserId();
		String id=(String) session.getAttribute("logId");
		System.out.println("userid   "+ id);
		String contactTraineeSave = traineeService.contactTraineeSave(contactTrainee , id);
		if(contactTraineeSave.equalsIgnoreCase("created")){
			model.addAttribute("created" , "Your request has been sent successfully !!!");
		}else{
			model.addAttribute("created" , "Oops, something went wrong !!!");
		}
		return "contactTrainee";
	}

	@ModelAttribute("courseNameListB")
	public List<CourseName> courseNameList(){
		List<CourseName> courseNameListB = traineeService.courseNameList();
		System.out.println("course name list   :   "+ courseNameListB);
		return courseNameListB;
	}
	
	@ModelAttribute("advanceCourseNameList")
	public List<CourseName> advanceCourseNameList(){
		List<CourseName> advanceCourseNameList = traineeService.courseNameListByType(Constantes.COURSETYPE_ADVANCE);
		System.out.println("Advance course name list   :   "+ advanceCourseNameList);
		return advanceCourseNameList;
	}

	@ModelAttribute("specialCourseNameList")
	public List<CourseName> specialCourseNameList(){
		List<CourseName> specialCourseNameList = traineeService.courseNameListByType(Constantes.COURSETYPE_SPECIAL);
		System.out.println("Advance course name list   :   "+ specialCourseNameList);
		return specialCourseNameList;
	}
	@ModelAttribute("trainingPartnerList")
	public List<ManageTrainingPartner> trainingPartnerList(){
		List<ManageTrainingPartner> trainingPartnerList = traineeService.trainingPartnerList();
		System.out.println("training partner name list   :   "+ trainingPartnerList);
		return trainingPartnerList;
	}
	@ModelAttribute("trainingCenterStateList")
	public List<State> trainingCenterStateList(){
		List<State> trainingCenterStateList = traineeService.trainingCenterStateList();
		System.out.println("training partner state list   :   "+ trainingCenterStateList);
		return trainingCenterStateList;
		//return null;
	}
	@RequestMapping(value="/updateInformation" , method=RequestMethod.GET)
	public String updateInformation(@ModelAttribute("updateInformation") RegistrationFormTrainee registrationFormTrainee, HttpSession session, Model model ){		
		Integer ss = (Integer)session.getAttribute("loginUser1");
		PersonalInformationTrainee personalInformationTrainee = (PersonalInformationTrainee) session.getAttribute("loginUser");
		return "updateInformation";
	}
	@RequestMapping(value="/updateTrainee" , method=RequestMethod.POST)
	public String updateTrainee(@ModelAttribute("updateInformation") RegistrationFormTrainee registrationFormTrainee ,BindingResult bindingResult, HttpSession session , Model model  ){
		Integer ss = (Integer)session.getAttribute("loginUser1");
		System.out.println("nnb   " +ss);
		String updateTrainee = traineeService.updateTrainee(registrationFormTrainee , ss);
		if(updateTrainee != "")
		{
			System.out.println("Data are updated successfully");
		}
		model.addAttribute("update", "Updated successfully !!!");
		return "welcomeupdatetrainee";
	}
	
	@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = pageLoadService.loadState();
		System.out.println("state list   :   "+ stateList);
		return stateList;
	}
	@RequestMapping(value="/generateAdmitCardtrainee" , method=RequestMethod.GET)
	public String generateAdmitCardtrainee(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model ){
		try{
			int loginId = (int) session.getAttribute("loginIdUnique");
			CourseName courseName=traineeService.getCourseName(loginId);
			model.addAttribute("courseName", courseName);
		}catch(NullPointerException npe){
			System.out.println("1 - Exception while fetching card details generating admit card course: "+npe.getMessage());
		}catch(NumberFormatException nfe){
			System.out.println("2 - Exception while fetching card details generating admit card course: "+nfe.getMessage());
		}catch(Exception e){
			System.out.println("3- Exception while fetching card details generating admit card course: "+e.getMessage());
		}
		return "generateAdmitCardtrainee";
	}
	
	@RequestMapping(value="/admit-cardtrainee" , method=RequestMethod.GET)
	public String admitcardtrainee(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("tp") TrainingPartner tp,BindingResult result ,HttpSession session, Model model ){
		if(session.getAttribute("loginIdUnique")!=null){
			String loginid=session.getAttribute("loginIdUnique").toString();
			AdmitCardForm admitCardForm=traineeService.generateAdmitCard(Integer.parseInt(loginid),Profiles.TRAINEE.value());
			model.addAttribute("admitCardForm", admitCardForm);
		}
		return "admit-cardtrainee";
	}
	
	@RequestMapping(value="/certificatetrainee" , method=RequestMethod.GET)
	public String certificatetrainee(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("tp") TrainingPartner tp ){
		return "certificatetrainee";
	}

	@RequestMapping(value="/advanceTrainee" , method=RequestMethod.GET)
	public String advance(@ModelAttribute("advanceTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "advanceTrainee";
	}
	@RequestMapping(value="/advanceTraineeSave" , method=RequestMethod.POST)
	public String advanceTraineeSave(@ModelAttribute("advanceTrainee") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result ,HttpSession httpSession, Model model){
		
		int loginId = 0;
		try{
			loginId = (int) httpSession.getAttribute("loginIdUnique");
		}catch(Exception e){
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		
		int personalinformationtraineeid = courseEnrolledUserForm.getPersonalinformationtraineeid();
		System.out.println("loginid   :"+ loginId);
		System.out.println("personalinformationtraineeid  :"+ personalinformationtraineeid);
		long basicEnroll = traineeService.advanceTraineeSave(courseEnrolledUserForm , loginId , personalinformationtraineeid);
		if(basicEnroll  > 1){
			model.addAttribute("created", "You have successfully enrolled !!!");
			model.addAttribute("roll", basicEnroll);
		}else{
			model.addAttribute("created", "Oops , something went wrong !!!");
			model.addAttribute("roll", basicEnroll);
		}
		return "traineeHomepage";
	}
	@RequestMapping(value="/specialTrainee" , method=RequestMethod.GET)
	public String specialTrainee(@ModelAttribute("specialTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "specialTrainee";
	}
	
	@RequestMapping(value="/specialTraineeSave" , method=RequestMethod.POST)
	public String specialTraineeSave(@ModelAttribute("specialTrainee") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result ,HttpSession httpSession, Model model){
		int loginId = 0;
		try{
			loginId = (int) httpSession.getAttribute("loginIdUnique");
		}catch(Exception e){
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		int personalinformationtraineeid = courseEnrolledUserForm.getPersonalinformationtraineeid();
		System.out.println("loginid   :"+ loginId);
		System.out.println("personalinformationtraineeid  :"+ personalinformationtraineeid);
		long basicEnroll = traineeService.specialTrainee(courseEnrolledUserForm , loginId , personalinformationtraineeid);
		if(basicEnroll  > 1){
			model.addAttribute("created", "You have successfully enrolled !!!");
			model.addAttribute("roll", basicEnroll);
		}else{
			model.addAttribute("created", "Oops , something went wrong !!!");
			model.addAttribute("roll", basicEnroll);
		}
		return "traineeHomepage";
	}
	
	@RequestMapping(value="/viewTraineeList" , method=RequestMethod.GET)
	public String viewTraineeList(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "viewTraineeList";
	}
	@RequestMapping(value ="/traineeAssessmentOnline", method = RequestMethod.GET)
	public String traineeAssessmentOnline(@ModelAttribute ("courseEnrolledUserForm")CourseEnrolledUserForm courseEnroledUserForm, Model model, HttpSession httpSession){
		String responseText = "";
		int loginId = -1;
		try{
		loginId = (int)httpSession.getAttribute("loginIdUnique");
		}catch(Exception e){
			responseText = "generic_error";
			System.out.println("Exception while fetching assessment details for trainee - "+e.getMessage());
		}
		if(loginId > 0){
			TraineeAssessment traineeAssessment = new TraineeAssessment();
			int courseType = 1;
			int courseNameId = 	traineeService.getCurrentCourseId(loginId);
			List<AssessmentQuestion> assessmentQuestions =  assessmentService.getAssessmentQuestions(courseType, courseNameId);
			traineeAssessment.setListAssessmentQuestion(assessmentQuestions);
			traineeAssessment.setCourseNameId(courseNameId);
			Gson gson=new Gson();
			String list=gson.toJson(traineeAssessment);
			responseText = "traineeAssessmentOnline";
			model.addAttribute("traineeAssessment",list);
		}
		return responseText;
	}
	@RequestMapping(value="/feedbackForm" , method=RequestMethod.GET)
	public String feedback(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model){
		int loginId=Integer.parseInt(session.getAttribute("loginIdUnique").toString());
		CourseName courseName=traineeService.getCourseName(loginId);
		List<FeedbackMaster> feedbackMasters=traineeService.getFeedMasterList(Profiles.TRAINEE.value());
		model.addAttribute("courseName",courseName);
		model.addAttribute("feedbackMasters",feedbackMasters);
		return "feedbackForm";
	}
	@RequestMapping(value="/generateCertificatetrainee" , method=RequestMethod.GET)
	public String generateCertificatetrainee(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model){
		int loginId=Integer.parseInt(session.getAttribute("loginIdUnique").toString());
		CourseName courseName=traineeService.getCourseName(loginId);
		model.addAttribute("courseName",courseName);
		
		return "generateCertificatetrainee";
	}
	@RequestMapping(value="/assessment-instructions-trainee" , method=RequestMethod.GET)
	public String assessmentinstructionstrainee(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer,BindingResult bindingResult, HttpSession session , Model model )
	{
		int loginId=Integer.parseInt(session.getAttribute("loginIdUnique").toString());
		CourseName courseName=traineeService.getCourseName(loginId);
		Utility utility=new Utility();
		//Need to write service for AsssessorAgency 
		model.addAttribute("courseName",courseName);
		model.addAttribute("utility",utility);
		return "assessment-instructions-trainee";
	}
	@RequestMapping(value="/feedback-form" , method=RequestMethod.GET)
	public String feedbackform(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "feedback-form-trainee";
	}
	@RequestMapping(value="/course-training" , method=RequestMethod.GET)
	public String coursetraining(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "course-training-trainee";
	}
	@RequestMapping(value="/saveFeedbackForm" , method=RequestMethod.POST)
	public String saveFeedbackForm(@ModelAttribute("feedbackforms") List<FeedbackForm> feedbackforms ,BindingResult bindingResult, HttpSession session , Model model){
		for(FeedbackForm feedbackForm:feedbackforms){
			feedbackForm.setUserId(session.getAttribute("loginIdUnique").toString());			
		}
		
//		CourseName courseName=traineeService.getCourseDetails(loginId);
//		List<FeedbackMaster> feedbackMasters=traineeService.getFeedMasterList();
//		model.addAttribute("courseName",courseName);
//		model.addAttribute("feedbackMasters",feedbackMasters);
		return "feedbackForm";
	}
}
