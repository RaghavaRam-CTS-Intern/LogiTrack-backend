package com.cognizant.logitrack.serviceImplementation;

import com.cognizant.logitrack.service.UserService;
import com.cognizant.logitrack.exception.BadRequestException;
import com.cognizant.logitrack.exception.ResourceNotFoundException;
import com.cognizant.logitrack.dto.RegisterRequestDTO;
import com.cognizant.logitrack.dto.UserDTO;
import com.cognizant.logitrack.entity.User;
import com.cognizant.logitrack.enums.UserStatus;
import com.cognizant.logitrack.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(RegisterRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new BadRequestException("Email already exists: " + dto.getEmail());
        }
        User user = User.builder().name(dto.getName()).email(dto.getEmail()).role(dto.getRole()).phone(dto.getPhone()).hubId(dto.getHubId()).passwordHash(passwordEncoder.encode(dto.getPassword())).status(UserStatus.ACTIVE).build();
        User saved = userRepository.save(user);
        log.info("User created: {}", saved.getEmail());
        return toDTO(saved);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUserStatus(Integer id, UserStatus status) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setStatus(status);
        User saved = userRepository.save(user);
        log.info("User status updated: {} -> {}", saved.getEmail(), status);
        return toDTO(saved);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setStatus(UserStatus.INACTIVE);
        userRepository.save(user);
        log.info("User soft-deleted: {}", user.getEmail());
    }

    private UserDTO toDTO(User user) {
        return UserDTO.builder().userId(user.getUserId()).name(user.getName()).role(user.getRole()).email(user.getEmail()).phone(user.getPhone()).hubId(user.getHubId()).status(user.getStatus()).build();
    }
}
