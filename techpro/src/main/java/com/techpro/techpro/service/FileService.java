package com.techpro.techpro.service;

import com.techpro.techpro.entity.Files;
import com.techpro.techpro.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    @Autowired
    private FileRepository imageRepository;

    private final String FILE_PATH = "C:\\images\\storage\\";

    public String storeFile(MultipartFile file) throws IOException {
        String storeMessage = null;

        Files files = Files
                .builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes())
                .build();

        files = imageRepository.save(files);

        if (files.getId() != null) {
            storeMessage = "File " + file.getOriginalFilename() + " uploaded successfully into DB";
        }

        return storeMessage;
    }

    public byte[] getFiles(String fileName) {
        return imageRepository.findByName(fileName).getImageData();
    }

    public String storeDataIntoFS(MultipartFile file) throws IOException {
        String storeMessage = null;

        String filePath = FILE_PATH + file.getOriginalFilename();

        Files files = Files
                .builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .path(filePath)
                .imageData(file.getBytes())
                .build();

        files = imageRepository.save(files);

        file.transferTo(new File(filePath));

        if (files.getId() != null) {
            storeMessage = "File uploaded successfully into DB";
        }

        return storeMessage;
    }

    public byte[] downloadFilesFromFS(String fileName) throws IOException {
        String path = imageRepository.findByName(fileName).getPath();

        return java.nio.file.Files.readAllBytes(new File(path).toPath());
    }
}
