//https://www.codingninjas.com/studio/problems/count-inversions_615?leftPanelTab=0

public class Count_Inversions {
    public static void main(String[] args) {
        long[] arr = { 2, 5, 1, 3, 4 };
        int n = arr.length;
        System.out.println(getInversions(arr, n));
        System.out.println(getInversions_2(arr, n));
    }

    // gets selected on coding ninjas but might show TLE.
    public static long getInversions(long arr[], int n) {
        // Write your code here.

        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // using merge sort application.
    public static long getInversions_2(long[] arr, int n) {
        return mergrSort(arr, 0, n - 1);
    }

    public static long mergrSort(long[] arr, int left, int right) {
        long inversions = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            inversions += mergrSort(arr, left, mid);
            inversions += mergrSort(arr, mid + 1, right);
            inversions += merge(arr, left, mid, right);
        }

        return inversions;
    }

    // almost same as merge function of merge sort just the first
    // while loop have little modifications.
    public static long merge(long[] arr, int left, int mid, int right) {
        long inversions = 0;
        int leftArrSize = mid - left + 1;
        int rightArrSize = right - mid;

        long[] leftArr = new long[leftArrSize];
        long[] rightArr = new long[rightArrSize];

        for (int i = 0; i < leftArrSize; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < rightArrSize; i++) {
            rightArr[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = left;
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                k++;
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
                k++;
                inversions += leftArrSize - i;
            }
        }

        while (i < leftArrSize) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }

        while (j < rightArrSize) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }

        return inversions;
    }
}
