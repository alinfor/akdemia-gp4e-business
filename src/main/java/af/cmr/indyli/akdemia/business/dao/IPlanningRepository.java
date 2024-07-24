package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Planning;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Planning} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Planning} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.PLANNING_DAO_KEY)
public interface IPlanningRepository extends JpaRepository<Planning, Integer> {
}
