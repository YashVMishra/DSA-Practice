//https://leetcode.com/problems/palindrome-linked-list/description/

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

public class Palindromic_LL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;

        // calculating the size for the array.
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];

        temp = head;

        // initialising the array.
        int index = 0;
        while (temp != null) {
            arr[index] = temp.val;
            temp = temp.next;
            index++;
        }

        // checking for palindrome.
        for (int i = 0; i < size / 2; i++) {
            if (arr[i] != arr[size - 1 - i]) {
                return false;
            }
        }

        return true;

    }
}
