package com.java.JavaRefresherIntermediate.Sessionn33;

public class IsMagic {

	public static void main(String[] args) {
		System.out.println(isMagic(83557));
		System.out.println(isMagic(1291));
	}

	public static int isMagic(int num) {
		// if (num == 1) return 1;
		if (num < 10) return num == 1 ? 1 : 0;
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num = num / 10;
		}
		return isMagic(sum);
	}
	public static int isMagicFor(int num) {
		// if (num == 1) return 1;
		if (num < 10) return num == 1 ? 1 : 0;

	    int sum = 0;
	    for (; num > 0; num /= 10) {
	        sum += num % 10;
	    }

	    return isMagic(sum);
	}
	
	public static int isMagicOptimized(int num) {
	    return (num != 0 && num % 9 == 1) ? 1 : 0;
	    // num%9 = sum of digits %9
	}
}
