// https://leetcode.com/problems/find-in-mountain-array/description/?envType=daily-question&envId=2023-10-12

class MountainArray {
    int[] array = { 1, 2, 3, 4, 5, 3, 1 };

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

public class Find_in_Mountain_Array {
    public static void main(String[] args) {
        MountainArray mountainArr = new MountainArray();
        System.out.println(findInMountainArray(3, mountainArr));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();

        // 1. Find the index of the peak element
        int low = 1;
        int high = length - 2;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int peakIndex = low;
        int left = binarySearch(mountainArr, target, 0, peakIndex, true);
        int right = binarySearch(mountainArr, target, peakIndex + 1, length - 1, false);

        return left != -1 ? left : right;
    }

    private static int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean asc) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);

            if (asc) {
                if (midVal < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                if (midVal > target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }

        if (mountainArr.get(low) == target) {
            return low;
        }

        return -1;
    }
}
