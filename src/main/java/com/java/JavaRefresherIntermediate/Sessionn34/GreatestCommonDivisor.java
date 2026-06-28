package com.java.JavaRefresherIntermediate.Sessionn34;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		System.out.println(getGreatestCommonDivisor(25, 15));
		System.out.println(getGreatestCommonDivisor(12, 30));
		System.out.println(getGreatestCommonDivisor(9, 18));
		System.out.println(getGreatestCommonDivisor(81, 153));

	}

	public static int getGreatestCommonDivisor(int m, int n) {
		if (n==0 ) {
			return m;
		}
		if (m==0) {
			return n;
		}
		if(m<n) {
			return getGreatestCommonDivisor(n%m, m);
		}else 
		return getGreatestCommonDivisor(m % n, n);
	}
	

}
