//https://leetcode.com/problems/swap-nodes-in-pairs/description/

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

public class Swap_Nodes_in_Pairs {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int[] head = { 1, 2, 3 };

        for (int i = 0; i < head.length; i++) {
            temp.next = new ListNode(head[i]);
            temp = temp.next;
        }

        display(dummy.next);
        temp = swapPairs(dummy.next);
        display(temp);

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // finding length of the LL.
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // creating array of that length.
        int[] arr = new int[len];

        // filling the array with the LL elements.
        temp = head;
        int index = 0;
        while (temp != null) {
            arr[index] = temp.val;
            temp = temp.next;
            index++;
        }

        // swapping the given indices.
        for (int i = 0; i < arr.length; i = i + 2) {
            if (i + 1 < arr.length) {
                swap(arr, i, i + 1);
            }
        }

        // creating a new LL from the modified array.
        ListNode dummy = new ListNode(0);
        temp = dummy;

        for (int i = 0; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }

        return dummy.next;
    }

    // function to swap two numbers in an array.
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
