package com.techpro.techpro.controller;

import com.techpro.techpro.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/files")
public class FilesController {

    @Autowired
    private FileService imageService;

    @PostMapping("/storeFilesIntoDB")
    public ResponseEntity<String> storeFilesIntoDB(@RequestParam("file") MultipartFile file) throws IOException {
        String response = imageService.storeFile(file);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/getImageFromDB/{fileName}")
    public ResponseEntity<byte[]> getImageFromDB(@PathVariable String fileName) {
        byte[] imageData = imageService.getFiles(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }

    @PostMapping("/uploadFilesIntoSystem")
    public ResponseEntity<String> uploadFilesIntoSystem(@RequestParam("file") MultipartFile file) throws IOException {
        String response = imageService.storeDataIntoFS(file);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/downloadFilesFromSystem/{fileName}")
    public ResponseEntity<byte[]> downloadFilesFromSystem(@PathVariable String fileName) {
        byte[] imageData = imageService.getFiles(fileName);

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}
