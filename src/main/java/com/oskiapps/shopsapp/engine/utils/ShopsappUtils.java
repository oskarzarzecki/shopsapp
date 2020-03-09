package com.oskiapps.shopsapp.engine.utils;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;

public class ShopsappUtils {

	public static String getShortenedText(String text, int length) {
		text = text.substring(0, length - 1) + " [...]";
		return text;
	}

	public static String getMimeType(String filePath) {
		File file = new File(filePath);
		String mimetype = "application/octet-stream";
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		mimetype = fileNameMap.getContentTypeFor(file.getName());
		return mimetype;
	}

}
