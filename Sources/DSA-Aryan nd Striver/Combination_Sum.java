// https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        System.out.println(combinationSum(arr, 7));
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        sum(arr, target, 0, list, new ArrayList<>());
        return list;
    }

    private static void sum(int[] arr, int target, int index, List<List<Integer>> ans, ArrayList<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            sum(arr, target - arr[i], i, ans, current);
            current.remove(current.size() - 1);
        }
    }
}
