// https://leetcode.com/problems/evaluate-boolean-binary-tree/description/?envType=daily-question&envId=2024-05-16

public class Evaluate_Boolean_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(0);
        root.right.left.right = new TreeNode(0);
        root.right.right.left = new TreeNode(0);
        root.right.right.right = new TreeNode(0);

        System.out.println(evaluateTree(root));
    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val != 0; // Convert int to boolean
        }

        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        }

        return evaluateTree(root.left) & evaluateTree(root.right);
    }
}
