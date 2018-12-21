package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
       this.userRepository = userRepository;
       this.passwordEncoder = passwordEncoder;
    }

    public User findByUsernameAndPassword(String username, String password) throws NotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new NotFoundException("Wrong username or password!");
        }
        return user;
    }
    
    
    
}
