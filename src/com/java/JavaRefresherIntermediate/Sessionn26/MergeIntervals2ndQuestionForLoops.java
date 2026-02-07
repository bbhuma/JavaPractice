package com.scaler.JavaRefresherIntermediate.Sessionn26;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals2ndQuestionForLoops {
	public static void main(String[] args) {
		int [][] intervals = { { 1, 3 }, { 6, 9 } };
		int [] newInterval = { 2, 5 };
		int[][] answer = mergeIntervals2ndQuestion(intervals,newInterval);
		for (int i = 0; i < answer.length; i++) {
			System.out.print("[" + answer[i][0] + "," + answer[i][1] + "] ");
		}

	}

	public static int[][] mergeIntervals2ndQuestion(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> result = new ArrayList<>();
		//Check if there are any intervals before the start of newInterval, if there are add them directly to list. 
		int i=0;
		int n= intervals.length;
		
		while(i<n && intervals[i][1]< newInterval[0]) {
			result.add(intervals[i]);
			i++;	
		}
		// merging until no overlap of intervals with new interval
		while(i<n && newInterval[1]>intervals[i][0]) {
			newInterval[0]= Math.min(intervals[i][0],newInterval[0] );
			newInterval[1]= Math.max(intervals[i][1],newInterval[1] );
			i++;
		}
		result.add(newInterval);
		
		while(i<n && newInterval[1]< intervals[i][0]) {
			result.add(intervals[i]);
			i++;
		}
		
		return result.toArray(new int[result.size()][2]);
	}
}
