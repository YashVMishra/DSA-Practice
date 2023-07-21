// https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// for second method read the article
// https://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/

import java.util.Arrays;

public class Count_triplets_with_sum_smaller_than_X {
    public static void main(String[] args) {
        int sum = 2;
        long arr[] = { -2, 0, 1, 3 };
        System.out.println(countTriplets(arr, arr.length, sum));
        System.out.println(countTriplets_2(arr, arr.length, sum));
    }

    public static long countTriplets(long arr[], int n, int sum) {
        long count = 0;

        // Fix the first element as A[i]
        for (int i = 0; i < n - 2; i++) {

            // Fix the second element as A[j]
            for (int j = i + 1; j < n - 1; j++) {

                // Now look for the third number
                for (int k = j + 1; k < n; k++)
                    if (arr[i] + arr[j] + arr[k] < sum) {
                        count++;
                    }

            }
        }

        return count;
    }

    public static long countTriplets_2(long arr[], int n, int sum) {
        long count = 0;
        Arrays.sort(arr);

        // Fix the first element as A[i]
        for (int i = 0; i < n - 2; i++) {

            int start = i + 1;
            int end = n - 1;

            while (start < end) {
                if (arr[start] + arr[end] + arr[i] >= sum) {
                    end--;
                } else {
                    count += end - start;
                    start++;
                }
            }
        }

        return count;
    }
}
