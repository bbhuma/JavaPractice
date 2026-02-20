package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

public class Numberof1Bits {

	public static void main(String[] args) {
		System.out.println(numberof1Bits(25));
		System.out.println(numberof1Bits(0));
		System.out.println(numberof1Bits(-12)); // most imprtant edg case, shows -1 has 32 ones. 
	}

	public static int numberof1BitsCountEachBit(int num) {
		int numberOf1bits=0;
		int i=0;
		while(i<32) {
			if((num & (1<<i)) !=0) { //if t is one, count it.
				numberOf1bits++;
			}
			i++;
		}
		return numberOf1bits;
	}
	
	public static int numberof1Bits(int num) {
		int numberOf1bits=0;
		while(num != 0) { // while n>0 works only for positive numbers. 
			num = (num & (num-1));
			numberOf1bits++;
		}
		return numberOf1bits;
	}

}
