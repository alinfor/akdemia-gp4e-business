package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IPrivilegeRepository;
import af.cmr.indyli.akdemia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.PrivilegeFullDTO;
import af.cmr.indyli.akdemia.business.entity.Privilege;
import af.cmr.indyli.akdemia.business.service.IPrivilegeService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link Privilege} entity, extending
 * the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing privilege, including CRUD operations.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.PRIVILEGE_SERVICE_KEY)
public class PrivilegeServiceImpl
		extends AbstractAkdemiaServiceImpl<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, IPrivilegeRepository>
		implements IPrivilegeService {

	@Resource(name = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
	private IPrivilegeRepository privilegeRepository;

	public PrivilegeServiceImpl() {
		super(Privilege.class, PrivilegeBasicDTO.class, PrivilegeFullDTO.class);
	}

	@Override
	public IPrivilegeRepository getDAO() {
		return this.privilegeRepository;
	}
}