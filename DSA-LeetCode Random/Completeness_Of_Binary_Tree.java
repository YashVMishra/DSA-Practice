//https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/

import java.util.LinkedList;
import java.util.Queue;

public class Completeness_Of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(isCompleteTree(root));
    }

    // just check for first null
    // if after the first null there is no node then its a complete BT
    // else no.
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean firstNull = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                firstNull = true;
            }

            else {
                if (firstNull) {
                    return false;
                }

                else {
                    q.offer(curr.left);
                    q.offer(curr.right);
                }
            }
        }

        return true;

    }
}