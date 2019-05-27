package com.pgorka;

import javax.xml.crypto.Data;

import com.pgorka.typeswitch.Switch;

public class Main {

	public static void main(String[] args) {
		
		Switch.of("kek")
			.is(String.class).then(Main::tst)
			.is(String.class).then(date -> System.out.println(date.charAt(2)))
			.is(Integer.class).then(intt -> System.out.println("Int + 5 = " + intt.byteValue() + 5))
			.orElse(els -> System.out.println("else"));

		int y = Switch.of(12)
			.is(String.class).thenReturn(x -> {return 10;})
			.is(Data.class).thenReturn(x -> Integer.MAX_VALUE)
			.is(Integer.class).thenReturn(92)
			.get();
		
		System.out.println("ThenReturn result: " + y);
	}
	
	public static void tst(String s) {
		System.out.println("kek");
	}
}