// https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1?page=1&company[]=SAP%20Labs&sortBy=submissions

// for reference read the editorial section of the problem.

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

class MyStack {
    StackNode top;

    // Function to push an integer into the stack.
    void push(int a) {
        // Add your code here
        StackNode newNode = new StackNode(a);

        if (top == null) {
            top = newNode;
        } else {
            StackNode temp = top;
            top = newNode;
            newNode.next = temp;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if (top == null) {
            return -1;
        } else {
            StackNode temp = top;
            top = top.next;
            return temp.data;
        }
    }
}

public class Implement_Stack_using_Linked_List {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        System.out.println(s.pop());
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
