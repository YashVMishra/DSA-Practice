//https://leetcode.com/problems/min-stack/description/

class MinStack {
    int[] stack = new int[10000];
    int[] min = new int[10000];

    int topPtr;
    int minPtr;

    public MinStack() {
        topPtr = -1;
        minPtr = -1;
    }

    public void push(int val) {
        if (topPtr >= 10000) {
            return;
        }

        stack[++topPtr] = val;

        if (minPtr >= 0) {
            if (min[minPtr] > val) {
                min[++minPtr] = val;
            }

            else {
                min[minPtr + 1] = min[minPtr];
                minPtr += 1;
            }
        }

        else {

            min[++minPtr] = val;
        }
    }

    public void pop() {
        topPtr--;
        minPtr--;
    }

    public int top() {
        return stack[topPtr];
    }

    public int getMin() {
        return min[minPtr];
    }
}

public class Min_Stack {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(9);
        obj.push(10);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(-1);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

        System.out.println(param_3);
        System.out.println(param_4);
    }

}
