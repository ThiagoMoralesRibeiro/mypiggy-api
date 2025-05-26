package com.tucandeira.mypiggy.user.application.service;

//import org.apache.coyote.BadRequestException;
import com.tucandeira.mypiggy.shared.exception.*;
//import org.hibernate.query.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.tucandeira.mypiggy.user.domain.model.User;
import com.tucandeira.mypiggy.user.domain.repository.UserRepository;
import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;
import com.tucandeira.mypiggy.user.infrastructure.repository.SpringDataUserRepository;
import com.tucandeira.mypiggy.user.interfaces.web.dto.UserRequestDTO;
import com.tucandeira.mypiggy.user.interfaces.web.dto.UserResponseDTO;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;

  @Autowired

  public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
    System.out.println("UserRepository implementation class: " + userRepository.getClass().getName());
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
    this.passwordEncoder = passwordEncoder;
  }

  public UserResponseDTO createUser(UserRequestDTO dto) {
    if (userRepository.existsByEmail(dto.getEmail())) {
      throw new BadRequestException("Email already registered");
    }

    if (userRepository.existsByCpf(dto.getCpf())) {
      throw new BadRequestException("CPF already registered");
    }

    User user = modelMapper.map(dto, User.class);
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    User saved = userRepository.save(user);

    return modelMapper.map(saved, UserResponseDTO.class);
  }

  /*
   * public UserResponseDTO createUser(UserRequestDTO dto) {
   * System.out.println("DTO password: " + dto.getPassword());
   * 
   * // Faça a conversão manual
   * User user = dto.transformToObject();
   * 
   * // Verifique se chegou na entidade
   * System.out.println("User password before encoding: " + user.getPassword());
   * 
   * user.setPassword(passwordEncoder.encode(user.getPassword()));
   * User saved = userRepository.save(user);
   * return modelMapper.map(saved, UserResponseDTO.class);
   * }
   */

  public Page<UserResponseDTO> getAllUsers(int page, int size, String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
    Page<User> users = userRepository.findAll(pageable);

    if (users == null || users.isEmpty()) {
      return Page.empty(pageable);
    }

    return users.map(UserResponseDTO::new);
  }

  public UserResponseDTO getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    return new UserResponseDTO(user);
  }

  public void deleteUser(Long id) {
    if (!userRepository.findById(id).isPresent()) {
      throw new ResourceNotFoundException("User not found");
    }
    userRepository.deleteById(id);
  }

  public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
    User existingUser = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    modelMapper.map(dto, existingUser);

    User updated = userRepository.save(existingUser);
    return modelMapper.map(updated, UserResponseDTO.class);
  }

}
