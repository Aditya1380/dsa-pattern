package com.fastandslowpointers5;

public class Palindrome {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}

		// Step 1: Find the middle of the linked list
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half of the linked list
		// 'slow' is now at the middle node
		ListNode secondHalfHead = reverseList(slow);
		ListNode firstHalfHead = head;

		// Step 3: Compare both halves
		ListNode p1 = firstHalfHead;
		ListNode p2 = secondHalfHead;
		boolean isPalindrome = true;

		while (p2 != null) { // We only need to check until the end of the second half
			if (p1.val != p2.val) {
				isPalindrome = false;
				break;
			}
			p1 = p1.next;
			p2 = p2.next;
		}

		// Optional Step 4: Restore the list structure (Good practice)
		reverseList(secondHalfHead);

		return isPalindrome;
	}

	// Helper method to reverse a linked list in-place
	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		while (current != null) {
			System.out.println("Current Node Value : "+current.val);
			ListNode nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		return prev; // New head of the reversed list
	}

	public static void main(String[] args) {
		// Create list: 1 -> 2 -> 2 -> 1
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		System.out.println("Is palindrome? " + isPalindrome(head)); // Output: true
//
//		// Create list: 1 -> 2 -> 3
//		ListNode head2 = new ListNode(1);
//		head2.next = new ListNode(2);
//		head2.next.next = new ListNode(3);
//
//		System.out.println("Is palindrome? " + isPalindrome(head2)); // Output: false
	}
}
