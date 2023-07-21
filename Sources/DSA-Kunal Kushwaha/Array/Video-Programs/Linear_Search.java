/*
 WAP to search for an element using Linear Search and prints its index.
 */

import java.util.Arrays;
import java.util.Scanner;
public class Linear_Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
        int [] arr=new int[size];
        System.out.println("Enter the array elements");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the element you want to search");
        int target=sc.nextInt();
        System.out.println(search(arr,target));
    }
    static int search(int arr[], int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target)
                return i;
        }

        //element not found
        return -1;
    }
}
