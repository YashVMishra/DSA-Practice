//https://leetcode.com/problems/sort-list/description/

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

public class Sort_Lists {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(3);

        display(sortList(head));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // head forms the starting node of the left side.
        // temp forms the ending node of left side.
        // slow form the starting node of right side.
        // fast forms the ending node of right side.
        temp.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }

            else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        curr.next = l1 != null ? l1 : l2;

        return dummy.next;
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
