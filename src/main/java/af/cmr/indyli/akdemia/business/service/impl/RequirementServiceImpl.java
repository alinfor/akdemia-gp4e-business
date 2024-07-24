package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IRequirementRepository;
import af.cmr.indyli.akdemia.business.dto.basic.RequirementBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.RequirementFullDTO;
import af.cmr.indyli.akdemia.business.entity.Requirement;
import af.cmr.indyli.akdemia.business.service.IRequirementService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link Requirement} entity,
 * extending the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing requirements, including CRUD operations.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.REQUIREMENT_SERVICE_KEY)
public class RequirementServiceImpl
		extends AbstractAkdemiaServiceImpl<Requirement, RequirementBasicDTO, RequirementFullDTO, IRequirementRepository>
		implements IRequirementService {

	@Resource(name = ConstsValues.ConstsDAO.REQUIREMENT_DAO_KEY)
	private IRequirementRepository requirementRepository;

	public RequirementServiceImpl() {
		super(Requirement.class, RequirementBasicDTO.class, RequirementFullDTO.class);
	}

	@Override
	public IRequirementRepository getDAO() {
		return this.requirementRepository;
	}
}