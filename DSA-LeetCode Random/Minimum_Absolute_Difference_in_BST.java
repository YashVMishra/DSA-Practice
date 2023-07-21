//https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
// Same ques as Min_Distance_Two_Nodes- Leetcode 783

import java.util.ArrayList;
import java.util.Collections;

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

public class Minimum_Absolute_Difference_in_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        // root.right.left = new TreeNode(12);
        // root.right.right = new TreeNode(49);

        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        Collections.sort(list);

        int minDiff = Integer.MAX_VALUE;

        for (int i = list.size() - 1; i > 0; i--) {
            int currDiff = list.get(i) - list.get(i - 1);
            minDiff = Math.min(minDiff, currDiff);
        }

        return minDiff;
    }

    public static void inorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        inorderTraversal(root.left, list);
        inorderTraversal(root.right, list);
    }
}
