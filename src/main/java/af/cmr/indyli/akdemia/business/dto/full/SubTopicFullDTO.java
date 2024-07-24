package af.cmr.indyli.akdemia.business.dto.full;

import af.cmr.indyli.akdemia.business.dto.basic.TopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.SubTopicMediumDTO;
import af.cmr.indyli.akdemia.business.entity.SubTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a full Data Transfer Object (DTO) for a
 * {@link SubTopic} entity, it extends {@link SubTopicMediumDTO}.
 */
public class SubTopicFullDTO extends SubTopicMediumDTO {

	private List<TopicBasicDTO> themes = new ArrayList<>();

	public List<TopicBasicDTO> getThemes() {
		return themes;
	}

	public void setThemes(List<TopicBasicDTO> themes) {
		this.themes = themes;
	}
}