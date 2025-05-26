package com.tucandeira.mypiggy.category.domain.repository;
// Em: user.domain.repository

import com.tucandeira.mypiggy.category.domain.model.Category;
import com.tucandeira.mypiggy.user.domain.model.User;
import java.util.Optional;

//import com.tucandeira.mypiggy.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface CategoryRepository{
	Category save(Category category);
  boolean existsByName(String name);
	Optional<Category> findById(Long categoryId);
	Page<Category> findAll(Pageable pageable);
	void delete(Long categoryId);
}

