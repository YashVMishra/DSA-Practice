//https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/

public class Ceil_Floor {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        int ceil_index = ceil(arr, 0);
        int floor_index = floor(arr, 0);
        System.out.println("Ceil is " + ceil_index);
        System.out.println("Floor is " + floor_index);
    }

    public static int ceil(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] > target) {
                j = mid - 1;
            }

            else {
                i = mid + 1;
            }
        }

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        return arr[i];
    }

    public static int floor(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            else if (arr[mid] > target) {
                j = mid - 1;
            }

            else {
                i = mid + 1;
            }
        }

        if (target < arr[0]) {
            return -1;
        }

        return arr[j];
    }
}
