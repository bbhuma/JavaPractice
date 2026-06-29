package com.java.JavaRefresherIntermediate.Sessionn37;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortSubarraywithLeftandRightIndex {

	public static void main(String[] args) {
		int[] arr = { 59, 11, 8, 91, 49, 44, 8 };
		int[] ans = sortSubarraywithLeftandRightIndex(arr, 2, 5);
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	}

	public static int[] sortSubarraywithLeftandRightIndex(int[] arr, int left, int right) {
		int n = right - left + 1;
		// int [] subarr = new int[n];
		int index = 0;
		int[] subarr = Arrays.copyOfRange(arr, left, right + 1);
		// for(int i =left; i<=right;i++) {subarr[index++] = arr[i]; //index++ ;}

		// index reaches n now, need to be reset to 0 or use another index variable.

		int[] newSub = mergeSort(subarr, 0, subarr.length - 1);
		index = 0;
		for (int i = left; i <= right; i++) {
			arr[i] = newSub[index++];
			//index++;
		}
		return arr;
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

}
