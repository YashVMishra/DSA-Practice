//https://leetcode.com/problems/add-two-numbers/description/

public class Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next.next = new ListNode(9);

        ListNode head = addTwoNumbers(head1, head2);
        display(head);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str1 = "";
        String str2 = "";

        // make the number present in the l1 as a String.
        ListNode temp1 = l1;
        while (temp1 != null) {
            str1 = Integer.toString(temp1.val) + str1;
            temp1 = temp1.next;
        }

        // make the number present in the l2 as a String.
        ListNode temp2 = l2;
        while (temp2 != null) {
            str2 = Integer.toString(temp2.val) + str2;
            temp2 = temp2.next;
        }

        int diff_len = Math.abs(str1.length() - str2.length());

        // make botht he string of same length by adding 0
        // in the smaller string.
        if (str2.length() > str1.length()) {
            for (int i = 0; i < diff_len; i++) {
                str1 = "0" + str1;
            }
        }

        else {
            for (int i = 0; i < diff_len; i++) {
                str2 = "0" + str2;
            }
        }

        // ans carries the sum of the two numbers.
        String ans = "";
        int carry = 0;

        // perform the nomral addition of two numbers.
        // and store the ans in ans var.
        for (int i = str1.length() - 1; i >= 0; i--) {
            int num1 = str1.charAt(i) - '0';
            int num2 = str2.charAt(i) - '0';

            int sum = num1 + num2 + carry;

            carry = sum / 10;
            ans = Integer.toString(sum % 10) + ans;
        }

        // imp as if the carry is greater than 0 then add it to the ans.
        // in the loop the last carry is left out.
        if (carry != 0) {
            ans = Integer.toString(carry) + ans;
        }

        // simple just make a dummy node and make the LL
        // from the given ans.
        ListNode head = new ListNode(0);
        ListNode temp = head;

        for (int i = ans.length() - 1; i >= 0; i--) {
            temp.next = new ListNode(ans.charAt(i) - '0');
            temp = temp.next;
        }

        return head.next;

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
