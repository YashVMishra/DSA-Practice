// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75

public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        root.left = p;
        root.right = q;

        TreeNode p1 = new TreeNode(6);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(7);
        TreeNode p4 = new TreeNode(4);

        p.left = p1;
        p.right = p2;

        q.left = p3;
        q.right = p4;

        TreeNode p5 = new TreeNode(0);
        TreeNode p6 = new TreeNode(8);

        p2.left = p5;
        p2.right = p6;

        System.out.println(lowestCommonAncestor(root, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
