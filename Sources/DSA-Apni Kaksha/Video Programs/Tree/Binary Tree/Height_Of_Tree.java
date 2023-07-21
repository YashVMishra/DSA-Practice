public class Height_Of_Tree {
    public static void main(String[] args) {
        int[] preOrder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(preOrder);
        System.out.println(height(root));
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int righHeight = height(root.right);

        return (Math.max(leftHeight, righHeight) + 1);
    }
}
