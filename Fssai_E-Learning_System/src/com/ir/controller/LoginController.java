package com.ir.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import org.apache.tomcat.util.net.jsse.openssl.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.ir.form.LoginForm;
import com.ir.model.LoginDetails;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.TrainingPartner;
import com.ir.service.LoginService;
import com.ir.service.TrainingPartnerService;
import com.ir.service.UpdateService;

/**
 * Controller to handle login process
 * 
 */
@Controller
@SessionAttributes
public class LoginController {
	
	
	@Autowired
	@Qualifier("loginService")
	LoginService loginService; 
	
	@Autowired
	@Qualifier("updateServiceImpl")
	UpdateService updateServiceImpl; 
	
	@Autowired
	@Qualifier("personalInformationTrainee")
	PersonalInformationTrainee personalInformationTrainee; 
	@Autowired
	@Qualifier("personalInformationTrainer")
	PersonalInformationTrainer personalInformationTrainer; 
	@Autowired
	@Qualifier("personalInformationTrainingPartner")
	PersonalInformationTrainingPartner personalInformationTrainingPartner; 
	@Autowired
	@Qualifier("personalInformationAssessor")
	PersonalInformationAssessor personalInformationAssessor; 
	@Autowired
	@Qualifier("trainingPartnerService")
	TrainingPartnerService trainingPartnerService; 
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(@ModelAttribute("login") LoginForm loginForm , HttpSession session) {
		Integer profileID = (Integer) session.getAttribute("profileId");
		if(profileID != null && profileID > 0){
			return "redirect:loginProcess.fssai";
		}
		System.out.println("LoginController loginForm begin .");
		return "login";
	}

	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/traineeHome", method = RequestMethod.GET)
	public String traineeHome(@ModelAttribute("login") LoginForm loginForm ,BindingResult result, Model model, HttpSession session) {
		String userid=(String)session.getAttribute("loginId");
		if(userid!=null){
			return "traineeHomepage";
		}else{
			return "login";
		}
		
	}

	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/trainerHome", method = RequestMethod.GET)
	public String trainerHome(@ModelAttribute("login") LoginForm loginForm ,BindingResult result, Model model, HttpSession session) {
		String userid=(String)session.getAttribute("loginId");
		if(userid!=null){
			return "trainerHomepage";
		}else{
			return "login";
		}
		
	}
	
	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("login") LoginForm loginForm,BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			session.invalidate();
			return "login";
		}
		LoginDetails loginDetails = null;
		try{
			loginDetails = loginService.login(loginForm);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(loginDetails == null){
			model.addAttribute("error" , "Oops , You are not authorized !!!");
			return "login";
		}
		session.setAttribute("loginIdUnique", loginDetails.getId());
		if(loginDetails!=null && loginDetails.getProfileId()==1 && loginDetails.getStatus().equalsIgnoreCase("A")){
			model.addAttribute("loginDetails", loginDetails);
			List<TrainingPartner> trainingPartnerList = trainingPartnerList();
			session.setAttribute("trainingPartnerList", trainingPartnerList);
			session.setAttribute("loginUser", loginDetails);  
			session.setAttribute("logId",loginDetails.getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			System.out.println("in super admin admin login");
			return "adminHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 2 && loginDetails.getStatus().equalsIgnoreCase("A")){
			System.out.println("in admin login");
			session.setAttribute("loginUser", loginDetails);
			session.setAttribute("logId",loginDetails.getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "adminHomepage";
		}else if(loginDetails !=null && loginDetails.getProfileId() == 3 && loginDetails.getStatus().equalsIgnoreCase("A"))
		{
			PersonalInformationTrainee personalInformationTrainee = loginService.FullDetail(loginDetails.getId() );
			System.out.println("in trainee login  "+ personalInformationTrainee.getFirstName());
			model.addAttribute("loginUser", personalInformationTrainee);
			session.setAttribute("personalinformationtraineeid", personalInformationTrainee.getId());
			session.setAttribute("loginId", personalInformationTrainee.getLoginDetails().getLoginId());
			session.setAttribute("loginUserS", personalInformationTrainee);
			session.setAttribute("loginUser", personalInformationTrainee);
			session.setAttribute("loginUser1", personalInformationTrainee.getId());
			session.setAttribute("logId", personalInformationTrainee.getLoginDetails().getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			session.setAttribute("traineeSteps", personalInformationTrainee.getSteps());
		
			//Set Course Details IF user Already Enrolled.
			
			
			return "traineeHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 4 && loginDetails.getStatus().equalsIgnoreCase("A")){
			PersonalInformationTrainer personalInformationTrainer = loginService.FullDetailTrainer(loginDetails.getId());
			session.setAttribute("loginUser", personalInformationTrainer);
			System.out.println("in trainer login");
			session.setAttribute("loginUr", personalInformationTrainer);
			session.setAttribute("personalInformationTrainerid", personalInformationTrainer.getPersonalInformationTrainerId());
			session.setAttribute("loginUserS", personalInformationTrainer);
			session.setAttribute("stateid", personalInformationTrainer.getPermanentstate().getStateId());
			session.setAttribute("statename", personalInformationTrainer.getPermanentstate().getStateName());
			System.out.println("-----> "+ personalInformationTrainer.getPermanentdistrict().getDistrictId());
			//int stateid = personalInformationTrainer.getPermanentstate().getStateId();
			//int districtId = personalInformationTrainer.getPermanentdistrict().getDistrictId();
			//int cityId = personalInformationTrainer.getPermanentcity().getCityId();
			session.setAttribute("tp", personalInformationTrainer.getAssociatedTrainingpartnerName() == null ? "" : personalInformationTrainer.getAssociatedTrainingpartnerName().getTrainingPartnerName());
			session.setAttribute("loginId", personalInformationTrainer.getLoginDetails().getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			model.addAttribute("logintrainer", personalInformationTrainer);
			session.setAttribute("loginUser2", personalInformationTrainer.getPersonalInformationTrainerId());
			session.setAttribute("logId", personalInformationTrainer.getLoginDetails().getLoginId());
			session.setAttribute("Id",personalInformationTrainer.getLoginDetails().getId());
			
			
			return "trainerHomepage";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 5){
			if(loginDetails.getStatus().equalsIgnoreCase("A")){
				PersonalInformationTrainingPartner personalInformationTrainingPartner ;
				personalInformationTrainingPartner = loginService.FullDetailtrainingpartner(loginDetails.getId());
				System.out.println("in trainer login aadhar is "+personalInformationTrainingPartner.getFirstName());
				session.setAttribute("loginUr", personalInformationTrainingPartner);
				session.setAttribute("loginUserS", personalInformationTrainingPartner);
				model.addAttribute("logintrainer", personalInformationTrainingPartner);
				System.out.println("**************"+personalInformationTrainingPartner.getPersonalInformationTrainingPartnerId());
				session.setAttribute("loginUsertrainingpartner", personalInformationTrainingPartner.getPersonalInformationTrainingPartnerId());
				session.setAttribute("logId", personalInformationTrainingPartner.getLoginDetails().getLoginId());
				session.setAttribute("profileId", loginDetails.getProfileId());
				session.setAttribute("userId", loginDetails.getId());
				session.setAttribute("userName", loginDetails.getLoginId());
				System.out.println("id of trainpartner is "+personalInformationTrainingPartner.getPersonalInformationTrainingPartnerId());	
				return "trainingPartnerHomepage";
			}else{
				model.addAttribute("error" , "Oops , you are not authorized !!!");
				return "login";
			}
				
		}
		else if(loginDetails != null && loginDetails.getProfileId() == 6 ){
			System.out.println("in login when assessor");
			if(loginDetails.getStatus().equalsIgnoreCase("A")){
				PersonalInformationAssessor personalInformationAssessor ;
				personalInformationAssessor = loginService.fullDetailAssessor(loginDetails.getId());
				session.setAttribute("loginUser", personalInformationAssessor);
				session.setAttribute("loginUr", personalInformationAssessor);
				session.setAttribute("loginUserAssessor", personalInformationAssessor.getId());
				model.addAttribute("loginUser", personalInformationAssessor);
				session.setAttribute("logId", personalInformationAssessor.getLoginDetails().getLoginId());
				session.setAttribute("profileId", loginDetails.getProfileId());
				session.setAttribute("userId", loginDetails.getId());
				session.setAttribute("userName", loginDetails.getLoginId());
				return "AssessorPage";
			}else{
				model.addAttribute("error" , "Oops , you are not authorized !!!");
				return "login";
			}
			
		}
		else if(loginDetails!=null && loginDetails.getProfileId() == 7 && loginDetails.getStatus().equalsIgnoreCase("A")){
			// TRAINING PARTNER  //// TRAINING PARTNER  //// TRAINING PARTNER  //// TRAINING PARTNER  //
			//session.invalidate();
			ManageTrainingPartner manageTrainingPartner = new ManageTrainingPartner();
			manageTrainingPartner = loginService.FullDetailTP(loginDetails.getId());
			System.out.println("in training partner login");
			session.setAttribute("loginUser", manageTrainingPartner);
			session.setAttribute("logerClass","PersonalInformationTrainingPartner");
		//by rishi
			session.setAttribute("logId", manageTrainingPartner.getLoginDetails().getLoginId());
			//rishi
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "trainingPartnerDashboard";
		}else if(loginDetails!=null && loginDetails.getProfileId() == 8 && loginDetails.getStatus().equalsIgnoreCase("A")){
			// Assessment Agency  //// Assessment Agency  //// Assessment Agency  //// Assessment Agency  //
			//session.invalidate();
			System.out.println("in assessment agency");
			ManageAssessmentAgency manageAssessmentAgency = new ManageAssessmentAgency();
			manageAssessmentAgency = loginService.FullDetailAssessmentAgency(loginDetails.getId());
			System.out.println("in assessment Agency Homepage");
			session.setAttribute("loginUser", manageAssessmentAgency);
		//by rishi
			session.setAttribute("logId", manageAssessmentAgency.getLoginDetails().getLoginId());
			session.setAttribute("logerClass","ManageAssessmentAgency");
			session.setAttribute("loginIdUnique", loginDetails.getId());
			System.out.println("id Is "+manageAssessmentAgency.getLoginDetails().getLoginId());
			session.setAttribute("profileId", loginDetails.getProfileId());
			session.setAttribute("userId", loginDetails.getId());
			session.setAttribute("userName", loginDetails.getLoginId());
			return "assessmentAgencyHomepage";
		}else{
			model.addAttribute("error" , "Oops , wrong Id and password !!!");
			return "login";
		}

	}
	
	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loadData", method = RequestMethod.GET)
	public String loadData(@Valid @ModelAttribute("login") LoginForm loginForm,BindingResult result, Model model, HttpSession session) {
		Integer profileID = (Integer) session.getAttribute("profileId");
		
		if(profileID != null && profileID > 0){
			if(profileID == 1){
				return "adminHomepage";
			}else if(profileID == 2){
				return "adminHomepage";
			}else if(profileID == 3){
				return "traineeHomepage";
			}else if(profileID == 4){
				return "trainerHomepage";
			}else if(profileID == 5){
				return "trainingPartnerHomepage";
			}else if(profileID == 6){
				return "AssessorPage";
			}else if(profileID == 7){
				return "trainingPartnerDashboard";
			}else if(profileID == 8){
				return "assessmentAgencyHomepage";
			}
		}
		return "login";
	}
	
	/**
	 * @param loginForm
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
	public String loginAuto(@Valid @ModelAttribute("login") LoginForm loginForm,BindingResult result, Model model, HttpSession session) {
		Integer profileID = (Integer) session.getAttribute("profileId");
		
		
		if(profileID != null && profileID > 0){
			if(profileID == 1){
				return "adminHomepage";
			}else if(profileID == 2){
				return "adminHomepage";
			}else if(profileID == 3){
				return "traineeHomepage";
			}else if(profileID == 4){
				return "trainerHomepage";
			}else if(profileID == 5){
				return "trainingPartnerHomepage";
			}else if(profileID == 6){
				return "AssessorPage";
			}else if(profileID == 7){
				return "trainingPartnerDashboard";
			}else if(profileID == 8){
				return "assessmentAgencyHomepage";
			}
		}
		return "login";
	}
	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@Validated @ModelAttribute("login") LoginForm loginForm, HttpSession session,  BindingResult result,Model model) {
		model.addAttribute("error"," You have successfully logout");
		session.invalidate();
		return "login";
	}
	
	//@ModelAttribute("trainingPartnerCountList")
	public List<TrainingPartner> trainingPartnerList(){
		List<TrainingPartner> trainingPartnerList = null;
		try{
			trainingPartnerList = loginService.trainingPartnerCountList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return trainingPartnerList;
	}
	
}