package af.cmr.indyli.akdemia.business.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "AKDEMIA_PARTICULAR_SOUSCRIPTION")
public class ParticularSubscription implements IEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
 
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
 
	@Column(name = "CREATION_DATE")
	private Date creationDate;
 
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
 
	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_PARTICULAR")
	private Particular particular;
 
	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_INTER_SESSION")
	private InterSession interSession;
 
	public ParticularSubscription() {
	}
 
	@Override
	public Integer getId() {
		return id;
	}
 
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
 
	public Status getStatus() {
		return status;
	}
 
	public void setStatus(Status status) {
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
 
	public Particular getParticular() {
		return particular;
	}
 
	public void setParticular(Particular particular) {
		this.particular = particular;
	}
 
	public InterSession getInterSession() {
		return interSession;
	}
 
	public void setInterSession(InterSession interSession) {
		this.interSession = interSession;
	}
	
}
