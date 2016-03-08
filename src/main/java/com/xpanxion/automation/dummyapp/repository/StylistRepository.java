package com.xpanxion.automation.dummyapp.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.xpanxion.automation.dummyapp.model.Stylist;

public interface StylistRepository extends Repository<Stylist, String> {
	
	List<Stylist> findAll();
	
	List<Stylist> findByFirstNameAndLastName(String firstName, String lastName);

//	List<Stylist> findBySalonZipcode(String zipcode);
}
