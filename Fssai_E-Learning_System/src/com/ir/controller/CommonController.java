package com.ir.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ir.service.CommonService;

@Controller
public class CommonController {

	@Autowired
	@Qualifier("commonService")
	CommonService commonService;
	
	@RequestMapping(value= "/getCourseTrainingType", method=RequestMethod.POST)	
	@ResponseBody
	public String getCourseTrainingType(@RequestParam String courseNameId, Model model , HttpSession session){
		
		String modeOfTraining = commonService.getCourseTrainingType(courseNameId);
		return modeOfTraining;
	}
}
