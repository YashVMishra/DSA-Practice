// https://leetcode.com/problems/counting-bits/description/

import java.util.Arrays;

public class Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(2)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            ans[i] = no_of_set_bits_2(i);
        }

        return ans;
    }

    public static int no_of_set_bits(int num) {

        String str = Integer.toBinaryString(num);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }

        return count;
    }

    // counting the number of set bits in the given number using bit manipulation
    public static int no_of_set_bits_2(int num) {
        int count = 0;

        while (num != 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }
}
