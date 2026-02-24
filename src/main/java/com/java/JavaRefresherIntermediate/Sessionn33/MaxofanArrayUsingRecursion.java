package com.java.JavaRefresherIntermediate.Sessionn33;

public class MaxofanArrayUsingRecursion {

	public static void main(String[] args) {
		

	}
	public static int maxofanArrayUsingRecursion(int[] arr) {
		 if(arr.length==0) return Integer.MIN_VALUE;
		 return helperInc(arr,0);
//		 return helperDec(arr,arr.length-1);
		
	}
	public static int helperInc(int[] arr,int i) {
		if(i==arr.length-1) return arr[i]; //assuming the last element is the max, and then compare it with the rest of the array
		int max = helperInc(arr,i+1); // Catch the max of the rest of the array, and then compare it with the current element
		return Math.max(arr[i], max);
	}
	public static int helperDec(int[] arr,int i) {
		if(i==0) return arr[i]; //assuming the first element is the max, and then compare it with the rest of the array
		int max = helperDec(arr,i-1); // Catch the max of the rest of the array, and then compare it with the current element
		return Math.max(arr[i], max);
	}

}
