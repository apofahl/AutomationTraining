package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_CLIENT")
public class Client implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Client_ID", nullable = false)
	private long id;
	@Column(name= "Client_FName", nullable = false)
	private String firstName;
	@Column(name= "Client_LName", nullable = false)
	private String lastName;
	@Column(name= "Client_Phone")
	private String phone;
	@Column(name= "Client_Email", nullable = false)
	private String email;
	@Column(name= "Client_Zip")
	private String zip;
	@ManyToOne(optional=true)
    @JoinColumn(name="Stylist_ID",referencedColumnName="Stylist_LicNum")
	private Stylist stylist;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public Stylist getStylist() {
		return stylist;
	}
	
	public void setStylistId(Stylist stylist) {
		this.stylist = stylist;
	}
}
