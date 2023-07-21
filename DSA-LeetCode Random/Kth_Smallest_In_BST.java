//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import java.util.ArrayList;
import java.util.List;

public class Kth_Smallest_In_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);

        System.out.println(kthSmallest_2(root, 3));
    }

    // still using extra space but TC is reduced.
    public static int kthSmallest_2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        System.out.println(list);

        // we are not sorting the list as inOrder of BST is always sorted.
        return list.get(k - 1);
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
