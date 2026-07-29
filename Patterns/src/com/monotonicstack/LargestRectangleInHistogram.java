package com.monotonicstack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        // Loop up to n (inclusive) to process a dummy bar of height 0 at index n
        for (int i = 0; i <= n; i++) {
            // Treat index 'n' as height 0 to flush out remaining items in the stack
            int currentHeight = (i == n) ? 0 : heights[i];

            // WHILE stack is not empty AND current height is smaller than top of stack height...
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                // 1. Pop the height index we are calculating the rectangle for
                int poppedIndex = stack.pop();
                int height = heights[poppedIndex];

                // 2. Determine width
                // Right boundary is 'i'. 
                // Left boundary is the index below poppedIndex in the stack (or -1 if stack is empty)
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftIndex - 1;

                // 3. Update max area
                maxArea = Math.max(maxArea, height * width);
            }

            // Push current index onto the stack
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
        // Expected Output: 10 (bars at index 2 and 3: height 5 and 6 form a 2x5 rectangle)
    }
}