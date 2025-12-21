package com.pedrosaez.englishtrainer.domain.service;


import com.pedrosaez.englishtrainer.domain.entity.User;
import com.pedrosaez.englishtrainer.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.map(user -> user.getPassword().equals(password)).orElse(false);
    }

    public boolean register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return false;
        }
        userRepository.save(new User(username, password));
        return true;
    }


}
