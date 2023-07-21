
public class LL {

    private Node head;
    private Node tail;
    public int size;

    public LL() {
        this.size = 0;
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

    // insert at the last position.
    public void inserFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    // insert at the last position.
    public void inserLast(int val) {

        if (tail == null) {
            inserFirst(val);
            return;
        }

        Node node = new Node(val);

        tail.next = node;
        tail = node;

        size++;
    }

    // insert at any index.
    public void insert(int value, int index) {
        if (index == 0) {
            inserFirst(value);
            return;
        }

        if (index == size) {
            inserLast(value);
            return;
        }

        Node temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
    }

    // insertion using recursion
    public void insertRec(int val, int index) {
        head = insert_rec(val, index, head);
    }

    // helper method to aid the above function.
    private Node insert_rec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insert_rec(val, index - 1, node.next);
        return node;
    }

    // delete from the start.
    public int deleteFirst() {

        int val = head.value;
        head = head.next;

        // if LL has only one element.
        if (head == null) {
            tail = null;
        }

        size--;

        return val;
    }

    // delete from the last.
    public int deleteLast() {

        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = getNode(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;

        size--;

        return val;
    }

    // delete from any index.
    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }

        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = getNode(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;

        size--;

        return val;

    }

    // gives the node present at the passed index.
    public Node getNode(int index) {

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    // method to find the node whose value is passed.
    public Node getNodeFromValue(int value) {
        Node temp = head;

        if (value == tail.value) {
            return tail;
        }

        for (int i = 0; i < size; i++) {
            if (temp.value == value) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    // Node class.
    private class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node next) {
            this.value = val;
            this.next = next;
        }
    }

}