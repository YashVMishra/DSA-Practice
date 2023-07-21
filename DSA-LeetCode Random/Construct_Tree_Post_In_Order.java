//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Construct_Tree_Post_In_Order {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = buildTree(inorder, postorder);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root, list1);
        postOrder(root, list2);

        System.out.println(list1);
        System.out.println(list2);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length != inorder.length) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public static TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            Map<Integer, Integer> map) {

        if (ps > pe || is > ie) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);

        int inRoot = map.get(postorder[pe]);
        int numsLeft = inRoot - is;

        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, map);
        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, map);

        return root;

    }

    // postorder Traversal.
    public static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
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
