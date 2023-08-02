// https://leetcode.com/problems/combinations/description/

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(1, n, ans, new ArrayList<>(), k);
        return ans;
    }

    public static void generateSubsets(int index, int n, List<List<Integer>> ans, ArrayList<Integer> curr, int k) {
        if (curr.size() == k) {
            ans.add((new ArrayList<>(curr)));
            return;
        }

        for (int i = index; i <= n; i++) {
            curr.add(i);
            generateSubsets(i + 1, n, ans, curr, k);
            curr.remove(curr.size() - 1);
        }
    }
}
