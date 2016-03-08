package com.xpanxion.automation.dummyapp.dao;

import java.util.List;

import com.xpanxion.automation.dummyapp.model.Stylist;

public interface AutoDao {

	/**
	 * Gets all stylists
	 * 
	 * @return all stylists
	 */
	List<Stylist> getAllStylists();
}
