package af.cmr.indyli.akdemia.business.dto.full;

import java.util.ArrayList;
import java.util.List;

import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.medium.TrainerMediumDTO;

public class TrainerFullDTO extends TrainerMediumDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 391602591455438228L;
	
	
	  private List<SessionBasicDTO> sessions = new ArrayList<>();
	  
	  public List<SessionBasicDTO> getSessions() { return sessions; }
	  
	  public void setSessions(List<SessionBasicDTO> sessions) { this.sessions =
	  sessions; }
	 
}
