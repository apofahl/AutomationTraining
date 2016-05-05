package com.xpanxion.automation.dummyapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xpanxion.automation.dummyapp.model.Salon;
import com.xpanxion.automation.dummyapp.model.Service;
import com.xpanxion.automation.dummyapp.model.ServiceType;
import com.xpanxion.automation.dummyapp.model.Stylist;
import com.xpanxion.automation.dummyapp.repository.SalonRepository;
import com.xpanxion.automation.dummyapp.repository.StylistRepository;

@Controller
public class ClientController {
	
	@Autowired
	private StylistRepository stylistRepo;
	@Autowired
	private SalonRepository salonRepo;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping("/logout")
    public String logout(Model model) {
        return "logout";
    }
    
    @RequestMapping("/")
    public String greeting(Model model) {
    	List<Stylist> stylistList = stylistRepo.findAll();
    	List<Salon> salonList = salonRepo.findAll();
    	model.addAttribute("stylistList", stylistList);
    	model.addAttribute("salonList", salonList);
        return "home";
    }
    
    @RequestMapping("/salons/{salonId}")
    public String salonProfile(@PathVariable String salonId, Model model) {
    	Salon salon = salonRepo.findByLicNum(salonId);
    	List<ServiceType> serviceList = salonRepo.findServiceTypesBySalon(salon);
    	model.addAttribute("salon", salon);
    	model.addAttribute("serviceList", serviceList);
        return "salonProfile";
    }
    
    @RequestMapping("/stylists/{stylistId}")
    public String stylistProfile(@PathVariable String stylistId, Model model) {
    	Stylist stylist = stylistRepo.findByLicNum(stylistId);
    	List<Service> serviceList = stylistRepo.findServices(stylist);
    	model.addAttribute("stylist", stylist);
    	model.addAttribute("serviceList", serviceList);
        return "stylistProfile";
    }
    
    @RequestMapping("/stylists")
    public String stylists(Model model) {
    	List<Stylist> stylistList = stylistRepo.findAll();
    	model.addAttribute("stylistList", stylistList);
        return "stylists";
    }
    
    @RequestMapping("/salons")
    public String salons(Model model) {
    	List<Salon> salonList = salonRepo.findAll();
    	model.addAttribute("salonList", salonList);
        return "salons";
    }
	
	@RequestMapping("/search")
	public String search(Model model) {
		return "search";
	}

}
