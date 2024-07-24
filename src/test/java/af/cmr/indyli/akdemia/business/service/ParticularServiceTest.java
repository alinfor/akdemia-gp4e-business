package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.ParticularBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.ParticularFullDTO;
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
public class ParticularServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.PARTICULAR_SERVICE_KEY)
	private IParticularService particularService;
	private ParticularFullDTO particularForAllTest = null;
	private Integer idCratedParticular = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		ParticularFullDTO particular = getSampleParticular();
		particular = this.particularService.create(particular);

		this.particularForAllTest = particular;

		assertNotNull(particular);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		ParticularFullDTO particular = getSampleParticular();
		particular.setEmail("newUser@gmail.com");
		particular = this.particularService.create(particular);
		idCratedParticular = particular.getId();

		assertNotNull(particular);
	}

	@Test
	void testFindAll() {
		List<ParticularBasicDTO> particulars = this.particularService.findAll();

		assertTrue(particulars.size() > 0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		ParticularFullDTO particular = this.particularService.findById(this.particularForAllTest.getId());
		assertNotNull(particular);
		assertEquals(particular.getAddress(), this.particularForAllTest.getAddress());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		ParticularFullDTO particularToUpdate = getSampleParticular();
		String updateAddr = "Updated Addr";
		particularToUpdate.setId(this.particularForAllTest.getId());
		particularToUpdate.setAddress(updateAddr);

		ParticularFullDTO updatedParticular = this.particularService.update(particularToUpdate);
		assertEquals(updatedParticular.getAddress(), updateAddr);
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.particularService.deleteById(this.particularForAllTest.getId());

		assertNull(this.particularService.findById(this.particularForAllTest.getId()));
		particularForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (this.particularForAllTest != null)
			this.particularService.deleteById(this.particularForAllTest.getId());
		if (idCratedParticular != null)
			this.particularService.deleteById(idCratedParticular);
	}

	ParticularFullDTO getSampleParticular() {
		ParticularFullDTO user = new ParticularFullDTO();
		user.setPhone("123456789");
		user.setEmail("example04@example.com");
		user.setAddress("123 Example Street, City");
		user.setLogin("example_user");
		user.setPassword("example_password");
		user.setPhoto("path/to/photo.jpg");
		user.setActivity("Veterinary");
		user.setCreationDate(new Date());
		user.setUpdateDate(new Date());

		return user;
	}
}