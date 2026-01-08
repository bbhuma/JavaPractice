package com.scaler.JavaRefresherIntermediate.Sessionn26;

public class ContinuousSumQuery {
	public static void main(String[] args) {
		int[] finalanswer = modifyAmountsofBeggers(5, new int[][] { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } });
		System.out.println("Final Amounts with each begger:");
		for (int i = 0; i < finalanswer.length; i++) {
			System.out.print(finalanswer[i]+" ");
		}
	}

	private static int[] pSum(int[] finalanswer) {
		int n= finalanswer.length;
		for(int i=1;i<n;i++) {
			finalanswer[i] += finalanswer[i-1];
		}
		return finalanswer;
	}

	public static int[] modifyAmountsofBeggers(int A, int[][] B) { // A beggers, B queries(devotees)
		int n = B.length;
		int[] answer = new int[A]; // size equal to number of beggers
		for (int i = 0; i < n; i++) {
			int startIndex = B[i][0] - 1; // converting to 0 based index
			int endIndex = B[i][1] - 1; // converting to 0 based index
			int amount = B[i][2];
			answer[startIndex] += amount;
			if (endIndex + 1 < A) {
				answer[endIndex + 1] -= amount;
			}
		}
		System.out.println("Amounts added as per each devotee:");
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();
		answer= pSum(answer);
		return answer;
	}
}
