package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IRoleRepository;
import af.cmr.indyli.akdemia.business.dto.basic.RoleBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.RoleFullDTO;
import af.cmr.indyli.akdemia.business.entity.Role;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing role,
 * providing specific operations for {@link Role} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IRoleService extends IAbstractAkdemiaService<Role, RoleBasicDTO, RoleFullDTO, IRoleRepository> {
}