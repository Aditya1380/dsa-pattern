package com.monotonicstack;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        // Step 1: Record the LAST index where each character appears in s
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Track characters currently standing in our stack
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // Step 2: Iterate through the string using a Monotonic Stack
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is already inside our stack, skip it!
            if (inStack[ch - 'a']) {
                continue;
            }

            // WHILE the stack isn't empty, AND current char is smaller than top of stack,
            // AND top of stack appears again later in the string...
            while (!stack.isEmpty() 
                    && ch < stack.peek() 
                    && lastIndex[stack.peek() - 'a'] > i) {
                
                // Pop it out and unmark it from our visited array!
                char popped = stack.pop();
                inStack[popped - 'a'] = false;
            }

            // Push current character and mark it as present in the stack
            stack.push(ch);
            inStack[ch - 'a'] = true;
        }

        // Step 3: Build the final result string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println("Result: " + removeDuplicateLetters(s));
        // Expected Output: "acdb"
    }
}