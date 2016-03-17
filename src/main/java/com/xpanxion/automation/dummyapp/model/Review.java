package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "APP_REVIEW")
public class Review implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Review_ID", nullable = false)
	private String id;
	@ManyToOne(optional=false)
    @JoinColumn(name="Client_ID",referencedColumnName="Client_ID")
	private Client client;
	@ManyToOne(optional=false)
    @JoinColumn(name="Stylist_ID",referencedColumnName="Stylist_LicNum")
	private Stylist stylist;
	@Column(name= "Review_Date", nullable = false)
	private Date date;
	@Column(name= "Review_Rate", nullable = false)
	private double review;
	@Column(name= "Review_Note")
	private String note;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClientId(Client client) {
		this.client = client;
	}
	
	public Stylist getStylist() {
		return stylist;
	}
	
	public void setStylistId(Stylist stylist) {
		this.stylist = stylist;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getReview() {
		return review;
	}
	
	public void setReview(double review) {
		this.review = review;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
}
