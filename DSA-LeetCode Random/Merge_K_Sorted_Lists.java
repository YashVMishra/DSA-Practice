//https://leetcode.com/problems/merge-k-sorted-lists/description/

import java.util.ArrayList;
import java.util.Collections;

public class Merge_K_Sorted_Lists {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        ListNode head2 = new ListNode(99);
        head2.next = new ListNode(100);
        head2.next.next = new ListNode(101);
        head2.next.next.next = new ListNode(102);

        ListNode head3 = new ListNode(77);
        head3.next = new ListNode(78);
        head3.next.next = new ListNode(79);
        head3.next.next.next = new ListNode(80);

        ListNode[] lists = { head1, head2, head3 };

        ListNode head = mergeKLists_3(lists);
        display(head);
    }

    // uses extra space.
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();

        ListNode head = new ListNode(0);
        ListNode temp = head;

        for (ListNode l : lists) {
            while (l != null) {
                list.add(l.val);
                l = l.next;
            }
        }

        Collections.sort(list);

        for (int value : list) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }

        return head.next;
    }

    // no extra space.
    public static ListNode mergeKLists_2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (true) {
            int p = 0;

            for (int i = 0; i < lists.length; i++) {
                if (lists[p] == null || (lists[i] != null && lists[p].val > lists[i].val)) {
                    p = i;
                }
            }

            if (lists[p] == null) {
                break;
            }

            temp.next = lists[p];
            temp = temp.next;
            lists[p] = lists[p].next;
        }

        return head.next;
    }

    // uses the mergeTwoLists function to break the program.
    public static ListNode mergeKLists_3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }

            interval = interval * 2;
        }

        return lists[0];
    }

    // func to merge two sorted lists in mergeKLists_3 function.
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
