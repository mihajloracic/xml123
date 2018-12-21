package com.example.demo.service;

import com.example.demo.model.Smestaj;
import com.example.demo.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmestajService {

    @Autowired
    SmestajRepository smestajRepository;

    public List<Smestaj> findAll(){
        return smestajRepository.findAll();
    }

    public Smestaj addSmestaj(Smestaj smestaj) {
        return smestajRepository.save(smestaj);
    }

    public Smestaj findBySmestajId(long id){ return smestajRepository.findById(id);}

    public boolean smestajExists(long id){
        boolean exists = false;
        if( smestajRepository.findById(id) !=null){
            exists = true;
        }
        return exists;
    }

}
