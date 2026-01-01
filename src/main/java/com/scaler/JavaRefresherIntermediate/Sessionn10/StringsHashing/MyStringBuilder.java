package com.scaler.JavaRefresherIntermediate.Sessionn10.StringsHashing;

class MyStringBuilder {
public String reverseString(String input) {
    if (input == null) {
        throw new IllegalArgumentException("null is not acceped as input");
    }
    StringBuilder reversed = new StringBuilder();
    for (int i = input.length() - 1; i >= 0; i--) {
        reversed.append(input.charAt(i));
    }                       
    return reversed.toString();
}
 public static void main(String[] args){
    MyStringBuilder sb = new MyStringBuilder();
    String result = sb.reverseString("fuck");
    System.out.println(result); // Output: "olleh"
}
}