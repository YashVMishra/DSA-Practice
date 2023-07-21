// https://practice.geeksforgeeks.org/problems/special-stack/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// just simple implementation problem 
// remember the edge cases like pop if the stack is empty.

import java.util.Stack;

class GfG {
    Stack<Integer> min;

    public GfG() {
        min = new Stack<>();
    }

    public void push(int a, Stack<Integer> s) {
        // add code here.
        if (s.isEmpty()) {
            s.push(a);
            min.push(a);
            return;
        }

        s.push(a);
        int value = min.pop();
        min.push(value);
        if (a > value) {
            min.push(value);
        } else {
            min.push(a);
        }
    }

    public int pop(Stack<Integer> s) {
        // add code here.
        if (s.isEmpty()) {
            return -1;
        }

        min.pop();
        return s.pop();
    }

    public int min(Stack<Integer> s) {
        // add code here.
        if (s.isEmpty()) {
            return -1;
        }

        int value = min.pop();
        min.push(value);
        return value;
    }

    public boolean isFull(Stack<Integer> s, int n) {
        // add code here.
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        // add code here.
        return s.size() == 0 ? true : false;
    }
}

public class Special_Stack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        GfG ob = new GfG();
        ob.push(2, s);
        ob.push(3, s);

        System.out.println(ob.pop(s));
        System.out.println(ob.min(s));

        ob.push(1, s);

        System.out.println(ob.min(s));
    }

}
