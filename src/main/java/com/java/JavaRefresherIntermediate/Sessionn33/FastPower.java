package com.java.JavaRefresherIntermediate.Sessionn33;

public class FastPower {

	public static void main(String[] args) {
		System.out.println(fastPower(2L,10));
		System.out.println(fastPower(1L,100));
		System.out.println(fastPower(1000000000L,2L));
		System.out.println(normalPower(2,10));
		System.out.println(normalPower(1,100));
	}
	
	// TC is O(b)
	public static long normalPower(int a, int b) {
		if(b==1) return a;
		
		return a * normalPower(a,b-1);
	}
	// TC is O(long b)
	public static long fastPower(long a, long b) {
		if(b==0) return 1;
		
		if(b%2==0) {
			return fastPower(a*a,b/2); // also same as fastPower(a, b / 2)* fastPower(a, b / 2);
		}else {
			return a*fastPower(a*a,b/2);
		}
	}

}
