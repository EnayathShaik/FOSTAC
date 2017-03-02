package com.ir.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.ir.form.ChangePasswordForm;
import com.ir.service.CommonService;
import com.zentech.logger.ZLogger;

@Controller
public class CommonController {

	@Autowired
	@Qualifier("commonService")
	CommonService commonService;
	
	@RequestMapping(value= "/getCourseTrainingType", method=RequestMethod.POST)	
	@ResponseBody
	public String getCourseTrainingType(@RequestParam String courseNameId, Model model , HttpSession session){
		String modeOfTraining = "";
		try{
			modeOfTraining = commonService.getCourseTrainingType(courseNameId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return modeOfTraining;
	}
	
	@RequestMapping(value="/changePasswordSave" , method=RequestMethod.POST)
	public String changePasswordTraineeSave(@ModelAttribute("changePasswordForm") ChangePasswordForm changePasswordForm,HttpSession session
			,BindingResult result , Model model
			){
		if(result.hasErrors()){
			new ZLogger("changePasswordSave", "bindingResult.hasErrors  "+result.hasErrors() , "CommonController.java");
			new ZLogger("changePasswordSave", "bindingResult.hasErrors  "+result.getErrorCount() +" All Errors "+result.getAllErrors(), "CommonController.java");
			return "changePasswordTrainee";
		}
		
		try{
			String id =(String) session.getAttribute("logId");
			boolean changePasswordTraineeSave = commonService.changePasswordSave(changePasswordForm , id);
			if(changePasswordTraineeSave){
				model.addAttribute("created" , "Your password has changed !!!");
			}else{
				model.addAttribute("created" , "Oops, something went wrong !!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			new ZLogger("changePasswordSave", " Exception while changePasswordSave  "+e.getMessage() , "CommonController.java");
		}
		return "changePasswordTrainee";
	}
}
