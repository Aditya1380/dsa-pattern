package com.fastandslowpointers5;

public class MiddleOfLinkList {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(-4);
		ListNode node5 = new ListNode(-7);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		int middleElement = midElement(head);
		System.out.println("The middle element of list " + middleElement);
	}
             
	private static int midElement(ListNode head) {
		if (head == null && head.next == null) {
			return 0;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.val;
	}
}
