// https://leetcode.com/problems/distribute-coins-in-binary-tree/description/

public class Distribute_Coins_in_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(3);

        int result = distributeCoins(root);
        System.out.println(result);
    }

    public static int distributeCoins(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        int[] moves = { 0 };
        solve(root, moves);

        return moves[0];
    }

    private static int solve(TreeNode root, int[] moves) {
        if (root == null) {
            return 0;
        }

        int l = solve(root.left, moves);
        int r = solve(root.right, moves);

        int totalExtraCandies = (l + r + root.val) - 1;

        moves[0] += Math.abs(l) + Math.abs(r);

        return totalExtraCandies;
    }
}
