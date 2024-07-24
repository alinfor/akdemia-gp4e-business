package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akdemia.business.entity.SubTopic;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link SubTopic} entity. It extends {@link SubTopicBasicDTO} and inherits
 * basic information about a sub-topic. Medium DTOs typically include additional
 * details beyond the basic DTO but exclude complex associations like lists.
 */
public class SubTopicMediumDTO extends SubTopicBasicDTO {
	public SubTopicMediumDTO() {
	}
}