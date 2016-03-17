package com.xpanxion.automation.dummyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.xpanxion.automation.dummyapp.model.Salon;
import com.xpanxion.automation.dummyapp.model.ServiceType;

public interface SalonRepository  extends Repository<Salon, String> {
	
	List<Salon> findAll();
	
	Salon findByLicNum(String licNum);
	
	@Query("SELECT s FROM ServiceType s WHERE s.id IN (SELECT serviceType FROM Service WHERE stylist IN (SELECT licNum FROM Stylist WHERE salon = ?1))")
	List<ServiceType> findServiceTypesBySalon(Salon salon);

}
