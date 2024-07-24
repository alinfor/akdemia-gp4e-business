package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akdemia.business.entity.User;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link User}
 * entity. It extends {@link UserBasicDTO} and inherits basic information about
 * a user. Medium DTOs typically include additional details beyond the basic DTO
 * but exclude complex associations like lists.
 */
public class UserMediumDTO extends UserBasicDTO {
	public UserMediumDTO() {
	}
}
