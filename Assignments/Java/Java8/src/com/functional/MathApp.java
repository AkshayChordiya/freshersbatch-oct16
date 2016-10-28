package com.functional;

public class MathApp {

	public static void main(String[] args) {
		MathOperation<Integer> add = (x , y) -> x + y; 
		MathOperation<Integer> sub = (x , y) -> x - y; 
		MathOperation<Integer> mul = (x , y) -> x * y; 
		MathOperation<Integer> div = (x , y) -> x / y;
		System.out.println("Add = " + add.operation(1, 2));
		System.out.println("Sub = " + sub.operation(1, 2));
		System.out.println("Mul = " + mul.operation(1, 2));
		System.out.println("Div = " + div.operation(1, 2));
	}

}
