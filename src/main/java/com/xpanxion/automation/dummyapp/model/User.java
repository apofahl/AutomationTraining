package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER")
public class User implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name= "User_ID", nullable = false)
    private long id;
	@ManyToOne(optional=false)
    @JoinColumn(name="User_Role",referencedColumnName="Role_ID")
	private Role role;
	@Column(name= "Email")
	private String email;
	@Column(name= "Password")
	private String password;
	@ManyToOne(optional=true)
    @JoinColumn(name="Client_ID",referencedColumnName="Client_ID")
	private Client client;
	@ManyToOne(optional=true)
    @JoinColumn(name="Stylist_ID",referencedColumnName="Stylist_LicNum")
	private Stylist stylist;
	@ManyToOne(optional=true)
    @JoinColumn(name="Salon_ID",referencedColumnName="Salon_LicNum")
	private Salon salon;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Stylist getStylist() {
		return stylist;
	}
	
	public Salon getSalon() {
		return salon;
	}
}
