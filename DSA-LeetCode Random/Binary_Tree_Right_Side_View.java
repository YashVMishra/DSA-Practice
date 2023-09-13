// https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class Binary_Tree_Right_Side_View {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
        System.out.println(rightSideView_2(root));
    }

    // using level order traversal
    // whichever node you encounter last in the level order traversal
    // add that node to the list.
    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == size - 1) {
                    list.add(temp.val);
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }

        return list;
    }

    // ----------------------------------------------------------------------------------------

    // recursion.
    public static List<Integer> rightSideView_2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewHelper(root, list, 0);
        return list;
    }

    private static void rightSideViewHelper(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }

        if (list.size() == level) {
            list.add(root.val);
        }

        rightSideViewHelper(root.right, list, level + 1);
        rightSideViewHelper(root.left, list, level + 1);
    }
}
