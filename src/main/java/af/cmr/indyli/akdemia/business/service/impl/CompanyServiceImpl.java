package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ICompanyRepository;
import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akdemia.business.entity.Company;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.ICompanyService;
import af.cmr.indyli.akdemia.business.service.IUserService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstRejectBusinessMessage;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;

/**
 * Service implementation class for managing Company entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing companies, including CRUD operations and validation.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.COMPANY_SERVICE_KEY)
public class CompanyServiceImpl
		extends AbstractAkdemiaServiceImpl<Company, CompanyBasicDTO, CompanyFullDTO, ICompanyRepository>
		implements ICompanyService {
	@Resource(name = ConstsValues.ConstsDAO.COMPANY_DAO_KEY)
	private ICompanyRepository companyRepository;

	@Resource(name = ConstsValues.ServiceKeys.USER_SERVICE_KEY)
	private IUserService userService;

	public CompanyServiceImpl() {
		super(Company.class, CompanyBasicDTO.class, CompanyFullDTO.class);

	}

	@Override
	public CompanyFullDTO create(CompanyFullDTO view) throws AkdemiaBusinessException {
		if (!userService.isExistUserByEmail(view.getEmail())) {
			view.setCreationDate(new Date());
			Company entity = this.getDAO().saveAndFlush(this.getModelMapper().map(view, Company.class));

			return this.getModelMapper().map(entity, CompanyFullDTO.class);
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public CompanyFullDTO update(CompanyFullDTO viewToUpdate) throws AkdemiaBusinessException, AccessDeniedException {
		if (!userService.isExistUserByEmail(viewToUpdate.getEmail(), viewToUpdate.getId())) {
			viewToUpdate.setUpdateDate(new Date());
			Company entity = this.getDAO().findById(viewToUpdate.getId()).orElse(null);
			if (entity != null) {
				BeanUtils.copyProperties(viewToUpdate, entity);
				this.getDAO().saveAndFlush(entity);
			} else {
				throw new AkdemiaBusinessException(ConstRejectBusinessMessage.UPDATE_OBJECT_NOT_FOUND);
			}
			return viewToUpdate;
		}
		throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
	}

	@Override
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException {
		var tmpCompany = this.findById(id);

		if (tmpCompany == null) {
			throw new AkdemiaBusinessException(ConstRejectBusinessMessage.DELETE_OBJECT_NOT_FOUND);
		}
//		else if (!tmpCompany.getIntraSessions().isEmpty()) {
//			throw new AkdemiaBusinessException(ConstBusinessRules.RG19);
//		}

		getDAO().deleteById(id);
	}

	@Override
	public ICompanyRepository getDAO() {
		return this.companyRepository;
	}

}
