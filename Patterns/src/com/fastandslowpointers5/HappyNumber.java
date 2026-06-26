package com.fastandslowpointers5;

public class HappyNumber {

    // Helper method to calculate the sum of the squares of its digits
    // This acts as our "node.next" generator
    private static int getNextNumber(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        // We simulate the Floyd's Cycle detection using our structural ListNode logic
        ListNode slow = new ListNode(n);
        ListNode fast = new ListNode(n);

        // Move slow by 1 transformation, fast by 2 transformations initially
        slow.next = new ListNode(getNextNumber(slow.val));
        fast.next = new ListNode(getNextNumber(getNextNumber(fast.val)));

        slow = slow.next;
        fast = fast.next;

        // Keep running until fast reaches 1, or they loop and meet each other
        while (fast.val != 1 && slow.val != fast.val) {
            // Move slow 1 step ahead
            slow.next = new ListNode(getNextNumber(slow.val));
            slow = slow.next;

            // Move fast 2 steps ahead
            int firstJump = getNextNumber(fast.val);
            int secondJump = getNextNumber(firstJump);
            fast.next = new ListNode(secondJump);
            fast = fast.next;
        }

        // If the fast pointer made it to 1, it's a Happy Number!
        return fast.val == 1;
    }

    public static void main(String[] args) {
        int test1 = 19;
        int test2 = 2;

        System.out.println(test1 + " is a happy number? " + isHappy(test1)); // Output: true
        System.out.println(test2 + " is a happy number? " + isHappy(test2)); // Output: false
    }
}