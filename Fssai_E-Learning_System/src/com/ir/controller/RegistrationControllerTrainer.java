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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadServiceTrainer;
import com.ir.service.RegistrationServiceTrainer;
import com.ir.service.RegistrationServiceTrainingPartner;
import com.ir.service.TraineeService;
import com.ir.util.Profiles;

@Controller
public class RegistrationControllerTrainer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	@Qualifier("pageLoadServiceTrainer")
	PageLoadServiceTrainer pageLoadServiceTrainer;
	
	@Autowired
	@Qualifier("registrationServiceTrainer")
	RegistrationServiceTrainer registrationServiceTrainer;
	
	@Autowired
	@Qualifier("registrationServiceTrainingPartner")
	RegistrationServiceTrainingPartner registrationServiceTrainingPartner;
	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	
	@ModelAttribute("trainingPartnerNameList" )
	public List<ManageTrainingPartner> trainingPartnerNameList() {
		List<ManageTrainingPartner> trainingPartnerNameList = registrationServiceTrainingPartner.trainingPartnerNameList();
		return trainingPartnerNameList;
	}
	@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = pageLoadServiceTrainer.loadState();
		System.out.println("state list   :   "+ stateList);
		return stateList;
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
		List<Title> titleList = pageLoadServiceTrainer.loadTitle();
		System.out.println("state list   :   "+ titleList);
		return titleList;
	}
	
	@ModelAttribute("basicCourseList" )
	public List<CourseName> basicCourseList() {
		List<CourseName> basicCourseList = pageLoadServiceTrainer.basicCourseName();
		System.out.println("CourseName  list   :   "+ basicCourseList);
		return basicCourseList;
	}
	
	@RequestMapping(value = "/registrationFormTrainer", method = RequestMethod.GET)
	public String registerForm(Model model) {
		System.out.println("registerForm trainer begins ");
		RegistrationFormTrainer registrationFormTrainer=new RegistrationFormTrainer();
		model.addAttribute("registrationFormTrainer", registrationFormTrainer);
		return "registrationFormTrainer";
	}
	
	@RequestMapping(value = "/registrationTrainer", method = RequestMethod.POST)
	public String registerTrainer(@Valid @ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer, BindingResult bindingResult,Model model)  {
		
		System.out.println("register controller before bind trainer");
		if(bindingResult.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+bindingResult.hasErrors());
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors());
			return "registrationFormTrainer";
		}
		System.out.println("registrationFormTrainer controller");
		System.out.println(registrationFormTrainer);
		//RegisterTraineeInformationFull registerTraineeInformationFull = registrationServiceTrainee.registerTraineeInformationFull(registrationFormTrainee);
		String personalInformationTrainer = registrationServiceTrainer.registerPersonalInformationTrainer(registrationFormTrainer);
		if(! personalInformationTrainer.equalsIgnoreCase("")){
			String[] all = personalInformationTrainer.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			//return "registrationFormTrainee";
			return "welcome";
		}else{
			model.addAttribute("id" , "Oops, something went wrong !!!");
			//model.addAttribute("pwd" , "User id created successfully !!");
			return "personalInformationTrainer";
		}
	}
	
	@RequestMapping(value="/search-and-apply" , method=RequestMethod.GET)
	public String searchandapply(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "search-and-apply";
	}
	
	
	@RequestMapping(value="/index" , method=RequestMethod.GET)
	public String trainerHomepage(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "trainerHomepage";
	}
	//by Rishi
    @RequestMapping(value="/basicTrainer" , method=RequestMethod.GET)
    public String basicTrainer(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm )
    {
	return "basicTrainer";
	}
    
    @RequestMapping(value="/basicCourseSaveTrainer" , method=RequestMethod.POST)
	public String basicSaveTrainer(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm,
			BindingResult result ,HttpSession session, Model model){
		
    	System.out.println("wefsjdjksbjbsdjbjsdjfsdjkfbjksdbfjbsdjfbjsdbfjsdbfjsdjfjbsd");
    	
		int loginId=(int) session.getAttribute("loginIdUnique");
		System.out.println("loginid   :"+ loginId);
		long basicEnroll = registrationServiceTrainer.basicTrainerSave(courseEnrolledUserForm , loginId );
		if(basicEnroll  > 1){
			model.addAttribute("created", "You have successfully enrolled !!!");
			model.addAttribute("roll", basicEnroll);
		}else{
			model.addAttribute("created", "Oops , something went wrong !!!");
			model.addAttribute("roll", basicEnroll);
		}
		return "trainerHomepage";
	}
   
    
    @RequestMapping(value="/advanceTrainer" , method=RequestMethod.GET)
    public String advance(@ModelAttribute("courseEnrolledUser") CourseEnrolledUserForm courseEnrolledUser )
    {
	return "advanceTrainer";
	}
    
    @RequestMapping(value="/advanceTrainerSave" , method=RequestMethod.POST)
	public String advanceTrainerSave(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result ,HttpSession session, Model model){
		
    	int loginId=(int) session.getAttribute("loginIdUnique");
		System.out.println("loginid   :"+ loginId);
		long basicEnroll = registrationServiceTrainer.advanceTrainerSave(courseEnrolledUserForm , loginId);
		if(basicEnroll  > 1){
			model.addAttribute("created", "You have successfully enrolled !!!");
			model.addAttribute("roll", basicEnroll);
		}else{
			model.addAttribute("created", "Oops , something went wrong !!!");
			model.addAttribute("roll", basicEnroll);
		}
		return "trainerHomepage";
	}
    
    @RequestMapping(value="/specialTrainer" , method=RequestMethod.GET)
    public String special(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm )
    {
	return "specialTrainer";
	}
    
    @RequestMapping(value="/specialTrainerSave" , method=RequestMethod.POST)
   	public String specialTrainerSave(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm,
   			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result ,HttpSession session, Model model){
   		
       	System.out.println("wefsjdjksbjbsdjbjsdjfsdjkfbjksdbfjbsdjfbjsdbfjsdbfjsdjfjbsd");
       	
       	int loginId=(int) session.getAttribute("loginIdUnique");
   		System.out.println("loginid   :"+ loginId);
   		long basicEnroll = registrationServiceTrainer.specialTrainerSave(courseEnrolledUserForm , loginId );
   		if(basicEnroll  > 1){
   			model.addAttribute("created", "You have successfully enrolled !!!");
   			model.addAttribute("roll", basicEnroll);
   		}else{
   			model.addAttribute("created", "Oops , something went wrong !!!");
   			model.addAttribute("roll", basicEnroll);
   		}
   		return "trainerHomepage";
   	}
    
     
    
    //by Rishi end
    

