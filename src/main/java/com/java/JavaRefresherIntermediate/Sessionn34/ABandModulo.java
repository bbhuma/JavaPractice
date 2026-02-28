package com.java.JavaRefresherIntermediate.Sessionn34;

public class ABandModulo {

	public static void main(String[] args) {
		System.out.println(ABandModulo(48,18));
		System.out.println(ABandModulo(56,98));
		System.out.println(ABandModulo(101,10));
	}

	public static int ABandModulo(int m , int n) {
		// A% M = B% M => A-B is divisible by M => A-B = kM => A-B = kM => k=1 => A-B = M =>
		return Math.abs(m-n);
	}

}
