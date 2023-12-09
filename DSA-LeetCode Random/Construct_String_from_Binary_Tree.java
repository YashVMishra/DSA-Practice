// https://leetcode.com/problems/construct-string-from-binary-tree/description/?envType=daily-question&envId=2023-12-08

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

public class Construct_String_from_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2, null, new TreeNode(4));
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(tree2str(root));
    }

    public static String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        String result = root.val + "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (root.left == null && root.right == null) {
            return result;
        }

        if (root.right == null) {
            return result + "(" + left + ")";
        }

        if (root.left == null) {
            return result + "()" + "(" + right + ")";
        }

        return result + "(" + left + ")" + "(" + right + ")";
    }
}