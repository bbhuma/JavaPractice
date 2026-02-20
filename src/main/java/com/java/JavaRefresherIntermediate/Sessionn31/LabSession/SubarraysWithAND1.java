package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

public class SubarraysWithAND1 {

	public static void main(String[] args) {
		int[] arr = {0,0,0,0,1,1,0,1,0,1,0,0};
		int[] arr1 = {0,0,0,0,0};
		System.out.println(subarraysWithOR1(arr));
	}

	public static int subarraysWithOR1(int[] arr) {
		int n = arr.length;
		int totalSubArrays = n * (n + 1) / 2;
		int oneSubArr = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				count++;
			} else { //when we find one, update zeroSubs and make count = 0 again. 
				oneSubArr = oneSubArr + (count* (count+1)/2); // Only adding when you find 1, so one last zero block is left not added. 
				count = 0;
			}
		}
		// add last zero block if any
		oneSubArr += count* (count+1)/2;
		
		return oneSubArr;
	}

}
