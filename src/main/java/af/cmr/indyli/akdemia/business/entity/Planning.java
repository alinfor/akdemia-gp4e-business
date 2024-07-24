package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents a Planning entity. It encapsulates information about a
 * of requests for training.
 */
@Entity
@Table(name = "AKDEMIA_PLANIFICATION")
public class Planning implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6708156610051681072L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@ManyToOne
	private Company company;


	public Planning() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
