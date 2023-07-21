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

        // create new deep copy for every node and join then alternatively.
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = temp.next.next;
        }

        // update the random pointers.
        temp = head;
        while (temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        temp = head;
        Node dummy = new Node(0);
        Node dummy_head = dummy;

        // now separate deep copy and the original copy.
        while (temp != null) {
            Node front = temp.next.next;
            dummy_head.next = temp.next;
            temp.next = front;
            temp = temp.next;
            dummy_head = dummy_head.next;
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
