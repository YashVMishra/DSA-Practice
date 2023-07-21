//https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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

public class Remove_Nth_Node_Last {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head = removeNthFromEnd_2(head, 2);
        display(head);
    }

    // first calculate the length and find the required position
    // and then match the pointers.
    // O(2n) TC
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int pos = length - n;
        temp = head;

        // if length is 1 and n is also 1 then we have to just return null
        // a edge case.
        if (length == 1 && n == 1) {
            return null;
        }

        // if the length == n then we just have to update the head.
        if (length == n) {
            head = head.next;
        }

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // O(n) TC.
    public static ListNode removeNthFromEnd_2(ListNode head, int n) {

        // important line, we are creating a dummy node just before
        // the head.
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        // important line.
        return start.next;
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
