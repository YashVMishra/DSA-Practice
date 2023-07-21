//https://leetcode.com/problems/subtree-of-another-tree/description/

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

public class Subtree_Of_Another_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        TreeNode subRoot = new TreeNode(2);
        subRoot.left = new TreeNode(3);
        subRoot.right = new TreeNode(4);

        System.out.println(isSubtree(root, subRoot));
    }

    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
        }

        return false;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (root.val == subRoot.val) {
            return isIdentical(root, subRoot);
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
