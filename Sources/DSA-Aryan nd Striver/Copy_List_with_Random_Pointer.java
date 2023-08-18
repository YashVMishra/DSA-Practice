// https://leetcode.com/problems/copy-list-with-random-pointer/description/

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Copy_List_with_Random_Pointer {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node newHead_1 = copyRandomList(head);
        Node newHead_2 = copyRandomList_2(head);
        display(newHead_1);
        display(newHead_2);
    }

    // using extra space.
    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        Node dummy = new Node(0);
        Node newHead = dummy;

        while (temp != null) {
            newHead.next = new Node(temp.val);

            // you have put newHead.next as we are copying the node in the newHead.next
            // node and not newHead node.
            map.put(temp, newHead.next);
            temp = temp.next;
            newHead = newHead.next;
        }

        temp = head;
        newHead = dummy.next;

        while (temp != null) {
            newHead.random = map.get(temp.random);
            temp = temp.next;
            newHead = newHead.next;
        }

        return dummy.next;
    }

    // using constant space.
    public static Node copyRandomList_2(Node head) {
        Node temp = head;

        // adding new nodes in between the original nodes.
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // setting random pointers of the new nodes.
        temp = head;
        while (temp != null) {

            // we are using if-else because temp.random can be null and we are
            // accessing temp.random.next which will give null pointer exception.
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        // separating the original and new nodes.
        temp = head;
        Node dummy = new Node(0);
        Node newHead = dummy;

        while (temp != null) {
            newHead.next = temp.next;
            temp.next = temp.next.next;
            temp = temp.next;
            newHead = newHead.next;
        }

        return dummy.next;
    }

    // display function.
    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
