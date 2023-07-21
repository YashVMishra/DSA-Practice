//https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

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

public class Minimum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(15);

        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        return bfs(root);
    }

    public static int dfs_1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null) {
            return 1 + dfs_1(root.left);
        } else if (root.left == null) {
            return 1 + dfs_1(root.right);
        } else {

            // return the min of the both the sides if both are present
            return 1 + Math.min(dfs_1(root.left), dfs_1(root.right));
        }
    }

    public static int dfs_2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.right == null) {
            return 1 + dfs_2(root.left);
        } else if (root.left == null) {
            return 1 + dfs_2(root.right);
        } else {

            // return the min of the both the sides if both are present
            return 1 + Math.min(dfs_2(root.left), dfs_2(root.right));
        }
    }

    public static int bfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();

                // checking the leaf node.
                // checking level order.
                if (temp.left == null && temp.right == null) {
                    return depth;
                }

                if (temp.left != null) {
                    queue.offer(temp.left);
                }

                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }

            depth++;
        }

        return depth;
    }
}
