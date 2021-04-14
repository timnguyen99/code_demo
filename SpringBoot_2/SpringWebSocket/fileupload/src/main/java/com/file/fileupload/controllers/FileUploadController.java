package com.file.fileupload.controllers;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.fileupload.model.FileResponse;
import com.file.fileupload.service.StorageService;

@RestController
public class FileUploadController {
	
	@Autowired
	public StorageService storageService;

	@PostMapping("/api/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		
		if (file.isEmpty()) {
            return new ResponseEntity<>("please select a file!", HttpStatus.OK);
        }
		
		try {
			storageService.storeFile(file);

        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
		
		return new ResponseEntity<>("File Uploaded Successfully: " + file.getOriginalFilename(), HttpStatus.OK);
	}
}
