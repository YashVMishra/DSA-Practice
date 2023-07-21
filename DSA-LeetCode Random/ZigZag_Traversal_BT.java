//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/s

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
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

public class ZigZag_Traversal_BT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // storing the level order traversal of the tree.
        level_order(root, list);

        // reversing the alternate innerlist starting from index 1.
        for (int i = 1; i < list.size(); i += 2) {
            Collections.reverse(list.get(i));
        }

        return list;
    }

    // method to store the level order traversal.
    public static void level_order(TreeNode root, List<List<Integer>> list) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        // temporary list for every level.
        List<Integer> temp = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                if (q.isEmpty()) {

                    // important line as without it you cannot
                    // capture the elements of the last level.
                    list.add(temp);
                    temp = new ArrayList<>();
                    return;
                }

                list.add(temp);

                // important as everytime for every level temp need to be different.
                temp = new ArrayList<>();
                q.add(null);
                continue;
            }

            temp.add(node.val);

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }
    }
}
