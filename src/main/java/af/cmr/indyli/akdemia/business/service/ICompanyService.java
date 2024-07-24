package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ICompanyRepository;
import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akdemia.business.entity.Company;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * companies, providing specific operations for {@link Company} entities.
 *
 * @see IAbstractAkdemiaService
 */

public interface ICompanyService
		extends IAbstractAkdemiaService<Company, CompanyBasicDTO, CompanyFullDTO, ICompanyRepository> {
}