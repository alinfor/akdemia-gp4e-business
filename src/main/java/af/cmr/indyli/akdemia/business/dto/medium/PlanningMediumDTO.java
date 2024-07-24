package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.PlanningBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.PrivilegeBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Privilege;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link Privilege} entity. It extends {@link PrivilegeBasicDTO} and inherits
 * basic information about a requirement. Medium DTOs typically include
 * additional details beyond the basic DTO but exclude complex associations like
 * lists.
 */
public class PlanningMediumDTO extends PlanningBasicDTO {
	private CompanyBasicDTO company;

	public PlanningMediumDTO() {
	}

	public PlanningMediumDTO(CompanyBasicDTO company) {
		this.company = company;
	}

	public CompanyBasicDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyBasicDTO company) {
		this.company = company;
	}

}
