package com.xpanxion.automation.dummyapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @RequestMapping("/")
//    public String greeting(@RequestParam(value="username", required=true) String username, @RequestParam(value="password", required=true) String password, Model model) {
//        return "greeting";
//    }
    
    @RequestMapping("/")
    public String greeting(Model model) {
    	List<Stylist> stylistList = stylistRepo.findAll();
    	List<Salon> salonList = salonRepo.findAll();
    	model.addAttribute("stylistList", stylistList);
    	model.addAttribute("salonList", salonList);
        return "greeting";
    }
    
    @RequestMapping("/salon")
    public String salonProfile(Model model) {
    	Salon salon = salonRepo.findByLicNum("73C6204JW");
    	List<Stylist> list = salon.getStylists();
    	List<ServiceType> serviceList = salonRepo.findServiceTypesBySalon(salon);
    	model.addAttribute("stylistList", list);
    	model.addAttribute("serviceList", serviceList);
        return "salonProfile";
    }
    
    @RequestMapping("/stylist")
    public String stylistProfile(Model model) {
//    	Stylist stylist = stylistRepo.findByLicNum("120938");
    	Stylist stylist = stylistRepo.findByLicNum("109283");
    	List<Service> serviceList = stylistRepo.findServices(stylist);
    	List<Review> reviewList = stylist.getReviews();
    	model.addAttribute("stylist", stylist);
    	model.addAttribute("serviceList", serviceList);
    	model.addAttribute("reviewList", reviewList);
        return "stylistProfile";
    }
	
//  @RequestMapping("/")
//  public String greeting(Model model) {
//      return "greeting";
//  }

}
