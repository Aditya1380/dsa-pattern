package com.fastandslowpointers5;

public class SortLinkedList {

    public static ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode nextToMid = mid.next;
        mid.next = null; // Break the link to separate the halves

        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMid);

        // Step 3: Merge the sorted halves together
        return sortedMerge(left, right);
    }

    // Helper: Find the middle node using Slow and Fast pointers
    private static ListNode getMid(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        // Starting 'fast' one step ahead ensures that 'slow' stops 
        // at the left-middle node for an even-sized list.
        ListNode fast = head.next; 

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper: Merge two sorted linked lists together
    private static ListNode sortedMerge(ListNode l1, ListNode l2) {
        // Dummy node acts as a dependable anchor to build our new sorted list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach any remaining nodes from either list
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
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

    public static void main(String[] args) {
        // Create list: 4 -> 2 -> 1 -> 3 -> null
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted List:   ");
        printList(head); // Output: 1 -> 2 -> 3 -> 4 -> null
    }
}