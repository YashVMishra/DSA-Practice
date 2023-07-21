import java.util.Arrays;

public class Cyclic_Sort {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 5 };
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclic(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // if the number are from 1 to N otherwise if its from 0 to N then (correct
            // =arr[i])
            int correct = arr[i] - 1;
            if (correct < arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int i, int correct) {
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
}
