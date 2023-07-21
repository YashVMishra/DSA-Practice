
//https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/

import java.util.HashSet;

public class Sum_Pair {
    public static void main(String[] args) {
        System.out.println(sumPair(new int[] { 11, 15, 26, 38, 9, 10 }, 45));
    }

    // does not use a constant space.
    public static boolean sumPair(int[] arr, int sum) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];

            if (hs.contains(diff)) {
                return true;
            }

            hs.add(arr[i]);
        }

        return false;
    }

    // uses a constant space.
    public static boolean sumPair_2(int[] arr, int sum, int n) {
        int i;
        for (i = 0; i < n - 1; i++)
            if (arr[i] > arr[i + 1])
                break;

        // l is now index of smallest element
        int l = (i + 1) % n;

        // r is now index of largest element
        int r = i;

        // Keep moving either l or r till they meet
        while (l != r) {
            // If we find a pair with sum x, we
            // return true
            if (arr[l] + arr[r] == sum)
                return true;

            // If current pair sum is less, move
            // to the higher sum
            if (arr[l] + arr[r] < sum)
                l = (l + 1) % n;

            // Move to the lower sum side
            else
                r = (n + r - 1) % n;
        }
        return false;
    }
}
