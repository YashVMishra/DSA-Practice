// https://leetcode.com/problems/find-mode-in-binary-search-tree/description/?envType=daily-question&envId=2023-11-01

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Find_Mode_in_Binary_Search_Tree {
    private static int currNum = 0;
    private static int currStreak = 0;
    private static int maxStreak = 0;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));

        int[] ans = findMode_2(root);

        System.out.println(Arrays.toString(ans));
    }

    // uses extra space.
    public static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // traverse the tree and add all the
        traverse(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : map.keySet()) {
            if (map.get(i) > max) {
                max = map.get(i);
                list.clear();
                list.add(i);
            } else if (map.get(i) == max) {
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    private static void traverse(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);

        traverse(root.left, map);
        traverse(root.right, map);
    }

    // ----------------------------------------------------------------------------

    // uses O(1) space.
    public static int[] findMode_2(TreeNode root) {
        traverse(root);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (root.val == currNum) {
            currStreak++;
        } else {
            currNum = root.val;
            currStreak = 1;
        }

        if (currStreak > maxStreak) {
            result.clear();
            maxStreak = currStreak;
        }

        if (currStreak == maxStreak) {
            result.add(root.val);
        }

        traverse(root.right);
    }
}
