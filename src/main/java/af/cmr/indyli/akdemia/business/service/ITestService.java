package af.cmr.indyli.akdemia.business.service;

import af.cmr.indyli.akdemia.business.dao.ITestRepository;
import af.cmr.indyli.akdemia.business.dto.basic.TestBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.TestFullDTO;
import af.cmr.indyli.akdemia.business.entity.Test;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing tests,
 * providing specific operations for {@link Test} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface ITestService extends IAbstractAkdemiaService<Test, TestBasicDTO, TestFullDTO, ITestRepository> {
}