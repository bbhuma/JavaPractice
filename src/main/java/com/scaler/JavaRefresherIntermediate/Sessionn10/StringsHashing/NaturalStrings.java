
package com.scaler.JavaRefresherIntermediate.Sessionn10.StringsHashing;

class NaturalStrings {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("apple");
        StringBuilder str2 = new StringBuilder("");

        for (int i = str1.length() - 1; i >= 0; i--) {
            str2.append(str1.charAt(i));
        }
        System.out.println(str2.toString()); // Output: "elppa"

        String original = "banana";
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println(reversed); // Output: "ananab"

        String str = "racecar";
        String reversedStr = new StringBuilder(str).reverse().toString();
        if (str.equals(reversedStr)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");

        }
         
        String str3 = "hello world";
        String[] words = str3.split(" ");   
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i != 0) {
                reversedSentence.append(" ");
            }
        }

        System.out.println(reversedSentence.toString()); // Output: "world hello"

        int[] numbers = {1, 2, 3, 4, 5};
        StringBuilder numberString = new StringBuilder();
        for (int num : numbers) {
            numberString.append(num).append(" ");
        }       
        System.out.println(numberString.toString().trim()); // Output: "1 2 3 4 5"  

        String str4 = "   Hello World   ";
        String trimmedStr = str4.trim();    
        System.out.println(trimmedStr); // Output: "Hello World"

        String str5 = "Java is fun";
        String replacedStr = str5.replace("fun", "awesome");    
        System.out.println(replacedStr); // Output: "Java is awesome"

        numberString.setLength(0); // Clear the StringBuilder
        for (int i = numbers.length - 1; i >= 0; i--) {
            numberString.append(numbers[i]).append(" ");
        }   
        System.out.println(numberString.toString().trim()); // Output: "5 4 3 2 1"

        reversedSentence.setLength(0); // Clear the StringBuilder
        for (int i = 0; i < words.length; i++) {
            reversedSentence.append(words[i]);
            if (i != words.length - 1) {
                reversedSentence.append(" ");
            }
        }
        System.out.println(reversedSentence.toString()); // Output: "hello world"
        

        
    }
}