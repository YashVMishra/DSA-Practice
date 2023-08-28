// https://practice.geeksforgeeks.org/problems/subset-sums2234/1

import java.util.ArrayList;
import java.util.Collections;

public class Subset_Sums {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        System.out.println(subsetSums(arr, 3));
        System.out.println(subsetSums_2(arr, 3));
        System.out.println(subsetSums_3(arr, 3));
    }

    // by generating all subsets
    // loop method
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : arr) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> temp = new ArrayList<>(subsets.get(i));
                temp.add(num);
                subsets.add(temp);
            }
        }

        for (ArrayList<Integer> subset : subsets) {
            ans.add(sum(subset));
        }

        return ans;
    }

    // ---------------------------------------------------------------------------------

    // by generating all subsets
    // recurison method.
    public static ArrayList<Integer> subsetSums_2(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, arr, subsets, new ArrayList<>());

        for (ArrayList<Integer> subset : subsets) {
            ans.add(sum(subset));
        }

        return ans;
    }

    private static void generateSubsets(int index, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> subsets,
            ArrayList<Integer> current) {
        subsets.add(new ArrayList<>(current));

        for (int i = index; i < arr.size(); i++) {
            current.add(arr.get(i));
            generateSubsets(i + 1, arr, subsets, current);
            current.remove(current.size() - 1);
        }
    }

    // ---------------------------------------------------------------------------------

    // helper function
    public static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

    // ---------------------------------------------------------------------------------

    public static ArrayList<Integer> subsetSums_3(ArrayList<Integer> arr, int N) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        calculateSum(0, 0, arr, ans);
        Collections.sort(ans);
        return ans;
    }

    private static void calculateSum(int index, int sum, ArrayList<Integer> arr, ArrayList<Integer> ans) {
        if (index == arr.size()) {
            ans.add(sum);
            return;
        }

        // pick
        calculateSum(index + 1, sum + arr.get(index), arr, ans);

        // not pick
        calculateSum(index + 1, sum, arr, ans);
    }
}
