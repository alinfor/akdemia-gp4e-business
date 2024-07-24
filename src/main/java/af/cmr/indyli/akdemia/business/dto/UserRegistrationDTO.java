package af.cmr.indyli.akdemia.business.dto;

/**
 * This class represents a Data Transfer Object (DTO) for user registration. It
 * encapsulates information required for user registration, such as first name,
 * last name, email, password, etc.
 */
public class UserRegistrationDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String roleName;
	private String gender;
	private String phone;
	private String address;
	private String photo;

	public UserRegistrationDTO() {
	}

	public UserRegistrationDTO(String firstName, String lastName, String email, String password, String roleName,
			String gender, String phone, String address, String photo) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roleName = roleName;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.photo = photo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
