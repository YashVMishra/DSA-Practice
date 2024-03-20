// https://leetcode.com/problems/merge-in-between-linked-lists/description/?envType=daily-question&envId=2024-03-20

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

public class Merge_In_Between_Linked_Lists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        list1.next = new ListNode(1);
        list1.next.next = new ListNode(2);
        list1.next.next.next = new ListNode(3);
        list1.next.next.next.next = new ListNode(4);
        list1.next.next.next.next.next = new ListNode(5);
        list1.next.next.next.next.next.next = new ListNode(6);

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        list2.next.next.next = new ListNode(1000003);
        list2.next.next.next.next = new ListNode(1000004);

        int a = 2, b = 5;

        ListNode result = mergeInBetween(list1, a, b, list2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null, last = null, temp = list1;

        for (int i = 0; i < b; i++) {
            if (i == a - 1) {
                start = temp;
            }

            temp = temp.next;
        }

        last = temp.next;
        start.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = last;
        return list1;
    }
}
