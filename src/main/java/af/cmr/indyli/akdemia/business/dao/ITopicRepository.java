package af.cmr.indyli.akdemia.business.dao;

import af.cmr.indyli.akdemia.business.entity.Topic;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface serves as a repository for managing {@link Topic} entities in
 * the database. It extends JpaRepository, providing CRUD operations for the
 * {@link Topic} entity with Integer as the type of its primary key.
 */
@Repository(value = ConstsValues.ConstsDAO.TOPIC_DAO_KEY)
public interface ITopicRepository extends JpaRepository<Topic, Integer> {
	Topic findByThemeTitle(String themeTitle);
}