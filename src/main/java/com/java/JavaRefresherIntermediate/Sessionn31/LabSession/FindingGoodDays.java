package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

public class FindingGoodDays {

	public static void main(String[] args) {
		System.out.println(findingGoodDays(25)); // cat wants to eat 25 units of food, so how many days should the cat behave well
	}
	public static int findingGoodDays(int num) {
		int goodDays=0;
		while(num>0) {
			num = num &(num-1);
			goodDays++;
		}
		return goodDays;
	}

}
