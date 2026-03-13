package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DistinctNumbersinWindow {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 1, 2, 3}; // 8 elements, window size = 4, 8-4+1 = 5 windows
		int windowSize = 4;
		distinctNumbersinWindow(arr, windowSize);
		int[] result = distinctNumbersinWindowPractice(arr, windowSize);
		
	}
	
	// TC = O(n*windowSize), SC = O(windowSize) for set, windows ≈ N and work per window ≈ K
	public static void  distinctNumbersinWindow(int[] arr,int windowSize) {
		int n = arr.length;
		for(int i=0; i<=n-windowSize; i++) { // n-windowSize+1 windows, i = 0 to n-windowSize
			HashSet<Integer> set = new HashSet<>();
			for(int j=i; j<i+windowSize; j++) { // j = i to i+windowSize-1, as window size is 4, j = i to i+3
				set.add(arr[j]);
			}
			System.out.print(set.size()+" ");
		}
	}
	
	public static int[] distinctNumbersinWindowPractice(int[] arr,int windowSize) {
		int n = arr.length;
		if(windowSize>n) {
			return new int[0];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<=n-windowSize; i++) { // n-windowSize+1 windows, i = 0 to n-windowSize
			HashSet<Integer> set = new HashSet<>();
			 set.clear(); // clear the set for each window
			for(int j=i; j<i+windowSize; j++) {
				set.add(arr[j]);
			}
			list.add(set.size());
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static int[] distinctNumbersinWindowOptimized(int[] arr, int k) {
		int n = arr.length;
		
		if(k>n) {
			return new int[0];
		}
		
		int[] result = new int[n-k+1];
		
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		
		// first window
		for(int i=0; i<k; i++) {
			freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
		}
		result[0] = freqMap.size();
		
		for(int i=k; i<n; i++) {
			// remove the outgoing element
			int outgoing = arr[i-k]; // outgoing element is the one which is sliding out of the window, for i=k, outgoing = arr[0], for i=k+1, outgoing = arr[1], and so on
			freqMap.put(outgoing, freqMap.get(outgoing)-1);
			if(freqMap.get(outgoing) == 0) {
				freqMap.remove(outgoing);
			}
			
			// add the incoming element
			int incoming = arr[i];
			freqMap.put(incoming, freqMap.getOrDefault(incoming, 0)+1);
			
			result[i-k+1] = freqMap.size();
		}		
		return result;
	}
	public static int minMaxDiff(int[] arr) {
		int min = Arrays.stream(arr).min().orElse(-1);
		int max = Arrays.stream(arr).max().orElse(-1);
		return max - min;
	}
	
	

}
