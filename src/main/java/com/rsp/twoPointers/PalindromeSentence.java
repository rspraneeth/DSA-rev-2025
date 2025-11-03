package com.rsp.twoPointers;

public class PalindromeSentence{
    /*Given a string, s, return TRUE if it is a palindrome; otherwise, return FALSE. A phrase is considered a palindrome if it reads the same backward as
    forward after converting all uppercase letters to lowercase and removing any characters that are not letters or numbers. Only alphanumeric characters (letters and digits) are taken into account.*/

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
        };

        for (String test : testCases) {
            System.out.println("\tString: " + test);
            boolean result = isPalindrome(test);
            System.out.println("\n\tResult: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
