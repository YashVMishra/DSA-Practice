public class Static_Stack {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public Static_Stack(int size) {
        this.data = new int[size];
    }

    public Static_Stack() {
        this(DEFAULT_SIZE);
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is Full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot Pop form empty stack");
        }

        return data[ptr--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot Peek from Empty Stack");
        }

        return data[ptr];
    }

}