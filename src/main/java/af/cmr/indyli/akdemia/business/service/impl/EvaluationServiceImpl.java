package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IEvaluationRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EvaluationFullDTO;
import af.cmr.indyli.akdemia.business.entity.Evaluation;
import af.cmr.indyli.akdemia.business.service.IEvaluationService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link Evaluation} entity,
 * extending the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing evaluation, including CRUD operations
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.EVALUATION_SERVICE_KEY)
public class EvaluationServiceImpl
		extends AbstractAkdemiaServiceImpl<Evaluation, EvaluationBasicDTO, EvaluationFullDTO, IEvaluationRepository>
		implements IEvaluationService {

	@Resource(name = ConstsValues.ConstsDAO.EVALUATION_DAO_KEY)
	private IEvaluationRepository evaluationRepository;

	public EvaluationServiceImpl() {
		super(Evaluation.class, EvaluationBasicDTO.class, EvaluationFullDTO.class);
	}

	@Override
	public IEvaluationRepository getDAO() {
		return this.evaluationRepository;
	}
}
