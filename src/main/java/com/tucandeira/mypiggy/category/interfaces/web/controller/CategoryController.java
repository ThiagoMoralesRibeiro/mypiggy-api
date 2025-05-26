package com.tucandeira.mypiggy.category.interfaces.web.controller;

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

import com.tucandeira.mypiggy.category.application.service.CategoryService;
import com.tucandeira.mypiggy.category.domain.model.Category;
import com.tucandeira.mypiggy.category.interfaces.web.dto.CategoryResponseDTO;
import com.tucandeira.mypiggy.category.application.service.CategoryService;
import com.tucandeira.mypiggy.category.interfaces.web.dto.CategoryRequestDTO;
import com.tucandeira.mypiggy.category.interfaces.web.dto.CategoryResponseDTO;
//import com.tucandeira.mypiggy.category.domain.model.Category;
//import com.tucandeira.mypiggy.category.interfaces.web.dto.*;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/category")
//@Validated
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<Page<CategoryResponseDTO>> getAllCategories(@RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "name") String sortBy) {
    Page<CategoryResponseDTO> categories = categoryService.getAllCategories(page, size, sortBy);
    if (categories.isEmpty())
      return ResponseEntity.noContent().build();
    return ResponseEntity.ok(categories);

  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoryResponseDTO> getCategoryById(Long id) {
    CategoryResponseDTO category = categoryService.getCategoryById(id);
    return ResponseEntity.ok(category);
  }

  @PostMapping
  public ResponseEntity<CategoryResponseDTO> createcategory(@Valid @RequestBody CategoryRequestDTO dto) {
    System.out.println("Received DTO: " + dto);
    return ResponseEntity.ok(categoryService.createCategory(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoryResponseDTO> updateTask(@PathVariable Long id, @RequestBody @Valid CategoryRequestDTO dto) {
    return ResponseEntity.ok(categoryService.updateCategory(id, dto));
  }

}
