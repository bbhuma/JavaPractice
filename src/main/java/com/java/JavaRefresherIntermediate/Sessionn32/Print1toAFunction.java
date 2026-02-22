package com.java.JavaRefresherIntermediate.Sessionn32;

public class Print1toAFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Print 1 to A");
		print1toAFunction(-5);
	}
	public static void print1toAFunction(int num) {
		if(num <=0) { // Base case, better than num ==1 because it can handle negative numbers as well
			return;
		}
		print1toAFunction(num-1);
		System.out.print(num+" ");
		
		// Print in reverse order
		//System.out.print(num+" ");
		//print1toAFunction(num-1);
		
	}

}
