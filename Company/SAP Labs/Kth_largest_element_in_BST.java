// https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// do a reverse inorder traversal.
// make the count and result variable as global.

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Kth_largest_element_in_BST {
    static int count = 0;
    static int result = -1;

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);

        System.out.println(kthLargest(root, 1));
    }

    // kth largest is the same as (N - k + 1)th smallest.
    public static int kthLargest(Node root, int K) {
        // Your code here
        kthLargestUtil(root, K);
        return result;
    }

    public static void kthLargestUtil(Node root, int k) {

        if (root == null || count >= k) {
            return;
        }

        kthLargestUtil(root.right, k);

        count++;
        if (count == k) {
            result = root.data;
            return;
        }

        kthLargestUtil(root.left, k);
    }
}
