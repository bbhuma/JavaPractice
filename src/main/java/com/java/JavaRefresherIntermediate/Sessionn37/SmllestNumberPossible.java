package com.java.JavaRefresherIntermediate.Sessionn37;

import java.util.Arrays;

public class SmllestNumberPossible {
	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0, 0, 9, 9, 9, 1, 2, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		int[] smallestNumberPossible = smallestNumberPossible(arr);
		for(int i=0;i<smallestNumberPossible.length;i++) {
			System.out.print(smallestNumberPossible[i]+" ");
		}
		
	}

	public static int[] smallestNumberPossible(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) max= arr[i];
		}
		
		// O(1) SC, TC is O(n)
		int[] count = new int[max+1];
		
		// fill count[] by reading elements from arr[], so go till arr.length
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		int index=0;
		for(int i=0;i<count.length;i++) {
			for(int j=0;j<count[i];j++) {
				arr[index]= i;
				index++;
			}
			count[i]--;
		}
		
		return arr;
	}
}
