package com.java.JavaRefresherIntermediate.Sessionn37;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
	int[] arr1 = {1,3,5,7,9};
	int[] arr2 = {2,4,6};
	int[] merged = mergeTwoSortedArrays(arr1, arr2);
	
		for(int x: merged) {
			System.out.print(x+" ");
		}
	}

	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;

		int[] merged = new int[n1 + n2];

		int i = 0, j = 0, k = 0;

		while (i < n1 && j < n2) { // compare arr1[i] and arr2[j], put smaller one in merged and move that pointer forward, if both are equal, we can put any one of them and move that pointer forward
			if (arr1[i] < arr2[j]) {
				merged[k++] = arr1[i++];
			} else {
				merged[k++] = arr2[j++];
			}
		}
		while (i < n1) {
			merged[k++] = arr1[i++];
		}
		while (j < n2) {
			merged[k++] = arr2[j++];
		}
		return merged;

	}

}
