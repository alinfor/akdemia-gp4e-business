package af.cmr.indyli.akdemia.business.service;

import java.util.List;

import af.cmr.indyli.akdemia.business.dao.IParticularSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.ParticularSubscription;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;

public interface IParticularSubscriptionService 
		extends IAbstractAkdemiaService <ParticularSubscription, ParticularSubscriptionBasicDTO, ParticularSubscriptionFullDTO, IParticularSubscriptionRepository>{

	public InterSessionFullDTO create(Integer interSessionId, List<Integer> particularsId) throws AkdemiaBusinessException;
}
