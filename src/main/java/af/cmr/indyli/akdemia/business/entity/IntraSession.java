package af.cmr.indyli.akdemia.business.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "AKDEMIA_INTRA_SESSION")
public class IntraSession extends Session {
	
	
	@JoinColumn(name = "ID_AKDEMIA_COMPANY")
	@ManyToOne
    private Company company;

	
	@OneToMany(mappedBy = "intraSession", fetch = FetchType.EAGER)
	private List<EmployeeSubscription> employeeSubscriptions;



	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
