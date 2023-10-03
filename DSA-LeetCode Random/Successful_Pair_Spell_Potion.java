// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class Successful_Pair_Spell_Potion {
    public static void main(String[] args) {
        int[] spells = { 5, 1, 3 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 7;
        System.out.println(Arrays.toString(successfulPairs_3(spells, potions, success)));
    }

    // shows TLE.
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int count = 0;
            for (int j = 0; j < potions.length; j++) {
                if (((long) (spells[i]) * (long) (potions[j])) >= success) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }

    // -----------------------------------------------------------------------------------

    // little bit optimized.
    public static int[] successfulPairs_2(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (((long) (spells[i]) * (long) (potions[j])) >= success) {
                    ans[i] = m - j;
                    break;
                }
            }
        }

        return ans;
    }

    // -----------------------------------------------------------------------------------

    // optimized version.
    public static int[] successfulPairs_3(int[] spells, int[] potions, long success) {
        // Sort the array for binary search.
        Arrays.sort(potions);
        int[] ans = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            // find the key for which we have to find the index.
            int key = (int) (Math.ceil(1.0 * success / spells[i]));

            // if the key is greater than the last element of the potions array then we
            // don't have to check for the index as we dont have any successful pair.
            if (key > potions[potions.length - 1]) {
                ans[i] = 0;
                continue;
            }

            int index = lowerBound(potions, key);
            ans[i] = potions.length - index;
        }

        return ans;
    }

    // here we have to find an index of that element whose value is greater than or
    // equal to key that is lowerbound.
    // and in these cases we don't have to check for the condition
    // if(arr[mid] == key) because we have to find the index of that element whose
    // value is greater than or equal to key.

    // For ex : arr = {1, 2, 4, 4, 5}
    // here if the key is 4 there might be a chance that the
    // binary search will return the index of the second 4.
    // and the first 4 will be ignored and we dont want that
    // as it decreases our count by one.
    public static int lowerBound(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
