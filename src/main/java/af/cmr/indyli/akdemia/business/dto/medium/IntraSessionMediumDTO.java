package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.IntraSessionBasicDTO;




public class IntraSessionMediumDTO extends IntraSessionBasicDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8066653311497150131L;
	private CompanyBasicDTO company;
	private EmployeeSubscriptionBasicDTO emploSubscription;


	public CompanyBasicDTO getCompany() {
		return company;
	}
	public void setCompany(CompanyBasicDTO company) {
		this.company = company;
	}
	public EmployeeSubscriptionBasicDTO getEmploSubscription() {
		return emploSubscription;
	}
	public void setEmploSubscription(EmployeeSubscriptionBasicDTO emploSubscription) {
		this.emploSubscription = emploSubscription;
	}

}
