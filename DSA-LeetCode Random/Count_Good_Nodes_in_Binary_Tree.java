// https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

public class Count_Good_Nodes_in_Binary_Tree {
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        dfs_1(root, Integer.MIN_VALUE);
        // dfs_2(root, Integer.MIN_VALUE);
        return ans;
    }

    private static void dfs_1(TreeNode root, int maxSoFar) {
        if (maxSoFar <= root.val) {
            ans++;
        }

        if (root.right != null) {
            dfs_1(root.right, Math.max(maxSoFar, root.val));
        }

        if (root.left != null) {
            dfs_1(root.left, Math.max(maxSoFar, root.val));
        }
    }

    private static void dfs_2(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }

        if (maxSoFar <= root.val) {
            ans++;
        }

        dfs_2(root.right, Math.max(maxSoFar, root.val));
        dfs_2(root.left, Math.max(maxSoFar, root.val));

    }
}
