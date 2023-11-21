// https://leetcode.com/problems/count-number-of-bad-pairs/description/

import java.util.HashMap;

public class Count_Number_of_Bad_Pairs {
    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[] { 1, 2, 3, 4, 5 }));
    }

    public static long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = i - nums[i];

            // we have done i - map.getOrDefault(key, 0) as
            // we want the pairs which are not equal and if the
            // key is not present then it can make pair with every element
            // to its left and that value is given by i and we have subtracted
            // the count of that key cause that many times the same value is
            // present to its left and it cannot make pair with that many.
            count += i - map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}
