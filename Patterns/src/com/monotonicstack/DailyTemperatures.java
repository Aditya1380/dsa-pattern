package com.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n]; // Java auto-initializes this to all 0s
        
        // Stack will store the INDICES of the days, not the actual temperatures
        Stack<Integer> stack = new Stack<>();

        // Walk through each day one by one
        for (int i = 0; i < n; i++) {
            // WHILE the stack isn't empty AND the current day's temperature
            // is strictly warmer than the day waiting at the top of our stack...
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // 1. Pop the cold day index out of the stack
                int poppedIndex = stack.pop();
                
                // 2. Calculate the distance (days waited) and save it
                result[poppedIndex] = i - poppedIndex;
            }
            
            // Push the current day's index onto the stack to wait for its warmer day
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temps);

        System.out.println("Wait days: " + Arrays.toString(result));
        // Expected Output: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}