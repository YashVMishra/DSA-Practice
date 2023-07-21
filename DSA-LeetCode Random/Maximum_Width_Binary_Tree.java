//https://leetcode.com/problems/maximum-width-of-binary-tree/description/

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

class Pair {
    TreeNode node;
    int num;

    public Pair(int num, TreeNode node) {
        this.num = num;
        this.node = node;
    }
}

public class Maximum_Width_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(0);
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().num;
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int curr_id = q.peek().num - min;
                TreeNode temp = q.peek().node;
                q.poll();

                if (i == 0) {
                    first = curr_id;
                }

                if (i == size - 1) {
                    last = curr_id;
                }

                if (temp.left != null) {
                    q.add(new Pair(curr_id * 2 + 1, temp.left));
                }

                if (temp.right != null) {
                    q.add(new Pair(curr_id * 2 + 2, temp.right));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
}
