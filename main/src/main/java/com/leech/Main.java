package com.leech;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nurkiewicz.typeof.TypeOf;

public class Main {

	private static final Logger log = LogManager.getLogger(Main.class);

	public static void main(final String... args) {
		
		LeechContainer initiateContainer = LeechContainer.initiateContainer();
		
//		ClassFinder bean = initiateContainer.getBean(ClassFinder.class);
		
//		System.out.println("bean = " + bean);
		
		
		
		String str = " string";
		final int result = TypeOf.whenTypeOf(42).
				is(Integer.class).thenReturn(i -> i + 1).
				get();
		
	
//		ClassFinder.findAllCompiledClasses();
//		
//		Reflections ref = new Reflections("");
//		
//		log.info("---logger test---");
	}
	
}
