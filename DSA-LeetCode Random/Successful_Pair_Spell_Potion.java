//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/

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

    // optimized version.
    public static int[] successfulPairs_3(int[] spells, int[] potions, long success) {
        // Sort the potions array in increasing order.
        Arrays.sort(potions);
        int[] answer = new int[spells.length];

        int m = potions.length;
        int maxPotion = potions[m - 1];

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];

            // Minimum value of potion whose product with current spell
            // will be at least success or more.
            long minPotion = (long) Math.ceil((1.0 * success) / spell);

            // Check if we don't have any potion which can be used.
            if (minPotion > maxPotion) {
                answer[i] = 0;
                continue;
            }

            // We can use the found potion, and all potion in its right
            // (as the right potions are greater than the found potion).
            int index = lowerBound(potions, (int) minPotion);
            answer[i] = m - index;
        }

        return answer;
    }

    // implementation of lower bound method using binary search.
    // very important.
    public static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] < key) {
                lo = mid + 1;
            }

            else {
                hi = mid;
            }
        }

        return lo;
    }
}
