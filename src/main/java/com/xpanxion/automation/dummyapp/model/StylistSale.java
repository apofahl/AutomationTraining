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
@Table(name = "APP_SALE")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "salesForStylists",
                query = "",
                resultClass = StylistSale.class),
        @NamedNativeQuery(
                name = "salesByStylist",
                query = "",
                resultClass = StylistSale.class)
})
public class StylistSale implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;
	

	@Id
	@Column(name= "Sale_ID", nullable = false)
	private long id;
	@Column(name= "Start_Date", nullable = false)
	private Date start;
	@Column(name= "End_Date", nullable = false)
	private Date end;
	@Column(name= "Description", nullable = false)
	private String description;
	@Column(name= "Stylist_ID")
	private String stylistId;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getStart() {
		return start;
	}
	
	public void setStart(Date start) {
		this.start = start;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStylistId() {
		return stylistId;
	}
	
	public void setStylistId(String stylistId) {
		this.stylistId = stylistId;
	}
}
