/*
 WAP to find the ceiling of a number.
 Ceiling of a number is the smallest number in a given array
 which is greater than or equal to the target number.
 */

import java.util.Scanner;
public class Ceiling_Of_Number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={1,2,4,6,56,78,89};
        int ans=ceiling(arr,55);
        System.out.println(arr[ans]);
    }
    static int ceiling(int[]arr, int target){
        if(arr.length==0)
            return -1;
        if(target>arr[arr.length-1])
            return -1;
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start + (end-start)/2;

            if(arr[mid]==target)
                return mid;
            else if(arr[mid] < target)
                start=mid+1;
            else
                end=mid-1;
        }

        //if the while condition is violated then the
        //element at the start will be the ceiling of the target number
        return start;
    }
}
