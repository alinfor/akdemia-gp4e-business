package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IManagerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ManagerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Manager;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IManagerService;
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
 * Service implementation class for managing {@link Manager} entity, extending
 * the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing users managers, including CRUD operations and
 * validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.MANAGER_SERVICE_KEY)
public class ManagerServiceImpl
		extends AbstractAkdemiaServiceImpl<Manager, ManagerBasicDTO, ManagerFullDTO, IManagerRepository>
		implements IManagerService {
	@Resource(name = ConstsValues.ConstsDAO.MANAGER_DAO_KEY)
	private IManagerRepository managerRepository;
	@Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
	private IUserService userService;

	public ManagerServiceImpl() {
		super(Manager.class, ManagerBasicDTO.class, ManagerFullDTO.class);
	}

	@Override
	public IManagerRepository getDAO() {
		return this.managerRepository;
	}

	@Override
	public ManagerFullDTO create(ManagerFullDTO view) throws AkdemiaBusinessException {
		if (!userService.isExistUserByEmail(view.getEmail())) {
			view.setCreationDate(new Date());
			Manager entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Manager.class));

			return this.getModelMapper().map(entity, ManagerFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public ManagerFullDTO update(ManagerFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
			viewToUpdate.setUpdateDate(new Date());
			Manager entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

}
