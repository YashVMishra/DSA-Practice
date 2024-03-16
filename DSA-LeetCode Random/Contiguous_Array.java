import java.util.HashMap;

public class Contiguous_Array {
    public static void main(String[] args) {
        int[] nums = { 0, 1 };
        System.out.println(findMaxLength_2(nums));
    }

    public static int findMaxLength(int[] nums) {
        int maxSubarray = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maxSubarray = Math.max(maxSubarray, totalCount(nums, i, j));
            }
        }

        return maxSubarray;
    }

    private static int totalCount(int[] nums, int start, int end) {
        int oneCount = 0;
        int zeroCount = 0;

        for (int i = start; i <= end; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
        }

        return zeroCount == oneCount ? zeroCount + oneCount : 0;
    }

    // --------------------------------------------------------------------------------

    public static int findMaxLength_2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        int currSum = 0;
        int maxL = 0;

        mp.put(0, -1);

        for (int i = 0; i < n; i++) {
            currSum += (nums[i] == 1) ? 1 : -1;
            if (mp.containsKey(currSum)) {
                maxL = Math.max(maxL, i - mp.get(currSum));
            } else {
                mp.put(currSum, i);
            }
        }

        return maxL;
    }
}