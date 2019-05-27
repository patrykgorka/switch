package com.pgorka.typeswitch.thenreturn;

import java.util.Optional;
import java.util.function.Function;

import com.pgorka.typeswitch.Executor;
import com.pgorka.typeswitch.Result;

public class IsOrElseGet<T, V> {

	private Optional<V> getValue;
	
	private Result<T> result;
	
	private T object;
	
	public IsOrElseGet(Result<T> result, Optional<V> valueToReturn) {
		this.result = result;
		this.object = result.getObject();
		this.getValue = valueToReturn;
	}

	public <R> ThenReturn<T, R, V> is(Class<R> type) {
		return Executor.executeIsThenReturn(type, result);
	}

	public V get() {
		return getValue.orElseThrow();
	}
	
	public V orElseGet(V defaultValue) {
		return getValue.orElse(defaultValue);
	}

	public V orElseGet(Function<T, V> function) {
		return function.apply(object);
	}
}