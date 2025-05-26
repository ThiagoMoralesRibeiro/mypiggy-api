package com.tucandeira.mypiggy.user.interfaces.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tucandeira.mypiggy.user.domain.model.User;
import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
  @NotBlank(message = "Name is required")
  private String name;
  @Email
  @NotBlank(message = "Email is required")
  private String email;
  @Size(min = 8, message = "Password must be at least 8 characters")  
  @NotBlank(message = "Password is required")
  private String password;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;
  @NotBlank(message = "Phone number is required")
  @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format. Use E.164 format (e.g., +5511999999999)")
  private String phoneNumber;
  @NotBlank(message = "CPF is required")
  @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "Invalid CPF format. Use XXX.XXX.XXX-XX")
  private String cpf;
  @NotBlank(message = "CEP is required")
  private String cep;

  public User transformToObject() {
    return new User(
        name,
        email,
        password,
        birthDate,
        phoneNumber,
        cpf,
        cep);
  }

}
