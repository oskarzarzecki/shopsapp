package com.oskiapps.shopsapp.engine.utils;

public class Utils {

	public static String getShortenedText(String text, int length) {
		text = text.substring(0, length - 1) + " [...]";
		return text;
	}

}
