package com.ing.catalog.impl;

import com.ing.catalog.dto.UploadFileResponseDto;
import com.ing.catalog.service.UploadService;
import com.ing.catalog.util.MiscUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private MiscUtil excelImport;

    @Override
    public UploadFileResponseDto uploadFile(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return excelImport.loadDataToDB(file);
    }

}
