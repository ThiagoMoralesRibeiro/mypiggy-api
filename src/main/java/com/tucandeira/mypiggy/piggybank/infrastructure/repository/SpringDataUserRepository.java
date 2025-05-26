package com.tucandeira.mypiggy.user.infrastructure.repository;

//import com.tucandeira.mypiggy.user.domain.model.User;
import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;

//import org.hibernate.query.Page;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByEmail(String email);
  Optional<UserEntity> findByCpf(String cpf);
  boolean existsByCpf(String cpf);
  boolean existsByEmail(String email);
  Page<UserEntity> findAll(Pageable pageable);
}
