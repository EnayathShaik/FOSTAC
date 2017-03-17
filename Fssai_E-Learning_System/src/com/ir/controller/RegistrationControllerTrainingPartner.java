package com.ir.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.PostVacancyTrainingCenterForm;
import com.ir.form.RegistrationFormTrainingPartner;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.service.RegistrationServiceTrainingPartner;
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;

@Controller
@SessionAttributes
public class RegistrationControllerTrainingPartner implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Autowired
	@Qualifier("registrationServiceTrainingPartner")
	RegistrationServiceTrainingPartner registrationServiceTrainingPartner;
	
	
	/*@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = registrationServiceTrainingPartner.loadState();
		 new ZLogger("stateList", "state list   :   "+ stateList, "RegistrationControllerTrainingPartner.java");
		return stateList;
	}
	@ModelAttribute("trainingCenterList")
	public List<ManageTrainingPartner> trainingCenterList() {
		List<ManageTrainingPartner> trainingCenterList = registrationServiceTrainingPartner.trainingCenterList();
		new ZLogger("trainingCenterList", "training Center List    :   "+ trainingCenterList, "RegistrationControllerTrainingPartner.java");
		if(trainingCenterList != null &&  trainingCenterList.size() > 0){
			return trainingCenterList;
		}else{
			return trainingCenterList;
		}

	}
	
	@ModelAttribute("titleList")
	public List<Title> populateTitle() {
		List<Title> titleList = registrationServiceTrainingPartner.loadTitle();
		new ZLogger("titleList", "titleList list   :   "+ titleList, "RegistrationControllerTrainingPartner.java");
		return titleList;
	}
	
	@ModelAttribute("courseNameList")
	public List<CourseName> courseNameList(){
		List<CourseName> courseNameList = registrationServiceTrainingPartner.courseNameList();
		return courseNameList;
	}
	
	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList(){
		List<CourseType> courseTypeList = registrationServiceTrainingPartner.courseTypeList();
		return courseTypeList;
	}
	
	@ModelAttribute("basicCourseList" )
	public List<CourseName> basicCourseList() {
		List<CourseName> basicCourseList = registrationServiceTrainingPartner.basicCourseName();
		new ZLogger("basicCourseList", "basicCourseList  list   :   "+ basicCourseList, "RegistrationControllerTrainingPartner.java");
		return basicCourseList;
	}
	
	@ModelAttribute("trainingPartnerNameList" )
	public List<ManageTrainingPartner> trainingPartnerNameList() {
		List<ManageTrainingPartner> trainingPartnerNameList = registrationServiceTrainingPartner.trainingPartnerNameList();
		return trainingPartnerNameList;
	}*/
	
	@RequestMapping(value = "/registrationFormTrainingPartner", method = RequestMethod.GET)
	public String registerForm(Model model) {
		new ZLogger("registrationFormTrainingPartner", "registerForm training partner begins ", "RegistrationControllerTrainingPartner.java");
		RegistrationFormTrainingPartner registrationFormTrainingPartner=new RegistrationFormTrainingPartner();
		List<State> stateList = registrationServiceTrainingPartner.loadState();
		model.addAttribute("stateList", stateList);
		model.addAttribute("registrationFormTrainingPartner", registrationFormTrainingPartner);
		return "registerTrainingCenter";
	}

	
	@RequestMapping(value = "/contactTC", method = RequestMethod.GET)
	public String contactTC(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee) {
		return "contactTC";
	}
	@RequestMapping(value = "/registrationTrainingPartner", method = RequestMethod.POST)
	public String registerTrainingCenter(@Valid @ModelAttribute("registrationFormTrainingPartner") RegistrationFormTrainingPartner registrationFormTrainingPartner, BindingResult bindingResult,Model model)  {
		
		System.out.println("register controller before bind trainer");
		if(bindingResult.hasErrors()){
			new ZLogger("registrationTrainingPartner", "bindingResult.hasErrors  "+bindingResult.hasErrors() , "RegistrationControllerTrainingPartner.java");
			new ZLogger("registrationTrainingPartner", "bindingResult.hasErrors  "+bindingResult.getErrorCount() +" All Errors "+bindingResult.getAllErrors(), "RegistrationControllerTrainingPartner.java");
			return "registrationFormTrainingPartner";
		}
		String personalInformationTrainingPartner = null;
		try{
			personalInformationTrainingPartner = registrationServiceTrainingPartner.registerPersonalInformationTrainingPartner(registrationFormTrainingPartner);	
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("registrationTrainingPartner", "Exception while registrationTrainingPartner  "+e.getMessage(), "RegistrationControllerTrainingPartner.java");
		}
		 
		if(personalInformationTrainingPartner != null && !personalInformationTrainingPartner.equalsIgnoreCase("")){
			String[] all = personalInformationTrainingPartner.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			new Thread(new Mail("Thanks", registrationFormTrainingPartner.getTrainingPartnerPermanentEmail(), all[1], all[0], registrationFormTrainingPartner.getFirstName())).start();
			return "welcomeTrainingCenter";
		}else{
			model.addAttribute("created" , "Oops , Something went wrong !!!");
			return "registrationFormTrainingPartner";
		}
	}
	
	@RequestMapping(value="/updateTrainingpartner" , method=RequestMethod.POST)
	public String updateTrainer(@RequestParam(value = "id", required = true)  Integer id,@Valid @ModelAttribute("updateInformation") RegistrationFormTrainingPartner registrationFormTrainingPartner ,BindingResult bindingResult, HttpSession session){
		
		if(session == null){
			return "login";
		}
		Integer ss = 0;
		if(id <= 0){
			 ss = (Integer)session.getAttribute("loginUser2");
		}else{
			ss = id;
		}

		String updateTrainer = registrationServiceTrainingPartner.UpdateTrainingPartner(registrationFormTrainingPartner , ss);
		if(!updateTrainer.equalsIgnoreCase(""))
		{
			new ZLogger("update-profile", "Data are updated successfully", "RegistrationControllerTrainingPartner.java");
		}
		
		
		//return "welcomeupdatetrainingCenter";
		return "welcomeupdatetrainee";
	}

	  @RequestMapping(value="/update-personal-information" , method=RequestMethod.GET)
		public String updateInformation(@RequestParam(value = "userId", required = true)  Integer userId ,Model model ,@ModelAttribute("updateInformation") RegistrationFormTrainingPartner registrationFormTrainingPartner, HttpSession session ){		
		  Integer profileID = 0;
			try{
				profileID = (Integer) session.getAttribute("profileId");
				if(profileID == 1 || profileID == 2 || profileID == 7){
					//Bases On User
				}else{
					userId = (Integer) session.getAttribute("userId");
				}
				
				List<State> stateList = registrationServiceTrainingPartner.loadState();
				model.addAttribute("stateList", stateList);
				
			}catch(Exception e){
				new ZLogger("update-personal-information", "Exception while update-personal-information  "+e.getMessage(), "RegistrationControllerTrainingPartner.java");
			}
			
		  
		  if(userId > 0){
				  PersonalInformationTrainingPartner personalInformationTrainingPartner = null ;
				  try{
					  personalInformationTrainingPartner = registrationServiceTrainingPartner.FullDetailtrainingpartner(userId);  
				  }catch(Exception e){
					  e.printStackTrace();
					  new ZLogger("update-personal-information", "Exception while update-personal-information  "+e.getMessage(), "RegistrationControllerTrainingPartner.java");
				  }
					
					session.setAttribute("loginUr", personalInformationTrainingPartner);
			
			 }
				model.addAttribute("update", "");
			return "update-personal-information";
		}

	  @RequestMapping(value="/contactTPSave" , method=RequestMethod.POST)
		public String contactTrainee1(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee,HttpSession session
				,BindingResult result , Model model
				){
			if(result.hasErrors()){
				new ZLogger("contactTPSave", "bindingResult.hasErrors  "+result.hasErrors() , "RegistrationControllerTrainingPartner.java");
				new ZLogger("contactTPSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "RegistrationControllerTrainingPartner.java");
				return "contactTrainee";
			}//int id = 1;
			String id=(String) session.getAttribute("logId");
			String contactTraineeSave = null;
			try{
				contactTraineeSave = registrationServiceTrainingPartner.contactTraineeSave(contactTrainee , id);	
			}catch(Exception e){
				e.printStackTrace();
				new ZLogger("contactTPSave", "Exception while contactTPSave  "+e.getMessage() , "RegistrationControllerTrainingPartner.java");
			}
			
			if(contactTraineeSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			return "contactTP";
		}
	  
	  @RequestMapping(value="/post-vacancy" , method=RequestMethod.GET)
	  public String postVacancy(@ModelAttribute("postVacancy") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm , Model model){		
		  model.addAttribute("created", "");
		  return "postVacancyTC";	
	 }
	  
	  @RequestMapping(value="/postVacancyTrainingCenterSave" , method=RequestMethod.POST)
	  public String postVacancySave(@ModelAttribute("postVacancy") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm , Model model){
		  String postVacancy = null;
		  
		  try{
			  postVacancy = registrationServiceTrainingPartner.postVacancyTrainingCenter(postVacancyTrainingCenterForm);  
		  }catch(Exception e){
			  e.printStackTrace();
			  new ZLogger("postVacancyTrainingCenterSave", "Exception while  "+e.getMessage() , "RegistrationControllerTrainingPartner.java");
		  }
		   
		  if(postVacancy.equalsIgnoreCase("created")){
			  model.addAttribute("created", "Vacancy created successfull !!!");
		  }else{
			  model.addAttribute("created", "vacancy already created !!!");
		  }
		  return "postVacancyTC";	
	 }
	  @RequestMapping(value="/changePasswordTCentre" , method=RequestMethod.GET)
		public String contactTrainee(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm ){
			return "changePasswordTCentre";
		}
		@RequestMapping(value="/changePasswordTCSave" , method=RequestMethod.POST)
		public String changePasswordTraineeSave(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session
				,BindingResult result , Model model
				){
			if(result.hasErrors()){
				new ZLogger("changePasswordTCentre", "bindingResult.hasErrors  "+result.hasErrors() , "RegistrationControllerTrainingPartner.java");
				new ZLogger("changePasswordTCentre", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "RegistrationControllerTrainingPartner.java");
				return "changePasswordTCentre";
			}
			String id =(String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = false ;
			try{
			 changePasswordTraineeSave = registrationServiceTrainingPartner.changePasswordTraineeSave(changePasswordForm , id);
			}catch(Exception e){
				e.printStackTrace();
			}
			if(changePasswordTraineeSave){
				model.addAttribute("created" , "Your password has been changed !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			return "changePasswordTCentre";
		}


		// Rishi end
	 
}