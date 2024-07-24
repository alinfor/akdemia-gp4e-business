package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.TopicBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Topic;

/**
 * This class represents a medium Data Transfer Object (DTO) for a {@link Topic}
 * entity. It extends {@link TopicBasicDTO} and inherits basic information about
 * a topic. Medium DTOs typically include additional details beyond the basic
 * DTO but exclude complex associations like lists.
 */
public class TopicMediumDTO extends TopicBasicDTO {
	public TopicMediumDTO() {
	}
}