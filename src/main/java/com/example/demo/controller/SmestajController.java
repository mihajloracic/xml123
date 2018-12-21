package com.example.demo.controller;

import com.example.demo.model.Smestaj;
import com.example.demo.model.User;
import com.example.demo.service.SmestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/smestaj")
@CrossOrigin
public class SmestajController {

    private SmestajService smestajService;

    @Autowired
    public SmestajController(SmestajService smestajService) {
        this.smestajService = smestajService;
    }

    @PostMapping(value="/create")
    public Smestaj createSmestaj(@RequestBody Smestaj smestaj) {
         User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         smestaj.setAgent(authUser);
        return smestajService.addSmestaj(smestaj);
    }

}
