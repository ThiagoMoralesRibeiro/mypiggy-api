package com.tucandeira.mypiggy.category.infrastructure.repository;

import com.tucandeira.mypiggy.category.infrastructure.persistence.CategoryEntity;
//import com.tucandeira.mypiggy.user.domain.model.User;
import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;

//import org.hibernate.query.Page;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpringDataCategoryRepository extends JpaRepository<CategoryEntity, Long> {
  Page<CategoryEntity> findAll(Pageable pageable);
  boolean existsByName(String name);

}
