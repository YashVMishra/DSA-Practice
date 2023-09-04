// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Maximum_Twin_Sum_of_a_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int[] head = { 1, 100000 };

        for (int i = 0; i < head.length; i++) {
            temp.next = new ListNode(head[i]);
            temp = temp.next;
        }

        System.out.println(pairSum(dummy.next));
        System.out.println(pairSum_2(dummy.next));
    }

    // uses extra space.
    public static int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int maxVal = 0;
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            maxVal = Math.max(maxVal, list.get(left) + list.get(right));
            left++;
            right--;
        }

        return maxVal;
    }

    // ------------------------------------------------------------------------------------------

    public static int pairSum_2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode revHead = reverse(slow);
        ListNode temp = head;
        int maxVal = 0;

        while (temp != null && revHead != null) {
            maxVal = Math.max(maxVal, temp.val + revHead.val);
            temp = temp.next;
            revHead = revHead.next;
        }

        return maxVal;
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
