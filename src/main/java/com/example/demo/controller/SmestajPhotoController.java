package com.example.demo.controller;

import com.example.demo.model.Smestaj;
import com.example.demo.model.SmestajPhoto;
import com.example.demo.model.dto.ImageData;
import com.example.demo.service.FileService;
import com.example.demo.service.SmestajPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/photos")
public class SmestajPhotoController {


    private FileService fileService;
    private SmestajPhotoService smestajPhotoService;

    @Autowired
    public SmestajPhotoController(FileService fileService, SmestajPhotoService smestajPhotoService) {
        this.fileService = fileService;
        this.smestajPhotoService = smestajPhotoService;
    }

    @GetMapping("/get/{unitId}")
    @ResponseBody
    public List<ImageData> getPhotosFromAccommodationUnit(@PathVariable("unitId") long id) throws IOException {
        List<SmestajPhoto> photos = smestajPhotoService.getPhotosBySmestaj(id);
        List<ImageData> encodedImages = new ArrayList<>();
        for (SmestajPhoto photo : photos) {
            String format = fileService.getImageFormat(photo.getPath());
            String imageContent = fileService.getImageAsBase64String(photo.getPath());
            encodedImages.add(new ImageData(format,imageContent));
        }
        return encodedImages;
    }

    @PostMapping(path = "/{smestajId}/upload")
    public boolean uploadFiles(@PathVariable("smestajId") long id, @RequestParam("photos") MultipartFile[] files) {
        boolean isUploadSuccess = fileService.uploadFiles(files);
        if (isUploadSuccess) {  //ako je upload uspjesan, sacuvaj putanje fajlova
            List<String> fNames = Arrays.asList(files).stream()
                    .map(el -> el.getOriginalFilename())
                    .collect(Collectors.toList());

            smestajPhotoService.saveSmestajPhotos(id,fNames);



        }
        return isUploadSuccess;
    }

}
