// https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06

import java.util.Stack;

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

public class Remove_Nodes_From_Linked_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        ListNode newHead = removeNodes(head);
        display(newHead);
    }

    // using stack.
    public static ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode current = head;

        while (current != null) {
            st.push(current);
            current = current.next;
        }

        current = st.pop();
        int maximum = current.val;
        ListNode resultHead = new ListNode(maximum);

        while (!st.empty()) {
            current = st.pop();
            if (current.val < maximum) {
                continue;
            } else {
                ListNode newNode = new ListNode(current.val);
                newNode.next = resultHead;
                resultHead = newNode;
                maximum = current.val;
            }
        }

        return resultHead;
    }

    // -----------------------------------------------------------------------------------

    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
