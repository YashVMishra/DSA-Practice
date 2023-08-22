// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

import java.util.Arrays;

public class Minimum_Platforms {
    public static void main(String[] args) {
        int n = 6;
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arr, dep, n));
    }

    public static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int count = 0, ans = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
                // ans = Math.max(ans, count);
            } else {
                count--;
                j++;
            }

            // you can write the below code here also and in the if
            // block also.
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
