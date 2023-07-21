/*
 WAP to do the binary search for both ascending and descending order arrays.
 */

import java.util.Arrays;
import java.util.Scanner;
public class Order_Agnostic_Binary_Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the array elements in a sorted manner");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the element you want to search");
        int target=sc.nextInt();
        System.out.println(search(arr,target));
    }
    static int search(int[]arr, int target){
        if(arr.length==0)
            return -1;
        int start=0;
        int end=arr.length-1;

        //checking for ascending or descending
        boolean isAsc = arr[0]< arr[arr.length-1];

        while(start<=end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;

            //if ascending order array
            if (isAsc) {
             if (arr[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            //if descending order array
            else {
                if (arr[mid] > target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        //element not found
        return -1;
    }
}
