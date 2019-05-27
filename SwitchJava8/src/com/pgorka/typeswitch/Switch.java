package com.pgorka.typeswitch;

public class Switch<T> {

	private T object;

	private Switch(T object) {
		this.object = object;
	}

	public static <T> Switch<T> of(T object) {
		return new Switch<T>(object);
	}

	public <X, R> AfterFirstIs<T, R> is(Class<R> type) {
		return Executor.executeFirstIs(type, object);
	}
}