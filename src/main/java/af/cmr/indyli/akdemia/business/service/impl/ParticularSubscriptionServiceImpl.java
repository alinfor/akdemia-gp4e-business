package af.cmr.indyli.akdemia.business.service.impl;



import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dao.IParticularRepository;
import af.cmr.indyli.akdemia.business.dao.IParticularSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.entity.Particular;
import af.cmr.indyli.akdemia.business.entity.ParticularSubscription;
import af.cmr.indyli.akdemia.business.entity.Status;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;

import af.cmr.indyli.akdemia.business.service.IParticularSubscriptionService;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;


@Service (ConstsValues.ServiceKeys.PARTICULAR_SUBSCRIPTION_SERVICE_KEY)
public class ParticularSubscriptionServiceImpl
		extends AbstractAkdemiaServiceImpl <ParticularSubscription, ParticularSubscriptionBasicDTO, ParticularSubscriptionFullDTO, IParticularSubscriptionRepository> 
			implements IParticularSubscriptionService
			{
		
			@Resource(name = ConstsValues.ConstsDAO.PARTICULAR_SUBSCRIPTION_DAO_KEY)
			private IParticularSubscriptionRepository particularSubscriptionRepository;
			
			@Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
			private IInterSessionRepository interSessionRepository;
			
			@Resource(name = ConstsValues.ConstsDAO.PARTICULAR_DAO_KEY)
			private IParticularRepository particularRepository;
			
			public ParticularSubscriptionServiceImpl() {
				super(ParticularSubscription.class, ParticularSubscriptionBasicDTO.class, ParticularSubscriptionFullDTO.class);
			}

			@Override
			public IParticularSubscriptionRepository getDAO() {
				return null;
			}
			
			@Override
			public InterSessionFullDTO create(Integer interSessionId, List<Integer> particularsId)
					throws AkdemiaBusinessException {
		 
				InterSession interSession = interSessionRepository.findById(interSessionId).orElse(null);
				if (interSession == null)
					throw new AkdemiaBusinessException(ConstRejectBusinessMessage.SESSION_NOT_FOUND);
				particularsId.forEach((id) -> {
					Particular p = particularRepository.findById(id).orElse(null);
					if (p != null) {
						ParticularSubscription particularSubscription = new ParticularSubscription();
						particularSubscription.setParticular(p);
						particularSubscription.setInterSession(interSession);
						particularSubscription.setCreationDate(new Date());
						particularSubscription.setStatus(Status.IN_PROGRESS);
						particularSubscriptionRepository.save(particularSubscription);
					}
				});
		 
				return getModelMapper().map(interSession, InterSessionFullDTO.class);
			}
					
}
