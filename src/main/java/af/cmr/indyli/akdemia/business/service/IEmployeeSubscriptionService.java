package af.cmr.indyli.akdemia.business.service;


import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;

import af.cmr.indyli.akdemia.business.dto.basic.EmployeeSubscriptionBasicDTO;

import af.cmr.indyli.akdemia.business.dto.full.EmployeeSubscriptionFullDTO;

import af.cmr.indyli.akdemia.business.entity.EmployeeSubscription;


public interface IEmployeeSubscriptionService 
	extends IAbstractAkdemiaService <EmployeeSubscription, EmployeeSubscriptionBasicDTO, EmployeeSubscriptionFullDTO, IEmployeeSubscriptionRepository> {


}