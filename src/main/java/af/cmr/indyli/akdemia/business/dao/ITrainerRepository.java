package af.cmr.indyli.akdemia.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.Trainer;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Repository(value = ConstsValues.ConstsDAO.TRAINER_DAO_KEY)
public interface ITrainerRepository extends JpaRepository<Trainer, Integer> {

}
