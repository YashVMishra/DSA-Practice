//https://leetcode.com/problems/reverse-nodes-in-k-group/description/

public class Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int[] arr = { 1, 2, 3, 4, 5 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        display(reverseKGroup(dummy.next, 2));
    }

    // to visualize this algo try working with k = 3.
    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;

        // counting the number of nodes.
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = dummy;
        while (temp.next != null) {
            if (count < k) {
                break;
            }

            int nodes = k - 1;
            ListNode tempNext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;

            while (nodes-- > 0) {
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }

            // updating the count.
            count -= k;
            temp.next = first;
            tempNext.next = second;
            temp = tempNext;
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
