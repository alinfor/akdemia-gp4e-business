package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IParticularRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akdemia.business.entity.Particular;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IParticularService;
import af.cmr.indyli.akdemia.business.service.IUserService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

/**
 * Service implementation class for managing {@link Particular} entity,
 * extending the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing particular, including CRUD operations and
 * validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.PARTICULAR_SERVICE_KEY)
public class ParticularServiceImpl
		extends AbstractAkdemiaServiceImpl<Particular, ParticularBasicDTO, ParticularFullDTO, IParticularRepository>
		implements IParticularService {
	@Resource(name = ConstsValues.ConstsDAO.PARTICULAR_DAO_KEY)
	private IParticularRepository particularRepository;

	@Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
	private IUserService userService;

	public ParticularServiceImpl() {
		super(Particular.class, ParticularBasicDTO.class, ParticularFullDTO.class);
	}

	@Override
	public IParticularRepository getDAO() {
		return this.particularRepository;
	}

	@Override
	public ParticularFullDTO create(ParticularFullDTO view) throws AkdemiaBusinessException {
		if (!userService.isExistUserByEmail(view.getEmail())) {
			view.setCreationDate(new Date());
			Particular entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Particular.class));

			return this.getModelMapper().map(entity, ParticularFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public ParticularFullDTO update(ParticularFullDTO viewToUpdate)
			throws AkdemiaBusinessException, AccessDeniedException {
		if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
			viewToUpdate.setUpdateDate(new Date());
			Particular entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.OBJECT_SEARCHED_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpParticipant = this.findById(id);

		if (tmpParticipant == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}

		getDAO().deleteById(id);
	}
}
