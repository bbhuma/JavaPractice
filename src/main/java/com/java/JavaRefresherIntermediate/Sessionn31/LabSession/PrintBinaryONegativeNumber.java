package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

public class PrintBinaryONegativeNumber {

	public static void main(String[] args) {
		printBinaryONegativeNumber(1);
		printBinaryONegativeNumber(-1); // invert l bit of 1, then add 1 i.e 2's compliment
		printBinaryONegativeNumber(-12);
		printBinaryONegativeNumber(12);

	}

	public static void printBinaryONegativeNumber(int num) {
		for (int i = 31; i>=0; i--) {
			if ((num & (1 << i)) != 0) {
				System.out.print("1");
			}else System.out.print("0");
		}
		System.out.println();
	}

}
