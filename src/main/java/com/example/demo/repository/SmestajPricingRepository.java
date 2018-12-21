package com.example.demo.repository;

import com.example.demo.model.SmestajPricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmestajPricingRepository extends JpaRepository<SmestajPricing,Long> {

    SmestajPricing findBySmestajId(long id);

}
