public class Doubly_LL {
    Node head;
    int size;

    public Doubly_LL() {
        this.size = 0;
    }

    // method to insert node in the beginning.
    public void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        node.prev = null;

        // if the node is the first node.
        if (head != null) {
            head.prev = node;
        }

        head = node;

        size++;
    }

    // method to insert node at the last.
    public void insertLast(int val) {

        // if the node is the first node.
        if (head == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);

        Node temp = head;
        Node last = null;

        while (temp != null) {
            last = temp;
            temp = temp.next;
        }

        node.next = null;
        node.prev = last;
        last.next = node;

        size++;
    }

    // method to insert at the particular index.
    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }

        if (index == size) {
            insertLast(val);
            return;
        }

        Node node = new Node(val);
        Node curr = getNode(index);

        node.prev = curr.prev;
        curr.prev.next = node;
        curr.prev = node;
        node.next = curr;

        size++;

    }

    // used to display the LL.
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }

    // used to display the LL backwards..
    public void displayReverse() {
        Node temp = head;
        Node last = null;

        // done to make last point to the last node.
        while (temp != null) {
            last = temp;
            temp = temp.next;
        }

        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.prev;
        }

        System.out.println("START");
    }

    // gives the node present at the passed index.
    public Node getNode(int index) {

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // Node class.
    private class Node {
        int value;
        Node next;
        Node prev;

        public Node(int val) {
            this.value = val;
        }

    }
}
