// https://leetcode.com/problems/even-odd-tree/description/?envType=daily-question&envId=2024-02-29

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Even_Odd_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        // root.right.right = new TreeNode(11);

        System.out.println(isEvenOddTree(root));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            levels.add(level);
        }

        System.out.println(levels);

        for (int i = 0; i < levels.size(); i++) {
            if (i % 2 == 0) {
                if (levels.get(i).get(0) % 2 == 0) {
                    return false;
                }

                for (int j = 1; j < levels.get(i).size(); j++) {
                    if (levels.get(i).get(j) % 2 == 0 || levels.get(i).get(j) <= levels.get(i).get(j - 1)) {
                        return false;
                    }
                }
            } else {
                if (levels.get(i).get(0) % 2 != 0) {
                    return false;
                }

                for (int j = 1; j < levels.get(i).size(); j++) {
                    if (levels.get(i).get(j) % 2 != 0 || levels.get(i).get(j) >= levels.get(i).get(j - 1)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
