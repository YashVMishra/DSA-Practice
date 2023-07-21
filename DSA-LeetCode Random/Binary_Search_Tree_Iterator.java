//https://leetcode.com/problems/binary-search-tree-iterator/description/?envType=study-plan&id=level-2

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Binary_Search_Tree_Iterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator_2 it = new BSTIterator_2(root);
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}

class BSTIterator {
    ArrayList<Integer> list = new ArrayList<>();
    int index;

    public BSTIterator(TreeNode root) {
        inOrder(root, list);
        index = -1;
    }

    public int next() {
        index++;
        return list.get(index);
    }

    public boolean hasNext() {
        return !(index + 1 == list.size());
    }

    public void inOrder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}

class BSTIterator_2 {
    Stack<TreeNode> order = new Stack<>();

    public BSTIterator_2(TreeNode root) {
        partialInOrder(root);
    }

    public void partialInOrder(TreeNode root) {
        while (root != null) {
            order.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = order.pop();
        partialInOrder(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !(order.isEmpty());
    }
}
