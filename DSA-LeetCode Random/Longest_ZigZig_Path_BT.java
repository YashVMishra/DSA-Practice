//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/

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

public class Longest_ZigZig_Path_BT {
    public static int maxLength = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        System.out.println(longestZigZag(root));
    }

    public static void solve(TreeNode root, int dir, int currLength) {
        if (root == null) {
            return;
        }

        maxLength = Math.max(maxLength, currLength);

        if (dir == 1) {
            solve(root.left, 0, currLength + 1);
            solve(root.right, 1, 1);
        }

        else {
            solve(root.right, 1, currLength + 1);
            solve(root.left, 0, 1);
        }
    }

    public static int longestZigZag(TreeNode root) {

        solve(root, 0, 0);
        solve(root, 1, 0);
        return maxLength;
    }
}
