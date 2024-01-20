// https://leetcode.com/problems/sum-of-subarray-minimums/description/?envType=daily-question&envId=2024-01-20

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Sum_of_Subarray_Minimums {
    private static int MOD = 1000000007;

    public static void main(String[] args) {
        int[] arr = { 11, 81, 94, 43, 3 };

        System.out.println(sumSubarrayMins_2(arr));
    }

    // shows TLE
    // just generate all subarrays and find min of each subarray
    public static int sumSubarrayMins(int[] arr) {
        List<List<Integer>> subArrays = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int[] subArray = Arrays.copyOfRange(arr, i, j + 1);

                List<Integer> subList = new ArrayList<>();
                for (int k : subArray) {
                    subList.add(k);
                }

                subArrays.add(subList);
            }
        }

        System.out.println(subArrays);
        int sum = 0;
        for (List<Integer> subArray : subArrays) {
            sum += min(subArray) % MOD;
        }

        return sum;
    }

    private static int min(List<Integer> subArray) {
        int min = Integer.MAX_VALUE;
        for (int i : subArray) {
            min = Math.min(min, i);
        }

        return min;
    }

    // ------------------------------------------------------------------------------------

    public static int sumSubarrayMins_2(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
                sum %= MOD;
            }
        }

        return sum;
    }

    // ------------------------------------------------------------------------------------

    public static int sumSubarrayMins_3(int[] arr) {
        int n = arr.length;

        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        int M = 1000000007;

        for (int i = 0; i < n; i++) {
            long d1 = i - NSL[i];
            long d2 = NSR[i] - i;

            long totalWaysForIMin = d1 * d2;
            long sumIInTotalWays = arr[i] * totalWaysForIMin;

            sum = (sum + sumIInTotalWays) % M;
        }

        return (int) sum;
    }

    public static int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    public static int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }
}
