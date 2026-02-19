package com.java.JavaRefresherIntermediate.Sessionn26;

public class Flip1and0KadanesAlgo {
	public static void main(String[] args) {
		//int A[] = { 1, 0, 0, 1, 0, 0, 1, 1, 0, 1 };
		String str = "11001000010010101";
		int[] answer = maxOnesAfterFlips(str);
		System.out.print( "[");
		for (int i = 0; i < answer.length-1; i++) {
			System.out.print(answer[i]+", ");
		}
		System.out.print( answer[answer.length-1]);
		System.out.print( "]");
	}
	public static int[] maxOnesAfterFlips(String str) {
		int n = str.length();
		int[] answer = new int[2]; // [L,R] indices to be returned
		int currentSum = 0; //both curr sum and max sum start with zero's to track the number of 0's
		int maxSum = 0;
		// A -> 		 [1,1,0,0,1,0,0,1,1,0,1];
		// current sum -> 0 0 1 2 1 1 2 3 3 3 4 4
		int l=0,r=0; // to track the start index of the current sum
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='0') currentSum +=1;
			else currentSum -=1;
			if(currentSum > maxSum) { //everytime when you find a new max, update it, and add r to answer. 
				maxSum = currentSum;
				answer[0] = l+1;
				answer[1] = r+1;
			}
			if(currentSum< 0) {
				currentSum=0;
				l= i+1; // reset l and r to i+1;
				r=i+1;
			}
			else {
				r +=1; // we can also use r++ since it is not part of expression.
			}
			
				
			
		}
		if(maxSum==0) return new int[0]; // if no 0's found, return empty array.
		
		return answer;
		
	}

}
