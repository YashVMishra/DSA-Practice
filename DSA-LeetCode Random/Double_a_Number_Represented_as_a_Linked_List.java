// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/?envType=daily-question&envId=2024-05-07

import java.util.ArrayList;
import java.util.List;

public class Double_a_Number_Represented_as_a_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        // head.next.next.next = new ListNode(3);
        // head.next.next.next.next = new ListNode(8);

        ListNode newHead = doubleIt(head);
        display(newHead);
    }

    // using extra space.
    public static ListNode doubleIt(ListNode head) {
        List<Integer> numbers = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            numbers.add(temp.val);
            temp = temp.next;
        }

        int carry = 0;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int num = numbers.get(i);
            int sum = num * 2 + carry;
            numbers.set(i, sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            numbers.add(0, carry);
        }

        ListNode newHead = new ListNode();
        ListNode dummy = newHead;
        for (int num : numbers) {
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return newHead.next;
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
