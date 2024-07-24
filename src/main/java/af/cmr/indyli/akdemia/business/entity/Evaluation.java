package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents an Evaluation entity. It encapsulates information about
 * the evaluation of a session or a trainer.
 */
@Entity
@Table(name = "AKDEMIA_EVALUATION")
public class Evaluation implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6773229990792510372L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "SESSION_SCORE")
	private Integer sessionScore;

	@Column(name = "TRAINER_SCORE")
	private Integer trainerScore;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private Particular particular;
	public Evaluation() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSessionScore() {
		return sessionScore;
	}

	public void setSessionScore(Integer sessionScore) {
		this.sessionScore = sessionScore;
	}

	public Integer getTrainerScore() {
		return trainerScore;
	}

	public void setTrainerScore(Integer trainerScore) {
		this.trainerScore = trainerScore;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Particular getParticular() {
		return particular;
	}

	public void setParticular(Particular particular) {
		this.particular = particular;
	}

}
