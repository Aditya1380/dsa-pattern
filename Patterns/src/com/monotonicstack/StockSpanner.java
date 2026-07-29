package com.monotonicstack;

import java.util.Stack;

public class StockSpanner {

    // Stack holds pairs: [price, accumulatedSpan]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; // Today counts as 1 day

        // WHILE stack isn't empty AND previous price <= today's price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Pop the smaller price and absorb its span!
            span += stack.pop()[1];
        }

        // Push today's price and its total compressed span onto the stack
        stack.push(new int[]{price, span});

        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // Returns 1
        System.out.println(stockSpanner.next(80));  // Returns 1
        System.out.println(stockSpanner.next(60));  // Returns 1
        System.out.println(stockSpanner.next(70));  // Returns 2 (absorbs 60)
        System.out.println(stockSpanner.next(60));  // Returns 1
        System.out.println(stockSpanner.next(75));  // Returns 4 (absorbs 60, 70, 60)
        System.out.println(stockSpanner.next(85));  // Returns 6 (absorbs 80, 60, 70, 60, 75)
    }
}