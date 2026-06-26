package com.fastandslowpointers5;

public class FindDuplicateLinkedList {
	public static void main(String[] args) {
		// Simulating a list containing a duplicate structure:
		// Index/Value Chain: 1 -> 3 -> 4 -> 2 -> [back to 3]
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(2);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;

		// Creating the duplicate link back to an existing value (node2 which has value
		// 3)
		node4.next = node2;

		System.out.println("The duplicate number is: " + findDuplicate(head)); // Output: 3
	}

	private static int findDuplicate(ListNode head) {
		if (head == null || head.next == null) {
            return -1;
        }
		ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Find the collision point inside the cycle
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        // Phase 2: Locate the entrance of the cycle (the duplicate value)
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Both pointers now point to the start of the loop
        return slow.val;
	}
}
