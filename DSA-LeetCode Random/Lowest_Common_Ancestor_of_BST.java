//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=study-plan&id=level-1

import java.util.ArrayList;

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

public class Lowest_Common_Ancestor_of_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode ans1 = lowestCommonAncestor(root, root.left, root.right);
        TreeNode ans2 = lowestCommonAncestor_brute(root, root.left, root.right);
        System.out.println(ans1.val);
        System.out.println(ans2.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case.
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        else if (right == null) {
            return left;
        }

        // both are not null that is our answer.
        else {
            return root;
        }
    }

    public static TreeNode lowestCommonAncestor_brute(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        traverse(root, p.val, list1);
        traverse(root, q.val, list2);
        TreeNode ans = null;

        for (TreeNode i : list1) {
            for (TreeNode j : list2) {
                if (i.val == j.val) {
                    ans = i;
                }
            }
        }

        return ans;
    }

    // adding the path from the root to that node in the list.
    public static void traverse(TreeNode root, int val, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }

        if (root.val == val) {
            list.add(root);
            return;
        }

        list.add(root);

        if (val > root.val) {
            traverse(root.right, val, list);
        }

        else {
            traverse(root.left, val, list);
        }
    }
}
