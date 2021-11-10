package com.company;

public class PalindromeChecker {
    public static boolean isPalindrome(String s){
        if(s.isEmpty() || s.length() == 1) return true;
        return (s.charAt(0) == s.charAt(s.length()-1)) &&
                isPalindrome(s.substring(1, s.length()-1));
    }
}
