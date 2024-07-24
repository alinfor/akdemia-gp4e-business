package af.cmr.indyli.akdemia.business.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.TrainingBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.RequirementFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TrainingFullDTO;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;


@ContextConfiguration(classes = { AkdemiaBusinessGp4eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TrainingServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.TRAINING_SERVICE_KEY)
	private ITrainingService trainingService;
	@Resource(name = ConstsValues.ServiceKeys.REQUIREMENT_SERVICE_KEY)
	private IRequirementService requirementService;
	private TrainingFullDTO trainingForAllTest = null;
	private RequirementFullDTO requirementForAllTest = null;
	private Integer idCratedTraining = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		RequirementFullDTO requirement = getSampleRequirement();
		this.requirementForAllTest = this.requirementService.create(requirement);

		TrainingFullDTO training = getSampleTraining();
		training.setRequirement(this.requirementForAllTest);
		this.trainingForAllTest = this.trainingService.create(training);

		assertNotNull(training);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		TrainingFullDTO training = getSampleTraining();
		training.setTitle("PHP 7 et MySQL 8");
		idCratedTraining = this.trainingService.create(training).getId();

		assertNotNull(idCratedTraining);
	}

	@Test
	void testFindAll() {
		List<TrainingBasicDTO> trainings = this.trainingService.findAll();

		assertTrue(trainings.size()>0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		TrainingFullDTO training = this.trainingService.findById(this.trainingForAllTest.getId());
		assertNotNull(training);
		assertEquals(training.getTitle(), this.trainingForAllTest.getTitle());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		TrainingFullDTO trainingToUpdate = getSampleTraining();
		String updateTitle = "Updated Addr";
		trainingToUpdate.setId(this.trainingForAllTest.getId());
		trainingToUpdate.setTitle(updateTitle);

		TrainingFullDTO updatedTraining = this.trainingService.update(trainingToUpdate);
		assertEquals(updateTitle, updatedTraining.getTitle());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.trainingService.deleteById(this.trainingForAllTest.getId());

		assertNull(this.trainingService.findById(this.trainingForAllTest.getId()));
		this.trainingForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (this.trainingForAllTest != null)
			this.trainingService.deleteById(this.trainingForAllTest.getId());
		if (idCratedTraining != null)
			this.trainingService.deleteById(idCratedTraining);
		this.requirementService.deleteById(this.requirementForAllTest.getId());

	}

	TrainingFullDTO getSampleTraining() {
		TrainingFullDTO training = new TrainingFullDTO();
		training.setTitle("Example Training Java");
		training.setDescription("Example training description");
		training.setTrainingPrice(99.99);
		training.setLogo("path/to/logo.jpg");
		training.setCreationDate(new Date());

		training.setRequirement(null);

		return training;
	}

	RequirementFullDTO getSampleRequirement() {
		RequirementFullDTO requirement = new RequirementFullDTO();
		requirement.setName("Example Requirement");
		requirement.setDescription("Example requirement description");
		requirement.setLink("https://example.com");
		requirement.setCreationDate(new Date());
		requirement.setUpdateDate(new Date());

		return requirement;
	}
}
