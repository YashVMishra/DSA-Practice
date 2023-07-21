//https://practice.geeksforgeeks.org/problems/combination-sum-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Combinational_Sum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(6);
        list.add(5);

        // we are using a hashset as it does not contain duplicate elements
        // in short we are removing the duplicate elements.
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        // sorting the list as we need to give answer in non-decreasing order.
        Collections.sort(list);
        System.out.println(combinationSum(list, 16));
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        sum(arr, target, list, 0, new ArrayList<Integer>());
        return list;
    }

    public static void sum(ArrayList<Integer> arr, int target, ArrayList<ArrayList<Integer>> list, int index,
            ArrayList<Integer> ds) {
        if (index == arr.size()) {
            if (target == 0) {
                list.add(new ArrayList<>(ds));
            }

            return;
        }

        if (arr.get(index) <= target) {
            ds.add(arr.get(index));
            sum(arr, target - arr.get(index), list, index, ds);
            ds.remove(ds.size() - 1);
        }

        sum(arr, target, list, index + 1, ds);
    }
}
