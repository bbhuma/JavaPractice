package com.java.JavaRefresherIntermediate.Sessionn26;

import java.util.ArrayList;

public class MergeSortedOverlappingIntervals {
	public static void main(String[] args) {
		int[][] A = { { 1, 3 }, { 2, 4 }, { 5, 7 }, { 6, 8 } };
		int[][] B = { { 1, 3 }, { 4, 6 }, { 5, 7 }, { 6, 8 } };
		int[][] A1 = mergeSortedOverlappingIntervals(A);
		int[][] B1 = mergeSortedOverlappingIntervals(B);
		for (int i = 0; i < A1.length; i++) {
			System.out.print("[" + A1[i][0] + "," + A1[i][1] + "] ");
		}
		System.out.println();
		for (int i = 0; i < B1.length; i++) {
			System.out.print("[" + B1[i][0] + "," + B1[i][1] + "] ");
		}
	}

	public static int[][] mergeSortedOverlappingIntervals(int[][] A) {
		ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();

		int start1 = A[0][0];
		int end1 = A[0][1];

		
		for (int i = 1; i < A.length; i++) {
			int start2 = A[i][0];
			int end2 = A[i][1];
			if (end1 >= start2) {
				end1 = Math.max(end1, end2);
			} else {
				ArrayList<Integer> temp = new ArrayList<>(); //New empty list for each merged interval
				temp.add(start1);
				temp.add(end1);
				mergedIntervals.add(temp);
				start1 = start2;
				end1 = end2;
				
			}
			
		}
		// 🔥 THIS WAS MISSING 
		// This must be added to include the last merged interval outside of the for loop
					ArrayList<Integer> temp = new ArrayList<>(); //New empty list for each merged interval
				    temp.add(start1);
				    temp.add(end1);
				    mergedIntervals.add(temp);
		return mergedIntervals.stream().map(interval -> interval.stream().mapToInt(Integer::intValue).toArray())
				.toArray(int[][]::new);
	}
}
