package af.cmr.indyli.akdemia.business.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "AKDEMIA_TRAINER")
public class Trainer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9168653190951349442L;

	@Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "ACTIVITY")
    private String activity;

    @Column(name = "CV_LINK")
    private String cvLink;
    

	 @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER) 
	 private List<Session> sessions = new ArrayList<>();
	 

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

	public String getCvLink() {
		return cvLink;
	}

	public void setCvLink(String cvLink) {
		this.cvLink = cvLink;
	}

}
