package com.java.JavaRefresherIntermediate.Sessionn34;

public class PairSumdivisiblebyM {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 }; // freq[] = {1,2,1,1,1} for target = 5
		int target = 5;
		System.out.println(pairSumDivisibleByTarget(arr, target));
	}

	public static int pairSumDivisibleByTarget(int[] arr, int target) {
		int count = 0;
		int[] freq = new int[target]; // SC is O(target) TC is O(n) + O(target/2) = O(n+target) = O(n) if target is small compared to n
		for(int num : arr) {
			freq[num%target]++; //0 to target-1 values we are storing the frequency of each remainder when divided by target
		}
		
		for(int j=0; j<=target/2; j++) { // target/2 because we are checking for pairs of remainders that add up to target, so we only need to check up to target/2
			if(j==0 || (j==target-j)) { // if target is even and we are at the middle element, then we can only choose 2 elements from that frequency
				count += 1L*freq[j]*(freq[j]-1)/2;
			}else {
				count += 1L*freq[j]*freq[target-j]; // if we are at any other element, then we can choose one element from that frequency and one element from the frequency of target-j
			}
		}
		return count;
	}

}
