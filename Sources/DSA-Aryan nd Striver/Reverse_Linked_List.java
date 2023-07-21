//https://leetcode.com/problems/reverse-linked-list/description/

public class Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int[] arr = { 1, 2, 3, 4, 5 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        display(reverseList_2(dummy.next));
    }

    // iterative appraoch.
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev; // reverse the link by pointing next to previous node
            prev = current; // move pointer one step forward in list
            current = temp; // move to next node.
        }

        return prev;
    }

    // recursive approach
    public static ListNode reverseList_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList_2(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head; // reversing links of nodes.
        head.next = null; // removing original reference from old tail and setting ot to null.

        return newHead;
    }

    // display function.
    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}