package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_SALON")
public class Salon implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name= "Salon_LicNum", nullable = false)
	private String licNum;
	@Column(name= "Salon_Name", nullable = false)
	private String name;
	@Column(name= "Salon_Phone", nullable = false)
	private String phone;
	@Column(name= "Salon_Street")
	private String street;
	@Column(name= "Salon_City")
	private String city;
	@Column(name= "Salon_State")
	private String state;
	@Column(name= "Salon_Zip", nullable = false)
	private String zip;
	
	
	public String getLicNum() {
		return licNum;
	}
	
	public void setLicNum(String licNum) {
		this.licNum = licNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}

}
