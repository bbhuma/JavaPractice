package com.java.JavaRefresherIntermediate.Sessionn29;

import java.util.ArrayList;

public class RainWaterTrapped {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 0, 3, 5, 2, 4, 7 };
		System.out.println(totalRainWaterTrapped(A));
		for (int i : A) {
			System.out.print(i + " ");
		}
		int[] ans = rainWaterTrappedAtEachIndex(A);
		System.out.println();
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
	public static int[] rainWaterTrappedAtEachIndex(int[] A) {
		int n = A.length;
		int left = 0, right = n - 1; // two pointers,some condition to chekc looping condition
		int leftMax = A[0];
		int rightMax = A[n - 1];
		ArrayList<Integer> res = new ArrayList<>();

		// Two pointers no need of extra space to store leftmax and rightmax as we are
		// calculating on the fly
		while (left <= right) {
			if (A[left] < A[right]) {
				if (A[left] > leftMax) {
					leftMax = A[left];
					res.add(0);
				} else
					res.add(leftMax - A[left]);
				left++;
			} else {
				if (A[right] >= rightMax) {
					rightMax = A[right];
					res.add(0);
				} else
					res.add(rightMax - A[right]);

				right--;
			}
		}
		return res.stream().mapToInt(i -> i).toArray();
	}

	public static int totalRainWaterTrapped(int[] A) {
		int n = A.length;
		int left = 0, right = n - 1; // two pointers,some condition to chekc looping condition
		int res = 0;
		int leftMax = A[0];
		int rightMax = A[n - 1];
		// Two pointers no need of extra space to store leftmax and rightmax as we are
		// calculating on the fly
		while (left <= right) {
			if (A[left] < A[right]) {
				if (A[left] > leftMax) {
					leftMax = A[left];
				} else
					res += leftMax - A[left];
				left++;
			} else {
				if (A[right] >= rightMax) {
					rightMax = A[right];
				} else
					res += rightMax - A[right];

				right--;
			}
		}
		return res;
	}

	
}
