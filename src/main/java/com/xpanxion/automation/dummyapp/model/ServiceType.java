package com.xpanxion.automation.dummyapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "APP_SERVICETYPE")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "allServiceTypes",
                query = "",
                resultClass = ServiceType.class)
//        @NamedNativeQuery(
//                name = "servicesByStylist",
//                query = "",
//                resultClass = ServiceType.class),
//        @NamedNativeQuery(
//                name = "servicesBySalon",
//                query = "",
//                resultClass = ServiceType.class)
})
public class ServiceType implements Serializable{
	
    /** Distinguish between different versions of this serialized class. */
    private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "Type_ID", nullable = false)
	private long id;
	@Column(name= "Description", nullable = false)
	private String description;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
