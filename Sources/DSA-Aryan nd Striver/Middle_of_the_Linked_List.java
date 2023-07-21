//https://leetcode.com/problems/middle-of-the-linked-list/description/

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

public class Middle_of_the_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int[] arr = { 1, 2, 3, 4, 5 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        System.out.println(middleNode(dummy.next).val);
    }

    // using the slow and fast pointer method.
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
