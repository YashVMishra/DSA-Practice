//https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Triplets_as_Sum {
    public static void main(String[] args) {
        System.out.println(tripletsAsSum(new int[] { -2, 0, 1, 3 }, 4, 2));
    }

    public static int tripletsAsSum(int[] arr, int size, int sum) {

        int count = 0;
        Arrays.sort(arr);

        // we have done size-2 as we need triplets
        // there might be a possibility that j and k will refer to the same element.
        for (int i = 0; i < size - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                if (arr[i] + arr[j] + arr[k] >= sum) {
                    k--;
                }

                // if the above condition is false then that means that there are (k-j)
                // different triplets for current i and j.
                else {
                    count += k - j;
                    j++;
                }
            }
        }

        return count;
    }
}
