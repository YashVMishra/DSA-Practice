// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/?envType=daily-question&envId=2024-01-04

import java.util.HashMap;

public class Minimum_Number_of_Operations_to_Make_Array_Empty {
    public static void main(String[] args) {
        int[] nums = { 14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12 };
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.keySet()) {
            int count = map.get(num);

            // if the count is 1 we cannot do anything and
            // cannot empty the array
            if (count == 1) {
                return -1;
            }

            // if the count is 2 then only one operation is needed
            else if (count == 2) {
                operations++;
            }

            // this is for the case where the count is
            // multiple of 3 or a mixture of 3 and 2
            else {

                // if the count is just above the multiple of 3
                // then we can do 2 operations to make it multiple of 3
                // and then we can empty the array

                // example: 16 -> 14 -> 12 -> 0
                if (count % 3 == 1) {
                    operations += 2;
                    count -= 4;
                    operations += count / 3;
                }

                // if the count is 2 above the multiple of 3
                // then we can do 1 operations to make it multiple of 3
                // and then we can empty the array

                // example: 17 -> 15 -> 0
                else if (count % 3 == 2) {
                    operations += 2;
                    count -= 2;
                    operations += count / 3;
                }

                // this is the case where count is multiple of 3
                else {
                    operations += count / 3;
                }
            }
        }

        return operations;
    }
}
