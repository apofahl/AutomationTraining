package com.xpanxion.automation.dummyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xpanxion.automation.dummyapp.services.StylistService;

@Controller
public class HomeController {
	
	private StylistService stylistService;
	
	@Autowired
	public HomeController(StylistService styleServ) {
		stylistService = styleServ;
	}

//    @RequestMapping("/")
//    public String greeting(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true) String password, Model model) {
//        return "greeting";
//    }
    
    @RequestMapping("/")
    public String greeting(Model model) {
    	model.addAttribute("stylistList", stylistService.getAllStylists());
        return "greeting";
    }
	
//  @RequestMapping("/")
//  public String greeting(Model model) {
//      return "greeting";
//  }

}
