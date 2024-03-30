// https://leetcode.com/problems/subarrays-with-k-different-integers/description/?envType=daily-question&envId=2024-03-30

import java.util.HashMap;

public class Subarrays_with_K_Different_Integers {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;

        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return slidingWindow(nums, k) - slidingWindow(nums, k - 1);
    }

    public static int slidingWindow(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;
        int i = 0;
        int j = 0;

        int count = 0;

        while (j < n) {

            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.size() > k) {

                // Shrink the window
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }

                i++;
            }

            count += (j - i + 1); // Ending at j
            j++;
        }

        return count;
    }

    // --------------------------------------------------------------------------------

    public int subarraysWithKDistinct_2(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        int i_chota = 0;
        int j = 0;
        int i_bada = 0;

        int result = 0;

        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

            while (mp.size() > k) {
                mp.put(nums[i_chota], mp.get(nums[i_chota]) - 1);
                if (mp.get(nums[i_chota]) == 0) {
                    mp.remove(nums[i_chota]);
                }

                i_chota++;
                i_bada = i_chota;
            }

            while (mp.get(nums[i_chota]) > 1) {
                mp.put(nums[i_chota], mp.get(nums[i_chota]) - 1);
                i_chota++;
            }

            if (mp.size() == k) {
                result += i_chota - i_bada + 1;
            }

            j++;
        }

        return result;
    }
}
