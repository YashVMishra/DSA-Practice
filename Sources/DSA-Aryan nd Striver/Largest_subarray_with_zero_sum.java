//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

import java.util.HashMap;

public class Largest_subarray_with_zero_sum {
    public static void main(String[] args) {
        int A[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(A, A.length));
        System.out.println(maxLen_2(A, A.length));
    }

    // shows TLE.
    public static int maxLen(int arr[], int n) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == 0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    public static int maxLen_2(int arr[], int n) {
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSum == 0) {
                maxLength = i + 1;
            } else {
                if (map.get(prefixSum) != null) {
                    maxLength = Math.max((i - map.get(prefixSum)), maxLength);
                } else {
                    map.put(prefixSum, i);
                }
            }
        }

        return maxLength;
    }
}
