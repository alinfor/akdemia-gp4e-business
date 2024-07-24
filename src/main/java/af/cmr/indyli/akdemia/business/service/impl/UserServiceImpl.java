package af.cmr.indyli.akdemia.business.service.impl;

import af.cmr.indyli.akdemia.business.dao.IManagerRepository;
import af.cmr.indyli.akdemia.business.dao.IPrivilegeRepository;
import af.cmr.indyli.akdemia.business.dao.IRoleRepository;
import af.cmr.indyli.akdemia.business.dao.IUserRepository;
import af.cmr.indyli.akdemia.business.dto.UserRegistrationDTO;
import af.cmr.indyli.akdemia.business.dto.UserRegistrationResponseDTO;
import af.cmr.indyli.akdemia.business.dto.basic.UserBasicDTO;
import af.cmr.indyli.akdemia.business.dto.full.UserFullDTO;
import af.cmr.indyli.akdemia.business.entity.Manager;
import af.cmr.indyli.akdemia.business.entity.Privilege;
import af.cmr.indyli.akdemia.business.entity.Role;
import af.cmr.indyli.akdemia.business.entity.User;
import af.cmr.indyli.akdemia.business.exception.AkdemiaBusinessException;
import af.cmr.indyli.akdemia.business.service.IUserService;
import af.cmr.indyli.akdemia.business.utils.ConstBusinessRules;
import af.cmr.indyli.akdemia.business.utils.ConstsValues;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * Service implementation class for managing {@link User} entity, extending the
 * AbstractAkdemiaServiceImpl class. This class provides specific functionality
 * for managing users, including CRUD operations.
 *
 * @see AbstractAkdemiaServiceImpl
 */
@Service(ConstsValues.ServiceKeys.USER_SERVICE_KEY)
public class UserServiceImpl extends AbstractAkdemiaServiceImpl<User, UserBasicDTO, UserFullDTO, IUserRepository> implements IUserService, UserDetailsService {
    @Resource(name = ConstsValues.ConstsDAO.USER_DAO_KEY)
    private IUserRepository userRepository;

    @Resource(name = ConstsValues.ConstsDAO.MANAGER_DAO_KEY)
    private IManagerRepository managerRepository;

    @Resource(name = ConstsValues.ConstsDAO.ROLE_DAO_KEY)
    private IRoleRepository roleRepository;

    @Resource(name = ConstsValues.ConstsDAO.PRIVILEGE_DAO_KEY)
    private IPrivilegeRepository privilegeRepository;

    @Resource(name = "BCRYPT_ENCODER")
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        super(User.class, UserBasicDTO.class, UserFullDTO.class);

    }

    @Override
    public IUserRepository getDAO() {
        return this.userRepository;
    }

    @Override
    public boolean isExistUserByEmail(String email) {
        return this.findAll().stream().anyMatch(u -> email.equals(u.getEmail()));
    }

    @Override
    public boolean isExistUserByEmail(String email, Integer id) {
        return this.findAll().stream().anyMatch(u -> email.equals(u.getEmail()) && !id.equals(u.getId()));
    }

    @Override
    public UserFullDTO findUserByEmail(String email) {
        Optional<User> user = this.getDAO().findUserByEmail(email);
        if (user.isPresent()) {
            return getModelMapper().map(user, UserFullDTO.class);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = userRepository.findUserByEmail(username);
        return userDetail.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    @Override
    public UserRegistrationResponseDTO registerUser(UserRegistrationDTO dto) throws AkdemiaBusinessException {
        User user = new User();

        if (isExistUserByEmail(dto.getEmail())) {
            throw new AkdemiaBusinessException(ConstBusinessRules.RG02);
        }

        Role role = roleRepository.findByRoleName(dto.getRoleName());

        if (dto.getRoleName().equalsIgnoreCase("manager")) {
            Manager manager = this.getModelMapper().map(dto, Manager.class);
            manager.setCreationDate(new Date());
            manager.setPassword(passwordEncoder.encode(dto.getPassword()));
            user = managerRepository.save(manager);
        }
        user = this.getModelMapper().map(dto, User.class);
        user.setCreationDate(new Date());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user = userRepository.save(user);

        Privilege privilege = new Privilege();
        privilege.setUser(user);
        privilege.setRole(role);
        privilege.setCreationDate(new Date());

        privilegeRepository.save(privilege);

        return new UserRegistrationResponseDTO(user.getId(), user.getEmail());
    }
}