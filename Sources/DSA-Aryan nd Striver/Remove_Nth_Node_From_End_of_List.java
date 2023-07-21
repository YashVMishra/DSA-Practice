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

public class Remove_Nth_Node_From_End_of_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int[] arr = { 1, 2 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        int n = 1;
        display(removeNthFromEnd(dummy.next, n));
    }

    // by finding the length variable.
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        // calculating length of the LL.
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // if the length is same as n then we have to delete
        // the first node.
        if (length == n) {
            return head.next;
        }

        // finding the node just before the deleting node.
        int jumps = length - n - 1;
        temp = head;
        for (int i = 0; i < jumps; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    // uses two pointers approach.
    public static ListNode removeNthFromEnd_2(ListNode head, int n) {

        // we have taken dummy node as there might be a case
        // that we have to delete the first node.
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
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
