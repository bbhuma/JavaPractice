package com.scaler.JavaRefresherIntermediate.Sessionn26;

public class Flip1and0KadanesAlgoOptimized {
	public static void main(String[] args) {
		int A[] = { 1, 0, 0, 1, 0, 0, 1, 1, 0, 1 };
		int[] answer = maxOnesAfterFlips(A);
		System.out.print( "[");
		for (int i = 0; i < answer.length-1; i++) {
			System.out.print(answer[i]+", ");
		}
		System.out.print( answer[answer.length-1]);
		System.out.print( "]");
	}
	public static int[] maxOnesAfterFlips(int[] A) {
		int n = A.length;
		int[] answer = new int[2]; // [L,R] indices to be returned
		int currentSum = 0; //both curr sum and max sum start with zero's to track the number of 0's
		int maxSum = 0;
		// A -> 		 [1 1 0,0,1,0,0,1,1,0,1];
		// current sum -> 0 0 1,2,1,2,3,2,1,2 
		for (int i = 0; i < n; i++) {
			int val = (A[i] == 0) ? 1 : -1;
			currentSum += val;
			if (currentSum < 0) { //Reset current sum to 0 and move start index to right.
				currentSum = 0;
			}
			if (currentSum > maxSum) { //when you found the greater current sum, update the maxsum and the answer indices
				maxSum = currentSum;
				answer[1] = i + 1; // end index, +1 for 1 based indexing
			}
		}
		return answer;
		
	}

}
