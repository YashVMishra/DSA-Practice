//https://leetcode.com/problems/number-of-zero-filled-subarrays/description/

public class No_Of_Zero_Filled_Subarrays {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 0, 0, 2, 0, 0, 4 };
        System.out.println(zeroFilledSubarray(nums));
        System.out.println(zeroFilledSubarray_2(nums));
    }

    // using the formula that array of length n has
    // (n*(n+1))/2 subarrays.
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long count = 0;

        for (int i : nums) {
            if (i == 0) {
                count++;
            }

            else {
                ans += (count * (count + 1)) / 2;
                count = 0;
            }
        }

        // if the consecutive zeroes are at the last then the loop
        // will not enter the else part.
        if (count > 0) {
            ans += (count * (count + 1)) / 2;
        }

        return ans;
    }

    // since (n*(n+1))/2 is a formula for sum of first n number
    // so we add its value everytime.
    public static long zeroFilledSubarray_2(int[] nums) {
        long ans = 0;
        long count = 0;

        for (int i : nums) {
            if (i == 0) {
                count++;
            }

            else {
                count = 0;
            }

            ans += count;
        }

        return ans;
    }
}
