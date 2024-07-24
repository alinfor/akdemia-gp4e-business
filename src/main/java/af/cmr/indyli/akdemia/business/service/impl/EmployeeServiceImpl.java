package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ICompanyRepository;
import af.cmr.indyli.akdemia.business.dao.IEmployeeRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.entity.Company;
import af.cmr.indyli.akdemia.business.entity.Employee;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IEmployeeService;
import af.cmr.indyli.akdemia.business.service.IUserService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

/**
 * Service implementation class for managing {@link Employee} entity, extending
 * the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing employees, including CRUD operations and
 * validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.EMPLOYEE_SERVICE_KEY)
public class EmployeeServiceImpl
		extends AbstractAkdemiaServiceImpl<Employee, EmployeeBasicDTO, EmployeeFullDTO, IEmployeeRepository>
		implements IEmployeeService {
	@Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_DAO_KEY)
	private IEmployeeRepository employeeRepository;

	@Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
	private IUserService userService;

	@Resource(name = ConstsValues.ConstsDAO.COMPANY_DAO_KEY)
	private ICompanyRepository companyRepository;

	public EmployeeServiceImpl() {
		super(Employee.class, EmployeeBasicDTO.class, EmployeeFullDTO.class);
	}

	@Override
	public IEmployeeRepository getDAO() {
		return this.employeeRepository;
	}

	@Override
	public EmployeeFullDTO findEmployeeByCompany(Integer idCompany) throws AkdemiaBusinessException {
		Company company = companyRepository.findById(idCompany).orElse(null);
		if (company == null)
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.OBJECT_SEARCHED_NOT_FOUND);
		return getModelMapper().map(getDAO().findByCompany(company), EmployeeFullDTO.class);
	}

	@Override
	public EmployeeFullDTO create(EmployeeFullDTO view) throws AkdemiaBusinessException {
		if (!userService.isExistUserByEmail(view.getEmail())) {
			view.setCreationDate(new Date());
			Employee entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Employee.class));

			return this.getModelMapper().map(entity, EmployeeFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public EmployeeFullDTO update(EmployeeFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
			viewToUpdate.setUpdateDate(new Date());
			Employee entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpEmployee = this.findById(id);

		if (tmpEmployee == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}
//		else if (!tmpEmployee.getEmployeeSubscriptions().isEmpty()) {
//			throw new AkdemiaBusinessException(ConstBusinessRules.RG16);
//		}

		getDAO().deleteById(id);

	}

	@Override
	public List<EmployeeFullDTO> findAllFull() {
		return this.getDAO().findAll().stream().map(p -> this.getModelMapper().map(p, EmployeeFullDTO.class)).toList();
	}
}
