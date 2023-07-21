import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 4, 1, 6, 8, 7, 9 };
        int[] ans = sort(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] arr = new int[first.length + second.length];

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                arr[k] = first[i];
                i++;
                k++;
            }

            else {
                arr[k] = second[j];
                j++;
                k++;
            }
        }

        while (i < first.length) {
            arr[k] = first[i];
            k++;
            i++;
        }

        while (j < second.length) {
            arr[k] = second[j];
            k++;
            j++;
        }

        return arr;

    }
}
