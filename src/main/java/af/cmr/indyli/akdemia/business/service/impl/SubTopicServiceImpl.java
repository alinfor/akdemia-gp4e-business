package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ISubTopicRepository;
import af.cmr.indyli.akdemia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SubTopicFullDTO;
import af.cmr.indyli.akdemia.business.entity.SubTopic;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ISubTopicService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

/**
 * Service implementation class for managing {@link SubTopic} entity, extending
 * the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing sub-topics, including CRUD operations and
 * validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.SUB_TOPIC_SERVICE_KEY)
public class SubTopicServiceImpl
		extends AbstractAkdemiaServiceImpl<SubTopic, SubTopicBasicDTO, SubTopicFullDTO, ISubTopicRepository>
		implements ISubTopicService {

	@Resource(name = ConstsValues.ConstsDAO.SUB_TOPIC_DAO_KEY)
	private ISubTopicRepository subTopicRepository;

	public SubTopicServiceImpl() {
		super(SubTopic.class, SubTopicBasicDTO.class, SubTopicFullDTO.class);
	}

	@Override
	public ISubTopicRepository getDAO() {
		return this.subTopicRepository;
	}

	@Override
	public SubTopicFullDTO create(SubTopicFullDTO view) throws AkdemiaBusinessException {
		SubTopic subTopic = this.getDAO().findBySubthemeTitle(view.getSubthemeTitle());
		if (subTopic == null) {
			view.setCreationDate(new Date());
			SubTopic entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, SubTopic.class));
			view.setId(entity.getId());
			return view;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG06);
	}

	@Override
	public SubTopicFullDTO update(SubTopicFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		boolean isSubThemeExist = this.findAll().stream()
				.anyMatch(p -> viewToUpdate.getSubthemeTitle().equals(p.getSubthemeTitle())
						&& !viewToUpdate.getId().equals(p.getId()));

		if (!isSubThemeExist) {
			viewToUpdate.setUpdateDate(new Date());
			SubTopic entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
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
		var tmpTrainings = this.findById(id);

		if (tmpTrainings == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}
			this.getDAO().deleteById(id);

	}
}