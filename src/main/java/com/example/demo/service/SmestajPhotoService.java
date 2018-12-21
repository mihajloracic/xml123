package com.example.demo.service;

import com.example.demo.model.SmestajPhoto;
import com.example.demo.repository.SmestajPhotoRepository;
import com.example.demo.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmestajPhotoService {

    private SmestajRepository smestajRepository;
    private SmestajPhotoRepository smestajPhotoRepository;

    @Autowired
    public SmestajPhotoService(SmestajRepository smestajRepository, SmestajPhotoRepository smestajPhotoRepository){
        this.smestajPhotoRepository = smestajPhotoRepository;
        this.smestajRepository = smestajRepository;

    }

    public List<SmestajPhoto> getPhotosBySmestaj(Long id){
        return smestajPhotoRepository.findBySmestajId(id);

    }

    public void saveSmestajPhotos(Long id,List<String> paths){
        for(String path: paths){
            SmestajPhoto s = new SmestajPhoto();
            s.setSmestaj(smestajRepository.getOne(id));
            s.setPath(path);
            smestajPhotoRepository.save(s);
        }
    }
    public void saveSmestajPhoto(SmestajPhoto photo){
        smestajPhotoRepository.save(photo);
    }

}
