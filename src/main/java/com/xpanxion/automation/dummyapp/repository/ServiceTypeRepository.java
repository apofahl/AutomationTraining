package com.xpanxion.automation.dummyapp.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.xpanxion.automation.dummyapp.model.ServiceType;

public interface ServiceTypeRepository extends Repository<ServiceType, Long>{

	List<ServiceType> findAll();
}
