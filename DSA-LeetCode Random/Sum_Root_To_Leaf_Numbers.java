//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/

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

public class Sum_Root_To_Leaf_Numbers {
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 0);
        return ans;
    }

    public static void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        val *= 10;
        val += root.val;

        // checking of the node is a leaf node.
        if (root.left == null && root.right == null) {
            ans += val;
            return;
        }

        dfs(root.left, val);
        dfs(root.right, val);
    }
}
