package af.cmr.indyli.akdemia.business.dto.basic;

import java.util.Date;

import af.cmr.indyli.akdemia.business.dto.IDTO;

public class EmployeeSubscriptionBasicDTO implements IDTO {
    
	
	private Integer id;
	private String status;
	private Date creationDate;
	private Date updateDate;
	private Integer idAkdemiaInterSession;
	private Integer idAkdemiaParticular;

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
	public Integer getIdAkdemiaInterSession() {
		return idAkdemiaInterSession;
	}
	public void setIdAkdemiaInterSession(Integer idAkdemiaInterSession) {
		this.idAkdemiaInterSession = idAkdemiaInterSession;
	}
	public Integer getIdAkdemiaParticular() {
		return idAkdemiaParticular;
	}
	public void setIdAkdemiaParticular(Integer idAkdemiaParticular) {
		this.idAkdemiaParticular = idAkdemiaParticular;
	}



}
