// https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;

public class Leaf_Similar_Trees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        System.out.println(leafSimilar(root1, root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        getLeafNodes(root1, list1);
        getLeafNodes(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }

        }

        return true;
    }

    // function to get the leaf nodes values.
    private static void getLeafNodes(TreeNode root, ArrayList<Integer> list1) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list1.add(root.val);
        }

        getLeafNodes(root.left, list1);
        getLeafNodes(root.right, list1);
    }
}
