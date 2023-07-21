//https://leetcode.com/problems/find-duplicate-subtrees/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

public class Find_Duplicate_Subtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        List<TreeNode> result = findDuplicateSubtrees(root);

        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        traverse(root, map, result);
        return result;
    }

    public static String traverse(TreeNode node, Map<String, Integer> map, List<TreeNode> result) {
        if (node == null) {
            return "$";
        }

        String subpath = node.val + "," + traverse(node.left, map, result) + "," + traverse(node.right, map, result);

        map.put(subpath, map.getOrDefault(subpath, 0) + 1);

        if (map.get(subpath) == 2) {
            result.add(node);
        }

        return subpath;
    }
}
