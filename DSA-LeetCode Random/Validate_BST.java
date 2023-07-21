//https://leetcode.com/problems/validate-binary-search-tree/description/

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

public class Validate_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(22);
        root.left = new TreeNode(19);
        root.right = new TreeNode(29);
        root.left.left = new TreeNode(18);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(27);
        root.right.right = new TreeNode(30);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // giving range to every node and checking its value.
    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) {
            return true;
        }

        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
