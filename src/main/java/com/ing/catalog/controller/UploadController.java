package com.ing.catalog.controller;

import com.ing.catalog.dto.UploadFileResponseDto;
import com.ing.catalog.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController


@RequestMapping("/ing")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<UploadFileResponseDto> singleFileUpload(@RequestParam("file") MultipartFile file) {

        UploadFileResponseDto message=uploadService.uploadFile(file);

        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}
