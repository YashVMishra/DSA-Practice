// https://leetcode.com/problems/count-alternating-subarrays/description/

public class Count_Alternating_Subarrays {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1 };
        System.out.println(countAlternatingSubarrays(nums));
        System.out.println(countAlternatingSubarrays_2(nums));
        System.out.println(countAlternatingSubarrays_3(nums));
    }

    public static long countAlternatingSubarrays(int[] nums) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (isAlternating(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isAlternating(int[] nums, int start, int end) {
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // --------------------------------------------------------------------------------

    // this is the approach that I came up with
    // i this I have used another loop inside a loop,
    // although its not afffecting the running time but i can be avoided.
    public static long countAlternatingSubarrays_2(int[] nums) {
        long count = 0;
        int i = 0, j = 0;

        while (j < nums.length) {

            while (true) {
                if (j + 1 < nums.length && nums[j] != nums[j + 1]) {
                    j++;
                } else {
                    break;
                }
            }

            long len = j - i + 1;
            count += len * (len + 1) / 2;

            i = j + 1;
            j = i;
        }

        return count;
    }

    // --------------------------------------------------------------------------------

    public static long countAlternatingSubarrays_3(int[] nums) {
        long count = 0;
        int i = 0, j = 0;

        while (j < nums.length) {
            if (j + 1 < nums.length && nums[j] != nums[j + 1]) {
                j++;
            } else {
                long len = j - i + 1;
                count += len * (len + 1) / 2;

                i = j + 1;
                j = i;
            }

        }

        return count;
    }
}