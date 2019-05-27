package com.oskiapps.shopsapp.engine.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ShopsappUtils {

	public static String getShortenedText(String text, int length) {
		text = text.substring(0, length - 1) + " [...]";
		return text;
	}

	public static String getMimeType(String filePath) {
		File file = new File(filePath);
		String mimetype = "application/octet-stream";
		try {
			mimetype = Files.probeContentType(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mimetype;
	}

}
