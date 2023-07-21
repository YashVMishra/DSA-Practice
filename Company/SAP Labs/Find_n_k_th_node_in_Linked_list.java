// https://practice.geeksforgeeks.org/problems/find-nk-th-node-in-linked-list/1?page=2&company[]=SAP%20Labs&sortBy=submissions

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Find_n_k_th_node_in_Linked_list {
    public static void main(String[] args) {
        Node dummy = new Node(0);
        Node head = dummy;
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        for (int i : arr) {
            head.next = new Node(i);
            head = head.next;
        }

        System.out.println(nknode(dummy.next, 2));
    }

    public static int nknode(Node head, int k) {
        // add your code here
        int length = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        temp = head;
        double target = Math.ceil((double) (length) / (double) (k));
        for (int i = 1; i < (int) (target); i++) {
            temp = temp.next;
        }

        return temp.data;
    }
}
