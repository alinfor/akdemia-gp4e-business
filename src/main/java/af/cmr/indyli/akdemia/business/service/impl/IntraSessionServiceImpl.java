package af.cmr.indyli.akdemia.business.service.impl;



import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.IntraSessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.entity.Status;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IIntraSessionService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;

@Service(ConstsValues.ServiceKeys.INTRA_SESSION_SERVICE_KEY)
public class IntraSessionServiceImpl extends
		AbstractAkdemiaServiceImpl<IntraSession, IntraSessionBasicDTO, IntraSessionFullDTO, IIntraSessionRepository>
		implements IIntraSessionService {

	@Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
		private IIntraSessionRepository intraSessionRepository;
	 
//		@Value("${akdemia.business.nbLimitMonths}")
//		private Integer nbLimitMonths;
	 
		public IntraSessionServiceImpl() {
			super(IntraSession.class, IntraSessionBasicDTO.class, IntraSessionFullDTO.class);
		}
	 
		@Override
		public IntraSessionFullDTO create(IntraSessionFullDTO view) throws AkdemiaBusinessException {
			IntraSession sessionExisting = this.getDAO().findByCode(view.getCode());
			if (sessionExisting != null) {
				throw new AkdemiaBusinessException(ConstBusinessRules.RG03);
			}
	 
			if (view.getDate() == null) {
				throw new AkdemiaBusinessException(ConstBusinessRules.RG09);
			}
	 
//			if (DateUtils.calculateDateDifferenceInDays(new Date(), view.getDate()) < (nbLimitMonths * 3))
//				throw new AkdemiaBusinessException(ConstBusinessRules.RG12);
	 
			view.setCreationDate(new Date());
//			view.setStatus(Status.WAITING);
			IntraSession tmpSession = this.getDAO().saveAndFlush(this.getModelMapper().map(view, IntraSession.class));
	 
			return this.getModelMapper().map(tmpSession, IntraSessionFullDTO.class);
		}
	 
		@Override
		public IntraSessionFullDTO update(IntraSessionFullDTO viewToUpdate)
				throws AkdemiaBusinessException, AccessDeniedException {
			IntraSession entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				boolean isCodeExist = this.findAll().stream().anyMatch(
						p -> viewToUpdate.getCode().equals(p.getCode()) && !viewToUpdate.getId().equals(p.getId()));
	 
				if (isCodeExist)
					throw new AkdemiaBusinessException(ConstBusinessRules.RG03);
	 
				if (viewToUpdate.getDate() == null)
					throw new AkdemiaBusinessException(ConstBusinessRules.RG09);
	 
//				if (DateUtils.calculateDateDifferenceInDays(new Date(), viewToUpdate.getDate()) < (nbLimitMonths * 30))
//					throw new AkdemiaBusinessException(ConstBusinessRules.RG12);
	 
				viewToUpdate.setUpdateDate(new Date());
				this.getDAO().saveAndFlush(this.getModelMapper().map(viewToUpdate, IntraSession.class));
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
	 
		@Override
		public void deleteForce(int id) {
			this.getDAO().deleteById(id);
		}
	 
		@Override
		public IIntraSessionRepository getDAO() {
			return this.intraSessionRepository;
		}
	 

}
