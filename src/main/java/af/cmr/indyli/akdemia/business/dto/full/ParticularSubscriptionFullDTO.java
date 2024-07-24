package af.cmr.indyli.akdemia.business.dto.full;

import java.util.List;

import af.cmr.indyli.akdemia.business.dto.medium.ParticularSubscriptionMediumDTO;

/**
 * This class represents a full Data Transfer Object (DTO) for a {@link ParticularSubscription}
 * entity, it extends {@link ParticularSubscriptionFullDTO}.
 */
public class ParticularSubscriptionFullDTO extends ParticularSubscriptionMediumDTO{	

	private List<ParticularSubscriptionMediumDTO> particularSubscriptions;
 
	 public List<ParticularSubscriptionMediumDTO> getParticularSubscriptions() {
		return particularSubscriptions;
	}

	public void setParticularSubscriptions(List<ParticularSubscriptionMediumDTO> particularSubscriptions) {
		this.particularSubscriptions = particularSubscriptions;
	}

	public ParticularSubscriptionFullDTO() {
		// TODO Auto-generated constructor stub
	}
}
