//https://leetcode.com/problems/delete-node-in-a-linked-list/description/

public class Delete_Node_in_a_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int[] arr = { 4, 5, 1, 9 };

        for (int i : arr) {
            head.next = new ListNode(i);
            head = head.next;
        }

        deleteNode(dummy.next.next);
        display(dummy.next);
    }

    public static void deleteNode(ListNode node) {
        int nextVal = node.next.val;
        node.val = nextVal;
        node.next = node.next.next;
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
