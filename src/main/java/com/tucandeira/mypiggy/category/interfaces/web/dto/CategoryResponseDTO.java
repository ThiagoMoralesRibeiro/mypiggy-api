package com.tucandeira.mypiggy.category.interfaces.web.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tucandeira.mypiggy.category.domain.model.Category;
import com.tucandeira.mypiggy.user.domain.model.User;
//import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryResponseDTO {
  private Long id;
  private String name;
  private String description;

  public CategoryResponseDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();

  }
}
