package com.java.JavaRefresherIntermediate.Sessionn32;

public class PrintAto1function {

	public static void main(String[] args) {
		printAto1function(5);
	}

	public static void printAto1function(int num) {
		printHelper(num);
		System.out.println();
	}
	public static void printHelper(int num) {
		if(num==0) return;
		System.out.print(num+" ");
		printHelper(num-1);
	}

}
