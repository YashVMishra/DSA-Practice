// https://leetcode.com/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Stack;

class Pair {
    int price, span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        if (stack.isEmpty()) {
            stack.push(new Pair(price, 1));
            return 1;
        }

        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }

        stack.push(new Pair(price, span));
        return span;
    }
}

public class Online_Stock_Span {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
