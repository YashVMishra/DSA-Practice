//https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class Min_Distance_Two_Nodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        // root.right.left = new TreeNode(12);
        // root.right.right = new TreeNode(49);

        System.out.println(minDiffInBST(root));
    }

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        dfs(root, list);

        // sorting the collections.
        Collections.sort(list);

        int min = Integer.MAX_VALUE;

        // this method works when the tree does not conatin duplicate elements
        // otherwise all the times min will be 0
        for (int i = list.size() - 1; i > 0; i--) {
            int diff = list.get(i) - list.get(i - 1);
            min = Math.min(min, diff);
        }

        return min;

    }

    // adding all the values of the tree in the list.
    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

}
