package com.functional;

@FunctionalInterface
public interface MathOperation<T extends Number> {
	T operation(T t1, T t2);
}
