// https://leetcode.com/problems/all-possible-full-binary-trees/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

public class All_Possible_Full_Binary_Trees {
    static HashMap<Integer, List<TreeNode>> dp = new HashMap<>();

    public static void main(String[] args) {
        int n = 7;

        // just count the number of list items.
        // dont do any sort of traversals for the individual BT.
        System.out.println(allPossibleFBT(n));
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        if (n == 1) {
            TreeNode node = new TreeNode(0);
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            return list;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0, l, r);
                    ans.add(root);
                }
            }
        }

        dp.put(n, ans);
        return ans;
    }
}
