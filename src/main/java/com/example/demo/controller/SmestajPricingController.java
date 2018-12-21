package com.example.demo.controller;

import com.example.demo.model.Smestaj;
import com.example.demo.model.SmestajPricing;
import com.example.demo.model.dto.PricingDTO;
import com.example.demo.service.SmestajPricingService;
import com.example.demo.service.SmestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pricing")
public class SmestajPricingController {

    private SmestajPricingService smestajPricingService;
    private SmestajService smestajService;

    @Autowired
    public SmestajPricingController(SmestajPricingService smestajPricingService, SmestajService smestajService){
        this.smestajPricingService = smestajPricingService;
        this.smestajService = smestajService;
    }

    @PostMapping("/{smestajId}")
    public boolean addSmestajPricing(@PathVariable("smestajId") long id, @RequestBody PricingDTO pricingDTO){
        boolean isAdded = false;
        if(smestajService.smestajExists(id) && smestajPricingService.smestajDontExist(id)) {
            Smestaj s = smestajService.findBySmestajId(id);
            SmestajPricing sp = new SmestajPricing(pricingDTO);
            sp.setSmestaj(s);
            smestajPricingService.savePricing(sp);
            isAdded = true;
        }
        return isAdded;
    }

}
