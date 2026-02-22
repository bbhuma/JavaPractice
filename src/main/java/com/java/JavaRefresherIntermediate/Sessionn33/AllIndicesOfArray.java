package com.java.JavaRefresherIntermediate.Sessionn33;

import java.util.ArrayList;
import java.util.Collections;

public class AllIndicesOfArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 5, 5, 5, 7, 5 }; // return indices of arr where 5 occur.
		int[] ans1 = allIndicesOfArrayUsingList(arr, 5);
		int[] ans2 = allIndicesOfArraysPureRecursion(arr, 5);
		for (int x : ans1) {
			System.out.print(x + " ");
		}
		System.out.println();
		for (int x : ans2) {
			System.out.print(x + " ");
		}

	}

	public static int[] allIndicesOfArrayUsingList(int[] arr, int B) {
		ArrayList<Integer> list = new ArrayList<>();
		helperList(arr, 0, B, list); // pass list as param, list gets set in the helper method
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void helperList(int[] arr, int i, int B, ArrayList<Integer> list) {
		if (i == arr.length)
			return;

		if (arr[i] == B)
			list.add(i);

		helperList(arr, i + 1, B, list);
	}
	
	//Pure recursion
	public static int[] allIndicesOfArraysPureRecursion(int[] arr, int B) {
		return helper(arr, 0, B);
	}
	public static int[] helper(int[] arr, int index, int target) {

		if (index == arr.length)
			return new int[0];

		int[] smallAns = helper(arr, index + 1, target);

		if (arr[index] == target) {

			int[] ans = new int[smallAns.length + 1];

			ans[0] = index;

			for (int i = 0; i < smallAns.length; i++)
				ans[i + 1] = smallAns[i];

			return ans;
		}

		return smallAns;
	}

}
