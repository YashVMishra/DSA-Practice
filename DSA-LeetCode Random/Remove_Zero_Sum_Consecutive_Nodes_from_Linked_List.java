// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/?envType=daily-question&envId=2024-03-12

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(removeZeroSumSublists(head));
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        for (int i = 0; i < list.size(); i++) {
            int sum = 0;

            for (int j = i; j < list.size(); j++) {
                sum += list.get(j);

                // as you find the sum to be zero then remove the elements from i to j
                // since you remove backwards then the elements from right comes to
                // right, so dont worry about the index.
                if (sum == 0) {
                    for (int k = j; k >= i; k--) {
                        list.remove(k);
                        System.out.println(list);
                    }

                    // since as we go up, there is always i++ so we need to
                    // make i as -1.
                    i = -1;
                    break;
                }
            }
        }

        ListNode dummy = new ListNode(0);
        cur = dummy;
        for (int i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        return dummy.next;
    }
}
