package com.pgorka.typeswitch;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import com.pgorka.typeswitch.then.IsOrElse;
import com.pgorka.typeswitch.thenreturn.IsOrElseGet;

public class AfterFirstIs<T, R> {

	private Result<T> result;

	public AfterFirstIs(Result<T> result) {
		this.result = result;
	}

	public IsOrElse<T> then(Consumer<R> consumer) {
		return Executor.executeThen(consumer, result);
	}

	public <V> IsOrElseGet<T, V> thenReturn(Function<R, V> function) {
		return Executor.executeThenReturnn(function, result, Optional.empty());
	}

	public <V> IsOrElseGet<T, V> thenReturn(V valueToReturn) {
		return Executor.executeThenReturn(valueToReturn, result, Optional.empty());
	}
}