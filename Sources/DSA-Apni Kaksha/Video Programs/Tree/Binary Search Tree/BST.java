class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

// here the assumption is that the BST does not contain duplicate items.
public class BST {

    // insertion.
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // right substree.
        if (val > root.data) {
            root.right = insert(root.right, val);
        }

        // left subtree.
        else {
            root.left = insert(root.left, val);
        }

        return root;
    }

    // searching.
    public static boolean search(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        // search in the right subtree.
        else if (target > root.data) {
            return search(root.right, target);
        }

        // search in left subtree.
        else {
            return search(root.left, target);
        }
    }

    // deletion.
    public static Node delete(Node root, int val) {
        if (root.data > val) {
            root.left = delete(root.left, val);
        }

        else if (val > root.data) {
            root.right = delete(root.right, val);
        }

        else {

            // case 1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            if (root.right == null) {
                return root.left;
            }

            else if (root.left == null) {
                return root.right;
            }

            // case 3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    // helping method used in deletion
    // find the inorder successor.
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }

        inorder(root);
        System.out.println();

        delete(root, 5);
        inorder(root);

    }
}