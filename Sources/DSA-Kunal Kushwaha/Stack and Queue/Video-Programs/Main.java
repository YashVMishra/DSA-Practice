public class Main {
    public static void main(String[] args) throws Exception {
        // Dynamic_Stack stack = new Dynamic_Stack(5);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);
        // stack.push(5);

        // // inserting the 6th element although passing the size as 5.
        // // Dynamic Stack.
        // stack.push(6);

        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());

        // we have used Circular queue to decrease the TC of remove
        // function from O(n) to O(1).
        Dynamic_Queue q = new Dynamic_Queue(5);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);

        q.display();

        System.out.println(q.remove());
        System.out.println(q.remove());
        q.insert(77);

        q.display();

    }
}
