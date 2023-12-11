// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/?envType=daily-question&envId=2023-12-11

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Element_Appearing_More_Than_25_In_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 6, 6, 6, 6, 7, 10 };
        System.out.println(findSpecialInteger(arr));
    }

    // verr simple approach
    // dont think about decimal value when dividing
    // by 4.
    public static int findSpecialInteger(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.put(i, ++count);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) > arr.length / 4) {
                return i;
            }
        }

        return -1;
    }

    // ---------------------------------------------------------------------------------

    // since the array is sorted if any number is present in
    // the array more than 25% of the length of the array
    // then it will be present at i till i + freq
    // where freq = arr.length / 4
    // and we are checking for the same.
    public static int findSpecialInteger_2(int[] arr) {
        int freq = arr.length / 4;

        for (int i = 0; i < arr.length - freq; i++) {
            if (arr[i] == arr[i + freq]) {
                return arr[i];
            }
        }

        return -1;
    }

    // ---------------------------------------------------------------------------------

    // for this see the video from the notes section.
    public int findSpecialInteger_3(int[] arr) {
        int n = arr.length;

        int freq = n / 4;

        List<Integer> candidates = Arrays.asList(arr[n / 4], arr[n / 2], arr[3 * n / 4]);

        for (int candidate : candidates) {
            int left = firstOccur(candidate, 0, n - 1, arr);
            int right = lastOccur(candidate, 0, n - 1, arr);

            if (right - left + 1 > freq) {
                return candidate;
            }
        }

        return -1;
    }

    // return leftmost index of the target
    private int firstOccur(int target, int l, int r, int[] arr) {
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                result = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }

    // return rightmost index of the target
    private int lastOccur(int target, int l, int r, int[] arr) {
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                result = mid;
                l = mid + 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
