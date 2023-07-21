//https://leetcode.com/problems/minimum-absolute-difference/

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Min_Abs_Diff {
    public static void main(String[] args) {
        int[] arr = { 3, 8, -10, 23, 19, -4, -14, 27 };
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();

        int min_diff = Math.abs(arr[0] - arr[1]);
        for (int i = 0; i < arr.length - 1; i++) {
            min_diff = Math.min(Math.abs(arr[i] - arr[i + 1]), min_diff);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == min_diff) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                list.add(temp);
            }
        }

        return list;
    }
}
