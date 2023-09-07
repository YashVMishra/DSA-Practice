// https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=daily-question&envId=2023-09-07

import java.util.ArrayList;

public class Reverse_Linked_List_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);

        display(reverseBetween(head, 1, 2));
        display(reverseBetween_2(head, 1, 2));
    }

    // uses extra space.
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        // adding value to the list.
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        // reversing the elements in the list from left to right.
        while (left < right) {
            int element = list.get(left - 1);
            list.set(left - 1, list.get(right - 1));
            list.set(right - 1, element);
            left++;
            right--;
        }

        // creating the new LL from the list.
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;

        for (int i : list) {
            newHead.next = new ListNode(i);
            newHead = newHead.next;
        }

        return dummy.next;
    }

    public static ListNode reverseBetween_2(ListNode head, int left, int right) {

        // if left and right are equal then no need to reverse the list.
        if (left == right) {
            return head;
        }

        // prev refers to the node that is just before the left node.
        ListNode prev = head;

        // next refers to the node that is just after the right node.
        ListNode next = null;

        // first refers to the left node.
        ListNode first = head;

        // last refers to the right node.
        ListNode last = null;
        ListNode temp = head;
        int count = 0;

        // setting all the values of the prev, next, first and last.
        while (temp != null) {
            count++;

            if (count == left - 1) {
                prev = temp;
            }

            if (count == left) {
                first = temp;
            }

            if (count == right) {
                last = temp;
            }

            if (count == right + 1) {
                next = temp;
            }

            temp = temp.next;
        }

        // checking for the edge cases that related to reversing the whole list.
        if (left - 1 == 0 && right == count) {
            return reverse(head);
        }

        // converting the last node next value to null.
        // else it will reverse the whole list starting from the first node.
        // not the first node of the LL but the variable first.
        last.next = null;
        ListNode newHead = reverse(first);

        // if left - 1 is 0 then prev will be the head of the LL
        // else prev will be the node just before the left node.
        // so we have to make the prev.next to the newHead.
        if (left - 1 == 0) {
            head = newHead;
        } else {
            prev.next = newHead;
        }

        // reching the last node of the newHead.
        // we want the last node of the newHead as we have to connect it to the next.
        // thats why newHead.next != null.
        while (newHead.next != null) {
            newHead = newHead.next;
        }

        // connecting the list.
        newHead.next = next;

        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
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
