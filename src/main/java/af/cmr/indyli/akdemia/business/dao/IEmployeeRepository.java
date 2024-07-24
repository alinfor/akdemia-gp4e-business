package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Company;
import af.cmr.indyli.akdemia.business.entity.Employee;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Employee} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Employee} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.EMPLOYEE_DAO_KEY)
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	public Employee findByCompany(Company company);
}