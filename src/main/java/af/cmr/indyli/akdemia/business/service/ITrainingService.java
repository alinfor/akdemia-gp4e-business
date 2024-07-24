package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ITrainingRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.entity.Training;

public interface ITrainingService extends IAbstractAkdemiaService<Training, TrainingBasicDTO, TrainingFullDTO, ITrainingRepository> {

}
