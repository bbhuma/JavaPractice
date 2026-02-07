package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class MinimumSwapsNeededWhileLoop {
	public static int minimumSwapsNeeded(int[] A, int B) {
		int n = A.length;
		//Step1 count how many good elements in total  
		int goodCount = 0;
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= B)
				goodCount++;
		}
		if(goodCount<=1) return 0; // no swaps needed if goodCount(<=B) are less than 1, can not group any numbers.
				
		// Step2, find how many bad elements in first window. 
		int left=0,right=0,currBadCount=0; 
		while(right<goodCount) {
			if(A[right]>B) currBadCount++;
			right++;
		}
		answer = currBadCount;
		
		// Step 3: Slide the window across the array
		while(right<n) {
		if(A[right]> B) currBadCount++;
		if(A[left]>B)currBadCount--;
		answer = Math.min(answer, currBadCount);
		left++;
		right++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 1, 12, 10, 3, 14, 10, 5 };
		int[] B = { 8,3,10,20,22,13,1,2,55,5,15,50};
		System.out.println(minimumSwapsNeeded(A, 8));
		System.out.println(minimumSwapsNeeded(B, 5));
	}

}
