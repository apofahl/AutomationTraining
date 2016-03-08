package com.xpanxion.automation.dummyapp.spring;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class DefaultNamingStrategy extends ImprovedNamingStrategy {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2860624524377441004L;

	@Override
	public String columnName(String columnName) {
		return columnName;
	}
}
