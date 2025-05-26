package com.tucandeira.mypiggy.user.domain.model;

import java.time.LocalDate;

public class User {
  private Long id;
  private String name;
  private String email;
  private String password;
  private LocalDate birthDate;
  private String phoneNumber;
  private String cpf;
  private String cep;

  public User(){}

  public User(String name, String email, String password, LocalDate birthDate, String phoneNumber,
      String cpf, String cep) {
    this.setName(name);
    this.setEmail(email);
    this.setPassword(password);
    this.setBirthDate(birthDate);
    this.setPhoneNumber(phoneNumber);
    this.setCpf(cpf);
    this.setCep(cep);
  }

  /*public User(Long id, String name, String email) {
    this.setId(id);
    this.setName(name);
    this.setEmail(email);
    //this.password = null;
    this.birthDate = null;
    this.phoneNumber = null;
    this.cpf = null;
    this.cep = null;
  }*/

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getName() {
    return name;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getCpf() {
    return cpf;
  }

  public String getCep() {
    return cep;
  }

}
