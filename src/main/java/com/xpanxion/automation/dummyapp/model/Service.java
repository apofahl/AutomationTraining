package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_SERVICE")
public class Service implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(optional=false)
    @JoinColumn(name="Service_Type",referencedColumnName="Type_ID")
	private ServiceType serviceType;
	@Id
	@ManyToOne(optional=false)
    @JoinColumn(name="Stylist_ID",referencedColumnName="Stylist_LicNum")
	private Stylist stylist;
	@Column(name= "Service_Price", nullable = false)
	private double price;
	@Column(name= "Service_Time", nullable = false)
	private int time;
	
	public ServiceType getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
	
	public Stylist getStylist() {
		return stylist;
	}
	
	public void setStylistId(Stylist stylist) {
		this.stylist = stylist;
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
