package com.company;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String s;
        while(true) {
            s = JOptionPane.showInputDialog("");
            long start = System.nanoTime();
            if(s.length() == 0)
                break;
            if (PalindromeChecker.isPalindrome(s)) {
                JOptionPane.showMessageDialog(null, "Palindrome!");
            } else {
                JOptionPane.showMessageDialog(null, "Not palindrome!");
            }
            JOptionPane.showMessageDialog(null,
                    "Time elapsed: " + (System.nanoTime()-start)/(int)1e6 + " ms");

        }
    }
}
