package com.fastandslowpointers5;

public class ReorderList {
	public static void main(String[] args) {
		// Create list: 1 -> 2 -> 3 -> 4 -> 5 -> null
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.print("Original List: ");
		printList(head);

		reorderList(head);

		System.out.print("Reordered List: ");
		printList(head); // Output: 1 -> 5 -> 2 -> 4 -> 3 -> null
	}

	// Helper method to print the list
	public static void printList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}

	private static void reorderList(ListNode head) {
		if (head == null && head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondHalfHead = reverseList(slow.next);
		System.out.println(slow.val);
		slow.next = null;

		ListNode firstHalfHead = head;
		mergeAlternately(firstHalfHead, secondHalfHead);
	}

	private static void mergeAlternately(ListNode l1, ListNode l2) {
		while (l1 != null && l2 != null) {
			ListNode nextL1 = l1.next;
			ListNode nextL2 = l2.next;
			
			
			l1.next = l2;
			if(nextL1==null) {
				break;
			}
			l2.next = nextL1;
			
			l1 = nextL1;
			l2 = nextL2;
		}

	}

	private static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			System.out.println("Current NEXT :" + curr.val);
			ListNode nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}

		return prev;
	}
	
}
