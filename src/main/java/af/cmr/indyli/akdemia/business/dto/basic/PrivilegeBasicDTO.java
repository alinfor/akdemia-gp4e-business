package af.cmr.indyli.akdemia.business.dto.basic;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.Privilege;

import java.util.Date;

/**
 * This class represents a basic Data Transfer Object (DTO) for a
 * {@link Privilege} entity.
 */
public class PrivilegeBasicDTO implements IDTO {
	private Integer id;
	private Date creationDate;
	private Date updateDate;

	public PrivilegeBasicDTO() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

}
