/*
 * Count the Number of nodes in a Binary Tree.
 */

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// used to form the Tree from PreOrder.
class BinaryTree {
    int index = -1;

    public Node buildTree(int[] preOrder) {
        index++;
        if (preOrder[index] == -1) {
            return null;
        }

        Node newNode = new Node(preOrder[index]);
        newNode.left = buildTree(preOrder);
        newNode.right = buildTree(preOrder);

        return newNode;
    }
}

public class Count_No_Of_Nodes {
    public static void main(String[] args) {
        int[] preOrder = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(preOrder);
        System.out.println(count(root));
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        // dont add 1 here.
        // add when you return.
        int leftSubTree = count(root.left);
        int rightSubTree = count(root.right);

        return leftSubTree + rightSubTree + 1;
    }
}
