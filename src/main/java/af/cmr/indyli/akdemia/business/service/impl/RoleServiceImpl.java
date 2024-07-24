package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IRoleRepository;
import af.cmr.indyli.akdemia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.RoleFullDTO;
import af.cmr.indyli.akdemia.business.entity.Role;
import af.cmr.indyli.akdemia.business.service.IRoleService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link Role} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing roles, including CRUD operations.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.ROLE_SERVICE_KEY)
public class RoleServiceImpl extends AbstractAkdemiaServiceImpl<Role, RoleBasicDTO, RoleFullDTO, IRoleRepository>
		implements IRoleService {

	@Resource(name = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
	private IRoleRepository roleRepository;

	public RoleServiceImpl() {
		super(Role.class, RoleBasicDTO.class, RoleFullDTO.class);
	}

	@Override
	public IRoleRepository getDAO() {
		return this.roleRepository;
	}
}