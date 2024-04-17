// https://leetcode.com/problems/smallest-string-starting-from-leaf/description/?envType=daily-question&envId=2024-04-17

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

class Pair<T, V> {
    T first;
    V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    public T getKey() {
        return first;
    }

    public V getValue() {
        return second;
    }
}

public class Smallest_String_Starting_From_Leaf {
    static String result = "";

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(smallestFromLeaf(root));
    }

    public static String smallestFromLeaf(TreeNode root) {
        solve(root, "");
        return result;
    }

    private static void solve(TreeNode root, String curr) {
        if (root == null) {
            return;
        }

        // This will take O(length of curr) but I have ignored this. You can
        // consider this as well in calculating T.C
        curr = (char) (root.val + 'a') + curr;
        if (root.left == null && root.right == null) {
            if (result.equals("") || result.compareTo(curr) > 0) {
                result = curr;
            }

            return;
        }

        solve(root.left, curr);
        solve(root.right, curr);
    }

    // --------------------------------------------------------------------------------

    public static String smallestFromLeaf_2(TreeNode root) {
        Queue<Pair<TreeNode, String>> queue = new LinkedList<>();

        String result = "";
        queue.add(new Pair<>(root, String.valueOf((char) (root.val + 'a'))));

        while (!queue.isEmpty()) {
            Pair<TreeNode, String> pair = queue.poll();
            TreeNode node = pair.getKey();
            String curr = pair.getValue();

            if (node.left == null && node.right == null) {
                if (result.equals("") || result.compareTo(curr) > 0) {
                    result = curr;
                }
            }

            if (node.left != null) {
                queue.add(new Pair<>(node.left, (char) (node.left.val + 'a') + curr));
            }

            if (node.right != null) {
                queue.add(new Pair<>(node.right, (char) (node.right.val + 'a') + curr));
            }
        }

        return result;
    }
}
