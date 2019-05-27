package com.pgorka.typeswitch.thenreturn;

import java.util.function.Function;

import com.pgorka.typeswitch.Executor;
import com.pgorka.typeswitch.Result;

public class ThenReturn<T, R, V> {

	private Result<T> matchResult;

	public ThenReturn(Result<T> matchResult) {
		this.matchResult = matchResult;
	}

	public IsOrElseGet<T, V> thenReturn(Function<R, V> function) {
		return Executor.executeThenReturn(function, matchResult);
	}
	
	public IsOrElseGet<T, V> thenReturn(V value) {
		return Executor.executeThenReturn(value, matchResult);
	}
}