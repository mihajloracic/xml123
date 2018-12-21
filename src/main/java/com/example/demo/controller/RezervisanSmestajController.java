package com.example.demo.controller;

import com.example.demo.model.Rezervacija;
import com.example.demo.model.Smestaj;
import com.example.demo.model.User;
import com.example.demo.service.RezervisanSmestajService;
import com.example.demo.service.SmestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sun.management.Agent;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class RezervisanSmestajController {

    private RezervisanSmestajService rezervisanSmestajService;
    private SmestajService smestajService;

    @Autowired
    public  RezervisanSmestajController(RezervisanSmestajService rezervisanSmestajService,SmestajService smestajService){
        this.rezervisanSmestajService = rezervisanSmestajService;
        this.smestajService = smestajService;
    }

    @PostMapping
    public Rezervacija createRezervacija(@RequestBody Rezervacija rezervacija){
        Smestaj smestaj = smestajService.findBySmestajId(rezervacija.getSmestaj().getId());
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        rezervacija.setAgent(authUser);
        rezervacija.setSmestaj(smestaj);
        return rezervisanSmestajService.addRezervacija(rezervacija);
    }

    @PostMapping(value = "/confirmReservation")
    public Rezervacija confirmReservationByAgent(@RequestBody Rezervacija rezervacija){
         Rezervacija r = rezervisanSmestajService.findByIdRezervacije(rezervacija);
         rezervisanSmestajService.setConfirmed(r);
         return rezervisanSmestajService.addRezervacija(r);

    }

    @GetMapping("/get/{id}")
    public Rezervacija getRezervacijaById(@PathVariable("id") long id) {
        return rezervisanSmestajService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Rezervacija> getAll() {
        return rezervisanSmestajService.findAll();
    }

}
