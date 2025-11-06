package com.rsp.twoPointers;

// IsStrobogrammatic.java
// Determine if a numeric string looks the same when rotated 180 degrees.
// Valid strobogrammatic pairs: (0,0), (1,1), (8,8), (6,9), (9,6)

import java.util.*;

public class IsStrobogrammatic {

    /**
     * Returns true if 'num' is strobogrammatic.
     * Uses a dictionary (map) of valid rotations and a two-pointer scan.
     *
     * Time:  O(n)
     * Space: O(1)  (map has constant size)
     */
    public static boolean isStrobogrammatic(String num) {
        if (num == null) return false;       // null is not valid
        if (num.length() == 0) return true;  // empty considered strobogrammatic

        // Rotation mapping
        Map<Character, Character> dict = new HashMap<>();
        dict.put('0', '0');
        dict.put('1', '1');
        dict.put('8', '8');
        dict.put('6', '9');
        dict.put('9', '6');

        int left = 0, right = num.length() - 1;

        while (left <= right) {
            char L = num.charAt(left);
            char R = num.charAt(right);

            // Left char must be rotatable, and its rotation must equal the right char
            if (!dict.containsKey(L) || dict.get(L) != R) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Simple driver
    public static void main(String[] args) {
        String[] tests = {
                "69",     // true
                "88",     // true
                "818",    // true
                "619",    // false
                "962",    // false
                "2",      // false (2 is not rotatable)
                "1",      // true
                "0",      // true
                "101",    // true
                "906",    // true (9↔6, 0 stays 0)
                ""        // true (by convention here)
        };

        for (String s : tests) {
            System.out.printf("num='%s' -> %s%n", s, isStrobogrammatic(s));
        }
    }
}

