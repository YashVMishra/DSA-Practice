//https://leetcode.com/problems/palindrome-linked-list/description/

import java.util.ArrayList;

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

public class Palindrome_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int[] arr = { 1, 2, 2, 1 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        System.out.println(isPalindrome(dummy.next));
        System.out.println(isPalindrome_2(dummy.next));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome_2(ListNode head) {
        // find the middle of linked-list and reverse second half

        ListNode middle = middle(head);
        ListNode revHead = reverse(middle);
        ListNode temp1 = head;
        ListNode temp2 = revHead;

        while (temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public static ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }
}
