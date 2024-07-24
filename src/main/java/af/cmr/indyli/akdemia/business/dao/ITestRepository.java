package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Test;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Test} entities in
 * the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Test} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.TEST_DAO_KEY)
public interface ITestRepository extends JpaRepository<Test, Integer> {
}