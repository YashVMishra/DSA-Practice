//https://leetcode.com/problems/linked-list-cycle/description/

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LL_Cycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
        System.out.println(hasCycle_2(head));
    }

    // simple method just try to add the nodes in the Set as you pass through them
    // if at any time the node is contained in the set then there is cycle and
    // return true.
    // uses extra space.
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode temp = head;

        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }

            set.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // Approach here is that if there is a cycle in a LL then if you have two
    // pointers
    // one that jumps one node and other jumps two nodes then they are bound to meet
    // each other
    // at one point and that fact is being used here.
    public static boolean hasCycle_2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // fast.next checks for last node and
        // fast.next.next checks for the second last node.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
