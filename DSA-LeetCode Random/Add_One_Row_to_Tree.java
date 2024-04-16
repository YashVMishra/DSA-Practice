// https://leetcode.com/problems/add-one-row-to-tree/description/?envType=daily-question&envId=2024-04-16

import java.util.LinkedList;
import java.util.Queue;

public class Add_One_Row_to_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        int val = 1;
        int depth = 2;

        TreeNode newRoot = addOneRow(root, val, depth);
        System.out.println(newRoot);
    }

    public static TreeNode add(TreeNode root, int val, int depth, int curr) {
        if (root == null)
            return null;

        if (curr == depth - 1) {
            TreeNode lTemp = root.left;
            TreeNode rTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = lTemp;
            root.right.right = rTemp;

            return root;
        }

        root.left = add(root.left, val, depth, curr + 1);
        root.right = add(root.right, val, depth, curr + 1);

        return root;
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        return add(root, val, depth, 1);
    }

    // --------------------------------------------------------------------------------

    public static TreeNode addOneRow_2(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        boolean rowAdded = false;

        while (!queue.isEmpty()) {
            int n = queue.size();
            level++;

            while (n-- > 0) {
                TreeNode curr = queue.poll();
                TreeNode tempL = curr.left;
                TreeNode tempR = curr.right;

                if (level == d - 1) {
                    curr.left = new TreeNode(v);
                    curr.right = new TreeNode(v);
                    curr.left.left = tempL;
                    curr.right.right = tempR;
                    rowAdded = true;
                }

                if (tempL != null)
                    queue.add(tempL);
                if (tempR != null)
                    queue.add(tempR);
            }

            if (rowAdded)
                break;
        }

        return root;
    }
}
