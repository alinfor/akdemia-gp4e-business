package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Company;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Company} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * Company entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.COMPANY_DAO_KEY)
public interface ICompanyRepository extends JpaRepository<Company, Integer> {
}
