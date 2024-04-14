public class Sum_of_Left_Leaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode parent = null;
        return sum(root, parent);
    }

    public static int sum(TreeNode curr, TreeNode parent) {
        if (curr == null)
            return 0;

        int left = sum(curr.left, curr);
        int right = sum(curr.right, curr);

        int sum = 0;
        if (curr.left == null && curr.right == null) {
            if (parent != null && parent.left == curr)
                sum += curr.val;
        }

        return left + right + sum;
    }

    // ---------------------------------------------------------------------------------

    public static int sumOfLeftLeaves_2(TreeNode root) {
        return solve(root, false);
    }

    public static int solve(TreeNode curr, boolean isLeft) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft) {
            return curr.val;
        }

        return solve(curr.left, true) + solve(curr.right, false);
    }
}
