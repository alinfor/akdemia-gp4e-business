package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;

public interface ISessionService extends IAbstractAkdemiaService<Session, SessionBasicDTO, SessionFullDTO, ISessionRepository> {
	
	boolean isExistsByCode(String code);
	public SessionBasicDTO deleteSession(SessionBasicDTO session) throws AkdemiaBusinessException;

}


