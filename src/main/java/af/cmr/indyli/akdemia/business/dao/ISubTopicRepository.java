package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.SubTopic;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link SubTopic} entities
 * in the database. It extends JpaRepository, providing CRUD operations for the
 * {@link SubTopic} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.SUB_TOPIC_DAO_KEY)
public interface ISubTopicRepository extends JpaRepository<SubTopic, Integer> {
	SubTopic findBySubthemeTitle(String subthemeTitle);
}