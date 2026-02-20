package com.java.JavaRefresherIntermediate.Sessionn30;

public class FindNthMagicNumber {

	public static void main(String[] args) {
		int ans = findNthMagicNumber(10);
		System.out.println(ans);
		System.out.println(findNthMagicNumber(5));
	}

	// unique powers of 5 sum, ath element. 
	public static int findNthMagicNumber(int num) {
		int power = 5;
		int magicNumber = 0;
		while(num>0) {
			if((num & 1) ==1 ) {
				magicNumber += power;
			}
			power *= 5;
			num >>=1;
		}
		
		return magicNumber;
	}

}
