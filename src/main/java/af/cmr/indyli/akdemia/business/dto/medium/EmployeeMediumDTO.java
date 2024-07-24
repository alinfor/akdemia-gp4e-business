package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Employee;

/**
 * This class represents a medium Data Transfer Object (DTO) for an
 * {@link Employee} entity. It extends {@link EmployeeBasicDTO} and inherits
 * basic information about an employee. Medium DTOs typically include additional
 * details beyond the basic DTO but exclude complex associations like lists.
 */
public class EmployeeMediumDTO extends EmployeeBasicDTO {
	private CompanyBasicDTO company;

	public EmployeeMediumDTO() {
	}

	public CompanyBasicDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyBasicDTO company) {
		this.company = company;
	}
}
