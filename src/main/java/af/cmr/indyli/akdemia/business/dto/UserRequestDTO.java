package af.cmr.indyli.akdemia.business.dto;

/**
 * This class represents a Data Transfer Object (DTO) for user authentication.
 * It encapsulates the information required for user authentication processing,
 * including email and password.
 */
public class UserRequestDTO {
	private String email;
	private String password;

	public UserRequestDTO() {
	}

	public UserRequestDTO(String email, String password) {
		this.email = email;
		this.password = password;
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
}
