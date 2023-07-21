//https://leetcode.com/problems/power-of-heroes/description/

import java.util.Arrays;

public class Power_of_Heroes {
    public static void main(String[] args) {
        int[] num = { 2, 1, 4 };
        System.out.println(sumOfPower(num));
    }

    public static int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int mod = 1000000007;

        long ans = 0;
        Arrays.sort(nums);
        long previosContri = 0;
        for (long num : nums) {
            ans = (ans + ((num * num) % mod * num) % mod + ((num * num) % mod * previosContri) % mod) % mod;
            previosContri = (previosContri * 2 + num) % mod;
        }
        return (int) ans;
    }
}
