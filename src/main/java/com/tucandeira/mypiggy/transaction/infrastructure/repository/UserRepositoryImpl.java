package com.tucandeira.mypiggy.user.infrastructure.repository;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tucandeira.mypiggy.user.domain.model.User;
import com.tucandeira.mypiggy.user.domain.repository.UserRepository;
import com.tucandeira.mypiggy.user.infrastructure.persistence.UserEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public class UserRepositoryImpl implements UserRepository {

  private final SpringDataUserRepository jpaRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public UserRepositoryImpl(SpringDataUserRepository jpaRepository, ModelMapper modelMapper) {
    this.jpaRepository = jpaRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return jpaRepository.findByEmail(email)
        .map(entity -> modelMapper.map(entity, User.class));
  }

  @Override
  public Optional<User> findByCpf(String cpf) {
    return jpaRepository.findByCpf(cpf)
        .map(entity -> modelMapper.map(entity, User.class));
  }

  @Override
  public boolean existsByEmail(String email) {
    return jpaRepository.existsByEmail(email);
  }

  @Override
  public boolean existsByCpf(String cpf) {
    return jpaRepository.existsByCpf(cpf);
  }

  @Override
  public Page<User> findAll(Pageable pageable) {
    return jpaRepository.findAll(pageable)
        .map(entity -> modelMapper.map(entity, User.class));
  }

  @Override
  public User save(User user) {
    UserEntity entity = modelMapper.map(user, UserEntity.class);
    UserEntity savedEntity = jpaRepository.save(entity);
    return modelMapper.map(savedEntity, User.class);
  }

  @Override
  public Optional<User> findById(Long id) {
    return jpaRepository.findById(id)
        .map(entity -> modelMapper.map(entity, User.class));
  }

  @Override
  public void deleteById(Long id){
    jpaRepository.deleteById(id);
  }
  

}
