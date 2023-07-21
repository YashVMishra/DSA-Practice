//https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

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

public class Remove_Duplicates_Sorted_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head = deleteDuplicates(head);
        display(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            if ((temp.next != null) && (temp.val == temp.next.val)) {
                temp.next = temp.next.next;
            }

            else {
                temp = temp.next;
            }
        }

        return head;
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
