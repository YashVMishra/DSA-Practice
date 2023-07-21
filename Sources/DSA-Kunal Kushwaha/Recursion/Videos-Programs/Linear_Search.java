//Linear search using recursion.

public class Linear_Search {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(search(arr, 5, 0));
    }

    public static boolean search(int[] arr, int target, int index) {
        if (index == arr.length) {
            return false;
        }

        else if (arr[index] == target) {
            return true;
        }

        return search(arr, target, index + 1);
    }
}
