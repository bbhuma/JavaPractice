package com.scaler.JavaRefresherIntermediate.Sessionn10.StringsHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringBasics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = scan.nextInt();

		for (int i = 0; i < testCases; i++) {
			String str = scan.next();
			System.out.println(str.length());
		}
        scan.close();

	}

	public int solve(final String A) {
		int countAlpha = 0;
		int counDigit = 0;
		for (char c : A.toCharArray()) {
			if (48 <= (int) c && (int) c <= 57)
				counDigit++;
			if ((65 <= (int) c && (int) c <= 90) && (97 <= (int) c && (int) c <= 122))
				countAlpha++;
		}
		return countAlpha > counDigit ? countAlpha : counDigit;

	}

	public int solve(final String A, final int B) {
		for (int i = 0; i < A.length(); i++) {
			if ((int) A.charAt(i) == B) {
				return i;
			}
		}
		return -1;
	}

	public String solve1(String A) {
		// return A.toUpperCase();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if ('a' <= c && c <= 'z') {
				sb.append((char) c - 32);
			} else
				sb.append(c);
		}
		return sb.toString();
	}

	public int solve1(final String A, final int B) {
		int index = -1;
		int j = 0;
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (c == B) {
				index = i;
				j = i;
			}
		}
		return j;

	}

	public int solve2(final String A, final int B) {
		int index = -1;
		for (int i = A.length() - 1; i >= 0; i--) {
			char c = A.charAt(i);
			if (c == B) {
				index = i;
			}
		}
		return index;

	}

	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testases = scan.nextInt();
		for (int i = 0; i < testases; i++) {
			String str = scan.next();
			int countVowel = 0;
			int countConst = 0;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					countVowel++;
				else
					countConst++;
			}
			   // ✅ Use the variables here — prevents warnings
        System.out.println("Vowels: " + countVowel + ", Consonants: " + countConst);
		scan.close();
		}
		
         
	}

	public String solve3(String A) {
		String str = "0abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			for (int j = 0; j < str.length(); j++) {
				if (c == str.charAt(j))
					sb.append(c + j);
			}
		}
		return sb.toString();
	}

	public int solve4(ArrayList<Integer> A) {
		Set<Integer> set = new HashSet<>();
		for (Integer num : A) {
			set.add(num);
		}
		return set.size();
	}

	public int solve5(ArrayList<Integer> A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			int count = 1;
			for (int j = 0; j < A.size(); j++) {
				if (A.get(i).equals(A.get(j)))
					count++;
			}
			if (count == 1)
				map.put(A.get(i), count);
		}

		return map.size();

	}

	public int[] solve6(int[] A) {
		for (int i = 0; i < A.length; i++) {

		}

		return A;
	}

	public String solve7(String A) {
		StringBuilder sb = new StringBuilder();
		for (int i = A.length() - 1; i >= 0; i--) {
			sb.append(A.charAt(i));
		}
		return sb.toString();
	}
	
	public int solve8(String A) {
		StringBuilder sb = new StringBuilder();
		for(int i=A.length()-1;i>=0;i-- ) {
			sb.append(A.charAt(i));
		}
		String str = sb.toString();
		if(str.equals(A))return 1;
		else return 0;
    }
	 public int solve9(ArrayList<Integer> A) {
		
			/*
	        HashMap<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < A.size(); i++) {
				int count = 0;
				for (int j = 0; j < A.size(); j++) {
					if (A.get(i).equals(A.get(j)))
						count++;
				}
				if (count == 1)
					map.put(A.get(i), count);
			}

			return map.size();
	        */
		 HashMap<Integer, Integer> map = new HashMap<>();
		 for(int num: A) {
			 map.put(num, map.getOrDefault(num,0)+1);
		 }
		 return map.size();
		}

}
