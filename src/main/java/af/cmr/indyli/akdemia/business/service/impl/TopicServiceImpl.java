package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ITopicRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TopicFullDTO;
import af.cmr.indyli.akdemia.business.entity.Topic;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ITopicService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

/**
 * Service implementation class for managing {@link Topic} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing topics, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.TOPIC_SERVICE_KEY)
public class TopicServiceImpl extends AbstractAkdemiaServiceImpl<Topic, TopicBasicDTO, TopicFullDTO, ITopicRepository>
		implements ITopicService {

	@Resource(name = ConstsValues.ConstsDAO.TOPIC_DAO_KEY)
	private ITopicRepository topicRepository;

	public TopicServiceImpl() {
		super(Topic.class, TopicBasicDTO.class, TopicFullDTO.class);
	}

	@Override
	public ITopicRepository getDAO() {
		return this.topicRepository;
	}

	@Override
	public TopicFullDTO create(TopicFullDTO view) throws AkdemiaBusinessException {
		Topic topic = this.getDAO().findByThemeTitle(view.getThemeTitle());
		if (topic == null) {
			view.setCreationDate(new Date());
			Topic entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Topic.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG05);
	}

	@Override
	public TopicFullDTO update(TopicFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isThemeExist = this.findAll().stream().anyMatch(
				p -> viewToUpdate.getThemeTitle().equals(p.getThemeTitle()) && !viewToUpdate.getId().equals(p.getId()));
		if (!isThemeExist) {
			viewToUpdate.setUpdateDate(new Date());
			Topic entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG06);
	}

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpSubTheme = this.findById(id);

		if (tmpSubTheme == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}

		if (tmpSubTheme.getSubThemes().isEmpty()) {
			this.getDAO().deleteById(id);
		} else {
			throw new AkdemiaBusinessException(ConstBusinessRules.RG15);
		}
	}
}