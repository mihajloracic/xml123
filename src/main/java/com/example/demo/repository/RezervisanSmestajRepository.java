package com.example.demo.repository;

import com.example.demo.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezervisanSmestajRepository extends JpaRepository<Rezervacija,Long> {



}
