package af.cmr.indyli.akdemia.business.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import af.cmr.indyli.akdemia.business.entity.IntraSession;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;

@Repository(value = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
public interface IIntraSessionRepository extends JpaRepository<IntraSession, Integer> {
	Optional<IntraSession> findIntraSessionById (Integer Id);
	IntraSession findByCode(String code);
}
