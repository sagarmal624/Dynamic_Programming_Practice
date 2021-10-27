package com.example.mongodbpoc.faang;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(alMostPalindrome("abcwdba"));
    }

    public static boolean isPalinDrone(String str) {

        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean alMostPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return isp(str.substring(left + 1, right)) || isp(str.substring(left, right - 1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isp(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
