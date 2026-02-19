package com.java.JavaRefresherIntermediate.Sessionn30;

public class SingleUniqueNumber {

	public static void main(String[] args) {

	}

	public static void singleUniqueNumber(String[] args) {
		int[] arr = { 1, 2, 3, 4, 1, 2, 3 };
		int unique = 0; // 0 ^ 1 = 1
						// 1 ^ 2 = 3
						// 3 ^ 3 = 0
						// 0 ^ 4 = 4
						// 4 ^ 1 = 5
						// 5 ^ 2 = 7
						// 7 ^ 3 = 4
		for (int i = 0; i < arr.length; i++) {
			unique = unique ^ arr[i];
		}
		System.out.println(unique);
	}

}
