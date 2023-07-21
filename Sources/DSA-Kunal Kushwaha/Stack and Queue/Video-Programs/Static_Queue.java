public class Static_Queue {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = 0;

    public Static_Queue(int size) {
        this.data = new int[size];
    }

    public Static_Queue() {
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        return ptr == data.length;
    }

    public boolean isEmpty() {
        return ptr == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }

        data[ptr++] = item;
        return true;
    }

    // Takes O(n) TC.
    // for O(1) TC check Circular_Queue.
    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        int removed = data[0];

        // shift the data left side;
        for (int i = 1; i < ptr; i++) {
            data[i - 1] = data[i];
        }

        ptr--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        return data[0];
    }

    public void display() {

        for (int i = 0; i < ptr; i++) {
            System.out.print(data[i] + " <- ");
        }

        System.out.println("END");
    }
}
