// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75

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

public class Delete_the_Middle_Node_of_a_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        head.next = node1;
        ListNode node2 = new ListNode(4);
        node1.next = node2;
        ListNode node3 = new ListNode(7);
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        node3.next = node4;
        ListNode node5 = new ListNode(2);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;

        display(head);
        display(deleteMiddle(head));
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
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
