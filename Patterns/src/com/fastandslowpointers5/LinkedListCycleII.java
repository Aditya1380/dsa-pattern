package com.fastandslowpointers5;

public class LinkedListCycleII {
	public static void main(String[] args) {
		// Create list: 3 -> 2 -> 0 -> -4
		ListNode head = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;

		// Create a cycle: Point -4 back to 2
		node4.next = node2;

		ListNode cycleStart = detectCycle(head);

		if (cycleStart != null) {
			System.out.println("Cycle starts at node with value: " + cycleStart.val); // Output: 2
		} else {
			System.out.println("No cycle found.");
		}
	}

	private static ListNode detectCycle(ListNode head) {
		if (head == null && head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;

		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}
		if (!hasCycle) {
			return null;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}
