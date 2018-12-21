package com.example.demo.service;

import com.example.demo.model.Rezervacija;
import com.example.demo.model.Smestaj;
import com.example.demo.model.SmestajPricing;
import com.example.demo.repository.SmestajPricingRepository;
import com.example.demo.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmestajPricingService {

    private SmestajPricingRepository smestajPricingRepository;
    private SmestajRepository smestajRepository;

    @Autowired
    public SmestajPricingService(SmestajPricingRepository smestajPricingRepository, SmestajRepository smestajRepository){
        this.smestajRepository = smestajRepository;
        this.smestajPricingRepository = smestajPricingRepository;
    }
    public SmestajPricing getBySmestajId(long id) {
        return smestajPricingRepository.findBySmestajId(id);
    }

    public SmestajPricing savePricing(SmestajPricing smestajPricing) {
        return smestajPricingRepository.save(smestajPricing);
    }

    public void deletePricing(SmestajPricing smestajPricing) {
        smestajPricingRepository.delete(smestajPricing);
    }


    public boolean smestajDontExist(long id){
        boolean dontExist = false;
        if(smestajPricingRepository.findBySmestajId(id)==null){
            dontExist = true;
        }
        return dontExist;
    }

}
