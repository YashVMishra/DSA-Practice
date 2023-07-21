//https://www.geeksforgeeks.org/radix-sort/

import java.util.Arrays;

public class Radix_Sort {
    public static void main(String[] args) {
        radix_sort(new int[] { 302, 50, 76, 54, 98, 654 });
    }

    public static void radix_sort(int[] arr) {

        int max = Integer.MIN_VALUE;

        // finding max value
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        // running loop till the digits of the max number.
        int exp = 1;
        while (exp <= max) {
            count_Sort(arr, exp);
            exp = exp * 10;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void count_Sort(int[] arr, int exp) {
        // creating an array of size 10
        int[] count = new int[10];

        // finding the count of every element of the original array.
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // modifying the count array that is to count[i] is the sum of the
        // count[i]+count[i-1]
        // this way we can evaluate the correct position at which the
        // element of the original array will be.
        for (int i = 0; i < count.length - 1; i++) {
            count[i + 1] += count[i];
        }

        // creating the new ans array so that we can store the sorted element in correct
        // order.
        int[] ans = new int[arr.length];

        // now we traverse the original array from the behind and we will
        // find the element of the original array and decrease its value in the count
        // by one and place that element in the ans array at the index of the decreased
        // count.
        for (int i = arr.length - 1; i >= 0; i--) {

            // finding the last digit if the element and arranging acc to it.
            int index = (arr[i] / exp) % 10;

            count[index]--;

            // here we have written arr[i] as we need the number at that index not the last
            // digit.
            ans[count[index]] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }

    }
}
