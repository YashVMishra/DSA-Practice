// https://leetcode.com/problems/count-nice-pairs-in-an-array/description/?envType=daily-question&envId=2023-11-21

import java.util.HashMap;

public class Count_Nice_Pairs_in_an_Array {
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[] { 13, 10, 35, 24, 76 }));
    }

    // rearrange the condition as
    // (nums[i] - rev(nums[i])) == (nums[j] - rev(nums[j])).

    // So, we can store the difference of each number with its reverse in a hashmap
    // and check if the same difference is present in the hashmap or not. If it is
    // present, then we can add the count of that difference to the answer.
    // and increment the count of that difference in the hashmap.
    public static int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int mod = 1000000007;

        for (int i : nums) {
            int key = i - reverse(i);
            count += map.getOrDefault(key, 0);
            count %= mod;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    private static int reverse(int num) {
        int rev = 0;

        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        return rev;
    }
}
