package com.ir.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import com.ir.model.ActivateDeActivateUsersForm;
import com.ir.model.AdminUserManagement;
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
import com.ir.model.TrainingPartnerCalendarForm;
import com.ir.model.admin.TrainerAssessmentSearchForm;
import com.ir.model.trainer.TrainerAssessmentEvaluation;
import com.ir.service.AdminService;
import com.ir.util.GenerateUniqueID;
import com.ir.util.JavaMail;
import com.ir.util.SendContectMail;

@Controller
public class AdminController {

	@Autowired
	@Qualifier("adminService")
	AdminService adminService;

	@ModelAttribute("stateList")
	public List<State> stateList() {
		List<State> stateList = null;
		try {
			stateList = adminService.stateList();
			System.out.println("state list   :   " + stateList);
		} catch (Exception e) {
			e.printStackTrace();
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
		}
		return courseTypeList;
	}

	@RequestMapping(value = "/stateMaster", method = RequestMethod.GET)
	public String stateMaster(
			@ModelAttribute("stateMaster") StateForm stateForm, Model model,
			HttpSession session) {
		try {
			model.addAttribute("created", " ");
			session.setAttribute("created", " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stateMaster";
	}

	@RequestMapping(value = "/stateMasterSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("stateMaster") StateForm stateForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "stateMaster";
		}
		try {
			String stateMasterSave = adminService.stateMasterSave(stateForm);
			if (stateMasterSave.equalsIgnoreCase("created")) {
				model.addAttribute("created",
						" State insertion successfull !!!");
				// session.setAttribute("created"," State insertion successfull !!!");
				model.addAttribute("stateMaster", new StateForm());
			} else {
				model.addAttribute("created",
						"State already exists in reord !!!");
				// session.setAttribute("created" ,
				// "State already exists in reord !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		try {
			model.addAttribute("created", " ");
			session.setAttribute("created", " ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "districtMaster";
	}

	@RequestMapping(value = "/manageAssessmentQuestions", method = RequestMethod.GET)
	public String manageAssessmentQuestions(
			@ModelAttribute("assessmentQuestionForm") AssessmentQuestionForm assessmentQuestionForm) {
		return "manageAssessmentQuestions";
	}

	@RequestMapping(value = "/manageAssessmentQuestionsSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("assessmentQuestionForm") AssessmentQuestionForm assessmentQuestionForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "manageAssessmentQuestions";
	}

	@RequestMapping(value = "/districtMasterSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("districtMaster") DistrictForm districtForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "districtMaster";
	}

	@RequestMapping(value = "/districtMasterSave", method = RequestMethod.GET)
	public String showDistrctForm() {

		return "redirect:districtMaster.fssai";
	}

	@RequestMapping(value = "/cityMaster", method = RequestMethod.GET)
	public String districtMaster(@ModelAttribute("cityMaster") CityForm cityForm) {
		return "cityMaster";
	}

	@RequestMapping(value = "/cityMasterSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("cityMaster") CityForm cityForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "cityMaster";
	}

	@RequestMapping(value = "/cityMasterSave", method = RequestMethod.GET)
	public String showCityForm() {

		return "redirect:cityMaster.fssai";

	}

	@RequestMapping(value = "/regionMappingMaster", method = RequestMethod.GET)
	public String districtMaster(
			@ModelAttribute("regionMappingMaster") RegionForm regionForm) {
		return "regionMappingMaster";
	}

	@RequestMapping(value = "/regionMasterSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("regionMappingMaster") RegionForm regionForm,
			BindingResult result, Model model, HttpSession session) {

		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		return "manageCourse";
	}

	@RequestMapping(value = "/manageCourse", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("manageCourse") ManageCourse manageCourse,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "manageCourse";
	}

	@RequestMapping(value = "/manageTrainingPartnerForm", method = RequestMethod.GET)
	public String manageTrainingPartnerForm(
			@ModelAttribute("manageTrainingPartnerForm") ManageTrainingPartnerForm manageTrainingPartnerForm) {
		return "manageTrainingPartnerForm";
	}

	@RequestMapping(value = "/manageTrainingPartnerSave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("manageTrainingPartnerForm") ManageTrainingPartnerForm manageTrainingPartnerForm,
			BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "manageTrainingPartnerForm";
		}
		String email = manageTrainingPartnerForm.getEmail();
		String manageTrainingPartnerSave = adminService
				.manageTrainingPartnerSave(manageTrainingPartnerForm);
		if (!manageTrainingPartnerSave.equalsIgnoreCase("")) {
			String[] all = manageTrainingPartnerSave.split("&");
			model.addAttribute("id", all[1]);
			model.addAttribute("pwd", all[0]);
			JavaMail javaMail = new JavaMail();
			javaMail.mailProperty("Thanks",
					email,all[1] , all[0],manageTrainingPartnerForm.getTrainingPartnerName());
			/*Thread t1 = new Thread(new Runnable() {
				public void run() {
					// code goes here.
					
				}
			});
			t1.start();*/
			// javaMail.mailProperty("Thanks",
			// manageTrainingPartnerForm.getEmail(),
			// manageTrainingPartnerForm.getUserId());

			return "welcomeManageTrainingPartner";
		} else {
			model.addAttribute("id", "User id created successfully !!");
			model.addAttribute("pwd", "User id created successfully !!");
			return "redirect:manageTrainingPartnerForm";
		}
	}

	@RequestMapping(value = "/manageAssessmentAgencyForm", method = RequestMethod.GET)
	public String manageAssessmentAgencyForm(
			@ModelAttribute("manageAssessmentAgencyForm") ManageAssessmentAgencyForm manageAssessmentAgencyForm) {
		return "manageAssessmentAgencyForm";
	}

	@RequestMapping(value = "/manageAssessmentAgencySave", method = RequestMethod.POST)
	public String stateSave(
			@Valid @ModelAttribute("manageAssessmentAgencyForm") ManageAssessmentAgencyForm manageAssessmentAgencyForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "manageAssessmentAgencyForm";
		}
		System.out.println("state  " + manageAssessmentAgencyForm.getStateId());
		System.out.println("district  " + manageAssessmentAgencyForm.getCity());
		System.out.println("stcityate  "
				+ manageAssessmentAgencyForm.getDistrict());
		String manageAssessmentAgencySave = adminService
				.manageAssessmentAgencySave(manageAssessmentAgencyForm);
		if (!manageAssessmentAgencySave.equalsIgnoreCase("")) {
			String[] all = manageAssessmentAgencySave.split("&");
			model.addAttribute("id", all[1]);
			model.addAttribute("pwd", all[0]);
			JavaMail javaMail = new JavaMail();
			javaMail.mailProperty("Thanks",
					manageAssessmentAgencyForm.getEmail(),
					all[1],all[0] ,manageAssessmentAgencyForm.getAssessmentAgencyName() );

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
	public String traineeUserManagementSave(
			@Valid @ModelAttribute("traineeUserManagementForm") TraineeUserManagementForm traineeUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "traineeUserManagementForm";
		}
		try {
			List<PersonalInformationTrainee> traineeUserManagementSearch = adminService
					.traineeUserManagementSearch(traineeUserManagementForm);
			// System.out.println("traineeUserManagementSearch controller"
			// +traineeUserManagementSearch.get(0).getLoginDetails().getLoginId());
			if (traineeUserManagementSearch != null
					&& traineeUserManagementSearch.size() > 0) {
				model.addAttribute("searchTraineeUsermanagement",
						traineeUserManagementSearch);
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	@ModelAttribute("userId")
	public String getUniqueId(){
		String uniqueID = GenerateUniqueID.getNextCombinationId("ADM", "adminusermanagement" , "00");		
		System.out.println(" Admin ID " + uniqueID);
		return uniqueID;
	}
	
	@RequestMapping(value = "/assessorUserManagementForm", method = RequestMethod.GET)
	public String assessorUserManagementForm(Model model) {
		try {
			AssessorUserManagementForm assessorUserManagementForm = new AssessorUserManagementForm();
			model.addAttribute("assessorUserManagementForm",
					assessorUserManagementForm);
		} catch (Exception e) {
			e.printStackTrace();
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
		}
		return "adminUserManagementForm";
	}

	@RequestMapping(value = "/adminUserManagementSave", method = RequestMethod.POST)
	public String adminUserManagementSave(
			@Valid @ModelAttribute("adminUserManagementForm") AdminUserManagementForm adminUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "adminUserManagementForm";
	}

	@RequestMapping(value = "/assessorUserManagementSave", method = RequestMethod.POST)
	public String assessorUserManagementSave(
			@Valid @ModelAttribute("assessorUserManagementForm") AssessorUserManagementForm assessorUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "registrationFormAssessor";
	}

	@RequestMapping(value = "/manageCourseContent", method = RequestMethod.GET)
	public String manageCourseContent(
			@ModelAttribute("manageCourseContent") ManageCourseContentForm manageCourseContentForm) {
		System.out
				.println("admin Controller manage course content form begin .");
		return "manageCourseContent";
	}

	@RequestMapping(value = "/manageCourseContentSearch", method = RequestMethod.POST)
	public String manageCourseContentSearch(
			@Valid @ModelAttribute("manageCourseContent") ManageCourseContentForm manageCourseContentForm,
			BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "manageCourseContent";
	}

	@RequestMapping(value = "/trainingCalendarForm", method = RequestMethod.GET)
	public String trainingCalendarForm(Model model) {
		try {
			TrainingCalendarForm trainingCalendarForm = new TrainingCalendarForm();
			model.addAttribute("trainingCalendarForm", trainingCalendarForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "trainingCalendarForm";
	}

	@RequestMapping(value = "/trainingCalenderSave", method = RequestMethod.POST)
	public String trainingCalenderSave(
			@Valid @ModelAttribute("trainingCalendarForm") TrainingCalendarForm trainingCalendarForm,
			BindingResult result, Model model) {
		System.out.println("kkkkkk");
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "trainingCalendarForm";
		}
		try {
			System.out.println(trainingCalendarForm.getTrainingStartDate() + "   "
					+ trainingCalendarForm.getTrainingEndDate());
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
		}

		return "trainingCalendarForm";
	}

	@RequestMapping(value = "/trainerUserManagementSearch", method = RequestMethod.POST)
	public String trainerUserManagementSave(
			@Valid @ModelAttribute("trainerUserManagementForm") TrainerUserManagementForm trainerUserManagementForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
		}
		return "trainerUserManagementForm";
	}

	@RequestMapping(value = "/trainingCetnterUserManagementSearch", method = RequestMethod.POST)
	public String trainingCetnterUserManagementSearch(
			@Valid @ModelAttribute("trainingCenterUserManagementForm") TrainingCenterUserManagementForm trainingCenterUserManagementForm,
			BindingResult result, HttpSession httpSession, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
			System.out.println("Exception while course details save : "
					+ e.getMessage());
		}
		return "trainingCenterUserManagementForm";
	}

	@RequestMapping(value = "/assessorUserManagementSearch", method = RequestMethod.POST)
	public String assessorUserManagementSearch(
			@Valid @ModelAttribute("assessorUserManagementForm") AssessorUserManagementForm assessorUserManagementForm,
			BindingResult result, HttpSession httpSession, Model model) {
		if (result.hasErrors()) {
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
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
			System.out.println("Exception while course details save : "
					+ e.getMessage());
		}
		return "assessorUserManagementForm";
	}

	@ModelAttribute("searchAdminUserManagement")
	public List<AdminUserManagement> searchAdminUserManagement() {
		List<AdminUserManagement> searchAdminUserManagement = adminService
				.adminUserManagementSearch();
		return searchAdminUserManagement;

	}

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
		System.out.println("id   ::::  " + id);
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
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "changePasswordAdminPage";
		}
		try {
			String id = (String) session.getAttribute("logId");
			// System.out.println(changePasswordForm.getLoginid());
			// int id = 1;
			boolean changePasswordTraineeSave = adminService
					.changePasswordadminSave(changePasswordForm, id);
			if (changePasswordTraineeSave) {
				model.addAttribute("created", "Your password has changed !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "changePasswordTp";
		}
		try {
			String id = (String) session.getAttribute("logId");
			// System.out.println(changePasswordForm.getLoginid());
			// int id = 1;
			boolean changePasswordTraineeSave = adminService
					.changePasswordTPSave(changePasswordForm, id);
			if (changePasswordTraineeSave) {
				model.addAttribute("created", "Your password has changed !!!");
			} else {
				model.addAttribute("created", "Oops, something went wrong !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "feedbackMaster";
		}
		try {
			String created = adminService.saveFeedbackMaster(feedbackMaster);
			model.addAttribute("created", created);
		} catch (Exception e) {
			e.printStackTrace();
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
			System.out
					.println(" bindingResult.hasErrors " + result.hasErrors());
			System.out.println(result.getErrorCount());
			System.out.println(result.getAllErrors());
			return "contactTPartner";
		}// String id = contactTrainee.getUserId();

		try {
			String id = (String) session.getAttribute("logId");
			System.out.println("userid   " + id);
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
		}
		return strData;
	}

	@RequestMapping(value = "/searchTrainerForAssessmentValidation", method = RequestMethod.POST)
	@ResponseBody
	public String searchTrainerForAssessmentValidation(
			@RequestParam Integer courseNameId, @RequestParam Integer tpId,
			HttpServletRequest request, HttpServletResponse response) {
		List<TrainerAssessmentSearchForm> listTrainersForAssessmentEval = null;
		String strData = "";
		try {
			listTrainersForAssessmentEval = adminService
					.searchTrainerForAssessmentValidation(courseNameId, tpId);
			Gson gson = new Gson();
			strData = gson.toJson(listTrainersForAssessmentEval);
		} catch (Exception e) {
			e.printStackTrace();
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
		System.out.println("inside activateDeActivateUsers ");
		System.out.println("Login ID Details :  "+assessorUserManagementForm.getLogindetails());
		System.out.println("status "+assessorUserManagementForm.getStatus() + "  profileid "+assessorUserManagementForm.getProfileID());
		String status = (assessorUserManagementForm.getStatus().equalsIgnoreCase("I")? "N":"Y");
		String tableName = TableLink.getByprofileID(Integer.parseInt(assessorUserManagementForm.getProfileID())).tableName();
		System.out.println(TableLink.getByprofileID(Integer.parseInt(assessorUserManagementForm.getProfileID())).tableName());
        adminService.updateUser(assessorUserManagementForm.getLogindetails() , tableName , status);
		return "redirect:/assessorUserManagementForm.fssai";
    }
	
	

}
