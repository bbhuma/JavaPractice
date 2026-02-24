package com.java.JavaRefresherIntermediate.Sessionn33;

public class CheckPalindromeusingRecursion {

	public static void main(String[] args) {
		String str1 = "abcdcba";
		String str2 = "palindrome";
		String str3 = "";
		String str4 = "a";
		String str5 = null;

		System.out.println(isPalindrome(str1));
		System.out.println(isPalindrome(str2));
		System.out.println(isPalindrome(str3));
		System.out.println(isPalindrome(str4));
		System.out.println(isPalindrome(str5));

		// handle null if any before invoking length
		System.out.println(checkPalindromeusingRecursionBadDesign(str5, 0, (str5 != null) ? str5.length() - 1 : 0));
		System.out.println(checkPalindromeusingRecursionBadDesign(str1, 0, str1.length() - 1));
		System.out.println(checkPalindromeusingRecursionBadDesign(str2, 0, str2.length() - 1));
		System.out.println(checkPalindromeusingRecursionBadDesign(str3, 0, str3.length() - 1));
		System.out.println(checkPalindromeusingRecursionBadDesign(str4, 0, str4.length() - 1));

	}

	public static int isPalindrome(String str) {

		if (str == null)
			return 0;

		return helper(str, 0, str.length() - 1);
	}

	private static int helper(String str, int l, int r) {

		if (l >= r)
			return 1;

		if (str.charAt(l) != str.charAt(r))
			return 0;

		return helper(str, l + 1, r - 1);
	}

	public static int checkPalindromeusingRecursionBadDesign(String str, int l, int r) {
		if (str == null)
			return 0;
		// if(str.isBlank() || str.isEmpty()) return 1;
		int n = str.length();
		// if(str.length()==1) return 1; //not needed, since l>=r covers it.

		// Base case for recursion
		if (l >= r)
			return 1;

		// not palindorme
		if (str.charAt(l) != str.charAt(r))
			return 0;

		// recursion
		return checkPalindromeusingRecursionBadDesign(str, l + 1, r - 1);
	}

}
