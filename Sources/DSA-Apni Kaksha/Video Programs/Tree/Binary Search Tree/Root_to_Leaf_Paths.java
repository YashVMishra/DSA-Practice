import java.util.ArrayList;

public class Root_to_Leaf_Paths {
    public static void main(String[] args) {
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;

        for (int i : values) {
            root = insert(root, i);
        }

        rootToLeafPaths(root, new ArrayList<>());
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

    public static void rootToLeafPaths(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        // leaf node.
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        // non-leaf node.
        else {
            rootToLeafPaths(root.left, path);
            rootToLeafPaths(root.right, path);
        }

        path.remove(path.size() - 1);
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }

        System.out.println();
    }
}
