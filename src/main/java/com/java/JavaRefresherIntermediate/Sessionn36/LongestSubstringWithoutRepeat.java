package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {

		String str = "abcabcbb";

		System.out.println("Brute Force O(N^3): " + longestSubstringBruteForce(str));

		System.out.println("Better Brute O(N^2): " + longestSubstringBetterBrute(str));

		System.out.println("Sliding Window Set: " + longestSubstringSlidingWindowSet(str));

		System.out.println("Optimized Map Method: " + longestSubstringMapMethod(str));

		System.out.println("Best Array Hashing: " + longestSubstringArrayMethod(str));
	}

	// ---------------------------------------------------
	// 1️⃣ BRUTE FORCE (O N^3)
	// ---------------------------------------------------

	public static int longestSubstringBruteForce(String s) {

		int n = s.length();
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (allUnique(s, i, j)) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		return max;
	}

	private static boolean allUnique(String s, int start, int end) {
		HashSet<Character> set = new HashSet<>();
		for (int i = start; i <= end; i++) {
			char ch = s.charAt(i);
			if (set.contains(ch))
				return false;
			set.add(ch);
		}
		return true;
	}

	// ---------------------------------------------------
	// 2️⃣ BETTER BRUTE (O N^2)
	// ---------------------------------------------------

	public static int longestSubstringBetterBrute(String s) {
		int n = s.length();
		int max = 0;
		for (int i = 0; i < n; i++) {
			HashSet<Character> set = new HashSet<>();
			for (int j = i; j < n; j++) {
				char ch = s.charAt(j);
				if (set.contains(ch))
					break;
				set.add(ch);
				max = Math.max(max, j - i + 1);
			}
		}
		return max;
	}

	// ---------------------------------------------------
	// 3️⃣ SLIDING WINDOW (HASHSET)
	// ---------------------------------------------------

	public static int longestSubstringSlidingWindowSet(String arr) {
		int goodness = 0;
		int n = arr.length();
		int i = 0, j = 0;
		HashSet<Character> set = new HashSet<>();
		while (j < n) {
			if (!set.contains(arr.charAt(j))) {
				set.add(arr.charAt(j));
				goodness = Math.max(goodness, j - i + 1);
				j++;
			} else {
				set.remove(arr.charAt(i));
				i++;
			}
		}
		return goodness;
	}

	// ---------------------------------------------------
	// 4️⃣ OPTIMIZED HASHMAP METHOD
	// ---------------------------------------------------

	public static int longestSubstringMapMethod(String arr) {
		HashMap<Character, Integer> map = new HashMap<>();
		int goodness = 0;
		int i = 0; // left pointer, will move forward when we encounter a duplicate character
		int end =0; // right pointer, will move forward in each iteration
		for (int j = 0; j < arr.length(); j++) {
			char ch = arr.charAt(j);
			if (map.containsKey(ch)) {
				i = Math.max(i, map.get(ch) + 1); // Move the left pointer to the right of the last occurrence of the duplicate character
			}
			map.put(ch, j); // Update the last index of the character in the map
			goodness = Math.max(goodness, j - i + 1);
			System.out.println(arr.substring(i, i+(j-i+1)));  // Print the longest substring without repeating characters
		}
		return goodness;
	}

	// ---------------------------------------------------
	// 5️⃣ BEST METHOD (ARRAY HASHING)
	// ---------------------------------------------------

	public static int longestSubstringArrayMethod(String s) {
		int[] lastIndex = new int[256];
		for (int i = 0; i < 256; i++) {
			lastIndex[i] = -1;
		}
		int max = 0;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if (lastIndex[ch] >= left) {
				left = lastIndex[ch] + 1;
			}
			lastIndex[ch] = right;
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

}