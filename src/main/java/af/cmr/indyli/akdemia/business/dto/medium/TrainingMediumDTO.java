package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.RequirementBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;

public class TrainingMediumDTO extends TrainingBasicDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -829134022477378075L;
	
	private RequirementBasicDTO requirement;
	
    public TrainingMediumDTO() {
    	
    }

    public RequirementBasicDTO getRequirement() {
        return requirement;
    }

    public void setRequirement(RequirementBasicDTO requirement) {
        this.requirement = requirement;
    }
}
