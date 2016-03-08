package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_SERVICE")
public class Service implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Service_Type", nullable = false)
	private int serviceType;
	@Id
	@Column(name= "Stylist_ID", nullable = false)
	private String stylistId;
	@Column(name= "Service_Price", nullable = false)
	private double price;
	@Column(name= "Service_Time", nullable = false)
	private int time;
	
	public int getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(int serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getStylistId() {
		return stylistId;
	}
	
	public void setStylistId(String stylistId) {
		this.stylistId = stylistId;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
}
