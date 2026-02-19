package com.java.JavaRefresherIntermediate.Sessionn30;

public class UnsetXbitsFromRight {

	public static void main(String[] args) {
		System.out.println(unsetXbitsFromRight(25,333));
		System.out.println(unsetXbitsFromRight(25,13));
	}
	 public static long unsetXbitsFromRight(long A, int B) {
		if(B<=32) {
	        for(int i=0;i<B;i++){
	            A = A & ~(1<<i);
	        }
	        return A;
		}
		 return -1;
	 }
}
