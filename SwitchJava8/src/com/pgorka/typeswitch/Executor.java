package com.pgorka.typeswitch;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import com.pgorka.typeswitch.then.IsOrElse;
import com.pgorka.typeswitch.then.Then;
import com.pgorka.typeswitch.thenreturn.IsOrElseGet;
import com.pgorka.typeswitch.thenreturn.ThenReturn;

public class Executor {

	public static <T, R> AfterFirstIs<T, R> executeFirstIs(Class<R> type, T object) {
		Boolean matches = matches(type, object);
		return new AfterFirstIs<T, R>(new Result<T>(matches, object, matches));
	}

	public static <T, R> Then<T, R> executeIsThen(Class<R> type, Result<T> result) {
		T object = result.getObject();
		Boolean matches = matches(type, object);

		return new Then<T, R>(new Result<T>(matches, object, result.matchedBefore())) ;
	}

	public static <T, R, V> ThenReturn<T, R, V> executeIsThenReturn(Class<R> type, Result<T> result) {
		T object = result.getObject();
		Boolean matches = matches(type, object);

		return new ThenReturn<T, R, V>(new Result<T>(matches, object, result.matchedBefore())) ;
	}

	public static <T, R, V> IsOrElseGet<T, V> executeThenReturnn(Function<R, V> function, Result<T> result, Optional<V> value) {
//		Optional<V> valueToReturn = Optional.empty();

		if (result.matches()) {
			V functionResult = function.apply(castObject(result.getObject()));
			value = Optional.of(functionResult);
		}

		return new IsOrElseGet<T, V>(result, value);
	}

	public static <T, V> IsOrElseGet<T, V> executeThenReturn(V returnValue, Result<T> result, Optional<V> value) {
//		Optional<V> valueToReturn = Optional.empty();

		if (result.matches()) {
			value = Optional.of(returnValue);
		}

		return new IsOrElseGet<T, V>(result, value);
	}

	public static <T, R> IsOrElse<T> executeThen(Consumer<R> consumer, Result<T> result) {
		if (result.matches()) {
			consumer.accept(castObject(result.getObject()));
		}

		return new IsOrElse<T>(result);
	}
	
	private static Boolean matches(Class<?> type, Object object) {
		return type.equals(object.getClass());
	}

	@SuppressWarnings("unchecked")
	private static <T, R> R castObject(T object) {
		return (R) object;
	}
}
