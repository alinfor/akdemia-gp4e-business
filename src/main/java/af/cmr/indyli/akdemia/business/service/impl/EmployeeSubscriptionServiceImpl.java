package af.cmr.indyli.akdemia.business.service.impl;

import org.springframework.stereotype.Service;

import af.cmr.indyli.akdemia.business.dao.IEmployeeRepository;
import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dao.IIntraSessionRepository;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.InterSessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.SessionBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.InterSessionFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;
import af.cmr.indyli.akdemia.business.entity.InterSession;
import af.cmr.indyli.akdemia.business.service.IEmployeeSubscriptionService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
@Service (ConstsValues.ServiceKeys.EMPLOYEE_SUBSCRIPTION_SERVICE_KEY)
public class EmployeeSubscriptionServiceImpl 
extends 
AbstractAkdemiaServiceImpl <EmployeeSubscription, EmployeeSubscriptionBasicDTO, EmployeeSubscriptionFullDTO, IEmployeeSubscriptionRepository>
implements IEmployeeSubscriptionService
{


	
	
	@Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_SUBSCRIPTION_DAO_KEY)
	private IEmployeeSubscriptionRepository employeeSubscriptionRepository;	
	@Resource(name = ConstsValues.ConstsDAO.INTRA_SESSION_DAO_KEY)
	private IIntraSessionRepository intraEmployeeSubscriptionRepository;	
	@Resource(name = ConstsValues.ConstsDAO.EMPLOYEE_DAO_KEY)
	private IEmployeeRepository emRepository;
	
	public EmployeeSubscriptionServiceImpl() {
		super(EmployeeSubscription.class, EmployeeSubscriptionBasicDTO.class, EmployeeSubscriptionFullDTO.class);
	}
	
	
	public IEmployeeSubscriptionRepository getEmployeeSubscriptionRepository() {
		return employeeSubscriptionRepository;
	}
	public void setEmployeeSubscriptionRepository(IEmployeeSubscriptionRepository employeeSubscriptionRepository) {
		this.employeeSubscriptionRepository = employeeSubscriptionRepository;
	}
	public IIntraSessionRepository getIntraEmployeeSubscriptionRepository() {
		return intraEmployeeSubscriptionRepository;
	}
	public void setIntraEmployeeSubscriptionRepository(IIntraSessionRepository intraEmployeeSubscriptionRepository) {
		this.intraEmployeeSubscriptionRepository = intraEmployeeSubscriptionRepository;
	}
	public IEmployeeRepository getEmRepository() {
		return emRepository;
	}
	public void setEmRepository(IEmployeeRepository emRepository) {
		this.emRepository = emRepository;
	}
	@Override
	public IEmployeeSubscriptionRepository getDAO() {
		return this.employeeSubscriptionRepository;
	}





}
