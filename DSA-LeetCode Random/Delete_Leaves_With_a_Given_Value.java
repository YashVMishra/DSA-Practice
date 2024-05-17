// https://leetcode.com/problems/delete-leaves-with-a-given-value/description/?envType=daily-question&envId=2024-05-17

public class Delete_Leaves_With_a_Given_Value {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        TreeNode result = removeLeafNodes(root, 2);
        printTree(result);
    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
}
