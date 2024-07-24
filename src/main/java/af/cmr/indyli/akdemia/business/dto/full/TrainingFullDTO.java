package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.TrainingMediumDTO;

public class TrainingFullDTO extends TrainingMediumDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2280436692868013919L;
	
	private List<SubTopicBasicDTO> subTopics = new ArrayList<>();

	/*
	 * private List<SessionBasicDTO> sessions = new ArrayList<>();
	 * 
	 * public List<SessionBasicDTO> getSessions() { return sessions; }
	 * 
	 * public void setSessions(List<SessionBasicDTO> sessions) { this.sessions =
	 * sessions; }
	 */

    public List<SubTopicBasicDTO> getSubThemes() {
        return subTopics;
    }

    public void setSubThemes(List<SubTopicBasicDTO> subTopics) {
        this.subTopics = subTopics;
    }
}
