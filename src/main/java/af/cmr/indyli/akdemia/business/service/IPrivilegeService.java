package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IPrivilegeRepository;
import af.cmr.indyli.akdemia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.PrivilegeFullDTO;
import af.cmr.indyli.akdemia.business.entity.Privilege;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * privilege, providing specific operations for {@link Privilege} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IPrivilegeService
		extends IAbstractAkdemiaService<Privilege, PrivilegeBasicDTO, PrivilegeFullDTO, IPrivilegeRepository> {
}