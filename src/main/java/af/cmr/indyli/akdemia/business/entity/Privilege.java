package af.cmr.indyli.akdemia.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents a Privilege entity. It encapsulates information about a
 * user privilege.
 */
@Entity
@Table(name = "AKDEMIA_PRIVILEGE")
public class Privilege implements IEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7452511460754453314L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "CREATION_DATE")
	private Date creationDate;

	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_USER")
	private User user;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_AKDEMIA_ROLE")
	private Role role;

	public Privilege() {
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
