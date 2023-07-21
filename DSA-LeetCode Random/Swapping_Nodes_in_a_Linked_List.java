//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/

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

public class Swapping_Nodes_in_a_Linked_List {
    public static void main(String[] args) {
        int[] head = { 7, 9, 6, 6, 7, 8, 3, 0, 9, 5 };
        ListNode dummy = new ListNode(0);
        ListNode temp_head = dummy;

        for (int i = 0; i < head.length; i++) {
            temp_head.next = new ListNode(head[i]);
            temp_head = temp_head.next;
        }

        ListNode l1 = dummy.next;
        display(l1);
        ListNode ans = swapNodes(l1, 5);
        display(ans);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;

        // calculatiing length of the LL.
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] arr = new int[len];

        // filling the array with the array elements.
        int index = 0;
        temp = head;
        while (temp != null) {
            arr[index] = temp.val;
            temp = temp.next;
            index++;
        }

        // swap the given indexes.
        swap(arr, k - 1, len - k);

        // create a dummy node to make the new LL.
        ListNode dummy = new ListNode(0);
        ListNode temp_head = dummy;

        for (int i = 0; i < len; i++) {
            temp_head.next = new ListNode(arr[i]);
            temp_head = temp_head.next;
        }

        return dummy.next;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
