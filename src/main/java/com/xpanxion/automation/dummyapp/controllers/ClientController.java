package com.xpanxion.automation.dummyapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xpanxion.automation.dummyapp.model.Review;
import com.xpanxion.automation.dummyapp.model.Salon;
import com.xpanxion.automation.dummyapp.model.Service;
import com.xpanxion.automation.dummyapp.model.ServiceType;
import com.xpanxion.automation.dummyapp.model.Stylist;
import com.xpanxion.automation.dummyapp.repository.SalonRepository;
import com.xpanxion.automation.dummyapp.repository.ServiceTypeRepository;
import com.xpanxion.automation.dummyapp.repository.StylistRepository;

@Controller
public class ClientController {
	
	@Autowired
	private StylistRepository stylistRepo;
	@Autowired
	private ServiceTypeRepository serviceTypeRepo;
	@Autowired
	private SalonRepository salonRepo;

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @RequestMapping("/logout")
    public String logout(Model model) {
        return "home";
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
    	List<Stylist> list = salon.getStylists();
    	List<ServiceType> serviceList = salonRepo.findServiceTypesBySalon(salon);
    	model.addAttribute("salon", salon);
    	model.addAttribute("serviceList", serviceList);
        return "salonProfile";
    }
    
    @RequestMapping("/stylists/{stylistId}")
    public String stylistProfile(@PathVariable String stylistId, Model model) {
//    	Stylist stylist = stylistRepo.findByLicNum("120938");
    	Stylist stylist = stylistRepo.findByLicNum(stylistId);
    	List<Service> serviceList = stylistRepo.findServices(stylist);
    	List<Review> reviewList = stylist.getReviews();
    	model.addAttribute("stylist", stylist);
    	model.addAttribute("serviceList", serviceList);
//    	model.addAttribute("reviewList", reviewList);
        return "stylistProfile";
    }
	
	@RequestMapping("/search")
	public String search(Model model) {
		return "search";
	}

}
