package com.java.JavaRefresherIntermediate.Sessionn40;

public class MaximumHeightOfStaircase {

	public static void main(String[] args) {
		System.out.println(maximumHeightOfStaircase(20));
	}

	public static int maximumHeightOfStaircase(int num) {
		// height ranges from 1 to num
		int low = 1 ; 
		int high = (int)Math.sqrt(2L * num); // h² / 2 ≈ num i.e h ≈ √(2 × num) will give upper bound to the answer, very important edge case 
		int ans = 0;
		
		while(low <= high) {
			int height = low +(high-low)/2;
			long blocks = height*(height+1)/2; // safer version avoids overflow
			if( blocks <= num ) {
				ans = height;
				low = height+1;
			}
			else {
				high = height-1;
			}
		}
	 return ans;
	 }

}
