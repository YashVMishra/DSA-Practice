//https://practice.geeksforgeeks.org/problems/maximize-arrii-of-an-array0026/1?page=1&company[]=SAP%20Labs&sortBy=submissions

import java.util.Arrays;

public class Maximize_sum_of_an_Array {
    public static void main(String[] args) {
        int Arr[] = { 5, 3, 2, 4, 1 };
        System.out.println(Maximize(Arr, Arr.length));
    }

    // keep in mind the datatypes.
    public static int Maximize(int arr[], int n) {
        // Complete the function
        Arrays.sort(arr);
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            ans += (long) (arr[i]) * (long) (i);
            ans = ans % 1000000007;
        }

        return (int) (ans);
    }
}
