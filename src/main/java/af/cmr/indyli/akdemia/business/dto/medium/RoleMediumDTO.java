package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Role;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link Role}
 * entity. It extends {@link RoleBasicDTO} and inherits basic information about
 * a role. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class RoleMediumDTO extends RoleBasicDTO {
	public RoleMediumDTO() {
	}
}