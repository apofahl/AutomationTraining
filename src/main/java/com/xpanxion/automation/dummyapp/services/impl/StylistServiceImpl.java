package com.xpanxion.automation.dummyapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpanxion.automation.dummyapp.dao.AutoDao;
import com.xpanxion.automation.dummyapp.model.Stylist;
import com.xpanxion.automation.dummyapp.services.StylistService;

@Service("stylistService")
public class StylistServiceImpl implements StylistService {
	
	@Autowired
	private AutoDao dao;

	public List<Stylist> getAllStylists() {
		return dao.getAllStylists();
	}
}
