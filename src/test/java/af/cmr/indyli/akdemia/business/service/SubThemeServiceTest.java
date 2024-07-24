package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.SubTopicFullDTO;
import af.cmr.indyli.akdemia.business.dto.full.TopicFullDTO;
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
public class SubThemeServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.TOPIC_SERVICE_KEY)
	private ITopicService topicService;

	@Resource(name = ConstsValues.ServiceKeys.SUB_TOPIC_SERVICE_KEY)
	private ISubTopicService subTopicService;
	private SubTopicFullDTO subThemeForAllTest = null;
	private TopicFullDTO themeForAllTest = null;

	private Integer idSubThemeCreated = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		TopicFullDTO theme = getSampleTheme();
		this.themeForAllTest = this.topicService.create(theme);

		SubTopicFullDTO subTheme = getSampleSubTheme();
		this.subThemeForAllTest = this.subTopicService.create(subTheme);

		assertNotNull(subTheme);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		SubTopicFullDTO subTheme = getSampleSubTheme();

		subTheme.setThemes(List.of(this.themeForAllTest));
		subTheme.setSubthemeTitle("Laravel framework");

		subTheme = this.subTopicService.create(subTheme);
		idSubThemeCreated = subTheme.getId();

		assertNotNull(subTheme);
	}

	@Test
	void testFindAll() {
		List<SubTopicBasicDTO> subThemes = this.subTopicService.findAll();

		assertTrue(subThemes.size() > 0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		SubTopicFullDTO subTheme = this.subTopicService.findById(this.subThemeForAllTest.getId());

		assertNotNull(subTheme);
		assertEquals(this.subThemeForAllTest.getSubthemeTitle(), subTheme.getSubthemeTitle());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		SubTopicFullDTO subThemeToUpdate = getSampleSubTheme();
		String updateName = "Updated Name";

		subThemeToUpdate.setId(this.subThemeForAllTest.getId());
		subThemeToUpdate.setSubthemeTitle(updateName);

		SubTopicFullDTO updatedSubTheme = this.subTopicService.update(subThemeToUpdate);
		assertEquals(updateName, updatedSubTheme.getSubthemeTitle());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.topicService.deleteById(this.themeForAllTest.getId());

		assertNull(this.topicService.findById(this.themeForAllTest.getId()));
		this.themeForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (this.subThemeForAllTest != null)
			this.subTopicService.deleteById(this.subThemeForAllTest.getId());
		if (idSubThemeCreated != null)
			this.subTopicService.deleteById(idSubThemeCreated);
		if (this.themeForAllTest != null)
			this.topicService.deleteById(this.themeForAllTest.getId());

	}

	SubTopicFullDTO getSampleSubTheme() {
		SubTopicFullDTO subTheme = new SubTopicFullDTO();
		subTheme.setSubthemeTitle("Example SubTopic");
		subTheme.setDescription("Example subtheme description");
		subTheme.setCreationDate(new Date());
		subTheme.setUpdateDate(new Date());

		return subTheme;
	}

	TopicFullDTO getSampleTheme() {
		TopicFullDTO theme = new TopicFullDTO();
		theme.setThemeTitle("Example Topic");
		theme.setDescription("Example theme description");
		theme.setCreationDate(new Date());

		return theme;
	}
}
