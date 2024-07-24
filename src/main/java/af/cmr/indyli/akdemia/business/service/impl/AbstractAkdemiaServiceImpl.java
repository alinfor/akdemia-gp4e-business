package af.cmr.indyli.akdemia.business.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import af.cmr.indyli.akdemia.business.dto.IDTO;
import af.cmr.indyli.akdemia.business.entity.IEntity;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IAbstractAkdemiaService;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import jakarta.annotation.Resource;

/**
 * Abstract class implementing the IAbstractAkdemiaService interface, providing
 * common functionality for service implementations managing entities in the
 * Akdemia system. This class handles basic CRUD operations for entities and DTO
 * mapping.
 *
 * @param <Entity>     The type of the entity handled by the service.
 * @param <BasicDTO>   The basic DTO type used for representing the entity.
 * @param <FullDTO>    The complete DTO type, extending the base type, used for
 *                     detailed representation of the entity.
 * @param <IEntityDAO> The type of the DAO (Data Access Object) used to interact
 *                     with the database.
 */
public abstract class AbstractAkdemiaServiceImpl<Entity extends IEntity, BasicDTO extends IDTO, FullDTO extends BasicDTO, IEntityDAO extends JpaRepository<Entity, Integer>>
		implements IAbstractAkdemiaService<Entity, BasicDTO, FullDTO, IEntityDAO> {
	private final Class<Entity> entityClass;
	private final Class<BasicDTO> basicClass;
	private final Class<FullDTO> fullClass;
	@Resource(name = "akdemia-modelmapper")
	private ModelMapper mapper;

	public AbstractAkdemiaServiceImpl(Class<Entity> myEntityClass, Class<BasicDTO> basicClass,
			Class<FullDTO> fullViewClass) {
		this.entityClass = myEntityClass;
		this.basicClass = basicClass;
		this.fullClass = fullViewClass;
	}

	public FullDTO create(FullDTO view) throws AkdemiaBusinessException {
		view.setCreationDate(new Date());
		Entity entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, this.entityClass));
		view.setId(entity.getId());
		return view;
	}

	public FullDTO update(FullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		viewToUpdate.setUpdateDate(new Date());
		Entity entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
		if (entity != null) {
			BeanUtils.copyProperties(viewToUpdate, entity);
			this.getDAO().saveAndFlush(entity);
		} else {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
		}
		return viewToUpdate;
	}

	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		this.getDAO().deleteById(id);
	}

	public List<BasicDTO> findAll() {
		List<Entity> list = this.getDAO().findAll();
		List<BasicDTO> viewList = new ArrayList<BasicDTO>();
		for (Entity ent : list) {
			BasicDTO view = this.getModelMapper().map(ent, this.basicClass);
			viewList.add(view);
		}
		return viewList;
	}

	public FullDTO findById(int id) throws AkdemiaBusinessException {
		Entity ent = this.getDAO().findById(id).orElse(null);
		if (ent == null) {
			return null;
		}
		return this.getModelMapper().map(ent, this.fullClass);
	}

	public boolean ifEntityExistById(int id) throws AkdemiaBusinessException {
		return this.getDAO().existsById(id);
	}

	public <T extends BasicDTO> T findById(int id, Class<T> type) {
		Entity ent = this.getDAO().findById(id).orElse(null);
		if (ent != null) {
			return this.getModelMapper().map(ent, type);
		}
		return null;
	}

	public abstract IEntityDAO getDAO();

	public ModelMapper getModelMapper() {
		return this.mapper;
	}

    @Override
    public List<FullDTO> fullAllList() {
        List<Entity> entities = getDAO().findAll();
        return entities.stream()
                       .map(entity -> getModelMapper().map(entity, fullClass))
                       .collect(Collectors.toList());
    }


}
