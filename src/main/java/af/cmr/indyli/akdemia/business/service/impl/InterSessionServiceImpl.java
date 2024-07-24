package af.cmr.indyli.akdemia.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IInterSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.entity.Status;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IInterSessionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import af.cmr.indyli.akdemia.business.utils.DateUtils;
import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.INTER_SESSION_SERVICE_KEY)
public class InterSessionServiceImpl extends
		AbstractAkdemiaServiceImpl<InterSession, InterSessionBasicDTO, InterSessionFullDTO, IInterSessionRepository>
		implements IInterSessionService {

	@Resource(name = ConstsValues.ConstsDAO.INTER_SESSION_DAO_KEY)
	private IInterSessionRepository iInterSessionRepository;

	
	public InterSessionServiceImpl() {
		super(InterSession.class, InterSessionBasicDTO.class, InterSessionFullDTO.class);
	}


	@Override
	public IInterSessionRepository getDAO() {
		return this.iInterSessionRepository;
	}


	@Override
	public void deleteForce(int id) {
		// TODO Auto-generated method stub
		
	}






		@Override
		public InterSessionFullDTO create(InterSessionFullDTO view) throws AkdemiaBusinessException {
			InterSession sessionExisting = this.getDAO().findByCode(view.getCode());
			if (sessionExisting != null) {
				throw new AkdemiaBusinessException(ConstBusinessRules.RG03);
			}
		
			if (view.getDate() == null) {
				throw new AkdemiaBusinessException(ConstBusinessRules.RG09);
			}
		
			if (DateUtils.calculateDateDifferenceInDays(new Date(), view.getDate()) < 90)
				throw new AkdemiaBusinessException(ConstBusinessRules.RG12);
		
			view.setCreationDate(new Date());
			view.setStatus(Status.WAITING);
		
			InterSession tmpSession = this.getDAO().saveAndFlush(this.getModelMapper().map(view, InterSession.class));
		
			return this.getModelMapper().map(tmpSession, InterSessionFullDTO.class);
		}











	@Override
	public InterSessionFullDTO update(InterSessionFullDTO viewToUpdate)
			throws AkdemiaBusinessException, AccessDeniedException {
		InterSession entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
 
		if (entity != null) {
			boolean isTrainerChange = !viewToUpdate.getTrainer().getId().equals(entity.getTrainer().getId());
			boolean isDateNear = DateUtils.calculateDateDifferenceInDays(viewToUpdate.getDate(), new Date()) <= 15;
			boolean isCodeExist = this.findAll().stream().anyMatch(
					p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));
 
			if (isCodeExist)
				throw new AkdemiaBusinessException(ConstBusinessRules.RG03);
 
			if (viewToUpdate.getDate() == null)
				throw new AkdemiaBusinessException(ConstBusinessRules.RG09);
 
			if (DateUtils.calculateDateDifferenceInDays(new Date(), viewToUpdate.getDate()) < 90)
				throw new AkdemiaBusinessException(ConstBusinessRules.RG12);
 
			if (isTrainerChange && isDateNear) {
				throw new AkdemiaBusinessException(ConstBusinessRules.RG10);
			}
 
			viewToUpdate.setUpdateDate(new Date());
			this.getDAO().saveAndFlush(this.getModelMapper().map(viewToUpdate, InterSession.class));
		} else {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
		}
 
		return viewToUpdate;
	}
 
	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		this.getDAO().findById(id).ifPresent(p -> {
			p.setStatus(Status.CANCELLED);
			this.getDAO().saveAndFlush(p);
		});
	}




}
