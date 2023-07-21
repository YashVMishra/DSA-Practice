//https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Pair_Difference {
    public static void main(String[] args) {
        System.out.println(findPair(new int[] { 1, 2, 3, 4, 2 }, 5, 0));
    }

    public static boolean findPair(int arr[], int size, int n) {
        // code here.
        Arrays.sort(arr);

        for (int i = 0; i <= size - 2; i++) {
            if (binSearch(arr, (arr[i] + n), i + 1)) {
                return true;
            }
        }

        return false;
    }

    public static boolean binSearch(int[] arr, int target, int a) {
        int i = a;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] == target) {
                return true;
            }

            else if (arr[mid] > target) {
                j = mid - 1;
            }

            else {
                i = mid + 1;
            }
        }

        return false;
    }
}
