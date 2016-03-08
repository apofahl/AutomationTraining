package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_STYLIST")
public class Stylist implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Stylist_LicNum", nullable = false)
	private String licNum;
	@Column(name= "Stylist_FName", nullable = false)
	private String firstName;
	@Column(name= "Stylist_LName", nullable = false)
	private String lastName;
	@Column(name= "Stylist_Phone")
	private String phone;
	@Column(name= "Stylist_Email")
	private String email;
	@Column(name= "Cash_Only")
	private Boolean cashOnly;
	@ManyToOne(optional=true)
    @JoinColumn(name="Salon_ID",referencedColumnName="Salon_LicNum")
	private Salon salon;
	
	public String getLicNum() {
		return licNum;
	}
	
	public void setLicNum(String licNum) {
		this.licNum = licNum;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isCashOnly() {
		return cashOnly;
	}
	
	public void setCashOnly(boolean cashOnly) {
		this.cashOnly = cashOnly;
	}
	
	public Salon getSalon() {
		return salon;
	}
	
	public void setSalonId(Salon salon) {
		this.salon = salon;
	}

}
