package com.psh.termon.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${upload.path}")
    private String uploadPath;

    public File storage(MultipartFile file) throws IOException {

        File uploadDir = new File(new File(".").getCanonicalPath() + "/" + uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        File uploadFile = new File(uploadDir,
                UUID.randomUUID().toString()
                + "_" + file.getOriginalFilename());
        file.transferTo(uploadFile);
        return uploadFile;
    }
}
