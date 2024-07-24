package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.InterSessionMediumDTO;
import af.cmr.indyli.akdemia.business.dto.medium.ParticularSubscriptionMediumDTO;


public class InterSessionFullDTO extends InterSessionMediumDTO {
	

	private List<ParticularSubscriptionMediumDTO> particularSubscriptions;
 
	public InterSessionFullDTO() {
	}
 
	public List<ParticularSubscriptionMediumDTO> getParticularSubscriptions() {
		return particularSubscriptions;
	}
 
	public void setParticularSubscriptions(List<ParticularSubscriptionMediumDTO> particularSubscriptions) {
		this.particularSubscriptions = particularSubscriptions;
	}
	
}
