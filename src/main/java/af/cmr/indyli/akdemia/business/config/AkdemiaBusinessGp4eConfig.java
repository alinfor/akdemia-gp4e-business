package af.cmr.indyli.akdemia.business.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class represents the configuration for the Akdemia business module. It
 * enables JPA auditing, scans for entity classes, repository interfaces, and
 * components within the specified base packages, and defines a singleton bean
 * for the ModelMapper instance.
 */
@Configuration
@EnableJpaAuditing
@EntityScan("af.cmr.indyli.akdemia.business.entity")
@EnableJpaRepositories("af.cmr.indyli.akdemia.business.dao")
@ComponentScan(basePackages = { "af.cmr.indyli.akdemia.business.*" })
public class AkdemiaBusinessGp4eConfig {

	@Bean(value = "akdemia-modelmapper")
	@Scope(value = "singleton")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean(value = "BCRYPT_ENCODER")
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
