//https://leetcode.com/problems/copy-list-with-random-pointer/description/

import java.util.HashMap;
import java.util.Map;

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

public class Copy_List_With_Random_Pointer {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        head.next.random = null;
        head.next.next.random = head.next;

        Node temp = copyRandomList_2(head);
        display(temp);
        display_random(temp);
    }

    // uses extra space.
    public static Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        // put the node and its copy in the map.
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            map.put(temp, node);
            temp = temp.next;
        }

        temp = head;

        // just copy the same pointers as the original ones.
        while (temp != null) {
            Node deep_copy = map.get(temp);
            deep_copy.next = map.get(temp.next);
            deep_copy.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    // using constant space.
    public static Node copyRandomList_2(Node head) {

        // just make new nodes of the original list and put them in between the
        // original nodes.
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // updating the random pointers.
        temp = head;
        while (temp != null) {

            // we are using if-else because temp.random can be null and we are
            // accessing temp.random.next which will give null pointer exception.
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(0);
        Node newHead = dummy;

        // sepeare the original list from the duplicate.
        while (temp != null) {
            newHead.next = temp.next;
            temp.next = temp.next.next;
            newHead = newHead.next;
            temp = temp.next;
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

    // display function to show Random pointers.
    public static void display_random(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.random != null) {
                System.out.print(temp.random.val + " -> ");
            }

            else {
                System.out.print("Null -> ");
            }

            temp = temp.next;
        }

        System.out.println("END");
    }
}
