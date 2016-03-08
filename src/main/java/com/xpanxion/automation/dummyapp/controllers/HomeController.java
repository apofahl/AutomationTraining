package com.xpanxion.automation.dummyapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xpanxion.automation.dummyapp.repository.ServiceTypeRepository;
import com.xpanxion.automation.dummyapp.repository.StylistRepository;

@Controller
public class HomeController {
	
	@Autowired
	private StylistRepository stylistRepo;
	@Autowired
	private ServiceTypeRepository serviceTypeRepo;

//    @RequestMapping("/")
//    public String greeting(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true) String password, Model model) {
//        return "greeting";
//    }
    
    @RequestMapping("/")
    public String greeting(Model model) {
    	model.addAttribute("serviceTypeList", stylistRepo.findAll());
        return "greeting";
    }
	
//  @RequestMapping("/")
//  public String greeting(Model model) {
//      return "greeting";
//  }

}
