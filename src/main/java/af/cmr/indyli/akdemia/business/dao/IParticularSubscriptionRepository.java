package af.cmr.indyli.akdemia.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.ParticularSubscription;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;


@Repository(value = ConstsValues.ConstsDAO.PARTICULAR_SUBSCRIPTION_DAO_KEY)
public interface IParticularSubscriptionRepository extends JpaRepository<ParticularSubscription,Integer> {
	
	boolean existsById(Integer id);

}
