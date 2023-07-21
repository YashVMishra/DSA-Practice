//https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/

public class Palindrome_Array {
    public static void main(String[] args) {
        System.out.println(mergeOp(new int[] { 11, 14, 15, 99 }));
    }

    public static int mergeOp(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        while (start <= end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
            }

            else if (arr[start] > arr[end]) {
                arr[end - 1] += arr[end];
                end--;
                count++;
            }

            else {
                arr[start + 1] += arr[start];
                start++;
                count++;
            }
        }

        return count;
    }
}
