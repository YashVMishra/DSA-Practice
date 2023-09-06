// https://leetcode.com/problems/split-linked-list-in-parts/description/?envType=daily-question&envId=2023-09-06

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

public class Split_Linked_List_in_Parts {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode[] ans = splitListToParts(head, 3);

        for (ListNode node : ans) {
            display(node);
        }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        // length of each part of the array
        int eachSize = len / k;

        // length of the extra part of the array
        int extarSize = len % k;
        curr = head;
        int index = 0;

        // loop till curr is not equal to null as after that list is empty
        while (curr != null) {

            // prev is the last node of every list of each index
            ListNode prev = null;

            // temp is the head.
            ListNode temp = curr;

            // if extraSize is greater than 0 then we have to add one more node in the list
            if (extarSize > 0) {
                for (int i = 0; i < eachSize + 1; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            } else {
                for (int i = 0; i < eachSize; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            // make the prev.next null as it is the last node of the list
            prev.next = null;
            ans[index++] = temp;

            // imp line.
            extarSize--;
        }

        return ans;
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
