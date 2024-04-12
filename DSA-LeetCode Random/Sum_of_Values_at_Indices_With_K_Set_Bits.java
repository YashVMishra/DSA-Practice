// https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/description/

import java.util.List;

public class Sum_of_Values_at_Indices_With_K_Set_Bits {
    public static void main(String[] args) {
        System.out.println(sumIndicesWithKSetBits(List.of(1, 2, 3, 4, 5), 1));
        System.out.println(sumIndicesWithKSetBits(List.of(1, 2, 3, 4, 5), 2));
        System.out.println(sumIndicesWithKSetBits(List.of(1, 2, 3, 4, 5), 3));
    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }
}
