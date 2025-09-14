/**
 * Utility class to rotate a singly linked list to the right by n positions.
 */
public class Question5_RotateLinkedList {

    /**
     * Node class for linked list.
     */
    static class ListNode {
        String val;
        ListNode next;

        ListNode(String val) {
            this.val = val;
        }
    }

    /**
     * Rotates the linked list to the right by n positions.
     *
     * @param head the head of the linked list
     * @param n    number of positions to rotate
     * @return the new head of the rotated linked list
     */
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) return head;

        // Step 1: find the length and last node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: connect tail to head to make it circular
        tail.next = head;

        // Step 3: find new tail: (length - n % length - 1)th node
        int stepsToNewTail = length - n % length - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 4: new head is next of newTail
        ListNode newHead = newTail.next;

        // Step 5: break the circle
        newTail.next = null;

        return newHead;
    }

    /**
     * Utility to print linked list.
     */
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Driver method to test rotation.
     */
    public static void main(String[] args) {
        // Build linked list
        ListNode head = new ListNode("ID_A01");
        head.next = new ListNode("ID_A02");
        head.next.next = new ListNode("ID_A03");
        head.next.next.next = new ListNode("ID_A04");
        head.next.next.next.next = new ListNode("ID_A05");
        head.next.next.next.next.next = new ListNode("ID_A06");

        System.out.print("Original List: ");
        printList(head);

        int n = 2;
        ListNode rotated = rotateRight(head, n);

        System.out.print("Rotated List: ");
        printList(rotated);
        // Expected: ID_A05 -> ID_A06 -> ID_A01 -> ID_A02 -> ID_A03 -> ID_A04
    }
}
