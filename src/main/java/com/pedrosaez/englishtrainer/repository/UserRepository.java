package com.pedrosaez.englishtrainer.repository;

import com.pedrosaez.englishtrainer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
