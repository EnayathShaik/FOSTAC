package com.ir.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ir.constantes.Constantes;
import com.ir.constantes.TableLink;
import com.ir.form.ChangePasswordForm;
import com.ir.form.ContactTrainee;
import com.ir.form.CourseEnrolledUserForm;
import com.ir.form.RegistrationFormTrainee;
import com.ir.form.RegistrationFormTrainer;
import com.ir.model.AdmitCardForm;
import com.ir.model.AssessmentQuestion;
import com.ir.model.CertificateInfo;
import com.ir.model.CourseName;
import com.ir.model.CourseTrainee;
import com.ir.model.CourseType;
import com.ir.model.FeedbackForm;
import com.ir.model.FeedbackMaster;
import com.ir.model.KindOfBusiness;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.State;
import com.ir.model.Title;
import com.ir.model.TraineeAssessment;
import com.ir.model.TrainingPartner;
import com.ir.model.Utility;
import com.ir.service.AssessmentService;
import com.ir.service.PageLoadService;
import com.ir.service.TraineeService;
import com.ir.util.GenerateUniqueID;
import com.ir.util.JavaMail;
import com.ir.util.Profiles;

@Controller
@SessionAttributes
public class TraineeController {
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	@Qualifier("traineeService")
	public TraineeService traineeService;
	
	
	
	@Autowired
	@Qualifier("assessmentService")
	public AssessmentService assessmentService;
	
	// Rishi 
	@RequestMapping(value="/contactTrainee" , method=RequestMethod.GET)
	public String contactTrainee(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee, Model model , HttpSession session){
		try{
			Integer userId = (Integer) session.getAttribute("userId");
			Integer profileId = (Integer) session.getAttribute("profileId");
			String defaultMail = traineeService.getDefaultMailID(userId, profileId);
			model.addAttribute("defaultMail", defaultMail);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "contactTrainee";
	}
	@RequestMapping(value="/changePasswordTrainee" , method=RequestMethod.GET)
	public String contactTrainee(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm ){
		return "changePasswordTrainee";
	}
	

	@ModelAttribute("kindOfBusinessList")
	public List<KindOfBusiness> populateKindOfBusiness() {
		List<KindOfBusiness> kindOfBusinessList = null;
		try{
			kindOfBusinessList=pageLoadService.loadKindOfBusiness();
		}catch(Exception e){
			e.printStackTrace();
		}
		return kindOfBusinessList;
	}
	
	
	@RequestMapping(value="/basic" , method=RequestMethod.GET)
	public String basic(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){// , Model modal , HttpSession session ){
		return "basic";
	}
	
	@ModelAttribute("courseTypes")
	public List<String> populateCourseType() {
		List<String> courseTypes  = traineeService.courseTypes();
		System.out.println("courseTypes    :   "+ courseTypes);
		return courseTypes;
	}
	
	
	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = null;
		try {
			courseTypeList = traineeService.courseTypeList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseTypeList;
	}

	
	@RequestMapping(value="/uploadImage" , method=RequestMethod.GET)
	public String uploadImage(@ModelAttribute("uploadImage") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "upload-image";
	}
	
	
	@RequestMapping(value="/uploadProfile" , method=RequestMethod.GET)
	public String uploadProfiles(@ModelAttribute("uploadImage") CourseEnrolledUserForm courseEnrolledUserForm ,
		 @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "upload-image";
	}
	
	 @RequestMapping(value="saveFile",method=RequestMethod.POST)  
	    public String saveFile( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
		 	String userName = "";
			int loginId = 0;
			try{
			userName = (String) session.getAttribute("userName");
			// String ss = session.getServletContext().getContextPath();
			String ss = session.getServletContext().getRealPath("")
					.replace("Fssai_E-Learning_System", "Fostac/Trainer");
			File dir = new File(ss);
			if (!dir.exists())
				dir.mkdirs();
			String extension = "";
			String fileName = file.getOriginalFilename();
			int i = fileName.lastIndexOf('.');
			if (i > 0) {
				extension = fileName.substring(i + 1);
			}
			byte[] bytes = file.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File(ss + File.separator
							+ userName + "." +extension)));
			stream.write(bytes);
			stream.flush();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "upload-image";
	    }  
	
	 
	 
