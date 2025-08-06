package com.example.employee.Service;

import com.example.employee.dao.entities.User;
import com.example.employee.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.map(user -> user.getPassword().equals(password)).orElse(false);
    }

    public boolean register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return false; // utilisateur existe déjà
        }
        User newUser = new User(username, password);
        userRepository.save(newUser);
        return true;
    }
}
