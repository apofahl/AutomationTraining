package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "APP_CLIENT")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "allClients",
                query = "",
                resultClass = Client.class),
        @NamedNativeQuery(
                name = "clientsForStylist",
                query = "",
                resultClass = Client.class)
//        @NamedNativeQuery(
//                name = "clientsForSalon",
//                query = "",
//                resultClass = Client.class)
})
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
	@Column(name= "Stylist_ID")
	private String stylistId;
	
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
	
	public String getStylistId() {
		return stylistId;
	}
	
	public void setStylistId(String stylistId) {
		this.stylistId = stylistId;
	}
}
