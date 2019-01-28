package com.example.demo.repository;

import com.example.demo.model.Smestaj;
import com.example.demo.model.SmestajPricing;
import com.example.demo.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    Smestaj findById(long smestajId);
    List<Smestaj> findByAgent(User user);


}
