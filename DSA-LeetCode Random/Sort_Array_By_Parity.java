// https://leetcode.com/problems/sort-array-by-parity/description/?envType=daily-question&envId=2023-09-28

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_Array_By_Parity {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(sortArrayByParity_2(nums)));
    }

    // using extra space
    public static int[] sortArrayByParity(int[] nums) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int i : nums) {
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        int index = 0;
        for (int i : even) {
            nums[index++] = i;
        }

        for (int i : odd) {
            nums[index++] = i;
        }

        return nums;
    }

    // using constant space.
    public static int[] sortArrayByParity_2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {

                // swapping.
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        return nums;
    }

    // using comparator.
    public static int[] sortArrayByParity_3(int[] nums) {
        Integer[] numsWrapper = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsWrapper[i] = nums[i];
        }

        Arrays.sort(numsWrapper, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return helper(a, b) ? -1 : 1;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsWrapper[i];
        }

        return nums;
    }

    /*
     * NOTE : return a%2 < b%2;
     * This is causing "Comparison method violates its general contract!" Error.
     * So, for JAVA, I have written below comparator
     */
    public static boolean helper(int a, int b) {

        // If both 'a' and 'b' are even or both are odd, compare them as usual.
        if ((a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0)) {
            return a < b;
        }

        // If 'a' is even and 'b' is odd, 'a' should come before 'b'.
        return a % 2 == 0;
    }
}
