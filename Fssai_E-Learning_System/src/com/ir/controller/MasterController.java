/*package com.ir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zentech.spring.hb.model.NState;
import com.zentech.spring.service.MasterService;


@Controller
public class MasterController {
	
	private MasterService masterService;
	*//**
	 * @param masterService the masterService to set
	 *//*
	@Autowired(required=true)
	@Qualifier(value="masterService")
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	
	
	//NState -----------------------------------------------------------------------------------
	@RequestMapping(value = "/States", method = RequestMethod.GET)
	public String listNStates(Model model) {
		model.addAttribute("State", new NState());
		model.addAttribute("listStates", this.masterService.listStates());
		return "State";
	}
	
	//For add and update NState both
	@RequestMapping(value= "/State/add", method = RequestMethod.POST)
	public String addNState(@ModelAttribute("State") NState p){
		if(p.getId() == 0){
			//new person, add it
			this.masterService.addState(p);
		}else{
			//existing person, call update
			this.masterService.updateState(p);
		}
		return "redirect:/States";
	}
	
	@RequestMapping("/State/remove/{id}")
    public String removeNState(@PathVariable("id") int id){
		
        this.masterService.removeState(id);
        return "redirect:/States";
    }
 
    @RequestMapping("State/edit/{id}")
    public String editNState(@PathVariable("id") int id, Model model){
        model.addAttribute("State", this.masterService.getStateById(id));
        model.addAttribute("listStates", this.masterService.listStates());
        return "State";
    }
    
    
 
      
}
*/