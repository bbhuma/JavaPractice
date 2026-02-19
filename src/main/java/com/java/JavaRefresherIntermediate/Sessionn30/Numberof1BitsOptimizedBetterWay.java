package com.java.JavaRefresherIntermediate.Sessionn30;

public class Numberof1BitsOptimizedBetterWay {
	public static void main(String[] args) {
		int n = 125;
		int numberOsSetBits = numberof1Bits(n);
		System.out.println(numberOsSetBits);

	}
	// T.C = constant = no of 1's 
	// S.C = constant.
	public static int numberof1Bits(int x) {
		int count = 0;
		while (x != 0) {
			x = x & x - 1; // it will make first set bit from right to 0, count how many times loop runs before 0
			count++;
		}
		return count;
	}

}
