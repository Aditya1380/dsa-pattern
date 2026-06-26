package com.fastandslowpointers5;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		super();
		this.val = val;
		this.next = next;
	}
}

public class LinkedListCycle {

	public static void main(String[] args) {
		// Creating a linked list: 3 -> 2 -> 0 -> -4
		ListNode head = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;

		// Test Case 1: No cycle currently
		System.out.println("Has cycle? " + hasCycle(head)); // Output: false

		// Creating a cycle: Link the tail (-4) back to node2 (2)
		node4.next = node2;

		// Test Case 2: Cycle present
		System.out.println("Has cycle? " + hasCycle(head)); // Output: true
	}

	private static boolean hasCycle(ListNode head) {
		if (head == null && head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}