@RequestMapping(value="/update-profile" , method=RequestMethod.GET)
   	public String updateInformation(Model model ,@ModelAttribute("updateInformation") RegistrationFormTrainer registrationFormTrainer, HttpSession session ){		
	Integer userId = (Integer) session.getAttribute("userId");
	 if(userId > 0){
		 PersonalInformationTrainer personalInformationTrainer = registrationServiceTrainer.FullDetailTrainer(userId);
			session.setAttribute("loginUr", personalInformationTrainer);
	 }
	
   		model.addAttribute("update", "");
   		return "update-profile";
   	}
    
    @RequestMapping(value="/updateTrainer11" , method=RequestMethod.POST)
	public String updateTrainer(@Valid @ModelAttribute("updateInformation") RegistrationFormTrainer registrationFormTrainer ,BindingResult bindingResult, HttpSession session){
		if(session == null){
			return "login";
		}
    	
    	Integer ss = (Integer)session.getAttribute("loginUser2");
	//	Integer ss=	(Integer) session.getAttribute("Id");
		System.out.println("nnb is  " +ss);
		System.out.println("----------"+registrationFormTrainer.getFatherName());
		String updateTrainer = registrationServiceTrainer.UpdateTrainer(registrationFormTrainer , ss);
		if(!updateTrainer.equalsIgnoreCase(""))
		{
			System.out.println("Data are updated successfully");
		}
		//model.addAttribute("update", "Updated successfully !!!");
		return "welcomeupdatetrainee";
	}
    @RequestMapping(value="/generatecertificatetrainer" , method=RequestMethod.GET)
	public String generatecertificate(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "generatecertificatetrainer";
	}
    @RequestMapping(value="/certificatetrainer" , method=RequestMethod.GET)
    public String certificate(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
    {
	return "certificatetrainer";
	}
    @RequestMapping(value="/generateadmitcardtrainer" , method=RequestMethod.GET)
	public String generateadmitcard(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer,BindingResult bindingResult, HttpSession session , Model model )
	{
    	CourseName courseName=traineeService.getCourseName(Profiles.TRAINER.value());
		model.addAttribute("courseName", courseName);
		return "generateAdmitCardTrainer";
	}
}