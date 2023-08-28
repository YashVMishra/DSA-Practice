// https://leetcode.com/problems/subsets-ii/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_2 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2 };
        System.out.println(subsetsWithDup(arr));
    }

    public static List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            start = 0;

            // checking for duplicates.
            if (i > 0 && arr[i] == arr[i - 1]) {
                start = end;
            }

            // we can also write (end = ans.size() - 1) instead of end = ans.size()
            // variable.
            // then under the if consition we have to write (start = end + 1) instead of
            // start = end.

            // this +1 and -1 thing is taught by KK in his video.
            end = ans.size();
            int size = ans.size();
            for (int j = start; j < size; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(arr[i]);
                ans.add(temp);
            }
        }

        return ans;
    }
}
