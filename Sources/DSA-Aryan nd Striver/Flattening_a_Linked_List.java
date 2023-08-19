// https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}

public class Flattening_a_Linked_List {
    public static void main(String[] args) {
        Node l1 = new Node(5);
        l1.bottom = new Node(7);
        l1.bottom.bottom = new Node(8);
        l1.bottom.bottom.bottom = new Node(30);

        Node l2 = new Node(10);
        l2.bottom = new Node(20);

        Node l3 = new Node(19);
        l3.bottom = new Node(22);
        l3.bottom.bottom = new Node(50);

        Node l4 = new Node(28);
        l4.bottom = new Node(35);
        l4.bottom.bottom = new Node(40);
        l4.bottom.bottom.bottom = new Node(45);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Node newHead = flatten(l1);
        display(newHead);
    }

    // we keep on moving to the next LL and as soon as we reach the end of the LL
    // we start merging from the back.
    public static Node flatten(Node root) {
        // Your code here
        if (root == null || root.next == null) {
            return root;
        }

        // now move to next node.
        root.next = flatten(root.next);

        // now merge the two lists.
        root = merge(root, root.next);

        return root;
    }

    // similar to merge sort.
    public static Node merge(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;

        // using bottom pointer for merging.
        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }

        return res.bottom;
    }

    // display function.
    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.bottom;
        }

        System.out.println("END");
    }
}
