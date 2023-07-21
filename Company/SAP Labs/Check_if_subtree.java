// https://practice.geeksforgeeks.org/problems/check-if-subtree/1?page=1&company[]=SAP%20Labs&sortBy=submissions

// for reference see handwritten notes.

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = null;
        right = null;
    }
}

public class Check_if_subtree {

    // IDK why this is showing false as it is running fine on the
    // GFG portal and I have passed all the test cases.
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        Node subRoot = new Node(2);
        subRoot.left = new Node(3);
        subRoot.right = new Node(4);

        System.out.println(isIdentical(root, subRoot));
    }

    public static boolean isSubtree(Node T, Node S) {
        // add code here.
        if (S == null) {
            return true;
        }

        if (T == null) {
            return false;
        }

        if (T.data == S.data) {

            // you cannot write return isIdentical(T, S) as there might be a chance that
            // main tree has duplicate values so whenever you find true then only you return
            // else you check further.
            if (isIdentical(T, S)) {
                return true;
            }
        }

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static boolean isIdentical(Node T, Node S) {
        if (T == null && S == null) {
            return true;
        }

        if (T == null || S == null) {
            return false;
        }

        if (T.data == S.data) {
            return isIdentical(T.left, S.left) && isIdentical(T.right, S.right);
        }

        return false;
    }
}
