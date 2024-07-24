package af.cmr.indyli.akdemia.business.dto.basic;


import java.util.Date;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.Status;
import af.cmr.indyli.akdemia.business.entity.Trainer;


public class SessionBasicDTO implements IDTO {
    
	private Integer id;
    private String code;
	private Integer duration;
    private Double price;
    private String description;
    private Status status;
    private Date date;
    private String location;
    private Integer sessionScore;
    private Date creationDate;
    private Date updateDate;
    private Trainer akdemiaTrainer; 
    private Integer idAkdemiaTraining;

    public Trainer getAkdemiaTrainer() {
		return akdemiaTrainer;
	}

	public void setAkdemiaTrainer(Trainer akdemiaTrainer) {
		this.akdemiaTrainer = akdemiaTrainer;
	}

	public Integer getIdAkdemiaTraining() {
		return idAkdemiaTraining;
	}

	public void setIdAkdemiaTraining(Integer idAkdemiaTraining) {
		this.idAkdemiaTraining = idAkdemiaTraining;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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


	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
