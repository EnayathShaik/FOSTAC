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

import com.google.gson.Gson;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.CourseName;
import com.ir.model.ManageTrainingPartner;
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
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;

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
	
	
	@RequestMapping(value = "/registrationFormTrainer", method = RequestMethod.GET)
	public String registerForm(Model model) {
		new ZLogger("registrationFormTrainer","registerForm trainer begins " , "RegistrationControllerTrainer.java");
		RegistrationFormTrainer registrationFormTrainer=new RegistrationFormTrainer();
		List<State> stateList = pageLoadService.loadState();
		List<Title> titleList = pageLoadService.loadTitle();
		List<String> casteList = pageLoadService.loadCaste();
		List<ManageTrainingPartner> trainingPartnerNameList= registrationServiceTrainingPartner.trainingPartnerNameList();
		//String uniqueID = GenerateUniqueID.getNextCombinationId("TR", "personalinformationtrainer" , "000000");
		List<CourseName> basicCourseList = pageLoadServiceTrainer.basicCourseName();
		
		
		model.addAttribute("registrationFormTrainer", registrationFormTrainer);
		model.addAttribute("stateList", stateList);
		model.addAttribute("titleList", titleList);
		model.addAttribute("casteList", casteList);
		model.addAttribute("trainingPartnerNameList", trainingPartnerNameList);
		model.addAttribute("basicCourseList", basicCourseList);
		
		return "registrationFormTrainer";
	}
	
	
	
	
	@RequestMapping(value = "/registrationTrainer", method = RequestMethod.POST)
	public String registerTrainer(@Valid @ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer, BindingResult bindingResult,Model model)  {
		new ZLogger("registrationTrainer","register controller before bind trainer" , "RegistrationControllerTrainer.java");
		if(bindingResult.hasErrors()){			
			new ZLogger("registrationTrainer", "bindingResult.hasErrors  "+bindingResult.hasErrors() , "RegistrationControllerTrainer.java");
			new ZLogger("registrationTrainer", "bindingResult.hasErrors  "+bindingResult.getErrorCount() +" All Errors "+bindingResult.getAllErrors(), "RegistrationControllerTrainer.java");
			return "registrationFormTrainer";
		}
		String personalInformationTrainer = registrationServiceTrainer.registerPersonalInformationTrainer(registrationFormTrainer);
		if(personalInformationTrainer != null && ! personalInformationTrainer.equalsIgnoreCase("")){
			String[] all = personalInformationTrainer.split("&");
			model.addAttribute("id" , all[1]);
			model.addAttribute("pwd" , all[0]);
			new Thread(new Mail("Thanks", registrationFormTrainer.getTrainingCenterPermanentEmail(), all[1], all[0], registrationFormTrainer.getFirstName())).start();
			return "welcome";
		}else{
			model.addAttribute("id" , "Oops, something went wrong !!!");
			return "personalInformationTrainer";
		}
	}
	
	@RequestMapping(value="/search-and-apply" , method=RequestMethod.GET)
	public String searchandapply(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer, Model model,HttpSession session )
	{
		
		Integer userId = (Integer) session.getAttribute("userId");
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
    	
		int loginId=(int) session.getAttribute("loginIdUnique");
		new ZLogger("basicCourseSaveTrainer", "loginid   :"+ loginId, "RegistrationControllerTrainer.java");
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
		new ZLogger("update-profile", "Exception while update-profile "+e.getMessage(), "RegistrationControllerTrainer.java");
	 };
	
	 List<ManageTrainingPartner> trainingPartnerList = null;
	 if(userId > 0){
		 trainingPartnerList = registrationServiceTrainer.trainingPartnerList();
		 PersonalInformationTrainer personalInformationTrainer = registrationServiceTrainer.FullDetailTrainer(userId);
		model.addAttribute("trainingPartnerID", personalInformationTrainer.getAssociatedTrainingpartnerName().getManageTrainingPartnerId());
		System.out.println("trainingPartnerList "+trainingPartnerList);
		model.addAttribute("trainingPartnerList" , trainingPartnerList);
		System.out.println(" partner ID "+personalInformationTrainer.getAssociatedTrainingpartnerName().getManageTrainingPartnerId());
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

		String updateTrainer = registrationServiceTrainer.UpdateTrainer(registrationFormTrainer , ss);
		if(!updateTrainer.equalsIgnoreCase(""))
		{
			new ZLogger("update-profile", "Data are updated successfully", "RegistrationControllerTrainer.java");
		}
		//model.addAttribute("update", "Updated successfully !!!");
		return "welcomeupdatetrainee";
	}
    
}