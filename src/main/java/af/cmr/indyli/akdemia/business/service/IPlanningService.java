package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IPlanningRepository;
import af.cmr.indyli.akdemia.business.dto.basic.PlanningBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.PlanningFullDTO;
import af.cmr.indyli.akdemia.business.entity.Planning;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * planning, providing specific operations for {@link Planning} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface IPlanningService
		extends IAbstractAkdemiaService<Planning, PlanningBasicDTO, PlanningFullDTO, IPlanningRepository> {
}