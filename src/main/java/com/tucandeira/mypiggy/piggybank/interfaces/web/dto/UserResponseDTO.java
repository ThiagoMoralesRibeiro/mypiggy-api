package com.tucandeira.mypiggy.user.interfaces.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tucandeira.mypiggy.user.domain.model.User;
//import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserResponseDTO {
  private Long id;
  private String name;
  private String email;
  // private String password;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;
  private String phoneNumber;
  private String cpf;
  private String cep;

  public UserResponseDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.birthDate = user.getBirthDate();
    this.phoneNumber = user.getPhoneNumber();
    this.cpf = user.getCpf();
    this.cep = user.getCep();

  }
}
