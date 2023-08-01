// https://leetcode.com/problems/reverse-linked-list/

// do on your own.

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        int[] arr = { 1, 2, 3, 4, 5 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        display(reverseList(dummy.next));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev; // reverse the link by pointing next to previous node
            prev = current; // move pointer one step forward in list
            current = nextNode; // move to next node.
        }

        return prev;
    }

    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
