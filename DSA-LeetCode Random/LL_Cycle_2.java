//https://leetcode.com/problems/linked-list-cycle-ii/description/

import java.util.Set;
import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LL_Cycle_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        ListNode ans = detectCycle(head);
        System.out.println(ans.val);

        ListNode temp = detectCycle_2(head);
        System.out.println(temp.val);
    }

    // uses O(n) TC but extra space.
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }

            set.add(temp);
            temp = temp.next;
        }

        return null;
    }

    // uses O(n) TC but with constant space.
    // extension of the Linked List Cycle problem.
    public static ListNode detectCycle_2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                ListNode temp = head;

                while (temp != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }

                return temp;
            }
        }

        return null;
    }
}
