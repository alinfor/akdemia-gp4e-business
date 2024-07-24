package af.cmr.indyli.akdemia.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Repository(value = ConstsValues.ConstsDAO.EMPLOYEE_SUBSCRIPTION_DAO_KEY)
public interface IEmployeeSubscriptionRepository extends JpaRepository<EmployeeSubscription, Integer> {
	
	boolean existsById(Integer Id);

}
