package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EvaluationBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akdemia.business.entity.Evaluation;

/**
 * This class represents a medium Data Transfer Object (DTO) for an
 * {@link Evaluation} entity. It extends {@link EvaluationBasicDTO} and inherits
 * basic information about an evaluation. Medium DTOs typically include
 * additional details beyond the basic DTO but exclude complex associations like
 * lists.
 */
public class EvaluationMediumDTO extends EvaluationBasicDTO {
	private EmployeeBasicDTO employee;

	private ParticularBasicDTO particular;

	public EvaluationMediumDTO() {
		super();
	}

	public EmployeeBasicDTO getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBasicDTO employee) {
		this.employee = employee;
	}

	public ParticularBasicDTO getParticular() {
		return particular;
	}

	public void setParticular(ParticularBasicDTO particular) {
		this.particular = particular;
	}
}
