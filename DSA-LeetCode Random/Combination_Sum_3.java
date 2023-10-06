// https://leetcode.com/problems/combination-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_3 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(1, 9, new ArrayList<>(), subsets, k, n);
        return subsets;
    }

    private static void generateSubsets(int start, int end, ArrayList<Integer> current, List<List<Integer>> subsets,
            int k, int target) {
        if (target == 0 && current.size() == k) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || current.size() > k) {
            return;
        }

        for (int i = start; i <= end; i++) {
            current.add(i);
            generateSubsets(i + 1, end, current, subsets, k, target - i);
            current.remove(current.size() - 1);
        }
    }
}
