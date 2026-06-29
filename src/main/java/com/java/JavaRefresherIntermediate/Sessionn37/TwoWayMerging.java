package com.java.JavaRefresherIntermediate.Sessionn37;

// Merge Sort Only works on Sorted Lists
//Combine TWO SORTED LISTS into one sorted list.
public class TwoWayMerging {

	public static void main(String[] args) {
		int[] input1 = { 1, 2, 3, 4 };
		int[] input2 = { 5, 6, 8, 9 };
		int[] twoWayMerge = twoWayMerge(input1, input2);
		for (int i = 0; i < twoWayMerge.length; i++) {
			System.out.print(twoWayMerge[i] + " ");
		}

	}

	public static int[] twoWayMerge(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;

		int finalLen = n1 + n2;
		int i = 0, j = 0, k = 0;
		int[] ans = new int[finalLen];

		while (i < n1 && j < n2) {
			if (arr1[i] < arr2[j]) {
				ans[k] = arr1[i];
				i++;
				k++;
			} else {
				if (arr1[i] < arr2[j]) {
					ans[k] = arr1[j];
					i++;
					k++;
				}
			}
		}
		while (i < n1) {
		ans[k] = arr1[j];
			i++;
			k++;
		}

		while (j < n2) {
			ans[k] = arr2[j];
			j++;
			k++;
		}

		return ans;
	}

}
