package af.cmr.indyli.akdemia.business.service;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.AccessDeniedException;
import java.util.List;

/**
 * Interface defining basic operations for an Akdemia service, allowing
 * manipulation and management of entities with different types of DTOs (Data
 * Transfer Objects). This interface provides methods to create, update, delete,
 * and retrieve entities, as well as to check the existence of an entity by its
 * identifier.
 *
 * @param <Entity>     The type of the entity manipulated by the service.
 * @param <BasicDTO>   The basic type of the DTO used to represent the entity.
 * @param <FullDTO>    The complete type of the DTO, extending the base type,
 *                     used to represent the entity with more details.
 * @param <IEntityDAO> The type of the DAO (Data Access Object) used to interact
 *                     with the database.
 */

public interface IAbstractAkdemiaService<Entity, BasicDTO, FullDTO extends BasicDTO, IEntityDAO extends JpaRepository<Entity, Integer>> {
	public FullDTO create(FullDTO ent) throws AkdemiaBusinessException;

	public FullDTO update(FullDTO entToUpdate) throws AkdemiaBusinessException, AccessDeniedException;

	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException;

	public List<BasicDTO> findAll();
	

	public FullDTO findById(int id) throws AkdemiaBusinessException;

	public boolean ifEntityExistById(int id) throws AkdemiaBusinessException;

	public <T extends BasicDTO> T findById(int id, Class<T> type) throws AkdemiaBusinessException;

//	public IEntityDAO getDAO();
	
	public List<FullDTO> fullAllList();


}
