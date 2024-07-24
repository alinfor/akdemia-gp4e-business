package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dto.basic.TopicBasicDTO;
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
public class ThemeServiceTest {

	@Resource(name = ConstsValues.ServiceKeys.TOPIC_SERVICE_KEY)
	private ITopicService topicService;
	private TopicFullDTO themeForAllTest = null;

	private Integer idCreatedTheme = null;

	@BeforeEach
	void setUp() throws AkdemiaBusinessException {
		TopicFullDTO theme = getSampleTheme();
		this.themeForAllTest = this.topicService.create(theme);

		System.out.println("ID CREATE... " + themeForAllTest.getId());

		assertNotNull(theme);
	}

	@Test
	void testCreate() throws AkdemiaBusinessException {
		TopicFullDTO theme = getSampleTheme();
		theme.setThemeTitle("Language du web");
		theme = this.topicService.create(theme);
		idCreatedTheme = theme.getId();

		assertNotNull(theme);
	}

	@Test
	void testFindAll() {
		List<TopicBasicDTO> themes = this.topicService.findAll();

		assertTrue(themes.size() > 0);
	}

	@Test
	void testFindById() throws AkdemiaBusinessException {
		TopicFullDTO theme = this.topicService.findById(this.themeForAllTest.getId());
		assertNotNull(theme);
		assertEquals(this.themeForAllTest.getThemeTitle(), theme.getThemeTitle());
	}

	@Test
	void testUpdate() throws AkdemiaBusinessException, AccessDeniedException {
		TopicFullDTO themeToUpdate = getSampleTheme();
		String updateName = "Updated Name";
		themeToUpdate.setId(this.themeForAllTest.getId());
		themeToUpdate.setThemeTitle(updateName);

		TopicFullDTO updatedTheme = this.topicService.update(themeToUpdate);
		assertEquals(updateName, updatedTheme.getThemeTitle());
	}

	@Test
	void testDelete() throws AkdemiaBusinessException, AccessDeniedException {
		this.topicService.deleteById(this.themeForAllTest.getId());

		assertNull(this.topicService.findById(this.themeForAllTest.getId()));
		themeForAllTest = null;
	}

	@AfterEach
	void rollback() throws AkdemiaBusinessException, AccessDeniedException {
		if (themeForAllTest != null)
			this.topicService.deleteById(this.themeForAllTest.getId());
		if (idCreatedTheme != null)
			this.topicService.deleteById(idCreatedTheme);
	}

	TopicFullDTO getSampleTheme() {
		TopicFullDTO theme = new TopicFullDTO();
		theme.setThemeTitle("Example Topic");
		theme.setDescription("Example theme description");
		theme.setCreationDate(new Date());

		return theme;
	}
}
