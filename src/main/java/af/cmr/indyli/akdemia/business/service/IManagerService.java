package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IManagerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ManagerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Manager;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing user
 * manager, providing specific operations for {@link Manager} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IManagerService
		extends IAbstractAkdemiaService<Manager, ManagerBasicDTO, ManagerFullDTO, IManagerRepository> {

}
