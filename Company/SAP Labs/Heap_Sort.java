// https://practice.geeksforgeeks.org/problems/heap-sort/1?page=2&company[]=SAP%20Labs&sortBy=submissions

// for refernce see the video
// https://www.youtube.com/watch?v=UVW0NfG_YWA&t=8s

// for code implementation see the articel
// https://www.geeksforgeeks.org/heap-sort/
// in the article the code is based on taking the 0th index as first element 
// and in the video its taken as 1st index, so adjust accordingly.

import java.util.Arrays;

class Solution {
    // Function to build a Heap from array.
    void buildHeap(int arr[], int N) {
        // Your code here

        // we have written n/2 - 1 as we are taking the first element from index 0
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }
    }

    // Heapify function to maintain heap property.
    void heapify(int arr[], int N, int i) {

        // adding one to both l and r as first element starts from 0.
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int N) {
        // code here
        buildHeap(arr, N);

        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, i, 0);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

public class Heap_Sort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        Solution ob = new Solution();
        ob.heapSort(arr, arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
