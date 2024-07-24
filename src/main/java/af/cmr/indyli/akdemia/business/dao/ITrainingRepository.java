package af.cmr.indyli.akdemia.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.Training;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Repository(value = ConstsValues.ConstsDAO.TRAINING_DAO_KEY)
public interface ITrainingRepository extends JpaRepository<Training, Integer> {
	Training findByTitle(String title);
}
