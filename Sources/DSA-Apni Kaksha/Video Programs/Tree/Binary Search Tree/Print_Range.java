public class Print_Range {
    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }

        print(root, 1, 10);
    }

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

    public static void print(Node root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            print(root.left, x, y);
            System.out.print(root.data + " ");
            print(root.right, x, y);
        }

        else if (root.data >= y) {
            print(root.left, x, y);
        }

        else {
            print(root.right, x, y);
        }
    }
}
