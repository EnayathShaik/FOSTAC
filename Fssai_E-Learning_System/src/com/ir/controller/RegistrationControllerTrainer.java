package com.ir.controller;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.google.gson.Gson;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.CourseEnrolledUser;
import com.ir.model.CourseName;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PostVacancyTrainingCenter;
import com.ir.model.PostVacancyTrainingCenterBean;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.service.PageLoadService;
import com.ir.service.PageLoadServiceTrainer;
import com.ir.service.RegistrationServiceTrainer;
import com.ir.service.RegistrationServiceTrainingPartner;
import com.ir.service.TraineeService;
import com.ir.service.TrainingPartnerService;
import com.ir.util.GenerateUniqueID;
import com.ir.util.JavaMail;
import com.ir.util.Profiles;

@Controller
public class RegistrationControllerTrainer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
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
	
	@Autowired
	@Qualifier("trainingPartnerService")
	TrainingPartnerService trainingPartnerService; 
	
	
	/*@ModelAttribute("trainingPartnerNameList" )
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
	
	@ModelAttribute("casteList")
	public List<String> populateCaste() {
		List<String> casteList = pageLoadServiceTrainer.loadCaste();
		System.out.println("casteList    :   "+ casteList);
		return casteList;
	}
	
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
	
	@ModelAttribute("userId")
	public String getUniqueId(){
		String uniqueID = GenerateUniqueID.getNextCombinationId("TR", "personalinformationtrainer" , "000000");		
		System.out.println(" Trainer ID " + uniqueID);
		return uniqueID;
	}*/
	
	@RequestMapping(value = "/registrationFormTrainer", method = RequestMethod.GET)
	public String registerForm(Model model) {
		System.out.println("registerForm trainer begins ");
		RegistrationFormTrainer registrationFormTrainer=new RegistrationFormTrainer();
		List<State> stateList = pageLoadService.loadState();
		List<Title> titleList = pageLoadService.loadTitle();
		List<String> casteList = pageLoadService.loadCaste();
		List<ManageTrainingPartner> trainingPartnerNameList= registrationServiceTrainingPartner.trainingPartnerNameList();
		String uniqueID = GenerateUniqueID.getNextCombinationId("TR", "personalinformationtrainer" , "000000");
		List<CourseName> basicCourseList = pageLoadServiceTrainer.basicCourseName();
		
		
		model.addAttribute("registrationFormTrainer", registrationFormTrainer);
		model.addAttribute("stateList", stateList);
		model.addAttribute("titleList", titleList);
		model.addAttribute("casteList", casteList);
		model.addAttribute("trainingPartnerNameList", trainingPartnerNameList);
		model.addAttribute("userId", uniqueID);
		model.addAttribute("basicCourseList", basicCourseList);
		
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
			JavaMail javaMail = new JavaMail();
			javaMail.mailProperty("Thanks", registrationFormTrainer.getTrainingCenterPermanentEmail(), all[1],all[0] ,registrationFormTrainer.getFirstName() );
			//return "registrationFormTrainee";
			return "welcome";
		}else{
			model.addAttribute("id" , "Oops, something went wrong !!!");
			//model.addAttribute("pwd" , "User id created successfully !!");
			return "personalInformationTrainer";
		}
	}
	
	@RequestMapping(value="/search-and-apply" , method=RequestMethod.GET)
	public String searchandapply(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer, Model model,HttpSession session )
	{
		
		Integer userId = (Integer) session.getAttribute("userId");
		Integer profileId = (Integer) session.getAttribute("profileId");
		List<PostVacancyTrainingCenter> postVacancyTrainingCenter=trainingPartnerService.getPostVacancyTrainingList(userId);
		List<PostVacancyTrainingCenterBean> vacancyTrainingCenterBeans=new ArrayList<>();
		PostVacancyTrainingCenterBean applicationStatusBean = null ;
		for(PostVacancyTrainingCenter pvtc:postVacancyTrainingCenter){
			try{
				 applicationStatusBean=trainingPartnerService.getApplicationStatusBean(String.valueOf(userId),pvtc.getCourseName().getCoursenameid(),pvtc.getCourseType().getCourseTypeId());	
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			if(applicationStatusBean.getStatus()!=null){
				applicationStatusBean.setCoursetypeName(pvtc.getCourseType().getCourseType());
				applicationStatusBean.setStrCourseName(pvtc.getCourseName().getCoursename());
				applicationStatusBean.setTrainingDate(pvtc.getTrainingDate());
				applicationStatusBean.setPersonalInformationTrainingPartner(pvtc.getTrainingCenter());
				applicationStatusBean.setPostvacancyID(pvtc.getId());
				vacancyTrainingCenterBeans.add(applicationStatusBean);
			}
		}
		
		
		model.addAttribute("postVacancyTrainingCenter", new Gson().toJson(postVacancyTrainingCenter));
		model.addAttribute("vacancyTrainingCenterBeans", new Gson().toJson(vacancyTrainingCenterBeans));
		
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
		long basicEnroll = 0;
		try{
			basicEnroll = registrationServiceTrainer.basicTrainerSave(courseEnrolledUserForm , loginId );	
		}catch(Exception e){
			e.printStackTrace();
		}
		 
		if(basicEnroll  > 1){
			model.addAttribute("created", "You have successfully enrolled !!!");
			model.addAttribute("roll", basicEnroll);
		}else{
			model.addAttribute("created", "Oops , something went wrong !!!");
			model.addAttribute("roll", basicEnroll);
		}
		return "trainerHomepage";
	}
   
     

    @RequestMapping(value="/update-profile" , method=RequestMethod.GET)
   	public String updateInformation(@RequestParam(value = "userId", required = true)  Integer userId ,Model model ,@ModelAttribute("updateInformation") RegistrationFormTrainer registrationFormTrainer, HttpSession session ){		
	Integer profileID = 0;
	try{
		profileID = (Integer) session.getAttribute("profileId");
		if(profileID == 1 || profileID == 2){
			//Bases On User
		}else{
			userId = (Integer) session.getAttribute("userId");
		}
		
	 }catch(Exception e){
		System.out.println("Exception while course details save : "+ e.getMessage());
	 }
	 if(userId > 0){
		 PersonalInformationTrainer personalInformationTrainer = registrationServiceTrainer.FullDetailTrainer(userId);
		model.addAttribute("trainingPartnerID", personalInformationTrainer.getAssociatedTrainingpartnerName().getManageTrainingPartnerId());
		 session.setAttribute("loginUr", personalInformationTrainer);
		 
	 }
	
   		model.addAttribute("update", "");
   		return "update-profile";
   	}
    
    @RequestMapping(value="/updateTrainer11" , method=RequestMethod.POST)
	public String updateTrainer(@RequestParam(value = "id", required = true)  Integer id,@Valid @ModelAttribute("updateInformation") RegistrationFormTrainer registrationFormTrainer ,BindingResult bindingResult, HttpSession session){
		if(session == null){
			return "login";
		}
		Integer ss = 0;
		if(id <= 0){
			 ss = (Integer)session.getAttribute("loginUser2");
		}else{
			ss = id;
		}

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
    
}