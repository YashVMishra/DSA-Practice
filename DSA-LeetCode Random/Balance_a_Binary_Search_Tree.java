// https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26

import java.util.ArrayList;
import java.util.List;

public class Balance_a_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode balanced = balanceBST(root);
        System.out.println(balanced.val);
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> vec = new ArrayList<>();
        inOrder(root, vec);
        return construct(0, vec.size() - 1, vec);
    }

    private static TreeNode construct(int l, int r, List<Integer> vec) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(vec.get(mid));
        root.left = construct(l, mid - 1, vec);
        root.right = construct(mid + 1, r, vec);

        return root;
    }

    private static void inOrder(TreeNode root, List<Integer> vec) {
        if (root == null) {
            return;
        }

        inOrder(root.left, vec);
        vec.add(root.val);
        inOrder(root.right, vec);
    }
}