package com.rsp.twoPointers;

import java.util.*;

// Definition for a Linked List node
class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Utility class to print the linked list
class PrintList {
    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
    }
}

// Utility class to easily create a linked list from a List<Integer>
class LinkedList {
    ListNode head;

    public LinkedList(List<Integer> values) {
        if (values == null || values.isEmpty()) return;
        this.head = new ListNode(values.get(0));
        ListNode current = this.head;
        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
    }
}

// Main solution class
public class RemoveNthLastNode {

    /**
     * Removes the Nth node from the end of a linked list.
     * Uses the two-pointer (fast and slow) technique.
     */
    public static ListNode removeNthLastNode(ListNode head, int n) {
        // Initialize two pointers at the head
        ListNode right = head;
        ListNode left = head;

        // Step 1: Move the right pointer n steps ahead
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        // Step 2: If right becomes null, that means
        // we need to remove the head node itself
        if (right == null) {
            return head.next;
        }

        // Step 3: Move both pointers together
        // until right reaches the end (right.next == null)
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        // Step 4: Skip the Nth node from the end
        left.next = left.next.next;

        // Step 5: Return the (possibly updated) head
        return head;
    }

    // Driver Code
    public static void main(String[] args) {
        List<List<Integer>> inputs = Arrays.asList(
                Arrays.asList(23, 89, 10, 5, 67, 39, 70, 28),
                Arrays.asList(34, 53, 6, 95, 38, 28, 17, 63, 16, 76),
                Arrays.asList(288, 224, 275, 390, 4, 383, 330, 60, 193),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
                Arrays.asList(69, 8, 49, 106, 116, 112, 104, 129, 39, 14, 27, 12)
        );

        int[] n = {4, 1, 6, 9, 11};

        for (int i = 0; i < inputs.size(); i++) {
            // Create a new linked list from the input
            LinkedList inputLinkedList = new LinkedList(inputs.get(i));

            // Display the original list
            System.out.print((i + 1) + ".\tLinked List:\t\t");
            PrintList.display(inputLinkedList.head);

            // Show n value
            System.out.print("\n\tn = " + n[i]);

            // Remove the Nth node from end and show updated list
            System.out.print("\n\tUpdated Linked List:\t");
            PrintList.display(removeNthLastNode(inputLinkedList.head, n[i]));

            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

