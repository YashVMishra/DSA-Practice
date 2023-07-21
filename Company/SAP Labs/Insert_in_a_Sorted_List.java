// https://practice.geeksforgeeks.org/problems/insert-in-a-sorted-list/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// first check for the first node - if the key is less than the head node then make a new node 
// of key and attach the head to its next.

// Else keep a variable prev that will keep the record for previous node less than the key, as 
// soon as you find the node with the data greater than then key then break and come out of the loop.

// Now make a new node with the key and make a node of prev.next as we need this.
// Now make the prev.next = newNode and newNode.next = nextNode.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Insert_in_a_Sorted_List {
    public static void main(String[] args) {
        Node dummy = new Node(0);
        Node head = dummy;
        int[] arr = { 1, 2, 3, 5, 6 };

        for (int i : arr) {
            head.next = new Node(i);
            head = head.next;
        }

        display(sortedInsert(dummy.next, 0));
    }

    public static Node sortedInsert(Node head1, int key) {
        // Add your code here.
        if (key <= head1.data) {
            Node newNode = new Node(key);
            newNode.next = head1;
            return newNode;
        }

        Node prev = null;
        Node temp = head1;

        while (temp != null) {
            if (temp.data >= key) {
                break;
            }

            prev = temp;
            temp = temp.next;
        }

        Node newNode = new Node(key);
        Node nextNode = prev.next;
        prev.next = newNode;
        newNode.next = nextNode;

        return head1;
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
