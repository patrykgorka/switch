package com.pgorka.typeswitch.then;

import java.util.function.Consumer;

import com.pgorka.typeswitch.Executor;
import com.pgorka.typeswitch.Result;

public class IsOrElse <T> {
	
	private T object;
	
	private Result<T> result;
	
	public IsOrElse(Result<T> result) {
		this.object = result.getObject();
		this.result = result;
	}
	
	public <R> Then<T,R> is(Class<R> type) {
		return Executor.executeIsThen(type, result);
	}
	
	public void orElse(Consumer<T> consumer) {
		if(!result.matchedBefore()) {
			consumer.accept(object);
		}
	}
}