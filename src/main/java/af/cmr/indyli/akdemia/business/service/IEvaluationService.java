package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IEvaluationRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EvaluationFullDTO;
import af.cmr.indyli.akdemia.business.entity.Evaluation;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * Evaluation, providing specific operations for {@link Evaluation} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IEvaluationService
		extends IAbstractAkdemiaService<Evaluation, EvaluationBasicDTO, EvaluationFullDTO, IEvaluationRepository> {

}
