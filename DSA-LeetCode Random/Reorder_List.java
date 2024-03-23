// https://leetcode.com/problems/reorder-list/description/?envType=daily-question&envId=2024-03-23

public class Reorder_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHalf = reverseList(slow);
        ListNode curr = head;

        while (revHalf.next != null) {
            ListNode tempFront = curr.next;
            curr.next = revHalf;

            ListNode tempBack = revHalf.next;
            revHalf.next = tempFront;

            revHalf = tempBack;
            curr = tempFront;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}