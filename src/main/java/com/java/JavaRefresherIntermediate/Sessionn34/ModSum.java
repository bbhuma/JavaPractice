package com.java.JavaRefresherIntermediate.Sessionn34;

public class ModSum {
	/*
	 * Whenever you see:
	 * - sum of (A[i] % A[j])
	 * 
	 * Think:
	 * 
	 * Fix divisor
	 * 
	 * Process in ranges
	 * 
	 * Use frequency + prefix sum
	 */

	public static void main(String[] args) {
		int[] arr = {1,1,2,5,3,4,7,9,5,6,7,8,9};
		System.out.println(modSumBruteforce(arr));
		System.out.println(modSumFrequencyBased(arr));
		 System.out.println(modSumOptimizedreqMethod(arr));
		
	}
	public static int modSumBruteforce(int[] arr) {
		int mod = 1000000007;
		int n= arr.length;
		int sum = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sum += (arr[i]%arr[j]);
			}
		}
		return sum%mod;
	}
	
	public static int modSumFrequencyBased(int[] arr) {
		int mod = 1000000007;
		int MAX = 100000; // we can also find the maximum element in the array and use that as the size of frequency array, but here we are assuming that the maximum element in the array is 100000, if it is greater than that, we need to increase the size of frequency array accordingly
		int n= arr.length;
		long[] freq = new long[MAX+1];
		for(int num : arr) {
			freq[num]++;
		}
		
		long ans = 0;
		for(int i=0;i<=1000;i++) {
			if (freq[i] == 0) continue;
			
			for(int j=1;j<=1000;j++) {
				if (freq[j] == 0) continue;
				
				ans += 1L*freq[i] * freq[j] * (i % j); // where A[i] = i and A[j] = j
				// we are multiplying by the frequency of i and j because we can choose any element from the frequency of i and any element from the frequency of j to form a pair (i,j), and we are adding (i%j) for each pair (i,j) to the answer
				//ans is the sum of (A[i] % A[j]) for all pairs (i,j) where A[i] = i and A[j] = j, and we are multiplying by the frequency of i and j because we can choose any element from the frequency of i and any element from the frequency of j to form a pair (i,j)
				ans %= mod;
			}
		}
		return (int)ans%mod;
	}
	public static int modSumOptimizedreqMethod(int[] arr) {
		int mod = 1000000007;
		int max = 0;
		int n= arr.length;
		int sum = 0;
		for(int num : arr) {
			max = Math.max(max, num);
			
		}
		// frequency array to store the frequency of each number in the input array, we are using max+1 because we want to store the frequency of numbers from 0 to max
		long[] freq = new long[max+1];
		for(int num : arr) {
			freq[num]++;
		}
		
		// prefix sum of frequency array
		long[] prefixSum = new long[max+1];
		prefixSum[0] = freq[0];
		for(int i=1;i<=max;i++) {
			prefixSum[i] = prefixSum[i-1] + freq[i];
		}
		
		long result = 0;
		
		for (int x = 1; x <= max; x++) {
	        if (freq[x] == 0) continue;

	        for (int k = 1; k * x <= max; k++) {
	            int left = k * x;
	            int right = Math.min(max, (k + 1) * x - 1);

	            long count = prefixSum[right] - prefixSum[left - 1];

	            result += freq[x] * count * (right - left + 1 - (k * x));
	            result %= mod;
	        }
	    }
		
		return (int) result;
	}
}
