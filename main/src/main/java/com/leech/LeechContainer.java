package com.leech;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import com.leech.addnotations.Bean;

public class LeechContainer {

	private static LeechContainer leechContainer;

	private static Map<Class<?>, Object> registredBeans = new HashMap<>();

	private static Reflections reflections = new Reflections("");

	private LeechContainer() {}

	public static LeechContainer initiateContainer() {
		if (leechContainer == null) {

			initializeAllAnnotatedBeans();

			leechContainer = new LeechContainer();
		}

		return leechContainer;
	}

	@SuppressWarnings("unchecked")
	public <T> T getBean(Class<?> beanClass) {

		if (registredBeans.containsKey(beanClass)) {
			Object bean = registredBeans.get(beanClass);
			return (T) bean;
		} else {
			throw new IllegalAccessError();
		}
	}

	private static void initializeAllAnnotatedBeans() {
		Set<Class<?>> annotatiedClasses = reflections.getTypesAnnotatedWith(Bean.class);
		Set<Method> methodsAnnotatedWith = reflections.getMethodsAnnotatedWith(Bean.class);
		
		methodsAnnotatedWith.forEach( annotatedMethod -> {
			annotatedMethod.getReturnType();
			
		});
		
		annotatiedClasses.forEach(annotatedClass -> {
			registredBeans.put(annotatedClass, createObjectInstanceWithInjection(annotatedClass));
		});
		
	}
	
	private static Object createObjectInstanceWithInjection(Class<?> clazz) {
		
		return null;
	}
}