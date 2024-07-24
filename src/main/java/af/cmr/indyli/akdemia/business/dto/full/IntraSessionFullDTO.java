package af.cmr.indyli.akdemia.business.dto.full;

import java.util.List;

import af.cmr.indyli.akdemia.business.dto.medium.EmployeeSubscriptionMediumDTO;
import af.cmr.indyli.akdemia.business.dto.medium.IntraSessionMediumDTO;

public class IntraSessionFullDTO extends IntraSessionMediumDTO {

	
	private List<EmployeeSubscriptionMediumDTO> employeeSubscription ;
	
	public IntraSessionFullDTO(){		
	}

	public List<EmployeeSubscriptionMediumDTO> getEmployeeSubscription() {
		return employeeSubscription;
	}

	public void setEmployeeSubscription(List<EmployeeSubscriptionMediumDTO> employeeSubscription) {
		this.employeeSubscription = employeeSubscription;
	}
	
	

}
