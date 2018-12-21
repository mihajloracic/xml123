package com.example.demo.service;

import com.example.demo.model.Rezervacija;
import com.example.demo.repository.RezervisanSmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezervisanSmestajService {

    @Autowired
    private RezervisanSmestajRepository rezervisanSmestajRepository;

    public List<Rezervacija> findAll(){
        return  rezervisanSmestajRepository.findAll();
    }

    public Rezervacija addRezervacija(Rezervacija rezervacija){
           return rezervisanSmestajRepository.save(rezervacija);
    }

    public Rezervacija findByIdRezervacije(Rezervacija rezervacija){ return rezervisanSmestajRepository.getOne(rezervacija.getId());}

    public Rezervacija findById(long id){
        Optional<Rezervacija> r = rezervisanSmestajRepository.findById(id);
        return r.get();
    }

    public Rezervacija setConfirmed(Rezervacija r){
        r.setConfirmed(true);
        return r;
    }


}
