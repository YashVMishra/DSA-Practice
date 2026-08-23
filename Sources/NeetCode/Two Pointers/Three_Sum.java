import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // sorting the array is the first step in almost all the two-pointer problems
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // if i is not the first element and same as the previous one, skip it
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1, end = nums.length - 1;
                int target = 0 - nums[i];

                while (start < end) {
                    int currSum = nums[start] + nums[end];

                    if (currSum == target) {
                        ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

                        // while loops to skip duplicates from the start side
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }

                        // while loops to skip duplicates from the end side
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }

                        // this extra start++ and end-- is for that when the above 2 while loop
                        // ends, we will on the final duplicate element, so we need to move both
                        // pointers
                        start++;
                        end--;
                    } else if (currSum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return ans;
    }
}
