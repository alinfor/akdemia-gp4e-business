package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Requirement;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Requirement}
 * entities in the database. It extends JpaRepository, providing CRUD operations
 * for the {@link Requirement} entity with Integer as the type of its primary
 * key.
 */
@Repository(value = ConstsValues.ConstsDAO.REQUIREMENT_DAO_KEY)
public interface IRequirementRepository extends JpaRepository<Requirement, Integer> {
}
