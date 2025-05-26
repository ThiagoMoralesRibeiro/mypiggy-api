package com.tucandeira.mypiggy.category.infrastructure.persistence;

import com.tucandeira.mypiggy.category.domain.model.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class CategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required")
  private String name;

  private String description;

  public CategoryEntity() {
  }

  public CategoryEntity(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public static CategoryEntity fromModel(Category category){
    if(category == null){
      return null;
    }
    return new CategoryEntity(category.getId(), category.getName(), category.getDescription());
  }

  public Category toModel(){
    Category category = new Category(
      name, description
    );
    category.setId(id);
    return category;
  }

  // Getters and setters

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
