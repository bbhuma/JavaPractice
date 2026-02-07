package com.scaler.JavaRefresherIntermediate.Sessionn26;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals2ndQuestionWhileLoops {
	public static void main(String[] args) {
		int [][] intervals = { { 1, 3 }, { 6, 9 } };
		int [] newInterval = { 2, 5 };
		int[][] answer = mergeIntervals2ndQuestion(intervals,newInterval);
		for (int i = 0; i < answer.length; i++) {
			System.out.print("[" + answer[i][0] + "," + answer[i][1] + "] ");
		}
	}

	public static int[][] mergeIntervals2ndQuestion(int[][] A, int[] B) {

	    ArrayList<int[]> result = new ArrayList<>();

	    int newStart = B[0];
	    int newEnd   = B[1];

	    boolean inserted = false;   // 👈 very important flag

	    for (int i = 0; i < A.length; i++) {

	        int start = A[i][0];
	        int end   = A[i][1];

	        // 1️⃣ current interval is BEFORE new interval
	        if (end < newStart) {
	            result.add(new int[]{start, end});
	        }

	        // 2️⃣ current interval is AFTER new interval
	        else if (start > newEnd) {

	            // insert new interval ONLY ONCE
	            if (!inserted) {
	                result.add(new int[]{newStart, newEnd});
	                inserted = true;
	            }

	            // then add current interval
	            result.add(new int[]{start, end});
	        }

	        // 3️⃣ overlap → merge into new interval
	        else {
	            newStart = Math.min(newStart, start);
	            newEnd   = Math.max(newEnd, end);
	        }
	    }

	    // 4️⃣ if new interval was never added (goes at end)
	    if (!inserted) {
	        result.add(new int[]{newStart, newEnd});
	    }

	    return result.toArray(new int[result.size()][2]);
	}

}
