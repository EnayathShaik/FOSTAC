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
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.RegistrationServiceTrainingPartner;
import com.ir.util.JavaMail;

@Controller
@SessionAttributes
public class RegistrationControllerTrainingPartner implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Autowired
	@Qualifier("registrationServiceTrainingPartner")
	RegistrationServiceTrainingPartner registrationServiceTrainingPartner;
	
	
	@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = registrationServiceTrainingPartner.loadState();
		System.out.println("state list   :   "+ stateList);
		return stateList;
	}
	@ModelAttribute("trainingCenterList")
	public List<ManageTrainingPartner> trainingCenterList() {
		List<ManageTrainingPartner> trainingCenterList = registrationServiceTrainingPartner.trainingCenterList();
		System.out.println("training Center List    :   "+ trainingCenterList);
		if(trainingCenterList != null &&  trainingCenterList.size() > 0){
			return trainingCenterList;
		}else{
			return trainingCenterList;
		}

	}
	
	@ModelAttribute("titleList")
	public List<Title> populateTitle() {
		List<Title> titleList = registrationServiceTrainingPartner.loadTitle();
		System.out.println("state list   :   "+ titleList);
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
		System.out.println("CourseName  list   :   "+ basicCourseList);
		return basicCourseList;
	}
	
	@ModelAttribute("trainingPartnerNameList" )
	public List<ManageTrainingPartner> trainingPartnerNameList() {
		List<ManageTrainingPartner> trainingPartnerNameList = registrationServiceTrainingPartner.trainingPartnerNameList();
		return trainingPartnerNameList;
	}
	
	@RequestMapping(value = "/registrationFormTrainingPartner", method = RequestMethod.GET)
	public String registerForm(Model model) {
		System.out.println("registerForm training partner begins ");
		RegistrationFormTrainingPartner registrationFormTrainingPartner=new RegistrationFormTrainingPartner();
		model.addAttribute("registrationFormTrainingPartner", registrationFormTrainingPartner);
		return "registrationFormTrainingPartner";
	}
	
	/*@RequestMapping(value = "/contactTP", method = RequestMethod.GET)
	public String contactTC(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee) {
		return "contactTP";
	}*/
	
	@RequestMapping(value = "/contactTC", method = RequestMethod.GET)
	public String contactTC(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee) {
		return "contactTC";
	}
	@RequestMapping(value = "/registrationTrainingPartner", method = RequestMethod.POST)
	public String registerTrainer(@Valid @ModelAttribute("registrationFormTrainingPartner") RegistrationFormTrainingPartner registrationFormTrainingPartner, BindingResult bindingResult,Model model)  {
		
		System.out.println("register controller before bind trainer");
		if(bindingResult.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+bindingResult.hasErrors());
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors());
			return "registrationFormTrainingPartner";
		}
		String personalInformationTrainingPartner = registrationServiceTrainingPartner.registerPersonalInformationTrainingPartner(registrationFormTrainingPartner);
		if(!personalInformationTrainingPartner.equalsIgnoreCase("")){
			String[] all = personalInformationTrainingPartner.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
				JavaMail javaMail = new JavaMail();
				javaMail.mailProperty("Thanks", registrationFormTrainingPartner.getTrainingPartnerPermanentEmail(), registrationFormTrainingPartner.getUserId(),all[0]);
				
			return "welcome";
		}else{
			model.addAttribute("created" , "Oops , Something went wrong !!!");
			return "registrationFormTrainingPartner";
		}
	}
	
	@RequestMapping(value="/updateTrainingpartner" , method=RequestMethod.POST)
	public String updateTrainer(@RequestParam(value = "id", required = true)  Integer id,@Valid @ModelAttribute("updateInformation") RegistrationFormTrainingPartner registrationFormTrainingPartner ,BindingResult bindingResult, HttpSession session){
		Integer ss = 0;
		if(id <= 0){
			 ss = (Integer)session.getAttribute("loginUsertrainingpartner");
		}else{
			ss = id;
		}
		
		
		System.out.println("nnb is ****** " +ss);
		String updateTrainingPartner = registrationServiceTrainingPartner.UpdateTrainingPartner(registrationFormTrainingPartner , ss);
		
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
				
			}catch(Exception e){
				System.out.println("Exception while course details save : "+ e.getMessage());
			}
			 
			System.out.println("*******************"+userId+"*******************");
		  
		  if(userId > 0){
				  PersonalInformationTrainingPartner personalInformationTrainingPartner ;
					personalInformationTrainingPartner = registrationServiceTrainingPartner.FullDetailtrainingpartner(userId);
					session.setAttribute("loginUr", personalInformationTrainingPartner);
			
			 }
				model.addAttribute("update", "");
			return "update-personal-information";
		}
		/*@RequestMapping(value="/contactTPSave" , method=RequestMethod.POST)
		public String contactTrainee1(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee
				,BindingResult result , Model model
				){
			if(result.hasErrors()){
				System.out.println(" bindingResult.hasErrors "+result.hasErrors());
				System.out.println(result.getErrorCount());
				System.out.println(result.getAllErrors());
				return "contactTrainee";
			}int id = 1;
			String contactTraineeSave = registrationServiceTrainingPartner.contactTraineeSave(contactTrainee , id);
			if(contactTraineeSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			return "contactTC";
		}*/
	  @RequestMapping(value="/contactTPSave" , method=RequestMethod.POST)
		public String contactTrainee1(@ModelAttribute("contactTrainee") ContactTrainee contactTrainee,HttpSession session
				,BindingResult result , Model model
				){
			if(result.hasErrors()){
				System.out.println(" bindingResult.hasErrors "+result.hasErrors());
				System.out.println(result.getErrorCount());
				System.out.println(result.getAllErrors());
				return "contactTrainee";
			}//int id = 1;
			String id=(String) session.getAttribute("logId");
			String contactTraineeSave = registrationServiceTrainingPartner.contactTraineeSave(contactTrainee , id);
			if(contactTraineeSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			return "contactTP";
		}
	  
	  @RequestMapping(value="/post-vacancy" , method=RequestMethod.GET)
	  public String postVacancy(@ModelAttribute("postVacancy") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm , Model model){		
		  System.out.println("llllllllll");
		  model.addAttribute("created", "");
		  return "postVacancyTC";	
	 }
	  
	  @RequestMapping(value="/postVacancyTrainingCenterSave" , method=RequestMethod.POST)
	  public String postVacancySave(@ModelAttribute("postVacancy") PostVacancyTrainingCenterForm postVacancyTrainingCenterForm , Model model){		
		  String postVacancy = registrationServiceTrainingPartner.postVacancyTrainingCenter(postVacancyTrainingCenterForm);
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
				System.out.println(" bindingResult.hasErrors "+result.hasErrors());
				System.out.println(result.getErrorCount());
				System.out.println(result.getAllErrors());
				return "changePasswordTCentre";
			}
			String id =(String) session.getAttribute("logId");
			//System.out.println(changePasswordForm.getLoginid());
			//int id = 1;
			boolean changePasswordTraineeSave = registrationServiceTrainingPartner.changePasswordTraineeSave(changePasswordForm , id);
			if(changePasswordTraineeSave){
				model.addAttribute("created" , "Your password has been changed !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			return "changePasswordTCentre";
		}


		// Rishi end
	 
}