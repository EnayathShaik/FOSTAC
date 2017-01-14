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
import com.ir.form.ContactFormAssessor;
import com.ir.form.ContactTrainee;
import com.ir.form.RegistrationFormAssessor;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.AssessmentAgency;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadServiceTrainer;
import com.ir.service.RegistrationServiceAssessor;
import com.ir.service.RegistrationServiceTrainer;

@Controller
@SessionAttributes
public class RegistrationControllerAssessor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("registrationServiceAssessor")
	RegistrationServiceAssessor registrationServiceAssessor;
	
	
	@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = registrationServiceAssessor.loadState();
		System.out.println("state list   :   "+ stateList);
		return stateList;
	}
	
	@ModelAttribute("assessmentAgencyNameList")
	public List<ManageAssessmentAgency> assessmentAgencyNameList() {
		List<ManageAssessmentAgency> assessmentAgencyNameList = registrationServiceAssessor.loadAssessmentAgency();
		System.out.println("assessment Agency Name List    :   "+ assessmentAgencyNameList);
		return assessmentAgencyNameList;
	}
	/*@ModelAttribute("districtList")
	public List<District> districtList() {
		List<District> districtList = pageLoadServiceTrainer.loadDistrict();
		System.out.println("district list   :   "+ districtList);
		return districtList;
	}*/
	/*@ModelAttribute("cityList")
	public List<City> populateCityList() {		
		List<City> cityList=new ArrayList<City>();
		return cityList;
	}*/
	@ModelAttribute("titleList")
	public List<Title> populateTitle() {
		List<Title> titleList = registrationServiceAssessor.loadTitle();
		System.out.println("state list   :   "+ titleList);
		return titleList;
	}
	
	@ModelAttribute("basicCourseList" )
	public List<CourseName> basicCourseList() {
		List<CourseName> basicCourseList = registrationServiceAssessor.basicCourseName();
		System.out.println("CourseName  list   :   "+ basicCourseList);
		return basicCourseList;
	}
	
	@RequestMapping(value = "/registrationFormAssessor", method = RequestMethod.GET)
	public String registerForm(Model model) {
		System.out.println("registerForm Assessor begins ");
		RegistrationFormAssessor registrationFormAssessor=new RegistrationFormAssessor();
		model.addAttribute("registrationFormAssessor", registrationFormAssessor);
		return "registrationFormAssessor";
	}
	
	@RequestMapping(value = "/registrationAsssessor", method = RequestMethod.POST)
	public String registerTrainer(@Valid @ModelAttribute("registrationFormAssessor") RegistrationFormAssessor registrationFormAssessor, BindingResult bindingResult,Model model)  {
		
		System.out.println("register controller before bind trainer");
		if(bindingResult.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+bindingResult.hasErrors());
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors());
			return "registrationFormAssessor";
		}
		System.out.println("registrationForm assessor controller");
		System.out.println(registrationFormAssessor);
		String personalInformationAssessor = registrationServiceAssessor.registerPersonalInformationAssessor(registrationFormAssessor);
		if(! personalInformationAssessor.equalsIgnoreCase("")){
			String[] all = personalInformationAssessor.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			//return "registrationFormTrainee";
			return "welcome";
		}else{
			model.addAttribute("id" , "Oops, something went wrong !!!");
			//model.addAttribute("pwd" , "User id created successfully !!");
			return "personalInformationAssessor";
		}
	}
	/*@RequestMapping(value = "/updateAssessor", method = RequestMethod.GET)
	public String updateAssessor(Model model) {
		System.out.println("registerForm trainer begins ");
		RegistrationFormAssessor registrationFormAssessor=new RegistrationFormAssessor();
		model.addAttribute("registrationFormAssessor", registrationFormAssessor);
		return "updateAssessor";
	}*/
	
	 @RequestMapping(value="/updateAssessor" , method=RequestMethod.GET)
		public String updateAssessor(@RequestParam(value = "userId", required = true)  Integer userId ,Model model ,@ModelAttribute("updateAssessor") RegistrationFormAssessor registrationFormAssessor, HttpSession session ){		
		 Integer profileID = 0;
			try{
				profileID = (Integer) session.getAttribute("profileId");
				if(profileID == 1 || profileID == 2 || profileID == 8){
					//Bases On User
				}else{
					userId = (Integer) session.getAttribute("userId");
				}
				
			}catch(Exception e){
				System.out.println("Exception while course details save : "+ e.getMessage());
			}
		 if(userId > 0){
				PersonalInformationAssessor personalInformationAssessor ;
				personalInformationAssessor = registrationServiceAssessor.fullDetailAssessor(userId);
				session.setAttribute("loginUr", personalInformationAssessor);
			 
		 }
		 	model.addAttribute("update", "");
			return "updateAssessor";
		}
	
	
	
	/*
	@RequestMapping(value = "/updateAssessor", method = RequestMethod.GET)
	public String updateAssessorData(Model model) {
		System.out.println("registerForm trainer begins ");
		RegistrationFormAssessor registrationFormAssessor=new RegistrationFormAssessor();
		model.addAttribute("registrationFormAssessor", registrationFormAssessor);
		return "updateAssessor";
	}
	
	*/
	 @RequestMapping(value="/updateAssessorDatavalue" , method=RequestMethod.POST)
	 //@RequestMapping(value="/updateAssessorData" , method=RequestMethod.POST)
		public String updateAssessorData(@RequestParam(value = "id", required = true)  Integer id,@Valid @ModelAttribute("updateAssessor") RegistrationFormAssessor registrationFormAssessor ,BindingResult bindingResult, HttpSession session){
		 Integer assessorId = 0;
			if(id <= 0){
				assessorId = (Integer) session.getAttribute("loginUserAssessor");
			}else{
				assessorId = id;
			}
			String updateAssessor = registrationServiceAssessor.UpdateAssessor(registrationFormAssessor , assessorId);
			if(!updateAssessor.equalsIgnoreCase(""))
			{
				System.out.println("Data are updated successfully");
			}
			//model.addAttribute("update", "Updated successfully !!!");
			return "welcomeupdatetrainee";
		}
		
		@RequestMapping(value="/contactAssessorPage" , method=RequestMethod.GET)
		public String contactAssessor(@ModelAttribute("contactFormAssessor") ContactFormAssessor contactFormAssessor ){
			return "contactAssessorPage";
		}
		
		@RequestMapping(value="/contactAssessorSaveData" , method=RequestMethod.POST)
		public String contactAssessorSaveData(@ModelAttribute("contactFormAssessor") ContactFormAssessor contactFormAssessor
				,BindingResult result , Model model
				){
			if(result.hasErrors()){
				System.out.println(" bindingResult.hasErrors "+result.hasErrors());
				System.out.println(result.getErrorCount());
				System.out.println(result.getAllErrors());
				return "contactAssessorSave";
			}int id = 1;
			//abhay   String id=	(String) session.getAttribute("logId");
			String contactAssessorSave = registrationServiceAssessor.contactAssesorSave(contactFormAssessor , id);
			if(contactAssessorSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
			return "contactAssessorPage";
		}
			@RequestMapping(value="/changePasswordAssessor" , method=RequestMethod.GET)
			public String changePass(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm ){
				return "changePasswordAssessor";
			}
			@RequestMapping(value="/changePasswordAssesorSave" , method=RequestMethod.POST)
			public String changePasswordAssesorSave(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session
					,BindingResult result , Model model
					){
				if(result.hasErrors()){
					System.out.println(" bindingResult.hasErrors "+result.hasErrors());
					System.out.println(result.getErrorCount());
					System.out.println(result.getAllErrors());
					return "changepasswordAS";
				}
				String id =(String) session.getAttribute("logId");
				//System.out.println(changePasswordForm.getLoginid());
				//int id = 1;
				boolean changePasswordAssesorSave = registrationServiceAssessor.changePasswordASSSave(changePasswordForm , id);
				if(changePasswordAssesorSave){
					model.addAttribute("created" , "Your password has changed !!!");
				}else{
					model.addAttribute("created" , "Oops, something went wrong !!!");
				}
				return "changepasswordAS";
			}
			// Rishi
		}
	
