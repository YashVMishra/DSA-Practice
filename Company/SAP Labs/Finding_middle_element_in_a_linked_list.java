//https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1?page=1&company[]=SAP%20Labs&sortBy=submissions

public class Finding_middle_element_in_a_linked_list {
    public static void main(String[] args) {
        Node dummy = new Node(0);
        Node head = dummy;
        int[] arr = { 1, 2, 3, 4, 5, 6 };

        for (int i : arr) {
            head.next = new Node(i);
            head = head.next;
        }

        System.out.println(getMiddle(dummy.next));
    }

    public static int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

}