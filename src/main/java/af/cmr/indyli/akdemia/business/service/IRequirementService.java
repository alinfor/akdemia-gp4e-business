package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IRequirementRepository;
import af.cmr.indyli.akdemia.business.dto.basic.RequirementBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.RequirementFullDTO;
import af.cmr.indyli.akdemia.business.entity.Requirement;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * requirement, providing specific operations for {@link Requirement} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IRequirementService
		extends IAbstractAkdemiaService<Requirement, RequirementBasicDTO, RequirementFullDTO, IRequirementRepository> {
}