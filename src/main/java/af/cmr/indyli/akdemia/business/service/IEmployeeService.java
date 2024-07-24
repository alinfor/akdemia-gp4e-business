package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.IEmployeeRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.entity.Employee;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;

import java.util.List;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * employees, providing specific operations for {@link Employee} entities.
 *
 * @see IAbstractAkdemiaService
 */
public interface IEmployeeService extends IAbstractAkdemiaService<Employee, EmployeeBasicDTO, EmployeeFullDTO, IEmployeeRepository> {

	public EmployeeFullDTO findEmployeeByCompany(Integer idCompany) throws AkdemiaBusinessException;

	public List<EmployeeFullDTO> findAllFull();
}
