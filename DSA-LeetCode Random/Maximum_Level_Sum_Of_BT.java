//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

import java.util.Queue;
import java.util.LinkedList;

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

public class Maximum_Level_Sum_Of_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        // root.right.left = new TreeNode(4);
        // root.right.right = new TreeNode(3);

        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 1;
        int maxSum = root.val;
        int level = 0;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            int currSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                currSum += temp.val;

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }

            if (currSum > maxSum) {
                ans = level;
                maxSum = currSum;
            }
        }

        return ans;
    }
}
