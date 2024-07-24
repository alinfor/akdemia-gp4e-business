package af.cmr.indyli.akdemia.business.entity;

import jakarta.persistence.*;

import java.util.Date;

/**
 * This class represents a Particular entity. It encapsulates information about
 * an individual who is not employed by the company but participates in session,
 * it extends {@link User}
 */
@Entity
@Table(name = "AKDEMIA_PARTICULAR")
public class Particular extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3927855605514477847L;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@Column(name = "GENDER")
	private String gender;
	@Column(name = "ACTIVITY")
	private String activity;

	@Column(name = "HIGHEST_DIPLOMA")
	private String highestDiploma;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	public Particular() {
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

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getHighestDiploma() {
		return highestDiploma;
	}

	public void setHighestDiploma(String highestDiploma) {
		this.highestDiploma = highestDiploma;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
