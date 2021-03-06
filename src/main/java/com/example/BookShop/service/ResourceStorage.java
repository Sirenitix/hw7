package com.example.BookShop.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;


@Service
public class ResourceStorage {

    @Value("${upload.path}")
    String uploadPath;

    public String saveNewBookImage(MultipartFile file, String slug) throws IOException {

        Logger.getLogger(this.getClass().getSimpleName()).info("selected file's size:" + file.getSize());
        Logger.getLogger(this.getClass().getSimpleName()).info("selected slug:" + slug);
        String resourceURI=null;
        if(!file.isEmpty()){
            if(!new File(uploadPath).exists()){
                Files.createDirectories(Paths.get(uploadPath));
                Logger.getLogger(this.getClass().getSimpleName()).info("created image folder in "+ uploadPath);
            }

            String fileName = slug+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
            Path path = Paths.get(uploadPath,fileName);
            resourceURI = "/Saved Pictures/"+fileName;
            file.transferTo(path); //uploading user file here
            Logger.getLogger(this.getClass().getSimpleName()).info("upload path" + uploadPath);
            Logger.getLogger(this.getClass().getSimpleName()).info("uri" + resourceURI);
            Logger.getLogger(this.getClass().getSimpleName()).info(fileName+" - uploaded OK!");
        }

        return resourceURI;
    }
}
