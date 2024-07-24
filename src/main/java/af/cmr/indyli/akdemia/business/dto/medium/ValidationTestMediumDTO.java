package af.cmr.indyli.akdemia.business.dto.medium;

import af.cmr.indyli.akdemia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akdemia.business.dto.basic.ValidationTestBasicDTO;
import af.cmr.indyli.akdemia.business.entity.ValidationTest;

/**
 * This class represents a medium Data Transfer Object (DTO) for a
 * {@link ValidationTest} entity. It extends {@link ValidationTestBasicDTO} and
 * inherits basic information about a validation. Medium DTOs typically include
 * additional details beyond the basic DTO but exclude complex associations like
 * lists.
 */
public class ValidationTestMediumDTO extends ValidationTestBasicDTO {

	private TestBasicDTO test;

	public ValidationTestMediumDTO() {
	}

	public TestBasicDTO getTest() {
		return test;
	}

	public void setTest(TestBasicDTO test) {
		this.test = test;
	}

}