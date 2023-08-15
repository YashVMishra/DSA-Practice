// https://leetcode.com/problems/partition-list/description/

import java.util.ArrayList;
import java.util.Arrays;

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

public class Partition_List {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 1));
        ListNode head = buildLLfromList(list);
        ListNode ans = partition(head, 2);
        display(ans);
    }

    public static ListNode partition(ListNode head, int x) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();

        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                less.add(temp.val);
            } else {
                greater.add(temp.val);
            }

            temp = temp.next;
        }

        less.addAll(greater);
        return buildLLfromList(less);
    }

    public static ListNode buildLLfromList(ArrayList<Integer> less) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        for (int i : less) {
            head.next = new ListNode(i);
            head = head.next;
        }

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
