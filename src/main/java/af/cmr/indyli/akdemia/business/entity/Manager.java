package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class represents a Manager entity. It encapsulates information about an
 * individual who holds a managerial position.
 */
@Entity
@Table(name = "AKDEMIA_MANAGER")
public class Manager extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5386288255302469764L;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "GENDER")
	private String gender;

	public Manager() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
