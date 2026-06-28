package com.java.JavaRefresherIntermediate.Sessionn37;

public class SortbyColor {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 1, 2 };
		int[] sorted = sortbyColor(arr);
		int[] sortedOptimized = sortbyColorOptimized(arr);
		for (int x : sortedOptimized) {
			System.out.print(x + " ");
		}
	}

	public static int[] sortbyColor(int[] arr) { // only contain 0,1,2 as elements.
		int n = arr.length;
		int red = 0, white = 0, blue = 0;
		for (int num : arr) {
			if (num == 0) {
				red++;
			} else if (num == 1) {
				white++;
			} else {
				blue++;
			}
		}
		//int[] ans = new int[n];
		for (int i = 0; i < red; i++) {
			arr[i] = 0;
		}
		for (int i = red; i < red + white; i++) {
			arr[i] = 1;
		}
		for (int i = red + white; i < n; i++) {
			arr[i] = 2;
		}
		return arr;
	}
	
	public static int[] sortbyColorOptimized(int[] arr) {

	    int low = 0;
	    int mid = 0;
	    int high = arr.length - 1;

	    while(mid <= high){

	        if(arr[mid] == 0){

	            swap(arr, low, mid);
	            low++;
	            mid++;

	        }
	        else if(arr[mid] == 1){

	            mid++;

	        }
	        else{

	            swap(arr, mid, high);
	            high--;
	        }
	    }

	    return arr;
	}

	static void swap(int[] arr,int i,int j){

	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}
