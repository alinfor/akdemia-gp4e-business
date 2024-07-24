package af.cmr.indyli.akdemia.business.service;


import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.CompanyBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.CompanyFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.EmployeeFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes={AkdemiaBusinessGp4eConfig.class})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyServiceTest {
	@Resource(name = ConstsValues.ServiceKeys.COMPANY_SERVICE_KEY)
	private ICompanyService companyService;

	private CompanyFullDTO companyForAllTest = null;

	private Integer idCreatedCompany = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		CompanyFullDTO company = getSampleCompany();
		this.companyForAllTest = this.companyService.create(company);

		assertNotNull(company);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		CompanyFullDTO company = getSampleCompany();
		company.setEmail("company@gmail.com");
		company = this.companyService.create(company);
		idCreatedCompany = company.getId();

		assertNotNull(company);
	}

	@Test
	void testFindAll() {
		List<CompanyBasicDTO> companies = this.companyService.findAll();

		assertTrue(companies.size() > 0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		CompanyFullDTO company = this.companyService.findById(this.companyForAllTest.getId());
		assertNotNull(company);
		assertEquals(this.companyForAllTest.getActivity(), company.getActivity());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		CompanyFullDTO companyToUpdate = getSampleCompany();
		String updateActivity = "Updated Activity";
		companyToUpdate.setId(this.companyForAllTest.getId());
		companyToUpdate.setActivity(updateActivity);

		CompanyFullDTO updatedCompany = this.companyService.update(companyToUpdate);
		assertEquals(updateActivity, updatedCompany.getActivity());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		Integer id = this.companyForAllTest.getId();
		this.companyService.deleteById(id);

		assertNull(this.companyService.findById(id));
		this.companyForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (this.companyForAllTest != null)
			this.companyService.deleteById(this.companyForAllTest.getId());
		if (idCreatedCompany != null)
			this.companyService.deleteById(idCreatedCompany);
	}

	CompanyFullDTO getSampleCompany() {
		CompanyFullDTO company = new CompanyFullDTO();
		company.setAddress("DLA");
		company.setEmail("mail01@company.com");
		company.setName("SCP");
		company.setLogin("scplog");
		company.setPassword("pass123");
		company.setPhone("08765678900");
		company.setPhoto("/profil/company.jpg");
		company.setActivity("C-Activity");
		company.setCreationDate(new Date());
		return company;
	}

	EmployeeFullDTO getSampleEmployee() {
		EmployeeFullDTO user = new EmployeeFullDTO();
		user.setPhone("123456789");
		user.setEmail("example@example.com");
		user.setAddress("123 Example Street, City");
		user.setLogin("example_user");
		user.setPassword("example_password");
		user.setPhoto("path/to/photo.jpg");
		user.setCreationDate(new Date());
		user.setUpdateDate(new Date());
		user.setFirstname("John");
		user.setLastname("Doe");
		user.setGender("M");

		return user;
	}
}
