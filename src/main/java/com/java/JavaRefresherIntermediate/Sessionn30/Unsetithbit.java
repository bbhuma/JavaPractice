package com.java.JavaRefresherIntermediate.Sessionn30;

public class Unsetithbit {

	public static void main(String[] args) {
		int A = 23;
		int B = 2; //0,1,2 0-based index
		int ans = unsetithbit(A,B);
		System.out.println(ans);
	}
	public static int unsetithbit(int A, int B) {
		if((A & (1<< B)) !=0) {
			// Unset bth bit 
			A = A & ~(1 << B);
			
			//Toggle bth bit
			A = A ^ (1<< B); // XOR A with 2^B = (1 << B) ==> A = 23 ^ 4;
		}
		return A; // else return A as is, no change
	}

}
