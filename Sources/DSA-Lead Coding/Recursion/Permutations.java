//https://leetcode.com/problems/permutations/description/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[] { 1, 2, 3, 4 }));
    }

    // inspiration taken from Kunal Kushwaha Permutations Program and Video
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list = permutations(nums, new int[] {}, list);
        return list;
    }

    public static List<List<Integer>> permutations(int[] nums, int[] ans, List<List<Integer>> list) {

        // whenever our nums is empty we have our one of the permuatations.
        if (nums.length == 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < ans.length; i++) {
                temp.add(ans[i]);
            }

            list.add(temp);

            return list;
        }

        // extracting the first element as this will be placed
        // in the start, middle and last.
        int num = nums[0];

        // running loop so that we can find all the spaces to fill num.
        for (int i = 0; i <= ans.length; i++) {

            // Arrays copy range functions works same as substring method of the
            // string , here we are finding different arrays.
            int[] left = Arrays.copyOfRange(ans, 0, i);
            int[] right = Arrays.copyOfRange(ans, i, ans.length);

            // temp array to merge the left and the right array
            int[] merge = new int[left.length + right.length + 1];

            // arraycopy function is used to merge two array into the third array.
            System.arraycopy(left, 0, merge, 0, left.length);
            merge[left.length] = num;
            System.arraycopy(right, 0, merge, left.length + 1, right.length);

            permutations(Arrays.copyOfRange(nums, 1, nums.length), merge, list);
        }

        return list;
    }
}
