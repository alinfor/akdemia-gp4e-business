package af.cmr.indyli.akdemia.business.service;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import af.cmr.indyli.akdemia.business.config.AkdemiaBusinessGp4eConfig;
import af.cmr.indyli.akdemia.business.dao.IEmployeeSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dao.IParticularSubscriptionRepository;
import af.cmr.indyli.akdemia.business.dao.ISessionRepository;
import af.cmr.indyli.akdemia.business.dto.full.SessionFullDTO;
import af.cmr.indyli.akdemia.business.entity.Session;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.impl.SessionServiceImpl;

@ContextConfiguration(classes = { AkdemiaBusinessGp4eConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SessionServiceTest {
	

    @Autowired
    private SessionServiceImpl sessionService;

    @MockBean
    private ISessionRepository sessionRepository;

    @MockBean
    private IEmployeeSubscriptionRepository employeeSubscriptionRepository;

    @MockBean
    private IParticularSubscriptionRepository particularSubscriptionRepository;

    
    private SessionFullDTO sampleSession;

    @BeforeEach
    void setUp() {

        sampleSession = new SessionFullDTO();
        sampleSession.setId(1);
        sampleSession.setCode("SAMPLE_SESSION");
        sampleSession.setDate(new Date());
    }

    @AfterEach
    void tearDown() {        
        sampleSession = null;
    }

   
   
    @Test
    void testDeleteSession() throws AkdemiaBusinessException, AccessDeniedException {
        
        when(sessionRepository.findById(anyInt()))
                .thenReturn(Optional.of(new Session()));
        when(employeeSubscriptionRepository.existsById(anyInt()))
                .thenReturn(false); 
        when(particularSubscriptionRepository.existsById(anyInt()))
                .thenReturn(false); 

        
        sessionService.deleteById(sampleSession.getId());

        
        verify(sessionRepository, times(1)).deleteById(anyInt());
    }
    
  
    
	
    
 


}