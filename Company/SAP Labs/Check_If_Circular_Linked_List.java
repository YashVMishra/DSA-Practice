//https://practice.geeksforgeeks.org/problems/circular-linked-list/1?page=1&company[]=SAP%20Labs&sortBy=submissions

public class Check_If_Circular_Linked_List {
    public static void main(String[] args) {
        Node dummy = new Node(0);
        Node head = dummy;
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        for (int i : arr) {
            head.next = new Node(i);
            head = head.next;
        }

        // making the LL circular by making the next of the last node
        // pointing to head of the LL.
        head.next = dummy.next;
        System.out.println(isCircular(dummy.next));
    }

    public static boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }

        Node temp = head;

        while (temp != null) {
            temp = temp.next;

            // write temp = temp.next first as we have to run the while loop
            // atleast once or you can use the do-while loop.
            if (temp == head) {
                return true; // circular linked list found, hence returning True.
            }
        }

        return false;
    }
}
