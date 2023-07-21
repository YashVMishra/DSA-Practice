//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

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

public class Max_Depth_BT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
        System.out.println(maxDepth_2(root));
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count_levels = -1;

        while (true) {

            // conatins the total nodes in that level.
            int total_nodes = q.size();

            // means the tree is now empty.
            if (total_nodes == 0) {
                return count_levels + 1;
            }

            // adding the children of the nodes and removing the previous nodes.
            while (total_nodes > 0) {
                TreeNode temp = q.poll();

                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

                total_nodes--;
            }

            count_levels++;
        }
    }

    // recursive solution.
    public static int maxDepth_2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);

        return Math.max(d1, d2) + 1;
    }

}
