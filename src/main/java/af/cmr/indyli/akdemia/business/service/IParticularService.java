package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IParticularRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularFullDTO;
import af.cmr.indyli.akdemia.business.entity.Particular;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * particular, providing specific operations for {@link Particular} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IParticularService
		extends IAbstractAkdemiaService<Particular, ParticularBasicDTO, ParticularFullDTO, IParticularRepository> {
}
