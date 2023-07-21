//https://practice.geeksforgeeks.org/problems/second-largest3735/1?page=1&company[]=SAP%20Labs&sortBy=submissions

public class Second_Largest {
    public static void main(String[] args) {
        int Arr[] = { 10, 5, 10 };
        System.out.println(print2largest(Arr, Arr.length));
    }

    public static int print2largest(int arr[], int n) {
        // code here

        int firstLargest = Integer.MIN_VALUE;
        for (int i : arr) {
            firstLargest = Math.max(firstLargest, i);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == firstLargest) {
                arr[i] = Integer.MIN_VALUE;
            }
        }

        int secondLargest = Integer.MIN_VALUE;
        for (int i : arr) {
            secondLargest = Math.max(secondLargest, i);
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}
