//https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1?page=1&company[]=SAP%20Labs&sortBy=submissions

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Reverse_a_linked_list {
    public static void main(String[] args) {
        Node dummy = new Node(0);
        Node head = dummy;
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        for (int i : arr) {
            head.next = new Node(i);
            head = head.next;
        }

        display(reverseList(dummy.next));
    }

    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node previous = null;

        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }

    // display function.
    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
