//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?page=1&company[]=SAP%20Labs&sortBy=submissions

import java.util.Arrays;

public class Sort_an_array_of_0_1_2 {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0 };
        sort012(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort012(int a[], int n) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // counting the number of 0,1,2.
        for (int i : a) {
            if (i == 0) {
                count0++;
            } else if (i == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            a[i] = 0;
        }

        for (int i = count0; i < count0 + count1; i++) {
            a[i] = 1;
        }

        for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
            a[i] = 2;
        }
    }
}