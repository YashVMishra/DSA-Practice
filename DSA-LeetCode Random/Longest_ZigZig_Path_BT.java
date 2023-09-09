// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

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
    static int maxLength = 0;

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

    public static void solve(TreeNode root, int steps, boolean goLeft) {
        if (root == null) {
            return;
        }

        maxLength = Math.max(maxLength, steps);

        if (goLeft) {
            solve(root.left, steps + 1, false);
            solve(root.right, 1, true);
        } else {
            solve(root.right, steps + 1, true);
            solve(root.left, 1, false);
        }
    }

    public static int longestZigZag(TreeNode root) {
        solve(root, 0, true);
        solve(root, 0, false);
        return maxLength;
    }
}
