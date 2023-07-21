/*
 WAP to find an element in an infinite sorted array.
 Infinite array means you cannot use length function.
 */

import java.util.Arrays;
import java.util.Scanner;

public class InfiniteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222};
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter a number to find from the above array");
        int target = sc.nextInt();
        int start = 0;
        int end = 1;
        int ans = search(arr, target, start, end);
        if (ans == -1) {
            //running the loops in chunks to find the target
            //searching first 0 to 1
            //then from 2 to 5 and so on...first the two elements then 4 elements then 8
            while (true) {
                int add = 4;
                start = end + 1;
                end = end + add;
                add *= 2;
                int newAns = search(arr, target, start, end);
                if (newAns == -1) {
                    ;
                } else {
                    System.out.println(newAns);
                    break;
                }
            }
        }
        else
            System.out.println(ans);
    }
    static int search(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            else if(target>arr[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
