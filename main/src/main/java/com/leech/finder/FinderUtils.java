package com.leech.finder;

import java.nio.file.Path;

public class FinderUtils {
	
	private static final String CLASS_EXTENSION = ".class";
	
	public static boolean isClassFile(Path path) {
		return path.getFileName()
				.toString()
				.endsWith(CLASS_EXTENSION);
	}
	
	public static String trimClassFile(String fileName) {
		return fileName.substring(0, fileName.length() - CLASS_EXTENSION.length());
	}
}
