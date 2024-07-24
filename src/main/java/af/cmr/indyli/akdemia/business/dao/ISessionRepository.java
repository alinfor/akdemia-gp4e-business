package af.cmr.indyli.akdemia.business.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Repository(value = ConstsValues.ConstsDAO.SESSION_DAO_KEY)
public interface ISessionRepository extends JpaRepository<Session, Integer> {
	Optional<Session> findSessionById(Integer Id);
//	public Session findByCode(String code); 
	
}
