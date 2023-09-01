// https://leetcode.com/problems/combination-sum-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_2 {
    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(combinationSum2(arr, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        sum(arr, target, 0, ans, new ArrayList<>());
        return ans;
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
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            current.add(arr[i]);
            sum(arr, target - arr[i], i + 1, ans, current);
            current.remove(current.size() - 1);
        }
    }
}
