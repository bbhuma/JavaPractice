package com.java.JavaRefresherIntermediate.Sessionn37;

public class MergeSort {
	
	public static int[] solve(int[] A) {
       int[] ans =  mergeSort(A,0,A.length-1);
	   return ans;
    }

	public static int[]  mergeSort(int[] arr,int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
		return arr;
	}
	public static int[] merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return arr;
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
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 10, 2, 1, 5};
		mergeSort(arr, 0, arr.length - 1);
		// Print the sorted array
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
