package af.cmr.indyli.akdemia.business.dto.medium;

import com.fasterxml.jackson.annotation.JsonIgnore;

import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Particular;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link Particular subscription} entity. It extends {@link ParticularSubscriptionDTO} and inherits basic
 * information about a Particular's subscription. Medium DTOs typically include additional details
 * beyond the basic DTO but exclude complex associations like lists.
 */
public class ParticularSubscriptionMediumDTO extends ParticularSubscriptionBasicDTO {
	private static final long serialVersionUID = 8638735324518521033L;
	 
	private ParticularBasicDTO particular;
 
	@JsonIgnore
	private InterSessionBasicDTO interSession;
 
	public ParticularSubscriptionMediumDTO() {
		super();
	}
 
	public ParticularBasicDTO getParticular() {
		return particular;
	}
 
	public void setParticular(ParticularBasicDTO particular) {
		this.particular = particular;
	}
 
	public InterSessionBasicDTO getInterSession() {
		return interSession;
	}
 
	public void setInterSession(InterSessionBasicDTO interSession) {
		this.interSession = interSession;
	}

}
