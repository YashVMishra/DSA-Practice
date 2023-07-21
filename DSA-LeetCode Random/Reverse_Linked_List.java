//https://leetcode.com/problems/reverse-linked-list/?envType=study-plan&id=level-1

public class Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(11);

        ListNode ans = reverseList(l1);
        display(ans);
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
