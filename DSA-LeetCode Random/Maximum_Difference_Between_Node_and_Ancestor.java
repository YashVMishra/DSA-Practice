// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/?envType=daily-question&envId=2024-01-11

public class Maximum_Difference_Between_Node_and_Ancestor {
    static int maxDiff;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        System.out.println(maxAncestorDiff_2(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        maxDiff = Integer.MIN_VALUE;
        findMaxDiff(root);
        return maxDiff;
    }

    private static void findMaxUtil(TreeNode root, TreeNode child) {
        if (root == null || child == null) {
            return;
        }

        maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

        findMaxUtil(root, child.left);
        findMaxUtil(root, child.right);
    }

    private static void findMaxDiff(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        // Find max differences of this root with all its children
        findMaxUtil(root, root.left);
        findMaxUtil(root, root.right);

        // Further move left and right
        findMaxDiff(root.left);
        findMaxDiff(root.right);
    }

    // ------------------- Another Solution -------------------

    public static int maxAncestorDiff_2(TreeNode root) {
        int minV = root.val;
        int maxV = root.val;

        return findMaxDiff(root, minV, maxV);
    }

    public static int findMaxDiff(TreeNode root, int minV, int maxV) {
        if (root == null) {
            return Math.abs(minV - maxV);
        }

        minV = Math.min(root.val, minV);
        maxV = Math.max(root.val, maxV);

        int l = findMaxDiff(root.left, minV, maxV);
        int r = findMaxDiff(root.right, minV, maxV);

        return Math.max(l, r);
    }
}
