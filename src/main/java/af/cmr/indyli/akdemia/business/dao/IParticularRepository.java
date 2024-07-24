package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Particular;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Particular}
 * entities in the database. It extends JpaRepository, providing CRUD operations
 * for the {@link Particular} entity with Integer as the type of its primary
 * key.
 */
@Repository(value = ConstsValues.ConstsDAO.PARTICULAR_DAO_KEY)
public interface IParticularRepository extends JpaRepository <Particular, Integer> {
}