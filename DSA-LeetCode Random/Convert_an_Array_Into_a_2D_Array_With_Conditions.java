// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/description/?envType=daily-question&envId=2024-01-02

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Convert_an_Array_Into_a_2D_Array_With_Conditions {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        System.out.println(findMatrix(nums));
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }

        for (int num : nums) {
            if (map.get(num) == result.size()) {
                result.add(new ArrayList<>());
            }

            result.get(map.get(num)).add(num);
            map.put(num, map.get(num) + 1);
        }

        return result;
    }

    // ----------------------------------------------------------------

    // since the range of the elements is 1 to the size of the nums
    // so we can use an array instead of a hashmap
    public static List<List<Integer>> findMatrix_2(int[] nums) {
        int[] freq = new int[nums.length + 1];
        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            if (freq[num] == result.size()) {
                result.add(new ArrayList<>());
            }

            result.get(freq[num]).add(num);
            freq[num]++;
        }

        return result;
    }
}
