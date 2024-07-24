package af.cmr.indyli.akdemia.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dao.IParticularSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.entity.Status;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ISessionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.SESSION_SERVICE_KEY)
public class SessionServiceImpl
		extends AbstractAkdemiaServiceImpl<Session, SessionBasicDTO, SessionFullDTO, ISessionRepository>
		implements ISessionService {

	@Resource(name = ConstsValues.ConstsDAO.SESSION_DAO_KEY)
	private ISessionRepository sessionRepository;
	
	@Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
	private IInterSessionRepository interSessionRepository;
	
	@Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
	private IIntraSessionRepository intraSessionRepository;

	public SessionServiceImpl() {
		super(Session.class, SessionBasicDTO.class, SessionFullDTO.class);
	}
	
	@Autowired
    private IEmployeeSubscriptionRepository employeeSubscriptionRepository;

    @Autowired
    private IParticularSubscriptionRepository particularSubscriptionRepository;

	@Override
	public ISessionRepository getDAO() {
		return this.sessionRepository;
	}

	@Override
	public boolean isExistsByCode(String code) {
		return this.findAll().stream().anyMatch(u -> code.equals(u.getCode()));
	}

	@Override
	public SessionFullDTO create(SessionFullDTO view) throws AkdemiaBusinessException {
		if (isExistsByCode(view.getCode())) {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG03);
		}

		if (view.getDate() == null) {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG09);
		}

		long diffInMillies = Math.abs(view.getDate().getTime() - new Date().getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if (diff < 90) {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG12);
		}
		view.setCreationDate(new Date());

		Session entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Session.class));
		return this.getModelMapper().map(entity, SessionFullDTO.class);
	}

	@Override
	public SessionFullDTO update(SessionFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {

		if (isExistsByCode(viewToUpdate.getCode())) {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG03);
		}

		if (viewToUpdate.getDate() == null) {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG09);
		}

		long diffInMillies = Math.abs(viewToUpdate.getDate().getTime() - new Date().getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		if (diff < 90) {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG12);
		}
		viewToUpdate.setCreationDate(new Date());

		Session entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
		if (entity != null) {
			BeanUtils.copyProperties(viewToUpdate, entity);
			this.getDAO().saveAndFlush(entity);
		} else {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
		}
		return viewToUpdate;

	}
	
	
	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
        var tmpSession = sessionRepository.findById(id).orElse(null);

        if (tmpSession == null) {
            throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
        }

        boolean hasEmployeeSubscriptions = employeeSubscriptionRepository.existsById(id);
        boolean hasParticularSubscriptions = particularSubscriptionRepository.existsById(id);

        if (hasEmployeeSubscriptions || hasParticularSubscriptions) {
            throw new AkdemiaBusinessException(ConstBusinessRules.RG16);
        }

        sessionRepository.deleteById(id);
    }

	
	@Override
	public SessionBasicDTO deleteSession(SessionBasicDTO sessionBasicDTO) throws AkdemiaBusinessException {
		Session session = getModelMapper().map(sessionBasicDTO, Session.class);
		if (session instanceof InterSession) {
			InterSession interSession = interSessionRepository.findById(sessionBasicDTO.getId()).get();
			interSession.setStatus(Status.CANCELLED);
			return getModelMapper().map(interSessionRepository.save(interSession), SessionBasicDTO.class);
		} 
		else if (session instanceof IntraSession) {
			IntraSession intraSession = intraSessionRepository.findById(sessionBasicDTO.getId()).get();
			intraSession.setStatus(Status.CANCELLED);
			return getModelMapper().map(intraSessionRepository.save(intraSession), SessionBasicDTO.class);
		}
		throw new AkdemiaBusinessException("Impossible d'annuler la session");

	}
}