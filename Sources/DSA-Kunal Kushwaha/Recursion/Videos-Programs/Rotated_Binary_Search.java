// Do binary search in a rotated sorted array.
// Ex=[5,6,7,8,9,1,2,3]

public class Rotated_Binary_Search {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3 };
        System.out.println(search(arr, 4, 0, arr.length - 1));
    }

    static int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        // when the target element is between the first sorted part.
        if (arr[start] <= arr[mid]) {
            if (target >= arr[start] && target <= arr[mid]) {
                return search(arr, target, start, mid - 1);
            }

            else {
                return search(arr, target, mid + 1, end);
            }
        }

        // if the target element is in the other sorted part
        if (target >= arr[mid] && target <= arr[end]) {
            return search(arr, target, mid + 1, end);
        }

        else {
            return search(arr, target, start, mid - 1);
        }
    }
}
