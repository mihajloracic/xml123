package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class FileService {
    public static final String uploadingDir = System.getProperty("user.dir") + "\\photos\\";


    public boolean uploadFiles(MultipartFile[] files) {
        for(MultipartFile file : files) {
            File f = new File(uploadingDir + file.getOriginalFilename());
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }


    public String getImageAsBase64String(String fileName) throws IOException {
        Path pathToFile = Paths.get(uploadingDir + fileName);
        byte[] imageBytes = Files.readAllBytes(pathToFile);
        return Base64.getEncoder().encodeToString(imageBytes);
    }


    public String getImageFormat(String fileName) {
        return fileName.substring(fileName.indexOf(".") + 1);
    }
}
