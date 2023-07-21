//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Construct_Tree_Pre_In_Order {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] preorder = { 3, 9, 20, 15, 7 };
        TreeNode root = buildTree(inorder, preorder);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root, list1);
        preOrder(root, list2);

        System.out.println(list1);
        System.out.println(list2);
    }

    public static TreeNode buildTree(int[] inorder, int[] preorder) {
        if (inorder == null || preorder == null || preorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreePreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

    }

    public static TreeNode buildTreePreIn(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd, Map<Integer, Integer> map) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTreePreIn(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, map);

        root.right = buildTreePreIn(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, map);

        return root;

    }

    // preorder Traversal.
    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // inorder traversal
    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

    }
}
