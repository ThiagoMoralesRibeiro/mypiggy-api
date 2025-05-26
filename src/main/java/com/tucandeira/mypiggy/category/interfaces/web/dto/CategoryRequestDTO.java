
package com.tucandeira.mypiggy.category.interfaces.web.dto;

import com.tucandeira.mypiggy.category.domain.model.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDTO {

  @NotBlank(message = "Name is required")
  private String name;

  private String description;

  public Category transformToObject() {
    return new Category(name, description);
  }

}
