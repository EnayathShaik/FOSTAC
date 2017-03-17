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

import com.ir.form.RegistrationFormAssessor;
import com.ir.model.CourseName;
import com.ir.model.ManageAssessmentAgency;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadService;
import com.ir.service.RegistrationServiceAssessor;
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;

@Controller
@SessionAttributes
public class RegistrationControllerAssessor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	@Autowired
	@Qualifier("registrationServiceAssessor")
	RegistrationServiceAssessor registrationServiceAssessor;
	
	@RequestMapping(value = "/registrationFormAssessor", method = RequestMethod.GET)
	public String registerForm(Model model) {
		new ZLogger("registerForm", "Assessor Registration Form Loading Starting............" , "RegistrationControllerAssessor.java");
		try{
			RegistrationFormAssessor registrationFormAssessor=new RegistrationFormAssessor();
			List<State> stateList = pageLoadService.loadState();
			List<Title> titleList = pageLoadService.loadTitle();
			List<ManageAssessmentAgency> assessmentAgencyNameList = registrationServiceAssessor.loadAssessmentAgency();
			
			
			List<CourseName> basicCourseList = registrationServiceAssessor.basicCourseName();
			model.addAttribute("registrationFormAssessor", registrationFormAssessor);
			model.addAttribute("stateList", stateList);
			model.addAttribute("titleList", titleList);
			model.addAttribute("assessmentAgencyNameList", assessmentAgencyNameList);
			model.addAttribute("basicCourseList", basicCourseList);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("registerForm", "Assessor Registration Form Loading Exception" , "RegistrationControllerAssessor.java");
		}
		new ZLogger("registerForm", "Assessor Registration Form Loading Stopped............" , "RegistrationControllerAssessor.java");
		
		return "registrationFormAssessor";
	}
	
	@RequestMapping(value = "/registrationAsssessor", method = RequestMethod.POST)
	public String registerAssessor(@Valid @ModelAttribute("registrationFormAssessor") RegistrationFormAssessor registrationFormAssessor, BindingResult bindingResult,Model model)  {
		new ZLogger("registerAssessor", "Assessor Registration Form Submitting Starting............" , "RegistrationControllerAssessor.java");
		try{
			if(bindingResult.hasErrors()){
				return "registrationFormAssessor";
			}
			String personalInformationAssessor = null;
			personalInformationAssessor = registrationServiceAssessor.registerPersonalInformationAssessor(registrationFormAssessor);
			if(personalInformationAssessor != null &&  !personalInformationAssessor.equalsIgnoreCase("")){
				String[] all = personalInformationAssessor.split("&");
				model.addAttribute("id" , all[1]);
				model.addAttribute("pwd" , all[0]);
				new Thread(new Mail("Thanks", registrationFormAssessor.getAssessorPermanentEmail(), all[1], all[0], registrationFormAssessor.getFirstName())).start();
				return "welcome";
			}else{
				model.addAttribute("id" , "Oops, something went wrong !!!");
				return "personalInformationAssessor";
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("registerAssessor", "Assessor Registration Form Submitting Exception" , "RegistrationControllerAssessor.java");
		}
		new ZLogger("registerAssessor", "Assessor Registration Form Submitting Stopped............" , "RegistrationControllerAssessor.java");
		return "personalInformationAssessor";
	}

	
	 @RequestMapping(value="/updateAssessor" , method=RequestMethod.GET)
		public String updateAssessor(@RequestParam(value = "userId", required = true)  Integer userId ,Model model ,@ModelAttribute("updateAssessor") RegistrationFormAssessor registrationFormAssessor, HttpSession session ){		
		 new ZLogger("updateAssessor", "Assessor Update Form Load Stopped............" , "RegistrationControllerAssessor.java");
		 Integer profileID = 0;
			try{
				profileID = (Integer) session.getAttribute("profileId");
				if(profileID == 1 || profileID == 2 || profileID == 8){
					//Bases On User
				}else{
					userId = (Integer) session.getAttribute("userId");
				}
				 if(userId > 0){
						PersonalInformationAssessor personalInformationAssessor ;
						personalInformationAssessor = registrationServiceAssessor.fullDetailAssessor(userId);
						session.setAttribute("loginUr", personalInformationAssessor);
					 
				 }
					List<State> stateList = pageLoadService.loadState();
					List<Title> titleList = pageLoadService.loadTitle();
					model.addAttribute("stateList", stateList);
					model.addAttribute("titleList", titleList);
				 model.addAttribute("update", "");
			}catch(Exception e){
				e.printStackTrace();
				new ZLogger("updateAssessor", "Assessor Update Form Exception............" , "RegistrationControllerAssessor.java");
			}
			new ZLogger("updateAssessor", "Assessor Update Form Load Stopped............" , "RegistrationControllerAssessor.java");
			return "updateAssessor";
		}
	
	 	@RequestMapping(value="/updateAssessorDatavalue" , method=RequestMethod.POST)
	 	public String updateAssessorData(@RequestParam(value = "id", required = true)  Integer id,@Valid @ModelAttribute("updateAssessor") RegistrationFormAssessor registrationFormAssessor ,BindingResult bindingResult, HttpSession session){
	 		new ZLogger("updateAssessorData ", "Assessor Update Form Submit Starting............" , "RegistrationControllerAssessor.java");
	 	try{
			 Integer assessorId = 0;
				if(id <= 0){
					assessorId = (Integer) session.getAttribute("loginUserAssessor");
				}else{
					assessorId = id;
				}
				String updateAssessor = registrationServiceAssessor.UpdateAssessor(registrationFormAssessor , assessorId);
				if(!updateAssessor.equalsIgnoreCase(""))
				{
					new ZLogger("Assessor : updateAssessorData ", "Data are updated successfully" , "RegistrationControllerAssessor.java");
				}
		 }catch(Exception e){
			 e.printStackTrace();
			 new ZLogger("updateAssessorData", "Assessor Update Form Submit Exception............" , "RegistrationControllerAssessor.java");
		 }
	 	new ZLogger("updateAssessorData ", "Assessor Update Form Submit Stopped............" , "RegistrationControllerAssessor.java");
	 	
		return "welcomeupdatetrainee";
		}
		
		
}
	
