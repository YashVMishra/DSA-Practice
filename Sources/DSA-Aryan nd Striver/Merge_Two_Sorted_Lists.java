//https://leetcode.com/problems/merge-two-sorted-lists/description/

public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode dummy1 = new ListNode(0);
        ListNode head1 = dummy1;
        int[] arr1 = { 1, 2, 4 };

        for (int i : arr1) {
            head1.next = new ListNode(i);
            head1 = head1.next;
        }

        ListNode dummy2 = new ListNode(0);
        ListNode head2 = dummy2;
        int[] arr2 = { 1, 3, 4 };

        for (int i : arr2) {
            head2.next = new ListNode(i);
            head2 = head2.next;
        }

        ListNode ans = mergeTwoLists(dummy1.next, dummy2.next);
        display(ans);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            head = head.next;
        }

        // remaining nodes of the longer LL.
        head.next = l1 != null ? l1 : l2;

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
