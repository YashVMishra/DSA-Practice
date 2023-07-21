//https://leetcode.com/problems/design-browser-history/description/

import java.util.Stack;

class BrowserHistory {
    private Stack<String> history, future;
    private String current;

    public BrowserHistory(String homepage) {
        history = new Stack<String>();
        future = new Stack<String>();
        // 'homepage' is the first visited URL.
        current = homepage;
    }

    public void visit(String url) {
        // Push 'current' in 'history' stack and mark 'url' as 'current'.
        history.push(current);
        current = url;
        // We need to delete all entries from 'future' stack.
        future = new Stack<String>();
    }

    public String back(int steps) {
        // Pop elements from 'history' stack, and push elements in 'future' stack.
        while (steps > 0 && !history.empty()) {
            future.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        // Pop elements from 'future' stack, and push elements in 'history' stack.
        while (steps > 0 && !future.empty()) {
            history.push(current);
            current = future.pop();
            steps--;
        }
        return current;
    }
}

public class Browser_History {
    public static void main(String[] args) {
        BrowserHistory obj = new BrowserHistory("leetcode.com");
        obj.visit("google.com");
        obj.visit("linkedin.com");
        obj.visit("youtube.com");
        obj.visit("facebook.com");
        String param_2 = obj.back(1);
        String param_3 = obj.forward(1);
        String param_4 = obj.back(1);

        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}
