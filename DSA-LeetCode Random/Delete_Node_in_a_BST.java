// https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75

public class Delete_Node_in_a_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        inorder(root);
        System.out.println();

        TreeNode res = deleteNode(root, 3);
        inorder(res);
    }

    // deletion in BST invloves two prcoess that is search and delete.
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        // search for key in right subtree
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }

        // search for key in left subtree
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }

        // key found.
        else {

            // case 1
            // leaf node.
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            // node with one child.
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            // node with two children.

            // Inorder Successor (IS) is the smallest node in the right subtree.
            TreeNode IS = inorderSuccessor(root.right);
            root.val = IS.val;

            // since we have taken IS from root.right subtree, we need to delete IS from
            // root.right subtree.
            root.right = deleteNode(root.right, IS.val);
        }

        return root;
    }

    private static TreeNode inorderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
