package com.example.demo.repository;

import com.example.demo.model.Smestaj;
import com.example.demo.model.SmestajPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmestajPhotoRepository extends JpaRepository<SmestajPhoto,Long> {

    List<SmestajPhoto> findBySmestajId(long id);

}
