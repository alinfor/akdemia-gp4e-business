package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IPlanningRepository;
import af.cmr.indyli.akdemia.business.dto.basic.PlanningBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.PlanningFullDTO;
import af.cmr.indyli.akdemia.business.entity.Planning;
import af.cmr.indyli.akdemia.business.service.IPlanningService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link Planning} entity, extending
 * the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing planning including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.PLANNING_SERVICE_KEY)
public class PlanningServiceImpl
		extends AbstractAkdemiaServiceImpl<Planning, PlanningBasicDTO, PlanningFullDTO, IPlanningRepository>
		implements IPlanningService {

	@Resource(name = ConstsValues.ConstsDAO.PLANNING_DAO_KEY)
	private IPlanningRepository planningRepository;

	public PlanningServiceImpl() {
		super(Planning.class, PlanningBasicDTO.class, PlanningFullDTO.class);
	}

	@Override
	public IPlanningRepository getDAO() {
		return this.planningRepository;
	}
}
