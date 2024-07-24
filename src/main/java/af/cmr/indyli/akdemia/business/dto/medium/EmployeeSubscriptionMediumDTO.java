package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;

public class EmployeeSubscriptionMediumDTO extends EmployeeSubscriptionBasicDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeBasicDTO employeeBasicDTO;
	 private IntraSessionBasicDTO intraSession;

	public EmployeeSubscriptionMediumDTO() {
	}

	public EmployeeBasicDTO getEmployeeBasicDTO() {
		return employeeBasicDTO;
	}

	public void setEmployeeBasicDTO(EmployeeBasicDTO employeeBasicDTO) {
		this.employeeBasicDTO = employeeBasicDTO;
	}

	public IntraSessionBasicDTO getIntraSession() {
		return intraSession;
	}

	public void setIntraSession(IntraSessionBasicDTO intraSession) {
		this.intraSession = intraSession;
	}


}
