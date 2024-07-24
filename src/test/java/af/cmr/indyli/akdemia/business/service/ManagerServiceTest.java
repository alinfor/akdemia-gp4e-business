package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.ManagerBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ManagerFullDTO;
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
public class ManagerServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.MANAGER_SERVICE_KEY)
	private IManagerService managerService;
	private ManagerFullDTO managerForAllTest = null;
	private Integer idCratedManager = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		ManagerFullDTO manager = getSampleManager();
		manager = this.managerService.create(manager);

		this.managerForAllTest = manager;

		assertNotNull(manager);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		ManagerFullDTO manager = getSampleManager();
		manager.setEmail("manager@gmail.com");
		manager = this.managerService.create(manager);
		idCratedManager = manager.getId();

		assertNotNull(manager);
	}

	@Test
	void testFindAll() {
		List<ManagerBasicDTO> managers = this.managerService.findAll();

		assertTrue(managers.size() > 0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		ManagerFullDTO manager = this.managerService.findById(this.managerForAllTest.getId());
		assertNotNull(manager);
		assertEquals(manager.getAddress(), this.managerForAllTest.getAddress());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		ManagerFullDTO managerToUpdate = getSampleManager();
		String updateAddr = "Updated Addr";
		managerToUpdate.setId(this.managerForAllTest.getId());
		managerToUpdate.setAddress(updateAddr);

		ManagerFullDTO updatedManager = this.managerService.update(managerToUpdate);
		assertEquals(updateAddr, updatedManager.getAddress());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.managerService.deleteById(this.managerForAllTest.getId());

		assertNull(this.managerService.findById(this.managerForAllTest.getId()));
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		this.managerService.deleteById(this.managerForAllTest.getId());
		if (idCratedManager != null)
			this.managerService.deleteById(idCratedManager);
	}

	ManagerFullDTO getSampleManager() {
		ManagerFullDTO user = new ManagerFullDTO();
		user.setPhone("123456789");
		user.setEmail("example05@example.com");
		user.setAddress("123 Example Street, City");
		user.setLogin("example_user");
		user.setPassword("example_password");
		user.setPhoto("path/to/photo.jpg");
		user.setCreationDate(new Date());

		return user;
	}
}