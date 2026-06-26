package com.fastandslowpointers5;

public class RemoveNthNode {

	public static void main(String[] args) {
		// Create list: 1 -> 2 -> 3 -> 4 -> 5 -> null
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.print("Original List: ");
		printList(head);

		// Remove 2nd node from the end (Node 4)
		head = removeNthFromEnd(head, 2);

		System.out.print("Modified List (Removed 2nd from end): ");
		printList(head); // Output: 1 -> 2 -> 3 -> 5 -> null
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode slow = dummy;
		ListNode fast = dummy;

		for (int i = 0; i <= n; i++) {
			fast = fast.next;
		}
		
		while(fast!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
		return dummy.next;
	}

	public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}
