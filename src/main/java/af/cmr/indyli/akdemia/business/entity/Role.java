package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class represents a Role entity. It encapsulates information about a
 * specific role in the system.
 */
@Entity
@Table(name = "AKDEMIA_ROLE")
public class Role implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -72253323029073521L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<Privilege> privileges = new ArrayList<>();

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}
