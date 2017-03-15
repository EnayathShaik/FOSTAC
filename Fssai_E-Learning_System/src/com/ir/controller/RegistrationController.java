package com.ir.controller;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ir.form.AadharDetails;
import com.ir.form.RegistrationFormTrainee;
import com.ir.model.KindOfBusiness;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadService;
import com.ir.service.RegistrationServiceTrainee;
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;


@Controller
@SessionAttributes
public class RegistrationController {
	
	@Autowired
	@Qualifier("registrationServiceTrainee")
	RegistrationServiceTrainee registrationServiceTrainee;
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	@RequestMapping(value = "/aadhar-verification", method = RequestMethod.GET)
	public String aadharVerification(Model model) {
		try{
			new ZLogger("aadhar-verification", "aadhar-verification begins ", "RegistrationController.java");
			AadharDetails aadharDetails=new AadharDetails();
			model.addAttribute("aadharDetails", aadharDetails);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("aadhar-verification", e.getMessage(), "RegistrationController.java");
		}
		new ZLogger("aadhar-verification", "aadhar-verification Ends ", "RegistrationController.java");
		return "aadhar-verification";
	}
	@RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
	public String registrationForm(@Valid @ModelAttribute("aadharDetails") AadharDetails aadharDetails,BindingResult result, Model model , HttpSession session) {
		System.out.println("aadhar-verification submit begins ");
		if(result != null && result.hasErrors()){
			new ZLogger("registrationForm", "bindingResult.hasErrors  "+result.hasErrors() , "RegistrationController.java");
			new ZLogger("registrationForm", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "RegistrationController.java");
			return "aadhar-verification";
		}
		session.setAttribute("aadhar", aadharDetails == null ? "" : aadharDetails.getAadharNumber());
		session.setAttribute("name",  aadharDetails == null ? "" : aadharDetails.getName());
		session.setAttribute("dob" ,  aadharDetails == null ? "" : aadharDetails.getDob());
		session.setAttribute("gender" ,  aadharDetails == null ? "" : aadharDetails.getGender());
		return "aadhar-verification";
	}
	@RequestMapping(value = "/registrationFormTrainee", method = RequestMethod.GET)
	public String registerForm(Model model) {
		new ZLogger("registrationFormTrainee", "registerForm begins ", "RegistrationController.java");
		RegistrationFormTrainee registrationFormTrainee=new RegistrationFormTrainee();
		List<State> stateList = pageLoadService.loadState();
		List<Title> titleList = pageLoadService.loadTitle();
		List<String> casteList = pageLoadService.loadCaste();
		List<KindOfBusiness> kindOfBusinessList=pageLoadService.loadKindOfBusiness();
		model.addAttribute("registrationFormTrainee", registrationFormTrainee);
		model.addAttribute("stateList", stateList);
		model.addAttribute("titleList", titleList);
		model.addAttribute("casteList", casteList);
		model.addAttribute("kindOfBusinessList", kindOfBusinessList);
		return "registrationFormTrainee";
	}
	
	
	@RequestMapping(value = "/registerTrainee", method = RequestMethod.POST)
	public String registerTrainee(@Valid @ModelAttribute("registrationFormTrainee") RegistrationFormTrainee registrationFormTrainee, BindingResult bindingResult,Model model)  {

		new ZLogger("registerTrainee", "Entering Registration ...............", "RegistrationController.java");
		if(bindingResult.hasErrors()){
			new ZLogger("registerTrainee", "bindingResult.hasErrors  "+bindingResult.hasErrors() , "RegistrationController.java");
			new ZLogger("registerTrainee", "bindingResult.hasErrors  "+bindingResult.getErrorCount() +" All Errors "+bindingResult.getAllErrors(), "RegistrationController.java");
			return "registrationFormTrainee";
		}
		String personalInformationTrainee = null;
		try{
		 personalInformationTrainee = registrationServiceTrainee.registerPersonalInformationTrainee(registrationFormTrainee);
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("registerTrainee", " Exception while registerTrainee   "+e.getMessage() , "RegistrationController.java");
		}
		
		if(personalInformationTrainee != null && ! personalInformationTrainee.equalsIgnoreCase("")){
			String[] all = personalInformationTrainee.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			new Thread(new Mail("Thanks", registrationFormTrainee.getEmail(), all[1], all[0], registrationFormTrainee.getFirstName())).start();
			return "welcome";
		}else{
			return "registrationFormTrainee";
		}
	}
}