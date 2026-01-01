package com.scaler.JavaRefresherIntermediate.Sessionn10.StringsHashing;

import java.util.ArrayList;
import java.util.HashMap;

public class Test1 {

	public static void main(String[] args) {

		int sum = add(20, 30);
		System.out.println(sum);
	}

	public static int add(int x, int y) {
		return x + y;
	}

	public String reverseString(String str) {
		String reverse = "";
		for (int i = 1; i < str.length(); i++) {
			reverse = reverse + str.charAt(i);
		}
		return reverse;
	}

	public String solve(String A) {
		String strLower = "";
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if ('A' <= ch && ch <= 'Z')
				strLower += (char) (ch + 32);
		}
		return strLower;
	}

	public int solve1(String A) {
		int mcount =0;
		int pcount =0;
		int acount =0;
		if (A.length() % 2 != 0)
			return 0;
		
		for (int i = 0; i < A.length(); i++) {
			if(A.charAt(i)=='m') mcount++;
			if(A.charAt(i)=='p') pcount++;
			if(A.charAt(i)=='a') acount++;
			if(mcount == acount+ pcount) return 1;
		}

		return 0;
	}
	
	public static int population(HashMap<String, Integer> H, int K){
		int count =0;
	    for(String str : H.keySet()) {
	    	if(H.get(str)<K)count++;
	    }
		return count;
	    
	}
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		return B;
    }

}
