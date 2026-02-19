package com.java.JavaRefresherIntermediate.Sessionn29;

public class NextGreatestPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {769, 533};
		int[] nextGreatestPermutation = nextGreatestPermutation(arr); // 1 2 4 3 5 6
		//nextGreatestPermutation = nextGreatestPermutation(arr); // 1 2 4 3 6 5
		//nextGreatestPermutation = nextGreatestPermutation(arr); //1 2 4 5 3 6 
		//nextGreatestPermutation = nextGreatestPermutationPractice(arr); // 6 1 4 3 2 5
		for (int x : nextGreatestPermutation) {
			System.out.print(x + " ");
		}

	}

	public static int[] nextGreatestPermutation(int[] arr) {
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				for (int j = arr.length - 1; j > i; j--) {
					if (arr[j] > arr[i]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						arr = reverse(arr, i + 1, arr.length - 1);
						return arr;
					}
				}
			}
		}
		return arr;
	}

	private static int[] reverse(int[] arr, int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return arr;
	}

	public static int[] nextGreatestPermutationPractice(int[] arr) {
		int n = arr.length;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) { // when you find pivot
				for (int j = n - 1; j > i; j--) {
					if (arr[j] > arr[i]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						arr = reverse(arr, i + 1, n - 1);
						return arr; // very important, to terminate loop once pivot found and 
					}
				}
			}
		}
		return arr; // return arr as is, if no pivot is found. 
	}
}
