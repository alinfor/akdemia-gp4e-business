package af.cmr.indyli.akdemia.business.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "AKDEMIA_EMPLOYEE_SOUSCRIPTION")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeSubscription implements IEntity {
	
	private static final long serialVersionUID = -2586996818147225669L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_INTRA_SESSION")
	private IntraSession intraSession;

	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_EMPLOYEE")
	private Employee employee;

	// Getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public IntraSession getIntraSession() {
		return intraSession;
	}

	public void setIntraSession(IntraSession intraSession) {
		this.intraSession = intraSession;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
