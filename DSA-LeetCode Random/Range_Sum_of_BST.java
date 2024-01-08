// https://leetcode.com/problems/range-sum-of-bst/description/?envType=daily-question&envId=2024-01-08

public class Range_Sum_of_BST {
    static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        int low = 7;
        int high = 15;

        System.out.println(rangeSumBST(root, low, high));
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        solve_2(root, low, high);
        return sum;
    }

    // checking all the nodes.
    private static void solve(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        solve(root.left, low, high);
        solve(root.right, low, high);
    }

    // checking only the nodes that are in the range.
    // using the property of BST.
    private static void solve_2(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
            solve(root.left, low, high);
            solve(root.right, low, high);
        } else if (root.val < low) {
            solve(root.right, low, high);
        } else if (root.val > high) {
            solve(root.left, low, high);
        }
    }
}
