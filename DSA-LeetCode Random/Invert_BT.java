//https://leetcode.com/problems/invert-binary-tree/description/

import java.util.LinkedList;
import java.util.Queue;

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

public class Invert_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        levelOrder(root);
        System.out.println();
        TreeNode ans = invertTree(root);
        levelOrder(ans);
    }

    public static TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }

    public static void swap(TreeNode root) {
        if (root == null) {
            return;
        }

        swap(root.left);
        swap(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp == null) {
                if (q.isEmpty()) {
                    return;
                }

                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(temp.val + " ");
            if (temp.left != null) {
                q.add(temp.left);
            }

            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }

}
