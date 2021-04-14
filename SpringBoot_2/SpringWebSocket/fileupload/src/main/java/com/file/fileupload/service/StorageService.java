package com.file.fileupload.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {

	public void storeFile(MultipartFile file) throws IOException{
		
		String fileStorageLocation = "C://temp/";

        byte[] bytes = file.getBytes();
        Path path = Paths.get(fileStorageLocation + file.getOriginalFilename());
        Files.write(path, bytes);
	}
}
