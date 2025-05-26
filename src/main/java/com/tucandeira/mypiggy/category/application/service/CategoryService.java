package com.tucandeira.mypiggy.category.application.service;

//import org.apache.coyote.BadRequestException;
import com.tucandeira.mypiggy.shared.exception.*;
//import org.hibernate.query.Page;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.Category;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.tucandeira.mypiggy.category.domain.model.Category;
import com.tucandeira.mypiggy.category.domain.repository.CategoryRepository;
import com.tucandeira.mypiggy.category.infrastructure.persistence.CategoryEntity;
import com.tucandeira.mypiggy.category.infrastructure.repository.SpringDataCategoryRepository;
import com.tucandeira.mypiggy.category.interfaces.web.dto.CategoryRequestDTO;
import com.tucandeira.mypiggy.category.interfaces.web.dto.CategoryResponseDTO;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;
  private final ModelMapper modelMapper;

  @Autowired

  public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper,
      PasswordEncoder passwordEncoder) {
    System.out.println("CategoryRepository implementation class: " + categoryRepository.getClass().getName());
    this.categoryRepository = categoryRepository;
    this.modelMapper = modelMapper;
  }

  public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
    if (categoryRepository.existsByName(dto.getName())) {
      throw new BadRequestException("Category name already registered");
    }

    Category category = modelMapper.map(dto, Category.class);

    Category saved = categoryRepository.save(category);

    return modelMapper.map(saved, CategoryResponseDTO.class);
  }

  /*
   * public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
   * System.out.println("DTO password: " + dto.getPassword());
   * 
   * // Faça a conversão manual
   * Category category = dto.transformToObject();
   * 
   * // Verifique se chegou na entidade
   * System.out.println("Category password before encoding: " +
   * category.getPassword());
   * 
   * category.setPassword(passwordEncoder.encode(category.getPassword()));
   * Category saved = categoryRepository.save(category);
   * return modelMapper.map(saved, CategoryResponseDTO.class);
   * }
   */

  public Page<CategoryResponseDTO> getAllCategories(int page, int size, String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
    Page<Category> category = categoryRepository.findAll(pageable);

    if (category == null || category.isEmpty()) {
      return Page.empty(pageable);
    }

    return category.map(CategoryResponseDTO::new);
  }

  public CategoryResponseDTO getCategoryById(Long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + id));
    return new CategoryResponseDTO(category);
  }

  public void deleteCategory(Long id) {
    if (!categoryRepository.findById(id).isPresent()) {
      throw new ResourceNotFoundException("Category not found");
    }
    categoryRepository.delete(id);
  }

  public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto) {
    Category existingCategory = categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

    modelMapper.map(dto, existingCategory);

    Category updated = categoryRepository.save(existingCategory);
    return modelMapper.map(updated, CategoryResponseDTO.class);
  }

}
