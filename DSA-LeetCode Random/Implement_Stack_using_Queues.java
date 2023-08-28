// https://leetcode.com/problems/implement-stack-using-queues/description/

import java.util.LinkedList;
import java.util.Queue;

// using twp queues.
class MyStack_1 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack_1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add((x));

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // emptying q2 into q1.
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

// using single queue.
class MyStack_2 {
    Queue<Integer> q;

    public MyStack_2() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add((x));

        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

public class Implement_Stack_using_Queues {
    public static void main(String[] args) {
        MyStack_1 ob1 = new MyStack_1();
        ob1.push(1);
        ob1.push(2);
        System.out.println(ob1.top());
        System.out.println(ob1.pop());
        System.out.println(ob1.empty());

        MyStack_2 ob2 = new MyStack_2();
        ob2.push(1);
        ob2.push(2);
        System.out.println(ob2.top());
        System.out.println(ob2.pop());
        System.out.println(ob2.empty());
    }
}
