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

public class Middle_LL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(middleNode_2(head).val);

    }

    // calculate the length of the LL and then run the loop length/2 times
    public static ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        temp = head;

        for (int i = 0; i < length / 2; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // using fast and slow pointer method.
    public static ListNode middleNode_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}