package com.java.JavaRefresherIntermediate.Sessionn30;

public class HelpFromSam {

	public static void main(String[] args) {
		System.out.println(helpFromSam(5)); // 101 -> 2 one's
		System.out.println(helpFromSamFor(13));// 1101 -> 3 ones

	}

	public static int helpFromSam(int A) {
		// Simply count number of 1's in number, that is min help taken from sam
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((A & (1 << i)) != 0)
				count++;
		}
		return count;
	}

	public static int helpFromSamWhile(int A) {
		int score = 0; // one for score = A; target
		int help =0; // one to track help from sam
		int i = 31;
		while ( i>=0) { // not needed !(score == A)&& i>=0, simple i>=0 is enough
			score = score * 2;
			if ((A & (1 << i)) != 0) { // always not equal to 0, it is not ==1
				score = score + 1;
				help++;
			}
			i--;
		}
		return help;
	}
	
	public static int helpFromSamFor(int A) {
		int score = 0; // one for score = A; target
		int help =0; // one to track help from sam
		for(int i=31;i>=0;i--) {
			score = score*2 ; // score *= 2;
			if(((A & (1<<i)) !=0)) {
				score = score + 1;
				help++; // track sam help
			}
		}
		return help;
	}
}
