package com.ir.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;
import com.ir.bean.common.IntStringBean;
import com.ir.constantes.TableLink;
import com.ir.form.AdminUserManagementForm;
import com.ir.form.AssessmentQuestionForm;
import com.ir.form.AssessorUserManagementForm;
import com.ir.form.ChangePasswordForm;
import com.ir.form.CityForm;
import com.ir.form.ContactTrainee;
import com.ir.form.DistrictForm;
import com.ir.form.GenerateCourseCertificateForm;
import com.ir.form.ManageAssessmentAgencyForm;
import com.ir.form.ManageCourse;
import com.ir.form.ManageCourseContentForm;
import com.ir.form.ManageTrainingPartnerForm;
import com.ir.form.RegionForm;
import com.ir.form.StateForm;
import com.ir.form.TraineeUserManagementForm;
import com.ir.form.TrainerUserManagementForm;
import com.ir.form.TrainingCalendarForm;
import com.ir.form.TrainingCenterUserManagementForm;
import com.ir.form.UpdateTrainerAssessmentForm;
import com.ir.model.City;
import com.ir.model.CourseName;
import com.ir.model.CourseType;
import com.ir.model.District;
import com.ir.model.FeedbackMaster;
import com.ir.model.ManageTrainingPartner;
import com.ir.model.PersonalInformationAssessor;
import com.ir.model.PersonalInformationTrainee;
import com.ir.model.PersonalInformationTrainer;
import com.ir.model.PersonalInformationTrainingPartner;
import com.ir.model.State;
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainer.TrainerAssessmentEvaluation;
import com.ir.service.AdminService;
import com.ir.service.PageLoadService;
import com.zentech.backgroundservices.Mail;
import com.zentech.logger.ZLogger;

