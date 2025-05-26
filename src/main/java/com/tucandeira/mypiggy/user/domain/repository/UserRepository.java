package com.tucandeira.mypiggy.user.domain.repository;
// Em: user.domain.repository

import com.tucandeira.mypiggy.user.domain.model.User;
import java.util.Optional;

//import com.tucandeira.mypiggy.user.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findByCpf(String cpf);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);

    Page<User> findAll(Pageable pageable);

    User save(User user);

    Optional<User> findById(Long id);

    void deleteById(Long id);

}

