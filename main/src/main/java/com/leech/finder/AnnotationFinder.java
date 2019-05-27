package com.leech.finder;

public class AnnotationFinder {
	
	public static void findClassLevelAnnotation() {
		
	}
	
	public static void findMethodLevelAnnotation() {
		
	}
	
	public static void findFieldLevelAnnotatation() {
		
	}
	
	public static void scanClassFileForAnnotation(String className) {
		try {
			
			Class<?> forName = Class.forName(className);
			
			System.out.println(forName.toString());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}