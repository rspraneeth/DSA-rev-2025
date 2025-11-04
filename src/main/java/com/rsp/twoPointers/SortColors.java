package com.rsp.twoPointers;

import java.util.*;

// Utility class for printing arrays and repeated characters
class Print {
    // Converts an int array to a formatted string
    public static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    // Returns a string with a repeated character (used for separators)
    public static String repeat(String s, int n) {
        return new String(new char[n]).replace("\0", s);
    }
}

// Main solution class
public class SortColors {

    /**
     * Sorts an array containing only 0s, 1s, and 2s (colors)
     * using the Dutch National Flag algorithm by Edsger Dijkstra.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int[] sortColors(int[] colors) {

        int start = 0;             // Pointer for the next position of 0
        int current = 0;           // Current index being examined
        int end = colors.length - 1; // Pointer for the next position of 2

        // Traverse the array until current crosses end
        while (current <= end) {

            // If current element is 0, swap it to the start
            if (colors[current] == 0) {
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                start++;
                current++;
            }

            // If current element is 1, just move forward
            else if (colors[current] == 1) {
                current++;
            }

            // If current element is 2, swap it to the end
            else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                end--;  // Do not increment current here (need to recheck swapped value)
            }
        }

        return colors;
    }

    // Driver code to test the algorithm
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Print.arrayToString(inputs[i]));

            // Sort a clone of the array to preserve original input
            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Print.arrayToString(sortedColors));

            System.out.println(Print.repeat("-", 100));
        }
    }
}

