package com.tucandeira.mypiggy.category.infrastructure.repository;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tucandeira.mypiggy.category.domain.model.Category;
import com.tucandeira.mypiggy.category.domain.repository.CategoryRepository;
import com.tucandeira.mypiggy.category.infrastructure.persistence.CategoryEntity;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

  private final SpringDataCategoryRepository jpaRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public CategoryRepositoryImpl(SpringDataCategoryRepository jpaRepository, ModelMapper modelMapper) {
    this.jpaRepository = jpaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public Category save(Category category) {
    CategoryEntity entity = modelMapper.map(category, CategoryEntity.class);
    CategoryEntity saved = jpaRepository.save(entity);
    return modelMapper.map(saved, Category.class);
  }

  @Override
  public boolean existsByName(String name) {
    return jpaRepository.existsByName(name);
  }

  @Override
  public Optional<Category> findById(Long categoryId) {
    return jpaRepository.findById(categoryId)
        .map(entity -> modelMapper.map(entity, Category.class));
  }

  @Override
  public Page<Category> findAll(Pageable pageable) {
    return jpaRepository.findAll(pageable)
        .map(entity -> modelMapper.map(entity, Category.class));
  }

  @Override
  public void delete(Long categoryId) {
    jpaRepository.deleteById(categoryId);
  }
}
