package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ITrainerRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainerFullDTO;
import af.cmr.indyli.akdemia.business.entity.Trainer;

public interface ITrainerService extends IAbstractAkdemiaService<Trainer, TrainerBasicDTO, TrainerFullDTO, ITrainerRepository> {

}
