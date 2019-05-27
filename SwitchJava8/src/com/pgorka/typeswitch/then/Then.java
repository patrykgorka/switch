package com.pgorka.typeswitch.then;

import java.util.function.Consumer;

import com.pgorka.typeswitch.Executor;
import com.pgorka.typeswitch.Result;

public class Then<T,R> {

	private Result<T> result;

	public Then(Result<T> result) {
		this.result = result;
	}

	public IsOrElse<T> then(Consumer<R> consumer) {
		return Executor.executeThen(consumer, result);
	}
}