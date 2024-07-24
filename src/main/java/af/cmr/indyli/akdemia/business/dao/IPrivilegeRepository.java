package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Privilege;
import af.cmr.indyli.akdemia.business.entity.Role;
import af.cmr.indyli.akdemia.business.entity.User;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface serves as a repository for managing {@link Privilege} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Privilege} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
public interface IPrivilegeRepository extends JpaRepository<Privilege, Integer> {
	List<Privilege> findByRole(Role role);

	List<Privilege> findByUser(User user);
}
