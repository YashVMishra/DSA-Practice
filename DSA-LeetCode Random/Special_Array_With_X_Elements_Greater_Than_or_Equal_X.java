// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/

public class Special_Array_With_X_Elements_Greater_Than_or_Equal_X {
    public static void main(String[] args) {
        int[] nums = { 0, 0 };
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {
        int n = nums.length;

        // Frequency array
        int[] freq = new int[n + 1];

        // Populate the frequency array
        for (int num : nums) {
            if (num >= n) {
                freq[n]++;
            } else {
                freq[num]++;
            }
        }

        // Calculate cumulative sum from the end
        int c_sum = 0;
        for (int i = n; i >= 0; i--) {
            c_sum += freq[i];
            if (i == c_sum) {
                return i;
            }
        }

        return -1;
    }
}
