//https://leetcode.com/problems/add-two-numbers/description/

public class Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode dummy1 = new ListNode(0);
        ListNode head1 = dummy1;
        int[] arr1 = { 2, 4, 3 };

        for (int i : arr1) {
            head1.next = new ListNode(i);
            head1 = head1.next;
        }

        ListNode dummy2 = new ListNode(0);
        ListNode head2 = dummy2;
        int[] arr2 = { 5, 6, 4 };

        for (int i : arr2) {
            head2.next = new ListNode(i);
            head2 = head2.next;
        }

        display(addTwoNumbers(dummy1.next, dummy2.next));
    }

    // first convert the two LL into numbers using Strings
    // since they are given in reverse order so form the numbers in
    // correct order.

    // Then make the length of both the numbers as equal.
    // Now perform the addition of both the Strings using the
    // simple adding technique.

    // Atlast convert the answer into LL in reverse order.
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        String str1 = "";
        String str2 = "";

        while (temp1 != null) {
            str1 = Integer.toString(temp1.val) + str1;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            str2 = Integer.toString(temp2.val) + str2;
            temp2 = temp2.next;
        }

        int diffLen = Math.abs(str1.length() - str2.length());

        if (str1.length() > str2.length()) {
            for (int i = 0; i < diffLen; i++) {
                str2 = "0" + str2;
            }
        } else {
            for (int i = 0; i < diffLen; i++) {
                str1 = "0" + str1;
            }
        }

        String ans = "";
        int carry = 0;

        for (int i = str1.length() - 1; i >= 0; i--) {
            int num1 = str1.charAt(i) - '0';
            int num2 = str2.charAt(i) - '0';

            int sum = carry + num1 + num2;
            carry = sum / 10;

            ans = sum % 10 + ans;
        }

        if (carry != 0) {
            ans = carry + ans;
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        for (int i = ans.length() - 1; i >= 0; i--) {
            head.next = new ListNode(ans.charAt(i) - '0');
            head = head.next;
        }

        return dummy.next;
    }

    // display function
    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
