package com.example.demo.repository;

import com.example.demo.model.Smestaj;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(@Param("username") String username);

}
