package com.rsp.twoPointers;

// ValidWordAbbreviation.java
// Checks if an abbreviation is valid for a given word.
// Rules:
//  - Letters in abbr must match letters in word at the corresponding positions.
//  - Numbers in abbr represent how many letters to skip in word.
//  - Leading zeros in a number are invalid (e.g., "w0rd" is invalid).
//  - Entire word must be consumed exactly by the abbreviation.

public class ValidWordAbbreviation {

    /**
     * Returns true if 'abbr' is a valid abbreviation of 'word'.
     * Uses two indices:
     *  - wordIndex: current position in 'word'
     *  - abbrIndex: current position in 'abbr'
     *
     * Digits in 'abbr' are parsed into a number (may be multi-digit),
     * which tells how many characters to skip in 'word'.
     * Leading zeros are not allowed.
     */
    public static boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0, abbrIndex = 0;

        while (abbrIndex < abbr.length()) {
            char ch = abbr.charAt(abbrIndex);

            // If current abbr character is a digit, parse the full number.
            if (Character.isDigit(ch)) {
                // Leading zero is invalid (e.g., "01", "0")
                if (ch == '0') {
                    return false;
                }

                int num = 0;
                // Parse multi-digit number
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }

                // Skip 'num' characters in word
                wordIndex += num;
            } else {
                // Must match the current letter in word
                if (wordIndex >= word.length() || word.charAt(wordIndex) != ch) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }

        // Both must be fully consumed; wordIndex must land exactly at the end of word
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    // Driver code for quick testing
    public static void main(String[] args) {
        String[] words = {
                "a",
                "a",
                "abcdefghijklmnopqrst",
                "abcdefghijklmnopqrst",
                "word",
                "internationalization",
                "localization"
        };

        String[] abbreviations = {
                "a",      // true
                "b",      // false
                "a18t",   // true  (skip 18 letters)
                "a19t",   // false (skips too much)
                "w0rd",   // false (leading zero)
                "i18n",   // true
                "l12n"    // true
        };

        for (int i = 0; i < words.length; i++) {
            System.out.println((i + 1) + ". word: '" + words[i] + "'");
            System.out.println("   abbr: '" + abbreviations[i] + "'");
            boolean ok = validWordAbbreviation(words[i], abbreviations[i]);
            System.out.println("   Is valid? " + (ok ? "Yes" : "No"));
            System.out.println(new String(new char[80]).replace('\0', '-'));
        }
    }
}
