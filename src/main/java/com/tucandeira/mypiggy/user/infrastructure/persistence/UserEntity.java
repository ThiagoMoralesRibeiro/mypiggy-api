package com.tucandeira.mypiggy.user.infrastructure.persistence;

import java.time.LocalDate;

import com.tucandeira.mypiggy.user.domain.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")

public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "Name is required")
  private String name;
  @Email
  @NotBlank(message = "Email is required")
  private String email;
  @NotBlank(message = "Password is required")
  @Size(min = 8, message = "Password must be greater than 8 characters")
  private String password;
  private LocalDate birthDate;
  private String phoneNumber;
  @NotBlank(message = "CPF is required")
  private String cpf;
  private String cep;

  public UserEntity() {
  }

  public UserEntity(Long id, String name, String email, String password, LocalDate birthDate, String phoneNumber,
      String cpf, String cep) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password; // pensar em como vamos aplicar o hash nas senhas
    this.birthDate = birthDate;
    this.phoneNumber = phoneNumber;
    this.cpf = cpf;
    this.cep = cep;
  }

  public static UserEntity fromModel(User user) {
    if (user == null) {
      return null;
    }
    return new UserEntity(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getBirthDate(),
        user.getPhoneNumber(), user.getCpf(), user.getCep());
  }

  public User toModel() {
    User user = new User(
        name, email, password, birthDate, phoneNumber, cpf, cep);
    user.setId(id);
    return user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

}
