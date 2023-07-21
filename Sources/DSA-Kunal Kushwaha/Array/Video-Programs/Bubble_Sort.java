/*
  WAP to do bubble sort.
 */

import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr={4,6,1,7,3,8,5,9};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void bubble(int[] arr){
        boolean swap; // use when the array is sorted before all the loops are over.
        for(int i=0;i<arr.length;i++){
            swap=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
}
