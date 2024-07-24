package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.ITestRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TestFullDTO;
import af.cmr.indyli.akdemia.business.entity.Test;
import af.cmr.indyli.akdemia.business.service.ITestService;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Service implementation class for managing {@link Test} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing tests, including CRUD operations.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.TEST_SERVICE_KEY)
public class TestServiceImpl extends AbstractAkdemiaServiceImpl<Test, TestBasicDTO, TestFullDTO, ITestRepository>
		implements ITestService {

	@Resource(name = ConstsValues.ConstsDAO.TEST_DAO_KEY)
	private ITestRepository testRepository;

	public TestServiceImpl() {
		super(Test.class, TestBasicDTO.class, TestFullDTO.class);
	}

	@Override
	public ITestRepository getDAO() {
		return this.testRepository;
	}
}
