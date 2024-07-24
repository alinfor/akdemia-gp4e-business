package af.cmr.indyli.akdemia.business.dto.basic;


import java.util.Date;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.Status;

public class IntraSessionBasicDTO implements IDTO {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6632160553039534564L;
	
	private Integer id;
	private String code;
	private Integer duration;
	private String description;
	private Status status;
	private Double price;
	private Date date;
	private String location;
	private Integer sessionScore;
	private Integer minParticipants;
	private Date creationDate;
	private Date updateDate;
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getSessionScore() {
		return sessionScore;
	}

	public void setSessionScore(Integer sessionScore) {
		this.sessionScore = sessionScore;
	}

	public Integer getMinParticipants() {
		return minParticipants;
	}

	public void setMinParticipants(Integer minParticipants) {
		this.minParticipants = minParticipants;
	}



	public IntraSessionBasicDTO() {
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getUpdateDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		// TODO Auto-generated method stub
		
	}
	
	

    
    
	

	
}
