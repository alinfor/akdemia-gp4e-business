package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents a Validation entity. It encapsulates information about
 * the validation of trainer.
 */
@Entity
@Table(name = "AKDEMIA_VALIDATION_TEST")
public class ValidationTest implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7864482508793024323L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TEST_DATE")
	private Date testDate;

	@Column(name = "SCORE")
	private Integer score;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@ManyToOne
	private Test test;

	public ValidationTest() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
}
