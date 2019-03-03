package com.oskiapps.shopsapp.engine.utils;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

public class ShopsappUtils {

	public static String getShortenedText(String text, int length) {
		text = text.substring(0, length - 1) + " [...]";
		return text;
	}

	public static String getMimeType(String filePath) {
		File file = new File(filePath);
		String mimetype = new MimetypesFileTypeMap().getContentType(file);
		return mimetype;
	}

}