@Controller
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	AdminService adminService;
	
	@Autowired
	@Qualifier("pageLoadService")
	PageLoadService pageLoadService;
	
	/*@ModelAttribute("stateList")
	public List<State> stateList() {
		List<State> stateList = null;
		try {
			stateList = adminService.stateList();
			new ZLogger("stateList", "state list   :   " + stateList, "AdminController.java");
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("stateList", "Exception while stateList :  "+ e.getMessage(), "AdminController.java");
		}
		return stateList;
	}

	
	@ModelAttribute("trainingPartnerList")
	public List<ManageTrainingPartner> trainingPartnerList() {
		List<ManageTrainingPartner> trainingPartnerList = null;
		try {
			trainingPartnerList = adminService.trainingPartnerList();
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingPartnerList", "Exception while trainingPartnerList :  "+ e.getMessage(), "AdminController.java");
		}
		return trainingPartnerList;
	}

	@ModelAttribute("trainingNameList")
	public List<PersonalInformationTrainer> trainingNameList() {
		List<PersonalInformationTrainer> trainingNameList = null;
		try {
			trainingNameList = adminService.trainingNameList();
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingNameList", "Exception while trainingNameList :  "+ e.getMessage(), "AdminController.java");
		}
		return trainingNameList;
	}

	@ModelAttribute("courseNameList")
	public List<CourseName> courseNameList() {
		List<CourseName> courseNameList = null;
		try {
			courseNameList = adminService.courseNameList();
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("courseNameList", "Exception while courseNameList :  "+ e.getMessage(), "AdminController.java");
		}
		return courseNameList;
	}

	@ModelAttribute("courseTypeList")
	public List<CourseType> courseTypeList() {
		List<CourseType> courseTypeList = null;
		try {
			courseTypeList = adminService.courseTypeList();
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("courseTypeList", "Exception while courseTypeList :  "+ e.getMessage(), "AdminController.java");
		}
		return courseTypeList;
	}

*/
	

	@RequestMapping(value = "/stateMaster", method = RequestMethod.GET)
	public String stateMaster(
			@ModelAttribute("stateMaster") StateForm stateForm, Model model,
			HttpSession session) {
		try {
			model.addAttribute("created", " ");
			session.setAttribute("created", " ");
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("stateMaster", "Exception while stateMaster :  "+ e.getMessage(), "AdminController.java");
		}
		return "stateMaster";
	}

	@RequestMapping(value = "/stateMasterSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("stateMaster") StateForm stateForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			
			new ZLogger("stateSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("stateSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "stateMaster";
		}
		try {
			String stateMasterSave = adminService.stateMasterSave(stateForm);
			if (stateMasterSave.equalsIgnoreCase("created")) {
				model.addAttribute("created",
						" State insertion successfull !!!");
				model.addAttribute("stateMaster", new StateForm());
			} else {
				model.addAttribute("created",
						"State already exists in reord !!!");
				// session.setAttribute("created" ,
				// "State already exists in reord !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("stateMasterSave", "Exception while stateMasterSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "stateMaster";
	}

	@RequestMapping(value = "/stateMasterSave", method = RequestMethod.GET)
	public String showForm() {

		return "redirect:stateMaster.fssai";
	}

	@RequestMapping(value = "/districtMaster", method = RequestMethod.GET)
	public String districtMaster(
			@ModelAttribute("districtMaster") DistrictForm districtForm,
			Model model, HttpSession session) {
		List<State> stateList = null;
		try {
			stateList = adminService.stateList();
			model.addAttribute("stateList", stateList);
			model.addAttribute("created", " ");
			session.setAttribute("created", " ");
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("districtMaster", "Exception while districtMaster :  "+ e.getMessage(), "AdminController.java");
		}
		return "districtMaster";
	}

	@RequestMapping(value = "/manageAssessmentQuestions", method = RequestMethod.GET)
	public String manageAssessmentQuestions(
			@ModelAttribute("assessmentQuestionForm") AssessmentQuestionForm assessmentQuestionForm, Model model) {
		List<CourseType> courseTypeList = pageLoadService.courseTypeList();
		model.addAttribute("courseTypeList", courseTypeList);
		return "manageAssessmentQuestions";
	}

	@RequestMapping(value = "/manageAssessmentQuestionsSave", method = RequestMethod.POST)
	public String manageAssessmentQuestionsSave(
			@Valid @ModelAttribute("assessmentQuestionForm") AssessmentQuestionForm assessmentQuestionForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("manageAssessmentQuestionsSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("manageAssessmentQuestionsSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "manageAssessmentQuestions";
		}
		try {
			String manageAssessmentQuestionsSave = adminService
					.manageAssessmentQuestionsSave(assessmentQuestionForm);
			if (manageAssessmentQuestionsSave.equalsIgnoreCase("created")) {
				model.addAttribute("created", "Question Saved successfully !!!");
			} else {
				model.addAttribute("created",
						"Question already exists in records !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("manageAssessmentQuestionsSave", "Exception while manageAssessmentQuestionsSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "manageAssessmentQuestions";
	}

	@RequestMapping(value = "/districtMasterSave", method = RequestMethod.POST)
	public String districtMasterSave(
			@Valid @ModelAttribute("districtMaster") DistrictForm districtForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			new ZLogger("districtMasterSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("districtMasterSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "districtMaster";
		}
		try {
			String districtMasterSave = adminService
					.districtMasterSave(districtForm);
			if (districtMasterSave.equalsIgnoreCase("created")) {
				model.addAttribute("created",
						"District inserted successfully !!!");
				model.addAttribute("districtMaster", new DistrictForm());
			} else {
				model.addAttribute("created",
						"District already exists in records !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("districtMasterSave", "Exception while districtMasterSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "districtMaster";
	}

	@RequestMapping(value = "/districtMasterSave", method = RequestMethod.GET)
	public String showDistrctForm() {

		return "redirect:districtMaster.fssai";
	}

	@RequestMapping(value = "/cityMaster", method = RequestMethod.GET)
	public String districtMaster(@ModelAttribute("cityMaster") CityForm cityForm, Model model) {
		List<State> stateList = adminService.stateList();
		List<District> districtList = adminService.districtList();
		model.addAttribute("districtList", districtList);
		model.addAttribute("stateList", stateList);
		return "cityMaster";
	}

	@RequestMapping(value = "/cityMasterSave", method = RequestMethod.POST)
	public String cityMasterSave(
			@Valid @ModelAttribute("cityMaster") CityForm cityForm,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			new ZLogger("cityMasterSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("cityMasterSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "cityMaster";
		}
		try {
			String cityMasterSave = adminService.cityMasterSave(cityForm);
			if (cityMasterSave.equalsIgnoreCase("created")) {
				model.addAttribute("created", " City insertion successfull !!!");
				model.addAttribute("cityMaster", new CityForm());
			} else {
				model.addAttribute("created", " City already exists !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("cityMasterSave", "Exception while cityMasterSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "cityMaster";
	}

	@RequestMapping(value = "/cityMasterSave", method = RequestMethod.GET)
	public String showCityForm() {

		return "redirect:cityMaster.fssai";

	}

	@RequestMapping(value = "/regionMappingMaster", method = RequestMethod.GET)
	public String districtMaster(
			@ModelAttribute("regionMappingMaster") RegionForm regionForm, Model model) {
		List<State> stateList = adminService.stateList();
		model.addAttribute("stateList", stateList);
		return "regionMappingMaster";
	}

	@RequestMapping(value = "/regionMasterSave", method = RequestMethod.POST)
	public String regionMasterSave(
			@Valid @ModelAttribute("regionMappingMaster") RegionForm regionForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			new ZLogger("regionMasterSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("regionMasterSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "regionMappingMaster";
		}
		try {
			String regionMasterSave = adminService.regionMasterSave(regionForm);
			if (regionMasterSave.equalsIgnoreCase("Oops")) {
				model.addAttribute("created",
						"Region already mapped with this district !!!");
			} else {
				model.addAttribute("created",
						"Region name successfully mapped !!!");
				model.addAttribute("regionMappingMaster", new RegionForm());
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("regionMasterSave", "Exception while regionMasterSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "regionMappingMaster";
	}

	@RequestMapping(value = "/regionMasterSave", method = RequestMethod.GET)
	public String showregionForm() {

		return "redirect:regionMappingMaster.fssai";

	}

	@RequestMapping(value = "/manageCourse", method = RequestMethod.GET)
	public String districtMaster(
			@ModelAttribute("manageCourse") ManageCourse manageCourse,
			Model model) throws JsonGenerationException, JsonMappingException,
			IOException {
		List<CourseType> courseTypeList = pageLoadService.courseTypeList();
		model.addAttribute("courseTypeList", courseTypeList);
		return "manageCourse";
	}

	@RequestMapping(value = "/manageCourse", method = RequestMethod.POST)
	public String manageCourse(
			@Valid @ModelAttribute("manageCourse") ManageCourse manageCourse,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("manageCourse", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("manageCourse", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "manageCourse";
		}
		try {
			String manageCourse1 = adminService.manageCourse(manageCourse);
			if (manageCourse1.equalsIgnoreCase("created")) {
				model.addAttribute("created",
						"New course inserted successfully !!!");
				model.addAttribute("manageCourse", new ManageCourse());
			} else {
				model.addAttribute("created",
						"This course already inserted !!!");
				model.addAttribute("manageCourse", new ManageCourse());
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("manageCourse", "Exception while manageCourse :  "+ e.getMessage(), "AdminController.java");
		}
		return "redirect:manageCourse.fssai";
	}

	@RequestMapping(value = "/manageTrainingPartnerForm", method = RequestMethod.GET)
	public String manageTrainingPartnerForm(
			@ModelAttribute("manageTrainingPartnerForm") ManageTrainingPartnerForm manageTrainingPartnerForm,Model model) {
		List<State> stateList = adminService.stateList();
		model.addAttribute("stateList", stateList);
		return "manageTrainingPartnerForm";
	}

	@RequestMapping(value = "/manageTrainingPartnerSave", method = RequestMethod.POST)
	public String manageTrainingPartnerSave(
			@Valid @ModelAttribute("manageTrainingPartnerForm") ManageTrainingPartnerForm manageTrainingPartnerForm,
			BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			new ZLogger("manageTrainingPartnerSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("manageTrainingPartnerSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "manageTrainingPartnerForm";
		}
		String email = manageTrainingPartnerForm.getEmail();
		String manageTrainingPartnerSave = adminService
				.manageTrainingPartnerSave(manageTrainingPartnerForm);
		if (manageTrainingPartnerSave != null && !manageTrainingPartnerSave.equalsIgnoreCase("")) {
			String[] all = manageTrainingPartnerSave.split("&");
			model.addAttribute("id", all[1]);
			model.addAttribute("pwd", all[0]);
			new Thread(new Mail("Thanks", email, all[1], all[0], manageTrainingPartnerForm.getTrainingPartnerName())).start();
			return "welcomeManageTrainingPartner";
		} else {
			model.addAttribute("id", "User id created successfully !!");
			model.addAttribute("pwd", "User id created successfully !!");
			return "redirect:manageTrainingPartnerForm";
		}
	}

	@RequestMapping(value = "/manageAssessmentAgencyForm", method = RequestMethod.GET)
	public String manageAssessmentAgencyForm(
			@ModelAttribute("manageAssessmentAgencyForm") ManageAssessmentAgencyForm manageAssessmentAgencyForm,Model model) {
		List<State> stateList = adminService.stateList();
		model.addAttribute("stateList", stateList);
		return "manageAssessmentAgencyForm";
	}

	@RequestMapping(value = "/manageAssessmentAgencySave", method = RequestMethod.POST)
	public String manageAssessmentAgencySave(
			@Valid @ModelAttribute("manageAssessmentAgencyForm") ManageAssessmentAgencyForm manageAssessmentAgencyForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("manageAssessmentAgencySave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("manageAssessmentAgencySave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "manageAssessmentAgencyForm";
		}
		new ZLogger("manageAssessmentAgencySave", " state  "+manageAssessmentAgencyForm.getStateId() , "AdminController.java");
		new ZLogger("manageAssessmentAgencySave", " stcityate  "+ manageAssessmentAgencyForm.getDistrict() , "AdminController.java");
		String manageAssessmentAgencySave = adminService
				.manageAssessmentAgencySave(manageAssessmentAgencyForm);
		if (manageAssessmentAgencySave != null && !manageAssessmentAgencySave.equalsIgnoreCase("")) {
			String[] all = manageAssessmentAgencySave.split("&");
			model.addAttribute("id", all[1]);
			model.addAttribute("pwd", all[0]);
			new Thread(new Mail("Thanks", manageAssessmentAgencyForm.getEmail(), all[1], all[0], manageAssessmentAgencyForm.getAssessmentAgencyName())).start();
			return "welcomeManageTrainingPartner";
		} else {
			model.addAttribute("id", "User id created successfully !!");
			model.addAttribute("pwd", "User id created successfully !!");
			return "redirect:manageAssessmentAgencyForm";
		}
	}

	@RequestMapping(value = "/traineeUserManagementForm", method = RequestMethod.GET)
	public String traineeUserManagementForm(
			@ModelAttribute("traineeUserManagementForm") TraineeUserManagementForm traineeUserManagementForm) {
		return "traineeUserManagementForm";
	}

	@RequestMapping(value = "/traineeUserManagementSearch", method = RequestMethod.POST)
	public String traineeUserManagementSearch(
			@Valid @ModelAttribute("traineeUserManagementForm") TraineeUserManagementForm traineeUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("traineeUserManagementSearch", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("traineeUserManagementSearch", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "traineeUserManagementForm";
		}
		try {
			List<PersonalInformationTrainee> traineeUserManagementSearch = adminService
					.traineeUserManagementSearch(traineeUserManagementForm);
			if (traineeUserManagementSearch != null
					&& traineeUserManagementSearch.size() > 0) {
				model.addAttribute("searchTraineeUsermanagement",
						traineeUserManagementSearch);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("traineeUserManagementSearch", "Exception while traineeUserManagementSearch :  "+ e.getMessage(), "AdminController.java");
		}
		return "traineeUserManagementForm";
	}

	@RequestMapping(value = "/trainerUserManagementForm", method = RequestMethod.GET)
	public String trainerUserManagementForm(
			@ModelAttribute("trainerUserManagementForm") TrainerUserManagementForm trainerUserManagementForm) {
		return "trainerUserManagementForm";
	}

	@RequestMapping(value = "/trainingCenterUserManagementForm", method = RequestMethod.GET)
	public String adminUserManagementForm(
			@ModelAttribute("trainingCenterUserManagementForm") TrainingCenterUserManagementForm trainerUserManagementForm) {
		return "trainingCenterUserManagementForm";
	}

	
	
	@RequestMapping(value = "/assessorUserManagementForm", method = RequestMethod.GET)
	public String assessorUserManagementForm(Model model) {
		try {
			AssessorUserManagementForm assessorUserManagementForm = new AssessorUserManagementForm();
			model.addAttribute("assessorUserManagementForm",
					assessorUserManagementForm);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("assessorUserManagementForm", "Exception while assessorUserManagementForm :  "+ e.getMessage(), "AdminController.java");
		}
		return "assessorUserManagementForm";
	}

	@RequestMapping(value = "/traineeRegistration", method = RequestMethod.GET)
	public String traineeRegistration(Model model) {
		try {
			PersonalInformationTrainee personalInformationTrainee = new PersonalInformationTrainee();
			model.addAttribute("traineeRegistration",
					personalInformationTrainee);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("traineeRegistration", "Exception while traineeRegistration :  "+ e.getMessage(), "AdminController.java");
		}
		return "traineeRegistration";
	}

	@RequestMapping(value = "/adminUserManagementForm", method = RequestMethod.GET)
	public String adminUserManagementForm(Model model) {
		try {
			AdminUserManagementForm adminUserManagementForm = new AdminUserManagementForm();
			model.addAttribute("adminUserManagementForm",
					adminUserManagementForm);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("adminUserManagementForm", "Exception while adminUserManagementForm :  "+ e.getMessage(), "AdminController.java");
		}
		return "adminUserManagementForm";
	}

	@RequestMapping(value = "/adminUserManagementSave", method = RequestMethod.POST)
	public String adminUserManagementSave(
			@Valid @ModelAttribute("adminUserManagementForm") AdminUserManagementForm adminUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("adminUserManagementSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("adminUserManagementSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "adminUserManagementForm";
		}
		try {
			String adminUserManagementSave = adminService
					.adminUserManagementSave(adminUserManagementForm);
			if (adminUserManagementSave.equalsIgnoreCase("created")) {
				model.addAttribute("created", "UserId created successfully !!!");
			} else {
				model.addAttribute("created", "This user Id already exists !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("adminUserManagementSave", "Exception while adminUserManagementSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "adminUserManagementForm";
	}

	@RequestMapping(value = "/assessorUserManagementSave", method = RequestMethod.POST)
	public String assessorUserManagementSave(
			@Valid @ModelAttribute("assessorUserManagementForm") AssessorUserManagementForm assessorUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("assessorUserManagementSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("assessorUserManagementSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "registrationFormAssessor";
		}
		try {
			String assessorUserManagement = adminService
					.assessorUserManagementSave(assessorUserManagementForm);
			if (assessorUserManagement.equalsIgnoreCase("created")) {
				model.addAttribute("created", "UserId created successfully !!!");
			} else {
				model.addAttribute("error", "Already exists !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("assessorUserManagementSave", "Exception while assessorUserManagementSave :  "+ e.getMessage(), "AdminController.java");
		}
		return "registrationFormAssessor";
	}

	@RequestMapping(value = "/manageCourseContent", method = RequestMethod.GET)
	public String manageCourseContent(
			@ModelAttribute("manageCourseContent") ManageCourseContentForm manageCourseContentForm, Model model) {
		new ZLogger("manageCourseContent", "admin Controller manage course content form begin .", "AdminController.java");
		List<CourseType> courseTypeList = pageLoadService.courseTypeList();
		model.addAttribute("courseTypeList", courseTypeList);
		return "manageCourseContent";
	}

	@RequestMapping(value = "/manageCourseContentSearch", method = RequestMethod.POST)
	public String manageCourseContentSearch(
			@Valid @ModelAttribute("manageCourseContent") ManageCourseContentForm manageCourseContentForm,
			BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			new ZLogger("manageCourseContentSearch", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("manageCourseContentSearch", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "manageCourseContent";
		}
		try {
			String manageCourseContentSearch = adminService
					.manageCourseContentSearch(manageCourseContentForm);
			if (manageCourseContentSearch.equalsIgnoreCase("created")) {
				model.addAttribute("created", "Data inserted successfully !!!");
				model.addAttribute("manageCourseContent",
						new ManageCourseContentForm());
			} else {
				model.addAttribute("created", "Data updated successfully !!!");
				model.addAttribute("manageCourseContent",
						new ManageCourseContentForm());
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("manageCourseContentSearch", "Exception while manageCourseContentSearch :  "+ e.getMessage(), "AdminController.java");
		}
		return "redirect:manageCourseContent.fssai";
	}

	@RequestMapping(value = "/trainingCalendarForm", method = RequestMethod.GET)
	public String trainingCalendarForm(Model model) {
		try {
			TrainingCalendarForm trainingCalendarForm = new TrainingCalendarForm();
			List<ManageTrainingPartner> trainingPartnerList = adminService.trainingPartnerList();
			List<CourseType> courseTypeList = pageLoadService.courseTypeList();
			model.addAttribute("courseTypeList", courseTypeList);
			model.addAttribute("trainingCalendarForm", trainingCalendarForm);
			model.addAttribute("trainingPartnerList", trainingPartnerList);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingCalendarForm", "Exception while trainingCalendarForm :  "+ e.getMessage(), "AdminController.java");
		}
		return "trainingCalendarForm";
	}

	@RequestMapping(value = "/trainingCalenderSave", method = RequestMethod.POST)
	public String trainingCalenderSave(
			@Valid @ModelAttribute("trainingCalendarForm") TrainingCalendarForm trainingCalendarForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("trainingCalenderSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("trainingCalenderSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "trainingCalendarForm";
		}
		try {

			String trainingCalendar = adminService
					.trainingCalendarForm(trainingCalendarForm);
			if (trainingCalendar.equalsIgnoreCase("created")) {
				model.addAttribute("created", "Calender saved successfully !!!");
				model.addAttribute("trainingCalendarForm",
						new TrainingCalendarForm());
			} else {
				model.addAttribute("created", "Oops , something went wrong !!!");
				model.addAttribute("trainingCalendarForm",
						new TrainingCalendarForm());
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingCalenderSave", "Exception while trainingCalenderSave :  "+ e.getMessage(), "AdminController.java");
		}

		return "trainingCalendarForm";
	}

	@RequestMapping(value = "/trainerUserManagementSearch", method = RequestMethod.POST)
	public String trainerUserManagementSave(
			@Valid @ModelAttribute("trainerUserManagementForm") TrainerUserManagementForm trainerUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("trainerUserManagementSearch", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("trainerUserManagementSearch", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "trainerUserManagementForm";
		}
		try {
			List<PersonalInformationTrainer> trainerUserManagementSearch = adminService
					.trainerUserManagementSearch(trainerUserManagementForm);
			if (trainerUserManagementSearch != null
					&& trainerUserManagementSearch.size() > 0) {
				model.addAttribute("searchTrainerUsermanagement",
						trainerUserManagementSearch);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainerUserManagementSearch", "Exception while trainerUserManagementSearch :  "+ e.getMessage(), "AdminController.java");
		}
		return "trainerUserManagementForm";
	}

	@RequestMapping(value = "/trainingCetnterUserManagementSearch", method = RequestMethod.POST)
	public String trainingCetnterUserManagementSearch(
			@Valid @ModelAttribute("trainingCenterUserManagementForm") TrainingCenterUserManagementForm trainingCenterUserManagementForm,
			BindingResult result, HttpSession httpSession, Model model) {
		if (result.hasErrors()) {
			new ZLogger("trainingCetnterUserManagementSearch", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("trainingCetnterUserManagementSearch", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "trainingCenterUserManagementForm";
		}
		Integer profileId = 0;
		Integer userId = 0;
		try {
			profileId = (Integer) httpSession.getAttribute("profileId");
			userId = (Integer) httpSession.getAttribute("userId");
			List<PersonalInformationTrainingPartner> trainingCetnterUserManagementSearch = adminService
					.trainingCenterUserManagementSearch(
							trainingCenterUserManagementForm, profileId, userId);
			if (trainingCetnterUserManagementSearch != null
					&& trainingCetnterUserManagementSearch.size() > 0) {
				model.addAttribute("searchTrainingCenterUsermanagement",
						trainingCetnterUserManagementSearch);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingCetnterUserManagementSearch", "Exception while trainingCetnterUserManagementSearch :  "+ e.getMessage(), "AdminController.java");
		
		}
		return "trainingCenterUserManagementForm";
	}

	@RequestMapping(value = "/assessorUserManagementSearch", method = RequestMethod.POST)
	public String assessorUserManagementSearch(
			@Valid @ModelAttribute("assessorUserManagementForm") AssessorUserManagementForm assessorUserManagementForm,
			BindingResult result, HttpSession httpSession, Model model) {
		if (result.hasErrors()) {

			new ZLogger("assessorUserManagementSearch", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("assessorUserManagementSearch", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "assessorUserManagementForm";
		}
		Integer profileId = 0;
		Integer userId = 0;
		try {
			profileId = (Integer) httpSession.getAttribute("profileId");
			userId = (Integer) httpSession.getAttribute("userId");
			List<PersonalInformationAssessor> assessorUserManagementSearch = adminService
					.assessorUserManagementSearch(assessorUserManagementForm,
							profileId, userId);
			if (assessorUserManagementSearch != null
					&& assessorUserManagementSearch.size() > 0) {
				model.addAttribute("searchassessorUsermanagement",
						assessorUserManagementSearch);
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingCetnterUserManagementSearch", "Exception while assessorUserManagementSearch  :  "+ e.getMessage(), "AdminController.java");
		}
		return "assessorUserManagementForm";
	}

	/*@ModelAttribute("searchAdminUserManagement")
	public List<AdminUserManagement> searchAdminUserManagement() {
		List<AdminUserManagement> searchAdminUserManagement = adminService
				.adminUserManagementSearch();
		return searchAdminUserManagement;

	}*/

	/*
	 * @RequestMapping(value="/searchManageCourse") public void getList( Model
	 * model) throws JsonGenerationException, JsonMappingException, IOException{
	 * List<CourseName> courseName = adminService.courseNameList(); ObjectMapper
	 * mapper = new ObjectMapper(); model.addAttribute("courseName",
	 * mapper.writeValueAsString(courseName)); }
	 */
	@RequestMapping(value = "/onLoadTrainingPartnerCenterId")
	public String onLoadTrainingPartnerCenterId(@RequestParam("id") int id,
			HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		new ZLogger("onLoadTrainingPartnerCenterId", "id   ::::  " + id, "AdminController.java");
		req.getRequestDispatcher("onLoadTrainingPartnerCenterId?id=" + id)
				.forward(req, res);
		return "dashboardTrainingPartnerPending";
	}

	// Rishi
	@RequestMapping(value = "/changePasswordAdminPage", method = RequestMethod.GET)
	public String changePasswordAdminPage(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm) {
		return "changePasswordAdminPage";
	}

	@RequestMapping(value = "/changePasswordAdminSave", method = RequestMethod.POST)
	public String changePasswordAdminSave(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,
			HttpSession session, BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("changePasswordAdminSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("changePasswordAdminSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			
			return "changePasswordAdminPage";
		}
		try {
			String id = (String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = adminService
					.changePasswordadminSave(changePasswordForm, id);
			if (changePasswordTraineeSave) {
				model.addAttribute("created", "Your password has changed !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("changePasswordAdminSave", "changePasswordAdminSave Loading Exception "+e.getMessage() , "RegistrationControllerAssessor.java");
		}
		return "changePasswordAdminPage";
	}

	@RequestMapping(value = "/changePasswordTp", method = RequestMethod.GET)
	public String changePasswordTp(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm) {
		return "changePasswordTp";
	}

	@RequestMapping(value = "/changePasswordTPSave", method = RequestMethod.POST)
	public String changePasswordTPSave(
			@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,
			HttpSession session, BindingResult result, Model model) {
		if (result.hasErrors()) {
			new ZLogger("changePasswordTPSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("changePasswordTPSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "changePasswordTp";
		}
		try {
			String id = (String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = adminService
					.changePasswordTPSave(changePasswordForm, id);
			if (changePasswordTraineeSave) {
				model.addAttribute("created", "Your password has changed !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("changePasswordTPSave", "changePasswordTPSave exception  "+e.getMessage(), "AdminController.java");
		}
		return "changePasswordTp";
	}

	@RequestMapping(value = "/contactTPartner", method = RequestMethod.GET)
	public String contactTPP(
			@ModelAttribute("contactTraineee") ContactTrainee contactTrainee) {
		return "contactTPartner";

	}

	@RequestMapping(value = "/feedbackMaster", method = RequestMethod.GET)
	public String feedbackMaster(
			@ModelAttribute("feedbackMaster") FeedbackMaster feedbackMaster,
			HttpSession session, BindingResult result, Model model) {
		return "feedbackMaster";

	}

	@RequestMapping(value = "/saveFeedbackMaster", method = RequestMethod.POST)
	public String saveFeedbackMaster(
			@ModelAttribute("feedbackMaster") FeedbackMaster feedbackMaster,
			HttpSession session, BindingResult result, Model model) {

		if (result.hasErrors()) {
			new ZLogger("saveFeedbackMaster", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("saveFeedbackMaster", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "feedbackMaster";
		}
		try {
			String created = adminService.saveFeedbackMaster(feedbackMaster);
			model.addAttribute("created", created);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("saveFeedbackMaster", "saveFeedbackMaster exception  "+e.getMessage(), "AdminController.java");
		}
		return "feedbackMaster";

	}

	@RequestMapping(value = "/saveFeedbackMaster", method = RequestMethod.GET)
	public String showFeedbackMaster() {

		return "redirect:feedbackMaster.fssai";
	}

	// Rishi
	@RequestMapping(value = "/contactTrainingPTSave", method = RequestMethod.POST)
	public String contactTPSav(
			@ModelAttribute("contactTraineee") ContactTrainee contactTrainee,
			BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			new ZLogger("contactTrainingPTSave", "bindingResult.hasErrors  "+result.hasErrors() , "AdminController.java");
			new ZLogger("contactTrainingPTSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "AdminController.java");
			return "contactTPartner";
		}// String id = contactTrainee.getUserId();

		try {
			String id = (String) session.getAttribute("logId");
			String contactTainingPtSave = adminService.contactTraningPTSave(
					contactTrainee, id);
			if (contactTainingPtSave.equalsIgnoreCase("created")) {
				model.addAttribute("created",
						"Your request has been sent successfully !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("contactTrainingPTSave", "contactTrainingPTSave exception  "+e.getMessage(), "AdminController.java");
			
		}

		return "contactTrainee";
	}

	@RequestMapping(value = "/updateTrainerAssessmentForm", method = RequestMethod.GET)
	public String updateTrainerAssessment(Model model,
			HttpServletRequest request) {
		try {
			UpdateTrainerAssessmentForm updateTrainerAssessmentForm = new UpdateTrainerAssessmentForm();
			model.addAttribute("updateTrainerAssessment",
					updateTrainerAssessmentForm);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("updateTrainerAssessmentForm", "updateTrainerAssessmentForm exception  "+e.getMessage(), "AdminController.java");
		}
		return "updateTrainerAssessment";
	}

	@RequestMapping(value = "/trainingCenterByCoursenameId", method = RequestMethod.POST)
	@ResponseBody
	public String getTrainingCentersByCourse(
			@RequestParam Integer courseNameId, HttpServletRequest request,
			HttpServletResponse response) {
		List<IntStringBean> listTrainingCenters = null;
		String strData = "";
		try {
			listTrainingCenters = adminService
					.getTrainingCentersByCourse(courseNameId);
			Gson gson = new Gson();
			strData = gson.toJson(listTrainingCenters);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("trainingCenterByCoursenameId", "trainingCenterByCoursenameId exception  "+e.getMessage(), "AdminController.java");
		}
		return strData;
	}

	@RequestMapping(value = "/searchTrainerForAssessmentValidation", method = RequestMethod.POST)
	@ResponseBody
	public String searchTrainerForAssessmentValidation(
			@RequestParam Integer courseNameId, @RequestParam Integer tpId,
			HttpServletRequest request, HttpServletResponse response) {
		List<TrainerAssessmentSearchForm> listTrainersForAssessmentEval = null;
		System.out.println("courseNameId "+courseNameId + " tpId "+tpId );
		String strData = "";
		try {
			listTrainersForAssessmentEval = adminService
					.searchTrainerForAssessmentValidation(courseNameId, tpId);
			Gson gson = new Gson();
			strData = gson.toJson(listTrainersForAssessmentEval);
		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("searchTrainerForAssessmentValidation", "searchTrainerForAssessmentValidation exception  "+e.getMessage(), "AdminController.java");
		}
		return strData;
	}

	@RequestMapping(value = "/saveTrainerAssessment", method = RequestMethod.POST)
	@ResponseBody
	public String saveTrainerAssessment(
			@Valid @ModelAttribute("trainerAssessmentForm") TrainerAssessmentSearchForm trainerAssessmentForm,
			Model model) {
		int response = 0;
		try {
			trainerAssessmentForm = adminService
					.evaluateTrainerAssessment(trainerAssessmentForm);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			String date = simpleDateFormat.format(new Date());
			TrainerAssessmentEvaluation trainerAssessmentEvaluation = new TrainerAssessmentEvaluation();
			trainerAssessmentEvaluation.setTrainerId(trainerAssessmentForm
					.getTrainerId());
			trainerAssessmentEvaluation.setCourseNameId(trainerAssessmentForm
					.getCourseNameId());
			trainerAssessmentEvaluation
					.setTrainingPartnerId(trainerAssessmentForm
							.getTrainingPartnerId());
			trainerAssessmentEvaluation.setRating(trainerAssessmentForm
					.getRating());
			trainerAssessmentEvaluation.setResult(trainerAssessmentForm
					.getResult());
			trainerAssessmentEvaluation.setAssessmentDate(date);
			response = adminService
					.saveTrainerAssessment(trainerAssessmentEvaluation);

		} catch (Exception e) {
			e.printStackTrace();
			new ZLogger("saveTrainerAssessment", "saveTrainerAssessment exception  "+e.getMessage(), "AdminController.java");
		}

		if (response > 0)
			return "success";
		else
			return "Error occured while updating the accessment";
	}

	@RequestMapping(value = "/getSingleAssessmentQuestion", method = RequestMethod.GET)
	public String getSingleAssessmentQuestion(Model model,
			HttpServletRequest request) {
		model.addAttribute("updateTrainerAssessment", "Test Ajax");
		return "updateTrainerAssessment";
	}
	
	@RequestMapping("/activateDeActivateTrainer" )
    public String activateDeActivateTrainer(@Valid @ModelAttribute("trainerUserManagementForm") TrainerUserManagementForm trainerUserManagementForm){
		String status = (trainerUserManagementForm.getStatus().equalsIgnoreCase("I")? "N":"Y");
		String tableName = TableLink.getByprofileID(Integer.parseInt(trainerUserManagementForm.getProfileID())).tableName();
        adminService.updateUser(trainerUserManagementForm.getLogindetails() , tableName , status);
		return "redirect:/trainerUserManagementForm.fssai";
    }
	
	@RequestMapping("/activateDeActivateTrainee" )
    public String activateDeActivateTrainee(@Valid @ModelAttribute("traineeUserManagementForm") TraineeUserManagementForm traineeUserManagementForm){
		String status = (traineeUserManagementForm.getStatus().equalsIgnoreCase("I")? "N":"Y");
		String tableName = TableLink.getByprofileID(Integer.parseInt(traineeUserManagementForm.getProfileID())).tableName();
        adminService.updateUser(traineeUserManagementForm.getLogindetails() , tableName , status);
		return "redirect:/traineeUserManagementForm.fssai";
    }
	
	@RequestMapping("/activateDeActivateTrainingCenter" )
    public String activateDeActivateTrainingCenter(@Valid @ModelAttribute("trainingCenterUserManagementForm") TrainingCenterUserManagementForm trainingCenterUserManagementForm){
		
		String status = (trainingCenterUserManagementForm.getStatus().equalsIgnoreCase("I")? "N":"Y");
		String tableName = TableLink.getByprofileID(Integer.parseInt(trainingCenterUserManagementForm.getProfileID())).tableName();
        adminService.updateUser(trainingCenterUserManagementForm.getLogindetails() , tableName , status);
		return "redirect:/trainingCenterUserManagementForm.fssai";
    }
	
	@RequestMapping("/activateDeActivateAssessor" )
    public String activateDeActivateAssessor(@Valid @ModelAttribute("assessorUserManagementForm") AssessorUserManagementForm assessorUserManagementForm){
		new ZLogger("activateDeActivateAssessor", "status "+assessorUserManagementForm.getStatus() + "  profileid "+assessorUserManagementForm.getProfileID(), "AdminController.java");
		new ZLogger("activateDeActivateAssessor", "Login ID Details :  "+assessorUserManagementForm.getLogindetails(), "AdminController.java");
		String status = (assessorUserManagementForm.getStatus().equalsIgnoreCase("I")? "N":"Y");
		String tableName = TableLink.getByprofileID(Integer.parseInt(assessorUserManagementForm.getProfileID())).tableName();
		new ZLogger("activateDeActivateAssessor", TableLink.getByprofileID(Integer.parseInt(assessorUserManagementForm.getProfileID())).tableName(), "AdminController.java");
        adminService.updateUser(assessorUserManagementForm.getLogindetails() , tableName , status);
		return "redirect:/assessorUserManagementForm.fssai";
    }
	
	
	@RequestMapping(value="/loadDistrict" , method=RequestMethod.POST)
	@ResponseBody
	public void getCourseName(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("loadDistrict","loadDistrict............" + data  , "AdminController.java");
		String stateId =  data;
		List districtList = pageLoadService.loadDistrict(stateId);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(districtList); 
		new ZLogger("loadDistrict","newList "+newList , "AdminController.java");
		out.write(newList);
		out.flush();
		
	}
	
//loadCity
	
	@RequestMapping(value="/loadCity" , method=RequestMethod.POST)
	@ResponseBody
	public void loadCity(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("loadCity","loadCity............" + data  , "AdminController.java");
		String districtid =  data;
		List<City> cityList = pageLoadService.loadCity(districtid);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(cityList); 
		new ZLogger("loadCity","newList "+newList , "AdminController.java");
		out.write(newList);
		out.flush();
		
	}
	
	
	@RequestMapping(value="/searchManageCourse" , method=RequestMethod.POST)
	@ResponseBody
	public void searchManageCourse(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchManageCourse","searchManageCourse............" + data  , "AdminController.java");
		List courseList = adminService.searchManageCourse(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	
	@RequestMapping(value="/editManageCourseData" , method=RequestMethod.POST)
	@ResponseBody
	public void editManageCourseData(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("editManageCourseData","editManageCourseData............" + data  , "AdminController.java");
		String courseList = adminService.editManageCourseData(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	
	@RequestMapping(value="/editState" , method=RequestMethod.POST)
	@ResponseBody
	public void editState(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("editState","editState............" + data  , "AdminController.java");
		String courseList = adminService.editState(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//CheckState
	@RequestMapping(value="/CheckState" , method=RequestMethod.POST)
	@ResponseBody
	public void CheckState(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("CheckState","CheckState............" + data  , "AdminController.java");
		String courseList = adminService.CheckState(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	@RequestMapping(value="/searchState" , method=RequestMethod.POST)
	@ResponseBody
	public void searchState(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchState","searchState............" + data  , "AdminController.java");
		List<State> courseList = adminService.searchState(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//onLoadDistrict

	
	@RequestMapping(value="/onLoadDistrict" , method=RequestMethod.POST)
	@ResponseBody
	public void onLoadDistrict(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("onLoadDistrict","onLoadDistrict............" + data  , "AdminController.java");
		List courseList = adminService.onLoadDistrict(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//changeStatusDistrict
	
	@RequestMapping(value="/changeStatusDistrict" , method=RequestMethod.POST)
	@ResponseBody
	public void changeStatusDistrict(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("changeStatusDistrict","changeStatusDistrict............" + data  , "AdminController.java");
		String courseList = adminService.changeStatusDistrict(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchDistrict
	
	@RequestMapping(value="/searchDistrict" , method=RequestMethod.POST)
	@ResponseBody
	public void searchDistrict(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchDistrict","searchDistrict............" + data  , "AdminController.java");
		List courseList = adminService.searchDistrict(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
//editCityData
	
	@RequestMapping(value="/editCityData" , method=RequestMethod.POST)
	@ResponseBody
	public void editCityData(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("editCityData","editCityData............" + data  , "AdminController.java");
		String courseList = adminService.editCityData(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchCity
	
	@RequestMapping(value="/searchCity" , method=RequestMethod.POST)
	@ResponseBody
	public void searchCity(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchCity","searchCity............" + data  , "AdminController.java");
		List courseList = adminService.searchCity(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//onLoadRegion
	
	
	@RequestMapping(value="/onLoadRegion" , method=RequestMethod.POST)
	@ResponseBody
	public void onLoadRegion(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("onLoadRegion","onLoadRegion............" + data  , "AdminController.java");
		List courseList = adminService.onLoadRegion(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	//editRegionData
	

	@RequestMapping(value="/editRegionData" , method=RequestMethod.POST)
	@ResponseBody
	public void editRegionData(@RequestParam("data") String data ,  Model model,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("editRegionData","editRegionData............" + data  , "AdminController.java");
		String courseList = adminService.editRegionData(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		
		out.write(newList);
		out.flush();
		
	}
	
	
	@RequestMapping(value="/traineeAssessmentCalender" , method=RequestMethod.POST)
	@ResponseBody
	public void traineeAssessmentCalender(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("traineeAssessmentCalender","traineeAssessmentCalender............" + data  , "AdminController.java");
		List courseList = adminService.traineeAssessmentCalender(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//getQuestions

	@RequestMapping(value="/getQuestions" , method=RequestMethod.POST)
	@ResponseBody
	public void getQuestions(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("traineeAssessmentCalender","traineeAssessmentCalender............" + data  , "AdminController.java");
		List courseList = adminService.getQuestions(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchFeedbackMaster
	
	@RequestMapping(value="/searchFeedbackMaster" , method=RequestMethod.POST)
	@ResponseBody
	public void searchFeedbackMaster(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchFeedbackMaster","searchFeedbackMaster............" + data  , "AdminController.java");
		List courseList = adminService.searchFeedbackMaster(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchAssessmentAgencyList
	
	@RequestMapping(value="/searchAssessmentAgencyList" , method=RequestMethod.POST)
	@ResponseBody
	public void searchAssessmentAgencyList(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchAssessmentAgencyList","searchAssessmentAgencyList............" + data  , "AdminController.java");
		List courseList = adminService.searchAssessmentAgencyList(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//searchAssessorDetail
	
	
	@RequestMapping(value="/searchAssessorDetail" , method=RequestMethod.POST)
	@ResponseBody
	public void searchAssessorDetail(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("searchAssessorDetail","searchAssessorDetail............" + data  , "AdminController.java");
		List courseList = adminService.searchAssessorDetail(data);
		PrintWriter out = response.getWriter();
		Gson g =new Gson();
		String newList = g.toJson(courseList); 
		System.out.println("newList "+newList);
		out.write(newList);
		out.flush();
		
	}
	
	//changeAssessor
	
	
	@RequestMapping(value="/changeAssessor" , method=RequestMethod.POST)
	@ResponseBody
	public void changeAssessor(@RequestParam("data") String data ,@RequestBody GenerateCourseCertificateForm generateCourseCertificateForm,HttpServletRequest httpServletRequest, HttpServletResponse response) throws IOException{
		new ZLogger("changeAssessor","changeAssessor............" + data  , "AdminController.java");
		String result = adminService.changeAssessor(data);
		PrintWriter out = response.getWriter();
		
		System.out.println("newList "+result);
		out.write(result);
		out.flush();
		
	}
}
