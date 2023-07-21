//https://leetcode.com/problems/add-two-numbers-ii/description/

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

public class Add_Two_Numbers_2 {
    public static void main(String[] args) {
        int[] arr1 = { 5 };
        int[] arr2 = { 5 };
        ListNode l1 = makeLL(arr1);
        ListNode l2 = makeLL(arr2);

        display(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str1 = "";
        String str2 = "";
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null) {
            str1 = str1 + temp1.val;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            str2 = str2 + temp2.val;
            temp2 = temp2.next;
        }

        int diff = Math.abs(str1.length() - str2.length());
        if (str1.length() > str2.length()) {
            while (diff-- > 0) {
                str2 = "0" + str2;
            }
        } else {
            while (diff-- > 0) {
                str1 = "0" + str1;
            }
        }

        String ans = "";
        int carry = 0;
        for (int i = str1.length() - 1; i >= 0; i--) {
            int nums1 = str1.charAt(i) - '0';
            int nums2 = str2.charAt(i) - '0';

            int sum = nums2 + nums1 + carry;
            System.out.println(sum);
            carry = sum / 10;
            ans = (sum % 10) + ans;
        }

        if (carry != 0) {
            ans = carry + ans;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for (int i = 0; i < ans.length(); i++) {
            head.next = new ListNode(ans.charAt(i) - '0');
            head = head.next;
        }

        return dummy.next;
    }

    // function to make LL of the given array.
    public static ListNode makeLL(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        return dummy.next;
    }

    // display functio..
    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
