package com.xpanxion.automation.dummyapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xpanxion.automation.dummyapp.model.Stylist;

public interface StylistService {

	/**
	 * Get all stylists
	 * 
	 * @return all stylists
	 */
	List<Stylist> getAllStylists();

}
