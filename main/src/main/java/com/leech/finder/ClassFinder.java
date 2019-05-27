package com.leech.finder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.leech.addnotations.Bean;
import com.leech.addnotations.InjectBean;
import com.nurkiewicz.typeof.WhenTypeOf;

@Bean
public class ClassFinder {

	private static final Logger log = LogManager.getLogger(ClassFinder.class);

	@InjectBean
	private static Set<String> compiletClasses = new HashSet<>();

	public static Set<String> findAllCompiledClasses() {

//        String classPath = System.getProperty("java.class.path");
		String classPath = "C:\\EclipseWorkspace\\main\\target\\classes";
		Path path = Paths.get(classPath);
		log.info(classPath);

		try {
			Files.walk(path).forEach(file -> {
				if (FinderUtils.isClassFile(file)) {
					compiletClasses.add(file.getFileName().toString());
				}
			});

//			compiletClasses.forEach(x -> log.info(FinderUtils.trimClassFile(x)));
//			compiletClasses.forEach(x -> AnnotationFinder.scanClassFileForAnnotation(FinderUtils.trimClasFile(x)));
		} catch (IOException e) {
			log.error(e.getMessage());
		}

		return compiletClasses;
	}
	
}