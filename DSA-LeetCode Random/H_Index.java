// https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = { 1, 3, 1 };
        System.out.println(hIndex(citations));
        System.out.println(hIndex_2(citations));
    }

    // approach is simple
    // since the h-index can have the maximum value of the length of the array
    // we run the loop from the max value to 0
    // then we find the count of the elements which are greater than or equal to the
    // current value of the loop
    // if the count is greater than or equal to the current value of the loop, we
    // return the current value of the loop else we decrease the value by 1
    // and repeat the process
    public static int hIndex(int[] citations) {
        int ans = citations.length;
        while (ans > 0) {
            int count = 0;
            for (int i : citations) {
                if (i >= ans) {
                    count++;
                }
            }

            if (count >= ans) {
                return ans;
            }

            ans--;
        }

        return ans;
    }

    // ----------------------------------------------------------------

    // using binary search
    // not a simple binary search
    // based on some observations.
    public static int hIndex_2(int[] citations) {
        Arrays.sort(citations);

        int low = 0, high = citations.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (citations[mid] == citations.length - mid) {
                return citations[mid];
            } else if (citations[mid] > citations.length - mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return citations.length - low;
    }
}
