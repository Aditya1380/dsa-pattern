package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    // Keypad mapping where index represents digit (e.g., index 2 = "abc")
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge Case: Empty input string
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int digitIndex, String digits, StringBuilder currentPath, List<String> result) {
        // Step 1: Base Case - path length matches digits length
        if (digitIndex == digits.length()) {
            result.add(currentPath.toString());
            return;
        }

        // Step 2: Get corresponding letters for current digit
        char digit = digits.charAt(digitIndex);
        String letters = KEYPAD[digit - '0'];

        // Step 3: Iterate through all mapped letters
        for (char c : letters.toCharArray()) {
            // STEP A: MAKE CHOICE
            currentPath.append(c);

            // STEP B: RECURSE (move to next digit)
            backtrack(digitIndex + 1, digits, currentPath, result);

            // STEP C: UNDO CHOICE (Backtrack!)
            currentPath.deleteCharAt(currentPath.length() - 1);
        }
    }
 
    public static void main(String[] args) {
        String digits = "23";
        System.out.println("Combinations: " + letterCombinations(digits));
        // Expected Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }
}