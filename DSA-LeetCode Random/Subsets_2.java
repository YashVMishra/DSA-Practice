//https://leetcode.com/problems/subsets-ii/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subsets_2 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] { 1, 2, 2, 1 }));
    }

    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;

            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = ans.size() - 1;
            int size = ans.size();
            for (int j = start; j < size; j++) {
                List<Integer> internal = new ArrayList<>(ans.get(j));
                internal.add(arr[i]);
                ans.add(internal);
            }
        }

        return ans;
    }
}
