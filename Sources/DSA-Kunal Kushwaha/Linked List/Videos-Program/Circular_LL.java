
public class Circular_LL {

    Node head;
    Node tail;
    int size;

    public Circular_LL() {
        this.size = 0;
    }

    // method to insert before head
    public void insertFirst(int val) {
        Node node = new Node(val);

        // first node.
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        node.next = head;
        head = node;
    }

    // method to insert after tail.
    public void insertLast(int val) {

        if (head == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);

        node.next = head;
        tail.next = node;
        tail = node;
    }

    // method to delete
    public void delete(int val) {
        if (head != null) {
            if (head.value == val && head == tail) {
                head = tail = null;
            }

            else if (head.value == val) {
                tail.next = head.next;
                head = head.next;
            }

            else {
                Node temp = head;

                while (temp != tail) {
                    if (temp.next.value == val) {
                        temp.next = temp.next.next;
                        return;
                    }

                    else {
                        temp = temp.next;
                    }
                }
            }
        }
    }

    // method to display
    public void display() {
        if (head == null) {
            System.out.println("EMPTY");
            return;
        }

        Node temp = head;

        while (temp != tail) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }

        System.out.print(temp.value + " -> ");
        System.out.println("END");
    }

    // Node class.
    private class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
        }

    }
}
