//https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/?envType=study-plan&id=level-1

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class N_ary_Tree_Preorder_Traversal {
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node curr = stack.pop();
            list.add(curr.val);

            // Pushing in children in reverse order
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }

        return list;
    }

    public static List<Integer> preorder_rec(Node root) {
        preorderHelper(root);
        return list;
    }

    // recursice solution.
    public static void preorderHelper(Node root) {
        if (root == null) {
            return;
        }

        list.add(root.val);

        for (Node temp : root.children) {
            preorderHelper(temp);
        }
    }

}
