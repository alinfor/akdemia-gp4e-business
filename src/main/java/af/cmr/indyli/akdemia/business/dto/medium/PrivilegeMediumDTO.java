package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Privilege;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link Privilege} entity. It extends {@link PrivilegeBasicDTO} and inherits
 * basic information about a role. Medium DTOs typically include additional
 * details beyond the basic DTO but exclude complex associations like lists.
 */
public class PrivilegeMediumDTO extends PrivilegeBasicDTO {
	private UserBasicDTO user;
	private RoleBasicDTO role;

	public UserBasicDTO getUser() {
		return user;
	}

	public void setUser(UserBasicDTO user) {
		this.user = user;
	}

	public RoleBasicDTO getRole() {
		return role;
	}

	public void setRole(RoleBasicDTO role) {
		this.role = role;
	}
}
