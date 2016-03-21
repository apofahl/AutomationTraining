package com.xpanxion.automation.dummyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.xpanxion.automation.dummyapp.model.Service;
import com.xpanxion.automation.dummyapp.model.Stylist;

public interface StylistRepository extends Repository<Stylist, String> {
	
	List<Stylist> findAll();
	
	List<Stylist> findByFirstNameAndLastName(String firstName, String lastName);
	
	Stylist findByLicNum(String licNum);
	
	@Query("SELECT s FROM Service s WHERE stylist = ?1")
	List<Service> findServices(Stylist stylist);

//	List<Stylist> findBySalonZipcode(String zipcode);
}
