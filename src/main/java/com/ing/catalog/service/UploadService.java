package com.ing.catalog.service;

import com.ing.catalog.dto.UploadFileResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    public UploadFileResponseDto uploadFile(MultipartFile file);
}
