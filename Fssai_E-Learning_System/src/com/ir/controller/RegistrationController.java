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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ir.form.AadharDetails;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.StateForm;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.District;
import com.ir.model.KindOfBusiness;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadService;
import com.ir.service.RegistrationServiceTrainee;
import com.ir.util.GenerateUniqueID;
import com.ir.util.JavaMail;


@Controller
@SessionAttributes
public class RegistrationController {
	
	@Autowired
	@Qualifier("registrationServiceTrainee")
	RegistrationServiceTrainee registrationServiceTrainee;
	
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	

	/*@RequestMapping(value = "/userIdCheck", method = RequestMethod.GET)
	public String loginForm(
			@Valid @ModelAttribute("registrationFormTrainee") RegistrationFormTrainee registrationFormTrainee, 
			BindingResult bindingResult,Model model)  {
		System.out.println("Reg Controller  begin . : ");

		String  registerTraineeInformationFull =  registrationServiceTrainee.registerTraineeInformationFullIdCheck(registrationFormTrainee);
		System.out.println("return null****** " + registerTraineeInformationFull);
		return "registrationFormTrainee";
	}*/
	
	
	@RequestMapping(value = "/aadhar-verification", method = RequestMethod.GET)
	public String aadharVerification(Model model) {
		System.out.println("aadhar-verification begins ");
		AadharDetails aadharDetails=new AadharDetails();
		model.addAttribute("aadharDetails", aadharDetails);
		return "aadhar-verification";
	}
	@RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
	public String registrationForm(@Valid @ModelAttribute("aadharDetails") AadharDetails aadharDetails,BindingResult result, Model model , HttpSession session) {
		System.out.println("aadhar-verification submit begins ");
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "aadhar-verification";
		}
		session.setAttribute("aadhar", aadharDetails.getAadharNumber());
		session.setAttribute("name", aadharDetails.getName());
		session.setAttribute("dob" , aadharDetails.getDob());
		session.setAttribute("gender" , aadharDetails.getGender());
		return "aadhar-verification";
	}
	@RequestMapping(value = "/registrationFormTrainee", method = RequestMethod.GET)
	public String registerForm(Model model) {
		System.out.println("registerForm begins ");
		RegistrationFormTrainee registrationFormTrainee=new RegistrationFormTrainee();
		model.addAttribute("registrationFormTrainee", registrationFormTrainee);
		//int  state =  stateSaveService.stateSave(statelist);
		return "registrationFormTrainee";
	}
	
	@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = pageLoadService.loadState();
		System.out.println("state list   :   "+ stateList);
		return stateList;
	}
	
	
	@ModelAttribute("titleList")
	public List<Title> populateTitle() {
		List<Title> titleList = pageLoadService.loadTitle();
		System.out.println("state list   :   "+ titleList);
		return titleList;
	}
	
	
	@ModelAttribute("casteList")
	public List<String> populateCaste() {
		List<String> casteList = pageLoadService.loadCaste();
		System.out.println("casteList    :   "+ casteList);
		return casteList;
	}
	
	@ModelAttribute("userId")
	public String getUniqueId(){
		String uniqueID = GenerateUniqueID.getNextCombinationId("TE", "personalinformationtrainee" , "000000");		
		System.out.println(" Trainee ID " + uniqueID);
		return uniqueID;
	}
	
	
	@ModelAttribute("kindOfBusinessList")
	public List<KindOfBusiness> populateKindOfBusiness() {
		
		List<KindOfBusiness> kindOfBusinessList=pageLoadService.loadKindOfBusiness();
		return kindOfBusinessList;
	}
	
	@RequestMapping(value = "/registerTrainee", method = RequestMethod.POST)
	public String registerTrainee(@Valid @ModelAttribute("registrationFormTrainee") RegistrationFormTrainee registrationFormTrainee, BindingResult bindingResult,Model model)  {
		System.out.println("Entering Registration ...............");
		System.out.println("register controller before bind");
		if(bindingResult.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+bindingResult.hasErrors());
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors());
			return "registrationFormTrainee";
		}
		System.out.println("registrationFormTrainee controller");
		System.out.println(registrationFormTrainee);
		//RegisterTraineeInformationFull registerTraineeInformationFull = registrationServiceTrainee.registerTraineeInformationFull(registrationFormTrainee);
		String personalInformationTrainee = registrationServiceTrainee.registerPersonalInformationTrainee(registrationFormTrainee);
		System.out.println("array");
		if(! personalInformationTrainee.equalsIgnoreCase("")){
			String[] all = personalInformationTrainee.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			JavaMail javaMail = new JavaMail();
			javaMail.mailProperty("Thanks", registrationFormTrainee.getEmail(), all[1], all[0]);
			//return "registrationFormTrainee";
			return "welcome";
		}else{
			return "registrationFormTrainee";
		}
	}
}