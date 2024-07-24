package af.cmr.indyli.akdemia.business.service;



import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;


public interface IInterSessionService extends
		IAbstractAkdemiaService<InterSession, InterSessionBasicDTO, InterSessionFullDTO, IInterSessionRepository> {
	
	public void deleteForce(int id);

}
