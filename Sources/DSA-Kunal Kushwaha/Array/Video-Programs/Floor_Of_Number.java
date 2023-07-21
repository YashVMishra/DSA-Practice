/*
 WAP to find the floor of a number.
 Floor of a number is the greatest number in a given array
 which is less than or equal to the target number.
 */

import java.util.Scanner;
public class Floor_Of_Number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr={23, 45, 67, 89, 96, 195};
        int ans=floor(arr,90);
        System.out.println(arr[ans]);
    }
    static int floor(int[]arr, int target){
        if(arr.length==0)
            return -1;
        if(target<arr[0])
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
        //element at the end will be the floor of the target number
        return end;
    }
}
