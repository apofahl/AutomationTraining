package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_APPOINTMENT")
public class Appointment implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Appointment_ID", nullable = false)
	private long id;
	@Column(name= "Client_ID", nullable = false)
	private long clientId;
	@Column(name= "Service_Type", nullable = false)
	private long serviceType;
	@Column(name= "Stylist_ID", nullable = false)
	private String stylistId;
	@Column(name= "App_Date")
	private Date date;
	@Column(name= "Time_Start")
	private Time start;
	@Column(name= "Time_End")
	private Time end;
	@Column(name= "Client_Note")
	private String clientNote;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getClientId() {
		return clientId;
	}
	
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	public long getServiceType() {
		return serviceType;
	}
	
	public void setServiceType(long serviceType) {
		this.serviceType = serviceType;
	}
	
	public String getStylistId() {
		return stylistId;
	}
	
	public void setStylistId(String stylistId) {
		this.stylistId = stylistId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Time getStart() {
		return start;
	}
	
	public void setStart(Time start) {
		this.start = start;
	}
	
	public Time getEnd() {
		return end;
	}
	
	public void setEnd(Time end) {
		this.end = end;
	}
	
	public String getClientNote() {
		return clientNote;
	}
	
	public void setClientNote(String clientNote) {
		this.clientNote = clientNote;
	}
	
	
}
