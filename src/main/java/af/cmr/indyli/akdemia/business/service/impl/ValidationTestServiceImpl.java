package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IValidationTestRepository;
import af.cmr.indyli.akdemia.business.dto.basic.ValidationTestBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ValidationTestFullDTO;
import af.cmr.indyli.akdemia.business.entity.ValidationTest;
import af.cmr.indyli.akdemia.business.service.IValidationTestService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link ValidationTest} entity,
 * extending the AbstractAkdemiaServiceImpl class. This class provides specific
 * functionality for managing validation tests, including CRUD operations.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.VALIDATION_TEST_SERVICE_KEY)
public class ValidationTestServiceImpl extends
		AbstractAkdemiaServiceImpl<ValidationTest, ValidationTestBasicDTO, ValidationTestFullDTO, IValidationTestRepository>
		implements IValidationTestService {

	@Resource(name = ConstsValues.ConstsDAO.VALIDATION_TEST_DAO_KEY)
	private IValidationTestRepository validationTestRepository;

	public ValidationTestServiceImpl() {
		super(ValidationTest.class, ValidationTestBasicDTO.class, ValidationTestFullDTO.class);
	}

	@Override
	public IValidationTestRepository getDAO() {
		return this.validationTestRepository;
	}
}