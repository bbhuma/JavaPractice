package com.java.JavaRefresherIntermediate.Sessionn30;

public class SetBit {

	public static void main(String[] args) {
		int A = 3;
		int B = 5; // 0,1,2 0-based index
		int ans = setithbit(A, B);
		System.out.println(ans);
	}

	public static int setithbit(int A, int B) {
		int x = 0;
		x = x | (1 << A);
		x = x | (1 << B);
		return x;
	}
}
