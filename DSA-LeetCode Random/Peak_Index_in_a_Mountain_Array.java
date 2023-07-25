// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

public class Peak_Index_in_a_Mountain_Array {
    public static void main(String[] args) {
        int[] arr = { 0, 2, 1, 0 };
        System.out.println(peakIndexInMountainArray(arr));
        System.out.println(peakIndexInMountainArray_2(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int index = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static int peakIndexInMountainArray_2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