	 @RequestMapping(value="saveImage",method=RequestMethod.POST)  
	    public String saveImage( @RequestParam CommonsMultipartFile file,  
	           HttpSession session) throws Exception{  
		 	String userName = "";
			try{
				userName = (String) session.getAttribute("userName");
				//String ss = session.getServletContext().getContextPath();
				String ss = session.getServletContext().getRealPath("").replace("Fssai_E-Learning_System", "Fostac/Trainee");
				File dir = new File(ss);
				if (!dir.exists())
					dir.mkdirs();
			 	  
		    byte[] bytes = file.getBytes();  
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
		         new File(ss + File.separator + userName+".png")));  
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
			}catch(Exception e){
				e.printStackTrace();
			}
			     
	    return "upload-image";  
	    }  
/*	@RequestMapping(value="/saveImage" , method=RequestMethod.POST)
	public String Savemage(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file){
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "upload-image";
	}*/
	@RequestMapping(value="/courseTraining" , method=RequestMethod.GET)
	public String courseTraining(@RequestParam(value = "courseTypeId", required = true)  String courseTypeId , Model model, HttpSession session){
		Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
		try{
				String docPath = "";
				String contentName = "";
				String pdf = ".pdf";
				String mp4 = ".mp4";
				String ppt = ".ppt";
				docPath = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Course/");
				if(userId>0){
					CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
					System.out.println("courseTrainee == "+courseTrainee.getCourseTypeId());
					System.out.println("courseTrainee == "+courseTrainee.getContentNameInput());
					System.out.println("courseTrainee == "+courseTrainee.getContentLinkInput());
					
					if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("BASIC")){
						if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")){
							docPath = docPath + "BASIC/PDF/"+courseTrainee.getContentLinkInput()+pdf;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("PPT")){
							docPath = docPath + "BASIC/PPT/"+courseTrainee.getContentLinkInput()+ppt;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("VIDEO")){
							docPath = docPath + "BASIC/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
						}
					}else if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("ADVANCE")){
						if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")){
							docPath = docPath + "ADVANCE/PDF/"+courseTrainee.getContentLinkInput()+pdf;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("PPT")){
							docPath = docPath + "ADVANCE/PPT/"+courseTrainee.getContentLinkInput()+ppt;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("VIDEO")){
							docPath = docPath + "ADVANCE/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
						}
					}else if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("SPECIAL")){
						if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY")){
							docPath = docPath + "SPECIAL/PDF/"+courseTrainee.getContentLinkInput()+pdf;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("PPT")){
							docPath = docPath + "SPECIAL/PPT/"+courseTrainee.getContentLinkInput()+mp4;
						}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentLinkInput().toUpperCase().contains("VIDEO")){
							docPath = docPath + "SPECIAL/VIDEO/"+courseTrainee.getContentLinkInput();
						}
					}
					contentName = (courseTrainee != null ? "" :  courseTrainee.getContentNameInput());
					model.addAttribute("contentName", contentName);
					model.addAttribute("contentPath", docPath);
					model.addAttribute("courseTrainee", courseTrainee);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "courseTraining12";
	}
	@RequestMapping(value="/training" , method=RequestMethod.GET)
	public String training(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer , HttpSession session)
	{
		
		//update Step
				Integer profileID = 0;
				Integer userId = 0;
				int loginId = 0;
				try{
					profileID = (Integer) session.getAttribute("profileId");
					loginId = (int) session.getAttribute("loginIdUnique");
					userId = (Integer) session.getAttribute("userId");
					int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileID);
					traineeService.updateSteps(tableID, profileID, 3);
					session.setAttribute("traineeSteps", 3);
				}catch(Exception e){
					e.printStackTrace();
				}
		return "training";
	}

	@RequestMapping(value="/playvedio" , method=RequestMethod.GET)
	public String playvideo(Model model, HttpSession session){
//		CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(Integer.parseInt(courseTypeId));
//		model.addAttribute("courseTrainee", courseTrainee);
		//session.setAttribute("uniqueId", uniqueId);
		return "playvedio";
	}
	
	@RequestMapping(value="/basicSave" , method=RequestMethod.POST)
	public String basicSave(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result , HttpSession httpSession,Model model){
		int loginId = 0;
		Integer profileId = 0;
		Integer userId = 0;
		try{
			profileId = (Integer) httpSession.getAttribute("profileId");
			loginId = (int) httpSession.getAttribute("loginIdUnique");
			userId = (Integer) httpSession.getAttribute("userId");
			//int tableID = courseEnrolledUserForm.getPersonalinformationtraineeid();
			int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileId);
			System.out.println("loginid   :"+ loginId);
			System.out.println("tableID  :"+ tableID);
			String basicEnroll = traineeService.basicSave(courseEnrolledUserForm , loginId , tableID,profileId);
				if(basicEnroll != null && basicEnroll.length()  > 1){
					Boolean status = traineeService.updateSteps(tableID, profileId, 1);
					httpSession.setAttribute("traineeSteps", 1);
					if(status){
						model.addAttribute("created", "You have successfully enrolled !!!");
						model.addAttribute("roll", basicEnroll);
					}else{
						model.addAttribute("created", "Oops , something went wrong !!!");
						model.addAttribute("roll", basicEnroll);
					}
				}else{
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		 return "traineeHomepage";
	}
	@RequestMapping(value="/changePasswordTraineeSave" , method=RequestMethod.POST)
	public String changePasswordTraineeSave(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "changePasswordTrainee";
		}
		try{
			String id =(String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = traineeService.changePasswordTraineeSave(changePasswordForm , id);
			if(changePasswordTraineeSave){
				model.addAttribute("created" , "Your password has changed !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "changePasswordTrainee";
	}
	@RequestMapping(value="/contactTraineeSave" , method=RequestMethod.POST)
	public String contactTrainee1(@ModelAttribute("contactTraineee") ContactTrainee contactTrainee
			,BindingResult result , HttpSession session, Model model
			){
		if(result.hasErrors()){
			System.out.println(" bindingResult.hasErrors "+result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "contactTrainee";
		}
		try{
			String id=(String) session.getAttribute("logId");
			System.out.println("userid   "+ id);
			String contactTraineeSave = traineeService.contactTraineeSave(contactTrainee , id);
			if(contactTraineeSave.equalsIgnoreCase("created")){
				model.addAttribute("created" , "Your request has been sent successfully !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "contactTrainee";
	}

	@ModelAttribute("courseNameListB")
	public List<CourseName> courseNameList(){
		List<CourseName> courseNameListB = null;
		try{
			courseNameListB = traineeService.courseNameList();
			System.out.println("courseNameListB course name list   :   "+ courseNameListB);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return courseNameListB;
	}
	
	@ModelAttribute("advanceCourseNameList")
	public List<CourseName> advanceCourseNameList(){
		List<CourseName> advanceCourseNameList = null;
		try{
			advanceCourseNameList = traineeService.courseNameListByType(Constantes.COURSETYPE_ADVANCE);
			System.out.println("Advance course name list   :   "+ advanceCourseNameList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return advanceCourseNameList;
	}

	@ModelAttribute("specialCourseNameList")
	public List<CourseName> specialCourseNameList(){
		List<CourseName> specialCourseNameList = null;
		try{
			specialCourseNameList = traineeService.courseNameListByType(Constantes.COURSETYPE_SPECIAL);
			System.out.println("specialCourseNameList course name list   :   "+ specialCourseNameList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return specialCourseNameList;
	}
	@ModelAttribute("trainingPartnerList")
	public List<ManageTrainingPartner> trainingPartnerList(){
		List<ManageTrainingPartner> trainingPartnerList = null;
		try{
			trainingPartnerList = traineeService.trainingPartnerList();
			System.out.println("training partner name list   :   "+ trainingPartnerList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return trainingPartnerList;
	}
	@ModelAttribute("trainingCenterStateList")
	public List<State> trainingCenterStateList(){
		List<State> trainingCenterStateList = null;
		try{
			trainingCenterStateList = traineeService.trainingCenterStateList();
			System.out.println("training partner state list   :   "+ trainingCenterStateList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return trainingCenterStateList;
	}
	@RequestMapping(value="/updateInformation" , method=RequestMethod.GET)
	public String updateInformation(@RequestParam(value = "userId", required = true)  Integer userId ,@ModelAttribute("updateInformation") RegistrationFormTrainee registrationFormTrainee, HttpSession session, Model model ){		
		Integer profileID = 0;
		try{
			profileID = (Integer) session.getAttribute("profileId");
			if(profileID == 1 || profileID == 2){
				//Bases On User
			}else{
				userId = (Integer) session.getAttribute("userId");
			}
			
			 if(userId > 0){
					PersonalInformationTrainee personalInformationTrainee = traineeService.FullDetail(userId);
					Title title = new Title();
					title.setTitleId(personalInformationTrainee.getTitle().getTitleId());
					title.setTitleName(personalInformationTrainee.getTitle().getTitleName());
					List<Title> titleList = new ArrayList<Title>();
					titleList.add(title);
					session.setAttribute("loginUser", personalInformationTrainee);
					session.setAttribute("titleList", titleList);
				 }
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		return "updateInformation";
	}
	@RequestMapping(value="/updateTrainee" , method=RequestMethod.POST)
	public String updateTrainee(@RequestParam(value = "id", required = true)  Integer id,@ModelAttribute("updateInformation") RegistrationFormTrainee registrationFormTrainee ,BindingResult bindingResult, HttpSession session , Model model  ){
		Integer ss = 0;
		try{
			if(id <= 0){
				 ss = (Integer)session.getAttribute("loginUser1");
			}else{
				ss = id;
			}
			System.out.println("nnb   " +ss);
			String updateTrainee = traineeService.updateTrainee(registrationFormTrainee , ss);
			if(updateTrainee != "")
			{
				System.out.println("Data are updated successfully");
			}
			model.addAttribute("update", "Updated successfully !!!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "welcomeupdatetrainee";
	}
	
	@ModelAttribute("stateList")
	public List<State> populateStateList() {
		List<State> stateList = null;
		try{
			stateList = pageLoadService.loadState();
			System.out.println("state list   :   "+ stateList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return stateList;
	}
	@RequestMapping(value="/generateAdmitCardtrainee" , method=RequestMethod.GET)
	public String generateAdmitCardtrainee(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model ){
		try{
			/*JavaMail javaMail = new JavaMail();
			javaMail.mailProperty("Hello", "manindramishra.seven@gmail.com", "10002");
			*/Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
			if(userId>0){
				CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
				model.addAttribute("courseTrainee", courseTrainee);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "generateAdmitCardtrainee";
	}
	
	@RequestMapping(value="/admit-cardtrainee" , method=RequestMethod.GET)
	public String admitcardtrainee(@ModelAttribute("basicTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("tp") TrainingPartner tp,BindingResult result ,HttpSession session, Model model ){
		//update Step
		System.out.println("Generate Admit Card ..........................");
		
		Integer profileID = 0;
		Integer userId = 0;
		int loginId = 0;
		String imagePath = "";
		String userName = "";
		try{
			profileID = (Integer) session.getAttribute("profileId");
			loginId = (int) session.getAttribute("loginIdUnique");
			userId = (Integer) session.getAttribute("userId");
			userName = (String) session.getAttribute("userName");
			String ss = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Trainee");
			imagePath = ss + File.separator + userName+".png";
			int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileID);
			if(session.getAttribute("loginIdUnique")!=null){
				String loginid=session.getAttribute("loginIdUnique").toString();
				AdmitCardForm admitCardForm=traineeService.generateAdmitCard(Integer.parseInt(loginid),Profiles.TRAINEE.value());
				System.out.println("&&&&&&&&&&&&& "+admitCardForm);
				//traineeService.updateSteps(tableID, profileID, 2);
				session.setAttribute("traineeSteps", 2);
				model.addAttribute("imagePath", imagePath);
				model.addAttribute("admitCardForm", admitCardForm);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		
		return "admit-cardtrainee";
	}
	
	@RequestMapping(value="/certificatetrainee" , method=RequestMethod.GET)
	public String certificatetrainee(HttpSession session, Model model){
		//update Step
				Integer profileID = 0;
				Integer userId = 0;
				int loginId = 0;
				try{
					profileID = (Integer) session.getAttribute("profileId");
					loginId = (int) session.getAttribute("loginIdUnique");
					userId = (Integer) session.getAttribute("userId");
					int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileID);
					traineeService.updateSteps(tableID, profileID, 0);
					/*String getId = GenerateUniqueID.getNextCombinationId("TCR");
					System.out.println("getId "+getId);*/
					//System.out.println(traineeService.getCertificateID(userId, profileID));
					CertificateInfo certificateInfo = traineeService.getCertificateID(userId, profileID);
					System.out.println("Certificate ID = "+certificateInfo.getCertificateID());
					System.out.println("Training Date = "+certificateInfo.getTrainingDate());
					//Close Course
					traineeService.closeCourse(userId, profileID, "Y");
					model.addAttribute("certificateID", certificateInfo.getCertificateID());
					model.addAttribute("trainingDate", certificateInfo.getTrainingDate());
					model.addAttribute("traineeCertificateName", certificateInfo.getName());
					session.setAttribute("traineeSteps", 0);
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("Exception while course details save : "+ e.getMessage());
				}
		return "certificatetrainee";
	}

	@RequestMapping(value="/advanceTrainee" , method=RequestMethod.GET)
	public String advance(@ModelAttribute("advanceTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "advanceTrainee";
	}
	@RequestMapping(value="/advanceTraineeSave" , method=RequestMethod.POST)
	public String advanceTraineeSave(@ModelAttribute("advanceTrainee") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result ,HttpSession httpSession, Model model){
		
		int loginId = 0;
		Integer profileId = 0;
		Integer userId = 0;
		try{
			loginId = (int) httpSession.getAttribute("loginIdUnique");
			profileId = (Integer) httpSession.getAttribute("profileId");
			userId = (Integer) httpSession.getAttribute("userId");
			int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileId);
			long basicEnroll = traineeService.advanceTraineeSave(courseEnrolledUserForm , loginId , tableID,profileId);
			if(basicEnroll  > 1){
				Boolean status = traineeService.updateSteps(tableID, profileId, 1);
				httpSession.setAttribute("traineeSteps", 1);
				if(status){
					model.addAttribute("created", "You have successfully enrolled !!!");
					model.addAttribute("roll", basicEnroll);
				}else{
					model.addAttribute("created", "Oops , something went wrong !!!");
					model.addAttribute("roll", basicEnroll);
				}
			}else{
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		return "traineeHomepage";
	}
	@RequestMapping(value="/specialTrainee" , method=RequestMethod.GET)
	public String specialTrainee(@ModelAttribute("specialTrainee") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "specialTrainee";
	}
	
	@RequestMapping(value="/specialTraineeSave" , method=RequestMethod.POST)
	public String specialTraineeSave(@ModelAttribute("specialTrainee") CourseEnrolledUserForm courseEnrolledUserForm,
			@ModelAttribute("rft") PersonalInformationTrainee loginUser ,BindingResult result ,HttpSession httpSession, Model model){
		int loginId = 0;
		Integer profileId = 0;
		Integer userId = 0;
		try{
			profileId = (Integer) httpSession.getAttribute("profileId");
			loginId = (int) httpSession.getAttribute("loginIdUnique");
			userId = (Integer) httpSession.getAttribute("userId");
			int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileId);
			String basicEnroll = traineeService.basicSave(courseEnrolledUserForm , loginId , tableID,profileId);
			if(basicEnroll != null && basicEnroll.length()  > 1){
				Boolean status = traineeService.updateSteps(tableID, profileId, 1);
				httpSession.setAttribute("traineeSteps", 1);
				if(status){
					model.addAttribute("created", "You have successfully enrolled !!!");
					model.addAttribute("roll", basicEnroll);
				}else{
					model.addAttribute("created", "Oops , something went wrong !!!");
					model.addAttribute("roll", basicEnroll);
				}
			}else{
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		return "traineeHomepage";
	}
	
	@RequestMapping(value="/viewTraineeList" , method=RequestMethod.GET)
	public String viewTraineeList(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,
			@ModelAttribute("state") State state , @ModelAttribute("loginUser") PersonalInformationTrainee pit ){
		return "viewTraineeList";
	}
	@RequestMapping(value ="/traineeAssessmentOnline", method = RequestMethod.GET)
	public String traineeAssessmentOnline(@ModelAttribute ("courseEnrolledUserForm")CourseEnrolledUserForm courseEnroledUserForm, Model model, HttpSession httpSession){
		String responseText = "";
		int loginId = -1;
		try{
		loginId = (int)httpSession.getAttribute("loginIdUnique");
		if(loginId > 0){
			TraineeAssessment traineeAssessment = new TraineeAssessment();
			int courseType = 1;
			int courseNameId = 	traineeService.getCurrentCourseId(loginId);
			List<AssessmentQuestion> assessmentQuestions =  assessmentService.getAssessmentQuestions(courseType, courseNameId);
			traineeAssessment.setListAssessmentQuestion(assessmentQuestions);
			traineeAssessment.setCourseNameId(courseNameId);
			Gson gson=new Gson();
			String list=gson.toJson(traineeAssessment);
			responseText = "traineeAssessmentOnline";
			model.addAttribute("traineeAssessment",list);
		}
		}catch(Exception e){
			e.printStackTrace();
			responseText = "generic_error";
			System.out.println("Exception while fetching assessment details for trainee - "+e.getMessage());
		}
		return responseText;
	}
	@RequestMapping(value="/feedbackForm" , method=RequestMethod.GET)
	public String feedback(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model){
		Integer profileId = (Integer) session.getAttribute("profileId");
		Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
		try{
			if(userId>0){
				CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
				model.addAttribute("courseTrainee", courseTrainee);
			}
			
			TableLink data = TableLink.getByprofileID(profileId);
			List<FeedbackMaster> feedbackMasters=traineeService.getFeedMasterList(profileId);
			model.addAttribute("feedbackMasters",feedbackMasters);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "feedbackForm";
	}
	@RequestMapping(value="/generateCertificatetrainee" , method=RequestMethod.GET)
	public String generateCertificatetrainee(@ModelAttribute("courseEnrolledUserForm") CourseEnrolledUserForm courseEnrolledUserForm ,BindingResult bindingResult, HttpSession session , Model model){
		Integer userId=Integer.parseInt(session.getAttribute("userId").toString());
		try{
			if(userId>0){
				String isEligible = "";
				isEligible = traineeService.isTraineeEligible(userId);
				if(isEligible != null && isEligible.equals("Y")){
					CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
					model.addAttribute("courseTrainee", courseTrainee);
				}
				System.out.println("isEligible ==== "+isEligible);
				model.addAttribute("Eligible", isEligible);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "generateCertificatetrainee";
	}
	@RequestMapping(value="/assessment-instructions-trainee" , method=RequestMethod.GET)
	public String assessmentinstructionstrainee(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer,BindingResult bindingResult, HttpSession session , Model model )
	{
		Utility utility=new Utility();
		//Need to write service for AsssessorAgency 
		model.addAttribute("utility",utility);
		Integer userId = 0;
		try{
			userId = (Integer) session.getAttribute("userId");
			System.out.println("user id = "+userId);
			String isOnline=traineeService.isCourseOnline(userId);
			System.out.println("Online == "+isOnline);
			CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
			model.addAttribute("courseTrainee", courseTrainee);
			if(isOnline != null && isOnline.toUpperCase().contains("ONLINE")){
				model.addAttribute("ISONLINE","YES");
			}else{
				model.addAttribute("ISONLINE","NO");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		return "assessment-instructions-trainee";
	}
	@RequestMapping(value="/feedback-form" , method=RequestMethod.GET)
	public String feedbackform(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer )
	{
		return "feedback-form-trainee";
	}
	@RequestMapping(value="/course-training" , method=RequestMethod.GET)
	public String coursetraining(@ModelAttribute("registrationFormTrainer") RegistrationFormTrainer registrationFormTrainer, HttpSession session, Model model )
	{
		System.out.println("************************8");
		Integer userId = 0;
		int loginId= 0;
		try{
			userId = (Integer) session.getAttribute("userId");
			loginId=Integer.parseInt(session.getAttribute("loginIdUnique").toString());
			String docPath = "";
			String contentName = "";
			String pdf = ".pdf";
			String mp4 = ".mp4";
			String ppt = ".ppt";
			docPath = servletContext.getContextPath().replace("Fssai_E-Learning_System", "Fostac/Course/");
			if(userId>0){
				CourseTrainee  courseTrainee= traineeService.getCourseTrainingByCourseTypeID(userId);
				if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("BASIC")){
					System.out.println("Enter Basic");
					System.out.println(courseTrainee.getContentLinkInput().toUpperCase());
					System.out.println(courseTrainee.getContentLinkInput().toUpperCase().contains("STUDY"));
					if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("STUDY")){
						System.out.println("Enter Study");
						docPath = docPath + "BASIC/PDF/"+courseTrainee.getContentLinkInput()+pdf;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("PPT")){
						docPath = docPath + "BASIC/PPT/"+courseTrainee.getContentLinkInput()+ppt;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("VIDEO")){
						docPath = docPath + "BASIC/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
					}
				}else if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("ADVANCE")){
					
					if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("STUDY")){
						docPath = docPath + "ADVANCE/PDF/"+courseTrainee.getContentLinkInput()+pdf;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("PPT")){
						docPath = docPath + "ADVANCE/PPT/"+courseTrainee.getContentLinkInput()+ppt;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("VIDEO")){
						docPath = docPath + "ADVANCE/VIDEO/"+courseTrainee.getContentLinkInput()+mp4;
					}
				}else if(courseTrainee != null && courseTrainee.getCourseTypeId() != null && courseTrainee.getCourseTypeId().toUpperCase().contains("SPECIAL")){
					if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("STUDY")){
						docPath = docPath + "SPECIAL/PDF/"+courseTrainee.getContentLinkInput()+pdf;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("PPT")){
						docPath = docPath + "SPECIAL/PPT/"+courseTrainee.getContentLinkInput()+mp4;
					}else if(courseTrainee.getContentLinkInput() != null && courseTrainee.getContentNameInput().toUpperCase().contains("VIDEO")){
						docPath = docPath + "SPECIAL/VIDEO/"+courseTrainee.getContentLinkInput();
					}
				}
				model.addAttribute("contentName", courseTrainee.getContentNameInput());
				model.addAttribute("contentPath", docPath);
				model.addAttribute("courseTrainee", courseTrainee);
			
			Utility utility=new Utility();
			//Need to write service for AsssessorAgency 
			model.addAttribute("utility",utility);
			
			
			System.out.println("user id = "+userId);
			String isOnline=traineeService.isCourseOnline(userId);
			System.out.println("Online == "+isOnline);
			if(isOnline != null && isOnline.toUpperCase().contains("ONLINE")){
				model.addAttribute("ISONLINE","YES");
			}else{
				model.addAttribute("ISONLINE","NO");
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Exception while course details save : "+ e.getMessage());
		}
		
		
		return "course-training-trainee";
		
	}
	@RequestMapping(value="/saveFeedbackForm" , method=RequestMethod.POST)
	public String saveFeedbackForm(@ModelAttribute("feedbackforms") List<FeedbackForm> feedbackforms ,BindingResult bindingResult, HttpSession session , Model model){
		try{
			for(FeedbackForm feedbackForm:feedbackforms){
				feedbackForm.setUserId(session.getAttribute("loginIdUnique").toString());			
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
//		CourseName courseName=traineeService.getCourseDetails(loginId);
//		List<FeedbackMaster> feedbackMasters=traineeService.getFeedMasterList();
//		model.addAttribute("courseName",courseName);
//		model.addAttribute("feedbackMasters",feedbackMasters);
		return "feedbackForm";
	}
	
	@RequestMapping(value="/afterFeedbackSubmit" , method=RequestMethod.GET)
	public String saveFeedbackForm(HttpSession session){
		//update Step
				Integer profileID = 0;
				Integer userId = 0;
				int loginId = 0;
				try{
					profileID = (Integer) session.getAttribute("profileId");
					loginId = (int) session.getAttribute("loginIdUnique");
					userId = (Integer) session.getAttribute("userId");
					int tableID = traineeService.getTableIdForEnrolmentID(loginId, profileID);
					traineeService.updateSteps(tableID, profileID, 5);
					session.setAttribute("traineeSteps", 5);
				}catch(Exception e){
					System.out.println("Exception while course details save : "+ e.getMessage());
				}
		return "redirect:/loginProcess.fssai";
	}
}
