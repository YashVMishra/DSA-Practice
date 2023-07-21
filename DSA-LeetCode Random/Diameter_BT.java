//https://leetcode.com/problems/diameter-of-binary-tree/description/

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

public class Diameter_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameter(root) - 1);

        TreeInfo ans = diameter_2(root);
        System.out.println(ans.dia - 1);
    }

    // uses O(n^2).
    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.right) + height(root.left) + 1;

        return Math.max(dia1, Math.max(dia2, dia3));
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int righHeight = height(root.right);

        return (Math.max(leftHeight, righHeight) + 1);
    }

    static class TreeInfo {
        int ht;
        int dia;

        public TreeInfo(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }

    // uses O(n).
    public static TreeInfo diameter_2(TreeNode root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter_2(root.left);
        TreeInfo right = diameter_2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht + 1;

        int myDia = Math.max(dia1, Math.max(dia2, dia3));

        TreeInfo ans = new TreeInfo(myHeight, myDia);
        return ans;
    }
}
