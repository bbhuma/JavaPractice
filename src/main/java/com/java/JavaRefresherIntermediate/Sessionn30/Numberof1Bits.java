package com.java.JavaRefresherIntermediate.Sessionn30;

public class Numberof1Bits {
	public static void main(String[] args) {
		int n= 125;
		numberof1Bits(n);

	}

	// T.C = constant = 32
	// S.C = constant.
	public static void numberof1Bits(int n) {
		int count=0;
		for(int i=0;i<32;i++) {
			if((n & (1<<i))!=0) { // n & (1<<i) is used to check if the ith bit of n is set (1) or not (0).
				count++;
			}
		}
		System.out.println("Number of 1 bits: "+count);
		for(int i=31;i>=0;i--) {
			if((n & (1<<i))!=0) {
				System.out.print(1);
			}
			else {
				System.out.print(0);
			}	
		}

	}

}
