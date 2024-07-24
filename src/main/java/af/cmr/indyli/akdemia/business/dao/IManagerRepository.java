package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Manager;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Manager} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Manager} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.MANAGER_DAO_KEY)
public interface IManagerRepository extends JpaRepository<Manager, Integer> {

	Manager findByEmail(String email);
}