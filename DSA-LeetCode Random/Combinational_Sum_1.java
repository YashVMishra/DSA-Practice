//https://leetcode.com/problems/combination-sum/description/

import java.util.ArrayList;

public class Combinational_Sum_1 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        System.out.println(combinational_sum(arr, 7));
    }

    public static void sum(int[] arr, int target, ArrayList<ArrayList<Integer>> list, int index,
            ArrayList<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                list.add(new ArrayList<>(ds));
            }

            return;
        }

        if (arr[index] <= target) {
            ds.add(arr[index]);
            sum(arr, target - arr[index], list, index, ds);
            ds.remove(ds.size() - 1);
        }

        sum(arr, target, list, index + 1, ds);
    }

    public static ArrayList<ArrayList<Integer>> combinational_sum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        sum(arr, target, list, 0, new ArrayList<Integer>());
        return list;
    }
}
