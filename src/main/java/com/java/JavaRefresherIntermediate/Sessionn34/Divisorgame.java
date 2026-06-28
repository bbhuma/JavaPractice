package com.java.JavaRefresherIntermediate.Sessionn34;

public class Divisorgame {

	public static void main(String[] args) {
		System.out.println(divisorgameBruteforce(12,3,2));
		System.out.println(divisorgameBruteforce(6,1,4));
		System.out.println(divisorgameBruteforce(10,2,3));
		
		System.out.println(divisorgameOptimized(12,3,2));
		System.out.println(divisorgameOptimized(6,1,4));
		System.out.println(divisorgameOptimized(10,2,3));
		
	}
	public static int divisorgameBruteforce(int A,int B,int C) {
		int cnt =0;
		for(int i=1;i<=A;i++) {
			if(i%B == 0 && i%C == 0) {
				cnt++;
			}
		}
		return cnt;
	}
	
	//TC mainly depends on gcd function, others are constant 
	public static int divisorgameOptimized(int A,int B,int C) {
		int cnt =0;
		long lcm = 1L*B*C/ gcd(B,C); // LCM * GCD = Multiply two numbers
		
		return (int) (A/lcm);
	}
	
	// TC is O(log(min(b,c)))
	public static int gcd(int b, int c) {
		if(b==0) return c;
		if(c==0) return b;
				
		return gcd(c,b%c);
	}

}
