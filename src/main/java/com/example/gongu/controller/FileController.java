package com.example.gongu.controller;

import com.example.gongu.domain.dto.FileDto;
import com.example.gongu.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files/*")
public class FileController {
    private final FileService fileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<FileDto> imgList(Long applyNumber){
        return fileService.findList(applyNumber);
    }

    @GetMapping("/display")
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, fileName));
    }
}
