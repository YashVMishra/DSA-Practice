// https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1?page=1&company[]=SAP%20Labs&sortBy=submissions

// use two stacks one for simple push and pop called main and then another stack min
// that keep records of the min till the element in the main stack.
// for refernce read the article.
// https://www.cdn.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

import java.util.Stack;

class GfG {
    int minEle;
    Stack<Integer> main;
    Stack<Integer> min;

    // Constructor
    GfG() {
        main = new Stack<>();
        min = new Stack<>();
    }

    /* returns min element from stack */
    int getMin() {
        // Your code here
        if (main.isEmpty()) {
            return -1;
        }

        int value = min.pop();
        min.push(value);
        return value;
    }

    /* returns poped element from stack */
    int pop() {
        // Your code here
        if (main.isEmpty()) {
            return -1;
        }

        min.pop();
        return main.pop();
    }

    /* push element x into the stack */
    void push(int x) {
        // Your code here
        if (main.isEmpty()) {
            main.push(x);
            min.push(x);
        } else {
            main.push(x);
            int value = min.pop();
            min.push(value);

            if (x > value) {
                min.push(value);
            } else {
                min.push(x);
            }
        }
    }
}

public class Get_minimum_element_from_stack {
    public static void main(String[] args) {
        GfG ob = new GfG();
        ob.push(2);
        ob.push(3);

        System.out.println(ob.pop());
        System.out.println(ob.getMin());

        ob.push(1);

        System.out.println(ob.getMin());
    }
}
