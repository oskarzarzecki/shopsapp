package com.oskiapps.shopsapp.engine.services;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.oskiapps.shopsapp.engine.config.properties.FileStorageProperties;
import com.oskiapps.shopsapp.engine.exceptions.FileNotFoundException;
import com.oskiapps.shopsapp.engine.exceptions.FileStorageException;
import com.oskiapps.shopsapp.engine.utils.ShopsappUtils;

@Service
public class FileStorageService {

	private final Path filePath;

	@Autowired
	public FileStorageService(FileStorageProperties properties) {
		this.filePath = Paths.get(properties.getResourcesPath()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.filePath);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	public Resource loadImageResource(String imagePath) {
		try {
			Path file = this.filePath.resolve(this.filePath.toAbsolutePath() + imagePath);
			String mimeType = ShopsappUtils.getMimeType(file.toString());
			if (!mimeType.split("/")[0].equals("image")) {
				throw new FileStorageException("The requested file is not an image.");
			}
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new FileNotFoundException("The requested file not found.");
			}
		} catch (MalformedURLException e) {
			throw new FileStorageException(e.getMessage());
		}
	}

}
