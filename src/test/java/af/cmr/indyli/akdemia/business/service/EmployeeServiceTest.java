package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.EmployeeBasicDTO;
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

@ContextConfiguration(classes = { AkdemiaBusinessGp4eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.EMPLOYEE_SERVICE_KEY)
	private IEmployeeService employeeService;

	@Resource(name = ConstsValues.ServiceKeys.COMPANY_SERVICE_KEY)
	private ICompanyService companyService;
	private EmployeeFullDTO employeeForAllTest = null;
	private CompanyFullDTO companyForAllTest = null;
	private Integer idCratedEmpl = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		CompanyFullDTO company = getSampleCompany();
		this.companyForAllTest = this.companyService.create(company);

		EmployeeFullDTO employee = getSampleEmployee();
		employee.setCompany(companyForAllTest);
		this.employeeForAllTest = this.employeeService.create(employee);

		assertNotNull(company);
		assertNotNull(employee);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		EmployeeFullDTO employee = getSampleEmployee();
		employee.setEmail("nesk02@mail.lss");
		employee.setCompany(companyForAllTest);
		employee = this.employeeService.create(employee);

		idCratedEmpl = employee.getId();
		assertNotNull(employee);
	}

	@Test
	void testFindAll() {
		List<EmployeeBasicDTO> employees = this.employeeService.findAll();

		assertTrue(employees.size() > 0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		EmployeeFullDTO employee = this.employeeService.findById(this.employeeForAllTest.getId());
		assertNotNull(employee);
		assertEquals(employee.getAddress(), this.employeeForAllTest.getAddress());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		EmployeeFullDTO employeeToUpdate = getSampleEmployee();
		String updateAddr = "Updated Addr";
		employeeToUpdate.setId(this.employeeForAllTest.getId());
		employeeToUpdate.setAddress(updateAddr);

		EmployeeFullDTO updatedEmployee = this.employeeService.update(employeeToUpdate);
		assertEquals(updateAddr, updatedEmployee.getAddress());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.employeeService.deleteById(this.employeeForAllTest.getId());

		assertNull(this.employeeService.findById(this.employeeForAllTest.getId()));
		employeeForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (employeeForAllTest != null)
			this.employeeService.deleteById(this.employeeForAllTest.getId());
		if (idCratedEmpl != null)
			this.employeeService.deleteById(idCratedEmpl);
		if (companyForAllTest != null)
			this.companyService.deleteById(this.companyForAllTest.getId());

	}

	EmployeeFullDTO getSampleEmployee() {
		EmployeeFullDTO user = new EmployeeFullDTO();
		user.setPhone("123456789");
		user.setEmail("example08@example.com");
		user.setAddress("123 Example Street, City");
		user.setLogin("example_user");
		user.setPassword("example_password");
		user.setPhoto("path/to/photo.jpg");
		user.setCreationDate(new Date());
		user.setUpdateDate(new Date());

		return user;
	}

	CompanyFullDTO getSampleCompany() {
		CompanyFullDTO company = new CompanyFullDTO();
		company.setAddress("DLA");
		company.setEmail("mail07@company.com");
		company.setName("SCP");
		company.setLogin("scplog");
		company.setPassword("pass123");
		company.setPhone("08765678900");
		company.setPhoto("/profil/company.jpg");
		company.setActivity("C-Activity");
		company.setCreationDate(new Date());
		return company;
	}

}
