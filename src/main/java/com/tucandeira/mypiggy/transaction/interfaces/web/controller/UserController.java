package com.tucandeira.mypiggy.user.interfaces.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tucandeira.mypiggy.user.application.service.UserService;
import com.tucandeira.mypiggy.user.interfaces.web.dto.UserRequestDTO;
import com.tucandeira.mypiggy.user.interfaces.web.dto.UserResponseDTO;
//import com.tucandeira.mypiggy.user.domain.model.User;
//import com.tucandeira.mypiggy.user.interfaces.web.dto.*;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/user")
//@Validated
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<Page<UserResponseDTO>> getAllUsers(@RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy) {
    Page<UserResponseDTO> users = userService.getAllUsers(page, size, sortBy);
    if (users.isEmpty())
      return ResponseEntity.noContent().build();
    return ResponseEntity.ok(users);

  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(Long id) {
    UserResponseDTO user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO dto) {
    System.out.println("Received DTO: " + dto);
    return ResponseEntity.ok(userService.createUser(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponseDTO> updateTask(@PathVariable Long id, @RequestBody @Valid UserRequestDTO dto) {
    return ResponseEntity.ok(userService.updateUser(id, dto));
  }

}
