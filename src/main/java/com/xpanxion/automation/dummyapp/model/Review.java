package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;


@Entity
@Table(name = "APP_REVIEW")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "allReviews",
                query = "",
                resultClass = Review.class),
        @NamedNativeQuery(
                name = "reviewsbyStylist",
                query = "",
                resultClass = Review.class)
})
public class Review implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Review_ID", nullable = false)
	private String id;
	@Column(name= "Client_ID", nullable = false)
	private String clientId;
	@Column(name= "Stylist_ID", nullable = false)
	private String stylistId;
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
	
	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
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
