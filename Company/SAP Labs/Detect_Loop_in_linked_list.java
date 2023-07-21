//https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1?page=1&company[]=SAP%20Labs&sortBy=submissions

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Detect_Loop_in_linked_list {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head.next;

        System.out.println(detectLoop(head));
    }

    public static boolean detectLoop(Node head) {
        // Add code here
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
